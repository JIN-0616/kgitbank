package test01;

public class test {
	private int Gtotal; // ��������=field
		
	public static void main(String[] args) {
		
	}//main end
	
	public String book(){
		String title="�����"; //��������
		System.out.println("å����: " + title);
		return title;		
	}//book end
	
	public void note() {
		String msg=book();
		System.out.println("å����: " + book());
		System.out.println("å����: " + msg);		
	}//note end
	
}//class END
