package sample;

public class LineBingoTest {
	public static void main(String[] args) {
		LineBingo u = new LineBingo();
		System.out.println(u.toString());
		
		System.out.println(u.toHiddenString());
		
		boolean f1 = u.mark(1);
		boolean f2 = u.mark(2);
		boolean f3 = u.mark(3);
		System.out.println(f1+" / "+f2+" / "+f3);
		System.out.println(u.toHiddenString());
		System.out.println(u.isRevealed());
	}
}
