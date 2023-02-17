package com.randebrock.worldsBestBank.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.randebrock.worldsBestBank.repository.AccountHolderRepository;
import com.randebrock.worldsBestBank.repository.AdminRepository;
import com.randebrock.worldsBestBank.repository.CheckingRepository;
import com.randebrock.worldsBestBank.repository.TransferRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;
import static org.springframework.web.servlet.function.ServerResponse.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransferTest {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
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
    void transferMoney() throws Exception {
        System.out.println(checking1.getBalance() + " receiving balance: " + checking2.getBalance());
//       Transfer moneyTransfer =  new Transfer(accountHolder1,accountHolder2, new Money(new BigDecimal(1000)).getAmount());
       /* Optional<Transfer> moneyTransfer = transfer.transferMoney(accountHolder1, accountHolder2, new Money(new BigDecimal(1000)).getAmount());
        String body = objectMapper.writeValueAsString(moneyTransfer);*/
        System.out.println("************************************");
        System.out.println(checking1.getBalance() + " receiving balance: " + checking2.getBalance());

//        String body =
      /*  MvcResult mvcResult = mockMvc.perform(
                post("/transfer")
                        .contentType(body)
                        .contentType(MediaType.APPLICATION_JSON)

        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
*/
//        transfer.transferMoney(accountHolder1,accountHolder2, new Money(new BigDecimal(1000)).getAmount());
//        System.out.println(checking1.getBalance() + " receiving balance: " + checking2.getBalance());
    }
}