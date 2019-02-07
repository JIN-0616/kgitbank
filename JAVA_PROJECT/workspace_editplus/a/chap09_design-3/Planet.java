/*
	class 가 아닌 다른 키워드를 이용해서 설계

	1. enum 
	객체를 설계하면서 해당타입으로 몇개를 미리 선정해서 만들어두고 사용하는 설계
*/

enum Planet {
	MERCURY(2438.7e3, 3.023e23), EARTH(6378.12e3, 5.9736e24);
	

	double weight;
	double radius;

	Planet(double r, double w){
		radius = r;
		weight = w;
	}
	
	@Deprecated
	double getGravity() {
		return 6.67384e-11*weight/(radius*radius);
	}
	

}


