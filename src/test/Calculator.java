package test;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Double> result = new ArrayList<>();

    public double calculate(double num1, double num2, String operator) throws CalculatorException {
        double result;
        char op = operator.charAt(0);

        if (op == '+') {
            result = num1 + num2;
        } else if (op == '-') {
            result = num1 - num2;
        } else if (op == '*') {
            result = num1 * num2;
        } else if (op == '/') {
            if (num2 == 0) {
                throw new CalculatorException("분모는 0이 될 수 없습니다.");
            }
            result = num1 / num2;
        } else {
            throw new CalculatorException("형식에 맞는 연산자 입력하세요" + operator + ".");
        }
        return result;
    }

}
