
public class Source02_Wrapper {
	public static void main(String[] args) {
		// Wrap(Boxing), UnWrap(UnBoxing) �� �ڵ����� �Ͼ��.
		Integer n1 = new Integer(4561);
		Integer n2 = 4561;
		Integer n3 = 4561;
		System.out.println(n1 +" / " + n2 +" / " + n3);
		System.out.println(n1 == n2);
		System.out.println(n1 == n3);
		System.out.println(n2 == n3);
		System.out.println();
		System.out.println(n1.equals(n2));
		System.out.println(n1.intValue() == n3.intValue());
		
		int v1 = n1;	// UnWrap (UnBoxing)
		System.out.println(v1);
		System.out.println(n2 + n3);
		/*
		 * �̰� ����ڽ�,��ڽ� �̶�� �θ���. 
		 */
		System.out.println("===================================");
		Boolean b1 = true;
		Boolean b2 = true;
		System.out.println(b1 == b2);	// ���� ��ü
		
		Integer i1 = -128;	// - 128 ~ 127
		Integer i2 = -128;	// - 128 ~ 127

		System.out.println(i1 == i2);	// ���� ��ü
		// ��..?
		
	}
}
