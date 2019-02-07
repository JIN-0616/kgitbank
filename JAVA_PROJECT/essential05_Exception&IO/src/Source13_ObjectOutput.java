import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 *  DataInput/OutputStream 을 이용해서 ,
 *   기본value를 파일에 출력하고 읽어내는 작업에 대해 알아보고, 사용해보았다.
 *  
 *  실제 DataStream만을 이용해서 입출력을 진행하는 상황은 많지 않다.
 *   출력하고자 하는 데이터가 복잡하면 (이전 카드 뽑기에서 사용했던 데이터)
 *   일일이 다 따로따로 출력해야되고, 복원시에도 일일히 읽어서 하나라 묶어야 되고
 *   
 *  이번에 살펴볼 객체는 ObjectInput,OutputStream 객체인데,
 *   객체단위로 입출력을 할수있게 지원하는 입출력이다.
 *  
 */
public class Source13_ObjectOutput {
	public static void main(String[] args) {
		int[] data = new int[] {4,1,4,15,11,6,2};
		boolean[] flag = new boolean[] {true, true, false};
		String day = "WED";
				
		try {	//dataoutput 0바이트 기준 / ObjectOutputStream - 기본 4바이트  
			FileOutputStream fos = new FileOutputStream("array.sav"); // 이게 성공했다면,
			ObjectOutputStream oos = new ObjectOutputStream(fos);	  // 여긴 별다른 익셉션이 발생안함
				// ObjectOutputStream 을 열게 되면 기본 4byte 출력이 일단 일어남
			System.out.println("try success! output ready!");
			
			oos.writeObject(data); // 객체를 출력시키면, 복원에 필요한 형태로 해당 객체를 출력함
								   // 처음 4byte 기본출력, int->Integer 출력
			oos.writeObject(flag);
			oos.writeObject(day);
			
			System.out.println("output complete");
			oos.close();
		} catch (IOException e) {
			System.out.println("fail... "+e.getMessage());
		}
	}
}
