class Bishop extends Piece {
	

	String shape() {
		return "¨Î";	
	}
	boolean checkMove(int dx, int dy) {
		int gx = this.x - dx;
		if(gx < 0 )
			gx *= -1;
		int gy = this.y > dy ? this.y - dy : dy- this.y;
		
		return gx == gy;

	}
}
