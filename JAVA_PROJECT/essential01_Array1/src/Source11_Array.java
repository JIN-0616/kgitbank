
public class Source11_Array {

	static int[] make() {
		int[] a = new int[5];
		int idx = 0;
		set : while (idx < a.length) {
			int num = 1 + (int) (Math.random() * 10);
			// -----------------------------------------
			// 1~10 같은숫자가 안나오도록 세팅
			/* ing
			for (int i = 0; i < a.length; i++) {
				if (a[i] == num) {
					break;
				} else {
					a[idx] = num;
				}
			}
			idx++;
			*/
			boolean find = false;
			for (int c = 0; c < a.length; c++) {
				System.out.println("["+c+"] = "+a[c]);
				if(a[c]==num) {
					find = true;
					//while에 set빼고 break;
					continue set;
				}
			}
			System.out.println("a contains "+num+" ??"+find);
			if(!find)
				a[idx++] = num;
			
			//-----------------------------------------

		}
		return a;
	}

	
	
	public static void main(String[] args) {
		int[] box = make();
		int data = 3; // 찾아야될 데이터 (고정이긴 하지만 바뀔수 있다고 가정)

		// box안에 설정된 int 값중에 data가 있는지 없는지 확인
		boolean find = false;
		for (int i = 0; i < box.length; i++) {
			System.out.println("box[" + i + "] = " + box[i]);
		}
		/*
		 * int idx=0; while(idx<box.length) { if(box[idx].equals(data)) { find = true; }
		 * idx++; }
		 */
		for (int idx = 0; idx < box.length; idx++) {
			System.out.println("[" + idx + "] = " + box[idx]);
			if (box[idx] == data) {
				find = true;
				break;
			}
		}

		System.out.println("box contains data ?? " + find);
	}

}
