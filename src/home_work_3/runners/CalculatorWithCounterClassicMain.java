package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {
    public static void main(String[] args) {
        CalculatorWithCounterClassic calc4 = new CalculatorWithCounterClassic();

        double result = calc4.sum(4.1, calc4.mult(15, 7), calc4.power(calc4.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Калькулятор был использован " + calc4.getCountOperation() + " раз(а).");
    }
}
