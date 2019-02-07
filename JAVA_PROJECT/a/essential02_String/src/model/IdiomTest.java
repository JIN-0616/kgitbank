package model;

public class IdiomTest {
	public static void main(String[] args) {
		String w = "���õ��";
		String h = "����� ��� ���� ������ ����.";
		
		Idiom i = new Idiom(w, h);
		System.out.println(i.mixChars());	// õ�ݻ�⼼��
		System.out.println(i.toString());	// ����� ��� ���� ������ ���� : ��??? 
		
		
		boolean b = i.mark("��ݱ�õ");
		System.out.println(b);
		
		boolean bb =i.mark("���õ��");
		System.out.println(bb);
		
		//=========================================================================
		String[][] datas = new String[][] { 
			new String[] {"�����ֱ�","���񳭸�","��ź����","�߹�����"},
			new String[] {  
						"������ Ȥ���ϰ� ¡���ϰ� ������ ������ �䱸��",
						"���� ������ ���� ���� ������ ���� �繫�� �������� ����",
						"�޸� ��Ű�� ���� ��´ٴ� ��",
						"������ ���� ���� ���� ����� ����"
					}
			};
		//==========================================================================
		Idiom[] ids = new Idiom[4];
		for(int c=0; c<ids.length; c++) {
			// [0][0],[1][0],   / [0][1], [1][1]  
			ids[c] = new Idiom(datas[0][c], datas[1][c]);
		}
		//===========================================================================
		// �� String[] �� �迭�� �̿��ؼ�, Idiom[] �� �����,
		// ���� ���ڼ��� ���߱� ���α׷����� ����
		Idiom p = ids[(int)(Math.random()*ids.length)];
		System.out.println(p);
		
		
	}
}
