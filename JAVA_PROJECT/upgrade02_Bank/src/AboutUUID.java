import java.util.UUID;

public class AboutUUID {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid); //16�����ڿ�, 32�� ����, ���� ��ȿ�� ������ ��
		//String���� �ƴϳ� toString()����
		String s = uuid.toString();
		System.out.println(s);
	}
}
