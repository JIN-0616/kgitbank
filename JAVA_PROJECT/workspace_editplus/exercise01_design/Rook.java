class Rook extends Piece {
	Rook(int x, int y, boolean flag){
		super(x,y,flag);
	}
	String shape(){
		return "¨Þ";
	}
	boolean cheakMove(int dx, int dy){
		if( (dx == this.x && dy != this.y) || (dx != super.y && dx != x) )
			return true;
		else
			return false;

	}
}
