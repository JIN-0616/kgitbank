import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Exercise02_Client {
	public static void main(String[] args) {
		/*
		 * TCP방식으로 가동되는 프로그램 같은 경우엔 매번 연결을 시도하는게 아니라,
		 */
		Scanner cin = new Scanner(System.in);
		System.out.print("[client] input server ip address : ");
		String ip = cin.nextLine();
		try(Socket soc = new Socket(ip, 56789);) {
			/*
			 * 프로그램이 시작되면서 한번 연결을 잡아서, IO 확보하고
			 */
			System.out.println("[client] connected to server");
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			System.out.println("[client] established i/o stream");
			
			// 재연결이나, io 재 확보 없이, 계속 유지 시킨상태에서 데이터 주고 받으면 된다.
			while(soc.isConnected()) {
				System.out.print("[client] request : ");
				String req = cin.nextLine();
				if(req.equals("exit")) {
					break;
				}
				oos.writeObject(req);
				String resp = (String)ois.readObject();
				System.out.println("[client] response : " + resp);			
			}
			
		}catch(ClassNotFoundException |IOException e) {
			System.out.println("[client] network error " + e.toString());
		}
		/*
		 * 서버측도 마찬가지이다.
		 * 한번 accept 받아서, io 확보 후 , 그다음에 사용자가 연결 끊을때까지 처리해주면 된다.
		 * 
		 * 이 프로그램을 이용해서 여러분들의 서버에 몇가지 형태의 요청을 보낼려고 한다.
		 * 이 요청을 처리해주는 TCP 서버를 만들면 된다.
		 *  
		 *  reserve#1-A   reserve#9-C  이 형태로 보낼꺼임.
		 *  	: reserve#숫자-알파벳    
		 *  	이미 1-A를 보낸적이 있다면, "false",  
		 *  	처음보내는거면 저장하고 "true"라고 보내주세요.
		 *  
		 *  cancel#1-A   cancel#9-B  이 형태로 보낼꺼임
		 *  	: cancel#숫자-알파벳
		 *  	이 데이터를 가지고 있었으면 지우고 "true" 없으면 "false"
		 *  		
		 * 	(사용자들이 보낸 데이터 관리는 컬렉션을 이용해서 관리,
		 * 	 어떤 형태의 컬렉션이 유용한지는 알아서 판단.)
		 * 		
		 * 
		 * 
		 */
		
		
	}
}
