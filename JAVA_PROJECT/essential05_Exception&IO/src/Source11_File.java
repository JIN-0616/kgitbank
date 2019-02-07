/*
 * 지금 FileInputStream, FileOutputStream 객체를 이용해서, (inout기준 : 프로그램기준)
 * 파일시스템내에 존재하는 파일을 대상으로 입출력을 진행해보았다.
 *  (의미있는 데이터 입출력을 위해 지원하는 DataInput,OutputStream까지)
 * 
 * 객체생성을 하면서, 문자열로 대상을 저장했지만, 내부적으로는 File 객체로 바뀌게 된다.
 * 앞으로 프로그래밍을 계속 해나가기 위해서 혹은 좀 더 발전된 파일입출력을
 * 하기 위해선, 이 객체 사용법을 익혀둘 필요가 있다.
 * 
 * File 객체는 시스템상에 존재하는 디렉터리, 파일을 관리하기 위한 객체
 */
import java.io.File;
import java.util.Iterator;
public class Source11_File {
	public static void main(String[] args) {
		//파일 객체를 생성하는 방법은 크게 3가지 형태가 있음
		
		// String으로 경로 지정 
		// ( 절대경로 도 가능하고, 상대경로도 가능함, 파일이나 디렉터리 잡을수 있다. )
		System.out.println(System.getProperty("user.home")); //홈디렉터리 출력
		System.out.println(System.getProperty("user.name")); //유저명 출력
		
		File home = new File(System.getProperty("user.home"));
		
		File[] ar = new File[] { // 절대경로 / 상대경로
				new File("c:\\workspace"),
				new File("c:\\workspace\\.gitignore"),
				new File("bin"),
				new File(".classpath"),
				new File("Intro.dat"),
				new File("c:\\workspace", "workspace_java"), // 절대경로(소속) + 파일명(폴더명)
				new File(home, "Desktop") 					 // 소속(상위개체) + 이름
		};
		
		// .exists() , isDirectory() , isFile()
		// .getAbsolutePath()-절대경로 , .getPath()-설정되어있는경로
		// String.getAbsolutePath()
		
		for (int i = 0; i < ar.length; i++) {
			File t = ar[i];
			System.out.println(t.exists() + "? "+t.isDirectory()+" / "+ t.isFile());
			System.out.println(t.getAbsolutePath() + " vs "+t.getPath()); // String.getAbsolutePath()
			String name = t.getName();
			String parent = t.getParent(); // 부모(소속) , 상대경로 지정시 parent = null;
			long len = t.length();		   // File 이라면 파일 크기 반환(단위 byte),
										   // directory 라면 의미 없는 숫자임	
			if(t.isDirectory()) {
				String[] li = t.list();
				System.out.println("li = "+li.length); // 디렉터리 내부 존재하는것들의 숫자, DIR 아니면 터짐
				for (String m : li) {
					File child = new File(t, m);
					System.out.println("       "+m+ (child.isDirectory() ? "    DIR" : "    FILE"));
				}
			}
			System.out.println("name = "+name);
			System.out.println("parent = "+parent);
			System.out.println("len = "+len);
			
			System.out.println();
			System.out.println();
		}
		
		//=====================================================================
		// 시스템 파일 정보확인 시 tip
		File target = new File(home, ".p2");
		System.out.println(target.isDirectory());
		String p = target.getParent();
		System.out.println(p);
		
		File fp = target.getParentFile(); // 바로 윗단계를 파일객체로
		System.out.println(home.equals(fp) + ", "+(home==fp));
		//equals는 처리되어있어서 true, 같은 객체는 아님
		
		String[] c = target.list();		
		File[] fc = target.listFiles();	  // 하위 객체들을 파일객체로
		for (File t : fc) {
			System.out.println(t.getAbsolutePath()+", "+t.getName()+", "+t.getParent());
		}		
		
	}
}

/*
C:\Users\kgitbank
kgitbank
true? true / false
c:\workspace vs c:\workspace
li = 16
       .git    DIR
       .gitignore    FILE
       .metadata    DIR
       .recommenders    DIR
       a    DIR
       essential01_Array1    DIR
       essential02_String    DIR
       essential03_Wrapper    DIR
       essential04_Collections    DIR
       essential05_Exception&IO    DIR
       essentialAll.zip    FILE
       IndiaEngine.java    FILE
       special01_GUI    DIR
       special01_GUI_A    DIR
       workspace_editplus    DIR
       workspace_java    DIR
name = workspace
parent = c:\
len = 12288


true? false / true
c:\workspace\.gitignore vs c:\workspace\.gitignore
name = .gitignore
parent = c:\workspace
len = 28


true? true / false
C:\workspace\essential05_Exception&IO\bin vs bin
li = 18
       Account.class    FILE
       CriticalException.class    FILE
       CustomScanner.class    FILE
       Exercise01_NoDataInOut.class    FILE
       InvalidException.class    FILE
       NonTriangleException.class    FILE
       Source01_Exception.class    FILE
       Source02_Exception.class    FILE
       Source03_Exception.class    FILE
       Source04_Exception.class    FILE
       Source05_Exception.class    FILE
       Source06_Exception.class    FILE
       Source07_Output.class    FILE
       Source08_DataOutput.class    FILE
       Source09_Input.class    FILE
       Source10_DataInput.class    FILE
       Source11_File.class    FILE
       Triangle.class    FILE
name = bin
parent = null
len = 8192


true? false / true
C:\workspace\essential05_Exception&IO\.classpath vs .classpath
name = .classpath
parent = null
len = 301


false? false / false
C:\workspace\essential05_Exception&IO\Intro.dat vs Intro.dat
name = Intro.dat
parent = null
len = 0


true? true / false
c:\workspace\workspace_java vs c:\workspace\workspace_java
li = 1
       essential01    DIR
name = workspace_java
parent = c:\workspace
len = 0


true? true / false
C:\Users\kgitbank\Desktop vs C:\Users\kgitbank\Desktop
li = 7
       desktop.ini    FILE
       dev(192.168.10.27).lnk    FILE
       eclipse F.lnk    FILE
       Eclipse Java 2018-09.lnk    FILE
       EditPlus.lnk    FILE
       Git GUI.lnk    FILE
       share(192.168.10.27).lnk    FILE
name = Desktop
parent = C:\Users\kgitbank
len = 4096


true
C:\Users\kgitbank
true, false
C:\Users\kgitbank\.p2\org.eclipse.equinox.p2.core, org.eclipse.equinox.p2.core, C:\Users\kgitbank\.p2
C:\Users\kgitbank\.p2\org.eclipse.equinox.p2.engine, org.eclipse.equinox.p2.engine, C:\Users\kgitbank\.p2
C:\Users\kgitbank\.p2\org.eclipse.equinox.p2.repository, org.eclipse.equinox.p2.repository, C:\Users\kgitbank\.p2
C:\Users\kgitbank\.p2\pool, pool, C:\Users\kgitbank\.p2
C:\Users\kgitbank\.p2\pools.info, pools.info, C:\Users\kgitbank\.p2
C:\Users\kgitbank\.p2\profiles.info, profiles.info, C:\Users\kgitbank\.p2

*/