class Source04_Switch {
	public static void main(String[] args) {
		/*
			������ó���������� branch �۾��� �ʿ��Ҷ� ����Ҽ� �ִ� ��������
			switch -case ��°͵� �����Ѵ�.

			if ~ else : �����Ϳ� ���¿� ���� branch �۾�
			switch - case  : ������ ���� ���� branch ó��
				/ int,char �� ������ , String ������, enum �����Ϳ��� ��밡��
		*/
		int d = 3;		
		System.out.println("d == " + d +" / switch branch start");
		// switch(�����͸� ����ִ� ����)
		switch(d) {
		case 6 :
		case 5 :
			System.out.println("case..5 handle");
			System.out.println("case..5 handle");
			System.out.println("case..5 handle");
			break;
		case 3 :
			System.out.println("case..3 handle");
			System.out.println("case..3 handle");
		default :
			System.out.println("default handle");
		}
		System.out.println("switch branch end");
		/*
			�ش� case �� �۵��ϴ°� �ƴ϶�, �ش� case���� ������ �ȴ�.
			default �� case ó�� �ȵ� �����Ͱ��϶� �۵�.
			�ش� ���̽��� �۵���Ű�� �ʹٸ�, 
			�ٸ� ���̽� �۾��������� break �� �����صθ� �ȴ�.
		*/
		/*
		double r = 3.14;
		switch(r) {

		}
		*/
		String str ="java";	// System.console().readLine();
		switch(str) {
		case "java":
		case "JAVA":
			System.out.println("�ڹ� ���α׷��� JRE�� ���ؼ� �����Ű�� ��ɾ��̴�");
			break;
		case "javac":
		case "JAVAC":
			System.out.println("�ڹ� �ҽ��ڵ带 JDK�� ���ؼ� ���α׷�ȭ ��Ű�� ��ɾ��̴�");
			break;
		}
	
	}
}
