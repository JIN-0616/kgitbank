package sample;

public class SquareBingo {
	/*
	 * 
	 */
	int size;
	int[][] num;
	boolean[][] flag;
	
	public SquareBingo(int size) {
		this.size = size;
		flag = new boolean[size][size];
		num = new int[size][size];
		int[] f = new int[size*size]; //이거도 가능 (1줄로생각하고 랜덤후 처리)
		
		int idx = 0;
		while(idx<f.length) {
			boolean find = false;
			int rand = 1+(int)(Math.random()*size*size*2);
			for (int i = 0; i < f.length; i++) {
				if (f[i] == rand) {
					find = true;
					break;
				}
			}
			if(!find) {
				f[idx++] = rand;
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				num[i][j] = f[i*size+j]; // !!!!!!!!!!!!!!!!!! why? (1,0 != 0,1)
				//System.out.println(num[i][j]);
				flag[i][j] = false;
			}
		}
		/* teacher A
		int idx = 0;
		while(idx< size*size) {
			int p = 1+(int)(Math.random() *size*size*2);
			boolean find = false;
			search:
			for (int i = 0; i < size; i++) {
				int[] ar = num[i];
				for (int j = 0; j < size; j++) {
					if(ar[j] == p) {
						find =true;
						break search;
					}
				}
			}
			if(!find)
				num[idx/size][idx%size] = p;
		}
		
		or
		
		int[] f = new int[size*size]; //이거도 가능 (1줄로생각하고 랜덤후 처리)
		
		int idx = 0;
		while(idx<f.length) {
			boolean find = false;
			int rand = 1+(int)(Math.random()*size*size*2);
			for (int i = 0; i < f.length; i++) {
				if (f[i] == rand) {
					find = true;
					break;
				}
			}
			if(!find) {
				f[idx++] = rand;
			}
		}
		for (int i = 0; i < size; i++) {
			int[] c = num[i]
			for (int j = 0; j < size; j++) {
				num[i][j] = f[i+size*j]; 
			}
		}
		
		or
		
		for(int c = 0; c < size ; c++){
			num[c/size][c%size] = f[c];
		}
		*/
		
		
		/* 다른방법 A
		int tr = 0, tc = 0;
		
		while(true) {
			//num[idx/size][idx%size] = p
			num[tr][tr]=p;
			tr++;
			if(tr>size)
				tr++;
				tc=0;
		}
		*/
		
		/* 차선방법 A
		int idx = 0;
		while(idx<size*size) {
			int p = 1+(int)(Math.random()*size*size*2);
			//p 숫자가 이중배열 전체를 뒤져서 있는지 확인
			//없다고하면
			num[idx/size][idx%size] = p;
			idx++;
		}
		*/
		
		/*
		 *  이중배열에다가 숫자를 1~ size*size*2 사이의 랜덤숫자를 설정
		 *  겹치면 안됨 / 라인만 체크하면 안되고, 전체 체크를 해야함
		 *  5 - 50 6 - 72
		 *  
		 *  num[idx/size][idx%size]
		 */
		
		
	}
	
	public SquareBingo() {
		this(5);
	}
	
	public boolean mark(int data) {
		// 이 숫자 있으면 return true;
		// (있다면 boolean[][] 의 같은 칸접근해서 true로 변경)
		// 없으면 return false
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				if(data == num[i][j]) {
					flag[i][j] = true;
					return true;
				}
			}
		}
		return false;		
		/* teacher A
		int tr= -1, tc =-1;
		srch : for(int r=0; r<num.length; r++) {
			int[] ar = num[r];
			for(int c=0; c<ar.length; c++) {
				if(ar[c] == data) {
					
					 // tr = r; 
					 // tc = c;
					 // break srch;
					 
					boolean[] fr = flag[r];
					fr[c] = true;
					return true;
				}
			}
		}
		return false;
		*/
		/*
		if(tr != -1 && tc != -1) {
			flag[tr][tc] =true;
			return true;
		}else {
			return false;
		}
		*/	
	}
	
	public int revealedCount() {
		// 가로나 세로, (대각선)이 전부 true인 개수를 확인
		int count = 0;
		for(int row=0;row<size;row++) {
			boolean flg = true;
			for(int col=0;col<size;col++) { // flag[row][col]
				if(flag[row][col])
					flg = false;
			}
			if(flg)
				count++;
		}		
		for(int col=0;col<size;col++) {
			boolean flg = true;
			for(int row=0;row<size;row++) {				
				if(flag[row][col]) {
					flg = false;
				}					
			}
			if(flg)
				count++;
		}
	
		for(int row=0;row<size;row++) {
			boolean flg = true;
			for (int col = 0; col < size; col++) {
				if(row==col && flag[row][col]) {
					flg = false;
				}
			}
			if(flg)
				count++;
		}
		for(int row=0;row<size;row++) {
			boolean flg = true;
			for (int col = 0; col < size; col++) {
				if(row+col==size && flag[row][col]) {
					flg = false;
				}
			}
			if(flg)
				count++;
		}
		// Teacher A-----------------------------------------------------
		int cnt = 0;
		/*
		 * for(int r=0; r<size; r++) {
		 * 	  int fcnt=0;
		 *    for(int c=0; c<size; c++) {
		 *         if(flag[r][c])
		 *            fcnt++;
		 *    }
		 * 	  if(fnct==size)
		 *       cnt++;
		 * }
		 * 
		 */
		rowSrch : for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if(flag[row][col] == false) {		// if(!flag[row][col])
					continue rowSrch;
				}
			}
			cnt++;
		}
		colSrch : for (int col = 0; col < size; col++) {
			for (int row = 0; row < size; row++) {
				if(flag[row][col] == false) {		// if(!flag[row][col])
					continue colSrch;
				}
			}
			cnt++;
		}
		//대각선
		int[] cross = new int[2];
		for (int r = 0; r < size; r++) {
			if(flag[r][r])
				cross[0] +=1;
			if(flag[r][size-r-1])
				cross[1] +=1;			
		}
		if(cross[0]==size)
			cnt++;
		if(cross[1]==size)
			cnt++;
		
		//return cnt;  //T's A-------------------------------------------
		return count;
	}
	
	public String toHiddenString() {
		// 같은 칸의 boolean 값이 false면 ?? , 아니면 숫자로 만들어서 리턴
		String str = "";
		for (int i = 0; i < flag.length; i++) {
			str += "[";
			for (int j = 0; j < flag.length; j++) {
				if (flag[i][j]) {
					str += (num[i][j] < 10) ? "0" + num[i][j] : num[i][j];
				} else {
					str += "??";
				}
				// if 처리해서 마지막제외 , 연결
				if (j != num[i].length - 1)
					str += ", ";	
			}
			str += "]\n";
		}
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int r = 0; r < num.length; r++) {
			str +="[";
			// int[] ar = num[r];
			for (int c = 0; c < num[r].length; c++) {
				str+= num[r][c] <10 ? ("0"+num[r][c]):(num[r][c]);
				// if 처리해서
				if(num[r].length-1 != c)
					str +=",";
			}			
			str +="]\n";
		}
		return str;
	}
}
