package java_plus;
import java.util.*;
	/*
	
	2. 사용자 정의 예외
	 -- 사용자에 의해 예외 발생
	 -- throw 로 예외를 할당하여 던짐
	 -- 사용자 예외 처리는 여러개 사용 불가
	  
	
	
	try {
		throw new Exception("메시지");
	}catch(Exception e){
		e.메소드()
	}
	
	예외처리 try~catch() ==> 메소드에 결합
	메소드 결합 형태와 try~catch()가 같이 있을경우
	try~catch()가 실행
	
	리턴형 메소드(인수) throws 예외처리클래스1, 예외처리클래스2
	{
		
	}
	
	*/
public class Chap10_2_예외처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String id ="aaaa", pw="aaaa";
		while(true) {
			try {
				System.out.println("로그인 해 주세요");
				System.out.print("ID : ");
				String in_id = sc.next();
				System.out.print("PW : ");
				String in_pw = sc.next();
				
				if(!id.equals(in_id))
					throw new Exception("일치하는 아이디가 없습니다");
				else if(!pw.equals(in_pw))
					throw new Exception("암호가 맞지 않습니다");
				else
					System.out.println(id+"님 안녕하세요");
				break;				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
