/*
 * 
 * Wrapper ��ü��
 * 	: �⺻�����͸� ��üȭ��Ű�� ���ؼ� ������ �͵��̴�.  
 */
public class Source01_Wrapper {
	public static void main(String[] args) {
		// �⺻������ 
		// (��ü�� �����ͷ�  true,false  / ���� / �Ǽ� / ����  �����͸� �ǹ��Ѵ�.) 
		
		boolean b = true;
		Boolean wb1 = new Boolean(b);	// Wrap
		Boolean wb2 = new Boolean(b);
		System.out.println(wb1 + " / " + wb2);
		// Wrapper ��ü���� ����ϸ� toString() �� ���� ������ �ִ� �����Ͱ� ������.
		System.out.println(wb1 == wb2);
		
		boolean d1 = wb1.booleanValue();	// UnWrap
		boolean d2 = wb2.booleanValue();	// UnWrap
		System.out.println(d1 == d2);
		/*
		 * Boolean  : Boolean(boolean)    , boolean  booleanValue() 
		 * Byte : Byte(byte) , byte byteValue();
		 * Short ..     : shortValue();
		 * Integer (int)   : intValue();
		 * Long (long)   : longValue();
		 * Float (float) : floatValue();
		 * Double (double) : doubleValue();
		 * Character (char) : charValue()
		 */
		
		
	}
}



