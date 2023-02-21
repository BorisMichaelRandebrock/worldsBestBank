package com.randebrock.worldsBestBank.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.dto.DepositDTO;
import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.controller.dto.WithdrawDTO;
import com.randebrock.worldsBestBank.model.*;
import com.randebrock.worldsBestBank.repository.AccountHolderRepository;
import com.randebrock.worldsBestBank.repository.AdminRepository;
import com.randebrock.worldsBestBank.repository.CheckingRepository;
import com.randebrock.worldsBestBank.repository.TransferRepository;
import com.randebrock.worldsBestBank.service.interfaces.AccountHolderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/*@SpringBootTest
@AutoConfigureMockMvc*/
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountHolderControllerImplTest {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private AccountHolderService accountHolderService;
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private AccountHolder accountHolder1, accountHolder2;
    private Address home, postal;
    private Checking checking1, checking2;
    private Transfer transfer;

    Date birthday = new Date(78, 1, 13);
    Date babyBirthday = new Date(109, 1,13);
    @BeforeEach
    void setUp() {
        home = new Address("Elmstreet", 13, "5","ElmsCity", 123, "ElmsLand");
        postal = new Address("Sesamestreet", 213, "9","ElmsCity", 223, "ElmsLand");


        accountHolder1 = new AccountHolder("BooUser","boo", "123", babyBirthday,home, postal );
        accountHolder2 = new AccountHolder("NathaBoo", "natha", "123", birthday,home);
        accountHolderRepository.saveAll(List.of(accountHolder1, accountHolder2));

        checking1 = new Checking(accountHolder1,null,  "123");
        checking2 = new Checking(accountHolder2,null, "123");
        checking1.setBalance(new Money(new BigDecimal(1000)));

        checkingRepository.saveAll(List.of(checking1, checking2));

        transfer = new Transfer();

        transferRepository.save(transfer);

    }

    @AfterEach
    void tearDown() {
        checking1.setPrimaryOwner(null);
        checking2.setPrimaryOwner(null);
        checkingRepository.deleteAll();
        adminRepository.deleteAll();
        accountHolderRepository.deleteAll();
    }
    @Test
    void moneyTransfer() throws Exception{
        assertEquals("US$ 1000.00", checking1.getBalance().toString());
        assertEquals("US$ 0.00",checking2.getBalance().toString());

        TransferDTO moneyTransfer = new TransferDTO(checking1.getAccountNumber(),checking2.getAccountNumber(), new Money(new BigDecimal(500)).getAmount());

        String body = objectMapper.writeValueAsString(moneyTransfer);

//        accountHolderService.makeTransfer(moneyTransfer);
        MvcResult mvcResult = mockMvc.perform(
                post("/transfer")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Optional<Checking> checking1Optional = checkingRepository.findById(checking1.getAccountNumber());
        Optional<Checking> checking2Optional = checkingRepository.findById(checking2.getAccountNumber());

        assertEquals("US$ 500.00", checking1Optional.get().getBalance().toString());
        assertEquals("US$ 500.00",checking2Optional.get().getBalance().toString());

    }

    @Test
    void addFunds() throws Exception {
        DepositDTO depositDTO = new DepositDTO();
       depositDTO.setAmount(new Money(new BigDecimal(5)));
        String body = objectMapper.writeValueAsString(depositDTO);

        MvcResult mvcResult = mockMvc.perform(
                        patch("/deposit/"+ checking1.getAccountNumber())
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent())
                .andReturn();

        Optional<Checking> optionalChecking = checkingRepository.findById(checking1.getAccountNumber());
        assertEquals("US$ 1005.00", optionalChecking.get().getBalance().toString());
    }

    @Test
    void withdrawFunds() throws Exception {
        WithdrawDTO withdrawDTO = new WithdrawDTO();
        withdrawDTO.setAmount(new Money(new BigDecimal(5)));
        String body = objectMapper.writeValueAsString(withdrawDTO);

        MvcResult mvcResult = mockMvc.perform(
                        patch("/withdraw/"+ checking1.getAccountNumber())
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent())
                .andReturn();

        Optional<Checking> optionalChecking = checkingRepository.findById(checking1.getAccountNumber());
        assertEquals("US$ 995.00", optionalChecking.get().getBalance().toString());
    }

    @Test
    void deleteAccount() throws Exception {

        System.out.println(checking1.getAccountNumber());
        MvcResult mvcResult = mockMvc.perform(delete("/delete/" + checking1.getAccountNumber()))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(checkingRepository.existsById(checking1.getAccountNumber()));
    }
}