package bankaccount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class BankAccountTest {
	
	
	BankAccount bank;
	@BeforeAll
	public static void msg() {
		System.out.println("Test has Started");
	}
	
	@BeforeEach
	public void init() {
		bank=new BankAccount(1000);
	}
	
	@Test
	public void testConstrucor() {
		assertThrows(IllegalArgumentException.class,()->bank=new BankAccount(-1000));
		
	}
	@Test
	public void testDeposit() {
		assertAll(
				()->bank.deposit(500),
				()->assertEquals(1500,bank.getBalance()),
			()->assertThrows(IllegalArgumentException.class,()->bank.deposit(-1000))
				);
	}
	
	@Test
	public void testWithdraw() {
		assertAll(
				()->bank.withdraw(500),
				()->assertEquals(500,bank.getBalance()),
				()->assertThrows(IllegalArgumentException.class,()->bank.withdraw(5000))
				
				);
	}
	
	@Test
	public void testMultipleTransactions() {
		assertAll(
		()->bank.withdraw(100),
		()->assertEquals(900,bank.getBalance()),
		()->bank.withdraw(100),
		()->assertEquals(800,bank.getBalance()),
		()->bank.withdraw(100),
		()->assertEquals(700,bank.getBalance()),
		()->bank.withdraw(100),
		()->assertEquals(600,bank.getBalance())
		
		);
	}
	
	@AfterAll
	public static void msg2() {
		System.out.println("Test has been Ended");
	}
}
