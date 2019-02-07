import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Source16_Serializable {
	public static void main(String[] args) {
		/*
		 * Source15_ 에서 출력했던 User 객체를 읽어내서 제대로 확보됫는지...
		 * 확인작업을 해보자.
		 * 
		 */
		try (ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream("v해적왕v"));) {
			System.out.print("input try..");
		
			User got = (User)ois.readObject();
			
			System.out.println("success!");
			System.out.println(got.toString());
			for(Item m :  got.li) {
				System.out.println("    → " +m + " .. " + m.name);
			}
			
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("failed..  " + e.toString());
		}
		
	}
}
