package Collection;
/*
 	2.set
 	-> ������ ���� ������ ����, �ߺ� �Ұ�
 	
 	 HashSet(�⺻����), LinkedHashSet(�������). TreeSet(��������,��������)

*/
import java.util.*;
public class Chap13_5_Set {
	public static void main(String[] args) {
		
		HashSet set = new HashSet(); // ������ ���� ����
		LinkedHashSet set2 = new LinkedHashSet<>(); // ���� ���
		Object [] oo = {"1","7","7","3","2","1","1","2","4","3","1","2",new Integer(1)};
		
		for (int i = 0; i < oo.length; i++) {
			set.add(oo[i]); // �ߺ��� �ڷ�� �Էµ��� �ʴ´�.
			set2.add(oo[i]);
		}
		System.out.println(set);
		System.out.println(set2);
		
		//-------------------------------------����
		
		HashSet bingo = new HashSet();
		for(;bingo.size()<25;) { // bingo�� ũ�Ⱑ 25�϶����� ������			
			bingo.add((int)(Math.random()*50)+1);
			//���� ���� �Էµ��� �ʰ� �ٸ������θ� 25���� ��
			//1--->50 ������ ��쿡 ���� �Էµ�
		}
		System.out.println("����");
		Iterator it = bingo.iterator();
		for (int i = 1; i <= bingo.size(); i++) {
			System.out.print(it.next()+"\t");
			
			if(i%5==0) {
				System.out.println(); // i�� 5�϶����� �ٹٲ�
			}
		}
	}
}
