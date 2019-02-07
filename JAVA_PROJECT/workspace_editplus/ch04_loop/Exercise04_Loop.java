class Exercise04_Loop {
	public static void main(String[] args)	{
		/*
			2x + 3y = 0
			4x + 2z = 0
			를 만족하는 x,y,z가 존재하는지? 범위는 -6<=  <6
			단, 전부 0인 경우는 제외
		*/
		boolean find = false; // 찾으면 find true, 외부 break
		Outloop:
		for(int x= -6; x<=6; x++){
			if(x==0) continue;
			for(int y= -6; y<=6; y++){
				if(y==0) continue;
				for(int z= -6; z<=6; z++){
					if(z==0) continue;
					//System.out.println(x+", "+y+", "+z);
					if(2*x + 3*y ==0 && 4*x+2*z == 0) {
						find = true;
						System.out.println(x+","+y+","+z);
						break Outloop; // 1개만 빠르게 찾고 종료시키기
					}
				}
			}
		}
		System.out.println("find = " +find);
	}
}
