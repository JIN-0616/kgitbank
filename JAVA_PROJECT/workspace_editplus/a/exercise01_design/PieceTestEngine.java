

class PieceTestEngine {
	Piece piece;

	PieceTestEngine(){
	}

	PieceTestEngine(Piece p) {
		piece = p;
	}

	
	void changePiece(Piece p) {
		piece = p;
	}

	void execute() {
		System.out.println("TEST Execute ────────");
		for(int ty = 0; ty <8; ty++) {
			for(int tx=0; tx<8; tx++) {
				// tx, ty 값이 어떻게 설정되며 반복될지 생각..
				if(tx == piece.x && ty == piece.y ) 
					System.out.print(piece.shape());
				else {
					boolean b = piece.checkMove(tx, ty);
					if(b) {
						System.out.print("※");
					}else {
						String tile = (tx +ty)%2 ==0 ?"□":"■";
						System.out.print(tile);
					}
				}
			}
			System.out.println("");
		}
	}
}
