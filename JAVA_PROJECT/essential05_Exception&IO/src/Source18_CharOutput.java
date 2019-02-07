import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Source18_CharOutput {
	public static void main(String[] args) {
		/*
		 * 일일이 사람이 볼수 있게 문자byte를 계산해서 출력하는게 번거롭기 때문에
		 * 
		 * OutputStreamWriter, InputStreamReader 라는 객체를 만들어두었다.
		 * 
		 * 주로 사용시에는  OutputStreamWriter >> BufferedWriter 로 연계해서 사용 
		 */
		try {
			
			//---------------------------------------------------------------------
			/*
			
			FileOutputStream fos = new FileOutputStream("output.log");
			OutputStreamWriter osw = new OutputStreamWriter(fos); 		
			
			//문자(열)에 해당하는 byte객체를 찾아서 자동 출력하는 OutputStreamWriter객체
			//줄바꿈기능이 없으므로 --> 보통 BufferedWriter까지 연계해서 같이 사용
			
			*/
			
			//==> 파일같은 경우,2단계 건너띄고
			//    바로 OutputStreamWriter 와 같은 역활의 객체를 얻을수도 있다.
			FileWriter osw = new FileWriter("output.log");
					
			
			BufferedWriter bw = new BufferedWriter(osw); // 숫자 1 당 char[] 1024칸 (default 8)
														 // char[] 버퍼가 가득차면 writer
														 // 혹은 close() 진행시 writer
			
			bw.write("그룹데이터 v1.0");
			bw.newLine();				//파일에서는 \n이 아니라 \r\n, 1310 이 줄바꿈
			bw.write("===================");
			bw.newLine();
			bw.write("# 밀집모자 #");
			bw.newLine(); //추가된 메소드
			bw.write("▷ 루피");
			bw.write("조로 나미");
			bw.flush(); // .flush() -->강제 buffer내용 쓰기진행 후 buffer 비우기
			bw.newLine();
			bw.newLine();
			bw.write("# 빅맘 #");
			
			// 출력을 할때 입력을 고려하는것이 아닌 파일자체를 외부에서 열어보았을때
			// 바로 문자를 읽을수 있도록 고려하는것			
			
			/*
			osw.write('문'); //2바이트						기호-1바이트씩
			char[] data = new char[] {'자','열','출','력','!','!'};
			osw.write(data);
			osw.write(13);
			osw.write(10);
			//문자와 문자열 출력은 동일한 write를 사용하나 실제로는 다름 (자동 char[]로 변환처리)
			osw.write("[SYSTEM] 문자열 출력");
			osw.append('.');
			osw.append("...");
			*/			
			System.out.println("[SYSTEM] DONE");
			
			bw.close();
			//닫는객체가 무엇인지 주의할것 (stream을 닫았을때 실제로 쓰여진다)
			
		} catch (IOException e) {
			System.out.println("[SYSTEM] exception..." + e.toString());
		}
	}
}
