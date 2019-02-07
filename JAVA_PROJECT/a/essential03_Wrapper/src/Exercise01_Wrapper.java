/*
 * 	Wrapper ��ü�� ������� Ȱ��Ǵ���..?
 * 
 */
import java.util.LinkedHashSet;

public class Exercise01_Wrapper {
	public static void main(String[] args) {
		/*
		 * LinkedHashSet �� Collection(=��ü�������ϴ¿뵵) ��ü�� �ϳ���, 
		 * 	������ü��(Ȥ�� equals ��� true)�� ������ ���ϰ� ����Ǿ��ִ�. 
		 */
		// �ٷ� �������� ����, �� ��ü�� ���� � ��ü���� ó���Ҳ��� ������ �ؾ� �Ѵ�.
		
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		LinkedHashSet<String> set1 = new LinkedHashSet<String>();
		LinkedHashSet<Double> set2 = new LinkedHashSet<Double>();
		
		for(int cnt=1; cnt<=15; cnt++) {
			int n = 1+(int)(Math.random()*15);
			System.out.print(cnt + " 's pick = " +n );
			// boolean b = set.add(n);	// ���强�����ΰ� ����.
			// boolean b = set.add( Integer.valueOf(n) );	// ���强�����ΰ� ����.
			boolean b = set.add( new Integer(n) );	// ���强�����ΰ� ����.
			System.out.println("  / add result = "  + b);
		}
		System.out.println(set.toString());	// ������ �ִ� �����͸� ���ڿ��� �������.
		// �� �ܿ��� �� �߰����� ����� �ִµ�, Collection �� ��ü�� �ٷ궧 ���� �ɲ���. 
		// ������ Wrapper ��ü�� ��� ����� �Ǵ��� ���� �Ѿ�� �ȴ�.
	}
}

/*
 * ���� ���� HangmanWordMain �� 
 * char �� ��üŸ���� ������ LinkedHashSet ��ü�� �������Ѽ�
 * ����ڰ� �Է��� ���ڸ� mark ������ ����, add ���Ѽ� true �� �߸� mark�� ��Ű��
 * false �� �߸� �̹� �Է��� ���ڴٰ� �˷��ְ�, �̶����� �Է��� ���ڵ��� ���� �� ���
 *    
 * 
 */










