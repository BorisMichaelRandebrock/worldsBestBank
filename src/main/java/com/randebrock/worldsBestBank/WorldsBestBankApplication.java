package com.randebrock.worldsBestBank;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.dto.DepositDTO;
import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.controller.dto.WithdrawDTO;
import com.randebrock.worldsBestBank.model.*;
import com.randebrock.worldsBestBank.repository.*;
import com.randebrock.worldsBestBank.service.interfaces.AccountHolderService;
import com.randebrock.worldsBestBank.service.interfaces.AdminService;
import com.randebrock.worldsBestBank.util.Welcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
//public class WorldsBestBankApplication {
	public class WorldsBestBankApplication implements CommandLineRunner { /*---- uncomment this and line 51 @Override when finished testing*/

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	AdminService adminService;
	@Autowired
	AccountHolderRepository accountHolderRepository;

	@Autowired
	AccountHolderService accountHolderService;
	@Autowired
	CheckingRepository checkingRepository;

	@Autowired
	CreditCardRepository creditCardRepository;
	@Autowired
	SavingsRepository savingsRepository;
	@Autowired
	StudentCheckingRepository studentCheckingRepository;


	public static void main(String[] args) {
		SpringApplication.run(WorldsBestBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Welcome.start();
		Scanner scanner = new Scanner(System.in);
		menu();
		System.out.println("Introduce your command:");
		boolean runProgram = true;
		while (runProgram) {
			String command = scanner.nextLine();
			switch (command) {
				case "1":

					System.out.println("Enter the name of the new admin:");
					String name = scanner.nextLine();
					System.out.println("Enter username:");
					String username = scanner.nextLine();
					System.out.println("Enter password:");
					String password = scanner.nextLine();

					Admin newAdmin = new Admin(name, username, password);
					adminRepository.save(newAdmin);

						System.out.println("New workforce created.");

					break;
				/*case "2":
					System.out.println("Enter the new Street Name:");
					String streetName = scanner.nextLine();

					System.out.println("Enter house number:");
					Integer houseNumber = Integer.valueOf(scanner.nextLine());
					System.out.println("If needed enter the number of the appartment, else enter null:");
					String appartmentNumber = scanner.nextLine();
					System.out.println("Enter city:");
					String city = scanner.nextLine();
					System.out.println("Enter postal coder:");
					Integer postCode = Integer.valueOf(scanner.nextLine());
					System.out.println("Enter country:");
					String country = scanner.nextLine();




					System.out.println("New workforce created.");

					break;*/
				case "3":
					System.out.println("Enter the name of the new Account Holder:");
					String customerName = scanner.nextLine();
					System.out.println("Enter username:");
					String customerUsername = scanner.nextLine();
					System.out.println("Enter password:");
					String customerPassword = scanner.nextLine();
					System.out.println("Enter the date of birth (counting the years from 1900 and only put last 2 digits.... 🤪:");
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
					Date dateOfBirth = formatter.parse(scanner.nextLine());
					System.out.println("Enter the name of the street:");
					String streetName = scanner.nextLine();
					System.out.println("Enter house number:");
					Integer houseNumber = Integer.valueOf(scanner.nextLine());
					System.out.println("If needed enter the number of the appartment, else enter null:");
					String appartmentNumber = scanner.nextLine();
					System.out.println("Enter city:");
					String city = scanner.nextLine();
					System.out.println("Enter postal coder:");
					Integer postCode = Integer.valueOf(scanner.nextLine());
					System.out.println("Enter country:");
					String country = scanner.nextLine();

					Address newAddress = new Address(streetName, houseNumber, appartmentNumber, city, postCode, country);

					AccountHolder newAccountHolder = new AccountHolder(customerName, customerUsername,customerPassword, dateOfBirth, newAddress);

					accountHolderRepository.save(newAccountHolder);
					break;

			case "4":
					System.out.println("Enter Account Holder id:");
					Long accountHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> accountHolderOptional = accountHolderRepository.findById(accountHolderId);
					if(accountHolderOptional.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secondary account Holder or, if not existing, enter null:");
					Long secondaryAccountHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> accountHolderOptional2 = accountHolderRepository.findById(secondaryAccountHolderId);
					if(accountHolderOptional2.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secret key:");
					String secretKey = scanner.nextLine();

					Checking checkingAccount = new Checking(accountHolderOptional.get(), accountHolderOptional2.get(), secretKey);
					checkingRepository.save(checkingAccount);
					System.out.println("New Checking account created.");
					break;

				case "5":
					System.out.println("Enter Account Holder id:");
					Long creditCardHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> creditCardHolderIdOptional = accountHolderRepository.findById(creditCardHolderId);
					if(creditCardHolderIdOptional.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secondary account Holder or, if not existing, enter null:");
					Long secondaryCreditCardAccountHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> creditCardAccountHolderOptional2 = accountHolderRepository.findById(secondaryCreditCardAccountHolderId);
					if(creditCardAccountHolderOptional2.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secret key:");
					String creditCardSecretKey = scanner.nextLine();

					CreditCard creditCardAccount = new CreditCard(creditCardHolderIdOptional.get(),creditCardAccountHolderOptional2.get());
					creditCardRepository.save(creditCardAccount);

					System.out.println("Dear "+ creditCardHolderIdOptional.get().getName() +" your Credit Card account created.");
					break;

				case "6":
					System.out.println("Enter Account Holder id:");
					Long savingsHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> savingsHolderIdOptional = accountHolderRepository.findById(savingsHolderId);
					if(savingsHolderIdOptional.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secondary account Holder or, if not existing, enter null:");
					Long secondarySavingsAccountHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> savingsAccountHolderOptional2 = accountHolderRepository.findById(secondarySavingsAccountHolderId);
					if(savingsAccountHolderOptional2.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secret key:");
					String savingsSecretKey = scanner.nextLine();

					Savings savingsAccount = new Savings(savingsHolderIdOptional.get(), savingsAccountHolderOptional2.get(), savingsSecretKey);

					savingsRepository.save(savingsAccount);
					System.out.println("Dear "+ savingsHolderIdOptional.get().getName() +" your Credit Card account created.");
					break;

				case "7":
					System.out.println("Enter Account Holder id:");
					Long studentCheckingHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> studentCheckingHolderIdOptional = accountHolderRepository.findById(studentCheckingHolderId);
					if(studentCheckingHolderIdOptional.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secondary account Holder or, if not existing, enter null:");
					Long secondaryStudentCheckingAccountHolderId = Long.valueOf(scanner.nextLine());
					Optional<AccountHolder> studentCheckingAccountHolderOptional2 = accountHolderRepository.findById(secondaryStudentCheckingAccountHolderId);
					if(studentCheckingAccountHolderOptional2.isEmpty()) throw new IllegalArgumentException("No account holder found");
					System.out.println("Enter a secret key:");
					String studentCheckingSecretKey = scanner.nextLine();

					StudentChecking studentCheckingAccount = new StudentChecking(studentCheckingHolderIdOptional.get(), studentCheckingAccountHolderOptional2.get(), studentCheckingSecretKey);

					studentCheckingRepository.save(studentCheckingAccount);

					System.out.println("Dear " + studentCheckingHolderIdOptional.get().getName() + " your student checking account has been created :)");
					break;

				case "8":
					System.out.println("Enter the account number of the checking account you want to find:");
					Long accountNumber = Long.valueOf(scanner.nextLine());
					Optional<Checking> optionalChecking =  checkingRepository.findById(accountNumber);
					if(optionalChecking.isEmpty()) throw new IllegalArgumentException("This account does not exist");

					System.out.println("Checking account found: " + optionalChecking.get().getBalance());
					break;

				case "9":
					List<Checking> allCheckingAccounts = checkingRepository.findAll();
					System.out.println("All checking accounts:");
					allCheckingAccounts.forEach(System.out::println);

					break;
				case "10":
					System.out.println("Enter the account number of the credit card account you want to find:");
					Long creditCardAccountNumber = Long.valueOf(scanner.nextLine());
					Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(creditCardAccountNumber);
					if(optionalCreditCard.isEmpty()) throw new IllegalArgumentException("This account does not exist");

					System.out.println("Credit Card account found:" + optionalCreditCard.get().getBalance() + optionalCreditCard.get().getPrimaryOwner());
					System.out.println(optionalCreditCard.get().getCreationDate() + "" + optionalCreditCard.get().getCreditLimit());

					break;
				case "11":
					List<CreditCard> allCreditCardAccounts = creditCardRepository.findAll();
					System.out.println("All Credit Card accounts:");
					allCreditCardAccounts.forEach(System.out::println);

					break;
				case "12":
					System.out.println("Enter the account number of the savings account you want to find:");
					Long savingsAccountNumber = Long.valueOf(scanner.nextLine());
					Optional<Savings> optionalSavings = savingsRepository.findById(savingsAccountNumber);
					if (optionalSavings.isEmpty()) throw new IllegalArgumentException("No such thing is lurking around here");

					System.out.println("Savings account found, the balance is : " + optionalSavings.get().getBalance());

					break;
				case "13":
					List<Savings> allSavingsAccounts = savingsRepository.findAll();
					System.out.println("All Savings accounts:");
					allSavingsAccounts.forEach(System.out::println);

					break;
				case "14":
					System.out.println("Enter the account number of the student checking account you want to find:");
					Long studentCheckingAccountNumber = Long.valueOf(scanner.nextLine());
					Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(studentCheckingAccountNumber);
					if(optionalStudentChecking.isEmpty()) throw new IllegalArgumentException("try again later... this account does not seem to exist..");

					System.out.println("Student Checking account found, the current balance is :" + optionalStudentChecking.get().getBalance());

					break;
				case "15":
					List<StudentChecking> allStudentCheckingAccounts = studentCheckingRepository.findAll();
					System.out.println("All Student Checking accounts:");
					allStudentCheckingAccounts.forEach(System.out::println);

					break;
				case "16":
					System.out.println("Enter the id of the admin you want to find:");
					Long adminId = Long.valueOf(scanner.nextLine());

					Admin admin = adminRepository.findById(adminId).get();
					System.out.println("Admin found:");
					System.out.println(admin.getUsername() +" " + admin.toString());

					break;
				case "17":
					List<Admin> allAdmins = adminRepository.findAll();
					System.out.println("All admins:");
					allAdmins.forEach(System.out::println);

					break;

				case "18":
					System.out.println("Enter id of the admin you want to edit:");
					Long adminIdToEdit = Long.valueOf(scanner.nextLine());

					System.out.println("Enter the new name for the admin:");
					String adminName = scanner.nextLine();
					System.out.println("Enter the new username for the admin:");
					String adminUsername = scanner.nextLine();
					System.out.println("Enter the new password for the admin:");
					String adminPassword = scanner.nextLine();

					Admin adminToEdit = adminRepository.findById(adminIdToEdit).get();
					adminToEdit.setName(adminName);
					adminToEdit.setUsername(adminUsername);
					adminToEdit.setPassword(adminPassword);

					adminRepository.save(adminToEdit);

					break;
/*
				case "19":
					System.out.println("Enter the account number you want to edit:");
					Long accountNumberEditable = Long.valueOf(scanner.nextLine());

					System.out.println("Enter the id of the new primary Owner for the account:");
					Long newPrimaryOwnerId = Long.valueOf(scanner.nextLine());
					Optional<Checking> optionalCheckingToBeEdited = checkingRepository.findById(accountNumberEditable);

					optionalCheckingToBeEdited.get().setPrimaryOwner(newPrimaryOwnerId.);
					Checking checkingAccountToEdit = checkingRepository.findById(accountNumberEditable.);
					checkingAccountToEdit.setPrimaryOwner(newPrimaryOwnerId);

					accountHolderRepository.save(checkingAccountToEdit);
					checkingAccountToEdit.setBalance(accountBalance);
					break;
 */
				case "20":
					System.out.println("Enter the account number you want to add funds to:");
					Long accountNumberToAddFunds = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the amount you want to add:");
					Double amount = Double.valueOf(scanner.nextLine());

					accountHolderService.addFunds(accountNumberToAddFunds, new DepositDTO());

					break;
				case "21":
					System.out.println("Enter the account id you want to withdraw money from:");
					Long accountIdToWithdrawFunds = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the amount you want to withdraw:");
					BigDecimal withdrawAmount = BigDecimal.valueOf(Double.valueOf(scanner.nextLine()));

					accountHolderService.withdrawFunds(accountIdToWithdrawFunds, new WithdrawDTO());

					break;
				case "22":
					System.out.println("Enter the account id of the account you want to withdraw money from:");
					Long accountIdToTransferFrom = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the account id of the account you want to transfer money to:");
					Long accountIdToTransferTo = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the amount you want to transfer:");
					BigDecimal transferAmount = BigDecimal.valueOf(Double.valueOf(scanner.nextLine()));

					accountHolderService.makeTransfer(new TransferDTO(accountIdToTransferFrom, accountIdToTransferTo, transferAmount));

					break;
				case "23":
					System.out.println("Enter the id of the admin you want to delete:");
					Long adminIdToDelete = Long.valueOf(scanner.nextLine());

					adminRepository.deleteById(adminIdToDelete);

					break;

				case "24":
					System.out.println("Enter the id of the account holder you want to delete:");
					Long accountHolderIdToDelete = Long.valueOf(scanner.nextLine());

					accountHolderRepository.deleteById(accountHolderIdToDelete);

					break;
				case "25":
					runProgram = false;
					break;
				default:
					System.out.println("Command not found. Try again.");
			}
		}
		scanner.close();
	}


	public static void menu(){
		System.out.println(
						"1. Add new Admin\n" +
						"2. Add new Address\n" +
						"3. Add new Account Holder\n" +
						"4. Add new Checking account\n" +
						"5. Add new Credit Card account\n" +
						"6. Add new Savings account\n" +
						"7. Add new Student Checking account\n" +
						"8. Find Checking account\n" +
						"9. Find all Checking accounts\n" +
						"10. Find Credit Card account\n" +
						"11. Find all Credit Card accounts\n" +
						"12. Find Savings account\n" +
						"13. Find all Savings account\n" +
						"14. Find new Student Checking account\n" +
						"15. Find all Student Checking account\n" +
						"16. Find admin\n" +
						"17. Find all admin\n" +
						"18. Edit admin\n" +
						"19. Edit account\n" +
						"20. Add Funds to account\n" +
						"21. Withdraw money\n" +
						"22. Transfer money\n" +
						"23. Delete admin\n" +
						"24. Delete account\n" +
						"25. Exit");
	}

}

