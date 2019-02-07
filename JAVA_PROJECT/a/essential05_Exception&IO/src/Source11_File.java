import java.io.File;

/*
 * 지금 FileInputStream, FileOutputStream 객체를 이용해서,
 * 같은 시스템내에 존재하는 파일을 대상으로 입출력을 진행해보았다
 * 	(의미있는 데이터 입출력을 위해 지원하는 DataInput,OutputStream 까지 )
 * 
 * 객체생성시 문자열로 대상을 지정했지만, 내부적으로는 File 객체로 바뀌게 된다.
 * 앞으로 프로그래밍을 계속 해나가기위해서 혹은 좀 더 발전된 파일입출력을 
 * 하기 위해선, 이 객체 사용법을 익혀둘 필요가 있다.
 * 
 * File 객체는 시스템상에 존재하는 디렉터리,파일을 관리하기 위한 객체
 */

public class Source11_File {
	public static void main(String[] args) {
		// 파일 객체를 생성하는 방법은 크게 3가지 형태가 있음.
		// String으로 경로 지정 
		// (절대경로 도 가능하고, 상대경로도 가능함, 파일이나 디렉터리 잡을수 있다.)
	//	System.out.println(System.getProperty("user.home"));
	//	System.out.println(System.getProperty("user.name"));
		
		File home = new File(System.getProperty("user.home"));
		File[] ar = new File[] {
			new File("c:\\dev\\workspace_II"),
			new File("c:\\dev\\01.설정.txt"),
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
			System.out.println("len = " + len);	// file 이라면 파일 크기 나옴 (단위 byte)
												// directory 라면 의미 없는 숫자임
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
		File fp = target.getParentFile();	// 바로 윗단계를 파일객체로 
		System.out.println(home.equals(fp) + " ,  " + (home == fp));
		String[] c = target.list();
		File[] fc = target.listFiles();
		for(File t : fc) {
			System.out.println(t.getAbsolutePath() +" , " + t.getName() +" , " + t.getParent());
		}
		
		
			
		
		
		
		
		
		
		
		
		
		
	}
}




