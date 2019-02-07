
public class Source07_StringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("JavaProgramming");
		// ���� String ��ü�� �ѱ�鼭 �����ϸ�, toCharArray() �ڽ��� �迭�� ī�Ǹ� �ص�.
		
		// �ڽſ��� ������ char[] �� �����Ҽ� �ְ� �صξ���.
		char c = sb.charAt(4);	// String�� ó���� ���ִ� ����̰�,
		System.out.println(c);
		
		sb.delete(3, 6);	// 3<= 6 char ���� ���ش�.
		System.out.println(sb.toString()  + "/"+sb.length() );
		sb.deleteCharAt(0);
		System.out.println(sb.toString()  + "/"+sb.length());
		sb.insert(5, "BAAAM!");
		System.out.println(sb.toString()  + "/"+sb.length());
		
		sb.replace(0, 4, "?");
		System.out.println(sb.toString() + "/"+sb.length());
		sb.setCharAt(5, '��');
		System.out.println(sb.toString() + "/"+sb.length());
		
		StringBuilder sbb = sb.reverse();
		System.out.println(sb.toString() + "/"+sb.length());
		System.out.println(sbb == sb);
		// �� ��ü�� Ư���� ��? 
		// ������ �ϴ� ��ɵ��� ��κ��� ������ StringBuilder �ڽ��� ��ü���� this�� ���Ͻ�Ų��.
		sb.reverse().insert(3, "123456").reverse();
		System.out.println(sb.toString());
		
		// StringBuffer ��� ��ü�� �ִ�. �̰� StringBuilder �ϰ� ����� �Ȱ���.
		// �ڹ� ��â�� �������� �����ϴ� ��ü�̰� �̰� �������Ѽ� �����а� StringBuilder 
		// ������ ���� Thread �� �ٷ궧 �˰� �ȴ�.
		
		
	}
}



