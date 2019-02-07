import java.util.UUID;

public class AboutUUID {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid); //16진문자열, 32개 문자, 고유 유효값 생성시 편리
		//String값은 아니나 toString()가능
		String s = uuid.toString();
		System.out.println(s);
	}
}
