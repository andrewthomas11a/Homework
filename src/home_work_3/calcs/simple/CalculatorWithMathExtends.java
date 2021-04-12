package home_work_3.calcs.simple;

public class CalculatorWithMathExtends extends CalculatorWithOperator{
    @Override
    public double power(double a, int b){
        return Math.pow(a, b);
    }

    @Override
    public double abs(double a){
        return Math.abs(a);
    }

    @Override
    public double sqrt(double a){
        return Math.sqrt(a);
    }
}
