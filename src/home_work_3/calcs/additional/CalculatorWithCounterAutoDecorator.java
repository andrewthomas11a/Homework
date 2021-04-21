package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoDecorator implements ICalculator {
    private final ICalculator calc;
    private long count;

    public CalculatorWithCounterAutoDecorator(ICalculator calc){
        this.calc = calc;
    }

    /**
     * Метод возвращает калькулятор, вложенный при использовании конструктора при создании объекта класса
     * @return вложенный калькулятор
     */
    public ICalculator getCalculator(){
        return this.calc;
    }

    public long getCountOperation(){
        return count;
    }

    @Override
    public double sum(double ... a){
        this.count++;
        return calc.sum(a);
    }

    @Override
    public double minus(double a, double b){
        this.count++;
        return calc.minus(a, b);
    }

    @Override
    public double mult(double ...a){
        this.count++;
        return calc.mult(a);
    }

    @Override
    public double div(double a, double b){
        this.count++;
        return calc.div(a, b);
    }

    @Override
    public double power(double a, int b){
        this.count++;
        return calc.power(a, b);
    }

    @Override
    public double abs(double a){
        this.count++;
        return calc.abs(a);
    }

    @Override
    public double sqrt(double a){
        this.count++;
        return calc.abs(a);
    }
}
