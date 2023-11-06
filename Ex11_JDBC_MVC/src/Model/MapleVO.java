package Model;
//Model : Data 담당 / 사실 DAO도 이쪽이 좀 더 어울림

public class MapleVO {

	private String nick;
	private String job;
	private int fame;

	public MapleVO(String nick) {
		super(); 
		//상위클래스의 생성자 호출! default 생성자 => 생략가능
		//반드시 """"생성자의 첫번째 줄""""에 써야됨.. 아래로 보내면 에러남
		this.nick = nick;
		this.job = "모험가";
		this.fame = 0;
	}
	

	public MapleVO(String nick, String job, int fame) {
		this.nick = nick;
		this.job = job;
		this.fame = fame;
	}


	public String getNick() {
		return nick;
	}

	public String getJob() {
		return job;
	}

	public int getFame() {
		return fame;
	}

}

//닉네임 직업 