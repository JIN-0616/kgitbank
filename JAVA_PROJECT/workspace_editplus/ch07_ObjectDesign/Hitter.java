package baseball;

public class Hitter {
	String name;	//설정할 이름
	int cnt;	// true 뜬 회수
	int in, out, middle;	// 인, 아웃, 가운데 공을 칠수 있는 능력

	// 이 객체를 이름만 설정해서 만들수 있게 생성자를 설정 (나머지는 0으로 설정);

	// 이 생성은 외부패키지에서도 가능하게 access 설정

	public Hitter(String name){
		this.name = name;
		cnt = in = out = middle = 0;
	}

	public boolean swing(Ball t){
		/*
			전달받은 Ball 객체의 type 과 speed를 고려해서 true, false가 랜덤처리
																-1 이 (바깥), 0 (중앙),  1 (안쪽)
			-1인 경우 out = 0 일때 80~100사이만 50퍼센트 true, 나머지 false
					  out = 1 일때 80~100사이는 80퍼센트 true, 100~120 50퍼센트, 그이상은 false
					  out = 2 일때 80~100사이는 100퍼센트 ture, 100~120 80퍼센트, 그이상은 50퍼센트
			0인 경우엔 middle에 따라서 똑같이
			1인 경우에는 in에 따라서 동일한 확률
		*/
		boolean flag =false;
		switch(t.course){
		case -1:
			if(out ==0){
				if(t.speed>=80 && t.speed<100){
					if(Math.random()>0.5) {
						flag = true; 
						cnt++;
					}else{
						flag = false;
					}
				}
			}else if(out ==1){
				if(t.speed>=80 && t.speed<100){
					if(Math.random()>0.2) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else if(t.speed>=100 && t.speed<120){
					if(Math.random()>0.5){
						flag = true;
						cnt++;
					}
					else flag = false;
				}else flag = false;
			}else if(out==2){
				if(t.speed>=80 && t.speed<100){
					flag = false;
				}else if(t.speed>=100 && t.speed<120){
					if(Math.random()>0.2) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else{
					if(Math.random()>0.5) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}
			}
			break;
		case 0:
			if(middle ==0){
				if(t.speed>=80 && t.speed<100){
					if(Math.random()>0.5) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}
			}else if(middle ==1){
				if(t.speed>=80 && t.speed<100){
					if(Math.random()>0.2) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else if(t.speed>=100 && t.speed<120){
					if(Math.random()>0.5) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else flag = false;
			}else if(middle==2){
				if(t.speed>=80 && t.speed<100){					
						flag = true;
						cnt++;					
				}else if(t.speed>=100 && t.speed<120){
					if(Math.random()>0.2) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else{
					if(Math.random()>0.5) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}
			}
			break;
		case 1:
			if(in == 0){
				if(t.speed>=80 && t.speed<100){
					if(Math.random()>0.5) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}
			}else if(in == 1){
				if(t.speed>=80 && t.speed<100){
					if(Math.random()>0.2) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else if(t.speed>=100 && t.speed<120){
					if(Math.random()>0.5) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else flag = false;
			}else if(in == 2){
				if(t.speed>=80 && t.speed<100){
					flag = true;
					cnt++;					
				}else if(t.speed>=100 && t.speed<120){
					if(Math.random()>0.2) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}else{
					if(Math.random()>0.5) {
						flag = true;
						cnt++;
					}
					else flag = false;
				}
			}
		}
		return flag;
		/*
		int per;	
		switch(target.course) {
		case -1 :
			per = out;	break;
		case 0 :
			per = middle;	break;
		default :	
			per = in;	break;
		}
		if(target.speed >= 120) {
			if(per == 2 ) {
				if(Math.random()>0.5) {
					cnt++;
					return true;
				}
			}
		} else if(target.speed>=100) {
			if(per ==2) {
				return true;
			}else if(per==1) {
				if(Math.random()>0.5) {
					cnt++;
					return true;
				}
			}
		} else {
			if(per ==2 || per == 1) {
				return true;
			}else if(per==0) {
				if(Math.random()>0.5) {
					cnt++;
					return true;
				}
			}
		}
		return false; // 디폴트 false로 잡고 true조건만 설정하는 방식
	}

		*/
	}


	public String current(){
		// 플레이어이름, hit count개수, in,out,middle값을 포함한 문자열 만들기
		return " player "+this.name+" hit count : "+cnt +" in,out,middle : "+in+","+out+","+middle;
	}
	
	public void levelUpIn(int mode){
		if(mode == -1){
			this.out ++;
			if(out<=3)
				out = 2;
		}else if (mode == 0){
			this.middle ++;
			middle = middle>=3 ? 2: middle;
		}else{
			if(in<2)
				this.out ++;
		}
	}
}
