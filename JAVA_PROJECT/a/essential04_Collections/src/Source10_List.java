import java.util.List;
import java.util.Vector;

/*
 * Set �� �÷����� ���캸�Ҵµ�, 
 *  �� �÷����� �ߺ������͸� �����ϸ鼭 ��ü�� ������� ���ѵ�, 
 *  ���߿� �� ���վȿ��� Ư����ü�� ���̷�Ʈ�� Ȯ���ؼ� ����ϱ� �����.
 *  
 * �̹��� ���캸���� �ϴ� List�� �÷�����
 *  ��ü���� �������شٴ� �� ������, 
 *  �ߺ���ü�� �����ϰ� ���ְ�, 
 *  Ư����ü�� ��ġ�� �˷��ְ�, ��ġ�� �ȴٸ� �ٷ� ��ü�� Ȯ���ؼ� ����Ҽ� �ִ�.
 *  
 * �⺻���� ����� Set�� �÷��ǰ� ����ϴ�.
 */

public class Source10_List {
	public static void main(String[] args) {
		List<String> li;
		//	li = new Vector<>();   (Vector �� �÷����� �����Ǳ������� �ִ� ��ü, �迭���)
		//  li = new ArrayList<>();   (�÷����� �����ϸ鼭, Vector�� �������� �������Ѽ� ������ ��ü, �迭���)

		//  li = new LinkedList<>();  (Vector�ʹ� �ٸ����·� ��ü�� �����ϰ� ����� ��ü - �迭����� �ƴ�)
		//  � Ư¡�� ����� ��ü������ List �� �÷����� ��� �۵��Ǵ����� �˾ƺ��� ���캸��.
		li = new Vector<>();
		System.out.println(li.size());
		System.out.println(li.isEmpty());
		
		String s = "�÷���";
		System.out.println("add = "+ li.add(s));
		System.out.println("contains = "+ li.contains(s));
	//	System.out.println("remove = "+ li.remove(s));
		
		System.out.println("add = "+ li.add(s));	// �ߺ���ü�� ����ǰ� ������ְ�
		System.out.println("add = "+ li.add(s));	//
		System.out.println("add = " +  li.add("collection"));
		System.out.println("add = "+ li.add(s));
	//	li.clear();
		System.out.println("size = " + li.size());	// 
		li.iterator();
		for(String m : li) {
			System.out.println("��" + m);
		}
	//  ���� index ó���� �صּ�, ��ü ��ġ�� ã������ �ְ�
		int idx = li.indexOf("collection");
		System.out.println("idx = " + idx);
	//  ��ġ�� �ȴٸ�, �� ��ġ�� �ش��ϴ� ��ü�� �ٷ� ���������ִ� (index ���� 0���� �������ְ�, 
		String m = li.get(0);	// ������ idx ������ Error �߻�
		System.out.println(m);
	//  ���� index�� ���ؼ� , set, add, remove �� �Ҽ� �ִ�. 
		System.out.println("size = " + li.size());	// 
		li.set(0, "set");
		System.out.println("size = " + li.size());	// 
		System.out.println(li.get(0));
		System.out.println(li.toString());
		li.add(2, "HashSet");
		System.out.println("size = " + li.size());	//
		System.out.println(li.toString());
		li.remove(4);
		System.out.println(li.toString());
		
		// ������ �ִ� �Ϻκ��� List�� ����Ҽ��� �ִ�.
		List<String> sub = li.subList(1, 4);
		System.out.println(sub);
		sub.add(1, "totoro");
		System.out.println(li.toString());

		// ���� index �� ��ȭ�� ���ٸ�, Vector or ArrayList�� ���� ������ ����,
		// �߰�index�� �����Ǿ��ִ� ��ü�� �������ٰų�, �߰��� add�� �Ǵ� ��Ȳ�� ���ٸ� LinkedList �� ������ ����. 
		
	}
}
