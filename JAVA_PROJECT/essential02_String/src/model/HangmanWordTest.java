package model;

public class HangmanWordTest {
	public static void main(String[] args) {
		HangmanWord w = new HangmanWord("DIAMOND");
		
		System.out.println(w.toString()); // ?????? [¢¾¢¾¢¾¢¾¢¾]

		boolean b = w.mark('A');
		System.out.println(b); //true
		
		System.out.println(w.toString()); // ??A??? [¢¾¢¾¢¾¢¾¢¾]
		
		boolean bb = w.mark('F'); 
		System.out.println(bb); // false

		System.out.println(w.toString()); // ??A??? [¢¾¢¾¢¾¢¾]
		
		boolean bbb = w.mark('D');
		System.out.println(bbb); //true
		
		System.out.println(w.toString()); // D?A??D [¢¾¢¾¢¾¢¾]
		
		System.out.println(w.isRevealed()); //false
		w.mark('I');
		w.mark('M');
		w.mark('O');
		w.mark('N');
		
		System.out.println(w.isRevealed()); //true
		

	}
}
