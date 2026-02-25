package mathutilitysystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MathServiceTest {
	MathService math;
	@BeforeAll
	public static void msg1() {
		System.out.println("Test is Started");
	}
	@AfterAll
	public static void msg2() {
		System.out.println("Test is ended");
	}
	
	
	
	@BeforeEach
	public void init() {
		math=new MathService();
	}
	
	@Nested
	public class AllTests{
		
		
		
		@RepeatedTest(5)
		public void testEven() {
			assertAll(
			()->assertTrue(math.isEven(4)),
			()->assertFalse(math.isEven(5))
			);
		}
		@Test
		@DisplayName("Test Square")
		public void testSquare() {
			assertAll(
					()->assertEquals(4,math.square(2)),
					()->assertNotEquals(114,math.square(4))
					);
		}
		@Test
		public void testClassification() {
			assertAll(
					()->assertEquals("POSITIVE",math.classifyNumber(5)),
					()->assertEquals("NEGATIVE", math.classifyNumber(-5)),
					()->assertEquals("ZERO", math.classifyNumber(0))
					);
		}
		
	}
	@ParameterizedTest
	@ValueSource(ints={22,44,88,10,16})
	@DisplayName("Test By Parameters")
	public void parameterizedEvenTest(int number) {
		assertTrue(math.isEven(number));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,4",
		"3,9",
		"4,16"
	})
	@DisplayName("Test By Parameters of Square")
	public void testParameterizedSquare(int a,int b) {
		assertEquals(b,math.square(a));
	}
	
	@Disabled
	public void testDisabled() {
		fail();
	}

}
