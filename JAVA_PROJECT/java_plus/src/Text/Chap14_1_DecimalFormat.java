package Text;
/*
	1. DecimalFormat
	- ���Ϲ��ڿ��� ���·� ����ȭ
	- ��� ����� "���Ϲ��ڿ�"�� �Ű������� ����ϴ� �����ڸ� ȣ���Ͽ�
	 ��ü�� �����ϰ� �� Ŭ������ format()�޼ҵ带 ȣ���Ͽ� �����͸� ����ȭ �Ѵ�.
	 
	 DecimalFormat fmt = new DecimalFormat("���Ϲ��ڿ�");
	 
	 DecimalFormat : ���� Ȥ�� ���ڿ��� ��¹��
	 	�����ڿ� String ������ ������ �Է�
	 	new DecimalFormat("����");
	 	��� -> printf( DecimalFormat );
	 	
	 	0 : �ڸ��� ǥ��, ���� ������ 0���� ó��
	 	# : �ڸ��� ǥ��, ���� ������ ����
	 	- : ������ȣ, ������ ǥ����ġ ����
	 	, : ����������
	 	% : �����
	 	; : ���, ���� ����	 	
 
*/
import java.text.*;
import java.awt.*;
public class Chap14_1_DecimalFormat {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double dd = -123.456;
		String[] pp = {"0","0.0000","#.####","##,##.##","00,000.00","-##","##-","##.#%","#,##;����#,##"};
		
		DecimalFormat df = new DecimalFormat("#,##0");	//ǥ����� ���ϱ�
		
		System.out.println(df.format(dd));	// ���� �����͸� ǥ��������� ��ȯ
		
		System.out.println("DeciamlFormat ��¹��");
		System.out.println("���� : "+dd);
		for (int i = 0; i < pp.length; i++) {
			df = new DecimalFormat(pp[i]);
			System.out.println(pp[i]+ "  ->  "+df.format(dd));			
		}
		/*
		-123
		DeciamlFormat ��¹��
		���� : -123.456
		0  ->  -123
		0.0000  ->  -123.4560
		#.####  ->  -123.456
		##,##.##  ->  -1,23.46
		00,000.00  ->  -00,123.46
		-##  ->  --123
		##-  ->  -123-
		##.#%  ->  -12345.6%
		#,##;����#,##  ->  ����1,23
		*/
	}
}
