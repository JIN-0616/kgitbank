class Bishop extends Piece {
	Bishop(int x, int y, boolean flag){
		super(x,y,flag);
	}
	String shape(){
		return "ⓑ";
	}
	boolean checkMove(int dx, int dy){
		if(super.x-super.y == dx-dy || super.x+super.y == dx+dy) {
			return true;
		}else {
			return false;
		}
		/*
			int gx = this.x -dx;
			if(gx <0)
				gx *= -1;
			int gy = this.y > dy ? this.y - dy : dy - this.y;

			return gx == gy;
			// 식이 true, false로 나가게 됨
		*/

	}
}
