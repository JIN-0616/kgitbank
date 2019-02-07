/*
	Chess (8 x 8) �� �����ϴµ� �־ ��ü���� ������, �׽�Ʈ�� �غ���.

	- Pawn / Bishop / Knight / Rook / Queen / King 
	- �̰�ü���� �� ���� ���踦 �Ϸ��� �ϴµ�, �������� �κе鵵 �ְ� , ��ɵ鵵 �����Ŵ�.
	�̰� ��ӱ����� �̿��ؼ� �����غ���.
*/
abstract class Piece {
	int x;	// ���� x ��ǥ�� �����ų ����
	int y;	// ���� y ��ǥ�� �����ų ����
	boolean whiteFlag;	// ������� �ƴ����� �����ų ����
	
	Piece() {
		this.x = (int)(Math.random()*8);
		this.y = (int)(Math.random()*8);
		this.whiteFlag = Math.random()>0.5;
	}

	Piece(int x, int y, boolean whiteFlag) {
		this.x = x;
		this.y = y;
		this.whiteFlag = whiteFlag;
	}

	boolean checkMove(int dx, int dy) {	
		// �� ��ü�� x,y�� �������� �ش� ��ǥ�� �̵��������� Ȯ�����ִ� ���	
		// �̱�� ���ǹ��ϰ� �۵���.
		return Math.random()>0.7;
	}

	void confirmMove(int dx, int dy) {
		this.x = dx;
		this.y = dy;
	}

	String shape() {
		// �̱�� ���ǹ��ϰ� �۵���.
		return "not used";
	}
	/*
		checkMove(int, int) , shape()  �� �� ����� �ϴ� ���� �����аǵ�, (� ������ �������� �ʴ´�.)
		�̰� ����� �ȵǰ�, �̷��� �����̶� �����־� �Ǵ� ������ �����ΰ�..?

		���� �� ��ü�� �� ����� ���ٸ�(�����..?)..
	*/
}
