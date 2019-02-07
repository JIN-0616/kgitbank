import java.util.LinkedHashSet;
import java.util.Set;

public class Source07_Duplicate {
	public static void main(String[] args) {
		/*
		 * Set �� �÷��� �ߺ���ü�� �������� �ʴ´�.
		 * 	(��ü���� �޶� � ������ �����ϸ�, ���� ��ü�� �ν��Ѵ�.)
		 * 	: Integer ��ü�� �װ� ó���� ���־ �׷���.
		 */
		Set<Integer> s = new LinkedHashSet<>();
		s.add(3);	// Boxing�Ǽ� Integer ��ü�� ����ȴ�.
		s.add(Integer.valueOf(3) );
		s.add(new Integer(3) );
		s.add(new Integer(3) );
		System.out.println(s.size());
		
		Integer i1 = new Integer(31);
		Integer i2 = new Integer(31);
		System.out.println(i1==i2);
		System.out.println(s.add(i1));
		System.out.println(s.add(i2));	// i2 ��ü�� ������ �ִٰ� �Ǵ�����.
		System.out.println(i1.equals(i2));
		System.out.println(i1.hashCode() + " , " + i2.hashCode());	
		// equals �� ����� ����, hashCode�� ���Ƽ� ������ü��� �ν���.
		// hashCode�� ��ü�� �����ɶ� �ο��Ǵ� �������ε�, 
		// Integer��ü���� ���� �ؽ��ڵ带 �ܺο��� Ȯ���Ҷ� �����Ͱ����� ����ϰ� �صξ���.
		System.out.println(System.identityHashCode(i1) + " , " + System.identityHashCode(i2) );
		
		// �ڹٿ��� ���� �����ϴ� ��ü�� ���� ��쿣 �̷��� ó���� �صа͵��� ������,
		// �����ڰ� �ʿ信 ���ؼ� �����ϴ� ��ü�� ��쿣 �������� ó���� �صξ�� �Ѵ�.
		// ���..?
	}
}

