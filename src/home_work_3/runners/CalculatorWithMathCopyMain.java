package home_work_3.runners;

import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        CalculatorWithMathCopy calc2 = new CalculatorWithMathCopy();

        double result = calc2.sum(4.1, calc2.mult(15, 7), calc2.power(calc2.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
    }
}
