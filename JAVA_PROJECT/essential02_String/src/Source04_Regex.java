/*
 *  Á¤±Ô½Ä : regular expression
 */
public class Source04_Regex {
	public static void main(String[] args) {
		// Á¤±Ô½ÄÀº ¹®ÀÚ¿­·Î ÀÛ¼ºÇÏ¸é µÈ´Ù.
		// ±× ¾È¿¡ ¹®ÀÚ°ªµéÀÌ, ÆĞÅÏÀ» ºĞ¼®ÇÏ´Âµ¥ »ç¿ëµÈ´Ù.
		
		/*	.matches(String regex)
		 * 
		 *  [] : ÇÑ ¹®ÀÚ¸¦ ³ªÅ¸³»°íÀÚ ÇÒ¶§ »ç¿ë, ÀÌ ¾È¿¡ ÀûÇôÀÖ´Â ¹®ÀÚ´Â ÀüºÎ or Ã³¸®
		 *  
		 *     : ÀÌ ¾È¿¡ ¹®ÀÚ±¸¼ºÀ» ÇÏ°íÀÚ ÇÒ¶§, ¿¬°áµÇ¾îÀÖ´Â ¹®ÀÚ°ªÀÌ¶ó¸é - Ã³¸®°¡ °¡´ÉÇÔ
		 *     
		 *    ¿¹¸¦ µé¾î [A-Za-z] ¾ËÆÄºª, [°¡-ÆR] ÇÑ±Û¿Ï¼ºÇü¹®ÀÚ
		 *    
		 *     : ^¸¦ ºÙÀÌ¸é Á¦¿Ü¸¦ ÀÇ¹ÌÇÑ´Ù.
		 *  
		 *  ¸ğµç ±¸¸¨À» ¸¸µé¾î¼­ ½á¾ßµÇ´Â°Ç ¾Æ´Ï°í,
		 *  ¹Ì¸® Á¤ÇØÁ® ÀÖ´Â Æ¯¼ö ±×·ìÀÌ ÀÖ´Ù.
		 *  
		 *  .  : (¾Æ¹«¹®ÀÚ) anychar
		 *  
		 * \\d : ¼öÄ¡Çü ¹®ÀÚ : ==>[0-9]
		 * \\D : ¼öÄ¡Çü ¹®ÀÚ Á¦¿Ü : ==>[^0-9]
		 * 
		 * \\w : ¹®ÀÚÇü ¹®ÀÚ :  ==> [A-Za-z_0-9] -¾ğ´õ¹Ù(_)Æ÷ÇÔ
		 * \\W : ¹®ÀÚÇü ¹®ÀÚ Á¦¿Ü :  \\w Á¦¿Ü
		 * 
		 * \\s : °ø¹éÇü ¹®ÀÚ
		 * \\S : °ø¹éÇü ¹®ÀÚ Á¦¿Ü
		 */
		String[] sample = "È«±æµ¿,trump,arump, rump,trumt,te0505,Arump".split(",");
		for (int i = 0; i < sample.length; i++) {
			String s = sample[i];
			System.out.print("["+i+"] "+s+" : ");
			//System.out.println(s.matches("[at]rum[pt]")); // [a or t] / [p or t]
			//System.out.println(s.matches("[a-t]rum[pt]"));	// [a ~ t]
			//System.out.println(s.matches("[^a-p]rum[pt]")); // [not a ~ p]
			System.out.println(s.matches(".rum[pt]")); // . ¾Æ¹«¹®ÀÚ»ó°ü¾øÀ½ °ø¹éµµÆ÷ÇÔ			
		}
		System.out.println("13".matches("\\d\\d"));
		System.out.println("loc_p5".matches("loc_[a-z]\\d")); 
		System.out.println("loc_p5".matches("loc_[a-z][0-9]")); // ==
		System.out.println("loc_pa".matches("loc_[a-z]\\D"));
		
				
	}
}
