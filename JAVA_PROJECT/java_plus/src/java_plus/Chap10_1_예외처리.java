package java_plus;
import java.io.*;

		/*
		1. 정의
		 프로그램 진행중 발생되는 에러를 통해 오작동 혹은 비정상적 종료를 막고
		 예외처리를 통해 정상적인 상태로 수습토록 유도
		 
		 try{ } 구간이 있으면 반드시
		 에러를 처리할 예외처리 : catch(예외클래스 인수){ } 구간이 필요
		 
		 try~catch() 는 짝으로 이루어져야 한다
		 중간에 try가 더 삽입되어서는 안된다
		 catch()는 예외처리클래스에 따라 오버로딩, 오버라이딩으로 여러개를 둘 수 있다.
		 
		 finally{ } // 마지막 처리구문(생략가능)
		 			// 반드시 맨마지막에 작성
		 
		 1. 에러발생예상 구문 --> try{ }
		 
		 2. 예외 처리 --> catch(예외인수 e){ }
		 
		 		상속
		 	Exception ---> IOException : 입출력에러
		 		   ArithmeticException : 수학적기호
		 
		 3. 마지막 실행구문 ---> finally{ }
		
		*/

public class Chap10_1_예외처리 {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		try { //에러발생 예상 구문
			System.out.println("try 시작");
			int a = 0/3;
			int b = 3/0; //에러발생
			System.out.println("정상처리");
		}catch(ArithmeticException e) { //수학 연산 에러처리
			System.out.println("0 하지마");
			return; //main() 종료
		}catch(Exception e){
			System.out.println("예외발생");
			return; //main() 종료
		}finally {
			System.out.println("시스템종료");
		}
		
		
	}
}
