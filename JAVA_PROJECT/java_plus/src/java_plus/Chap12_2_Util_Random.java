package java_plus;
/*
	2.Random
	-컴퓨터가 난수를 발생하는 것은 의사 난수(pseudo random number).
	-그 이유는 수 많은 난수를 발생시키다 보면 어느 순간에 동일한 패턴으로 난수가 발생되기 때문
	-Java 언어에서 난수를 발생시키기 위해 java.lang 패키지에 있는 
	 Math 클래스의 random() 메소드를 호출하여 균일하게 0과 1사이의 난수를 생성
	-이보다 좀더 정교하게 제작된 클래스가 java.util 의 Random 클래스
*/
import java.util.*;
public class Chap12_2_Util_Random {
	public static void main(String[] args) {
		Random r1= new Random();
		Random r2= new Random(10); //seed(씨앗)으로 규칙적 난수 발생
		Random r3= new Random(10);
		System.out.println(r1);
		System.out.println(r1.nextInt());
		System.out.println(r1.nextInt(10));
		System.out.println(r1.nextLong());
		System.out.println(r1.nextFloat());
		System.out.println(r1.nextDouble());
		System.out.println(r1.nextBoolean());
		
		System.out.println();
		for (int i = 0; i < 5; i++) {
			System.out.println(r1.nextInt());
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			System.out.println(r2.nextInt());
		}
		System.out.println();
		for (int q = 0; q < 5; q++) {
			System.out.println(r3.nextInt());			
		}
	}
}
