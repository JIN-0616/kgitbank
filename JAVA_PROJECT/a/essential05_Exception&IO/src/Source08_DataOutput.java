import java.io.*;

public class Source08_DataOutput {
	public static void main(String[] args) {
		/*
		 * ���Ͽ� ��µǾ�� �ϴ� ���´� 1byte �� ��ġ�̴�.
		 * �� �⺻ ��»��·δ�, ���ϴ� �����͸� ����ϱ� �����.
		 */
		try {
			FileOutputStream fos = new FileOutputStream("output.data");
			
			System.out.println("output ready.. " + (fos instanceof OutputStream));
			// DataOutputStream ��ü�� FileOutputStream ��ü���� ����Ǵ°� �ƴϰ�, 
			// OutputStream ��ü�� �� �ȴ�. 
			DataOutputStream dos = new DataOutputStream(fos);
			// �� ��ü�� �̿��ϰ� �Ǹ�,
			dos.writeInt(4561221);
			dos.writeDouble(3.141592);
			dos.writeBoolean(true);
			dos.writeUTF("ȫ�浿");	// ���ڿ� ���
			dos.writeInt(30);			
			
			dos.close();
			System.out.println("try data out success!!");
			
		}catch(IOException e) {	// �ͼ��ǵ�, ��ü�� ���� �ִ� ������ ������ ������ �����Ҽ� �ִ�.
			// FileNotFoundException �� IOException �� ������ ó���� ��ٰ� �����. 
			System.out.println("try fail.. cause " + e.getMessage() );
		}
		
	}
}
