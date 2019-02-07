package java_plus;

abstract class abs_shape{
	double area, border;
	abstract double getArea();
	abstract double getBorder();
	abstract String getKind();
	
	void print() {
		System.out.println("도형종류: "+getKind());
		System.out.println("너비: "+getArea());
		System.out.println("둘레: "+getBorder());
		
	}
}

class abs_rec extends abs_shape{
	int h,w;
	public abs_rec(int h, int w) {
		this.h = h;
		this.w = w;
	}
	
	@Override
	double getArea() {
		return w*h;
	}
	@Override
	double getBorder() {
		return (w+h)*2;		
	}
	@Override
	String getKind() {
		return "사각형";
	}
}
	
	
public class Chap09_2_추상클래스_인터페이스 {
	/*
	 * @param args
	 */
	public static void main(String[] args) {
		abs_shape sh = new abs_rec(5,4);
		sh.print();
	}
}