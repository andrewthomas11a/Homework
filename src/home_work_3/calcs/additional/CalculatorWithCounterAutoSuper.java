package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterAutoSuper extends CalculatorWithMathExtends {

    private long count;

    public long getCountOperation(){
        return count;
    }

    @Override
    public double sum(double ... a){
        this.count++;
        return super.sum(a);
    }

    @Override
    public double minus(double a, double b){
        this.count++;
        return super.minus(a, b);
    }

    @Override
    public double mult(double ...a){
        this.count++;
        return super.mult(a);
    }

    @Override
    public double div(double a, double b){
        this.count++;
        return super.div(a, b);
    }

    @Override
    public double power(double a, int b){
        this.count++;
        return super.power(a, b);
    }

    @Override
    public double abs(double a){
        this.count++;
        return super.abs(a);
    }

    @Override
    public double sqrt(double a){
        this.count++;
        return super.abs(a);
    }
}
