class Knight extends Piece {
	
	String shape() {
		return "��";
	}

	boolean checkMove(int dx, int dy) {
		// x��=2 y��=1  or  x��=1 y��=2
		int gx = this.x - dx;
		if(gx < 0 )
			gx *= -1;
		int gy = this.y > dy ? this.y - dy : dy- this.y;
		if( (gx ==2 && gy==1)  ||  (gx==1 && gy == 2) ) 
			return true;
		else
			return false;
	}

}
