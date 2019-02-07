/*
	��(����) ��� ��ü�� �������� �Ѵ�.
*/
class Sphere {
	/*
		storage.
	*/
	int radius;	

	/*
		procedure.
	*/
	// 1.�ʿ��Ҷ� �ڽſ��� ������ �����������͸� �̿��Ͽ� ���̸� ������ִ� ���.
	double calcArea() {
		return 4 * 3.141592 * radius* radius;
	}

	// 2. ������ ������ ���� ���Ǹ� ����ؼ� �˷��ִ� ���.
	double calcVolume() {
		// �����е���..
		return 4.0 / 3 * 3.141592 * Math.pow(radius, 3) ;
	}
	// 3. ������ Ű���
	void grow(int d) {
		radius += d;
	}
	// 4. �ڽ��� �������� Ư��������� ū�� �ƴ��� �˷��ִ�
	boolean greaterThan(int cmp) {
		if(radius > cmp)
			return true;
		else
			return false;
		// return radius > cmp ? true : false;
		// return radius > cmp;
	}
	// 5. ���� ������ �� �����ϰ� ���ο� ���������� �����ϴ�
	void change(int newRadius) {
		radius = newRadius;
	}


}