/*
	2. static 을 설정을 통해, 
	객체별로 따로 설정되지 않고 해당타입의 모든 객체가 접근해서 사용하는 저장영역이나
	프로시져를 만들어둘수가 있다.

	 ※ static 저장소에 초기화 작업을 해야된다면, 생성자를 써서 처리하면 안되고
	 static 초기화 방법이 따로 존재하는데, 그걸 이용해서 해결해야된다.
*/
class Enemy {
	static int health;
	int damaged;
	
	static {
		health = 0;
		// damaged= 3;	// 객체가 생성되며 개별적으로 가지게 될 것들은 제어불가
		System.out.println("Enemy 자체 생성자");
	}
	
	Enemy() {
		damaged = 0;
		System.out.println("Enemy 객체 생성자");
	}
	
	static void heal(int d) {
		// 만약에 설계한 프로시져가 개별 객체를 제어를 하는 프로시져가 아니라
		// 객체 전체에서 가져다 쓰는 걸 제어하는 프로시져라면, static 설정이 가능하다. (선택)
		health += d;	
	}

	void attacked(int dmg) {
		damaged += dmg;
		health += dmg;
	}

	String info() {
		return "health = "+ health+"/damaged="+damaged;
	}
}
