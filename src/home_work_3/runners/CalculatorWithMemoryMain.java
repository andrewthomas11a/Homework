package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithMemory;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithMemoryMain {

    public static void main(String[] args) {
        // для примера при создании объекта типа CalculatorWithMemory передадим в качестве аргумента CalculatorWithMathExtends();
        CalculatorWithMemory calc = new CalculatorWithMemory(new CalculatorWithMathExtends());

        calc.power(calc.div(28, 5), 2);
        calc.toMemory();
        calc.sum(calc.mult(15,7), 4.1, calc.getMemory());
        System.out.println("Проверяем состояние памяти после ее вызова: " + calc.getMemory());
        calc.toMemory();

        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + calc.getMemory());
        System.out.println("Проверяем состояние памяти после ее вызова: " + calc.getMemory());
    }
}