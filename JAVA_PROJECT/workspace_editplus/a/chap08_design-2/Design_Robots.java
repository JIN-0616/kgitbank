/*
	Extenstion (Ȯ��/���)
	: ��ü�� �����Ҷ�, �̹� ������� ��ü�� �̿��ؼ� �߰� �����Ҽ� �ְ� Ȯ���̶�°� �����ϰ� �ִ�. 
	
	Extenstion�� ����..?
	 1. �������� ���� - (Starcraft �������ο� ���Դ� Marine , Ȯ���ǿ��� ���Դ� Marine)
	 2. �����ؾߵ� ��ü�� ������ �������� �����ؼ� �ϳ��� �����ΰ�, 
		�������� �� Ȯ����� �߰��κи� ���������ν� ������ ��ü�� �����Ҽ� ����.
		(
	 3. 
*/
class Android extends Robot {
	int happiness;
	Android(String n, int t, int h) {
		this.name = n;
		type = t;
		happiness = h;
	}
	boolean doCleaning() {
		if(this.happiness >= 10) {
			happiness -=10;
			return true;
		}else {
			return false;
		}
	}
	String tell() {
		if(happiness >=30) {
			String m = greet();
			return m;
		}else {
			return name+".....�Դϴ�...";
		}
	}

}
