package test;

public class Calculator {
    double result;
    double num1;
    double num2;
    String operator;

    public double add(double num1, double num2) {
        double result = num1 + num2;
        return result;
    }
    public double sub(double num1, double num2) {
        double result = num1 - num2;
        return result;
    }
    public double mul(double num1, double num2) {
        double result = num1 * num2;
        return result;
    }
    public double div(double num1, double num2) {
        double result = num1 / num2;
        return result;
    }
}
