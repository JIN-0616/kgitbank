class Exercise04_Loop{
	public static void main(String[] args) 	{
		/*
			2x + 3y =  0
			4x + 2z =  0
			�� �����ϴ� x,y,z �� �����ϴ���..? ������ -6<=  <=6
			�� (����0�ΰ��� ����)
		*/
		boolean find = false;
		sol : 
		for(int x= -6; x <=6; x++) {
			if(x ==0 ) 
				continue;

			for(int y = -6; y <=6; y++) {
				if(y == 0 || 2*x + 3*y !=0)
					continue;

				for(int z = -6; z <=6; z++) {
					if(z==0) 
						continue;
					System.out.println(x+ " , " + y + ", " + z);
					if(2*x + 3*y == 0 && 4*x + 2*z == 0 ) {
						find = true;
						break sol;
					}
				}
			}
		}
		System.out.println(find);
	}
}