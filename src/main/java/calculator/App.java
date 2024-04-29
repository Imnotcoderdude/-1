package main.java.calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> save = new ArrayList<>(10); // ArrayList를 사용하여 결과를 저장함, 초기용량 10으로 설정

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // 첫 번째 숫자를 양의 정수로 입력

            if (!sc.hasNextInt()) {
                System.out.println("제대로 입력하세요");
                sc.next();
                continue;
            } int firstInt = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            // 두 번째 숫자를 양의 정수로 입력. 0은 불가.
            if (!sc.hasNextInt()) {
                System.out.println("제대로 입력하세요");
                sc.next();
                continue;
            }
            int secondInt = sc.nextInt();

            System.out.print("연산기호를 입력하세요: ");
            // 연산기호 입력, 이상한 기호 입력시 오류 출력
            String oper = sc.next();

            double result = 0;

            // 올바른 기호가 입력됬다면 연산 수행하는 반복문
            switch (oper) {
                case "+":
                    result = firstInt + secondInt; // 더하기 실행부분
                    break;
                case "-":
                    result = firstInt - secondInt; // 빼기 실행부분
                    break;
                case "*":
                    result = firstInt * secondInt; // 곱하기 실행부분
                    break;
                case "/":
                    if (secondInt == 0) {
                        System.out.println("두번째 숫자에는 0이 입력될 수 없습니다.");
                        continue; // 0이 입력되면 다시 처음으로
                    }
                    result = firstInt / secondInt;
                    break;
                default:
                    System.out.println("올바른 연산기호를 입력하세요");
                    continue; // 이상한 연산기호 입력하면 다시 처음으로
            }

            // 계산결과를 배열에 추가하고 배열 크기가 10을 초과하면 오래된 인덱스, 즉 0번째부터 제거
            save.add(result);
            if (save.size() > 10) {
                save.remove(0);
            }
            System.out.println("");
            // 결과 출력하기
            System.out.println("계산결과: " + result);
            System.out.println("");

            // 추가로 입력하는 부분 출력후 입력받기.
            System.out.println("계속하려면 1 입력 : ");
            System.out.println("계산기를 종료하려면 exit 입력 : ");
            System.out.println("배열의 첫번째 제거하려면 remove 입력 : ");
            System.out.println("저장된 결과 조회 inquiry 입력 : ");
            String action = sc.next();

            // 사용자가 추가로 입력하는 것에 따라서 그에 맞는 작업 실행하는 제어문
            switch (action) {
                case "1":// 1을 입력받으면 루프를 반복한다.
                    break;
                case "exit": // exit을 입력받으면 루프를 깨고 계산기를 종료한다.
                    System.out.println("계산기 종료");
                    return;
                case "remove": // remove를 입력받으면 배열의 0번째 요소 삭제 실행.
                    if (!save.isEmpty()) {// save 배열
                        save.remove(0); // 삭제 실행 부분
                        System.out.println("배열의 첫번째 요소가 삭제되었습니다.");
                    } else { // 저장된 배열의 값이 없으면 출력됨
                        System.out.println("저장된 결과가 없습니다.");
                    }
                    break;
                case "inquiry" :
                    System.out.println("저장된 결과들 ");
                    for (Double savedResult : save) {
                        System.out.println(savedResult);
                    } break;
                default:
                    System.out.println("올바른 입력을 하세요");
                    break;
            }
        }
    }
}
