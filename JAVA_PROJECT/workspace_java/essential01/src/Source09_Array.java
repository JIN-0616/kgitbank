
public class Source09_Array {
	
	static boolean[] makeSample() {
		boolean[] sheet = new boolean[ 5+(int)(Math.random()*10) ];
		for (int idx = 0; idx <= sheet.length-1; idx++) {
			if(Math.random()>0.5)
				continue;
			sheet[idx] = true;
		}
		return sheet;
	}

	
	
	public static void main(String[] args) {
		// �迭��ü�� �����͸� �����ϴ� ������ [0], [1] ���ʴ�� ��ȣ�� �����صΰ�,
		// �� �ε����� ���� ���� �����͸� �����Ѵٰų�, Ȯ���Ѵٰų� �Ҽ� �ְ� ���ִ�.

		boolean[] sheet = makeSample(); 
		System.out.println("sample.. obtained..");
		for (int idx = 0; idx < sheet.length; idx++) {
			System.out.println(idx + " : " + sheet[idx]);
		}
		System.out.println(sheet.toString());	// �̰ɷ� �ϰ� Ȯ���Ҽ� �ְ� �����ص����� ����.
		// �迭�� �����͸� ������ѵΰ�, ���� �ϴ� �۾��� Ư�����¸� ���� ������ ���� Ȯ���ϴ� �۾�
		// true ���� ����, ��ü ������ �� true �� ������..?
		
		
		
		
	}
}
