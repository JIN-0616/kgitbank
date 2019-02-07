/*
	procedure 를 이용한 UpDown Game을 구현해보았는데,
	데이터 관리나 처리를 좀더 편하게 하기 위해서 UpDownEngine 객체를 설계해보고
	그걸 토대로 한번 더 1인용, 대전용을 만들어보자. [추후 GUI 변경예정이므로 - 입출력 main에서 다 할것임]
*/
class UpDownEngine {
	// storage
	int target; // 정답
	int min, max; // 가능한 최소값과 최대값 (범위)
	int tried;	// 시도횟수
	boolean flag;	//끝났는지 안끝났는지 기억시켜둘 값

	//==========================================================
	// 엔진 초기화
	void start(){
		// target 이 1~200 사이에 랜덤으로 설정되고
		// min, max가 1과 200으로 설정되고
		// tried 가 0이 되고
		// flag가 true로 바뀌게
		target = (int)(1+Math.random()*200);
		min = 1;
		max = 200;
		tried = 0;
		flag = true;
	}

	int recommend(){
		// min ~ max 사이 범위 의 랜덤정수 하나를 만들어주게
		int result = (int)(min+Math.random()*(max-min+1));
		return result;
		
	}

	String compare(int data){
		// 전달받은 숫자와 자신의 target 을 비교해서
		// "CORRECT"(같을때), "TOO HIGH", "HIGH", "LOW", "TOO LOW"
		//	data가 타겟보다 큰데 그 차가 50 넘으면 "TOO HIGH", 그렇지 않으면 "HIGH"	
		//	data가 타겟보다 작은데 그 차가 50 넘으면 "TOO LOW", 그렇지 않으면 "LOW"	

		// 이걸하면서 동시에, min ~ max 수정해두고, tried 올리고, 같으면 flag를 false로 변경
		
		++tried;
		String returnValue = "";
		if (data == target){
			flag = false;
			returnValue = "CORRECT";
		}else if (data > target){
			max = data > max ? max : data;
			/* ==
				if (data<max)
					max = data;
			*/
			if (data - target >50){
				returnValue = "TOO HIGH";
			}else{
				returnValue ="HIGH";
			}
		}else if (data < target){
			min = data > min ? data : min;
			if (target - data >50){
				returnValue = "TOO LOW";
			}else{
				returnValue = "LOW";
			}
		}
		return returnValue;
	}

	boolean isRun(){
		// 엔진이 작동중인지 아닌지만 확인 flag보다 isRun처럼 묻는것을 추천함
		if(flag)
			return true;
		else
			return false;

	}

	String tell(){
		// 현재 tried 값이랑 min 값, max 값을 조합해서 바로 출력할수 있게 문자열로 만들어주는 기능
		return "tried = "+tried+" min = "+min+" max = "+max;
	}
}
