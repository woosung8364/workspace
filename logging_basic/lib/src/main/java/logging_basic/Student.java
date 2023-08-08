package logging_basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //생성자
@Getter
@Setter

public class Student {
	private int ssn;
	private String name;
}
