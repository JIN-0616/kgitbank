
public class Source03_Wrapper {
	public static void main(String[] args) {
		// Ư�� �����͸� ���� Wrapper ��ü�� ������ ����
		// ������ ���ΰ� �ƴϴ�.
		
		// ��� Wrapper ��ü�� valueOf ��� ����� �ִµ�, �̰� ���ؼ��� �������� �ִ�.
		// �Ű������� ���������Ѱ�, �� ��ü�� ������ Ÿ���̳�, String �̴�.
		Boolean b1 = new Boolean(true);
		Boolean b2 = Boolean.valueOf(true);
		Boolean b3  = Boolean.valueOf("true");
		
		System.out.println(Boolean.TRUE == b2);
		
		Integer i1 = new Integer(41);
		Integer i2 = Integer.valueOf(41);
		Integer i3 = Integer.valueOf("41");	// �غ� ����..
		System.out.println(i2 == i3);
		/*
			String d = "135000";
			int v = Integer.valueOf(d);		// ��ó���� ���� ��ڽ̵� int���� Ȯ���ϰ� �ȴ�.
		*/
		// b1 == b2  ������ü ?  / b2 == b3 ������ü?
		// i1 == i2  ������ü ?  / i2 == i3 ������ü?
		/*
		 * valueOf�� �̿��ؼ� Ȯ���ϴ� Wrapper��ü�� �̸� ������� ��ü�� �ش�.
		 * 	(Boolean �� true ������ �ִ� ��ü��, false ���� ��ü�� �̸� �����ΰ� ���߿� �ϳ��� ����)
		 * ��ġ�� Wrapper ���� ���� , -128 ~ 127 ������ �����ΰ�, �׻��̰�ü�� ��������� ����
		 * 	�������� ���� ����.
		 * 
		 * �ڵ� Boxing  �Ͼ�� , valueOf()�� ��ü�� Ȯ���Ѵ�
		 */
		
		Double d1 = Double.valueOf(3.14);
		Double d2 = 3.14;
		System.out.println(d1 == d2);
		
		
		
	}
}
