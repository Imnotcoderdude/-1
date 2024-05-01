package main.java.calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator(); // 객체 생성!
        Scanner sc = new Scanner(System.in); // 키보드로 입력받을 수 있게 스캐너 설정
        List<Double> save = new ArrayList<>(10); // ArrayList를 사용하여 결과를 저장함, 초기용량 10으로 설정

        while (true) { // while 문을 사용하여 정수 두개와 연산자를 입력받고 while문 내에 제대로 입력하지 않은 것은 오류메세지 출력
            System.out.print("첫 번째 숫자 입력 : ");
            if (!sc.hasNextInt()) {// 만약 정수가 아닌( ! ) 것이 입력되면 오류메세지 출력
                System.out.println("숫자를 제대로 입력하세요");
                sc.next();
                continue;// 오류메세지를 출력한 후 다시 while문 처음으로 이동하기 위해 continue 사용
            }
            int num1 = sc.nextInt();// 정확히 입력했다면 스캐너 변수로 받기

            System.out.print("두 번째 숫자 입력 : ");
            if (!sc.hasNextInt()) {
                System.out.println("숫자를 제대로 입력하세요");
                sc.next();
                continue;
            }
            int num2 = sc.nextInt();

            System.out.print("연산기호 입력 : ");
            // Calculator 클래스의 마지막 매개변수인 operator를 받기.
            // 받을때 Calculator 클래스 내에 if문으로 무엇을 받았는지 검사하고 맞는 연산자로 계산 실행.
            // 맞지 않는 연산자를 입력할 경우 형식에 맞는 연산자 입력하라고 출력
            char operator = sc.next().charAt(0); // 한글자만 받아야 하기에 char을 사용한다
                                                 // 문자열 내에 첫번째 인덱스를 받아야 하기에 charAt(0)을 사용한다.
            double result = 0;
            try { // 예외를 찾기 위한 try, 만약 여기서 예외가 발생한다면 catch 로 이동
                result = calc.calculate(num1, num2, operator);
                save.add(result);
                if (save.size() > 10) { // 만약 저장된 배열의 크기가 10보다 크다면
                    save.remove(0);// 0번째 인덱스를 삭제한다.
                }
                System.out.println("계산결과 : " + result); // 계산결과 출력
                calc.mainAction(sc, save); // 계산결과 출력 이후 메인액션 메소드 실행
            } catch (CalculatorException e) {// 포착하려는 예외 유형을 CalculatorException으로 잡고 예외변수 e 설정
                System.out.println(e.getMessage());// 예외가 발견될 경우 e.getMessage로 메세지 출력
            }
        }
    }
}
