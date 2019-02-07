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
		 * 파일에다가, ar배열과 br배열의 데이터를 문서편집기 로 볼 수 있게 출력
		 *  
		 */
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("arrayData.log"));){
			bw.write("# int 배열의 최종 상태");
			bw.newLine();
			for(int a : ar) {
				bw.write(String.valueOf(a));
				bw.write(",");
			}
			
			bw.newLine();
			bw.newLine();
			bw.write("# boolean 배열의 최종 상태");
			bw.newLine();
			for(boolean b : br) {
				bw.write(String.valueOf(b));
				bw.write(",");
			}
			System.out.println("[시스템] 로그파일 생성 완료.");
		}catch(IOException  e) {
			System.out.println("[시스템] 로그파일 생성 실패." + e.toString());
		}
		
		
		
	}
	
	
}
