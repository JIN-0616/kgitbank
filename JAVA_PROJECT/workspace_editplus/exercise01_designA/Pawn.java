class Pawn extends Piece {
	Pawn(int x, int y, boolean flag){
		super(x,y,flag);
	}
	String shape(){
		return "ⓟ";
	}
	boolean checkMove(int dx, int dy){
		if(dx==this.x) {
			if(whiteFlag) {
				if(this.y==6 &&(dy==this.y-1||dy==this.y-2)) {				
					return true;				
				}else if(dy==this.y-1) 
					return true;			
			}else {
				if(this.y==1 && (dy==this.y+1||dy==this.y+2)) {
					return true;
				}else if(dy==this.y+1)
					return true;
			}
		}
		return false;
		
		/*
			흰색이 아래라인이라고 가정
			-다른방법1

		if(dx == this.x) {
			if(whiteFlag) {
				if(y == 6 && (dy == 5 || dy == 4) )
					return true;
				else {
					if(dy == this.y -1)
						return true;
					else
						return false;
				}
			}else {
				if(y == 1 && (dy == 2 || dy == 3) )
					return true;
				else {
					if(dy == this.y + 1)
						return true;
					else
						return false;
				}
			}
		} else {
			return false;
		}
		*/

		/*	-다른방법2

		if(!whiteFlag){
			if(dx==x && y==1 && dy-y==2 || dx==x && dy-y==1)
				return true;
			else 
				return false;
		}else{
			if(dx==x && y==6 && y-dy==2 ||dx==x && y-dy==1)
				return true;
			else 
				return false;
		}	

		*/

	}
}
