package UI;

public class IndiaEngine {
	int target; // 정답-
	int min, max; // 가능한 최소값과 최대값
	int tried; // 시도회수
	boolean flag; // 끝났는지 안끝났는지 기억시켜둘 값

	// ==================================================
	void start() {
		target = 1 + (int) (Math.random() * 200);
		min = 1;
		max = 200;
		tried = 1;
		flag = true;
	}

	int recommend() {
		if (Math.random() > 0.95) {
			return min + (int) (Math.random() * (max - min + 1));
		} else {
			return target;
		}
	}

	String compare(int data) {
		tried++;
		if (data == target) {
			flag = false;
			return "CORRECT";
		} else if (data < target) {
			min = data > min ? data : min;
			if (target - data > 50)
				return "TOO LOW";
			else
				return "LOW";
		} else {
			if (data < max)
				max = data;

			if (data - target > 50)
				return "TOO HIGH";
			else
				return "HIGH";
		}
	}

	boolean isRun() {
		return flag == true;
	}

	String tell() {
		return tried + "'s TRY (" + min + " ~ " + max + ") ";
	}
	
}
