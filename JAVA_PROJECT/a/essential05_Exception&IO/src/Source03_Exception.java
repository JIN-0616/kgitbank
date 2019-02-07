import java.util.Scanner;

/*
 * Exception �� �������ΰ� �� �߰��ǰ�, 
 * 	�����ڵ鵵 ���� ����Ҽ� �ֱ� ������ �� �ܿ�ٴ°� �Ұ����̴�.
 */

// �ڵ�󿡼� ���Ƴ��� �ͼ����� RuntimeException , (�ʼ� handle�� ���ص� �Ǵ� �ͼ���)
class InvalidException extends RuntimeException {	
	// �ϳ��� ���������Ͱ� �������� ������ �ͼ��� 
}
// �ͼ����� �����ϴµ�, �� �ͼ��ǵ� RuntimeException ���� extends �ɾ
// �ͼ��� ��ü ���� �� �ϰ�, �� �ͼ�����
// Triangle ��ü�� ���鶧, ���������� �ﰢ���� �ȸ�������� ��쿡 �ͼ����� �߻���Ű��.
class NotEnoughException extends RuntimeException {
	
}
//=============================================================
class Triangle {
	int x,y,z;
	
	Triangle(int x, int y, int z) {
		if(x<=0 || y<=0 || z <=0) {
			throw new InvalidException();
		}
		// �ϳ��� ������ ���� �ΰ��� ���� �� Ŀ�� ��.
		if( x+y<=z || x+z <= y ||  y+z <= x   )
			throw new NotEnoughException();
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Source03_Exception {
	public static void main(String[] args) {
		try {
			new Triangle(3, 4, 3);
		}catch(InvalidException e) {
			System.out.println("InvalidException .. ");
		}catch(NotEnoughException e) {
			System.out.println("NotEnoughException .. ");
		}
		//=======================================================
		
		try {
			new Triangle(3, 4, 1);
		}catch( InvalidException | NotEnoughException e  ) {
			System.out.println("InvalidException | NotEnoughException");
		}
		
		
		
		
		
		
	}
}


