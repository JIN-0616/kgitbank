
/*
	
*/

package baseball;

public class PitchingMachine {
	
	int hard;	// 0, 1, 2
	
	PitchingMachine(int hard) {
		this.hard = hard;
	}

	Ball pitch() {
		int s = 80 + hard*20 + (int)(Math.random()*20);
		int c = -1 + (int)(Math.random()*3);

		Ball b = new Ball(s, c);
		return b;
	}
}
