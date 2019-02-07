import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * 
 *	share 공유폴더에 access_log.txt 파일을 준비해두었다.
 *	이 파일에서 문자들을 읽어내서 IP 별 요청회수 통계를 내달라.
 *		/ 이 서버로 요청을 보낸 IP 들 개수 를 구해도 된다.
 *	
 *
 */
public class Exercise03_CharInput {
	public static void main(String[] args) {
		System.out.println("[시스템] 로그 분석 시작");
		try(BufferedReader br = new BufferedReader(new FileReader("access_log.txt"));){
			int cnt=0;
			Set<String> ips = new LinkedHashSet<>();
			for(;;) {
				String line = br.readLine();
				if(line == null) 
					break;
				
				String[] datas = line.split(" ");
				
				String ip =  datas[0];
				ips.add(ip);
				cnt++;
			}
			System.out.println("[시스템] 분석 결과 (총 데이터 : " + cnt+")");
			System.out.println("[시스템] 총 요청 주소 : " + ips.size() );
			for(String e : ips) {
				System.out.println("[시스템] " +  e);
			}
			
		}catch (IOException e) {
			System.out.println("[시스템] 분석 오류. " + e.toString());
		}
		
		
		
		
		
	}
}
