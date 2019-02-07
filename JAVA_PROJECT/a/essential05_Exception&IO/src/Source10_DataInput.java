import java.io.*;

public class Source10_DataInput {
	public static void main(String[] args) {
		/*
		 * DataOutput과 반대되는 작업을 하는 DataInputStream 객체를 살펴보자.
		 */
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("output.data"));
			// IOException 계열의 FileNotFoundException
			System.out.println(dis.available());
			int m = dis.readInt();
			System.out.println("data = " +m );
			System.out.println(dis.available());
			double e = dis.readDouble();
			System.out.println(e);
			System.out.println(dis.available());
			boolean f = dis.readBoolean();
			System.out.println(f);
			String s = dis.readUTF();	// IO 계열의 UTFDataFormatException
			System.out.println(s);
			System.out.println(dis.readInt());
			System.out.println("available = " + dis.available());
			dis.readInt();	// 읽어낼 데이터가 없으면 IOException 의 계열인 EOFException 이 발생
			dis.close();
			System.out.println("try success");
		}catch(IOException e) {
			if(e instanceof UTFDataFormatException) {
				System.out.println("파일이 손상됫다.");
			}
			System.out.println("fail..! " + e.toString());
		}
	}
}
