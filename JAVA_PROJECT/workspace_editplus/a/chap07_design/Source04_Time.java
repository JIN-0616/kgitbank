/*
	Stage 객체를 이용해서 
	한쪽이 승리조건을 만족하면 종료되는 프로그램을 장학퀴즈 프로그램을 만들려고 한다.
	컴퓨터가 가끔은 틀려주는게 공정성 차원에 필요한데, 
	틀리게 하는 조건중에 하나를 사용자가 문제를 풀리는데 걸리는 시간에 영향을 받게 하려고 한다.

	이 작업을 하려면 System.currentTimeMillis() 라는 기능이 어떤건지 알아두어야 한다.
*/
class Source04_Time {
	public static void main(String[] args) 	{
		long t1 = System.currentTimeMillis();	// long 형 수치가 하나 나오게 된다.
		System.out.println("t1 == "+ t1);	// 현재 시간임.
		// 1970.01.01 00:00:00 초부터 지금 몇 ms가 흘러간건지에 대한 데이터값이다.

		long y = t1/(1000L*60*60*24*365);
		System.out.println(y);
		long d = t1%(1000L*60*60*24*365)/(1000L*60*60*24);
		System.out.println(d);

		long h = t1%(1000L*60*60*24*365)%(1000L*60*60*24);	// 19
		System.out.println(h/(1000L*60*60));

		System.console().readLine();
		long t2 = System.currentTimeMillis();	
		System.out.println(t2 - t1);
	
	}
}
