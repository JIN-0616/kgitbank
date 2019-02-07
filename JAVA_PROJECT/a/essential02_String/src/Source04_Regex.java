/*
 *  ���Խ� ? regular expression
 */
public class Source04_Regex {
	public static void main(String[] args) {
		// ���Խ��� ���ڿ��� �ۼ��ϸ� �ȴ�. 
		// �� �ȿ� ���ڰ�����, ������ �м��ϴµ� ���ȴ�.
		
		/*
		 * [] : �ѹ��ڸ� ��Ÿ������ �Ҷ� ��� �̾ȿ� �����ִ� ���ڴ� ���� or ó��
		 *    : �̾ȿ� ���ڱ����� �ϰ��� �Ҷ�, ����Ǿ��ִ� ���ڰ��̶�� - ó���� ������.
		 *    ���� ��� [A-Za-z] ���ĺ� , [��-Ş] �ѱۿϼ�������
		 *    : ^�� ���̸� ���ܸ� �ǹ��Ѵ�.
		 * ��� �׷��� ���� ��ߵǴ°� �ƴϰ�,
		 * �̸� ������ �ִ� Ư�� �׷��� �ִ�.
		 *  .  �ƹ����� 
		 *  \\d  ��ġ������ : [0-9]
		 *  \\D  ��ġ������ ���� : [^0-9]
		 *  \\w : ���������� : [A-Za-z_0-9]
		 *  \\W : \\w ����
		 *  \\s : ���������� 
		 *  \\S : ���������� ����
		 */
		String[] sample = "ȫ�浿,trumt,trump, rump,prump,te0506,Arump".split(",");
		for(int i=0; i<sample.length; i++) {
			String s = sample[i];
			System.out.print("["+ i+"] "+s+" : " );
			// System.out.println(s.matches("[at]rum[pt]") );
			// System.out.println(s.matches("[a-t]rum[pt]") );
			// System.out.println(s.matches("[^a-p]rum[pt]") );
			System.out.println(s.matches(".rum[pt]") );
		}
		System.out.println("loc_p5".matches("loc_[a-z][0-9]"));
		System.out.println("loc_pa".matches("loc_[a-z]\\D"));
		
	}
}
