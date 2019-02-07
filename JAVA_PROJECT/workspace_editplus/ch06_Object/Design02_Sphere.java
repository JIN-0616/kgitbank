/*
	구(도형) 라는 객체를 만들어보려고 한다.
*/
class Sphere {
	/*
		storage
	*/

	int radius;
	
	/*
		procedure
	*/
	// 1. 필요할때 자신에게 설정된 반지름데이터를 이용하여, 넓이를 계산해주는 기능 4pir^2
	double calcArea(){
		return 4 * 3.141592 * radius * radius; 
 	}

	// 2. 설정된 반지름 기준 부피를 계산해서 알려주는 기능 4/3 pi r^3
	double calcVolume(){
		//		4.0/3.0				* Math.pow(radius, 3); 
		return (4 / 3.0) * 3.141592 * radius* radius* radius;
		// ※  4/3 != 4/3.0 ※
		// 정수 나누기 할때 주의할것
	}

	// 3. 반지름키우기
	void grow(int d){
		radius += d;
	}

	// 4. 자신의 반지름이 특정value보다 큰지 아닌지 알려주는 
	boolean greaterThan(int cmp) {
		if ( radius > cmp)
			return true;
		else 
			return false;
	}
		//return radius >cmp ? true : false;
		//return radius >cmp;

	// 5. 기존 설정된 값 무시하고 새로운 반지름으로 설정하는
	void change (int newRadius ) {
		radius = newRadius;
	}

	
}
