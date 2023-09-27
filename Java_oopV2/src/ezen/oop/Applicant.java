package ezen.oop;

/**
 * 응모자
 * @author 김기정
 */
public class Applicant<T> {
	
	private T kind;
	
	public Applicant() {}
	
	public Applicant(T kind) {
		this.kind = kind;
	}

	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Applicant [kind=" + kind + "]";
	}
	
	
}
