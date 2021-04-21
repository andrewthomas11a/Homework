package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemoryDecorator implements ICalculator {
    // Переменная, в которую сохраняется результат последнего метода при вызове пользователем метода toMemory. К ней можно
    // обратиться через методы toMemory и getMemory
    private double memory;
    // Переменная для хранения результата каждого последнего вызыванного метода. К ней нет доступа извне этого класса.
    private double resultAfterEveryMethod;

    private final ICalculator calc;

    public CalculatorWithMemoryDecorator(ICalculator calc){
        this.calc = calc;
    }

    /**
     * Метод возвращает калькулятор, вложенный при использовании конструктора при создании объекта класса
     * @return вложенный калькулятор
     */
    public ICalculator getCalculator(){
        return this.calc;
    }

    /**
     * Метод по вызову пользователя сохраняет в отдельную переменную результат последней операции.
     */
    public void toMemory(){
        this.memory = this.resultAfterEveryMethod;
    }

    /**
     * Метод возвращает сохраненное в памяти число, при этом "обнуляя" память.
     * @return значение, сохраненное в памяти при помощи метода toMemory
     */
    public double getMemory(){
        double memoryNew = this.memory;
        this.memory = 0;
        return memoryNew;
    }

    public double sum(double ... a){
        this.resultAfterEveryMethod = calc.sum(a);
        return this.resultAfterEveryMethod;
    }

    public double minus(double a, double b){
        this.resultAfterEveryMethod = calc.minus(a,b);
        return this.resultAfterEveryMethod;
    }


    public double mult(double ...a){
        this.resultAfterEveryMethod = calc.mult(a);
        return this.resultAfterEveryMethod;
    }

    public double div(double a, double b){
        this.resultAfterEveryMethod = calc.div(a,b);
        return this.resultAfterEveryMethod;
    }

    public double power(double a, int b){
        this.resultAfterEveryMethod = calc.power(a,b);
        return this.resultAfterEveryMethod;
    }

    public double abs(double a){
        this.resultAfterEveryMethod = calc.abs(a);
        return this.resultAfterEveryMethod;
    }

    public double sqrt(double a){
        this.resultAfterEveryMethod = calc.sqrt(a);
        return this.resultAfterEveryMethod;
    }
}