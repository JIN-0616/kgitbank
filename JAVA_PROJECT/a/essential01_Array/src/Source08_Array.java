
public class Source08_Array {
	public static void main(String[] args) {
		/*
		 * �̸� �����͸� �����صΰ� �迭�� �̷������� ����ϸ�..?
		 */
		String[] mode = new String[] {"��","��","��"};
		int auto = (int)(Math.random()*3);
		System.out.println(auto  + " /  " + mode[auto]);
		
		String[] first = new String[] {"��","��","��","��","��","��","��","��","��","��" };
		String[] last = new String[] {"����","����","����","�ÿ�","����","����","����","����","����","����"};
		
		int fidx = (int)(Math.random()*first.length);
		int lidx = (int)(Math.random()*last.length);
		
		String name = first[fidx]+last[lidx];
		System.out.println("����� �̹����� [" + name +"] ���� ��Ե˴ϴ�.");
		
	}
}
