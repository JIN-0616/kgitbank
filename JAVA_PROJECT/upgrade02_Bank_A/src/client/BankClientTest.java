package client;

public class BankClientTest {
	public static void main(String[] args) {
		BankClientNetwork net = new BankClientNetwork("192.168.10.27");
		String r1 =net.sendAndReceive("create");
		System.out.println(r1);
		String r2 = net.sendAndReceive("get#c63b0c99#11d11");
		System.out.println(r2);
		
	}
}
