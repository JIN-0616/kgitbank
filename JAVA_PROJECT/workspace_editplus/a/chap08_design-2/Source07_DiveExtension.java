class Stone {
	int x, y;
	Stone(int x, int y){
		this.x = x;
		this.y = y;
	}
	void move(int nx, int ny) {
		System.out.println("Stone.move()");
		x = nx;
		y = ny;
	}
	String inform() {
		return "(x="+x+ ", y=" +y+")";
	}
	// �̰� ���� �� ����� �ִٰ� �����ϰ�... �� ��ü�� �������� �������.
	// �ð��� ������ �������� �ؾߵǴ� ��Ȳ��.
}
//=========================================================
class MemoryStone extends Stone {	// ����ȸ���� ����ϴ� Stone
	int cnt;
	MemoryStone(int x, int y) {
		super(x, y);
	}
	void memoryMove(int nx, int ny) {	
		cnt++;
		super.move(nx, ny);
	}
	// extends �ɰ� �����ϸ鼭 ���� ���·� �Լ��� �����ϸ� �� ��ü�� ����Ҷ� ���� ����� ���������
	// ���� �ٽ� ������ ������� �۵��ϰ� �ǰ� �ȴ�. 
	// �Լ� �缳�踦 ���ؼ� ��������� �������� �Ǹ� �׷��� super�� �����ؾߵȴ�.
	// extends �� �ɰ� �����ϴ� �ʿ��� ������ �Լ��� ���������(�缳��) �ϴ°� override ��� �θ���.
	// �ڹٴ� �̰� �����Ѵ�. -
	// ������ �ÿ��� ���� �͵鿡 ���ؼ��� �����ϰ�, access�� �ּ��� �����ؾ߸� �Ѵ�.
	// ������ �ٸ��� �������̵尡 �ƴϴ�.
	public void move(int nx, int ny) {	
		System.out.println("MemoryStone.move()");
		cnt++;
		super.move(nx, ny);
	}
	String inform() {
		return "�̵�ȸ��:"+cnt+",������ġ:" +super.inform();
	}
}
/*
	����� �߰��ؼ� �����ص� ������, 
	���� ����� �ٲ㼭 �����ϴ°͵� �����ϰ� (�۵��Ǹ� �ȵǴ°͵��� �������صδ�) �̷��� ������
	�̰�ü�� �����ؼ� �Լ� ���� �ϰ� �Ǹ�, ������ ����� �۵���Ű�°� ������ �۵��ǰ� �ȴ�.
*/
//=========================================================
class Source07_DiveExtension {
	public static void main(String[] args) {
		MemoryStone ms;
		ms = new MemoryStone(5, 2);

		ms.move(4, 5);
		ms.memoryMove(5, 6);
		System.out.println(ms.inform());
		System.out.println(ms.cnt);
		// �������̵尡 ���� ȿ���� ���°� �������� �¹��������̴�.

		Stone s = new MemoryStone(0, 0);	//  ���� Ÿ������ �̰�ü�� �����ϴ���
		s.move(5, 5);	// �۵��ϴ°� MemoryStone ��ü�̱� ������
		System.out.println(s.inform());	// �� ��ü�� ������ ������ �ִ� �Լ��� �۵��� �ϰ� �ȴ�.
		
		/*
			s ��� ������ ��� �Ǵ� ��ü�� Stone ��üŸ������ �νĵǼ� ���Ǽ�
			Stone ��ü�� ��������� ������ ������ ��ɵ鸸�� ȣ���Ҽ� ����.
		*/
		s.memoryMove(4, 5);	// �̰� ����� ����. 
		// �װͶ����� ����� ���鶧 �������̵带 �ؼ� �����ߵǴ� ��Ȳ�� �����.

	/*	
		Stone s = new Stone(1, 1);
		System.out.println(s.inform());
		s.move(3, 5);
		System.out.println(s.inform());
	*/
	}
}
