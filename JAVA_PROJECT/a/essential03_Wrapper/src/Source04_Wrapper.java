
public class Source04_Wrapper {
	public static void main(String[] args) {
		/*
		 * Wrapper ��ü�� �����ϸ鼭,���� ��ü�� ������ �����͸� ����
		 *	 equals �� compareTo �� �����͸� ���Ҽ� �ִ� ��ɵ��� ��κ� �����صξ���.
		 * 
		 * �����͸� ������� �۵��ϴ� ��ɵ��� ������ ��ɵ��� ������ �ʴ�.
		 * 
		 * static ���� �ش� Ÿ���� �����͸� �ٷ궧 ����� ��ɵ��� �ξ� ������ �͵��� ����. 
		 */
		Boolean b = new Boolean(true);
		Integer i = 44;
		i.doubleValue();
		boolean a = Boolean.logicalOr(true, false);
		System.out.println(a);
		
		/*
		 * �� Wrapper �� ������ �߿��� ����� 
		 * String �� �м��ؼ� �ش� type�� �����͸� ������ ����̴�.
		 * (valueOf �� �������� ��Ա� ������, �װ� �ᵵ �Ǳ� ��)
		 */
		boolean r1 = Boolean.parseBoolean("true");
			int r2 = Integer.parseInt("123");
			int r3 = Integer.valueOf("123");
		double r4 = Double.parseDouble("3.144");
			float r5 = Float.parseFloat("1.4");
			
		/*
		 *  �� Wrapper ��ü�� String ==> data �� �м��Ҽ� �ִ� parsing ����� �����Ѵ�! 	
		 */
			
			
			
	}
}


