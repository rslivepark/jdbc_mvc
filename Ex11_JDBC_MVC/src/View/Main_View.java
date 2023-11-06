package View;
//View : UI 담당 /모든 입출력은 View

import java.util.ArrayList;
import java.util.Scanner;

import Controller.DAO;
import Model.MapleVO;

public class Main_View {

	public static void main(String[] args) {
		System.out.println("=== 메이플 캐릭터 생성기 ===");

		DAO jdbc = new DAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("[1]추가 [2]전체조회");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("=== 추가 ===");
				System.out.println("닉네임 >> ");
				String nick = sc.next();
				// 입력받은 닉네임 DB에 보내주자!!

				int rowCnt = jdbc.insert(nick);

				if (rowCnt > 0) {
					System.out.println("insert success");
				} else if (rowCnt == 1) {
					System.out.println("문제있다");
				}
				break;
			case 2:
				System.out.println("=== 전체조회 ===");
				// 캐릭터 하나 저장하는 건 VO, 그 캐릭터 개수 모를때 -> ArrayList

				ArrayList<MapleVO> allChar = jdbc.allSelect();

				// 모든캐릭터 정보 출력
				
				if (allChar != null) {
					for (int i = 0; i < allChar.size(); i++) {
						System.out.print(allChar.get(i).getNick() + "\t");
						System.out.print(allChar.get(i).getJob() + "\t");
						System.out.print(allChar.get(i).getFame() + "\t");
						System.out.println();
					}
				}

				break;
			default:
				System.out.println("잘못된 입력ㅋ");
			}// switch
		} // while
	}

}
