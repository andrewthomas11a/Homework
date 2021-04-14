package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoComposite {
    private CalculatorWithOperator calc1;
    private CalculatorWithMathCopy calc2;
    private CalculatorWithMathExtends calc3;

    // вместо такой переменной можно проверку с использованием instanceOf
    private final int type;

    private long count;
    public long getCountOperation(){
        return this.count;
    }

    public CalculatorWithCounterAutoComposite(CalculatorWithOperator calc){
        type = 1;
        this.calc1 = calc;
    }

    public CalculatorWithCounterAutoComposite(CalculatorWithMathCopy calc){
        type = 2;
        this.calc2 = calc;
    }

    public CalculatorWithCounterAutoComposite(CalculatorWithMathExtends calc){
        type = 3;
        this.calc3 = calc;
    }

    public double sum(double ... a){
        this.count++;
        double result = 0;
        if (type == 1){
            result = calc1.sum(a);
        }else if (type == 2){
            result = calc2.sum(a);
        }else if (type == 3){
            result = calc3.sum(a);
        }
        return result;
    }

    public double minus(double a, double b){
        this.count++;
        double result = 0;
        if (type == 1){
            result = calc1.minus(a,b);
        }else if (type == 2){
            result = calc2.minus(a,b);
        }else if (type == 3){
            result = calc3.minus(a,b);
        }
        return result;
    }


    public double mult(double ...a){
        this.count++;
        double result = 0;
        if (type == 1){
            result = calc1.mult(a);
        }else if (type == 2){
            result = calc2.mult(a);
        }else if (type == 3){
            result = calc3.mult(a);
        }
        return result;
    }

    public double div(double a, double b){
        this.count++;
        double result = 0;
        if (type == 1){
            result = calc1.div(a,b);
        }else if (type == 2){
            result = calc2.div(a,b);
        }else if (type == 3){
            result = calc3.div(a,b);
        }
        return result;
    }

    public double power(double a, int b){
        this.count++;
        double result = 0;
        if (type == 1){
            result = calc1.power(a,b);
        }else if (type == 2){
            result = calc2.power(a,b);
        }else if (type == 3){
            result = calc3.power(a,b);
        }
        return result;
    }

    public double abs(double a){
        this.count++;
        double result = 0;
        if (type == 1){
            result = calc1.abs(a);
        }else if (type == 2){
            result = calc2.abs(a);
        }else if (type == 3){
            result = calc3.abs(a);
        }
        return result;
    }

    public double sqrt(double a){
        this.count++;
        double result = 0;
        if (type == 1){
            result = calc1.sqrt(a);
        }else if (type == 2){
            result = calc2.sqrt(a);
        }else if (type == 3){
            result = calc3.sqrt(a);
        }
        return result;
    }
}
