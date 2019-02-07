import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Source14_Map {
	public static void main(String[] args) {
		Map<Integer, String[]> map = new TreeMap<>();
		/*
		 * �̾ȿ� ���尴ü�� �����Ҷ�, 
		 * put, remove, get �� ������ ���� put����, remove�� �Ȱ��� Ȯ���Ϸ��� ���Ϲ���� ������ �ȴ�.
		 * ó������� ���Ÿ������ �߻��Ѵ�. ������ �ִ��ְ� ����. �� ��ü�� ���� �Ǵ��Ҽ� �ִ�.
		 * 
		 * �ƴϸ�, boolean containsKey(Key) Ư��Ű�� ���ǰ� �ִ����� Ȯ���� �Ҽ� �ִ�.
		 * put �ϱ� ���� üũ�ؼ� ������ ����put, ������ ����
		 * get �ϱ� ���� üũ�ؼ� ������ ��ϰ�ü ���°�, �ƴ� �ְ�
		 * remove �ϱ� ���� üũ�ؼ� ������ ���� ����, ������ ����
		 */
		String[] a = map.put(2, new String[] {Integer.toString(2, 2), "��", "�", "two"} );
		System.out.println(a ==  null);
		String[] ab = map.put(2, new String[] {Integer.toString(2, 2), "��", "�", "two"} );
		System.out.println(ab ==  null);
		map.put(12, new String[] {Integer.toString(12, 2), "����", "��", "twelve"} );
		map.put(21, new String[] {Integer.toString(21, 2),"�����ϳ�", "�", "two"} );
		map.put(9, new String[] {Integer.toString(9, 2), "��ȩ", "��", "nine"} );// �� ������ ctrl
		// 1~99 ���̿� ���ڸ� Ű�� �ؼ� �װ� ǥ���ϴ� ���ڿ��迭�� 2~3�� ������ put
		Integer key = 11;
		String[] obt = map.get(key);
		if(obt == null) {
		}else {
			System.out.println(key+ "�� Ű�� �ϴ� String[] ");
			for(String m : obt) {
				System.out.println("��" + m);
			}
		}
		String[] abc = map.remove(1);
		System.out.println(abc);
		System.out.println("contains = " + map.containsKey(1));
		/*
		 * containsKey�� ����ϰ� containsValue �� �ִ�.
		 * 
		 */
		boolean f = map.containsValue(new String[] {Integer.toString(21, 2),"�����ϳ�", "�", "two"} );
			// equals ������ ����·� ���ִ� ��ü�Ŀ� ����, ��ü���� �޶� true �� ���ü��� �ִ�.
			// cf# containsKey �� �Map�� ���Ŀ� ���� ��ü���� �޶� ���ϰ�ü�� �ǴܵǼ� true�� ���´�. 
		System.out.println(f);
		
		// Map�� ���� �����Ǵ� ��� ��ü�� Ȯ���غ����� �ϸ�, keySet()�� ����, Ű �ݺ�ó���ϸ鼭 ��ü���� Ȯ��
		Set<Integer> k = map.keySet();
		System.out.println(k);
		for(Integer i : k) {	// for(Integer i :  map.keySet())
			System.out.println(i + "..." +map.get(i));
		}
		
		// �Ű�� �����ִ����� ���� �ǰ�, ��ü�鸸 �� ����ϰ� ������
		Collection<String[]> vs = map.values();
		System.out.println((vs instanceof Queue) +" ?");
		for(String[] c : vs) {		// for(String[] c : map.values())
			System.out.println(c);
		}
		System.out.println(map.toString());
		// entrySet()
		// Entry�� ���ʸ��κ� ������ Map�̶����� ����
		Set<Entry<Integer, String[]> > eset  =  map.entrySet();
		for(Entry<Integer, String[]> e : eset) {
			System.out.println("�� " + e);
			Integer ek =e.getKey();
			String[] ar = e.getValue();
		}
	}
}
