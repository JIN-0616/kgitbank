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
		/*
		 * 이중배열에다가 숫자를 1~ size*size*2 사이의 랜덤숫자를 설정 겹치면 안됨 
		 * 라인만 체크하면 안되고, 전체 체크를 해야됨.
		 */
		int idx = 0;
		while (idx < size * size) {
			int p = 1 + (int) (Math.random() * size * size * 2);
			// p 숫자가 이중배열 전체를 뒤져서 있는지 확인
			// 없다고 하면
			boolean find = false;
			search: for (int r = 0; r < size; r++) {
				int[] ar = num[r];
				for (int c = 0; c < size; c++) {
					if (ar[c] == p) {
						find = true;
						break search;
					}
				}
			}
			if(!find)
				num[idx/size][idx++%size] = p;
		}
		/*
		int[] f = new int[size*size];
		int i = 0;
		while (i < size) {
			int p = 1 + (int) (Math.random() * size * size * 2);
			boolean find = false;
			for (int s = 0; s < i; s++) {
				if(f[s] == p) {
					find = true;
					break;	// 없다면 어떤 불필요한 작업이 일어날지..?
				}
			}
			if(!find) {
				f[i++] = p;
			}
		}
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				num[r][c] = f[ r*size + c]; 
			}
		}
		for(int c=0; c<f.length; c++) {
			num[c/size][c%size]= f[c];
		}
		 */
		
		
	}

	public SquareBingo() {
		this(5);
	}

	public boolean mark(int data) {
		int tr= -1, tc =-1;
		srch : for(int r=0; r<num.length; r++) {
			int[] ar = num[r];
			for(int c=0; c<ar.length; c++) {
				if(ar[c] == data) {
					/*
					 * tr = r; 
					 * tc = c;
					 * break srch;
					 */
					boolean[] fr = flag[r];
					fr[c] = true;
					return true;
				}
			}
		}
		return false;
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
		// 가로나, 세로 , (대각선) 이 전부 true 인 개수 확인
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
		int[] cross = new int[2];
		for(int r=0; r<size; r++) {
			if(flag[r][r])
				cross[0] +=1;
			if(flag[r][size-r-1])
				cross[1] +=1;
		}
		if(cross[0] == size)
			cnt++;
		if(cross[1]==size)
			cnt++;
		return cnt;
	}
	
	public String toHiddenString() {
		String str = "";
		for (int r = 0; r < num.length; r++) {
			str += "[";
			// int[] ar = num[r];
			for (int c = 0; c < num[r].length; c++) {
				if(flag[r][c])
					str += num[r][c] < 10 ? ("0" + num[r][c]) : num[r][c];
				else
					str += "??";
				// if 처리해서
				if(c != size-1)
					str += ",";
			}
			str += "]\n";
		}
		return str;
	}

	
	public String toString() {
		String str = "";
		for (int r = 0; r < num.length; r++) {
			str += "[";
			// int[] ar = num[r];
			for (int c = 0; c < num[r].length; c++) {
				str += num[r][c] < 10 ? ("0" + num[r][c]) : num[r][c];
				// if 처리해서
				if(c != size-1)
					str += ",";
			}
			
			str += "]\n";
		}
		return str;

	}

}
