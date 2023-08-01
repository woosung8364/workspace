package ezen.member;
/**
 * JavaBean 규약에 따라 만든 재사용 가능한 컴포넌트
 * @author i7C-송우성
 * 연결되는 jsp 파일에서의 form 태그 속성안에 있는 name 이름과 선언되어있는 변수이름이 동일해야함
 */
public class Member {
	private String id;
	private String name;
	private String passwd;
	private String email;
	private String regdate;
	
	public Member() {}
	
	public Member(String id, String name, String passwd, String email, String regdate) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getEmail() {
		return email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", passwd=" + passwd + ", mail=" + email + ", regdate=" + regdate
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
