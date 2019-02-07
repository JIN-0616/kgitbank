
public class Source07_Array {
	public static void main(String[] args) {
		/*
		 * 배열객체는 생성시 데이터를 저장하는 칸에는 0기반의 데이터들로 채워져있다. int[] : 0, boolean[] : false ,
		 * double[] : 0.0 , 객체[] : null
		 * 
		 * 만들때 0이상 으로 설정할수 있고, 최대 칸수는 int 허용범위
		 */
		int size = 3;
		boolean[] box = new boolean[size];
		System.out.println("boolean[] created.. length " + box.length);
		System.out.println(box[0] + ".." + box[1] + ".." + box[2]);
		/*
		 * 생성하면서 각칸에 데이터를 설정하면서 만들수 있다. 설정한 개수만큼 사이즈 맞춰서 생성된다.
		 */
		int[] n = new int[] { 1, 4, 5, 6, 1, 54 }; // new int[empty] { }
		System.out.println(n.length);
		n = new int[] { 1, -1, 3, 6 };
		boolean[] bb = new boolean[] {true, false, true, true};
		/*
		 * Sword 3칸짜리를 만드는데 바로 사용할수 있게, 객체값들을 설정한상태로 만들려면..?
		 * 
		 */
		
		Sword[] sw = new Sword[] { new Sword(), new Sword(), new Sword() };
		//==============================================
		System.out.println(sw.length);	// 3
		System.out.println(sw[0]);
		System.out.println(sw[1]);
		System.out.println(sw[2]);
		
		System.out.println(sw[0] != sw[1] );
		System.out.println(sw[0] != sw[2] );
		System.out.println(sw[1] != sw[2] );
		Sword x1 = new Sword();
		Sword x2 = new Sword();
		Sword x3 = new Sword();
		Sword[] sww = new Sword[] {x1, x2, x3 };
		
		/*
		 * 데이터여러개를 묶어서 만들 관리형객체(배열)을 만들때,
		 * 칸만 지정하고 만들수도 있고(나중에 채울용도로),
		 * 각칸에 값을 설정해서 만들어낼수도 있다 (바로 확보해서 사용할 용도로)  
		 */
		
	}
}








