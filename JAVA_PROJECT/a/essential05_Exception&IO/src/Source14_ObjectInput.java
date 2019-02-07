import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class Source14_ObjectInput {
	public static void main(String[] args) {
		try (ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("arrays.sav"));) {
			// ObjectInputStream ��ü ������ Exception�� �߻��Ҽ� �ִ�.
			// InputStream ��ü�� ����, 4byte�� ���� �о, Ȯ���� ��.
			System.out.println("try success.. input ready");
			System.out.println(ois.available());	// �̰ɷ� Ȯ�� �ȵǰ�.
			
			Object o = ois.readObject();	//
			System.out.println(o instanceof int[]);
			int[] a = (int[])o;
			System.out.println(a.length + ".."+ a[0]);
			boolean[] b= (boolean[])ois.readObject();	//
			System.out.println(b.length + ".."+ b[0]);
			
			String s = (String)ois.readObject();	// 
			System.out.println(s+ " ... " + s.matches("[A-Z]{3}"));
			
			// ��µǾ��ִ� ��ü ������ �𸣸�, �о�� ��ư�
			ois.readObject();	// �о ��ü�� ������ EOFException�� �߻�
			// avaliable ���� �ȳ��ͼ�,  �а��� �ϴ� ��ü ������ �ȸ����� �о�� �����.

		} catch (StreamCorruptedException e) {
			System.out.println("invalid file type.." + e.getMessage());
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("fail.. " + e.toString());
		}

	}
}
