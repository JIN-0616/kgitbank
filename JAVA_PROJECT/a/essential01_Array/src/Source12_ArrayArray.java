
public class Source12_ArrayArray {
	public static void main(String[] args) {
		// �迭��ü�� �迭�� �����Ҽ� �ִ�. - �迭�� �迭�� .. ���߹迭 �̶�� �θ���..
		// �迭�� ��ü�� ������ ��ü�迭�� �����ϵ�, �迭�� ������ �ȴ�.

		System.out.println(new int[3][]); // int[] �� 3�� ������ �迭�� �����.

		// ���߹迭�� ����ҷ��� ��ü���� �޾���� ���ٵ�, ���� ���� [][] �� ���� �ȴ�.

		int[][] nums;
		boolean[][] flag;
		Sword[][] sws;

		// ==================================
		nums = new int[10][];
		System.out.println(nums.length);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(i + " : " + nums[i]);
		}
		nums[0] = new int[5];

		int[] t = new int[3];
		nums[1] = t;
		nums[2] = t;

		flag = new boolean[3][]; // flag �� boolean[] �� �迭�� ��� �����ϴµ�
									// 0ĭ���� 3ĭ¥�� boolean �迭
									// 1ĭ���� 5ĭ¥�� boolean �迭
									// 2ĭ���� 7ĭ¥�� boolean �迭 �� �������Ѽ�
									// �����޶�.
		flag[0] = new boolean[3];
		flag[1] = new boolean[5];
		flag[2] = new boolean[7];

		for (int i = 0; i < flag.length; i++) {
			System.out.println(i + " : " + flag[i] + " / " + flag[i].length);
		}

		flag = new boolean[][] { new boolean[3], new boolean[5], new boolean[7] };

		sws = new Sword[][] { new Sword[2], new Sword[3] };
		/*
		 * sws[0] = new Sword[] { new Sword(), new Sword()}; sws[1] = new Sword[] { new
		 * Sword(), new Sword(), new Sword() };
		 */

		Sword[] got;
		got = sws[0];
		got[0] = new Sword();
		got[1] = new Sword();
		got = sws[1];
		got[0] = new Sword();
		got[1] = new Sword();
		got[2] = new Sword();

		for (int i = 0; i < sws.length; i++) {
			Sword[] e = sws[i];
			System.out.println(i + " .. " + e.length); // 0ĭ���� 2��¥�� Į��, 1ĭ���� 3��¥�� Į��
			for (int ii = 0; ii < e.length; ii++) {
				System.out.println(e[ii]);
			}
		}

		sws = new Sword[][] {
				new Sword[] { new Sword(), new Sword() },
				new Sword[] { new Sword(), new Sword(), new Sword() } 
			};
		//==================================================================
		// ���ι迭�� ��Ҹ� �����Ҷ� ,��) 1 - 1
		Sword[] obt = sws[1];
		System.out.println("�� " + obt[1] +" / " + sws[1].length +" / " + sws[1][1] );
		System.out.println(obt[1] == sws[1][1]);	
	}
}




