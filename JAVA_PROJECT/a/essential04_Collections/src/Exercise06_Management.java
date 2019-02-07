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
public class Exercise06_Management {
	public static void main(String[] args) {
		if(Math.random() >0.5) {
			System.out.println("SYSTEM> DATA LOAD SUCCESS.");
		}else {
			System.out.println("SYSTEM> DATA LOAD FAILED.");
		}
		Map<String, List<String>> groups = new TreeMap<>();
		List<String> list = new ArrayList<>();
		list.add("루피");
		list.add("조로");
		groups.put("밀짚모자", list);

		groups.put("빅맘", new ArrayList<>());
		groups.get("빅맘").add("징베");
		List<String> got = groups.get("빅맘");
		got.add("푸딩");
		// System.out.println(groups.toString());
		groups.clear();
		Scanner cin = new Scanner(System.in);
		while (true) {
			System.out.print("SYSTEM> ");
			String cmd = cin.nextLine();
			String[] ar = cmd.split(" ");
			switch (ar[0]) {
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
		/*
		 * 저장메뉴 입력방식 ) 저장 이름 소속 입력 예)저장 나미 밀짚모자 (전제조건, 이름은 고유해야 됨) 저장 징베 밀짚모자 / 이전에 이
		 * 문자열이 어딘가의 List에 등록되있다면 삭제 처리 (새로운 그룹은 List부터 만들어서 문자열 저장) 저장 샹크스 붉은머리
		 * 
		 * 삭제 메뉴 삭제 나미
		 * 
		 * 확인 메뉴 확인 징베 (징베 은/는 밀짚모자로 등록되어있습니다)
		 * 
		 * 전체 전체 밀짚모자 .. . . ....
		 * 
		 * 총 몇개의 데이터가 관리되고 있습니다.
		 * 
		 * 
		 * 
		 * 
		 */

	}
}
