class Source07_DataOperation {
	public static void main(String[] args) {
		/*
			¼öÄ¡ µ¥ÀÌÅÍ¸¦ °¡Áö°í ÇÒ¼ö ÀÖ´Â ºñ±³ÀÛ¾÷µéµµ ÀÌ¾î¼­ »ìÆìº¸ÀÚ.

			Å©±âºñ±³(>, >=, <, <=),  µ¿µîºñ±³( ==, !=) ¸¦ Áö¿øÇÑ´Ù.
			°á°ú´Â true, false ·Î ¹ß»ıÇÏ°í , ÀÌ ÀÛ¾÷Àº ½Ç¼öµµ °¡´ÉÇÏ´Ù
		*/
		System.out.println(34 > 10);
		System.out.println( ( 34<<1 ) >= 68);
		System.out.println(( 34>>1) == 17);
		System.out.println((64>>1) != (16<<1) );
		System.out.println( 100.0 > 99.9);

		/*
			¹®ÀÚ µ¥ÀÌÅÍ(È¦µû¿ÈÇ¥·Î Ç¥±âÇÑ) ¿ª½Ã ¹æ±İ±îÁö »ìÆìº» ÀÛ¾÷ÀÌ °¡´ÉÇÑµ¥,
			½ÇÁ¦ÀûÀ¸·Î´Â Á¤¼öÃ³·³ Ã³¸®°¡ µÇ±â ¶§¹®¿¡ ±×·¸´Ù.
		*/
		System.out.println('°¡' + 0);
		System.out.println('°¡' + '³ª');
		System.out.println('°¡' * '³ª');
		System.out.println('°¡' < '³ª');
		System.out.println('°¡' >> 1);
		
		// ¿Ï¼ºÇü¹®ÀÚµî·ÏÀÌ '°¡' ºÎÅÍÇØ¼­ 'ÆR' ±îÁö°¡ Â÷·Ê´ë·Î ¹øÈ£°¡ ¼³Á¤µÇÀÖ´Ù.
		// ÃÑ ¸î°³ µî·ÏÀÌ µÇÀÖ´Â°É±î?  11172 °³
		System.out.println('ÆR'-'°¡'+1);
		System.out.println('z'-'a'+1);
		System.out.println('Z'-'A'+1);
		System.out.println('z'-'A'+1);
		System.out.println('A'*1);
		System.out.println('a'+0);
	
	}

}
