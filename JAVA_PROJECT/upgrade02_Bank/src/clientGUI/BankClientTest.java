package clientGUI;

public class BankClientTest {
	public static void main(String[] args) {
		// gui �� ����� ���ϰ� �ϱ� ���ؼ� ��ü�� �����ϰ� �����ϵ���
		// engine ��ü ����� ����ϵ���
		BankClientNetwork net = new BankClientNetwork("127.0.0.1");
		
		String r1 = net.sendAndReceive("create");
		System.out.println(r1);
		String r2 = net.sendAndReceive("get#asdasdasd#1234");
		System.out.println(r2);
	}
}
