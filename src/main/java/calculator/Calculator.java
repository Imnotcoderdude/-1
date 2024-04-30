package main.java.calculator;

public class Calculator {
    // 사용할 필드 선언한 부분
    double result;
    double num1;
    double num2;
    String operator;

    // 메소드를 선언한 부분
    public double add(double num1, double num2) {
        double result = num1 + num2; // + 메서드
        return result;
    }
    public double sub(double num1, double num2) {
        double result = num1 - num2; // - 메서드
        return result;
    }
    public double mul(double num1, double num2) {
        double result = num1 * num2; // * 메서드
        return result;
    }
    public double div(double num1, double num2) {
        double result = num1 / num2; // 나누기 메서드
        return result;
    }
}
