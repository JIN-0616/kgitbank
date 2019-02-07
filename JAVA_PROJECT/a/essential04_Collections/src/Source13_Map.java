import java.util.HashMap;
import java.util.Map;

/*
 * �÷����� ��ü�� Map �迭�� ���ؼ� ���캸��.
 * 	Map�� �ٸ� �÷���(Set,List,Queue�迭)���� ������ ���� �ٸ���.
 *  �� ��3���� ��ü���� �����ϱ� ���ؼ� add�� ���� �Ѱ��ָ� �����. 
 *  Map�迭�� ��ü���� �ѱ�°� �ƴ϶�, ��ü���� �ο��� Ű���� ���� �����ؼ� ������Ѿ� �ȴ�.
 *  ���߿� ��ü�� ����ų�, �� Ȯ���ؾߵǴ� ��Ȳ�� �ο��ߴ� Ű���� ���ȴ�. 
 *  ����, ��ü�� �����ϸ鼭 Ű�� �����ϴµ�, 
 *  	�� Ű�� �̹� ���ǰ� �־��ٸ�, ���������. (����)
 *  
 *  ��ǥ���� Map �� ��ü�δ� Hashtable, HashMap, TreeMap, LinkedHashMap �� �ִ�.
 *  ������ ���̴� Ű�� ������ �ִ�. 
 */
public class Source13_Map {
	
	public static void main(String[] args) {
		// Ÿ�Լ����� �ΰ����� �ʿ��ϴ�, 
		// �ϳ��� ������ ��üŸ��, �ٸ��ϳ��� Ű�� �� ��üŸ���̴�.
		Map<String, String[]> map = new HashMap<>();
		// <ŰŸ��, ���Ÿ��>
		System.out.println(map.size());		// int size() : �������� ��ü����
		System.out.println(map.isEmpty());	// boolean isEmpty() : �����ϰ� �ִ� ��ü ����?
		
		String[] a = "����,����,�ÿ�,����".split(",");
		// ��ü ������ put
		map.put("f", a);		// ���� Ű��ü, �ڰ� ���尴ü
		map.put("F", a);
		System.out.println(map.size());	
		// �� Ű�� ��ü Ȯ���� ������ ���ȴ�.
		String[] got = map.get("f");
		System.out.println(got +" / " + got[0]);
		String[] got2 = map.get("F");
		System.out.println(got2 + "/ " + got2[1]);
		map.remove("F");	
		// Ű�� ����� �Ű�, �ش� Ű�� ��ϵ� ��ü�� ��� ������ �߻��ϰų� �׷��� �ʴ´�
		String[] got3 = map.get("F");	// Ű�� ��ϵ� ��ü�� ������ null
		System.out.println(got3+"/ " + (got3==null) );
		// System.out.println(got3.length);
		
		String[] b = "����,�Ͽ�,����".split(",");
		map.put("f"  ,b);	// ��ü����� ���� Ű�� put�� �Ǹ� �ٲ��.
		String[] got4 = map.get("f");
		System.out.println(got4[0] );

		map.clear();
		System.out.println(map.isEmpty());
		
		
		
	}
}





