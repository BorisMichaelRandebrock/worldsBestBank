package com.randebrock.worldsBestBank.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.dto.CreditCardDTO;
import com.randebrock.worldsBestBank.controller.dto.SavingsDTO;
import com.randebrock.worldsBestBank.controller.dto.StudentCheckingDTO;
import com.randebrock.worldsBestBank.model.*;
import com.randebrock.worldsBestBank.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerImplTest {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;


    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Admin admin1, admin2, admin3;
    private AccountHolder accountHolder1, accountHolder2, accountHolder3;
    private Address home, postal;

    private Checking checking1, checking2;

    private CreditCard creditCard1, creditCard2, creditCard3;
    private Savings savings1, savings2;
    private StudentChecking studentChecking1, studentChecking2;

        Date birthday = new Date(13/02/1978);
    @BeforeEach
    void setUp() {
        admin1 = new Admin("Boo Bo", "Boo Boobo", "123");
        admin2 = new Admin("Asdasd", "Asdasdasd Asdasd", "123");

        adminRepository.saveAll(List.of(admin1, admin2));

        home = new Address("Elmstreet", 13, "5","ElmsCity", 123, "ElmsLand");
        postal = new Address("Sesamestreet", 213, "9","ElmsCity", 223, "ElmsLand");


        accountHolder1 = new AccountHolder("BooUser","boo", "123", birthday,home, postal );
        accountHolder2 = new AccountHolder("NathaBoo", "natha", "123", birthday,home);
        accountHolder3 = new AccountHolder("Iñigo Montoya", "nathan2", "123", birthday,home);

        accountHolderRepository.saveAll(List.of(accountHolder1, accountHolder2, accountHolder3));

        checking1 = new Checking(accountHolder1,null,  "123");
        checking2 = new Checking(accountHolder2,null, "123");

        checkingRepository.saveAll(List.of(checking1, checking2));

        creditCard1 = new CreditCard(accountHolder1,accountHolder2);
        creditCard2 = new CreditCard(accountHolder2, null);

        creditCardRepository.saveAll(List.of(creditCard1,creditCard2));

        savings1 = new Savings(accountHolder1,null,  "123");
        savings2 = new Savings(accountHolder2,null,  "123");

        savingsRepository.saveAll(List.of(savings1,savings2));

        studentChecking1 = new StudentChecking(accountHolder3, null, "123");
        studentChecking2 = new StudentChecking(accountHolder1, null, "123");

        studentCheckingRepository.saveAll(List.of(studentChecking1, studentChecking2));


    }


    @AfterEach
    void tearDown() {
        studentChecking1.setPrimaryOwner(null);
        studentChecking2.setPrimaryOwner(null);
        studentCheckingRepository.deleteAll();
        savings1.setPrimaryOwner(null);
        savings2.setPrimaryOwner(null);
        savingsRepository.deleteAll();
        creditCard1.setPrimaryOwner(null);
        creditCard1.setOptionalSecondaryOwner(null);
        creditCard2.setPrimaryOwner(null);
            creditCardRepository.deleteAll();
            checking1.setPrimaryOwner(null);
            checking2.setPrimaryOwner(null);
            checkingRepository.deleteAll();
            adminRepository.deleteAll();
            accountHolderRepository.deleteAll();
    }



    @Test
    void addNewAdmin_ValidNewAdmin_FindNewAdminInDB() throws Exception {
       Admin admin3 = new Admin("AsdasdBoo", "Asdasdasd Asdasd", "123");
        String body = objectMapper.writeValueAsString(admin3);

        adminRepository.save(admin3);
        MvcResult mvcResult = mockMvc.perform(
                        post("/admin/admin")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("AsdasdBoo"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Asdasdasd Asdasd"));
        assertTrue(adminRepository.existsById(admin3.getId()));
        assertEquals("AsdasdBoo",admin3.getName());
    }

    @Test
    void addNewAccountHolder_AddingValidNewAccountHolder_FindsNewAccountHolder() throws Exception {
        AccountHolder accountHolder3 = new AccountHolder("YetANathaBoo", "nathan", "123", birthday,home);

        String body = objectMapper.writeValueAsString(accountHolder3);

        MvcResult mvcResult = mockMvc.perform(
                        post("/admin/account-holder")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("YetANathaBoo"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("nathan"));
    }

    @Test
    void getAllCheckingAccounts_NoParam_AllCheckingAccounts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/accounts/checkings"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("BooUser"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("NathaBoo"));
    }

    @Test
    void createNewCheckingAccount_PostingValues_ReturnsStatusCreated() throws Exception {
        CheckingDTO checkingDTO = new CheckingDTO(accountHolder3, null, "123");

        String body = objectMapper.writeValueAsString(checkingDTO);

        MvcResult mvcResult = mockMvc.perform(
                        post("/accounts/checkings")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println("------------------------------------");
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Montoya"));
    }

    @Test
    void createNewCreditCardAccount_PostingValues_ReturnsStatusCreated() throws Exception {
        CreditCardDTO creditCardDTO = new CreditCardDTO(accountHolder3,null);

        String body = objectMapper.writeValueAsString(creditCardDTO);

        MvcResult mvcResult = mockMvc.perform(
                        post("/accounts/credit-cards")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println("------------------------------------");
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Montoya"));
    }

    @Test
    void getAllCreditCardAccounts_NoParams_FindsAllAccounts() throws Exception {
        System.err.println("esto es una credit card" + creditCard1.toString());
        MvcResult mvcResult = mockMvc.perform(get("/accounts/credit-cards"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        System.out.println("...............--------------------");

        assertTrue(mvcResult.getResponse().getContentAsString().contains("BooUser"));
    }

    @Test
    void createNewSavingsAccount() throws Exception {
        SavingsDTO savingsDTO = new SavingsDTO(accountHolder3, null, "123");

        String body = objectMapper.writeValueAsString(savingsDTO);

        MvcResult mvcResult = mockMvc.perform(
                        post("/accounts/savings")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Montoya"));
    }

    @Test
    void createNewStudentsCheckingAccount() throws Exception {
        StudentCheckingDTO studentCheckingDTO = new StudentCheckingDTO(accountHolder3, null, "123");

        String body = objectMapper.writeValueAsString(studentCheckingDTO);

        MvcResult mvcResult = mockMvc.perform(
                        post("/accounts/student-checkings")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Montoya"));
    }

    @Test
    void getAllSavingsAccounts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/accounts/savings"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        System.out.println("...............--------------------");

        assertTrue(mvcResult.getResponse().getContentAsString().contains("BooUser"));
    }

    @Test
    void getAllStudentCheckingAccounts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/accounts/student-checkings"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        System.out.println(("-----------------------------------------"));
        System.out.println(("-----------------------------------------"));
        System.out.println(("-----------------------------------------"));
        System.out.println(("-----------------------------------------"));

        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("BooUser"));
    }
}