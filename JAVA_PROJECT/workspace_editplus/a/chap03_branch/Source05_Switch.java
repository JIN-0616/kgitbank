class Source05_Switch {
	public static void main(String[] args) {
		/*
			switch - case ����
			 : ����ó�����ٴ� Ư�������� ������ branch �� �����µ� ����
			 : ó�����Ǵ� �����͵��� int,char,String, (���캸�� ���� enum ����)
			 : �ش� case �۾��� ����Ǵ°� �ƴϱ⿡ break �� ��� �Ҽ��� �ִ�.
			 : ���� ���̽� �����̳�, ���� ���̽��� ��� �����Ҽ� ����.
			 : if�� branch ���鶧�ʹ� �ٸ��� case ���� ������ ���� �Ҵ���� �ʴ´�.
		*/
		int d = (int)(Math.random()*4);
		switch(d){
		case 1:
			double e = Math.random();
	
			break;
			// case 3, 4:
		case 3:
		case 4:
		//	String e =  "switch branch";
		//  case 1:
		}
		System.out.println("e == "+e);
		/*
			if ~ else �� ������ branch �ȿ���  switch case �� �̿��ؼ� �ش� branch �� ����ȭ����
			switch -case�� ó���ص� branch �ȿ��� if ~else �� �̿��ؼ� �ش� case ����ȭ����
		*/

	}
}
