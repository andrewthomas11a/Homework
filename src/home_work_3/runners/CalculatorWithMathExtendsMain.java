package home_work_3.runners;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithMathExtendsMain {
    public static void main(String[] args) {
        CalculatorWithMathExtends calc3 = new CalculatorWithMathExtends();

        double result = calc3.sum(4.1,
                                calc3.mult(15, 7),
                                calc3.power(calc3.div(28, 5), 2));
        System.out.println("4.1 + 15 * 7 + (28 / 5 ) ^ 2 = " + result);
    }
}
