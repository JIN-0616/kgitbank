class Source05_UseUtils {
	public static void main(String[] args) 	{
		Utils u = new Utils();
		int v = u.max(3, 5);
		System.out.println(v);
		int vv = Utils.max(5, 6);
		System.out.println(vv);
		Math.random();
		/*
			main �� �� static �� �ֳ�..? 
		*/
	// 	Source05_UseUtils.main(null);
		Source04_Time s = new Source04_Time();
		s.main(null);
		/*
			java Source05_UseUtils ==>
			main�� static�� �ƴ϶��, ��ü������ �ؼ� call�� �ؾ߸� ������ �ȴ�.
			JVM ���� �����ڵ� ������ �ش簴ü�� ������Ű�� �ɷ��� ���.
		*/
		Source01_UseBot.main(null);
	}
}