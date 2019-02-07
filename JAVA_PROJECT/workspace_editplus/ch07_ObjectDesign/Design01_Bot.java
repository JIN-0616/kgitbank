/*
	사용할 객체를 설계하면서, 데이터 저장영역 이랑, 해야될 기능을 어떤식으로
	구현해두어야하는지 살펴보았다.
	이게 가장 설계시 중요한 부분이긴 하나, 그 외에 알아두면 좋은 것들이 더 존재한다.

	1. constructor (생성자)
		: 객체를 만들고 난 이후, 초기화를 시키는게 아니라
		만들어지면서 어떤상태가 되있길 원할때 구현해두는 것
		설계하는 객체명으로 리턴타입없는 Procedure 형태로 설계하면 된다.
		: 생성시 필요한 데이터를 넘기면서 만들어지게도 유도가 가능하다.

		: 객체 생성자를 하나만 구현해둘수 있는건 아니다. 오버로딩이 가능하다.
*/

class Bot {
	int stamina;	// 체력
	int count;		// 작업회수

	void init(){
		stamina = 100;
		count = 0;
	}
	
	//--------- Constructor 생성자 -----------

	Bot(int initStamina){ // 생성시에 매개변수 넣어서 생성해야 함
		stamina = initStamina;
		count = 0;
		System.out.println("constructor");
	}

	Bot(){ //기본생성자 (비워두는형태)
		stamina = 100;
		count = 0;
		System.out.println("constructor");
	}

	//----------------------------------------

	String tell(){
		return "STAMINA : " + stamina + " , COUNT = "+ count;
	}

	boolean move(int distance){
		/*
			전달받은 거리만큼 이동한다고 가정하고,
			체력소모가 이동거리 10당 1씩 감소
			이 객체가 이동에 필요한 스테미너가 있다면, count++,
			소모량 stamina에서 감소시키고 return true
			그게 아니면 return false
		*/
		int need;
		if(distance>stamina*10){
			return false;
		}
		else{
			need = distance/10; 
			//distance%10 == 0 ? need : need++ ;
			if (distance%10 != 0)
				need++;	
			stamina = stamina - need;
			count++;
			return true;
		}
	}
	/*
		int need= 0;
		while(distance >0){
			need++;
			distance -= 10;
		}

		in need = distance/10;
		if(need%10>0)
		need++;

		int need;
		if(distance%10 ==0)
			need = distance/10;
		else
			need = (distance/10)+1;
	*/


	/*
	9 - > 1 , 21~ -> 3
	Bot b = new Bot();
	b.move(10); // false
	System.out.println(b.tell()); // init없으므로 0 0
	b.init();
	b.move(15);
	System.out.println(b.tell()); // 98 , 1
	*/
}
