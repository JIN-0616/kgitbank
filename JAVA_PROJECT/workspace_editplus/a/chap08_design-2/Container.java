


import design.Box;

class Container extends Box {
	String str;
	Container() {
//		data = 3;	
		// default access ���� ������, extends�� �ɰ� �����ϱ� ������ ��������� �Ұ�
		flag = true;	
		// protected�� extends �ɰ� ����Ǵ� ��ü���, access�� ����� �ȴ�.
		str ="extension";
		// public �� ���� Ÿ��Ű�������� ������ ���Ǵ� access �ܰ�� ������, access ����
		rate = 0.25;
		System.out.println("container instance created");
	}



}