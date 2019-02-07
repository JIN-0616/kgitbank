


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
 * ���ڿ� ������ �Ϸ��� ��, {String}
 * 	List�� Map�� ��� ó���Ϸ��� ��
 */
public class Exercise06_Management {
	public static void main(String[] args) {
		Map<String, List<String>> groups = new TreeMap<>();
		
		//-------���� �Է¹��----------------
		List<String> list = new ArrayList<>();
			list.add("����");list.add("����");			
		groups.put("��������",list);
		
		groups.put("��", new ArrayList<>());
		groups.get("��").add("¡��");
		List<String> got = groups.get("��");
		got.add("Ǫ��");
		//-------------------------------------
	//	System.out.println(groups.toString());
		
		Scanner cin = new Scanner(System.in);
		
		Set<Entry<String, List<String>>> all = groups.entrySet();
		
		while (true) {
			System.out.print("SYSTEM> ");
			String cmd = cin.nextLine();
			String[] ar = cmd.split(" "); //cmd �Է¹�� ���� - �ϰ�Line��ɾ�imput
			System.out.println(ar[0]+" / "+ar.length);
			switch(ar[0]) {
			case "����":
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					
					boolean getVal = e.getValue().contains(ar[1]);
					boolean getKey = e.getKey().equals(ar[2]);
					boolean a = groups.containsKey(ar[2]);
					
					if(getVal && getKey) {
						e.getValue().remove(ar[1]);
						e.getValue().add(ar[1]);
						System.out.println("SYSTEM> ���Է�");
					}if(!getVal && getKey) {
						e.getValue().add(ar[1]);
						System.out.println("SYSTEM> �ű��Է�");
					}if (!getVal && !getKey && !a) {
						groups.put(ar[2], new ArrayList<>());
						groups.get(ar[2]).add(ar[1]);
					}
				}
				
//				if(groups.containsValue(ar[2])){
//					//�̸� �Է�
//				}else {
//					//�׷� ����(���)
//					groups.put(ar[1], new ArrayList<>());
//					//�̸� �Է�(���)
//					groups.get(ar[1]).add(ar[2]);
//				}
				break;
			case "����":
				//contains Ȯ��
				//Ȯ���� remove
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					if(e.getValue().contains(ar[1])) {
						e.getValue().remove(ar[1]);
					}
				}
//				if(groups.keySet().contains(ar[1])) {
//					if(groups.get(ar[1]).contains(ar[2])) {
//						groups.get(ar[1]).remove(ar[2]);
//						System.out.println(ar[2]+" ����");						
//					}else {
//						System.out.println(ar[2]+" missing error");
//					}
//				}else {
//					System.out.println(ar[1]+" missing error");
//				}
				break;
			case "Ȯ��":
				//contains Ȯ��
				//check �׷�
				//��¹� �ۼ�
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					if(e.getValue().contains(ar[1])) {
						 String key = e.getKey();
						 System.out.println("("+ar[1]+" ��/�� "+key+"����/�� ��ϵǾ��ֽ��ϴ�.");
					}
					
				}				
				break;
					

			case "��ü":	
				//entrySet ó��
				//���ο��� ó��
				//��¹� �ۼ�
				int sum=0;
				for (Entry<String, List<String>> a : all) {
					System.out.println(a);
					sum += a.getValue().size();
				}
				System.out.println("�� �ο��� : "+sum);
				break;
			default:
				System.out.println(" Error");				
			}
		}
		/* <����޴�>
		 *    �Է¹�� : ���� �̸� �Ҽ�
		 * 		     ex) ���� ���� ��������
		 *    (��������, �̸��� �����ؾ� ��)
		 *	 		   ���� ¡�� �������� /
		 * 		 	   ������ �� ���ڿ��� ��򰡿� list�� ��ϵǾ������� ����ó��
		 *    (���ο� �׷��� list�� ���� ���� ���ڿ� ����)
		 *  	     ex) ���� ��ũ�� �����Ӹ�	
		 * 
		 * <�����޴�>
		 *     ���� ���� - ã�Ƽ� ����
		 *  
		 * <Ȯ�θ޴�> 
		 *     Ȯ�� ¡�� : (¡�� ��/�� �������ڷ� ��ϵǾ��ֽ��ϴ�.)
		 * 
		 *   +  <��ü> : ��� �̸� ��� (entrySet�� ������)  
		 * 				+�� �ο��� ���
		 */
	}
}
