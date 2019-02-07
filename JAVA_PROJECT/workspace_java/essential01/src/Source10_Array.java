import sample.Coord;

public class Source10_Array {
	static Coord[] makeCoords() {
		Coord[] cs = new Coord[10];
		cs[0] = new Coord(0, 0);
		cs[1] = new Coord(0, 0);
		for(int idx=2; idx <cs.length; idx++) {
			int x = (int)(Math.random()*4);	// -2 ~ 2
			int y = (int)(Math.random()*4);	// -2 ~ 2
			cs[idx] = new Coord(x, y);
		}
		return cs;
	}
	
	public static void main(String[] args) {
		Coord[] box = makeCoords();
		for(int i=0; i<box.length; i++) {
			System.out.println(i+" : " + box[i].toString() );
		}
		System.out.println(box[0] == box[1]);
		System.out.println(box[0].equals(box[1]));
		// 확보된 좌표 10개짜리 묶음에 , 중복된 좌표들은 1개로 카운팅하면,
		// 총 몇개의 좌표가 있는건가.
	}
}
