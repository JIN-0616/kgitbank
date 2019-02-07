/*
 * 
 */
public class Source06_StringBuilder {
	public static void main(String[] args) {
		/*
		 * StringBuilder ��ü 
		 * 	����ϰ��� �ϴ� ���ڿ��� ȿ�������� �������� �Ҷ� ����ϴ� ��ü
		 * 
		 * 	�⺻������ ��ü�ȿ� ������ ����� String �̶� ���� �����.
		 * 	�߰����� ��ɵ��� �ִ�.
		 *  
		 *  �ٸ����� �ִٸ� ���ΰ����� char[] �迭�� ���ڸ� �����Ҽ� �ְ� �صξ���,
		 *	���̵� �˾Ƽ� ������ �ȴ�. 
		 * 
		 */
		/*
		 * ��ü ������ �⺻(�Ű�����)���̵� �ǰ�, int�� �ǰ�, String�� ��.
		 */
		StringBuilder sb = new StringBuilder();	// 
		System.out.println(sb.length());	// int : ������ �ִ� ���ڿ��� ����
		System.out.println(sb.capacity());	// int : ���ڿ��� ����� ���ؼ� ������ char[] �迭 ũ��
		
		sb.append("String");
		System.out.println(sb.toString());	// ����� �ִ� ���ڿ��� String ȭ �����ش�.
		
		System.out.println(sb.length());	// int : ������ �ִ� ���ڿ��� ����
		System.out.println(sb.capacity());	// int : ���ڿ��� ����� ���ؼ� ������ char[] �迭 ũ��
		sb.append("Builder is ");
		sb.append(true);	// �����͸� ���ڿ�ȭ �ؼ� char[] �迭�� �ǵڿ� �ٿ�����
		
		System.out.println(sb.toString());	// ����� �ִ� ���ڿ��� String ȭ �����ش�.
		System.out.println(sb.length());	// int : ������ �ִ� ���ڿ��� ����
		System.out.println(sb.capacity());	// int : ���ڿ��� ����� ���ؼ� ������ char[] �迭 ũ��
		
		//====================================================================
		String str = "";	
		System.out.println(System.identityHashCode(str));
		str += "String";	// str + "String"
		System.out.println(System.identityHashCode(str));
		str += "Builder is ";
		System.out.println(System.identityHashCode(str));
		str += true;
		System.out.println(System.identityHashCode(str));
		System.out.println(str);
		// String���� ���� ��Ư�� ����� �ִ�.
		
		
	}
}







