
public class Source07_Array {
	public static void main(String[] args) {
		/*
		 * �迭��ü�� ������ �����͸� �����ϴ� ĭ���� 0����� �����͵�� ä�����ִ�. int[] : 0, boolean[] : false ,
		 * double[] : 0.0 , ��ü[] : null
		 * 
		 * ���鶧 0�̻� ���� �����Ҽ� �ְ�, �ִ� ĭ���� int ������
		 */
		int size = 3;
		boolean[] box = new boolean[size];
		System.out.println("boolean[] created.. length " + box.length);
		System.out.println(box[0] + ".." + box[1] + ".." + box[2]);
		/*
		 * �����ϸ鼭 ��ĭ�� �����͸� �����ϸ鼭 ����� �ִ�. ������ ������ŭ ������ ���缭 �����ȴ�.
		 */
		int[] n = new int[] { 1, 4, 5, 6, 1, 54 }; // new int[empty] { }
		System.out.println(n.length);
		n = new int[] { 1, -1, 3, 6 };
		boolean[] bb = new boolean[] {true, false, true, true};
		/*
		 * Sword 3ĭ¥���� ����µ� �ٷ� ����Ҽ� �ְ�, ��ü������ �����ѻ��·� �������..?
		 * 
		 */
		
		Sword[] sw = new Sword[] { new Sword(), new Sword(), new Sword() };
		//==============================================
		System.out.println(sw.length);	// 3
		System.out.println(sw[0]);
		System.out.println(sw[1]);
		System.out.println(sw[2]);
		
		System.out.println(sw[0] != sw[1] );
		System.out.println(sw[0] != sw[2] );
		System.out.println(sw[1] != sw[2] );
		Sword x1 = new Sword();
		Sword x2 = new Sword();
		Sword x3 = new Sword();
		Sword[] sww = new Sword[] {x1, x2, x3 };
		
		/*
		 * �����Ϳ������� ��� ���� ��������ü(�迭)�� ���鶧,
		 * ĭ�� �����ϰ� ������� �ְ�(���߿� ä��뵵��),
		 * ��ĭ�� ���� �����ؼ� �������� �ִ� (�ٷ� Ȯ���ؼ� ����� �뵵��)  
		 */
		
	}
}







