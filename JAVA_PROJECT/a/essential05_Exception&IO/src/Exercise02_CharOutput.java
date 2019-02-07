import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise02_CharOutput {
	
	public static void main(String[] args) {
		int[] ar = new int[7];
		for(int i=0; i<ar.length; i++) {
			ar[i] = (int)Math.pow(2, i);
		}
		boolean[] br = new boolean[5];
		for(int i=0; i<br.length; i++) {
			br[i] = i%2==0 ? true : false;
		}
		//==============================================================
		/*
		 * ���Ͽ��ٰ�, ar�迭�� br�迭�� �����͸� ���������� �� �� �� �ְ� ���
		 *  
		 */
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("arrayData.log"));){
			bw.write("# int �迭�� ���� ����");
			bw.newLine();
			for(int a : ar) {
				bw.write(String.valueOf(a));
				bw.write(",");
			}
			
			bw.newLine();
			bw.newLine();
			bw.write("# boolean �迭�� ���� ����");
			bw.newLine();
			for(boolean b : br) {
				bw.write(String.valueOf(b));
				bw.write(",");
			}
			System.out.println("[�ý���] �α����� ���� �Ϸ�.");
		}catch(IOException  e) {
			System.out.println("[�ý���] �α����� ���� ����." + e.toString());
		}
		
		
		
	}
	
	
}
