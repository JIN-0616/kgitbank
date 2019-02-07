import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise01_Set {
	public static void main(String[] args) {
		String[] heros = "루피,조로,나미,우솝,샹디,쵸파,핸콕,프랑키,브룩".split(",");
		Set set = new TreeSet();
		for(int i=0; i<heros.length;i++) {
			set.add(heros[i]);
		}
		System.out.println(set.size());
		//===============================================================
		Scanner cin = new Scanner(System.in);
		Set pick=  new HashSet();
		while(pick.size() <3) {
			System.out.print("이름> ");
			String in = cin.nextLine();
			in.hashCode();
			if(!set.contains(in)) {
				System.out.println("잘못된 선택입니다. 있는 데이터를 입력해주세요.");
				continue;
			}
			if(pick.add(in)) {
				System.out.println("추가되었습니다.");
			}else {
				System.out.println("이미 하신 선택입니다.");	
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
			System.out.println(" → " + o.toString());
		}
		System.out.println("REMAIN .." );
		Object[] ar = remain.toArray();
		for(int i=0; i<ar.length; i++) {
			System.out.println(" → " + ar[i].toString());
		}
		
	}
}
