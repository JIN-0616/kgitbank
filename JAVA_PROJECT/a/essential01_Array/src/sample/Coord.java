package sample;

/*
 *  2차원평면상의 좌표관리 객체
 * 
 */
public class Coord {
	int x;
	int y;

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[x=" + x + ",y=" + y + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coord) {
			Coord other = (Coord) obj;
			return this.x == other.x && y == other.y;
		} else {
			return false;
		}
	}
	
	public boolean isDuplicated(Coord other) {
		if (this.x == other.x && y == other.y)
			return true;
		else
			return false;
	}

	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}
	
	
}








