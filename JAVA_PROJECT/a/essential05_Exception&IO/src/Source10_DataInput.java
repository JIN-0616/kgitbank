import java.io.*;

public class Source10_DataInput {
	public static void main(String[] args) {
		/*
		 * DataOutput�� �ݴ�Ǵ� �۾��� �ϴ� DataInputStream ��ü�� ���캸��.
		 */
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("output.data"));
			// IOException �迭�� FileNotFoundException
			System.out.println(dis.available());
			int m = dis.readInt();
			System.out.println("data = " +m );
			System.out.println(dis.available());
			double e = dis.readDouble();
			System.out.println(e);
			System.out.println(dis.available());
			boolean f = dis.readBoolean();
			System.out.println(f);
			String s = dis.readUTF();	// IO �迭�� UTFDataFormatException
			System.out.println(s);
			System.out.println(dis.readInt());
			System.out.println("available = " + dis.available());
			dis.readInt();	// �о �����Ͱ� ������ IOException �� �迭�� EOFException �� �߻�
			dis.close();
			System.out.println("try success");
		}catch(IOException e) {
			if(e instanceof UTFDataFormatException) {
				System.out.println("������ �ջ�̴�.");
			}
			System.out.println("fail..! " + e.toString());
		}
	}
}
