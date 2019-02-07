
/*
 * Math ��ü��
 * 	Wrapper�� ��ü�� �ƴ�����, ��ġ ��꿡 ���õ� ����� ��Ƶ� ��ü�̴�. 
 */
public class Source06_Math {
	public static void main(String[] args) {
		// new Math();	// �����ؼ� ����ϴ� ��ü�� �ƴϴ�.
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		// double abs(double ) , float abs(float ) , int abs(int ) , long abs(long )
		int n =Math.abs(-3);
		System.out.println(n);
		
		// double ceil(double) , double floor(double) , double round(double)
		System.out.println(Math.ceil(3.7));
		System.out.println(Math.floor(3.7));
		System.out.println(Math.round(3.7));
		
		// min , max 
		int m = Math.min(3, 5);
		System.out.println(m);
		System.out.println("=======================");
		
		// ���� �α� ���� ���
		System.out.println(Math.log10(10000));
		System.out.println(Math.log(10000));
		// pow , sqrt , exp
		double t = Math.exp(4);
		System.out.println(t);
		System.out.println(Math.log(t));
		
		// �ﰢ�Լ� , sin, cos, tan, asin, acos, atan,  toDegrees  toRadians
		
		double r30 = Math.toRadians(30);
		double sin30 = Math.sin(r30);
		System.out.println(sin30);
		
		
		
		
		
	}
}
