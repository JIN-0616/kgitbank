
class Sim {
	static String[] first;
	static String[] last;
	static {
		first = new String[] { "김", "이", "박", "최", "정", "강", "조", "윤", "장", "임" };
		last = new String[] { "하준", "도윤", "서준", "시우", "민준", "하윤", "서윤", "서연", "하은", "지우" };
	}
	String name;
	int age;
	boolean gender;

	Sim() {
		int fidx = (int) (Math.random() * first.length);
		int lidx = (int) (Math.random() * last.length);

		name = first[fidx] + last[lidx];
		name.intern();	// 이게 무슨작업인지는 String 객체 살펴볼때 알아보자.
		age = 7 + (int) (Math.random() * 50);
		gender = Math.random() > 0.5;
	}

	// public String toString() 을 오버라이드 이름(xx세/성별)
	public String toString() {
		return name + "(" + age + "세/" + (gender ? "남" : "여") + ")";
	}
}

//==========================================================
public class Source14_ArrayArray {
	static Sim[] makeFamily() {
		int size = 2 + (int) (Math.random() * 4);
		Sim[] t = new Sim[size];
		for (int c = 0; c < size; c++) {
			Sim s = new Sim();
			// System.out.println(s.toString());
			t[c] = s;
		}
		return t;
	}
	public static void main(String[] args) {
		Sim[][] families = new Sim[7][];
		// ==============================================
		// 총 Sim[] 배열 7개를 설정할수 있는 집합을 만들었는데,
		// 적당한크기(2~5인 가구)의 배열에 Sim 객체를 설정해서 families 에 등록
		/*
		 * for(int r=0; r<families.length; r++) {
		 * System.out.println(r+" family set start"); int size = 2 +
		 * (int)(Math.random()*4); Sim[] t = new Sim[size]; for(int c =0; c<size; c++) {
		 * Sim s = new Sim(); System.out.println(s.toString()); t[c] = s; } families[r]
		 * = t; System.out.println(r+" family set end"); }
		 */
		for (int r = 0; r < families.length; r++) {
			Sim[] tmp = makeFamily();
			families[r] = tmp;
			System.out.println(r + " family set ! " + tmp);
		}

		// ==========================================================================
		// 세팅 완료되고 나면..
		// 전체 패밀리정보를 전부 출력
		for (int r = 0; r < families.length; r++) {
			System.out.println(r + "'s  Family");
			Sim[] ar = families[r];
			for (int i = 0; i < ar.length; i++) {
				Sim s = ar[i];
				System.out.println(" ▷ " + i + " : " + ar[i]);
			}
		}
		// =============================================================================
		// 이 가족들중에 남자 몇명, 여자 몇명 개수 .. 확인
		int[] cnt = new int[2];
		for (int r = 0; r < families.length; r++) {
			Sim[] ar = families[r];
			for (int i = 0; i < ar.length; i++) {
				Sim s = ar[i];
				if (s.gender)	// families[r][c].gender
					cnt[0] += 1;
				else
					cnt[1] += 1;
			}
		}
		System.out.println("남 : " +cnt[0] + " / 여 : " + cnt[1] );
		// 2인가족이 몇개인가..
		int two = 0;
		for (int r = 0; r < families.length; r++) {
			Sim[] ar = families[r];
			if(ar.length==2) 
				two++;
		}
		// 10대 몇명인가..(10~19)
		int teenager  =0;
		for (int r = 0; r < families.length; r++) {
			for (int c = 0; c < families[r].length; c++) {
				if(families[r][c].age /10 == 1)
					teenager++;
			}
		}
		// "박시우" 라는 이름을 가진 Sim은 있는가..? == "박시우"
		boolean find = false;
		
		for (int r = 0; r < families.length; r++) {
			Sim[] ar = families[r];
			for (int i = 0; i < ar.length; i++) {
				Sim s = ar[i];
				if(s.name =="박시우") {
					find = true;
					break;
				}
			}
		}
		System.out.println("박시우 find ? " + find);
		// 이 families에 들어가져 있는 Sim중에 하나를 random()으로 뽑아라

		int randRow = (int)(Math.random()*families.length);
		Sim[] pickFamily = families[randRow];
		Sim pick = pickFamily[  (int)(Math.random()*pickFamily.length)  ];
		System.out.println(pick + " 이/가 칭찬을 받습니다.(in " + randRow +" family)");

	}
}
