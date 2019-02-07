package clientGUI;

public class BankClientTest {
	public static void main(String[] args) {
		// gui 등 적용시 편하게 하기 위해서 객체만 생성하고 실행하도록
		// engine 객체 만들고 사용하듯이
		BankClientNetwork net = new BankClientNetwork("127.0.0.1");
		
		String r1 = net.sendAndReceive("create");
		System.out.println(r1);
		String r2 = net.sendAndReceive("get#asdasdasd#1234");
		System.out.println(r2);
	}
}
