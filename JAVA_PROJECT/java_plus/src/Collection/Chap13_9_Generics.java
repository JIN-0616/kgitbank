package Collection;
/*
	4. Generics
	collection ��ü���� object�� ó���ǹǷ� ����ȯ�� ���� �߻�
	
	Generics 
	  - ���� ������ �� : ��ü���� �����ϴ� �������� ������ ����
	  - Ÿ�� �������� ����
	  - Ÿ��üũ�� ����ȯ�� �����Ǿ� �ڵ尡 ����
	  - list, set, map �� ����
	  - ����� <Ÿ��> ���·� ����
	  - �޼ҵ��� ��� �÷����� ������±��� ����ؾ� ��
	    ex) List<Ÿ��> ����Ʈ�� = new List<Ÿ��>();	     
*/

import java.util.ArrayList;
import java.util.Iterator;

class Product{}

class Tv extends Product{}

class bed{}

public class Chap13_9_Generics {
	
	static void meth_1(ArrayList ar) { }
	
	static void meth_2(ArrayList<Product> ar) { }
	
	static void meth_3(ArrayList<Tv> ar) { }
	
	static void meth_4(ArrayList<? extends Product> ar) { }
	// ��Ӱ����� ���·� ���ʸ��� ����
	
	public static void main(String[] args) {
		ArrayList l1 = new ArrayList<>();	// �Ϲ� ����Ʈ
			l1.add(new Product());
			l1.add(new Tv());
			l1.add(new bed());
			l1.add("ħ��� ������ �Ƴ�");  	// ��� Object�� �߰������� - ���� ������ ����			
		System.out.println(l1);
		
		ArrayList<Product> l2 = new ArrayList<Product>(); // Generic�� �̿��Ͽ� ������ ��
			l2.add(new Product());
			l2.add(new Tv());				// Ŭ������ ���������� �߰� ����
		//	l2.add(new Bed());				// �߰� �Ұ�
		//	l2.add("ħ��� ������ �Ƴ�");	// �߰� �Ұ�
			
		ArrayList<Tv> l3 = new ArrayList<Tv>();
		//	l3.add(new Product());			// �߰� �Ұ�
			l3.add(new Tv());
			
		meth_1(l1);
		meth_1(l2);
		meth_1(l3);
		
		meth_2(l1);
		meth_2(l2);
		//meth_2(l3);	//��Ӱ���δ� �μ� ���� �Ұ�
		
		meth_3(l1);
		//meth_3(l2); 	//��Ӱ���δ� �μ� ���� �Ұ�
		meth_3(l3);
		
		meth_4(l1);
		meth_4(l2);
		meth_4(l3);
		
		
		Iterator it = l2.iterator();
		while(it.hasNext()) {
			Product data = (Product)it.next();
		}
		
		// ---------------------------------------
		
		Iterator<Product> git = l2.iterator();
		// git = l3.iterator();
		while (git.hasNext()) {
			Product data = git.next();			
		}
				
		// ---------------------------------------

		Iterator<Tv> tvit = l3.iterator();
		//tvit = l2.iterator();
		while (tvit.hasNext()) {
			Product data = tvit.next();			
		}
		
		// ---------------------------------------
		
		Iterator<? extends Product> exit = l2.iterator(); //Iterator ���� ��Ӱ���� ���ʸ��� ����
		exit = l3.iterator();
		while (exit.hasNext()) {
			Product data = exit.next();			
		}
		
	}
}
