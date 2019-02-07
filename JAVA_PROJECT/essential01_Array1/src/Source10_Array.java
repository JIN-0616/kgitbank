
import sample.Coord;

public class Source10_Array {
	static Coord[] makeCoord() {
		Coord[] cs = new Coord[10];
		cs[0] = new Coord(0,0);
		cs[1] = new Coord(0,0);		
		for(int idx=2;idx<cs.length;idx++) {
			int x = (int)(Math.random()*4);	
			int y = (int)(Math.random()*4);
			cs[idx] = new Coord(x,y);
		}
		return cs;
	}
	public static void main(String[] args) {
		Coord[] box = makeCoord();
		for(int i=0;i<box.length;i++) {
			System.out.println(i+" : "+box[i].toString());
		}
		System.out.println(box[0]== box[1]); //false
		// 객체변수 == 으로 비교는 같은 객체인지를 확인
		
		System.out.println(box[0].equals(box[1])); //true
		// 원래는 위와 동일한 같은객체비교이나 우리는 Override해놨음
		
		// 10개 좌표중 중복은 1개로 처리하고 몇개의 좌표를 확보중인가?
		// homework
		
		int count=0;
		int cnt=0;
		String[] a = new String[10];
		for (int i = 0; i < box.length; i++) {
			for (int j = i+1; j < box.length; j++) {
				if(box[i].equals(box[j])){
					System.out.println(i+","+j);
					a[j] = String.valueOf(j);
					count++;					
				}
			}		
		}
		System.out.println("중복좌표수 = "+count);
		System.out.println("중복처리 좌표리스트index :");
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null) {				
				cnt++;
			}else {
				System.out.print(a[i]+" ");
			}			
		}
		System.out.println("");
		System.out.println("중복제외 좌표리스트 :");
		for (int i = 0; i < box.length; i++) {
			if (a[i] == null) {
				System.out.println(i+" : "+box[i].toString());			
			}
		}
		System.out.println("중복제외 좌표수 = "+cnt);
		
		//another ##########################################################
		int ct = 0;
		for (int i = 0; i < box.length; i++) {
			Coord pick = box[i];
			System.out.println(i+"th Coord "+ pick);
			for (int srch = 0; srch < box.length; srch++) {
				Coord cmp = box[srch];
				System.out.println("  vs  " +srch+"'s coord : "+ cmp+" / "+pick.equals(cmp) );
				//if(srch == i)//(or srch = i+1)
				//	continue;
				if(pick.equals(box[srch])) {
					System.out.println(" FInd Duplicate Coord");
					//System.out.println("find duplicate Coord at"+srch+" : "+box[srch].toString());
					ct++;
					break;
				}
			}
		}
		System.out.println("duplicated cnt = "+cnt);
		System.out.println("cnt = "+(10-cnt));
		System.out.println("================1st end==============");

		//another ##########################################################
		int ct2 = 0;
		for (int i = 0; i < box.length; i++) {
			Coord pick = box[i];
			System.out.println(i+"th Coord "+ pick);
			for (int srch = 0; srch < i; srch++) {
				Coord cmp = box[srch];
				System.out.println("  vs  " +srch+"'s coord : "+ cmp+" / "+pick.equals(cmp) );
				//if(srch == i)//(or srch = i+1)
				//	continue;
				if(pick.equals(box[srch])) {
					System.out.println(" FInd Duplicate Coord");
					//System.out.println("find duplicate Coord at"+srch+" : "+box[srch].toString());
					ct2++;
					break;
				}
			}
		}
		System.out.println("duplicated cnt = "+cnt);
		System.out.println("cnt = "+(10-cnt));
		System.out.println("================2nd end==============");
		
		//another방법 #######################################################
		
		boolean[] rst = new boolean[box.length];
	}
}
