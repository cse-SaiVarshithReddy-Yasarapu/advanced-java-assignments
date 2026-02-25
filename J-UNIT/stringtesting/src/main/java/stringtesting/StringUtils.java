package stringtesting;

public class StringUtils {

    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        if (input == null) return false;
        return input.equals(reverse(input));
    }
}