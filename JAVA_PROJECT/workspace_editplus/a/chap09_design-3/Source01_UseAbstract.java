/*
	exer01_���� chess game�� ����µ� �־ �ʿ��� ��ü���� �����غ��Ѵµ�,

	Piece �� ����..? �̰� �����ٸ�..?
	������ �������� ����� ��ü���� �����ϱ� ���ؼ�, �⺻Ʋ�� ���� �뵵�� ������ ��. 
	(Piece ��ü�� ���� �������Ѽ� ����ϰڴ� �̷� �� �ƴϿ���.)

	�̷� �뵵�϶� �ڹٴ� �߻�Ŭ����(abstract ) ������ ���踦 �Ҽ� �ְ� �صξ���.
	�� Ÿ������ ������������ �ش� Ÿ���� ��ü�� ������ ������ �ǰ�,
	���� ����� ��ü���� ����� ȣ���ϱ� ���ؼ� �����ξ��� ���ǹ��� �Լ��������
	abstract ó���صѼ� �ִ�.
*/
abstract class Piece {
	int x;
	int y;
	Piece() {
	}
	Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	void confirm(int dx, int dy) {
		x = dx;
		y = dy;
	}
	abstract boolean check(int dx, int dy);
	abstract String shape();
}
//==================================================================================
class Rook extends Piece {
	String shape() {
		return "��";
	}
	boolean check(int dx, int dy) {
		return dx == dy;
	}
}
//==================================================================================
// �Ϲ� extends ���� �ٸ��� abstract type�� extends �� �ϰ� �Ǹ�,
// �����ʿ��� abstract ó���ص� ��ɵ��� ������ �۵��ɼ� �ְ� �����صξ�߸� �������� �ǰ�,
// ��ü���谡 �ϼ��ȴ�.
class Queen extends Piece {
	String shape() {
		return "��";
	}
	boolean check(int dx, int dy) {
		return dx * dy >=3;
	}
}


//=====================================================================================
class Source01_UseAbstract {
	public static void main(String[] args) 	{
		// Abstract ó���ص� Ÿ���� ��ü���� ������ �Ұ����ϴ�. cannot be instantiated
	//	new Piece();
		Piece p = new Rook();	// ��ü ��� �ϴµ� ������ ����.
		System.out.println(p.shape());
		System.out.println(p.check(3, 3));
	}
}
