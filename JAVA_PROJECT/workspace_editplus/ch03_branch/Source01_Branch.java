/*
	chap01, chap02를 거치면서
	프로그램에서 사용할수 있는 데이터 종류와, 데이터에 지원하는 연산,
	데이터를 저장하는 법, 저장되있는 데이터를 토대로 지원하는 연산에 대하여 살펴보았다.

	그걸 이용해서
	준비된 데이터와 사용자로부터 입력받은 데이터를 토대로,
	원하는 결과를 도출해내기 위한 연산작업도 해보았다.

	하지만, 결과 도출을 하기 위한 작업을 구현을 하다보면,
	데이터 상태에 따라 다른 처리가 필요한 경우가 생기게 된다.

	예를 들어, 실제 원래가격과 무관하게 100단위, (50단위)로 끊어서 가격ㅂㄴ동을 시켰는데,
	이런 주식거래같은 경우, 호가 단위 라는 개념이 존재해서 
	원래가격에 따라서 변동 단위가 다르게 처리한다.
	예를들어 5000-10000원 사이는 10원 단위 / 50000-100000사이는 100원단위로 변동이 되기때문에
	데이터 상태에 따라서 다른 처리가 일어나게 작업 구현을 해야한다.

	이걸 구현하는데 사용되는게 branch 문이고, 이 branch를 구현하는데 사용되는게
	if - else (데이터상태) / switch (데이터값) 문 두가지 구문이다.

	if - else 부터
*/

class Source01_Branch {
	public static void main(String[] args) 	{
		System.out.print("Insert coin> ");
		int coin = Integer.valueOf(System.console().readLine());

		// 온전한 데이터인 경우가 그렇지 않은 경우에 처리가 달라져야 한다면
		// 데이터 상태 몇개 추가해서, if쪽 branch가
		// coin100이상이고, 100단위 입력했을때만 작동할 수 있게 구현
		if(coin>=100 && coin%100==0){ //데이터 상태 확인을 좀더 푸가하고 싶을때 &&혹은 ||를 써서 구현
			// 어떤상태일때 { }을 작동시킬껀지 뎅터 상태 환경식을 구현 / ture, false
			int life = coin/100;
			System.out.println(life +" life gained");
		}else{
			System.out.println("[System] invalied coin : "+ coin);
			System.out.println("[System] Sorry");
		}
		System.out.println(");
		System.out.println("[System] terminate");

	}
}
