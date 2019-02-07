package java_plus;

public class Chap06_2_배열_다차원배열 {
	/*
	다차원 배열 : 배열을 원소로 하는 배열
		배열의 차원에 따라 1,2,3... 차원으로 명시
		자료형만 일치하면 사용가능
		각 원소배열의 가지고 있는 원소갯수가 다른 원소배열과 일치할 필요가 없음
		
	차원의 갯수대로 [] 를 기재
	 자료형 [][] 배열명 = {
	 	{원소0_0, 원소0_1, 원소0_2..... }, // 1차원->0
	 	{원소1_0, 원소1_1, 원소1_2..... }, // 1차원->1
	 	{원소2_0, 원소2_1, 원소2_2..... }, // 1차원->2
	 	{원소3_0, 원소3_1, 원소3_2..... }  // 1차원->3
	 	//2차원 0 	    1		 2
	 	 };
	 	 
	원소 호출 : 배열명[1차원원소번호][2차원원소번호];
	
	자료형 배열명 [][] --> 배열명과 배열차원을 바꾸어서 선언 가능
	 	
	*/
	public static void main(String[] args) {
		int [][] arr = {
				{11,12,13,14}, 		// 1--> 0
				{21,22,23,24,25}, 	// 1--> 1
				{31,32,33}			// 1--> 2
			//2-> 0, 1, 2, 3, 4
		};		
		
		System.out.println(arr[1][2]);
		
		// 각 차원의 원소의 갯수나 메소드등을 호출할 경우 각 차원에 접근하여 불러온다.
		// arr.length --> 1차원의 원소 갯수 : 3개
		// arr[0].length --> 1차원 0번 배열의 2차원배열 원소갯수 : 4개
		
		
		// 다차원배열을 출력시에는 차원의 수만큼 for문을 중첩하여 사용
		
		System.out.println("arr.length : "+arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + " 원소갯수 : "+arr[i].length);
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]+", ");				
			}
			System.out.println();			
		}
		
		int [] subarr1 = {1000,2000,3000,4000,5000};
		int [] subarr2 = new int[6];
		int [] subarr3;
		
		int arr2 [][] = {
			new int[3],		//동적 할당 생성
			{201,202,203,304},	//초기값
			subarr1,			//기존의 초기화된 배열
			subarr2,			//기존의 동적할당된 배열
			subarr3 = new int[4]
		};
		arr2[2][3] = 44;
		System.out.println("arr2[2][3] : "+arr2[2][3]); //44
		System.out.println("subarr : "+subarr1[3]); //44
		
		int[][] arr3 = new int[4][3];
		//1차원-4개, 2차원-3개인 2중배열 동적할당 : 원칙적인 방법
		arr3[3][2]=1234;
		System.out.println("arr3[3][2] : "+arr3[3][2]);
		
		int[][] arr4 = new int[4][];
		//1차원-4개, 2차원-알수없는 동적할당
		//arr4[1][2]=56; 2차원 배열을 할당하지 않아 에러발생
		arr4[1] = new int [5];
		arr4[1][2] = 56;
		//arr4[0][1]=35; // 모든 2차원배열을 동적받아야한다.
		System.out.println("arr4[1][2] : "+arr4[1][2]);
	}
}
