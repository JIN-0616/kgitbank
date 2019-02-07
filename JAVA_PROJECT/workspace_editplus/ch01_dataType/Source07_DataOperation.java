class Source07_DataOperation {
	public static void main(String[] args) {
		/*
			¼öÄ¡ µ¥ÀÌÅÍ¸¦ °¡Áö°í ÇÒ¼ö ÀÖ´Â ºñ±³ÀÛ¾÷µéµµ ÀÌ¾î¼­ »ìÆìº¸ÀÚ

			Å©±âºñ±³ ( >, >=, < , <=), µ¿µîºñ±³ ( ==, != )¸¦ Áö¿øÇÑ´Ù.
			°á°ú´Â true, false ·Î ¹ß»ıÇÏ°í, ÀÌ ÀÛ¾÷Àº ½Ç¼öµµ °¡´ÉÇÏ´Ù.
		*/
		System.out.println(32 > 10);  //T
		System.out.println(34<<1 > 100);  //F
		System.out.println(34>>1 == 17);  //T
		System.out.println(64>>1 != 16<<1); //F
		System.out.println(100.0 > 99.9);

		/*
			¹®ÀÚ µ¥ÀÌÅÍ(È¦µû¿ÈÇ¥·Î Ç¥±âÇÑ) ¿ª½Ã ¹æ±İ±îÁö »ìÆìº» ÀÛ¾÷ÀÌ °¡´ÉÇÑµ¥
			½ÇÁ¦ÀûÀ¸·Î´Â Á¤¼öÃ³·³ Ã³¸®°¡ µÇ±â ¶§¹®¿¡ ±×·¸´Ù.
		*/
		System.out.println('°¡'+0); // °¡=44032
		System.out.println('°¡'+'³ª'); // 89240
		System.out.println('°¡'*'³ª'); 
		System.out.println('°¡'/'³ª'); 
		System.out.println('°¡'<'³ª'); 
		System.out.println('°¡'>>1);
		
		// ¿Ï¼ºÇü¹®ÀÚµî·ÏÀÌ ½ÃÀÛÀº '°¡' ºÎÅÍ 'ÆR' ±îÁö Â÷·Ê´ë·Î ¹øÈ£°¡ ¼³Á¤µÇ¾îÀÖ´Ù.
		// ÃÑ ¸î°³ µî·ÏÀÌ µÇÀÖ´Â°É±î?
		// system.out.println(10-1+1); //10°³
		System.out.println('ÆR'-'°¡'+1); //11172°³
		System.out.println('z'-'a'+1); // 26
		System.out.println('Z'-'A'+1); // 26
		System.out.println('a'*1);	// 97
		System.out.println('A'+0);	// 56
	}
}
