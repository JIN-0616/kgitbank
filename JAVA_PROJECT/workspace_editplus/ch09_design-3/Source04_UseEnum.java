class Source04_UseEnum {
	public static void main(String[] args)	{
		System.out.print("당신의 체중은?");
		double kg = Double.valueOf(System.console().readLine());
					//주의할것
		Planet e = Planet.valueOf("EARTH");
		double w = kg/e.getGravity();
		
		String ch = "MERCURY";

		Planet m = Planet.valueOf(ch);
		double mw = w*m.getGravity();
		System.out.println("수성으로 가게되면..."+mw+"kg 정도입니다.");


	}
}
