import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * DataInput/OutputStream 을 이용해서, 
 * 	기본밸류를 파일에 출력하고 읽어내는 작업에 대해 알아보고, 사용해보았다.
 * 
 * 실제 DataStream만을 이용해서 입출력작업하는상황은 많지 않다.
 *  출력하고자 하는 데이터가 복잡하면 (이전 카드 뽑기에서 사용했던 데이터)
 *  일일이 다 따로따로 출력해야되고, 복원시에도 일일이 읽어서 하나로 묶어야 되고
 *  
 * 이번에 살펴볼 객체는 ObjectInput,OutputStream 객체인데, 객체단위로 입출력을 할수 있게 해둔 입출력객체이다.
 */

public class Source13_ObjectOutput {
	public static void main(String[] args) {
		int[] data = new int[] {4, 1, 49, 15, 11, 6, 2};
		boolean[] flag = new boolean[]{true, true, false};
		String day = "WED";
		try {
			FileOutputStream fos = new FileOutputStream("arrays.sav");	// 이게 성공했다면,
			ObjectOutputStream oos = new ObjectOutputStream(fos);	// 이건 별다른 익셉션이 발생안함.
				// ObjectOutputStream 을 열게 되면 기본 4byte 출력이 일단 일어남. 
			System.out.println("try success! output ready!");
			
			oos.writeObject(data);	// 객체를 출력시키면, 복원에 필요한 형태로 해당 객체를 출력함.
			oos.writeObject(flag);	// 객체를 출력시키면, 복원에 필요한 형태로 해당 객체를 출력함.
			oos.writeObject(day);
			
			System.out.println("output complete!.");
			oos.close();
			
		}catch(IOException e) {
			System.out.println("fail .. " + e.getMessage());
		}
	}
}



