package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoComposite;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoCompositeMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoComposite calc61 = new CalculatorWithCounterAutoComposite(new CalculatorWithOperator());

        double result1 = calc61.sum(4.1,
                                calc61.mult(15, 7),
                                calc61.power(calc61.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result1);
        System.out.println("Калькулятор был использован " + calc61.getCountOperation() + " раз(а).");

        CalculatorWithCounterAutoComposite calc62 = new CalculatorWithCounterAutoComposite(new CalculatorWithMathCopy());

        double result2 = calc62.sum(4.1,
                                calc62.mult(15, 7),
                                calc62.power(calc62.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result2);
        System.out.println("Калькулятор был использован " + calc62.getCountOperation() + " раз(а).");

        CalculatorWithCounterAutoComposite calc63 = new CalculatorWithCounterAutoComposite(new CalculatorWithMathExtends());

        double result3 = calc63.sum(4.1,
                                calc63.mult(15, 7),
                                calc63.power(calc63.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result3);
        System.out.println("Калькулятор был использован " + calc63.getCountOperation() + " раз(а).");
    }
}
