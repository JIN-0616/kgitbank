class Exercise03_Loop {
	public static void main(String[] args)	{
		// vip 등급계산
		int vip =0;
		System.out.println("충전금액 : ");
		int charge = Integer.valueOf(System.console().readLine());
		// 충전금액만큼 vip 등급이 올라감
		// 0 -> 3 등급까지는 등급당 5000원
		// 3 -> 6 등급까지는 등급당 10000원
		// 6 -> 10 등급까지는 등급당 10000+(현재등급*1000) 원
		//====================================================
		// 반복문 ? while추천
		int result = charge;
		
		//do~while+switch문
		/*
		boolean possible = true;
		do{
			int need;
			switch(vip){
			case 0: case 1: case 2:
				if(charge>=5000){
					charge -= 5000;
					vip++;
				}else
					possible = false;
				break;
			case 3: case 4: case 5:
				if(charge>=10000){
					charge -= 10000;
					vip++;
				}else
					possible = false;
				break;				
			default:
				if(charge >= 10000+vip*1000){
					charge -=10000+vip*1000;
					vip++;
				}else
					possible = false;
			}
		}while(possible);
		*/
		//while + switch문
		int i=0;
		while(charge >=0){
			i++;
			switch(i){
	
				 case 1: case 2: case 3:
					charge -= 5000; break;
				 case 4: case 5: case 6:
					charge -= 10000; break;
				default:
					charge = charge -(10000+(i-1)*1000); break;

			}		
		}
		System.out.println("현재등급은 "+(i-1));
		System.out.println();

		// ※ while + if-else문
		int remain=0;
		while (result>0 && vip < 10){
			if (vip>=0 && vip <3) {
				if (result-5000 <0) {
					remain +=5000;
					break;
				}
				result -= 5000;
				vip++;
				System.out.print("잔액 = "+result);
				System.out.println(", vip 등급상승, vip="+vip);
			}else if (vip>=3 && vip <6) {
				if (result-10000 <0) {
					remain +=10000;
					break;
				}
				result -= 10000;			
				vip++;
				System.out.print("잔액 = "+result);
				System.out.println(", vip 등급상승, vip="+vip);
			}else if (vip>=6 && vip <10) {
				if (result- (10000+(vip*1000)) <0) {
					remain +=(10000+(vip*1000));
					break;
				}
				result -= (10000+(vip*1000));
				vip++;
				System.out.print("잔액 = "+result);
				System.out.println(", vip 등급상승, vip="+vip);
			}
		}
		System.out.println();
		System.out.println("총 금액 투입 : "+charge +", 잔액  = "+result ) ;
		System.out.println("현재 vip 등급: "+vip);
		System.out.println("vip"+(vip+1)+" 등급 도달까지의 투입금액 = "+remain+"-잔액"+result+" = "+(remain-result));
		/*
		for (vip=0; (vip<10 && result>0); vip++){
			if (vip >= 0 && vip <3 && result >0){
				result -= 5000;
				System.out.print("잔액 = "+result);
				System.out.println(", vip 등급상승, vip="+vip);

			}else if (vip >=3 && vip <6&& result >0){
				result -= 10000;
				System.out.print("잔액 = "+result);
				System.out.println(", vip 등급상승, vip="+vip);

			}else if(vip >=6 && vip <10&& result >0){
				if(result>0) {
					result -= (10000+(vip*1000));
					System.out.print("잔액 = "+result);
					System.out.println(", vip 등급상승, vip="+vip);
				}
			}
		}
		
		System.out.println("잔액 = "+result);
		System.out.println("vip="+vip);
		*/	
			/*
			switch(vip){
			case 0: case 1: case 2:
				result -= 5000;
				System.out.println("vip 등급상승");
				break;
			case 3: case 4: case 5:
				result -= 10000; 
				System.out.println("vip 등급상승");
				break;
			case 6: case 7: case 8: case 9:
				result -= (10000+(vip*1000));
				System.out.println("vip 등급상승");
			}
			System.out.println("vip = "+vip+"이후 잔액" +result);
			*/
		
		
		//====================================================
		// 각 등급별 커트라인점수를 출력 //for + for 추천
		
		// ※ for + switch문
		int sum =0;
		System.out.println();
		System.out.println("등급 필요 누적포인트");
		for(int v=0; v<10; v++){
			switch(v){
			case 0: case 1: case 2:
				sum += 5000;
				System.out.println("vip"+(v+1)+"	"+sum);
				break;
			case 3: case 4: case 5:
				sum += 10000;
				System.out.println("vip"+(v+1)+"	"+sum);
				break;
			default:
				sum += 10000+(v*1000);
				System.out.println("vip"+(v+1)+"	"+sum);
			}
		}
		
		/*
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
		*/
		/*
			vip1	5000
			vip2	10000
			vip3	15000
			vip4	25000
			vip5	35000
			vip6	45000
			vip7	61000
			vip8	78000
			vip9	96000
			vip10	115000

		*/
		}
	}