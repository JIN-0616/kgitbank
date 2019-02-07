import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
 * 문자열 관리를 하려고 함, {String}
 * 	List와 Map을 섞어서 처리하려고 함
 */
public class Exercise06_Management {
	public static void main(String[] args) {
		Map<String, List<String>> groups = new TreeMap<>();
		
		//-------여러 입력방식----------------
		List<String> list = new ArrayList<>();
			list.add("루피");list.add("조로");			
		groups.put("밀집모자",list);
		
		groups.put("빅맘", new ArrayList<>());
		groups.get("빅맘").add("징베");
		List<String> got = groups.get("빅맘");
		got.add("푸딩");
		//-------------------------------------
	//	System.out.println(groups.toString());
		
		Scanner cin = new Scanner(System.in);
		
		while (true) {
			System.out.print("SYSTEM> ");			
			String cmd = cin.nextLine();
			String[] ar = cmd.split(" "); //cmd 입력방식 구현 - 일괄Line명령어imput
			//System.out.println(ar[0]+" / "+ar.length);
			Set<Entry<String, List<String>>> all = groups.entrySet();			

			switch(ar[0]) {
			case "입력":
			case "저장":
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					
					boolean get = e.getValue().contains(ar[1]); //기존값 존재여부
					boolean getkey = e.getKey().equals(ar[2]); // 입력 그룹과 동일여부
					boolean iskey = groups.containsKey(ar[2]); // 그룹 존재여부
					
					if(get && getkey) {						
						e.getValue().remove(ar[1]);
						groups.get(ar[2]).add(ar[1]);
						System.out.println("SYSTEM> 정상처리 -재등록");					
					}else if(!get && getkey && iskey) {
						groups.get(ar[2]).add(ar[1]);
						System.out.println("SYSTEM> 정상처리 -신규등록");
					}else if(get && !getkey) {
						e.getValue().remove(ar[1]);
						System.out.println("SYSTEM> 정상처리 -기존삭제");
					}else if(!get && !getkey && !iskey) {
						groups.put(ar[2], new ArrayList<>());
						groups.get(ar[2]).add(ar[1]);
						System.out.println("SYSTEM> 정상처리 -신규그룹등록,신규등록");
						break;	
					}
				}						
				break;
			case "삭제":
				//contains 확인
				//확인후 remove	
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					if(e.getValue().contains(ar[1])) {
						//int idx = e.getValue().indexOf(ar[1]);						
						boolean ok = e.getValue().remove(ar[1]);
						if(ok)
							System.out.println("SYSTEM> "+ar[1]+" 을/를 정상 삭제하였습니다..");
						break ;
					}
					if(!i.hasNext()) {
						System.out.println("SYSTEM> "+ar[1]+" 을/를 찾을수 없습니다.");
					}
				}
				break;
			
			case "확인":
				//contains 확인
				//check 그룹
				//출력문 작성
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					if(e.getValue().contains(ar[1])) {
						//int idx = e.getValue().indexOf(ar[1]);						
						System.out.println("SYSTEM> "+ar[1]+" 은/는 "+e.getKey()+" 으로/로 등록되어있습니다.");
						break ;
					}
					if(!i.hasNext()) {
						System.out.println("SYSTEM> "+ar[1]+" 을/를 찾을수 없습니다.");
					}
				}				
				break;
					
			case "all":
			case "전체":	
				//entrySet 처리
				//총인원수 처리
				//출력문 작성
				int sum = 0;		
				System.out.println("SYSTEM> =======================");
				for (Entry<String, List<String>> a : all) {
					System.out.println("SYSTEM> "+a+"");
					sum += a.getValue().size();
				}				
				System.out.println("SYSTEM> 총 인원수 : "+sum);
				System.out.println("SYSTEM> =======================");				
				break;
			default:
				System.out.println("SYSTEM> Error : 저장, 삭제, 확인, 전체" );				
			}
		}
		/* <저장메뉴>
		 *    입력방식 : 저장 이름 소속
		 * 		     ex) 저장 나미 밀집모자
		 *    (전제조건, 이름은 고유해야 됨)
		 *	 		   저장 징베 밀집모자 /
		 * 		 	   이전에 이 문자열이 어딘가에 list에 등록되어있으면 삭제처리
		 *    (새로운 그룹은 list로 부터 만들어서 문자열 저장)
		 *  	     ex) 저장 샹크스 붉은머리	
		 * 
		 * <삭제메뉴>
		 *     삭제 나미 - 찾아서 삭제
		 *  
		 * <확인메뉴> 
		 *     확인 징베 : (징베 은/는 밀집모자로 등록되어있습니다.)
		 * 
		 *   +  <전체> : 모든 이름 출력 (entrySet도 괜찮음)  
		 * 				+총 인원수 출력
		 */
	}
}
