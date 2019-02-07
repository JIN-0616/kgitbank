import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 *  
 */

class Unit{
	String name;
	int lv;
	
	public Unit(String name) {
		this(name, 1);
	}
	
	public Unit(String name, int lv) {
		this.name = name;
		this.lv = lv;
	}
	
	@Override
	public String toString() {
		return "["+name+" "+lv+"lv]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// 이름만 같으면 같게 해라, 중복되면 현재 뽑은객체 lv을 더해줘라
		if(obj instanceof Unit) {
			Unit other = (Unit)obj;
			return name.equals(other.name);				
		}else {
			return false;
		}
		/* ----------------teachers A---------------------------------
		if(obj instanceof Unit) { //이클립스 자동 casting지원--> obj.name-->(Unit)obj.name
			unit u = (Unit)obj;
			if(((Unit)obj).name.equals(this.name))
				return true;
			else
				return false;
				
			// 축약ver
			//return ((Unit)obj).name.equals(this.name);
		*/
	}
}

class Shop{
	static Unit gaChya() {
		String[] names = "기사,아처,화살,미니언,대포,고블린".split(",");
		String n = names[(int)(Math.random()*names.length)];
		return new Unit(n);
	}
}
//========================================================================
class UnitComparator implements Comparator<Unit>{
	@Override
	public int compare(Unit o1, Unit o2) {
		int c = o1.name.compareTo(o2.name);
		if(o1.lv>o2.lv) {
			return -1;
		}else if(o1.lv<o2.lv) {
			return 1;
		}else {
			return c < 0 ? -1 : (c > 0 ? 1: 0);
		//	return o1.name.compareTo(o2.name);
		}
	}
}
//=========================================================================
public class Exercise03_List {
	public static void main(String[] args) {
		List<Unit> units = new LinkedList<>();
		units.add(new Unit("기사",3));
		units.add(new Unit("미니언",2));
		System.out.println("현재 덱 : "+units.toString());
		System.out.println("시스템 : 10 연속뽑기 시작");
		System.out.println("시스템 : 10번째는 고렙 유닛 등장!");
		
		for (int cnt = 1; cnt <= 10; cnt++) {
			Unit unit = Shop.gaChya();
			if(cnt==10) {
				unit.lv=3;
			}
			System.out.println(unit.toString());
			if(units.contains(unit)) {
				Unit i = units.get(units.indexOf(unit));
				i.lv += unit.lv;
				/*
				 * int idx = units.indexOf(unit);
				 * Unit got = units.get(idx);
				 * got.lv += units.lv;
				 * // Unit renew = new Unit(ggot.name, got.lv+unit.lv); 
				 * // 기존 개체가 아닌 새로 만들 객체로 사용될 경우 set을 해서 재설정해야함
				 * System.out.println(got == units.get(idx); //이기때문에
				 * //units.set(idx,got); 					 //생략가능
				 * System.out.println("합성결과 = "+got.toString());
				 */
			}else {
				units.add(unit);
			}
		}
		System.out.println("시스템 : 10연 뽑기 끝!");
		/*
		  Unit 객체를 비교할 Comparator 객체가 필요해서 설계후 생성을 시켰는데,
		  이게 다시 사용을 안할것 같다면, 설계하면서 생성할 수 있다.
		  
		  특수한경우만 가능
		  (implements 걸고 설계를 해야되는 경우, extends 걸고 설계해야될때.)
		*/
		//--------------1. 기존 ----------------------------------------
		Comparator<Unit> c = new UnitComparator();
		units.sort(c);		
		//--------------2. 단순화 --------------------------------------
		//units.sort(new UnitComparator());
		
		//---------------3. 설계+생성 ---------------------------------
		Comparator<Unit> t = new Comparator<Unit>() {
			@Override
			public int compare(Unit o1, Unit o2) {
				if(o1.lv>o2.lv) {
					return -1;
				}else if(o1.lv<o2.lv) {
					return 1;
				}else {
					return o1.name.compareTo(o2.name);
				}
			}
		};
		// < 익명설계 > 
		//  - 따로 객체명 지정없이 설계한 객체들을 익명 객체 (Anonymous Object)
		
		// 익명객체... compile  생성객체$1 컴파일결과물(\bin폴더)
		//							-->   Exercise03_List$1.class
		
		// 1번이상 사용할때는 불가능한 방법이다. (Only 1회성 객체생성)		
		//----------------------------------------------------------

		System.out.println("현재 덱 : "+units.toString()); 
		// lv이 높은 순서대로 정렬, 같은 레벨이면 가나다순 
		
		
	}
}
/*
	이 리스트에는 같은 이름을 가진 Unit객체가 나오게 한다면
	기존 객체의 lv를 뽑힌 Unit객체의 lv만큼 더해주는 작업을 for 안에서 처리하고
	
	최종적으로 list에 add가 다 처리되고 나면, 이걸 lv을 내림차순, 같은레벨시 이름 오름차순으로 
	정렬되게 Comparator 구현해서 sort하고 출력해라
	
*/