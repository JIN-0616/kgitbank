class Source04_UseEnum {
	public static void main(String[] args) 	{
		System.out.print("����� ü����?");
		double kg = Double.valueOf(System.console().readLine());
		Planet e = Planet.valueOf("EARTH");
		double w = kg/e.getGravity();
		String ch  = "MERCURY";
		Planet m = Planet.valueOf(ch);

		double mw = w * m.getGravity();
		System.out.println("�������� ���� �Ǹ� .. " +mw +"kg �����Դϴ�");
	}
}
