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
		String[] names = "���,��ó,ȭ��,�̴Ͼ�,����,���".split(",");
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
		units.add(new Unit("���", 3));
		units.add(new Unit("�̴Ͼ�", 2));
		System.out.println("���給 : " + units.toString() );
		System.out.println("�ý��� : 10 ���ӻ̱� ����.");
		System.out.println("�ý��� : 10 ��°�� �� ���� ����!");
		for(int cnt=1; cnt<=10; cnt++) {
			Unit unit = Shop.gachya();	
			if(cnt==10) 
				unit.lv = 3;
			
			System.out.println("PICK!! " + unit.toString());
			if(units.contains(unit)) {
				System.out.println("�ý��� : ������ü�� �ռ��˴ϴ�.");
				int idx = units.indexOf(unit);
				Unit got = units.get(idx);
				got.lv += unit.lv;
				// Unit renew = new Unit(got.name, got.lv+unit.lv);
				//	units.set(idx, got);
				System.out.println("�ý��� : �ռ���� " + got);
			}else {
				units.add(unit);
			}
		}
		System.out.println("�ý��� : 10�� �̱� ��!");
		/*
		 * 	Unit ��ü�� ���� Comparator ��ü�� �ʿ��ؼ� ���� �� ������ ���״µ�,
		 * 	�̰� �ٽ� ����� ���Ұ� ���ٸ�, �����ϸ鼭 �����Ҽ� �ִ�.  
		 *  
		 *  (implements �ɰ� ���踦 �ؾߵǴ�, extends �ɰ� �����ؾߵɶ� ) 
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
		// ���� ��ü�� �������� ������ ��ü���� �͸� ��ü (anonymous class)
		units.sort(t);
		
		
		System.out.println("���給 : " + units.toString() );	
		// Lv�� ���� �������, List���� Unit�� ������ ���ְ�, ���� Lv�̸� �����ټ�
	}
}
/*
 * 
 * �� ����Ʈ���� ���� �̸��� ���� Unit��ü�� ������ �ȴٸ�, 
 * 	���� ��ü�� lv�� ���� Unit��ü�� Lv��ŭ �����ִ� �۾��� for �ȿ��� ó���ϰ�,
 * 
 * ���������� list�� add�� �� ó���ǰ� ����, �̰� Lv�� ��������, (����LV�̸� �̸� ������������) ���ĵǰ�
 * Comparator �����ؼ� sort �ϰ� ���
 * 
 */


