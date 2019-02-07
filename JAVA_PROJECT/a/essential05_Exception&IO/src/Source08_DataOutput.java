import java.io.*;

public class Source08_DataOutput {
	public static void main(String[] args) {
		/*
		 * 파일에 출력되어야 하는 형태는 1byte 의 수치이다.
		 * 이 기본 출력상태로는, 원하는 데이터를 출력하기 힘들다.
		 */
		try {
			FileOutputStream fos = new FileOutputStream("output.data");
			
			System.out.println("output ready.. " + (fos instanceof OutputStream));
			// DataOutputStream 객체는 FileOutputStream 객체에만 적용되는건 아니고, 
			// OutputStream 객체면 다 된다. 
			DataOutputStream dos = new DataOutputStream(fos);
			// 이 객체를 이용하게 되면,
			dos.writeInt(4561221);
			dos.writeDouble(3.141592);
			dos.writeBoolean(true);
			dos.writeUTF("홍길동");	// 문자열 출력
			dos.writeInt(30);			
			
			dos.close();
			System.out.println("try data out success!!");
			
		}catch(IOException e) {	// 익셉션도, 객체가 갖고 있는 다형성 때문에 상위로 제어할수 있다.
			// FileNotFoundException 이 IOException 의 하위라서 처리가 됬다고 여긴다. 
			System.out.println("try fail.. cause " + e.getMessage() );
		}
		
	}
}
