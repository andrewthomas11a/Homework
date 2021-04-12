package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {
    public static void main(String[] args) {
        CalculatorWithCounterClassic calc4 = new CalculatorWithCounterClassic();

        double result1 = calc4.mult(15, 7);
        calc4.incrementCountOperation();

        double result2 = calc4.div(28, 5);
        calc4.incrementCountOperation();

        result2 = calc4.power(result2, 2);
        calc4.incrementCountOperation();

        result1 = calc4.sum(result1, result2, 4.1);
        calc4.incrementCountOperation();

        System.out.println("4.1 + 15 * 7 + (28 / 5 ) ^ 2 = " + result1);
        System.out.println("Калькулятор был использован " + calc4.getCountOperation() + " раз(а).");
    }
}
