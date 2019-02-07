import java.io.File;
import java.io.IOException;

public class Source12_File {
	public static void main(String[] args) {
		// File 객체를 통해서 정보를 얻는것 뿐만 아니라 ,
		// 프로그램적으로 파일시스템 제어를 할수가 있다.
		
		File root = new File("c:\\data\\temp\\");
		
		File t = new File(root, "storage");
		System.out.println(t.getAbsolutePath() + " ? " + t.exists());
		boolean f = t.mkdirs();	// 디렉터리 생성하는것..! 성공여부가 리턴됨.
		System.out.println(f);	// 이미 있거나, 만들수 없는 곳에 만들려고 할때
		
		// mkdir 보다는 mkdirs 기능이 좀더 활요이 많이 된다. 중간단계를 만들기 때문에
		File a = new File(t, "data.sav");
		/*
		try {
			boolean r = a.createNewFile();	// FileOutput시 exception 뜨는 상황과 같다.
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
		boolean z = tt.delete();	// 파일은 100프로 지워지고, 디렉은 자식이 없을때만 지워짐
		
	}
}
