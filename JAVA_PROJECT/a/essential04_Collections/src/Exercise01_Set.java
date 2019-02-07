import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise01_Set {
	public static void main(String[] args) {
		String[] heros = "����,����,����,���,����,����,����,����Ű,���".split(",");
		Set set = new TreeSet();
		for(int i=0; i<heros.length;i++) {
			set.add(heros[i]);
		}
		System.out.println(set.size());
		//===============================================================
		Scanner cin = new Scanner(System.in);
		Set pick=  new HashSet();
		while(pick.size() <3) {
			System.out.print("�̸�> ");
			String in = cin.nextLine();
			in.hashCode();
			if(!set.contains(in)) {
				System.out.println("�߸��� �����Դϴ�. �ִ� �����͸� �Է����ּ���.");
				continue;
			}
			if(pick.add(in)) {
				System.out.println("�߰��Ǿ����ϴ�.");
			}else {
				System.out.println("�̹� �Ͻ� �����Դϴ�.");	
			}
		}
		//===============================================================================
		Set remain = new HashSet();
		for(Object obj : set) {
			if(!pick.contains(obj))
				remain.add(obj);
		}
		System.out.println("PICK ..");
		for(Iterator i= pick.iterator(); i.hasNext(); ) {
			Object o = i.next();
			System.out.println(" �� " + o.toString());
		}
		System.out.println("REMAIN .." );
		Object[] ar = remain.toArray();
		for(int i=0; i<ar.length; i++) {
			System.out.println(" �� " + ar[i].toString());
		}
		
	}
}
