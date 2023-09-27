
public class StringExample {

	public static void main(String[] args) {

		String message1 = new String("Java King");
		String message2 = new String("Java King");
		System.out.println(message1 == message2);
		System.out.println(message1.equals(message2));
		
		
		String message3 = "Java King";
		String message4 = "Java King";
		System.out.println(message3 == message4);
		System.out.println(message3.equals(message4));
	
		char[] chars = {'j', 'a', 'v', 'a'};
		String str = new String(chars);
		System.out.println(str);
	}

}
