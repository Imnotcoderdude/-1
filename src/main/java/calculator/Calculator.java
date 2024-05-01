package main.java.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    // calculate 메소드 생성, 매개변수 int형 두개 char형 하나 설정, 예외 처리 설정
    public double calculate(int num1, int num2, char operator) throws CalculatorException {
        double result;
        // while 반복문으로 if반복문을 감싸고 if반복문 내에 operator로 받은 연산자를 하나씩 검사.
        // 맞는 연산자로 연산을 실행하거나 예외처리한 항목이 발생할 경우 메세지를 출력.
        while (true) {

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
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
    // 리턴타입이 없는 void형 메소드 선언, 필자가 생각하는 메인컨트롤을 진행하는 메서드.
    public void mainAction(Scanner scanner, List<Double> save) {
        // while 문으로 감싸서 sout과 if문이 따로 놀지 않게 설정.
        // 왜 while 문으로 감싸야 하는지 정확한 이유는 알지 못합니다 ㅠㅠ
        // 그저 감싸지 않으면 if문이 그대로 흘러내려서 마지막 else까지 가버리기에 while문으로 감싸놓았습니다.
        while (true) { // while 문이 true 이기에 일단 중괄호 내에 있는 코드를 실행.
            System.out.println("계속하려면 1번");
            System.out.println("배열 0번째 삭제 원하면 remove");
            System.out.println("배열을 보려면 inquiry");
            System.out.println("종료하시려면 exit 를 입력해주세요");
            String action = scanner.next(); // 위에 적힌 선택지중 하나를 입력받는 곳

            if ("1".equals(action)) {// 만약 액션에 1이 입력됐을 경우
                return; // 리턴하여 처음에 숫자를 입력받는 것 부터 시작. 정확한 구동내역은 알지 못합니다 ㅠㅠ
            } else if ("remove".equals(action)) {// remove를 입력받을 경우
                if (!save.isEmpty()) { // 만약 배열이 비어있지 않다면
                    save.remove(0); // 배열 내에 0번째 인덱스 삭제
                    System.out.println("0 번째 인덱스가 제거되었습니다.");
                } else { // 배열 내에 인덱스가 없다면 출력하는 부분
                    System.out.println("저장된 배열이 없습니다.");
                }
            } else if ("inquiry".equals(action)) { // inquiry 입력시
                System.out.println("저장된 결과 출력");
                // for 문을 통해 저장된 배열의 0번째 인덱스 값부터 하나 하나 씩 출력
                for (Double savedResult : save) { // 향상된 for 문
                    System.out.println("["+ savedResult +"]");
                }
            } else if ("exit".equals(action)) {
                System.out.println("계산기를 종료합니다.");
                System.exit(0); // 구글링으로 나온 프로그램을 종료하는 코드. break, return도 듣지 않기에 사용함
            } else {
                System.out.println("맞는 문자를 입력해 주세요!!");
                System.out.println();
            }
        }
    }
}

