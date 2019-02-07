
abstract class Advertisement {
	String ment;
	void start(String m) {
		ment = m;
		System.out.println("─광고시작─");
		effect();
	}
	abstract void effect();
}
//===========================================================
class Shop {
 	Advertisement adv;
	String name;
	Shop(String n) {
		name = n;
	}
	void setAdv(Advertisement adv) {
		this.adv = adv;
	}
	void open() {
		adv.start(name);
	}
}
//================================================================================
class MarkAdv extends Advertisement {
	void effect() {
		for(int cnt=1; cnt<=3; cnt++) {
			System.out.println(ment+"!");
		}
	}
}
class ArrowAdv extends Advertisement {
	void effect() {
		for(int cnt=1; cnt<=5; cnt++) {
			// 1==> 1, 2==>2  , 3==>3 , 4==>2 , 5==> 1
			int gx = cnt >=3 ? cnt-3 : 3-cnt;
			for(int scnt =1; scnt<= 3 - gx ; scnt++) {
					System.out.print(ment+" ");
			}
			System.out.println();
		}
	}
}
//=============================================================
class Source02_UseAbstract {
	public static void main(String[] args) 	{
		Shop s = new Shop("청초수물회");
		Advertisement a = new MarkAdv();
		s.setAdv(a);
		s.open();
		Advertisement b = new ArrowAdv();
		s.setAdv(b);
		s.open();
	}
}
