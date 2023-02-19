package com.randebrock.worldsBestBank;

import com.randebrock.worldsBestBank.model.Transfer;
import com.randebrock.worldsBestBank.util.Welcome;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorldsBestBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldsBestBankApplication.class, args);
//		Welcome.start();
	}

}
