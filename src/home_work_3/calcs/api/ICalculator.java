package home_work_3.calcs.api;

public interface ICalculator {
    public double sum(double ... a);

    public double minus(double a, double b);

    public double mult(double ...a);

    public double div(double a, double b);

    public double power(double a, int b);

    public double abs(double a);

    public double sqrt(double a);
}