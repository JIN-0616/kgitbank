
class PieceTestEngine {
	Piece piece;

	PieceTestEngine(){

	}
	PieceTestEngine(Piece p){
		piece = p;
	}
	void changePiece(Piece p){
		piece = p;
	}
	void execute(){
		System.out.println("\n"+piece.getClass());
		for(int ty=0; ty<8; ty++){
			for(int tx=0; tx<8; tx++){
				// tx. ty value가 어떻게 설정되며 반복할지 생각...
				if(piece.x==tx && piece.y==ty) {
					System.out.print(piece.shape());
				}else{
					boolean b = piece.checkMove(tx,ty);
					if(b==true){
						System.out.print("※");
					}else{
						String tile = (tx + ty)%2 ==0 ? "□":"■";
						System.out.print(tile);
					}
				}
			}
			System.out.println("");
		}
	}		
}
