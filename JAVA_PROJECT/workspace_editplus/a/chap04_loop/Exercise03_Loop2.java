class Exercise03_Loop2{
	public static void main(String[] args) 	{

		System.out.print("충전금액: ");
//		int charge =Integer.valueOf(System.console().readLine());
		for(int charge = 1000; charge <=120000; charge += 1000 ) {
			int i=0;
			int copy = charge;
			while(copy >=0){
				i++;
				switch(i){
					 case 1: case 2: case 3:
						copy -= 5000; break;
					 case 4: case 5: case 6:
						copy -= 10000; break;
					default:
						copy = copy -(10000+(i-1)*1000); break;

				}
			}
			System.out.println(charge+" : 현재등급은 "+(i-1));
		}
	}
}
