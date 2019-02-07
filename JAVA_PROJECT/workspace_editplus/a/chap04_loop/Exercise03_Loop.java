class Exercise03_Loop {
	public static void main(String[] args) {
		// vip 등급계산
		int vip = 0;
		System.out.print("충전금액 :");
		int charge = Integer.valueOf(System.console().readLine());
		// 충전금액만큼 vip 등급이 올라감.
		boolean possible = true;
		do {
			switch(vip) {
			case 0: case 1: case 2:
				if(charge>= 5000) {
					charge -= 5000;
					vip++;
				}
				else
					possible = false;
				break;
			case 3: case 4: case 5:
				if(charge>= 10000) {
					charge -= 10000;
					vip++;
				}
				else
					possible = false;	
				break;
			default :
				if(charge >= 10000+vip*1000) {
					charge -= 10000+vip*1000;
					vip++;
				}else {
					possible = false;	
				}
			}
		} while(possible);
		System.out.println("현재 등급 :"+  vip);
		// 0 ▷ 3 등급까지는 등급당 5000원
		// 3 ▷ 6 등급까지는 등급당 10000원
		// 6 ▷ 10 등급까지는 등급당 10000 + (현재등급*1000) 원
		//===============================================
		//=======================================================
		// 각 등급별 커트라인점수를 출력 loop를 이용해서 출력
		int need=0;
		for(int v=1; v<=10; v++) {
			System.out.println(v+"등급 필요 포인트");
			switch(v) {
			case 1: case 2: case 3:
				need +=5000;
				break;
			case 4: case 5: case 6:
				need += 10000;
				break;
			default :
				need += 10000+ (v - 1)*1000;
			}
			System.out.println("▶▶ "+need);
		}
	}
}
/*
	vip1	 5000 
	vip2	10000 		
	vip3	15000 
	vip4	25000 
	vip5	35000 
	vip6	45000
	vip7	61000
	vip8	78000
	vip9	96000
	vip10  115000
*/
