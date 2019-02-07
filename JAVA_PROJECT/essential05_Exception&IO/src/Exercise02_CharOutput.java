import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Exercise02_CharOutput {
	public static void main(String[] args) {
		int[] ar = new int[7];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) Math.pow(2, i);
		}
		boolean[] br = new boolean[5];
		for (int i = 0; i < br.length; i++) {
			br[i] = Math.random() > 0.5;
		}
		// ==================================================================
		/*
		 * 파일에다가, ar배열과 br배열의 데이터를 문서편집기로 볼 수 있게 출력
		 */
		File f;
		FileOutputStream out;
		OutputStreamWriter osw;
		BufferedWriter bw;
		try {
			f = new File("log.log");
			out = new FileOutputStream(f);
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			
			bw.write("# int 배열의 데이터");
			bw.newLine();
			bw.write("-> ");
			for (int i = 0; i < ar.length; i++) {
				bw.write(String.valueOf(ar[i]));
				bw.write(" ");
			}
			bw.newLine();
			bw.newLine();
			bw.write("# boolean 배열의 데이터");
			bw.newLine();
			bw.write("-> ");
			for (int i = 0; i < br.length; i++) {
				bw.write(String.valueOf(br[i]));
				bw.write(" ");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[SYSTEM] 로그파일 생성");
		
		//-----------------------------------------------------------------
		try(BufferedWriter bw1 = new BufferedWriter(new FileWriter("arrayData.log"));){
			bw1.write("# int 배열의 최종 상태");
			bw1.newLine();
			for (int a : ar) {
				bw1.write(String.valueOf(a));
				bw1.write(",");				
			}
			bw1.newLine();
			bw1.newLine();
			bw1.write("# int 배열의 최종 상태");
			bw1.newLine();
			for (boolean b : br) {
				bw1.write(String.valueOf(b));
				bw1.write(",");
			}
			System.out.println("완");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
