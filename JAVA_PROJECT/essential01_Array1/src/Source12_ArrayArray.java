
public class Source12_ArrayArray {
	public static void main(String[] args) {
		// 배열객체를 배열로 관리할수 있다. - 배열을 배열로 .. 이중배열 이라고 부르는..
		// 배열도 객체기 때문에 객체배열이 가능하듯, 배열로 관리가 된다.
		
		System.out.println(new int[3][]);
			// int[] 을 3개 저장할 배열을 만든것
		// 이중배열은 사용하려면 객체값을 받아줘야 할텐데, 변수 선언 [][]을 쓰면된다.
		
		int[][] nums;
		boolean[][] flag;
		Sword[][] sws;
		
		//=========================================================================
		nums = new int[10][];
		System.out.println(nums.length);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(i + " : " + nums[i]);
		}
		nums[0] = new int[5];
		
		int[] t = new int[3];
		nums[1] = t;
		nums[2] = t;
		
		flag = new boolean[3][];		// flag에 boolean[] 을 배열로 묶어서 설정하는데
										// 0칸에는 3칸짜리 boolean 배열
										// 1칸에는 5칸짜리 boolean 배열
										// 2칸에는 7칸짜리 boolean 배열 을 설정시켜서
										// 만들어달라
		flag[0] = new boolean[3];
		flag[1] = new boolean[5];
		flag[2] = new boolean[7];
		// 혹은
		int a=3;
		for (int i = 0; i < flag.length; i++) {
			flag[i] = new boolean[a];
			a += 2;
			System.out.println(i+" : "+flag[i]+" / "+ flag[i].length);
		}
		// 혹은
		flag = new boolean [][] {new boolean[3], new boolean[5], new boolean[7]};
		
		sws = new Sword[2][];
		
		sws = new Sword[][] { { new Sword(), new Sword() },
							  { new Sword(), new Sword(),new Sword() }
		};
		
		// 주의할것
		sws = new Sword[][] {
							new Sword[] {new Sword(),new Sword()},
							new Sword[] {new Sword(), new Sword(),new Sword()}
		};
		
		for (int i = 0; i < sws.length; i++) {
			Sword[] e = sws[i];
			System.out.println(i + " .. " +e.length);
			// 0칸에는 2개짜리 칼집, 1칸에는 3개짜리의 칼집
			for (int ii = 0; ii < e.length; ii++) {
				System.out.println(e[ii]);				
			}
		}
		//=========================================================================
		Sword[] obt = sws[0];
		System.out.println("-->"+obt+ " / "+ sws[1].length+" / "+ sws[1][1]);
		System.out.println(obt[1] == sws[1][1]);
	}
}
