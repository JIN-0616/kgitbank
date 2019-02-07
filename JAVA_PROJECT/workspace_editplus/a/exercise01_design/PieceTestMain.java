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
			King 객체 : checkMove , 이동시키고자 하는 좌표가 현재좌표하고 비교했을때
					x차가 1이하고 y차가 1이하기만 하면 됨.
			Bishop 객체 : x차하고 y차 같으면 된다.
			
			Queen 객체 : Rook이랑 Bishop 의 룰을 다 갖는다

			Knight 객체 : 이동가능한 곳의 x차, y차 를 생각해보면 된다.

			Pawn 객체 : 무조건 흰색은 위로만 가고, 검은색은 아래로만 간다. 
			기본이 1칸씩이지만, 스타트지점에 있는 경우에 한해서만 2칸이 이동 가능하다.
		*/
	}
}
