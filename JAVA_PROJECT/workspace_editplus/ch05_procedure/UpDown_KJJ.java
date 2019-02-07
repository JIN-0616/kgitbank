class UpDown_KJJ {
	static int random(){
		return 1 + (int)(Math.random()*200);
	}
	static int random(int n1, int n2){
		return n1+(int)(Math.random()*(n2-n1+1));
	}
	
	static int greater(int n1, int n2){
		if (n1>n2)	return n1;
		else		return n2;
	}
	static int less(int n1, int n2){
		if (n1>n2)	return n2;
		else		return n1;
	}
	static int handle(String data, int min, int max){
		switch (data){
		default :
			return Integer.valueOf(data);
		case "" :
			return random(min,max);
		}		
	}
	public static void main(String[] args)	{
		
		int min = 1, minC = 1; 
		int max = 200, maxC = 200;
		int target = random();
		int targetC = random();
		int tried = 0;
		/*
		min = minC = 1;
		max = maxc = 20;

		but
		target = targetC = random(); ( X ) 안됌
		*/
		//----------------------------------------------------
		System.out.println("[SYSTEM] UP_AND_DOWN VS COM ");
		boolean user = false;
		boolean com = false;
		boolean p = false;

		// user = com = p = false;
		System.out.println("[SYSTEM] autoMode ==> a");
		while(true){
			System.out.println("[ USER ] "+ (++tried)+" tried ("+min+" - "+max+") : " );
			System.out.println("[SYSTEM] "+ (tried)+" tried ("+minC+" - "+maxC+") : " );
			String in;
			if(p==false)
				in = System.console().readLine();
			else
				in = "";
			int got;
			switch(in){
			case "a":
				p = true;
				got = handle("",min,max);
				break;
			default:
				got = handle(in,min,max);
			}
			// String in = System.console().readLine();
			// int got = handle(in,min,max);
			if(got == target){
				System.out.println("[ USER ] CORRECT VALUE !!! "+ target);
				user = true;
			}else if(got<target){
				System.out.println("[ USER ] TARGET VALUE is GREATER THEN "+got);
				min = greater(got, min);
			}else {
				System.out.println("[ USER ] TARGET VALUE is LESS THEN "+got);
				max = less(got, max);
			}
			int gotC = handle("",minC,maxC);
			if(gotC == targetC){
				System.out.println("[SYSTEM] CORRECT VALUE !!! "+ target);
				com = true;
			}else if(gotC<targetC){
				System.out.println("[SYSTEM] TARGET VALUE is GREATER THEN "+gotC);
				minC = greater(gotC, minC);
			}else {
				System.out.println("[SYSTEM] TARGET VALUE is LESS THEN "+gotC);
				maxC = less(gotC, maxC);
			}
			if(user==true || com==true){
				System.out.println("[======] THE GAME IS END [=======]");
				if (user && com==false){
					System.out.println("[======] WINNER IS USER [======]");
					break;					
				}else if(com && user==false){
					System.out.println("[======] WINNER IS SYSTEM [======]");
					break;					
				}else{
					System.out.println("[======]	DRAW	 [======]");
					break;
				}
				
			}
			
		}
		/*
		int t1, t2;
		int min1, min2;
		int max1, max2;
		int tried = 0;
		boolean done1, done2;
		//====================
		t1=random();
		t2=random();
		//t1 = t2 = random(); ( X )
		min1 = min2 = 1;
		max1 = max2 = 200;
		done1 = done2 = flase;
		System.out.println("[SYSTEM] UPDOWN VS MODE");
		while(done1 != true %% don2 != true){
			System.out.println("[SYSTEM] ROUND " + ++tried);
			System.out.println("[SYSTEM] YOU ("+min1 +" - " +max +")");
			String in = System.console().readLine();
			int g1 = handle(in, min1, max1);
			int g2 = handle("", min2, max2);
			System.out.println("[SYSTEM] COM ("+min2 +" - " +max2+")");
			
			System.out.println("[SYSTEM] PRESS ENTER");
			System.out.println();

			if(g1>t1){
				System.out.println("[SYSTEM] YOU +"g1 +" IS GREATER ");
				max1 = less(g1, max1);
			}else if(g1<t1){
				System.out.println("[SYSTEM] YOU +"g1 +" IS LESS ");
				min1 = greater(g1, min1);
			}else{
				System.out.println("[SYSTEM] YOU +"g1 +" IS CORRECT ");
				done1=true;
			}

			
			if(g2>t2){
				System.out.println("[SYSTEM] YOU +"g2 +" IS GREATER ");
				max2 = less(g2, max2);
			}else if(g2<t2){
				System.out.println("[SYSTEM] YOU +"g2 +" IS LESS ");
				min2 = greater(g2, min2);
			}else{
				System.out.println("[SYSTEM] YOU +"g2 +" IS CORRECT ");
				done2=true;
			}
		}
		*/
		
		/*
			만들면서 가낭 번거로웠던 작업은 어떤거였나?
			만약 이걸 AI나 사용자 하나 더 껴서 3인 대결로 바꾼다면 어떤점이 제일 번거롭겠는가?
			
			프로시저 중심의 언어는 데이터 처리에 중점을 맞추다보니, 관리가 번거롭다.
			추가적인 변수들을 더 설정해야하고, 변경되는 것들도 진행중에 일일이 바꿔줘야 하는 번거로움이 있다.

			데이터처리에 + 데이터관리의 번거로움을 개선한 방식이 등장하는데,
			이게 객체 중심(객체지향)의 프로그래밍 이다.
		*/
	}
}
