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
		System.out.println(box[0] == box[1]);	// 객체변수 == 로 비교는 같은 객체인지 확인
		System.out.println(box[0].equals(box[1]));
		// 확보된 좌표 10개짜리 묶음에 , 중복된 좌표들은 1개로 카운팅하면,
		// 총 몇개의 좌표가 있는건가.
		int cnt2 = 0;
		for(int i=0; i<box.length; i++) {
			Coord pick = box[i];
			System.out.println(i+"'s coord : " + pick);
			if(i==0)
				continue;
			for(int srch = 0 ; srch< i; srch++) {
				Coord cmp = box[srch];
				System.out.println("  vs " + srch+"'s coord : " + cmp + " / " +pick.equals(cmp) );
				if(pick.equals(box[srch])) {
					System.out.println("  Find! duplicate Coord");
					// System.out.println(" At " +srch +" : " +box[srch].toString());		
					cnt2++;
					break;
				}
			}
		}
			
		//=======================================================================
		int cnt = 0;
		for(int i=0; i<box.length; i++) {
			Coord pick = box[i];
			System.out.println(i+"'s coord : " + pick);
			for(int srch = i +1 ; srch<box.length; srch++) {
				Coord cmp = box[srch];
				System.out.println("  vs " + srch+"'s coord : " + cmp + " / " +pick.equals(cmp) );
				if(pick.equals(box[srch])) {
					System.out.println("  Find! duplicate Coord");
					// System.out.println(" At " +srch +" : " +box[srch].toString());		
					cnt++;
					break;
				}
			}
		}
		System.out.println("duplicated CNT = " + cnt + " /  " + (10-cnt));
		System.out.println("duplicated CNT2 = " + cnt2 + " /  " + (10-cnt2));
	}
}


