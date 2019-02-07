class Source09_For {
	public static void main(String[] args)	{
		/*
			루프안에서 다시 루프를 구현하는 형태의 구문도 설정가능하다.
		*/
		for (int lv=1; lv<=5 ; lv++){
			System.out.println("lv == "+lv);
			for (int step=1; step<=10 ; step++){
				System.out.println("step == " +step);
			}
			System.out.println();
		}
		/*
			이런 형태의 loop 구현시, 2의 1제곱부터 10제곱까지를 출력해보자
		*/
		
		for(int step=1;step<=10; step++){
			int d =1;
			for(int cnt=1; cnt<=step; cnt++){
			// 바깥쪽 loop의 변화하는 수를 가지고, 내부루프의 조건으로사용하는 형태가
			// 중복형태의 loop 중 가장 많은 생각이 필요하게 된다.
				d *=2;
			}
			System.out.println("d == " +d);
		}		
		//=====================================================================
		// 1 3 6 10 15 21 28 36 45 55
		//0+1 0+1+2 0+1+2+3 0+1+2+3+4 .....
		/*
			i1 - j0+1
			i2 - j0+1+2
			i3 - j0+1+2+3
		*/

		for(int i=1;i<=10;i++){
			System.out.print("리미트"+i);
			int sum=0;
			for(int j=0;j<=i;j++){
				System.out.print(j);
				sum += j;
			}
			System.out.println();
			System.out.println(i+"까지 합은 = "+sum);
			System.out.println(i+"까지 합은 = "+sum);
		}
		
		int total =0;
		for (int num=1; num<=10;num++){
			System.out.print("num ==" + num);
			total += num;
			System.out.println("/ total == " +total);
		}

	}
}
