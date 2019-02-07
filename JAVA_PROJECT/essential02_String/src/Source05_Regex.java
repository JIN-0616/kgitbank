import java.util.Scanner;

public class Source05_Regex {
	public static void main(String[] args) {
		/*
		 * ¹æ±İ »ìÆìº»°ÍµéÀº ¹®ÀÚÇÏ³ª¸¦ ¼³Á¤ÇÑ°ÍÀÌ°í,
		 * 
		 * [Æ¯Á¤±×·ì] <Á¦ÇÑ¹®ÀÚ>
		 * 
		 * 				?	ÀÖ°Å³ª ¾ø°Å³ª {0,1}
		 * 
		 * 				+	1°³ ÀÌ»ó ÀÖ¾î¾ß µÈ´Ù {1,}
		 * 
		 * 				*	¾ø¾îµµ µÇ°í ¿©·¯°³°¡ ÀÖ¾îµµ µÈ´Ù. {0,}
		 * 	
		 * 				{n}		Á¤È®ÇÏ°Ô ¸î°³°¡ ÀÖ¾î¾ß µÈ´Ù
		 * 
		 * 				{n,}	ÃÖ¼ÒÇÑ ¸î°³°¡ ÀÖ¾î¾ß ÇÑ´Ù
		 * 
		 * 				{n,m}	ÃÖ¼Ò ¸î°³ ÀÌ»ó, ÃÖ´ë ¸î°³ ÀÌÇÏ
		 * 
		 */
		String[] s1 = "A1,A-1,B-14,C-".split(",");
		for (int i = 0; i < s1.length; i++) {
			System.out.println(s1[i]+ " matches "+ s1[i].matches("\\w-?\\d"));
		}
		System.out.println();//---------------
		String[] s2 = "A1,A-1,B-14,C-".split(",");
		for (int i = 0; i < s1.length; i++) {
			//System.out.println(s2[i]+ " matches "+ s2[i].matches("\\w-?\\d+")); //1°³ÀÌ»ó
			System.out.println(s2[i]+ " matches "+ s2[i].matches("\\w-?\\d*"));
		}
		System.out.println();//---------------
		String[] s3 = "41¿À9135,97 ³ª4539,1Çã3211".split(",");
		for (int i = 0; i < s3.length; i++) {
			System.out.println(s3[i]+ " matches "+ s3[i].matches("\\d{2}\\s?[°¡-ÆR]\\d{3,}"));
								// ³»ºÎÄŞ¸¶¶ç¾î¾²±âx,°ø¹é¾øÀÌ //¼ıÀÚ2,°ø¹é1ÀÖ¾ø,¹®ÀÚÇÏ³ª,¼ıÀÚ3°³ÀÌ»ó
		}
		
		Scanner cin = new Scanner(System.in);
//		System.out.println("ºñ»ó ¿¬¶ôÃ³? (ÈŞ´ëÀüÈ­ ¹øÈ£) : ");
//		String in = cin.nextLine();
//		System.out.println(in.matches("[0][1]\\d[-]?\\d{4}[-]?\\d{4}"));
								    // "01[01789]-?\\d{3,4}-?\\d{4}"
									//01046148225
									//kyoungho@kgitbank.co.kr
		
		/*
		 *  ÆĞÅÏÀ» Â©¶§ . + * ? [ ] { } ÀÌ·±½ÄÀÇ ÀÇ¹Ì¸¦ ´ã°íÀÖ´Â ¹®ÀÚÀÎµ¥
		 *  
		 *  ÀÌ°É ¹®ÀÚÀÚÃ¼·Î ÀÎ½Ä½ÃÅ°·Á¸é \\À» ºÙÀÌ°í »ç¿ë 
		 *  
		 *  Æ¯Á¤ÆĞÅÏÀ» ±×·ìÃ³¸®°¡ °¡´ÉÇÔ ( )
		 *  (»ç¿ëÀÚÆĞÅÏ) {1,2}
		 *  (»ç¿ëÀÚÆĞÅÏ) +
		 */
		
		System.out.println("°³ÀÎ ÀÌ¸ŞÀÏ? ");
		String addr = cin.nextLine();
		boolean rr = addr.matches("\\w{1,}@\\w{1,}(\\.\\w{1,}){1,2}"); // (.-> ±×³É ÀÔ·Â½Ã ¸ğµç¹®ÀÚ)
								  // \\w{1,}@\\w{1,}\\.\\w{1,}(\\.\\w{1,})*
		System.out.println("arr = "+rr);
	}
}
