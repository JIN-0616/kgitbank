public class Source11_Array {
	static int[] make() {
		int[] a = new int[5];
		int idx = 0;
		set : while (idx < a.length) {
			int num = 1 + (int) (Math.random() * 10);
			// ������������������������������������������
			boolean find = false;
			for (int c = 0; c < a.length; c++) {
				System.out.println("[" + c + "] = " + a[c]);
				if (a[c] == num) {
					find = true;
					// break;
					continue set;
				}
			}
			System.out.println("a contains " + num +" ?? " + find);
			if(!find)
				a[idx++] = num;
			// ������������������������������������������
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] box = make();
		int data = 3; // ã�ƾߵ� ������ (�����̱� ������ �ٲܼ� �ִٰ� ����)

		// box�ȿ� ������ int ���߿� data �� �ִ��� ������ Ȯ��
		boolean find = false;
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
