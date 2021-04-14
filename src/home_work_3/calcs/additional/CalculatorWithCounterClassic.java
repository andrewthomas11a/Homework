package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterClassic extends CalculatorWithMathExtends {
    private long count;

    public void incrementCountOperation(){
        this.count++;
    }

    public long getCountOperation(){
        return this.count;
    }
}
