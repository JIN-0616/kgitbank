


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
		
		Set<Entry<String, List<String>>> all = groups.entrySet();
		
		while (true) {
			System.out.print("SYSTEM> ");
			String cmd = cin.nextLine();
			String[] ar = cmd.split(" "); //cmd 입력방식 구현 - 일괄Line명령어imput
			System.out.println(ar[0]+" / "+ar.length);
			switch(ar[0]) {
			case "저장":
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					
					boolean getVal = e.getValue().contains(ar[1]);
					boolean getKey = e.getKey().equals(ar[2]);
					boolean a = groups.containsKey(ar[2]);
					
					if(getVal && getKey) {
						e.getValue().remove(ar[1]);
						e.getValue().add(ar[1]);
						System.out.println("SYSTEM> 재입력");
					}if(!getVal && getKey) {
						e.getValue().add(ar[1]);
						System.out.println("SYSTEM> 신규입력");
					}if (!getVal && !getKey && !a) {
						groups.put(ar[2], new ArrayList<>());
						groups.get(ar[2]).add(ar[1]);
					}
				}
				
//				if(groups.containsValue(ar[2])){
//					//이름 입력
//				}else {
//					//그룹 생성(등록)
//					groups.put(ar[1], new ArrayList<>());
//					//이름 입력(등록)
//					groups.get(ar[1]).add(ar[2]);
//				}
				break;
			case "삭제":
				//contains 확인
				//확인후 remove
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					if(e.getValue().contains(ar[1])) {
						e.getValue().remove(ar[1]);
					}
				}
//				if(groups.keySet().contains(ar[1])) {
//					if(groups.get(ar[1]).contains(ar[2])) {
//						groups.get(ar[1]).remove(ar[2]);
//						System.out.println(ar[2]+" 삭제");						
//					}else {
//						System.out.println(ar[2]+" missing error");
//					}
//				}else {
//					System.out.println(ar[1]+" missing error");
//				}
				break;
			case "확인":
				//contains 확인
				//check 그룹
				//출력문 작성
				for (Iterator i = all.iterator(); i.hasNext();) {
					Entry<String, List<String>> e = (Entry<String, List<String>>) i.next();
					if(e.getValue().contains(ar[1])) {
						 String key = e.getKey();
						 System.out.println("("+ar[1]+" 은/는 "+key+"으로/로 등록되어있습니다.");
					}
					
				}				
				break;
					

			case "전체":	
				//entrySet 처리
				//총인원수 처리
				//출력문 작성
				int sum=0;
				for (Entry<String, List<String>> a : all) {
					System.out.println(a);
					sum += a.getValue().size();
				}
				System.out.println("총 인원수 : "+sum);
				break;
			default:
				System.out.println(" Error");				
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
