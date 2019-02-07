import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Source16_Serializable {
	public static void main(String[] args) {
		/*
		 * Source15_ ���� ����ߴ� User ��ü�� �о�� ����� Ȯ���̴���...
		 * Ȯ���۾��� �غ���.
		 * 
		 */
		try (ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream("v������v"));) {
			System.out.print("input try..");
		
			User got = (User)ois.readObject();
			
			System.out.println("success!");
			System.out.println(got.toString());
			for(Item m :  got.li) {
				System.out.println("    �� " +m + " .. " + m.name);
			}
			
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("failed..  " + e.toString());
		}
		
	}
}
