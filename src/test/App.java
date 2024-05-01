package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CalculatorException {
        Calculator calc = new Calculator(); // 객체 생성!
        Scanner sc = new Scanner(System.in);
        List<Double> save = new ArrayList<>(10); // ArrayList를 사용하여 결과를 저장함, 초기용량 10으로 설정

        calc.start(save);
    }
}
