import java.io.File;

/*
 * ���� FileInputStream, FileOutputStream ��ü�� �̿��ؼ�,
 * ���� �ý��۳��� �����ϴ� ������ ������� ������� �����غ��Ҵ�
 * 	(�ǹ��ִ� ������ ������� ���� �����ϴ� DataInput,OutputStream ���� )
 * 
 * ��ü������ ���ڿ��� ����� ����������, ���������δ� File ��ü�� �ٲ�� �ȴ�.
 * ������ ���α׷����� ��� �س��������ؼ� Ȥ�� �� �� ������ ����������� 
 * �ϱ� ���ؼ�, �� ��ü ������ ������ �ʿ䰡 �ִ�.
 * 
 * File ��ü�� �ý��ۻ� �����ϴ� ���͸�,������ �����ϱ� ���� ��ü
 */

public class Source11_File {
	public static void main(String[] args) {
		// ���� ��ü�� �����ϴ� ����� ũ�� 3���� ���°� ����.
		// String���� ��� ���� 
		// (������ �� �����ϰ�, ����ε� ������, �����̳� ���͸� ������ �ִ�.)
	//	System.out.println(System.getProperty("user.home"));
	//	System.out.println(System.getProperty("user.name"));
		
		File home = new File(System.getProperty("user.home"));
		File[] ar = new File[] {
			new File("c:\\dev\\workspace_II"),
			new File("c:\\dev\\01.����.txt"),
			new File("bin"),
			new File(".classpath"),
			new File("c:\\dev", "workspace_I"),
			new File(home, "Desktop")
		};
		
		for(int i=0; i<ar.length; i++) {
			File t = ar[i];
			System.out.println(t.exists() + "? " +(t.isDirectory() +" / " + t.isFile()));
			System.out.println(t.getAbsolutePath() + " vs " + t.getPath());	// String getAbosolutePath	
			String name = t.getName();
			String parent = t.getParent();
			long len = t.length();
			System.out.println("name = " + name);
			System.out.println("parent = " + parent);
			System.out.println("len = " + len);	// file �̶�� ���� ũ�� ���� (���� byte)
												// directory ��� �ǹ� ���� ������
			if(t.isDirectory()) {
				String[] li = t.list();
				System.out.println("li = " + li.length);
				for(String m: li) {
					File child = new File(t, m);
					System.out.println("    "+ m +   (child.isDirectory() ? "    DIR" : "   FILE") );
				}
			}
			System.out.println();
			System.out.println();
		}
		
		//=======================================================
		File target = new File(home, ".p2");
		System.out.println(target.isDirectory());
		String p = target.getParent();
		System.out.println(p);
		File fp = target.getParentFile();	// �ٷ� ���ܰ踦 ���ϰ�ü�� 
		System.out.println(home.equals(fp) + " ,  " + (home == fp));
		String[] c = target.list();
		File[] fc = target.listFiles();
		for(File t : fc) {
			System.out.println(t.getAbsolutePath() +" , " + t.getName() +" , " + t.getParent());
		}
		
		
			
		
		
		
		
		
		
		
		
		
		
	}
}




