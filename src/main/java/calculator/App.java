package main.java.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] save = new double[10];
        int count = 0;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int firstInt = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int secondInt = sc.nextInt();

            System.out.print("연산기호를 입력: ");
            String oper = sc.next();
//        char oper = sc.next().charAt(0);

            System.out.println("계속하려면 1번 계산기를 끝내려면 exit 입력 : ");
            String exit = sc.next();

            if ("exit".equals(exit)) {
                System.out.println("계산기 종료");
                break;
            }
            double result = 0;

            if ("/".equals(oper) && secondInt == 0) {
                System.out.println("두번째 숫자에는 0이 입력될 수 없습니다.");
            } else {
                switch (oper) {
                    case "+":
                        result = firstInt + secondInt;
                        break;
                    case "-":
                        result = firstInt - secondInt;
                        break;
                    case "*":
                        result = firstInt * secondInt;
                        break;
                    case "/":
                        result = firstInt / secondInt;
                        break;
                    default:
                        System.out.println("정확한 연산기호를 입력하세요");
                }
                save[count] = result;
                if (count >= save.length) {
                    count = 0;
                }
            }
            System.out.println("계산결과 : " + result);
        }
    }
}
