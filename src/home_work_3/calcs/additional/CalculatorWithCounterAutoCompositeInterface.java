package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoCompositeInterface {
    private final ICalculator calc;
    private long count;

    public long getCountOperation(){
        return this.count;
    }

    public CalculatorWithCounterAutoCompositeInterface(ICalculator calc){
        this.calc = calc;
    }

    public double sum(double ... a){
        this.count++;
        return calc.sum(a);
    }

    public double minus(double a, double b){
        this.count++;
        return calc.minus(a,b);
    }


    public double mult(double ...a){
        this.count++;
        return calc.mult(a);
    }

    public double div(double a, double b){
        this.count++;
        return calc.div(a,b);
    }

    public double power(double a, int b){
        this.count++;
        return calc.power(a,b);
    }

    public double abs(double a){
        this.count++;
        return calc.abs(a);
    }

    public double sqrt(double a){
        this.count++;
        return sqrt(a);
    }
}
