package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import test.CalculatorException;

public class App {
    public static void main(String[] args) {

        Calculator calc = new Calculator(); // 객체 생성!

        Scanner sc = new Scanner(System.in);
        List<Double> save = new ArrayList<>(10); // ArrayList를 사용하여 결과를 저장함, 초기용량 10으로 설정

        while (true) {
            System.out.print("첫 번째 숫자 입력 : ");
            if (!sc.hasNextDouble()) {
                System.out.println("숫자를 제대로 입력하세요");
                sc.next();
                continue;
            }
            double num1 = sc.nextInt();

            System.out.println("두 번째 숫자 입력 : ");
            if (!sc.hasNextDouble()) {
                System.out.println("숫자를 제대로 입력하세요");
                sc.next();
                continue;
            }
            double num2 = sc.nextInt();

            System.out.println("연산기호 입력 : ");
            String operator = sc.next();
            double result = 0;

            try {
                result = calc.calculate(num1, num2, operator);
                save.add(result);
                if (save.size() > 10) {
                    save.remove(0);
                }
                System.out.println("계산결과 : " + result);
            } catch (CalculatorException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
