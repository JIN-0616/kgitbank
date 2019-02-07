import java.io.*;
public class Source10_DataInput {
	public static void main(String[] args) {
		/*
		 * DataOutput과 반대되는 작업을 하는 DataInputStream 객체를 살펴보자
		 * 
		 * ### 입출력구조 ###
		 * FileOutput(Input)Stream --> DataOutput(Input)Stream
		 * 
		 */
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("output.data"));
			
			// IOException 계열의 FileNotFoundException
			
			System.out.println(dis.available()); // 25
			int m = dis.readInt();				 // 4바이트를 읽어냄(int)
			System.out.println("data = "+ m);
			System.out.println(dis.available()); // --> 21
			double e = dis.readDouble();		 //	8바이트를 읽어냄(double)
			System.out.println("data = "+ e);
			System.out.println(dis.available()); // --> 13
			boolean f = dis.readBoolean();
			System.out.println(f);
			
			String s = dis.readUTF(); 			 // 처음숫자(길이) 데이터부분 +마킹 (기존보다 2바이트추가됨)
			
			// IO 계열의 UTFDataFormetException
			
			System.out.println(s);				 // 문자열은 에러발생높음
			System.out.println(dis.available()); // 1		
			System.out.println("available = "+dis.available());
			
			//System.out.println(dis.readInt()); 
			
			//읽어낼 데이터가 없으면 IOException 의 계열인 EOFException 이 발생
			
			dis.close();
			System.out.println("try success");
			
			// 처리를 위해 exception을 따로 잡아서 catch해서 각각처리를 해줘야 다른 대응이 가능하다.
			
		} catch (IOException e) {
			
			// 뭉쳐서 처리할 경우에는 내부에서 instanceof 구문을 이용해 나눠서 처리도 가능하다.
			
			if(e instanceof UTFDataFormatException) {
				System.out.println("파일이 손상되었다.");
			}
			//System.out.println("fail...! "+e.getMessage());
			System.out.println("fail... "+ e.toString());
		}
		
	}
}
