package junitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
//	Calculator calculator=new Calculator();
	private Calculator calculator;
	@BeforeEach
	void setUp() {
		calculator=new Calculator();
	}
	@Test
	public void testTwoAndTwoGivesFour() {
		assertEquals(5, calculator.sum(2, 3));
	}
	@Test
	public void testFiveAndFourGive() {
		assertEquals(13,calculator.sum(6,7));
	}
	@RepeatedTest(3)
	@DisplayName("Test sum with repeated execution")
	void testSumRepeated() {
		assertEquals(10,calculator.sum(5, 5),"Sum of 5 and 5 = 10");
	}
	@Nested 
	@DisplayName("Test subtraction of two numbers")
	class SubtractiorTests{
		@Test
		@DisplayName("Test subtraction of two  numbers")
		void testSubtraction() {
			assertEquals(2,calculator.subtract(5, 3),"5-3 should be 2");
		}
		
		@ParameterizedTest
		@ValueSource(ints={1,2,3,4,5})
		@DisplayName("Test multiplication of numbers by 2")
		void testMultiplyByTwo(int number) {
			assertEquals(number*2,calculator.multiply(number, 2),"Multiplication by 2");
		}
		@ParameterizedTest
		@CsvSource({"2,2,4","2,3,6","4,4,16"})
		void testMultiplyByTwo(int x,int y,int expected) {
			assertEquals(expected,calculator.multiply(x, y));
		}
		@ParameterizedTest
		@CsvFileSource(resources="/calculator-data.csv",numLinesToSkip=1)
		@DisplayName("Test sum using CSV file")
		void testSumUsingCsvFile(int a,int b,int expectedSum) {
			assertEquals(expectedSum,calculator.sum(a, b));
		}
		

	}
}
