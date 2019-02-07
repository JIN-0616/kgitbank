/*
 * String °´Ã¼ÀÇ ÇØÁÖ´Â °Íµé...
 */
public class Source03_String {
	public static void main(String[] args) {
		/*
		 * ´Ù¸¥ ¹®ÀÚ¿­°´Ã¼¿Í ºñ±³ÇØ¼­ ºñ±³°á°ú¸¦ ¾Ë·ÁÁÜ
		 */
		
		// 1. boolean equals(Object) : ¹®ÀÚ±¸¼ºÀÌ °°ÀºÁö È®ÀÎ
		
		// 2. boolean endsWith(String) : boolean StartWith(String)
		//	  - ÇØ´ç ¹®ÀÚ¿­·Î ½ÃÀÛÀ» ÇÑ´Ù°Å³ª, ³¡³­´Ù°Å³ª
		
		// 3. int compareTo(String) : Å©±âºñ±³ / abc¢¹°¡³ª´Ù ¼øÀ¸·Î °¥¼ö·Ï ¼ıÀÚ°¡ Ä¿Áü
		
		// 4. boolean matches(String) : Æ¯Á¤ ÆĞÅÏ(Á¤±Ô½Ä)¿¡ ºÎÇÕÇÏ´ÂÁö È®ÀÎ
		
		String[] names = "°ü¿ì,Á¶¿î,Á¶Á¶,È²Ãæ,ÇÏÈÄµ·,¸¶ÃÊ,»ç¸¶ÀÇ,Á¦°¥·®,ÇÏ¿ì¿¬".split(",");
		for (int i = 0; i < names.length; i++) {
			String s = names[i]; //names[i]¸¦ ÇØµµ µÇ°í
			System.out.println(s + "..."+ s.equals("°ü¿ì"));
			System.out.println("	..."+ s.startsWith("ÇÏÈÄ")+"..."+s.endsWith("ÀÇ"));
			System.out.println("    ..."+s.compareTo("Á¶Á¶")); // s - "Á¶Á¶"
			// ÀÚ±â°¡ °¡Áø ¹®ÀÚ¿­±¸¼ºÀÌ ´õ ÀÛÀ¸¸é À½¼ö, °°À¸¸é 0 , Å©¸é ¾ç¼ö
			System.out.println(" .. "+s.matches("°ü[°¡-ÆR]{1}"));
		}
		
		// Á¤±Ô½Ä?
		
		
	}
}
