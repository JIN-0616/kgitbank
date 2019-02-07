/*
 * About. Object in java.lang.Package
 * 
 *  자바에서 개발자가 사용할수 있는 객체들은 전부 패키지 처리가 되있다.
 *  java.lang 패키지 소속의 객체들은 import 처리를 하지 않아도 사용할 수 있다.(default)
 *  (별도로 코드 추가를 하지 않아도 자동 기입된다.)
 *  
 *  이 객체 자체는 크게 의미가 없을수도 있는데, 생성해서 사용되는 경우는 거의 없다.
 *  어떤 용도의 객체인가...?  
 */
import java.lang.Object;  // Object라는 단어를 ctrl+click
						  // 						--jdk폴더 src.zip
public class Source02_Object {
	// main... ctrl + space + enter
	public static void main(String[] args) { // main 하고 ctrl+space 자동완성
		Object obj = new Object();
		String s = obj.toString();
		System.out.println("s = "+ s);
		
		int c = obj.hashCode();
		// sysout ...ctrl + space
		System.out.println("c = "+ c);
		
		Object obj2 = new Object();
		boolean b = obj.equals(obj2); // obj == obj2 
		System.out.println("b = "+ b);
		
		obj2= obj;
		boolean b2 = obj.equals(obj2);
		System.out.println("b2 = "+ b2);
	}
}
