class PieceTestMain {
	public static void main(String[] args)	{
		Piece p = new Piece(3,3,true);
		PieceTestEngine pte = new PieceTestEngine(p);
		
		pte.execute();

		Piece pp = new Rook(3,4,false);
		pte.changePiece(pp);
		pte.execute();
		// 가능
		King k = new King(5,4,false);
		pte.changePiece(k);
		pte.execute();
		
		/*
			King 객체 : cheakMove , 이동시키고자 하는 좌표가 현재좌표하고 비교했을때
						x차가 1이하고, y차가 1이하기만 하면 됨.

			Bishop 객체 : x차하고 y차가 같으면 된다.

			Queen 객체 : Rock이랑 Bishop의 룰을 다 갖는다.

			Knight 객체 : ~~ 대충 알아서 해봐라
						  이동가능한 곳의 x차, y차를 생각해보면 된다.

			Pawn 객체 : 제일 지저분
						무조건 흰색은 위로만 가고, 검은색은 아래로만 간다.
						기본이 1칸씩이지만, 스타트지점에 있는 경우에 한해서만 2칸이 이동가능하다.
		*/

		/*
		(0,0)(1,0)(2,0)(3,0)(4,0)(5,0)(6,0)(7,0)

		(0,1)(1,1)(2,1)(3,1)(4,1)(5,1)(6,1)(7,1)

		(0,2)(1,2)(2,2)(3,2)(4,2)(5,2)(6,2)(7,2)

		(0,3)(1,3)(2,3)(3,3)(4,3)(5,3)(6,3)(7,3)

		(0,4)(1,4)(2,4)(3,4)(4,4)(5,4)(6,4)(7,4)

		(0,5)(1,5)(2,5)(3,5)(4,5)(5,5)(6,5)(7,5)

		(0,6)(1,6)(2,6)(3,6)(4,6)(5,6)(6,6)(7,6)

		(0,7)(1,7)(2,7)(3,7)(4,7)(5,7)(6,7)(7,7)	 
		
		*/
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				System.out.print("("+x+","+y+")");
			}
			System.out.println("");
		}	
	}
}
