package sample;

public class LineBingo {
	int[] num; // 숫자를 관리할 저장용 객체
	boolean[] checked; // 체크가 된적이 있나 없나를 관리할 저장객체

	public LineBingo(int size) {
		num = new int[size];
		checked = new boolean[size];
		/*
		 * num 배열에 숫자를 임의설정하는데, 겹치지 않게 범위는 size의 2배수
		 */
		int idx = 0;
		while (idx < num.length) {
			boolean find = false;
			int n = 1 + (int) (Math.random() * (size * 2));
			for (int i = 0; i < num.length; i++) {
				if (num[i] == n) {
					find = true;
					break;
				}
			}
			if (!find) {
				num[idx++] = n;
			}

		}
		/* ====================another======================
		int idx=0;
		while(idx<size){
			int n = 1+(int)(Math.random()*size*2);
			boolean find = false;
			for(int s = 0; s<idx; s++){
				if(num[s] == p){
					find =true;
			      	break; //없다면 어떤 불필요한 작업이 일어날지?
				}
			}
			if(!find){
				num[idx++] = p;
			}
		}
		*///====================another======================

		// System.out.println("linebingo created");
	}

	public LineBingo() {
		this(5);
	}

	public boolean mark(int data) {
		for (int i = 0; i < num.length; i++) {
			if (num[i] == data) {
				checked[i] = true;
				return true;
			}
		}
		/*
		 * 만약에 data가 있으면 return true, 없으면 return false를 하는데 있는 경우엔, boolean[ ] 같은 칸에
		 * true로 설정해줄수 있게
		 */
		return false;
		
		/* ====================another======================
		int idx = -1;
		for (int i = 0; i < num.length; i++) {
			if(num[i] == data) {
				idx = i;
				break;
			}
			
		}
		if(idx == -1) {
			return false;
		}else {
			checked[idx] = true;
			return true;
		}
		*///====================another======================

	}

	@Override
	public String toString() {
		String rep = "[";
		for (int i = 0; i < num.length; i++) {
			rep += num[i] < 10 ? "0" + num[i] : num[i];
			// if 처리해서 마지막 index제외 , 연결
			if (i != num.length - 1)
				rep += ", ";
		}
		rep += "]";
		return rep;
	}

	public String toHiddenString() {
		String rep = "[";
		for (int i = 0; i < num.length; i++) {
			// num 과 동일한 칸에 boolean배열의 값이 true면
			// false면 ??로 나오게 if처리
			if (checked[i]) {
				rep += num[i] < 10 ? "0" + num[i] : num[i];
			} else {
				rep += "??";
			}
			// if 처리해서 마지막제외 , 연결
			if (i != num.length - 1)
				rep += ", ";
		}
		rep += "]";
		return rep;
	}

	public boolean isRevealed() {
		// 자기가 가진 boolean[]의 모든 값이 all true인지 확인해서 리턴
		int cnt = 0;
		// checked boolean[] 배열에서 true 개수를 세서
		for (int i = 0; i < checked.length; i++) {
			if (checked[i]) {
				cnt++;
			}
		}
		return cnt == checked.length;
		/*====================another======================
		int cnt=0;
		for (int i = 0; i < this.checked.length; i++) {
			if(checked[i] == false)
				return false;
			}
		}
		return true;
		*///====================another======================
		/*====================another======================
		int cnt=0;
		
		for(int i = 0; i<this.checked.length;i++) {
			if(checked[i]) {
				cnt++;
			}
		}
		return cnt == checked.length;
		*///====================another======================
	}

}
