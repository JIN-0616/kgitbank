import java.io.File;
import java.io.IOException;

public class Source12_File {
	public static void main(String[] args) {
		// File 객체를 통해서 단순히 정보를 얻는것 뿐만 아니라,
		// 프로그램적으로 파일시스템 제어를 할 수가 있다.
		
		File root = new File("c:\\workspace\\temp");
		
		File t = new File(root, "storage");
		System.out.println(t.getAbsolutePath()+ " ? "+ t.exists());
		boolean f = t.mkdirs(); // 디렉토리 생성 : 성공여부 리턴됨
							   // 없을때 생성하면서 true 리턴,
							   // 존재하거나, 상위가 존재하지않거나, 접근권한없거나 ..해서 생성불가면 false
		System.out.println(f);
		
		// mkdir() 보다는 mkdirs() 기능이 좀더 활용이 많이 된다. why? 중간단계를 만들기 때문에
		File a =new File(t, "data.sav");
		/*
		try {
			boolean r =a.createNewFile(); //FileOutput 시 exception 뜨는 상황과 동일하게
			
										  // .createNewFile 은 try~catch 처리가 필요하다
			System.out.println(r);
		} catch (IOException e) {
			System.out.println("fail");
		}
		*/
		boolean rf = a.renameTo(new File(root, a.getName())); 
		// a.renameTo(new File(root, a.getName())); // 이동위치, 이름 
		System.out.println("renameTo = "+ rf); //재이름 설정 : 기존의 것을 삭제하고 이동
		
		root.renameTo(new File("c:\\", root.getName())); // 디렉토리는 이름변경 이동, 내부목록도 이동 
		
		File tt = new File("c:\\temp", "data.sav");
		boolean z = tt.delete(); // 파일은 존재만 하면 100% 지워짐
								 // 디렉터리는 자식이 없을때만(빈 디렉터리만) 지워짐
		System.out.println(z);
	}
}
