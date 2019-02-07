import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class Source14_ObjectInput {
	public static void main(String[] args) {
		try (ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("arrays.sav"));) {
			// ObjectInputStream 객체 생성은 Exception이 발생할수 있다.
			// InputStream 객체를 열때, 4byte를 먼저 읽어서, 확인이 들어감.
			System.out.println("try success.. input ready");
			System.out.println(ois.available());	// 이걸로 확인 안되고.
			
			Object o = ois.readObject();	//
			System.out.println(o instanceof int[]);
			int[] a = (int[])o;
			System.out.println(a.length + ".."+ a[0]);
			boolean[] b= (boolean[])ois.readObject();	//
			System.out.println(b.length + ".."+ b[0]);
			
			String s = (String)ois.readObject();	// 
			System.out.println(s+ " ... " + s.matches("[A-Z]{3}"));
			
			// 출력되어있는 객체 순서를 모르면, 읽어내기 어렵고
			ois.readObject();	// 읽어낼 객체가 없으면 EOFException이 발생
			// avaliable 값이 안나와서,  읽고자 하는 객체 개수가 안맞으면 읽어내기 어려움.

		} catch (StreamCorruptedException e) {
			System.out.println("invalid file type.." + e.getMessage());
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("fail.. " + e.toString());
		}

	}
}
