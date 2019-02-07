import java.io.File;
import java.io.IOException;

public class Source12_File {
	public static void main(String[] args) {
		// File ��ü�� ���ؼ� ������ ��°� �Ӹ� �ƴ϶� ,
		// ���α׷������� ���Ͻý��� ��� �Ҽ��� �ִ�.
		
		File root = new File("c:\\data\\temp\\");
		
		File t = new File(root, "storage");
		System.out.println(t.getAbsolutePath() + " ? " + t.exists());
		boolean f = t.mkdirs();	// ���͸� �����ϴ°�..! �������ΰ� ���ϵ�.
		System.out.println(f);	// �̹� �ְų�, ����� ���� ���� ������� �Ҷ�
		
		// mkdir ���ٴ� mkdirs ����� ���� Ȱ���� ���� �ȴ�. �߰��ܰ踦 ����� ������
		File a = new File(t, "data.sav");
		/*
		try {
			boolean r = a.createNewFile();	// FileOutput�� exception �ߴ� ��Ȳ�� ����.
			System.out.println(r);
		}catch(IOException e) {	// 
			System.out.println();
		}
		*/
		// boolean rf = a.renameTo(new File(a.getParentFile(), "data2.sav"));
		boolean rf = a.renameTo(new File(root, a.getName()));
		System.out.println("renameTo = " + rf );
		root.renameTo(new File("c:\\", root.getName()));
		
		File tt = new File("c:\\temp", "storage");
		boolean z = tt.delete();	// ������ 100���� ��������, ���� �ڽ��� �������� ������
		
	}
}
