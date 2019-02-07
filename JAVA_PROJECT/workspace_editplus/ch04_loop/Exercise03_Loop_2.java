class Exercise03_Loop_2
{
	public static void main(String[] args) 
	{
		//vip 등급 계산
		
		System.out.print("충전금액: ");
		int charge =Integer.valueOf(System.console().readLine());

		//충전 금액만큼 vip 등급이 올라감.
		//0 ~3 등급까지는 등급당 5000원 
		//3 ~6 등급까지는 등급당 10000원 
		//6~ 10 등급까지는 등급당 10000+현재등급 *1000 원
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

		//각 등급별 커트라인 점수를 출력
		int cut =0;
		for(int j=1; j<=10; j++){
			
			switch(j){
				case 1: case 2: case 3:
					cut +=5000; break;
				case 4: case 5: case 6: 
					cut += 10000; break;
				default:
					cut = cut +(10000+(j-1)*1000); break;

			}
			System.out.println(j+"등급까지 필요 점수는 "+cut+"입니다");
		}
	}
}
