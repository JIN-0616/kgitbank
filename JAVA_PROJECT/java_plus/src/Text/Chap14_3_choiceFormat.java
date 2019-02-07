package Text;
/*
	3. choiceFormat : 특정범위의 값을 문자열로 반환
		if 나 switch와 비슷
		범위배열은 반드시 작은수부터 기재 - double 배열로 선언
		범위와 반환 배열의 원소갯수는 같아야 한다.
		형식 : choiceFormat(범위배열, 반환배열) 
 */
import java.text.*;
public class Chap14_3_choiceFormat {
	public static void main(String[] args) {
		
		double [] jum = {0,60,70,80,90}; // 범위배열
		String [] gra = {"가","양","미","우","수"}; // 반환배열
		ChoiceFormat cf = new ChoiceFormat(jum,gra);
		int aa=88;
		System.out.println(cf.format(aa)); // 우
		//--------------------------------------------------------
		Object[][] a = {
				{"장동건","정우성","원빈"},
				{80,70,60},
				{0.0,60.0,70.0,80.0,90.0},
				{"가","양","미","우","수"}
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
			System.out.println(a[0][i]+" : "+a[1][i]+" 등급: "+cf_a.format(a[1][i]));			
		/*
		장동건 : 80 등급: 우
		정우성 : 70 등급: 미
		원빈 : 60 등급: 양
		*/	
		}
	}
}
