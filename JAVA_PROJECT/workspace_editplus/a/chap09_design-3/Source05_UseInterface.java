/*
class GameEngine extends Engine {	}	
	: extends 의 대상이 interface 면, 더 큰 interface 확장을 하겠다는 소리
*/
interface SuperEngine extends Engine {
	boolean boost();
}
/*
	interface 를 토대로 class 를 설계하고 싶으면 extends 아니라 implements  라는걸 써야 한다.
*/
class GameEngine implements Engine {
	boolean attack;
	boolean flag;

	public void init() {
		attack = Math.random()>0.5;
		flag = true;
	}
	public boolean isRun() {
		return flag;
	}
	public String execute() {
		String str  = (attack ? "당신의 " : "상대방의 " ) +"공격 턴\n";
		str += "0.묵  1.찌  2.빠";
		return str;
	}
	private String convert(int ch) {
		switch(ch){
			case 0:	
				return "묵";	
			case 1:	
				return "찌";
			case 2:	
				return "빠";
			default :
				return "";
		}
	}

	public String check(String in) {
		int choice = Integer.valueOf(in);
		int auto = (int)(Math.random()*3);		// 0, 1, 2
		String cv = convert(auto);
		String str = "상대방은 " +  cv+" 을/를 냈다.";
		// branch 를 만들어서 출력을 해주면 된다.
		if(choice == auto) {
			if(attack) {
				str += "당신의 승리입니다.";
			}else {
				str += "상대방의 승리입니다.";
			}
			flag = false;
		} else {
			if(choice == 0 && auto == 2 || choice==1 && auto ==0 || choice == 2 && auto ==1) {
				if(attack) {
					str += "공격권이 넘어갔습니다.";
				} 
				attack= false;		
			} else {
				if(!attack) {
					str += "공격권을 가져왔습니다.";
				}				
				attack = true;	
			}
		}
		return str;
	}
}

class Source05_UseInterface {
	public static void main(String[] args) 	{
		
		OptionPanePlayer opp = new OptionPanePlayer();
		opp.start();
		
		Engine e = new GameEngine();
		opp.insert(e);
		opp.start();
		opp.remove();
		opp.start();
		
	}
}
