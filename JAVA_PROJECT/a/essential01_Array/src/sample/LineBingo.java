package sample;

public class LineBingo {
	int[] num; // 숫자들 관리할 저장객체
	boolean[] checked; // 체크가 된적이 있냐 없냐를 관리할 저장객체

	public LineBingo(int size) {
		num = new int[size];
		checked = new boolean[size];
		/*
		 * num 배열에 숫자를 임의설정하는데, 겹치지 않게 범위는 size의 2배수 int p =
		 * 1+(int)(Math.random()*size*2);
		 */
		int idx = 0;
		while (idx < size) {
			int p = 1 + (int) (Math.random() * size * 2);
			boolean find = false;
			for (int s = 0; s < idx; s++) {
				if(num[s] == p) {
					find = true;
					break;	// 없다면 어떤 불필요한 작업이 일어날지..?
				}
			}
			if(!find) {
				num[idx++] = p;
			}
		}
	}

	public LineBingo() {
		this(5);
	}

	public boolean mark(int data) {
		int idx = -1;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == data) {
				idx = i;
				break;
			}
		}
		/*
		 * 만약에 data가 있으면 return true, 없으면 return false 를 하는데 있는 경우엔, 
		 * boolean[] 같은 칸에 true로 설정해줄수 있게
		 */
		if(idx == -1) {
			return false;
		}else {
			checked[idx] = true;
			return true;
		}
	}
	

	public boolean isRevealed() {
		// 자기가 가진 boolean[]의 값이 all true인지 확인해서 리턴
		int cnt = 0;
		for(int i=0; i<this.checked.length; i++) {
			if(checked[i]) {
				cnt++;
			}
		}
		return cnt == checked.length;
		/*
		for(int i=0; i<this.checked.length; i++) {
			if(checked[i] ==false) {
				return false;
			}
		}
		return true;
		*/
	}

	public String toString() {
		String rep = "[";
		int last = num.length -1;
		for (int i = 0; i < num.length; i++) {
			rep += num[i] < 10 ? "0" + num[i] : num[i];
			// if 처리 해서 i값이 마지막 index가 아니면
			if(i != last)
				rep += ", ";
		}
		rep += "]";
		return rep;
	}

	public String toHiddenString() {
		String rep = "[";
		for (int i = 0; i < num.length; i++) {
			// num 과 똑같은 칸의 boolean배열의 값이 true면,
			if (checked[i])
				rep += num[i] < 10 ? "0" + num[i] : num[i];
			else // false면 ?? 로 나오게 if 처리
				rep += "??";
			
			if(i != num.length-1)
				rep += ", ";
		}
		rep += "]";
		return rep;
	}

}
