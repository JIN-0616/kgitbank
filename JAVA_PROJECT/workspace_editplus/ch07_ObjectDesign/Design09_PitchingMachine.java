/*
	ó���� ��Ű�� ���ο��ٰ� ��ü�� �����ϰ�, �Ϲ��������� �����ص� ��
*/
package baseball;

public class PitchingMachine {

	int hard;	// 0 , 1 , 2

	PitchingMachine(int hard){
		this.hard = hard;
	}

	Ball pitch(){ //����Ÿ���� Ball ��ü
		int s = 80 + hard*20 + (int)(Math.random()*20);
		int c = -1 + (int)(Math.random()*3);
		
		Ball b = new Ball(s, c);
		return b;
	}
}
/*
---------- ��Ű�������� ----------
Design09_PitchingMachine.java:6: error: class PitchingMachine is public,
should be declared in a file named PitchingMachine.java

public class PitchingMachine {
       ^
1 error

��� �Ϸ� (0�� ���) - ���� ����

 --> public ����� ���ѻ��� ���ϸ� == ��ü��
*/