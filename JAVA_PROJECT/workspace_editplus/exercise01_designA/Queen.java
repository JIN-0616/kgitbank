class Queen extends Piece {
	Queen(int x, int y, boolean flag){
		super(x,y,flag);
	}
	String shape(){
		return "¨Ý";
	}
	boolean checkMove(int dx, int dy){
		if( (dx == this.x && dy != this.y) || (dy == super.y && dx != x) 
				|| (super.x-super.y == dx-dy || super.x+super.y == dx+dy))
			return true;
		else
			return false;
	}
}

