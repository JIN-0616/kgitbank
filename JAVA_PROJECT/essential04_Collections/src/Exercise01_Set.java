import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise01_Set {
	public static void main(String[] args) {
		String[] heros = "루피,조로,나미,우솝,상디,쵸파".split(",");
		Set set = new TreeSet();
		for (int i = 0; i < heros.length; i++) {
			set.add(heros[i]);
		}
		System.out.println(set.size());
		//============================================================
		Scanner cin = new Scanner(System.in);
		// 이름 3개를 입력받아야되는데,
		// 그 3개는 겹치면 안되고, heros[] 배열에 있는 데이터야 한다.
		// Set의 특징을 이용해서 해결
		// 입력을 받은 후, 선택된 인원들 출력해주고,
		// 미선택된 이름들을 다 출력해주세요
		
		TreeSet sel = new TreeSet();
		while(sel.size()<3) {
			String name = cin.nextLine();
			if(set.contains(name) && !sel.contains(name)){
				sel.add(name);
				set.remove(name);
			}				
		}
		System.out.println("Selected heros : "+sel.toString() );
		System.out.println("NonSelected heros : "+set.toString() );
		
		
		//Teachers A===================================================
		Set pick = new HashSet();
		while(pick.size()<3) {
			System.out.print("이름>");
			String in = cin.nextLine();
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
		//-----------------------
		Set remain = new HashSet();
		for (Object obj : set) {
			if(!pick.contains(obj)) {
				remain.add(obj);
			}			
		}
		System.out.println("Pick .. ");
		for (Iterator i = pick.iterator(); i.hasNext();) {
			Object o = (Object) i.next();
			System.out.println(" => "+o.toString());			
		}
		System.out.println("remain....");
		Object[] ar = remain.toArray();
		for (int i = 0; i < ar.length; i++) {
			System.out.println("  - "+ar[i].toString());
		}
		//Teachers A===================================================

		
	}
}
