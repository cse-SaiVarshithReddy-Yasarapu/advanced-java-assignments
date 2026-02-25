package stringtesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
	StringUtils string;
	@BeforeAll
	public static void msg() {
		System.out.println("Test has started");
	}
	
	@BeforeEach
	public void init() {
		string=new StringUtils();
	}
	@DisplayName("Test Started")
	@Test
	void testReverse() {
		assertEquals("inan",string.reverse("nani"));
		
	}
	@Test
	public void testReverseWithNull() {
		assertEquals(null,string.reverse(null));
	}
	@Test
	public void testWithAssertAll() {
		assertAll(
				()->assertEquals("ivak",string.reverse("kavi")),
				()->assertNull(string.reverse(null))
				
				);
	}
	public void isPalindromes() {
		assertAll(
				()->assertTrue(string.isPalindrome("madam")),
				()->assertTrue(string.isPalindrome("sis")),
				()->assertFalse(string.isPalindrome("hii")),
				()->assertFalse(string.isPalindrome("hey"))
				
				);
		
	}
	@AfterAll
	static public void msg2() {
		System.out.println("Test has ended");
	}
	

}
