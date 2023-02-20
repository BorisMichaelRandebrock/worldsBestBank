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
public class WorldsBestBankApplication implements CommandLineRunner {

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

			/*	case "4":
					System.out.println("Enter Account Holder id:");
					Long accountHolder = Long.valueOf(scanner.nextLine());
					System.out.println("Enter a secondary account Holder or, if not existing, enter null:");
					Long secondaryAccountHolder = Long.valueOf(scanner.nextLine());
					System.out.println("Enter a secret key:");
					String secretKey = scanner.nextLine();


					Checking checkingAccount = new Checking(accountHolder, secondaryAccountHolder, secretKey);


					adminService.save(checkingAccount);

					System.out.println("New Checking account created.");

					break;*/
/*
				case "5":
					System.out.println("Enter Account Holder id:");
					Long creditCardHolderId = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the credit card account number:");
					Long creditCardAccountNumber = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the credit card account type:");
					String creditCardType = scanner.nextLine();
					System.out.println("Enter the credit card account balance:");
					Double creditCardBalance = Double.valueOf(scanner.nextLine());
					System.out.println("Enter the credit card account credit Limit:");
					Double creditLimit = Double.valueOf(scanner.nextLine());

					AccountHolder creditCardHolder = getUsers().stream().filter(a -> a.getId().equals(creditCardHolderId)).findFirst().get();

					CreditCard creditCardAccount = createNewCreditCardAccount(new CreditCardDTO(creditCardAccountNumber, creditCardType, creditCardBalance, creditLimit));
					creditCardHolder.addCreditCardAccount(creditCardAccount);

					creditCardRepository.save(creditCardHolder);

					System.out.println("New Credit Card account created.");

					break;
				case "6":
					System.out.println("Enter Account Holder id:");
					Long savingsHolderId = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the savings account number:");
					Long savingsAccountNumber = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the savings account type:");
					String savingsType = scanner.nextLine();
					System.out.println("Enter the savings account balance:");
					Double savingsBalance = Double.valueOf(scanner.nextLine());
					System.out.println("Enter the savings account interest rate:");
					Double interestRate = Double.valueOf(scanner.nextLine());

					AccountHolder savingsHolder = getUsers().stream().filter(a -> a.getId().equals(savingsHolderId)).findFirst().get();

					Savings savingsAccount = createNewSavingsAccount(new SavingsDTO(savingsAccountNumber, savingsType, savingsBalance, interestRate));
					savingsHolder.addSavingsAccount(savingsAccount);

					savingsRepository.save(savingsHolder);

					System.out.println("New Savings account created.");

					break;
				case "7":
					System.out.println("Enter Account Holder id:");
					Long studentCheckingHolderId = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the student checking account number:");
					Long studentCheckingAccountNumber = Long.valueOf(scanner.nextLine());
					System.out.println("Enter the student checking account type:");
					String studentCheckingType = scanner.nextLine();
					System.out.println("Enter the student checking account balance:");
					Double studentCheckingBalance = Double.valueOf(scanner.nextLine());
					System.out.println("Enter the student checking account interest rate:");
					Double studentCheckingInterestRate = Double.valueOf(scanner.nextLine());
					System.out.println("Enter the student checking account required monthly payments:");
					Double requiredMonthlyPayments = Double.valueOf(scanner.nextLine());

					AccountHolder studentCheckingHolder = getUsers().stream().filter(a -> a.getId().equals(studentCheckingHolderId)).findFirst().get();

					StudentChecking studentCheckingAccount = createNewStudentsCheckingAccount(new StudentCheckingDTO(studentCheckingAccountNumber, studentCheckingType, studentCheckingBalance, studentCheckingInterestRate, requiredMonthlyPayments));
					studentCheckingHolder.addStudentCheckingAccount(studentCheckingAccount);

					studentCheckingRepository.save(studentCheckingHolder);

					System.out.println("New Student Checking account created.");

					break;
				case "8":
					System.out.println("Enter the account number of the checking account you want to find:");
					Long accountNumber = Long.valueOf(scanner.nextLine());

					Checking checkingAccount = findByAccountNumber(accountNumber);
					System.out.println("Checking account found:");
					System.out.println(checkingAccount.toString());

					break;
				case "9":
					List<Checking> allCheckingAccounts = getAllCheckingAccounts();
					System.out.println("All checking accounts:");
					allCheckingAccounts.forEach(System.out::println);

					break;
				case "10":
					System.out.println("Enter the account number of the credit card account you want to find:");
					Long creditCardAccountNumber = Long.valueOf(scanner.nextLine());

					CreditCard creditCardAccount = findCreditCardByAccountNumber(creditCardAccountNumber);
					System.out.println("Credit Card account found:");
					System.out.println(creditCardAccount.toString());

					break;
				case "11":
					List<CreditCard> allCreditCardAccounts = getAllCreditCardAccounts();
					System.out.println("All Credit Card accounts:");
					allCreditCardAccounts.forEach(System.out::println);

					break;
				case "12":
					System.out.println("Enter the account number of the savings account you want to find:");
					Long savingsAccountNumber = Long.valueOf(scanner.nextLine());

					Savings savingsAccount = findSavingsByAccountNumber(savingsAccountNumber);
					System.out.println("Savings account found:");
					System.out.println(savingsAccount.toString());

					break;
				case "13":
					List<Savings> allSavingsAccounts = getAllSavingsAccounts();
					System.out.println("All Savings accounts:");
					allSavingsAccounts.forEach(System.out::println);

					break;
				case "14":
					System.out.println("Enter the account number of the student checking account you want to find:");
					Long studentCheckingAccountNumber = Long.valueOf(scanner.nextLine());

					StudentChecking studentCheckingAccount = findStudentCheckingByAccountNumber(studentCheckingAccountNumber);
					System.out.println("Student Checking account found:");
					System.out.println(studentCheckingAccount.toString());

					break;
				case "15":
					List<StudentChecking> allStudentCheckingAccounts = getAllStudentCheckingAccounts();
					System.out.println("All Student Checking accounts:");
					allStudentCheckingAccounts.forEach(System.out::println);

					break;
				case "16":
					System.out.println("Enter the id of the admin you want to find:");
					Long adminId = Long.valueOf(scanner.nextLine());

					Admin admin = adminRepository.findById(adminId).get();
					System.out.println("Admin found:");
					System.out.println(admin.toString());

					break;
				case "17":
					List<Admin> allAdmins = adminRepository.findAll();
					System.out.println("All admins:");
					allAdmins.forEach(System.out::println);

					break;

				case "18":
					System.out.println("Enter id of the admin you want to edit:");
					Long adminId = Long.valueOf(scanner.nextLine());

					System.out.println("Enter the new name for the admin:");
					String adminName = scanner.nextLine();
					System.out.println("Enter the new username for the admin:");
					String adminUsername = scanner.nextLine();
					System.out.println("Enter the new password for the admin:");
					String adminPassword = scanner.nextLine();

					Admin adminToEdit = adminRepository.findById(adminId).get();
					adminToEdit.setName(adminName);
					adminToEdit.setUsername(adminUsername);
					adminToEdit.setPassword(adminPassword);

					adminRepository.save(adminToEdit);

					break;
				case "19":
					System.out.println("Enter the account number you want to edit:");
					Long accountNumber = Long.valueOf(scanner.nextLine());

					System.out.println("Enter the new type for the account:");
					String accountType = scanner.nextLine();
					System.out.println("Enter the new balance for the account:");
					Double accountBalance = Double.valueOf(scanner.nextLine());

					Checking checkingAccountToEdit = findByAccountNumber(accountNumber);
					checkingAccountToEdit.setType(accountType);
					checkingAccountToEdit.setBalance(accountBalance);

					accountHolderRepository.save(checkingAccountToEdit);
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























			/*	case "4":
					System.out.println("Enter the Author:");
					command = scanner.nextLine();
					if(command.length()<4){
						System.out.println("Minimun 4 characters for search by author name");
					}
					List<Author> bookAuthorList = authorRepository.findByNameContainingWithBooks(command);

					if(bookAuthorList.size()==0){
						System.out.println("No matching results");
					} else {
						for(Author author: bookAuthorList){
							for(Book book: author.getAuthorBooks()){
								System.out.println("--------------------------------\n"  + "ISBN: " + book.getIsbn()+" \nTitle: " +book.getTitle()+" \nAuthor: " +book.getAuthor().getName()+" \nCategory: "+book.getCategory()+" \nQuantity available: "+book.getQuantity() + "\n--------------------------------");
							}
						}

					}
					break;
				case "5":
					List<Book> allBooks = bookRepository.findAll();
					if(allBooks.size()==0){
						System.out.println("No matching results");
					} else {
						for(Book book: allBooks){
							System.out.println("--------------------------------\n"  + "ISBN: " + book.getIsbn()+" \nTitle: " +book.getTitle()+" \nAuthor: " +book.getAuthor().getName()+" \nCategory: "+book.getCategory()+" \nQuantity available: "+book.getQuantity() + "\n--------------------------------");
						}
					}
					break;
				case "6":
					System.out.println("Enter usn:");
					String issueUsn = scanner.nextLine();
					System.out.println("Enter name:");
					String issueName = scanner.nextLine();
					System.out.println("Enter book ISBN:");
					String issueIsbn = scanner.nextLine();
					if(!bookRepository.findById(issueIsbn).isPresent()){
						System.out.println("Book not found in the system");
						break;
					}
					if(bookRepository.findById(issueIsbn).get().getQuantity()<=0){
						System.out.println("No copies of this Book available");
						break;
					}
					Optional<Book> optionalBook = bookRepository.findById(issueIsbn);
					Optional<Student> optionalStudent = studentRepository.findById(issueUsn);
					if(optionalStudent.isPresent()){
						optionalBook.get().setQuantity(optionalBook.get().getQuantity()-1);
						bookRepository.save(optionalBook.get());
						Issue newIssue = new Issue(optionalStudent.get(), optionalBook.get());
						issueRepository.save(newIssue);
						optionalStudent.get().setIssuedBooks(List.of(newIssue));
						studentRepository.save(optionalStudent.get());
						System.out.println("Book issued to "+issueName);
						System.out.println("Return date: "+newIssue.getReturnDate());
					} else {
						optionalBook.get().setQuantity(optionalBook.get().getQuantity()-1);
						bookRepository.save(optionalBook.get());
						Student newStudent = new Student(issueUsn, issueName);
						studentRepository.save(newStudent);
						Issue newIssue = new Issue(newStudent, optionalBook.get());
						issueRepository.save(newIssue);
						newStudent.setIssuedBooks(List.of(newIssue));
						studentRepository.save(newStudent);
						System.out.println("Book issued to new student: "+issueName);
						System.out.println("Return date: "+newIssue.getReturnDate());
					}

					break;
				case "7":
					System.out.println("Enter student usn:");
					String studentUsn = scanner.nextLine();
					Optional<Student> studentOptional = studentRepository.findByUsnWithBooks(studentUsn);
					if(!studentOptional.isPresent()){
						System.out.println("Student not found");
					} else {
						for(Issue issue: studentOptional.get().getIssuedBooks()){
							System.out.println("--------------------------------\n"  + "ISBN: " + issue.getIssueBook().getIsbn()+" \nTitle: " +issue.getIssueBook().getTitle()+" \nAuthor: " +issue.getIssueBook().getAuthor().getName()+" \nCategory: "+issue.getIssueBook().getCategory()+" \nQuantity available: "+issue.getIssueBook().getQuantity() + "\n--------------------------------");
						}
					}
					break;
				case "8":
					SpringApplication.run(IronLibraryApplication.class, args).close();
					System.out.println("Goodbye!");
					break;
				default:
					help();
					break;

			*/



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

