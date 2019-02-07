
public class Source13_ArrayArray {
	static int[] makeRow() {
		int size = 2 + (int)(Math.random()*4);	// 2 ~ 5 
		int[] ar = new int[size];	
		for(int idx=0; idx<ar.length; idx++) {
			int val = (int)Math.pow(size, idx+1);
			ar[idx] = val;
		}
		return ar;
	}
	
	public static void main(String[] args) {
		int[] got = makeRow();
		int t = 0;
		for(int i=0; i<got.length;i++) {
			System.out.println(i+".."+got[i]);
			t += got[i];
		}
		System.out.println("t = " + t);
		//=========================================================
		int[][] multi = new int[5][];
		for(int r=0; r<multi.length; r++) {
			// multi[r] =makeRow();
			int[] tmp = makeRow();
			for(int i=0; i<tmp.length; i++) {
				System.out.print(tmp[i]+ " ");
			}
			multi[r] = tmp;
			System.out.println(" | setting to "+ r );
		}
		//============================================================
		int lengthSum=0;
		int firstSum =0;
		int allSum =0;
		for(int row =0; row<multi.length; row++) {
			int[] each = multi[row];
			lengthSum += each.length;	// multi[row].length;
			for(int col=0; col<each.length;col++) {
				allSum += each[col];	// += multi[row][col];
				if(row == 1) {
					firstSum += each[col];
				}
			}
		}
		
		// multi 에 들어가져있는 int[] 길이의 합
		System.out.println(lengthSum);
		// multi 에 들어가져있는 1번째 int[]의 int요소의 합
		System.out.println(firstSum);
		int tt = 0;
		for(int i=0; i<multi[1].length;i++) {
			tt += multi[1][i];
		}
		System.out.println(tt);
		
		// multi 에 들어가져 있는 int[] 배열들이 가지고 있는 int의 합
		System.out.println(allSum);
		
		
		
		
	}
	
}
