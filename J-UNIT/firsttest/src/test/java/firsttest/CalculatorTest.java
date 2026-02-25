package firsttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	
	
		Calculator cal;
@BeforeAll
 static public void msg() {
	System.out.println("Test Started");
}
	
	@BeforeEach
	public void init() {
		cal=new Calculator();
	}

	
	@Test
	public void addTwoNumbers() {
		
		assertEquals(5,cal.add(2, 3));
	}
	
	@Test
	public void subtractTwoNumbers() {
		assertEquals(5,cal.subtract(10, 5));
	}
	@Test
	public void divideTwoNumbers() {
		assertEquals(2,cal.divide(10, 5));
	}
	
	@Test
	public void testZeroException() {
		assertThrows(IllegalArgumentException.class,()->cal.divide(10,0));
	}
	
	@AfterAll
	static public void end() {
		System.out.println("Test Ended");
	}
	
}
