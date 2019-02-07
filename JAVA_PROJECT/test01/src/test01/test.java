package test01;

public class test {
	private int Gtotal; // 전역변수=field
		
	public static void main(String[] args) {
		
	}//main end
	
	public String book(){
		String title="몽블랑"; //지역변수
		System.out.println("책제목: " + title);
		return title;		
	}//book end
	
	public void note() {
		String msg=book();
		System.out.println("책제목: " + book());
		System.out.println("책제목: " + msg);		
	}//note end
	
}//class END
