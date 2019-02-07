/*
class GameEngine extends Engine {	}	
	: extends �� ����� interface ��, �� ū interface Ȯ���� �ϰڴٴ� �Ҹ�
*/
interface SuperEngine extends Engine {
	boolean boost();
}
/*
	interface �� ���� class �� �����ϰ� ������ extends �ƴ϶� implements  ��°� ��� �Ѵ�.
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
		String str  = (attack ? "����� " : "������ " ) +"���� ��\n";
		str += "0.��  1.��  2.��";
		return str;
	}
	private String convert(int ch) {
		switch(ch){
			case 0:	
				return "��";	
			case 1:	
				return "��";
			case 2:	
				return "��";
			default :
				return "";
		}
	}

	public String check(String in) {
		int choice = Integer.valueOf(in);
		int auto = (int)(Math.random()*3);		// 0, 1, 2
		String cv = convert(auto);
		String str = "������ " +  cv+" ��/�� �´�.";
		// branch �� ���� ����� ���ָ� �ȴ�.
		if(choice == auto) {
			if(attack) {
				str += "����� �¸��Դϴ�.";
			}else {
				str += "������ �¸��Դϴ�.";
			}
			flag = false;
		} else {
			if(choice == 0 && auto == 2 || choice==1 && auto ==0 || choice == 2 && auto ==1) {
				if(attack) {
					str += "���ݱ��� �Ѿ���ϴ�.";
				} 
				attack= false;		
			} else {
				if(!attack) {
					str += "���ݱ��� �����Խ��ϴ�.";
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