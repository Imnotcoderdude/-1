package test;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private Scanner scanner;

    public void start(List<Double> save) throws CalculatorException {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.print("첫 번째 숫자 입력 : ");
            int num1 = getIntInput();

            System.out.print("두 번째 숫자 입력 : ");
            int num2 = getIntInput();

            System.out.print("연산기호 입력 : ");
            char operator = getCharInput();
            double result = 0;

//            try {
//                result = calc.calculate(num1, num2, operator);
//                save.add(result);
//                if (save.size() > 10) {
//                    save.remove(0);
//                }
//                System.out.println("계산결과 : " + result);
//                mainAction(save);
//            } catch (CalculatorException e) {
//                System.out.println(e.getMessage());
//            }
        }
    }
    private int getIntInput() {
        while(true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("정확한 정수를 입력하세요");
                scanner.next();
            }
        }
    }
    private char getCharInput() throws CalculatorException {
        while(true) {
            if (scanner.hasNext()) {
                String input = scanner.next();
                if (input.length() == 1) {
                    return input.charAt(0);
                }
            }
            throw new CalculatorException("정확한 연산자를 입력하세요");
        }
    }
    private void mainCalculator(int num1, int num2, char operator) throws CalculatorException {
        while(true) {
            double result;
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
        }
    }



    public void mainAction(Scanner scanner, List<Double> save) {
        while (true) {
            System.out.println("계속하려면 1번");
            System.out.println("배열 0번째 삭제 원하면 remove");
            System.out.println("배열을 보려면 inquiry");
            System.out.println("종료하시려면 exit 를 입력해주세요");
            String action = scanner.next();

            if ("1".equals(action)) {
                return;
            } else if ("remove".equals(action)) {
                if (!save.isEmpty()) {
                    save.remove(0);
                    System.out.println("0 번째 인덱스가 제거되었습니다.");
                } else {
                    System.out.println("저장된 배열이 없습니다.");
                }
            } else if ("inquiry".equals(action)) {
                System.out.println("저장된 결과 출력");
                for (Double savedResult : save) {
                    System.out.println("["+ savedResult +"]");
                }
            } else if ("exit".equals(action)) {
                System.out.println("계산기를 종료합니다.");
                System.exit(0);
        } else {
            System.out.println("맞는 문자를 입력해 주세요!!");
            System.out.println();
            }
        }
    }
}

