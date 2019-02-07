class Source08_UseMarket {
	public static void main(String[] args) {
		Player u = new Player("ȫ�浿",20000);
		Market m = new Market();
		System.out.println(m.s1.current() +" / " + u.balance);

		boolean b = m.buyStock(1, 30, u);
		System.out.println(b);

		System.out.println(m.s1.current() +" / " + u.balance);
	}
}
