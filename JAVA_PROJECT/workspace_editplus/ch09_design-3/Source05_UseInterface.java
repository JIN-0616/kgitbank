/*
class GameEngine extends Engine {  }
	- extends 의 대상이 interface면, 더 큰 interface 확장을 하겠다는 소리
*/
import javax.swing.JOptionPane;

interface SuperEngine extends Engine{
	boolean boost();
}
/*
	Interface 를 토대로 class를 설계하고 싶으면 extends 가 아니라 implments 라는걸 써야 한다.

	일종의 규격서의 개념

	<->abstract
	
	interface는  abstract 가능하나 abstract를 interface는 불가능하다.

	interface는 default가 public으로 강제되어있다.
	(따라서 public이 생략되어있는 셈이다.)

	-->따라서
	 interface를 받아서 만들게 될 경우는
	 public으로 생성해야만 구현이 가능하다.
*/
class GameEngine implements Engine{
	int cnt, target, min, max;
	boolean flag;
	
	public void init(){
		cnt = 0;
		target = (int)(1+Math.random()*200);
		min = 1;
		max = 200;
		flag = true;
		JOptionPane.showMessageDialog(null,"[SYSTEM] UpDownEngine STARTED");
	}

	public boolean isRun(){
		if(cnt<10 && flag)
			return true;
		else
			return false;
	}

	int recommend(){
		int result = (int)(min+Math.random()*(max-min+1));
		return result;
	}
	String tell(){
		return "tried = "+cnt+" min = "+min+" max = "+max;
	}

	public String execute(){
		String o = this.tell();
		return o;
	}
	public String check(String in){
		cnt++;
		int data;
		/*
		switch(in){
		case "":
			data = this.recommend();
		default:
			data = Integer.valueOf(in);
		}
		*/
		data = Integer.valueOf(in);
		String returnValue = "";
		if (data == target){
			flag = false;
			returnValue = "CORRECT";
		}else if (data > target){
			max = data > max ? max : data;
			if (data - target >50){
				returnValue = "TOO HIGH";
			}else{
				returnValue ="HIGH";
			}
		}else if (data < target){
			min = data > min ? data : min;
			if (target - data >50){
				returnValue = "TOO LOW";
			}else{
				returnValue = "LOW";
			}
		}
		return returnValue;
	}	
}

class Source05_UseInterface {
	public static void main(String[] args)	{
		OptionPanePlayer opp = new OptionPanePlayer();
		Engine e = new GameEngine();
		opp.insert(e);
		opp.start();
		opp.remove();


	}
}
