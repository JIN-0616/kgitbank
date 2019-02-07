import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Source16_Serializable {
	public static void main(String[] args) {
		/*
		 * Source15에서 출력했던 item 객체를 읽어내서 제대로 확보했는지 확인작업
		 */
		User n = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("v해적왕v"));) {
			System.out.print("input try..");
			n = (User)ois.readObject();	
			System.out.println("success");
			
			System.out.println(n.toString());
			for(Item m : n.li) {
				System.out.println("    -"+m+" .. "+m.name);
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("fail... "+e.getMessage());
		}
		
		/* ################################################################
		 * 
		 * try~catch 문과 throws문의 차이
		 * 
		 * --> 트렌잭션 관리의 차이
		 * 
		 * --> 롤백의 문제를 고려
		 * 
		 * --> 코드의 진행상황과 정합성을 고려해야한다.
		 * 
		 * => main에 throws 처리를 하게되면 해당 예외가 발생한 구문만 실행이 안됨
		 *   try~ catch문을 걸게되면 try내부 구분이 모두 실행이 안됨
		 * 
		 * ################################################################
		 */
	}
}
