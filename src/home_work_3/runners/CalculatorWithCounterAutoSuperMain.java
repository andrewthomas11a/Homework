package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;

public class CalculatorWithCounterAutoSuperMain {

    public static void main(String[] args) {
        CalculatorWithCounterAutoSuper calc5 = new CalculatorWithCounterAutoSuper();

        double result = calc5.sum(4.1, calc5.mult(15, 7), calc5.power(calc5.div(28, 5), 2));

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Калькулятор был использован " + calc5.getCountOperation() + " раз(а).");
    }
}
