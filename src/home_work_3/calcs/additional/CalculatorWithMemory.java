package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemory {
    private final ICalculator calc;
    private long count;

    public long getCountOperation(){
        return this.count;
    }

    public CalculatorWithMemory(ICalculator calc){
        this.calc = calc;
    }

    // Переменная, в которую сохраняется результат последнего метода при вызове пользователем метода toMemory. К ней можно
    // обратиться через методы toMemory и getMemory
    private double memory;
    // Переменная для хранения результата каждого последнего вызыванного метода. К ней нет доступа извне этого класса.
    private double resultAfterEveryMethod;

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
        this.count++;
        this.resultAfterEveryMethod = calc.sum(a);
        return calc.sum(a);
    }

    public double minus(double a, double b){
        this.count++;
        this.resultAfterEveryMethod = calc.minus(a,b);
        return calc.minus(a,b);
    }


    public double mult(double ...a){
        this.count++;
        this.resultAfterEveryMethod = calc.mult(a);
        return calc.mult(a);
    }

    public double div(double a, double b){
        this.count++;
        this.resultAfterEveryMethod = calc.div(a,b);
        return calc.div(a,b);
    }

    public double power(double a, int b){
        this.count++;
        this.resultAfterEveryMethod = calc.power(a,b);
        return calc.power(a,b);
    }

    public double abs(double a){
        this.count++;
        this.resultAfterEveryMethod = calc.abs(a);
        return calc.abs(a);
    }

    public double sqrt(double a){
        this.count++;
        this.resultAfterEveryMethod = calc.sqrt(a);
        return calc.sqrt(a);
    }
}