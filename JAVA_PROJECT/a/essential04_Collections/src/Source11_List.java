import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class CustomComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		// o1 ��ü�� �۴ٰ� ó���ϰ� �ʹٸ� -1
		// o1 ��ü�� ũ�ٰ� ó���ϰ� �ʹٸ� 1
		// o1 ��ü�� o2��ü�� ũ�Ⱑ ���ٰ� ó���ϰ� ������ 0
		int c = o1.compareTo(o2);
		int r =  c < 0 ? -1 : (c > 0 ? 1 : 0);
		return r;
	}
}

//=============================================
class ParseComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int n1 = Integer.parseInt(o1, 2);
		int n2 = Integer.parseInt(o2, 2);
		
		if (n1 < n2)
			return -1;
		else if (n1 > n2)
			return 1;
		else
			return 0;

	}

}

//=============================================
public class Source11_List {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("11");
		li.add("101");
		li.add("10");
		li.add("100");
		li.add("110");
		li.add("1001");
		li.add("111");
		System.out.println(li.toString());
		System.out.println("contains? " + li.contains("101")); // true
		String data = new String("10");
		System.out.println("contains? " + li.contains(data)); // true
		// List �迭�� contains �� indexOf ��ü �Ǻ��Ҷ� equals �� ����Ѵ�.
		System.out.println("indexOf.. " + li.indexOf(data));
		System.out.println(li.get(2) == data);
		System.out.println(li.get(2).equals(data));
		// List�ȿ� ����� ��ü�� ������ ��ų���� �ִµ�, ��ü��ü�� compareTo�� ���Ǵ°� �ƴ϶�,
		// ũ��񱳸� �� ��ü�� �����ؼ� �Ѱ���� �Ѵ�.
		// ���� ���, String ��ü���� ����ִ� List�� Ư���������� ������ �ϰ� �ʹٸ�
		Comparator<String> c = new CustomComparator();
		li.sort(c);
		// li.sort(new CustomComparator() );
		for (int idx = 0; idx < li.size(); idx++) {
			String m = li.get(idx);
			System.out.println("��" + m + " / " + Integer.parseInt(m, 2));
		}

		Comparator<String> b = new ParseComparator();
		li.sort(b);
		for (Iterator<String> i = li.iterator(); i.hasNext();) {
			String d = i.next();
			System.out.println("��" + d + " / " + Integer.parseInt(d, 2));
		}

	}
}
