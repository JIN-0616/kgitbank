package java_plus;

public class Chap06_1_배열_1차원배열 {
	/*
	1. 1차원 배열
	 1) 배열 : 같은 자료형으로 묶어놓은 집합
	 2) 선언형태 : 자료형[] 변수명;
	 3) 변수명 = new 자료형[갯수]; //원소가 갯수만큼 들어가도록 공간할당
	 4) 호출 : 변수명[원소번호]
	 5) 배열원소갯수 : 배열명.length -> 맴버변수
	 6) for()문과 같이 사용가능 --> 배열원소번호는 순차적으로 진행되기 때문 
	 
	*/
	public static void main(String[] args) {
		/**
		 * @param args
		 */
		int [] arr = {23,56,12,78,98,43,21};
		//배열의 선언
		//자료형 [] 배열명 = {원소0,원소1,...};
		
		System.out.println(arr); // 배열명을 호출할 경우 메모리 주소(객체값)가 호출된다
		
		System.out.println(arr[0]);
		//원소를 호출할 경우 -> 배열명[원소번호]
		
		for (int i = 0; i < 4; i++) {
			System.out.println("arr 원소 "+i+" 번째 값: "+arr[i]);			
		}
		//int last = arr.length; //배열의 원소갯수
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i !=(arr.length-1))
				System.out.print(", ");
		}
		System.out.println();
		
		int[] arr2 = new int[5]; // int형으로 5개를 원소로 받도록 메모리할당
				//동적할당
		
		//arr2 ={67,78,89,123,456};
		//에러발생 --> 배열은 선언시에 크기를 알려줘야 한다.
		
		arr2[0]=89;
		
		int[] arr3 = arr; //shallow copy (얕은복사) --> 주소복사
		
		int[] arr4 = new int[arr.length];
		
		for (int i = 0; i < arr4.length; i++) {
			arr4[i] =arr[i];	//deep copy --> 원소 값 복사
		}
		arr3[5] = 78;
		System.out.println("arr4[5] : "+arr4[5]);
		System.out.println("arr3[5] : "+arr3[5]);
		System.out.println("arr[5] : "+arr[5]);
		
	}
}
