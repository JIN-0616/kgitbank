class Pawn extends Piece {
	
	String shape() {
		return "��";
	}

	boolean checkMove(int dx, int dy) {
		// ����� �Ʒ������̶�� ����
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
	}

}
