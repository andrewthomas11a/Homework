package home_work_3.calcs.simple;

public class CalculatorWithOperator {

    /**
     * Метод суммирует любое количество чисел типа double, возвращает результат.
     * @param a массив переданных чисел
     * @return результат сложения
     */
    public double sum(double ... a){
        double sum = 0;
        for (double i : a) {
            sum += i;
        }
        return sum;
    }

    public double minus(double a, double b){
        return a - b;
    }

    /**
     * Метод перемножает любое количество чисел типа double, возвращает результат.
     * @param a массив переданных числе
     * @return результат перемножения
     */
    public double mult(double ...a){
        double result = 1;
        for (int i = 0; i < a.length; i++) {
            result *= a[i];
        }
        return result;
    }

    public double div(double a, double b){
        return a / b;
    }

    public double power(double a, int b){
        double result = a;
        for (int i = 1; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public double abs(double a){
        if(a < 0){
            return a * -1;
        }else{
            return a;
        }
    }

    public double sqrt(double a){
        return Math.sqrt(a);
    }
}