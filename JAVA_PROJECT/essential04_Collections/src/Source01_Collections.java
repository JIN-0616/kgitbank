import model.Soldier;

/*
 * 컬랙션 이라고 불리우는 객체들에 대하여 알아보자
 *  - (기본데이터가 아닌) 객체관리를 용이하게 하기 위해서 설계된 객체들이다.
 *  - 배열로 처리하는 것보다는 훨씬 쉽고 간단하게 프로그램을 만들어낼 수 있다.
 *  
 *  - 컬랙션형 객체들은 종류가 다양하고, 작동하는 법도 약간씩 다르다.
 *  - 크게 네 계열이 존재하고, 그 계열의 객체들은 작동하는 방법이 대부분 비슷하다.  
 *  
 *  - 배열로 관리하게 될때의 불편함이 어떻게 해소되는지 알아보자.
 */
public class Source01_Collections {
	public static void main(String[] args) {
		Soldier[] army = new Soldier[3];
		Soldier s = new Soldier("짐레이너",34);
		for (int i = 0; i < army.length; i++) {
			if(Math.random()>0.9) {
				army[i] = s;
				break;
			}else {
				army[i] = new Soldier("익명",1);
			}
		}
		// 어딘가에 설정이됬거나, 아니면 이 배열안에 저장이 안됬거나 둘중에 하나
		//========================================================
		// army 반복문 돌려서 s객체가 army에 저장되어 있는지 탐색
		boolean find = false;
		for (int i = 0; i < army.length; i++) {
			if(army[i]==s)
				find = true;
		}
		System.out.println("s contains ?  "+ find);
		// 배열로 객체관리를 하게 되면 지원되는게 저장공간밖에 없기 때문에,
		// 포함여부나, 중복확인, 남아있는 공간체크같은 것을 
		// 일일히 각 칸을 확인해보면서 관리를 해나갈수 밖에 없다
		
		// 이런 번거로움을 해소하기 위해서 제공되는 객체가 컬렉션형 객체이다.
		
	}
}
