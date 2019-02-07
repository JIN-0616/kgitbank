class King extends Piece {
	King(int x, int y, boolean flag){
		super(x,y,flag);
	}
	String shape(){
		return "¨×";
	}
	boolean checkMove(int dx, int dy){
		
		int xp = (dx-super.x<0)? (-1*(dx-super.x)):(dx-super.x);
		int yp = (dy-super.y<0)? (-1*(dy-super.y)):(dy-super.y);

		if (xp <=1 && yp <=1){
			return true;	
		}else{
			return false;
		}
		
		
		

	}
}
