import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Source18_CharOutput {
	public static void main(String[] args) {
		/*
		 * 일일이 사람이 볼수 있게 문자byte를 계산해서 출력하는게 번거롭기 때문에,
		 * OutputStreamWriter , InputStreamReader 라는 객체를 만들어두었다.
		 * 
		 * OutputStreamWriter ▷▷ BufferedWriter 
		 */
		try  {
			/*
			FileOutputStream fos = new FileOutputStream("output.log");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			파일같은 경우, 바로 OutputStreamWriter 와 같은 역할의 객체를 만들수도 있다.
			*/
			OutputStreamWriter osw = new FileWriter("ouput.log");
			
			BufferedWriter bw = new BufferedWriter(osw, 1);
			bw.write("그룹데이터 v1.0\r\n");
			bw.write("======================================");
			bw.newLine();
			bw.write("# 밀짚모자 #");
			bw.newLine();
			bw.write("▷ 루피 ");
			bw.flush();
			bw.write("조로 나미");
			bw.newLine();
			bw.newLine();
			bw.write("# 빅맘 #");
			/*
			osw.write('문');
			char[] data = new char[] {'자', '열', '출', '력','!','!'};
			osw.write(data);
			osw.write(13);
			osw.write(10);
			osw.write("[SYSTEM] 문자열 출력");
			osw.append('.');
			osw.append("....");
			*/
			bw.close();
			System.out.println("[SYSTEM] DONE");
		} catch (IOException e) {
			System.out.println("exception !! " + e.toString());
		}

	}
}
