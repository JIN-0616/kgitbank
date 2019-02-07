import java.io.*;

public class Source08_DataOutput {
	public static void main(String[] args) {
		/*
		 *  파일에 출력되는 형태는 1byte의 수치이다.
		 *  이 기본 출력상태로는, 원하는 데이터를 출력하기 힘들다.
		 */
		try {
			FileOutputStream fos = new FileOutputStream("output.data");
			System.out.println("output ready..."+ (fos instanceof OutputStream));
			// DataOutputStream 객체는 FileOutputStream 객체에만 적용되는건 아니고,
			// OutputStream 객체면 다 된다.
			DataOutputStream dos = new DataOutputStream(fos);
			// 이 객체를 이용하ㅔ 되면,
			dos.writeInt(4561221); // int 4바이트 출력
			dos.writeDouble(3.141592); // double 8바이트 출력
			dos.writeBoolean(true);  // 1바이트 true 1 false 0
			dos.writeUTF("홍길동"); // 문자열출력
			dos.write(30);
			
			dos.close();
			System.out.println("try data out success!!");
			
		} catch (IOException e) { 
			// 상위 Exception, 익셉션도 객체가 갖고 있는 다형성때문에 상위로 제어가능
			// FileNotFoundException 이 IOException 의 하위라서 처리가 됬다고 여긴다. 
			System.out.println("try fail...cause "+e.toString());
		}
	}
}
