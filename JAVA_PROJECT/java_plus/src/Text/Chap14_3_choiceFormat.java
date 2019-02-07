package Text;
/*
	3. choiceFormat : Ư�������� ���� ���ڿ��� ��ȯ
		if �� switch�� ���
		�����迭�� �ݵ�� ���������� ���� - double �迭�� ����
		������ ��ȯ �迭�� ���Ұ����� ���ƾ� �Ѵ�.
		���� : choiceFormat(�����迭, ��ȯ�迭) 
 */
import java.text.*;
public class Chap14_3_choiceFormat {
	public static void main(String[] args) {
		
		double [] jum = {0,60,70,80,90}; // �����迭
		String [] gra = {"��","��","��","��","��"}; // ��ȯ�迭
		ChoiceFormat cf = new ChoiceFormat(jum,gra);
		int aa=88;
		System.out.println(cf.format(aa)); // ��
		//--------------------------------------------------------
		Object[][] a = {
				{"�嵿��","���켺","����"},
				{80,70,60},
				{0.0,60.0,70.0,80.0,90.0},
				{"��","��","��","��","��"}
		};
		// Double[] buf = (Double[])a[2].clone();
		double[] aaa = new double[a[2].length];
		for (int i = 0; i < aaa.length; i++) {
			aaa[i]=((Double)a[2][i]).doubleValue();
		}
		String[] buf = new String[a[3].length];
		for (int i = 0; i < buf.length; i++) {
			buf[i]=(String)a[3][i];
		}
		ChoiceFormat cf_a = new ChoiceFormat(aaa,buf);
		for (int i = 0; i < a[1].length; i++) {
			System.out.println(a[0][i]+" : "+a[1][i]+" ���: "+cf_a.format(a[1][i]));			
		/*
		�嵿�� : 80 ���: ��
		���켺 : 70 ���: ��
		���� : 60 ���: ��
		*/	
		}
	}
}
