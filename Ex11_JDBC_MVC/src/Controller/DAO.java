package Controller;
//Controller : 알고리즘, 로직 등을 작성하는 곳

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MapleVO;

//사실 dao는 모델에 가깝다.
public class DAO {

	private Connection conn;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;// select문일 때 사용

	// connection 메소드 생성하고 내용 작성
	public void connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.219.101:1521:xe";
			String id = "service";
			String pw = "12345";

			conn = DriverManager.getConnection(url, id, pw);

			// 로그출력 : 개발자가 확인하는 용도
			if (conn != null) {
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");

			} // if

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} // try-catch

	} // connection()

	public int insert(String nick) {

		connection(); // nullPointException 에러 뜨는 주범..

		MapleVO temp = new MapleVO(nick);
		// 객체 생성시 생성자 호출되는데 생성자의 매개변수 타입 맞지 않으면 에러 생길 수 있음

		String sql = "insert into Maple values(?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, temp.getNick());
			psmt.setString(2, temp.getJob());
			psmt.setInt(3, temp.getFame());

			int cnt = psmt.executeUpdate();
			// 결과 받지 않아도 됨 그냥 명령하는 거임ㅇㅇ
			// select는 결과를 받아야 하기 때문에 executeQuery()

			close();

			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
		// 리턴을 두 번 써도 되는 이유???

	}// insert()

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close();

	public ArrayList<MapleVO> allSelect() {

		connection();

		ArrayList<MapleVO> temp = new ArrayList<>();

		String sql = "select * from maple";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String nick = rs.getString(1);
				String job = rs.getString(2);
				int fame = rs.getInt(3);

				MapleVO vo = new MapleVO(nick, job, fame);

				temp.add(vo);
			} // while
			close();
			return temp;// 주의

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// allSelect()

}
