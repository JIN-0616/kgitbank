import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
/*
 * 문자열 관리를 하려고 함. (String)
 * 	List와 Map을 섞어서 처리하려고 함.
 */
public class ManagementMain {
	public static void main(String[] args) {
		DataPool dp = new DataPool();
		
		Map<String, List<String>> groups = dp.load();
		if(groups != null) {
			System.out.println("SYSTEM> 데이터 로드 완료");
		}else {
			System.out.println("SYSTEM> 데이터 로드 실패");
			groups = new TreeMap<>();
		}
		
		
		Scanner cin = new Scanner(System.in);
		main : while (true) {
			System.out.print("SYSTEM> ");
			String cmd = cin.nextLine();
			String[] ar = cmd.split(" ");
			switch (ar[0]) {
			case "종료" :
				break main;
			case "전체":
				if (groups.isEmpty()) {
					System.out.println("등록된 데이터가 없습니다.");
					break;
				} else {
					int sum = 0;
					for (Entry<String, List<String>> e : groups.entrySet()) {
						if(e.getValue().isEmpty())
							continue;
						
						System.out.println("# " + e.getKey());
						System.out.println("  → " + e.getValue());
						sum += e.getValue().size();
					}
					System.out.println("# 총 " + sum + "개의 데이터가 관리중입니다.");
				}
				break;
			case "삭제":
				if (!groups.isEmpty()) {
					boolean rst = false;
					for (List<String> e : groups.values()) {
						if (e.contains(ar[1])) {
							e.remove(ar[1]);
							rst = true;
							break;
						}
					}
					System.out.println("# " + ar[1] + " 데이터가 삭제 " + (rst ? "성공" : "실패") + "하였습니다.");
				}
				break;
			case "확인":
				if (!groups.isEmpty()) {
					String g = null;
					for (String key : groups.keySet()) {
						if (groups.get(key).contains(ar[1])) {
							g = key;
							break;
						}
					}
					if (g == null) {
						System.out.println("# " + ar[1] + " 데이터는 존재하지 않습니다.");
					} else {
						System.out.println("# " + ar[1] + " 데이터는 " + g + " 에 등록되어 있습니다.");
					}
				}
				break;
			case "저장":
				if (ar.length != 3) {
					System.out.println("# 사용법은 저장 데이터 그룹 형태입니다.");
					continue;
				}
				for (List<String> e : groups.values()) {
					if (e.contains(ar[1])) {
						e.remove(ar[1]);
						break;
					}
				}
				if (groups.get(ar[2]) == null) // if( !groups.containsKey(ar[2]) )
					groups.put(ar[2], new ArrayList<>());

				boolean r = groups.get(ar[2]).add(ar[1]);
				System.out.println("# " + ar[1] + " 데이터가 " + ar[2] + " 에 저장되었습니다.");
				break;
			default:
				System.out.println("# 사용가능메뉴는 저장,삭제,확인,전체 입니다.");
			}
		}
		//============================================================================================
		// 프로그램 종료할때, 사용중이던 파일에 출력
			dp.save(groups);
		
		
	}
}
