package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoDecorator;
import home_work_3.calcs.additional.CalculatorWithMemoryDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorDecoratorMain {
    public static void main(String[] args) {
        ICalculator calc = new
                CalculatorWithCounterAutoDecorator(new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends()));

        double result1 = calc.sum(4.1, calc.mult(15, 7), calc.power(calc.div(28, 5), 2));
        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result1);

        if (calc instanceof CalculatorWithCounterAutoDecorator){
            long count = ((CalculatorWithCounterAutoDecorator) calc).getCountOperation();
            System.out.println("Калькулятор был использован " + count + " раз(а).");

            ICalculator calc2 = (((CalculatorWithCounterAutoDecorator)calc).getCalculator());
            if (calc2 instanceof CalculatorWithMemoryDecorator){
                ((CalculatorWithMemoryDecorator) calc2).toMemory();
                double memory = ((CalculatorWithMemoryDecorator) calc2).getMemory();
                System.out.println("Результат последнего сохранения в памяти калькулятора: " + memory);
            }
        }
    }
}
