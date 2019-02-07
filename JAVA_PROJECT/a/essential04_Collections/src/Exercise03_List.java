import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 */
class Unit {
	String name;
	int lv;
	
	public Unit(String name) {
		this(name, 1);
	}
	
	public Unit(String name,int lv) {
		this.name = name;
		this.lv = lv;
	}
	
	public String toString() {
		return "["+name+" "+lv+"Lv]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Unit) {
			Unit u =(Unit)obj;
			if(((Unit) obj).name.equals(this.name)) 
				return true;
			else
				return false;
			// return ((Unit) obj).name.equals(this.name);
		}
		return false;
	}
}

class Shop {
	static Unit gachya() {
		String[] names = "기사,아처,화살,미니언,대포,고블린".split(",");
		String n = names[(int)(Math.random()*names.length)];
		return new Unit(n);
	}
	
}
//==================================================
class UnitComparator implements Comparator<Unit> {
	@Override
	public int compare(Unit o1, Unit o2) {
		if(o1.lv > o2.lv) {
			return -1;
		}else if(o1.lv < o2.lv) {
			return 1;
		} else {
			return o1.name.compareTo(o2.name);
		}
	}
}
//=====================================================


public class Exercise03_List {
	public static void main(String[] args) {
		List<Unit> units = new LinkedList<>();
		units.add(new Unit("기사", 3));
		units.add(new Unit("미니언", 2));
		System.out.println("현재덱 : " + units.toString() );
		System.out.println("시스템 : 10 연속뽑기 시작.");
		System.out.println("시스템 : 10 번째는 고렙 유닛 등장!");
		for(int cnt=1; cnt<=10; cnt++) {
			Unit unit = Shop.gachya();	
			if(cnt==10) 
				unit.lv = 3;
			
			System.out.println("PICK!! " + unit.toString());
			if(units.contains(unit)) {
				System.out.println("시스템 : 기존객체에 합성됩니다.");
				int idx = units.indexOf(unit);
				Unit got = units.get(idx);
				got.lv += unit.lv;
				// Unit renew = new Unit(got.name, got.lv+unit.lv);
				//	units.set(idx, got);
				System.out.println("시스템 : 합성결과 " + got);
			}else {
				units.add(unit);
			}
		}
		System.out.println("시스템 : 10연 뽑기 끝!");
		/*
		 * 	Unit 객체를 비교할 Comparator 객체가 필요해서 설계 후 생성을 시켰는데,
		 * 	이게 다시 사용을 안할것 같다면, 설계하면서 생성할수 있다.  
		 *  
		 *  (implements 걸고 설계를 해야되는, extends 걸고 설계해야될때 ) 
		 * 
		 */
		units.sort(new UnitComparator());

		Comparator<Unit> t = new Comparator<Unit>() {
			@Override
			public int compare(Unit o1, Unit o2) {
				if(o1.lv < o2.lv) {
					return -1;
				}else if(o1.lv > o2.lv) { 
					return 1;
				} else {
					return o1.name.compareTo(o2.name);
				}
			}
		};
		// 따로 객체명 지정없이 설계한 객체들을 익명 객체 (anonymous class)
		units.sort(t);
		
		
		System.out.println("현재덱 : " + units.toString() );	
		// Lv이 높은 순서대로, List안의 Unit이 정렬이 되있게, 같은 Lv이면 가나다순
	}
}
/*
 * 
 * 이 리스트에는 같은 이름을 가진 Unit객체가 나오게 된다면, 
 * 	기존 객체의 lv를 뽑힌 Unit객체의 Lv만큼 더해주는 작업을 for 안에서 처리하고,
 * 
 * 최종적으로 list에 add가 다 처리되고 나면, 이걸 Lv순 내림차순, (같은LV이면 이름 오름차순으로) 정렬되게
 * Comparator 구현해서 sort 하고 출력
 * 
 */


