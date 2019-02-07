package sample;
/*
 * 2차원 평면상의 좌표관리 객체
 */
public class Coord {
	int x;
	int y;
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;		
	}
	@Override //오버라이드 확인
	public String toString(){
		return "[x="+x+",y="+y+"]";
	}
	
	//#####자주 사용되는 패턴#########################
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coord) {
			Coord other = (Coord)obj;
			return this.x == other.x && y ==other.y;
		}else {
			return false;
		}
	}	
	//################################################
	public boolean isDuplicated(Coord other) {
		if (this.x == other.x && y ==other.y)
			return true;
		else
			return false;
	}
	//이걸 직접 바로 equals에 적용하면 Object 타입으로 받는데
	//상위타입으로 적용하므로 x,y 적용이 안됨
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}
}	//가비지컬렉션 돌아갈때 사용됨.
