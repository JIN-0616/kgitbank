package Collection;
/*
	2. Map�� ��ȯ
	
	Iterator <------------- Set <-------------- Map
		iterator 		 entrySet():Ű�� ���� ���� �ѱ�
	
	��ȯ�� ���� ����(�ϳ��� �׸� ����)
	it.next()------>Map.Entry----->getKey(), getValue()
	
	Ű ----> set
	keySet();
	
*/
import java.util.*;
public class Chap13_8_Map {
	public static void main(String[] args) {
		HashMap map = new HashMap();
			map.put("�嵿��", 80);
			map.put("�۽���", 70);
			map.put("����", 90);
			map.put("�̺���", 60);
			map.put("����", 50);
		
		// Iterator <-- Set <-- Map
		// Set set = map.entrySet();
		// Iterator it = set.Iterator();
		
		Iterator it = map.entrySet().iterator();	//�ѹ��� ���� ����
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();			
			//Map.Entry �������̽�
			System.out.println("����:"+e.getKey()+"\n����:"+e.getValue());
		}
		
		// Ű---->set
		Set setkey = map.keySet();
		System.out.println("�����ڸ��: "+setkey);
		
		// ��(value) ---> Collection
		Collection cc =map.values();
		Iterator ccit = cc.iterator();
		
		System.out.println("�� ��: " );
		int tot=0;
		while (ccit.hasNext()) {
			int aa = (Integer)ccit.next();
			System.out.println(aa+"\n");
			tot+=aa;			
		}
		System.out.println();
		System.out.println("����:" + tot);
		System.out.println("�ְ�����:"+Collections.max(cc));
		System.out.println("��������:"+Collections.min(cc));
		
	}
}
/*
����:����
����:50
����:�嵿��
����:80
����:�۽���
����:70
����:�̺���
����:60
�����ڸ��: [����, �嵿��, �۽���, �̺���]
�� ��: 
50

80

70

60


����:260
�ְ�����:80
��������:50
*/