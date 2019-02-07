import java.awt.Rectangle;
// 편하게 쓰기위해서는 import

class Source00_Package {
	public static void main(String[] args)	{
		java.awt.Rectangle r1 = new java.awt.Rectangle();

		Rectangle r2 = new Rectangle();

		design.Box b1 = new design.Box();

		//b1.flag = true;
		/*
		---------- 컴파일 ----------
		Source00_Package.java:12: error: flag has protected access in Box
				b1.flag = true;
				  ^
		1 error

		출력 완료 (0초 경과) - 정상 종료
		*/
		/*
			※※ 제한자 붙이기 ※※

			객체타입

			-	(defalut) / public 

			변수, 생성자, 함수 

			: private	-같은 패키지에서도 직접 접근은 막히게 됨

			: (defalut)	-기본설정 : 같은패키지에서는 자유롭게 사용

			: protected	-타패키지라도 일부의 경우 접근이 되는 상황이 있음

			: public	-어디서든 자유롭게 접근 가능
		*/
	}
}
