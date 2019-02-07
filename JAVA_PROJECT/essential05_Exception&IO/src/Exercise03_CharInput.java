import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Share 공유폴더에 access_log.txt 파일을 준비해두었다. 
 * 이 파일에서 문자들을 읽어내서 ip별 요청회수 통계를 내 달라.
 * 			/이 서버로 요청을 보낸 IP들 개수를 구해라.
 */

public class Exercise03_CharInput {
	public static void main(String[] args) {
		// 로그파일 분석을 위해서 라인단위 입력을 받아야 하는 경우
		// ==> readLine() 
		// 첫번째 공백문자찾기 -> 거기까지 substring .. => [0번째] 아이피 추출
		// 아이피별 count --> Map 사용 추천 
		// 카드합성 형태와 비슷한 예
		File log = new File("access_log.txt");
		Map<String, List<String>> map = new HashMap<>();
		String str = "";
		try(BufferedReader br = new BufferedReader(new FileReader(log));) {
			while(true) {
				String a = br.readLine();
				if(a == null)
					break;
				String[] ar = a.split(" ");
				if(map.containsKey(ar[0])) {
					map.get(ar[0]).add(a);
				}else {
					List<String> list = new ArrayList<>();
					map.put(ar[0], list);
					list.add(a);
				}
			}
			
		} catch (IOException e) {
			System.out.println("[SYSTEM] IOE input Error");
		}
		Set<String> key = map.keySet();
		
		for (String s : key) {
			System.out.println(s+" => "+map.get(s).size());			
		}
	}
}
