/*
 *	java.lang.Object ��ü��..? 
 * 		Ư���� extends�� �������� ������ �ڵ����� �����ǰ� �� �ִ�.
 * 	�ڹٿ��� ���Ǵ� ��� ��ü���� ������ �������̴�, ���������δ� ������ �ǰ� ���ִ�.
 *  java.lang.Object �� ����� ��ɵ��� ������ ������ �ۿ� ����.  
 */
class Sword  {
	int atk;
	Sword() {
		super();	// �Ѵܰ� ��(?) ��ü�� ������ ȣ�� ??
		atk = 30;
	}
	boolean enchant() {
		if(Math.random() >0.66) {
			atk += 5;
			return true;
		}else {
			return false;
		}
	}
	public String toString() {
		return "Sword[ATK="+atk+"]";
	}
}
//��������������������������������������������������������
public class Source03_Object {
	public static void main(String[] args) {
		Sword s = new Sword();
		boolean b = s.enchant();	// �̰� �����Ҷ� �����аŰ�..
		System.out.println("b.."+ b );
		System.out.println(s.atk);
		
		String str = s.toString();	// �ȸ���� ������..?
		System.out.println("str =" + str);
		int c = s.hashCode();	// �� �ִ°���..?
		System.out.println("c =" + c);
		Sword s2 = s;
		System.out.println("equals? " + s.equals(s2) );	// �̰� �� �Ӿ�..?
		/*
		 * ��ü��� ��¿�� ���� �����ԵǴ� Object�� ���� ����� 
		 * ��ü ���迡 ���缭 �� ������ �ص־ߵǴ°� �ƴ�����, �صδ� ���� ����.
		 * 
		 *  1. public String toString() : 
		 *  	��ü ���¸� ���ڿ�ȭ�ؼ� ���Ͻ�Ű�� �����صδ� ��
		 *     / �⺻�� ��ü��@��ü�ؽ��ڵ�16�� �� ���� ��������� ������.  
		 */
		Object ob = new Sword();	// �ǰ�ü�� Object �� �޾Ƽ� �����ϸ�
		// ob.enchant();	// �̷��� ������ ��ü�� �����ϸ鼭 ����� ���� �ȵ�����
		String obs = ob.toString();	// ���� �ִ°� ���� �ǰ� , �װ� �������־��ٸ�..?
		System.out.println(obs);	// 
		// �� ������ ����Ǽ� , System.out.println �̳�, �׿� ������ ����� ��ü����
		
		Sword s3 = new Sword();
		System.out.println(s3);		// ��ü���� �ڵ����� ���� �Ǽ� ���Ǵ� ��Ȳ�� �ִ�.
		
		
	}
}






