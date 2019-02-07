class Rook extends Piece {
	
	Rook(int x, int y, boolean flag ) {
		super(x, y, flag);
	}

	String shape() {
		return "¨Þ";
	}

	boolean checkMove(int dx, int dy) {
		if( (dx == this.x && dy != this.y)  ||  (dy == super.y && dx != x) )
			return true;
		else
			return false;
	}
}
