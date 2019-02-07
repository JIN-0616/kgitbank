import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 *  �÷��� ��ü�� ��üŸ���� �����ϰ� ����ϴ°� �����̴�.	(���ʸ� ������ �Ҽ��ְ� �صξ���) 
 *	
 *	���ʸ��� ����ϰ��� ��üŸ���� ������Ÿ�ӿ� ���������� �ְ� ���� ó���صа� ���ϴ� �Ŵ�.
 *	(�������� ������ Object�� ó�� ��)  
 */

class Box<E> {
	E one;	// 
	E other;
	boolean setData(E e) {
		if(one == null) {
			one = e;
			return true;
		} else if(other == null) {
			other = e;
			return true;
		} else {
			return false;
		}
	}
	public String toString() {
		return "one = "+ one +", other = " + other;
	}
}

public class Source04_Generic {
	public static void main(String[] args) {
		Box b = new Box();
		// boolean setData(Object e)  �� ó���ȴ�.
		Box<String> bb = new Box<String>();	// �����ϰ� �Ǹ�
		bb.setData("33");	// ��Ÿ������ ����ó�� �ص� ��üŸ���� �����ǰ� �ȴ�.
		
		
		// �����ϰ� ����� ��� ����..?
		Set<String> filter = new HashSet<>();	// �ڴ� ������ �ص� �ȴ�.	new HashSet<String>(); �ᵵ ��.
		// filter.add(3);
		filter.add("MON");
		filter.add("MON");
		filter.add("THU");
		// �ش�Ÿ���� ��ü���� ������ �ǰ�,
		// Iterator�� ���ٰų�, enhanced for �� ������ �ٷ� ���尴üŸ������ ��ü���� �������� �ִ�.
		Iterator<String> it =filter.iterator();
		while(it.hasNext()) {
			String m = it.next();
			System.out.println(m+" .. " + m.charAt(0));
		}
		for(String o  :  filter) {
			System.out.println(o +" .. " + o.charAt(1));
		}
		//==============================================================
		
		
		
	}
}



