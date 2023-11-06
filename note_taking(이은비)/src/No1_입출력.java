import java.util.Scanner;

public class No1_입출력 {

	public static void main(String[] args) {
		// 1. Scanner란?
		// 자바 화면에서 데이터를 입력받는 기능(을 제공하는 클래스)

		// 정수형 값을 입력받을 때
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(num);

		// 2. String형 값을 입력받을 때
		String str = sc.next();
		System.out.println(str);

		// 3. System.out.println()이란?
		// 괄호안의 내용을 출력하고 줄바꿈을 한다

		// - ln이 있는 것과 없는 것의 차이점 :
		// ln이 있으면 줄바꿈을 하고 없으면 줄바꿈을 하지 않는다.

	}
}
