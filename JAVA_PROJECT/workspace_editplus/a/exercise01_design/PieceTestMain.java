class PieceTestMain {
	public static void main(String[] args) 	{

		PieceTestEngine pte = new PieceTestEngine();



		Rook pp = new Rook(3, 4, false);
		pte.changePiece(pp);
		pte.execute();

		Piece bp = new Bishop();
		pte.changePiece(bp);
		pte.execute();

		Knight n = new Knight();
		pte.changePiece(n);
		pte.execute();

		Pawn pa = new Pawn();
		pte.changePiece(pa);
		pte.execute();
		/*
			King ��ü : checkMove , �̵���Ű���� �ϴ� ��ǥ�� ������ǥ�ϰ� ��������
					x���� 1���ϰ� y���� 1���ϱ⸸ �ϸ� ��.
			Bishop ��ü : x���ϰ� y�� ������ �ȴ�.
			
			Queen ��ü : Rook�̶� Bishop �� ���� �� ���´�

			Knight ��ü : �̵������� ���� x��, y�� �� �����غ��� �ȴ�.

			Pawn ��ü : ������ ����� ���θ� ����, �������� �Ʒ��θ� ����. 
			�⺻�� 1ĭ��������, ��ŸƮ������ �ִ� ��쿡 ���ؼ��� 2ĭ�� �̵� �����ϴ�.
		*/
	}
}
