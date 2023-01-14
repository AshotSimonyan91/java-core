package homework.homework7;

public class CalculatorDemo {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double vol;
        vol = calculator.plus(4, 5);
        System.out.println(vol);
        vol = calculator.minus(4, 5);
        System.out.println(vol);
        vol = calculator.divide(4, 5);
        System.out.println(vol);
        vol = calculator.multiply(4, 5);
        System.out.println(vol);
    }
}
