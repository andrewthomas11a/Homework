package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoCompositeInterface;
import home_work_3.calcs.simple.*;

public class CalculatorWithCounterAutoCompositeInterfaceMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoCompositeInterface calc71 = new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithOperator());

        double result1 = calc71.sum(4.1, calc71.mult(15, 7), calc71.power(calc71.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result1);
        System.out.println("Калькулятор был использован " + calc71.getCountOperation() + " раз(а).");

        CalculatorWithCounterAutoCompositeInterface calc72 = new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithMathCopy());

        double result2 = calc72.sum(4.1, calc72.mult(15, 7), calc72.power(calc72.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result2);
        System.out.println("Калькулятор был использован " + calc72.getCountOperation() + " раз(а).");

        CalculatorWithCounterAutoCompositeInterface calc73 = new CalculatorWithCounterAutoCompositeInterface(new CalculatorWithMathExtends());

        double result3 = calc73.sum(4.1, calc73.mult(15, 7), calc73.power(calc73.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result3);
        System.out.println("Калькулятор был использован " + calc73.getCountOperation() + " раз(а).");
    }
}
