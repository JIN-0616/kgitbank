/*
	Extenstion (확장/상속)
	: 객체를 설계할때, 이미 만들어진 객체를 이용해서 추가 설계할수 있게 확장이라는걸 지원하고 있다. 
	
	Extenstion의 장점..?
	 1. 버전업이 용이 - (Starcraft 오리지널에 나왔던 Marine , 확장판에서 나왔던 Marine)
	 2. 설계해야될 객체가 많을때 공통점을 추출해서 하나를 만들어두고, 
		나머지는 다 확장시켜 추가부분만 설계함으로써 빠르게 객체를 설계할수 있음.
		(
	 3. 
*/
class Android extends Robot {
	int happiness;
	Android(String n, int t, int h) {
		this.name = n;
		type = t;
		happiness = h;
	}
	boolean doCleaning() {
		if(this.happiness >= 10) {
			happiness -=10;
			return true;
		}else {
			return false;
		}
	}
	String tell() {
		if(happiness >=30) {
			String m = greet();
			return m;
		}else {
			return name+".....입니다...";
		}
	}

}
