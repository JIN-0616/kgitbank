
public class Source13_ArrayArray {
	
	static int[] makeRow() {
		int size = 2+(int)(Math.random()*4);
		int[] ar = new int[size];		//2~5
		for (int idx = 0; idx < ar.length; idx++) {
			int val = (int)Math.pow(size, idx+1);
			
			ar[idx]= val;
		}
		return ar;
	}
	public static void main(String[] args) {
		int[] got = makeRow();
		for (int i = 0; i < got.length; i++) {
			System.out.println(i+".."+got[i]);
		}
		
		//====================================================================
		int[][] multi = new int[5][];
		for (int r = 0; r < multi.length; r++) {
			multi[r] = makeRow();
			
		}
		System.out.println();
		//====================================================================
		for (int i = 0; i < multi.length; i++) {
			for (int j = 0; j < multi[i].length; j++) {
				System.out.print(multi[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("");
		// multi에 들어가져있는 int[] 길이의 합
		int sum1=0;
		for (int i = 0; i < multi.length; i++) {
			sum1 += multi[i].length;
			System.out.print(multi[i].length+" / ");
		}
		System.out.println("\n (1) : "+sum1);
		// multi에 들어가져있는 1번째 int[]의 요소의 합
		int sum2=0;
		for (int i = 0; i < multi[1].length; i++) {
			sum2 += multi[1][i];
			System.out.print(multi[1][i]+" / ");
		}
		System.out.println("\n (2) : "+sum2);
		// multi에 들어가져있는 int[]배열들이 가지고 있는 int의 합
		int sum3=0;
		for (int i = 0; i < multi.length; i++) {
			for (int j = 0; j < multi[i].length; j++) {
				sum3 += multi[i][j];
				System.out.print(multi[i][j]+" / ");
			}			
		}
		System.out.println("\n (3) : "+sum3);
		
		//another===============================================
		int[][] multi1 = new int[5][];
		for (int r = 0; r < multi1.length; r++) {
			// multi[r] =makeRow();
			int[] tmp = makeRow();
			for (int i = 0; i < tmp.length; i++) {
				System.out.print(tmp[i]+" ");
			}
			multi1[r] = tmp;
			System.out.print(" | setting to "+ r);
			
		}
		
		//another===============================================
		int lengthSum=0;
		int firstSum=0;
		int allSum=0;
		for (int row = 0; row < multi.length; row++) {
			int[] each = multi[row];
			lengthSum += each.length; 	// multi[row].length
			for (int col = 0; col < each.length; col++) {
				System.out.println(col+"..."+each[col]);
				allSum += each[col];	// += multi[row][col];
				if(row == 1) {
					firstSum += each[col];
				}
			}
		}
		System.out.println(lengthSum);
		System.out.println(firstSum);
		System.out.println(allSum);
		
		//=========
		/*
		int tt =0;
		for (int i = 0; i < multi1[i].length; i++) {
			System.out.println(i+"..."+multi[1][i]);
			tt += multi[1][i];			
		}
		System.out.println(tt);
		*/
	}
}
