package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;

public class CalculatorWithCounterAutoSuperMain {

    public static void main(String[] args) {
        CalculatorWithCounterAutoSuper calc5 = new CalculatorWithCounterAutoSuper();

        double result1 = calc5.mult(15, 7);
        System.out.println("15 * 7 = " + result1);

        double result2 = calc5.div(28, 5);
        System.out.println("28 / 5 = " + result2);

        System.out.print(result2 + " ^ 2 = ");
        result2 = calc5.power(result2, 2);
        System.out.println(result2);

        System.out.print("4.1 + " + result1 + " + " + result2 + " = ");
        result1 = calc5.sum(result1, result2, 4.1);
        System.out.println(result1);

        System.out.println("4.1 + 15 * 7 + (28 / 5 ) ^ 2 = " + result1);
        System.out.println("Калькулятор был использован " + calc5.getCountOperation() + " раз(а).");
    }


}
