import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class Source14_ObjectInput {
	public static void main(String[] args) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("array.sav"));){
			
			// ObjectInputStream 객체 생성은 Exception이 발생할수 있다.
			// InputStream 객체를 열때 4byte를 먼저 읽어서, 확인에 들어감 (.readShort 2번)
			
			// ex)fail...java.io.StreamCorruptedException: invalid stream header: 00459945
			// 저장한 header부분이 잘못되거나 아닌경우에 발생하는 오류
			
			// EOFException
			// 읽어낼 파일이 없는 경우, 길이가 잘못된경우
			
			/* ------File 내용
			int[] data = new int[] {4,1,4,15,11,6,2};
			boolean[] flag = new boolean[] {true, true, false};
			String day = "WED"; 
			*/
			
			System.out.println("try success...input ready");
			System.out.println(ois.available()); //이걸로 확인 안됨
			
			Object o = ois.readObject();	//
			System.out.println(o instanceof int[]);
			int[] a = (int[])o;
			System.out.println("int[] ="+a.length+"..."+a[0]);
			boolean[] b = (boolean[])ois.readObject();
			System.out.println("boolean[] ="+b.length+"..."+b[0]);
						
			String s = (String)ois.readObject();
			System.out.println(s+ "..."+s.matches("[A-Z]{3}"));

			// 출력되어있는 객체 순서를 모르면, 읽어내기 어렵고
			//ois.readObject();	// 읽어낼 객체가 없으면 EOFException이 발생
			// available 값이 안나와서, 읽고자 하는 객체 개수를 모르면 읽어내기 어려움
			
			
			
			//ois.close(); 위에서 자동처리됨
		} catch (StreamCorruptedException e) {
			System.out.println("파일형식이 맞지 않습니다.");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("fail..."+e.toString());
		} catch (ClassNotFoundException e) { //따로 잡아줘야되는 다른계열쪽 Ex
			e.printStackTrace();
		}
	}
}
