package sample;

public class LineBingo {
	int[] num; // ���ڵ� ������ ���尴ü
	boolean[] checked; // üũ�� ������ �ֳ� ���ĸ� ������ ���尴ü

	public LineBingo(int size) {
		num = new int[size];
		checked = new boolean[size];
		/*
		 * num �迭�� ���ڸ� ���Ǽ����ϴµ�, ��ġ�� �ʰ� ������ size�� 2��� int p =
		 * 1+(int)(Math.random()*size*2);
		 */
		int idx = 0;
		while (idx < size) {
			int p = 1 + (int) (Math.random() * size * 2);
			boolean find = false;
			for (int s = 0; s < idx; s++) {
				if(num[s] == p) {
					find = true;
					break;	// ���ٸ� � ���ʿ��� �۾��� �Ͼ��..?
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
		 * ���࿡ data�� ������ return true, ������ return false �� �ϴµ� �ִ� ��쿣, 
		 * boolean[] ���� ĭ�� true�� �������ټ� �ְ�
		 */
		if(idx == -1) {
			return false;
		}else {
			checked[idx] = true;
			return true;
		}
	}
	

	public boolean isRevealed() {
		// �ڱⰡ ���� boolean[]�� ���� all true���� Ȯ���ؼ� ����
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
			// if ó�� �ؼ� i���� ������ index�� �ƴϸ�
			if(i != last)
				rep += ", ";
		}
		rep += "]";
		return rep;
	}

	public String toHiddenString() {
		String rep = "[";
		for (int i = 0; i < num.length; i++) {
			// num �� �Ȱ��� ĭ�� boolean�迭�� ���� true��,
			if (checked[i])
				rep += num[i] < 10 ? "0" + num[i] : num[i];
			else // false�� ?? �� ������ if ó��
				rep += "??";
			
			if(i != num.length-1)
				rep += ", ";
		}
		rep += "]";
		return rep;
	}

}
