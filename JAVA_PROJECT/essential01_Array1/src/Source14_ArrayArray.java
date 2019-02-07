
class Sim {
	static String[] first;
	static String[] last;
	static {
		first = new String[] {"김","이","박","최","정","강","조","윤","장","임"};
		last = new String[] {"하준","도원","서준","시우","만준","하원","서윤","서연","하은","지우"};
	}
	//공유의 느낌이라기보다는 메모리절약차원
	
	String name;
	int age;
	boolean gender;
	
	public Sim() {
		
		int fidx =(int)(Math.random()*first.length);
		int lidx =(int)(Math.random()*last.length);
		
		name = first[fidx]+last[lidx];
		age = 7+(int)(Math.random()*50);
		gender = Math.random()>0.5;
		
		name.intern(); //String객체 관련 --> 박시우 true처리
					   //String객체 관련 공부때 다시 볼 예정
	}
	@Override
	public String toString() {
		// 이름(xx세/성별)
		return name+"("+age+"세/"+((gender)?"남자":"여자")+")";
		// return name+"("+age+"세/"+(gender?"남":"여")+")";		
	}
}


//==========================================================================
public class Source14_ArrayArray {
	static Sim[] makeFamily() {
		int size = 2 +(int)(Math.random() *4);
		Sim[] t = new Sim[size];
		for (int i = 0; i < size; i++) {
			Sim s = new Sim();
			//System.out.println(s.toString());
			t[i] = s;
		}
		return t;
	}

	
	public static void main(String[] args) {
		Sim[][] families = new Sim[7][];
		//============================================================
		// 총 Sim[] 배열 7개를 설정할수 있는 집합을 만들었는데,
		// 적당한크기(2~5인 가구)의 배열에 Sim객체를 설정해서 families 에 등록
		
		/* 잘못된 예제
		 * for(int row = 0 ; row < families.length ; row++) {
		 * 		for(int col = 0; col < families.[row].length ; col++){
		 * 			families[row][col] = new Sim();
		 * 		}
		 * }
		 * ------------------------------------------------------
		 * for(int r = 0 ; r < families.length ; r++) {
		 * 		Sim[] each = families[row];
		 * 		for(int c = 0 ; c < each.length ; c++){
		 * 			each[c] = new Sim();
		 * 		}
		 * }
		 * ------------------------------------------------------
		 * 패밀리즈에 Sim배열이 있다는 전제하에 Sim만 생성한 코드
		 * Sim 배열부터 만들고 나서 Sim배열만 생성한것, 1줄씩만 추가하면 됨
		*/
		//============================================================
		// 세팅 완료되고나면.. 
		// 전체 패밀리정보를 전부 출력
		
		/* teacher A
		for (int r = 0; r < families.length; r++) {
			System.out.println(r+ "family set start");
			int size = 2 +(int)(Math.random()*4);
			Sim[] t = new Sim[size];
			for (int c = 0; c < size; c++) {
				Sim s = new Sim();
				System.out.println(s.toString());
				t[c] = s;
			}
			families[r] = t;
			System.out.println(r+"family set end");
		}
		or
		static 만들었으면
		
		for (int i = 0; i < families.length; i++) {
			System.out.println("family set start");
			Sim[] tmp = makeFamily();
			families[i] = tmp;
		}
		
		전체찍기
		
		for (int r = 0; r < families.length; r++) {
			System.out.println(r +"'s Family");
			Sim[] ar = families[r];
			for(int i=0; i<ar.length;i++){
				Sim s = ar[i];
				System.out.println(" -> "+i+" : "+ar[i] );
			}
			
		}
		*/

		
		
		int[] ran = new int[families.length];
		for (int i = 0; i < families.length; i++) {
			int sum =2+(int)(Math.random()*4);
			ran[i] = sum;
		}
		for (int i = 0; i < ran.length; i++) {
			System.out.println("families "+i +"- 구성원 ["+ran[i]+"] 명");
			families[i] = new Sim[ran[i]];
			for (int j = 0; j < families[i].length; j++) {
				families[i][j]= new Sim();
				System.out.println("	f["+i+"]["+j+"] = "+families[i][j].toString());
			}
		}			
		
		//============================================================
		int maleCount = 0;
		int femaleCount = 0;
		int twoCount = 0;
		int tenCount = 0;
		boolean psuCount =false;
		Sim pick = null;		
		
		for (int i = 0; i < families.length; i++) {
			for (int j = 0; j < families[i].length; j++) {
				if(families[i].length == 2) {
					twoCount++;
				}
				if(families[i][j].age >=10 && families[i][j].age <20) {
					tenCount++;
				}
				if(families[i][j].name == "박시우") {
					psuCount = true;
				}
				if(families[i][j].gender) {
					maleCount++;
				}else {
					femaleCount++;
				}
			}
		}
		System.out.println();
		// 이 가족들중에 남자 몇명, 여자 몇명 개수 확인
		System.out.println("남성 : "+maleCount+"명 / 여성 : "+femaleCount+"명");		
		// 2인가족이 몇개인가?
		System.out.println("2인가족 : "+twoCount+"가구");
		// 10대 몇명인가? (10~19)
		System.out.println("10대 : "+tenCount +"명");
		// "박시우" 라는 이름을 가진 Sim은 있는가? ( =="박시우" )
		System.out.println("박시우가 존재하는가? ... "+((psuCount)?"존재한다":"존재하지않는다"));
		// 이 families에 들어가져 있는 Sim중에 하나를 random()으로 뽑아라, 랜덤줄 + 랜덤칸 2중
		int rand = (int)(Math.random()*7);
		pick = families[rand][(int)(Math.random()*(families[rand].length))];		
		
		System.out.println(pick.name + " 이/가 모든 가족들의 칭찬을 받습니다.");
		
		// 남녀 숫자세기 A
		int[] cnt = new int[2];
		for (int i = 0; i < families.length; i++) {
			Sim[] ar = families[i];
			for (int j = 0; j < ar.length; j++) {
				Sim s = ar[i];
				if(s.gender)	//families[r][c].gender
					cnt[0] += 1;
				else
					cnt[1] += 1;
			}			
		}
		// 2인가족 A
		int two=0;
		for (int i = 0; i < families.length; i++) {
			Sim[] ar = families[i];
			if(ar.length ==2)
				two++;			
		}
		
		// 10대 A
		int teenager = 0;
		for (int i = 0; i < families.length; i++) {
			for (int j = 0; j < families[i].length; j++) {
				if(families[i][j].age /10 ==1)
					teenager++;
			}			
		}
		// 박시우 A
		boolean find = false;
		for (int i = 0; i < families.length; i++) {
			Sim[] ar = families[i];
			for (int j = 0; j < ar.length; j++) {
				Sim s = ar[i];
				if(s.name == "박시우") {
					find = true;
					break;					
				}					
			}			
		}
		// random A
		int randRow = (int)(Math.random()*families.length);
		Sim[] pickFamily = families[randRow];
		Sim pick1 = pickFamily[ (int)(Math.random()*pickFamily.length)];
		System.out.println(pick + " 이/가 칭찬을 받습니다.(in " + randRow +" family)");
	}
}
