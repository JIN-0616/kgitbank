import java.util.Set;
import java.util.TreeSet;

/*
 * Exercise02_Card ���� , 
 * 	LinkedHashSet �̳� HashSet �� �̿��ؼ� Card ��ü�� ó���ϸ� ���ٸ� ������ ������,
 * 	TreeSet ��ü�� �̿��ؼ� Card��ü�� �����ϸ� ó������ error�� �߻��Ѵ�. 
 * 
 *  TreeSet �� ũ��� �������ĵǼ� �����͸� Ȯ���Ǵ� Set ��ü�ε�,
 *  ���� ��ü������ ũ�Ⱑ ���� ������, ũ��񱳰� ������ ��ü�� ���ؼ��� ������ �ǰ�,
 *  
 *  TreeSet ��ü��, hashCode / equals �� �ߺ���ü��� �Ǵ��ϴ°� �ƴ϶�
 *  ũ��񱳰���� 0�϶� ������ü�� �ν��� �Ѵ�.
 */

public class Source09_Duplicate {
	public static void main(String[] args) {
		Set<Double> ds = new TreeSet<>();
		Double d1 = new Double(3.14);
		Double d2 = new Double(3.19);
		System.out.println(ds.add(d1));	// 3.14
		System.out.println(ds.add(d2));	// 3.13
		
		System.out.println(d2.compareTo(d1));	
		// �� �۾��� TreeSet���� add �� �ɶ� ���ϰ� return ������� ���ȴ�. 
		System.out.println(ds.toString());
		
		
		Integer i1 = 3;
		Integer i2 = -1;
		System.out.println(i1.compareTo(i2));
		
		
		String s1= "����";
		String s2 = "����";
		// System.out.println(s1-s2);
		int n =s1.compareTo(s2);	// s1-s2 �� ������ ������ �ϸ� �ȴ�.
		System.out.println(n);
		// ���� TreeSet�� �� �ΰ�ü�� ��������� ������� ����.
		Card p1 = CardShop.random();
		Card p2 = CardShop.random();
		// System.out.println(p1-p2);
		p1.compareTo(p2);
	}
	
}
