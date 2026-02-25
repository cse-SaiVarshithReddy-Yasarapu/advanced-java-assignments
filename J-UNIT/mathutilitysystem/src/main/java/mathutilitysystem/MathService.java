package mathutilitysystem;

public class MathService {

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int square(int number) {
        return number * number;
    }

    public String classifyNumber(int number) {
        if (number < 0) return "NEGATIVE";
        if (number == 0) return "ZERO";
        return "POSITIVE";
    }

    public void slowMethod() throws InterruptedException {
        Thread.sleep(200);
    }
}