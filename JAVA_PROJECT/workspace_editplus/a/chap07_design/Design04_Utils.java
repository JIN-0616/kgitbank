/*
	static 설정된 변수나 함수는 생성없이 사용가능하다는걸 이용해서,
	Math 같은 객체 설계가 가능하다.
*/
class Utils {
	/*
		객체의 storage 영역을 포기하고, 함수들만 모아서 설계할때
		데이터관리목적이 아닌, 전부 전달받은 데이터를 토대로 작동하는 기능성 객체
	*/
	static int max(int a, int b) {
		return a> b? a: b;
	}

	static int max(int a, int b, int c) {
		return max(max(a, b), c);
	}
}
