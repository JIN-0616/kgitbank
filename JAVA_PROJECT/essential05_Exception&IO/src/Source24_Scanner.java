import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// Scanner 객체는 문자열을 직접 소스로 설정 안해도,
// 문자byte를 읽어낼수 있는 InputStream을 설정해도 
// 해당 Input을 알아서 개조해서 문자들을 확보하면서 작업을 한다.

// 읽어낼수 있는 Stream을 넘겨도 됨 ex) System.in
public class Source24_Scanner {
	public static void main(String[] args) {
		/*
		 * Scanner 에 System.in 설정했던 것은
		 * 키보드로 입력받은 내용은, 실제로 존재하지 않는 메모리상의 파일같은 곳에
		 * byte로 저장이 되는데, 거기서 byte값을 읽어낼수 있게 설정된 객체가 System.in
		 * 
		 * 위 입력버퍼에서 가지고 올 byte가 없다면, 시스템적으로 대기 상태에 빠지게 되어있다.
		 */
		System.out.println("Use Scanner=>");
		Scanner cin = new Scanner(System.in);
		System.out.println(cin.next());	// 반지름 3 5 OKKKKKKKKK!
		int a = cin.nextInt();
		int b = cin.nextInt();
		System.out.println(a+b);
		String s = cin.nextLine(); //엔터값 띄어쓰기등만 남아있다면 그걸 가져가게되서 생략됨
		System.out.println(s);
		cin.nextLine(); // 다음값이 없다면 대기상태로
		
		
		try(Scanner scan = new Scanner(new FileInputStream("last-log.txt"));) {
			System.out.println(scan.hasNext() + "..."+scan.hasNextLine());
			
			System.out.println(scan.next());
			System.out.println(scan.nextLine());
			
			System.out.println(scan.nextDouble());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());			
		} catch (IOException e) {
			System.out.println("# scan Error #");
		}
	}
}
/*

true...true
문자열
 출력해보자!!
3.141592653589793

true
44651

*/