
class Sim {
	static String[] first;
	static String[] last;
	static {
		first = new String[] { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };
		last = new String[] { "����", "����", "����", "�ÿ�", "����", "����", "����", "����", "����", "����" };
	}
	String name;
	int age;
	boolean gender;

	Sim() {
		int fidx = (int) (Math.random() * first.length);
		int lidx = (int) (Math.random() * last.length);

		name = first[fidx] + last[lidx];
		name.intern();	// �̰� �����۾������� String ��ü ���캼�� �˾ƺ���.
		age = 7 + (int) (Math.random() * 50);
		gender = Math.random() > 0.5;
	}

	// public String toString() �� �������̵� �̸�(xx��/����)
	public String toString() {
		return name + "(" + age + "��/" + (gender ? "��" : "��") + ")";
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
		// �� Sim[] �迭 7���� �����Ҽ� �ִ� ������ ������µ�,
		// ������ũ��(2~5�� ����)�� �迭�� Sim ��ü�� �����ؼ� families �� ���
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
		// ���� �Ϸ�ǰ� ����..
		// ��ü �йи������� ���� ���
		for (int r = 0; r < families.length; r++) {
			System.out.println(r + "'s  Family");
			Sim[] ar = families[r];
			for (int i = 0; i < ar.length; i++) {
				Sim s = ar[i];
				System.out.println(" �� " + i + " : " + ar[i]);
			}
		}
		// =============================================================================
		// �� �������߿� ���� ���, ���� ��� ���� .. Ȯ��
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
		System.out.println("�� : " +cnt[0] + " / �� : " + cnt[1] );
		// 2�ΰ����� ��ΰ�..
		int two = 0;
		for (int r = 0; r < families.length; r++) {
			Sim[] ar = families[r];
			if(ar.length==2) 
				two++;
		}
		// 10�� ����ΰ�..(10~19)
		int teenager  =0;
		for (int r = 0; r < families.length; r++) {
			for (int c = 0; c < families[r].length; c++) {
				if(families[r][c].age /10 == 1)
					teenager++;
			}
		}
		// "�ڽÿ�" ��� �̸��� ���� Sim�� �ִ°�..? == "�ڽÿ�"
		boolean find = false;
		
		for (int r = 0; r < families.length; r++) {
			Sim[] ar = families[r];
			for (int i = 0; i < ar.length; i++) {
				Sim s = ar[i];
				if(s.name =="�ڽÿ�") {
					find = true;
					break;
				}
			}
		}
		System.out.println("�ڽÿ� find ? " + find);
		// �� families�� ���� �ִ� Sim�߿� �ϳ��� random()���� �̾ƶ�

		int randRow = (int)(Math.random()*families.length);
		Sim[] pickFamily = families[randRow];
		Sim pick = pickFamily[  (int)(Math.random()*pickFamily.length)  ];
		System.out.println(pick + " ��/�� Ī���� �޽��ϴ�.(in " + randRow +" family)");

	}
}
