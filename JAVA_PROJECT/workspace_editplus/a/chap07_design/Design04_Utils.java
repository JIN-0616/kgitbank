/*
	static ������ ������ �Լ��� �������� ��밡���ϴٴ°� �̿��ؼ�,
	Math ���� ��ü ���谡 �����ϴ�.
*/
class Utils {
	/*
		��ü�� storage ������ �����ϰ�, �Լ��鸸 ��Ƽ� �����Ҷ�
		�����Ͱ��������� �ƴ�, ���� ���޹��� �����͸� ���� �۵��ϴ� ��ɼ� ��ü
	*/
	static int max(int a, int b) {
		return a> b? a: b;
	}

	static int max(int a, int b, int c) {
		return max(max(a, b), c);
	}
}
