
public class Source15_ArrayArray {
	public static void main(String[] args) {
		/*
		 * 이중배열(배열을 배열로 관리하고자 할때) 객체를 생성할때,
		 */
		boolean[][] map = new boolean[5][];
		// 이 형태로 만들어 보았는데
		for (int r = 0; r < map.length; r++) {
			System.out.println(map[r]); // map[r].length 접근시 에러
		}
		// 만약에, 이중배열에 설정해야될 배열의 크기가 일정하다면...
		int[][] num = new int[4][5]; // 두번째칸에 크기를 설정해두고 만들수 있다.
		for (int r = 0; r < num.length; r++) {
			System.out.println(num[r] + " / " + num[r].length);
		}
		// 직사각형모양으로 생성할때는 미리 정할수 있음
		
		// 위의 작업과 동일
		// int[][] num = new int[][]{ new int[5], new int[5], new int[5], new int[5] }
		
		
		num[1] = new int[10]; //생성후 수정 가능
		
		Sim[][] f = new Sim[3][2];			 // vs new Sim[3][];
		for (int r = 0; r < f.length; r++) {
			System.out.println(f[r]);
			for (int c = 0; c < f[r].length; c++) {
				System.out.println(f[r][c]);
				// Sim생성은 하지 않았으므로 null
			}
		}
		
		
		
	}
}
