
/*
	
*/



/*
	��Ű�� ó���ߴٸ�, 
	public ���� �����صξ�� Ÿ��Ű������ ������ ��. 
	(public���� �����Ϸ��� �����̸��� ������ ��ġ���Ѿ� ��)

	public class �� ����� �νĵǱ� ������,

	�׾ȿ� ������ �����ڳ�,������, �Լ��� ȣ��Ǵ°� ���� �� ������ �ؾ߸� �Ѵ�.
*/
package baseball;
public class PitchingMachine {
	
	int hard;	// 0, 1, 2
	
	public PitchingMachine(int hard) {
		this.hard = hard;
	}

	public Ball pitch() {
		int s = 80 + hard*20 + (int)(Math.random()*20);
		int c = -1 + (int)(Math.random()*3);

		Ball b = new Ball(s, c);
		if(Math.random() > 0.8) {
			b.course = -2;
		}

		return b;
	}
}