package model;

public class IdiomTest {
	public static void main(String[] args) {
		String w = "기상천외";
		String h = "상식을 벗어난 아주 엉뚱한 생각.";
		
		Idiom i = new Idiom(w, h);
		System.out.println(i.mixChars());	// 천금상기세외
		System.out.println(i.toString());	// 상식을 벗어난 아주 엉뚱한 생각 : 기??? 
		
		
		boolean b = i.mark("상금기천");
		System.out.println(b);
		
		boolean bb =i.mark("기상천외");
		System.out.println(bb);
		
		//=========================================================================
		String[][] datas = new String[][] { 
			new String[] {"가렴주구","각골난망","감탄고토","견물생심"},
			new String[] {  
						"세금을 혹독하게 징수하고 물건을 강제로 요구함",
						"입은 은혜에 대한 고마운 마음이 뼈에 사무쳐 잊혀지지 않음",
						"달면 삼키고 쓰면 뱉는다는 뜻",
						"물건을 보면 갖고 싶은 욕심이 생김"
					}
			};
		//==========================================================================
		Idiom[] ids = new Idiom[4];
		for(int c=0; c<ids.length; c++) {
			// [0][0],[1][0],   / [0][1], [1][1]  
			ids[c] = new Idiom(datas[0][c], datas[1][c]);
		}
		//===========================================================================
		// 이 String[] 을 배열을 이용해서, Idiom[] 을 만들고,
		// 랜덤 사자성어 맞추기 프로그램으로 변경
		Idiom p = ids[(int)(Math.random()*ids.length)];
		System.out.println(p);
		
		
	}
}
