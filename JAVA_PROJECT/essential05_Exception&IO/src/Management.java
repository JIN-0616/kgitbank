import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class DataManagement{
	Map<String, List<String> > groups;
	
	public DataManagement() {
		//--------init data Setting-----------
		groups = new TreeMap<>();
		List<String> list = new ArrayList<>();
			list.add("루피");
			list.add("조로");
		groups.put("밀짚모자", list);	
		groups.put("빅맘", new ArrayList<>());
		groups.get("빅맘").add("징베");
		
		List<String> got = groups.get("빅맘");
		got.add("푸딩");
		//------------------------------------
	}
	
	public DataManagement(File path) {
		//-------Load data Setting------------
		//------------------------------------
	}
	
	// 그룹, 사이즈, value
	void save(DataManagement a) {

	}

}

public class Management {
	DataManagement a;
	boolean isRun = false;
	File root = new File(System.getProperty("user.home"));
	File path = new File(root, "Management\\list.sav");
	public Management() {
		if (path.exists()) {
			a = new DataManagement(path);
			
		} else if(path.getParentFile().exists() & !path.exists()){
			//폴더有,파일無 , new save파일생성			
		} else {
			a = new DataManagement();
			//폴더 생성, save생성
			try {
				File t = new File(root, "Management");
				if(t.mkdirs()) {
					boolean r = path.createNewFile();
				}
			} catch (IOException e) {
				System.out.println("파일생성오류");
			}
			
		}
	}
	
	void start() {
		Scanner cin = new Scanner(System.in);
		isRun = true;
		while(isRun) {
			System.out.print("SYSTEM> ");
			String cmd = cin.nextLine();
			String[] ar = cmd.split(" ");
			switch(ar[0]) {
			case "전체":
				if(a.groups.isEmpty()) {
					System.out.print("등록된 데이터가 없습니다.");
					break;
				}else {
					int sum =0;
					for( Entry<String,List<String>> e : a.groups.entrySet() ) {
						if(e.getValue().isEmpty()) {
							continue;
						}
						System.out.println("# " +e.getKey());
						System.out.println("  → " +e.getValue());
						sum += e.getValue().size();
					}
					System.out.println("# 총 " +sum+"개의 데이터가 관리중입니다.");
				}
				break;
			case "삭제":
				if(!a.groups.isEmpty()) {
					boolean rst = false;
					for(List<String> e : a.groups.values()) {
						if(e.contains(ar[1])) {
							e.remove(ar[1]);
							rst = true;
							//entry 혹은 keyset로 돌렸으면 그룹이 비었으면 삭제가능
							//맵은 key를 모르면 삭제를 못함
							break;
						}
					}
					System.out.println("# " + ar[1]+" 데이터가 삭제 "+(rst ? "성공" :"실패") + "하였습니다.");
				}
				break;
			case "확인":
				if(!a.groups.isEmpty()) {
					String g = null;
					for( String key : a.groups.keySet() ) {
						if(a.groups.get(key).contains(ar[1])) {
							g = key;
							break;
						}
					}
					if(g == null) {
						System.out.println("# " + ar[1]+" 데이터는 존재하지 않습니다.");
					}else {
						System.out.println("# " + ar[1]+" 데이터는 " + g + " 에 등록되어 있습니다.");
					}
				}
				break;
			case "저장": 
				if(ar.length != 3) {
					System.out.println("# 사용법은 저장 데이터 그룹 형태입니다.");
					continue;
				}
				for(List<String> e : a.groups.values()) {
					if(e.contains(ar[1])) {
						e.remove(ar[1]);
						break;
					}
				}
				if(a.groups.get(ar[2]) == null)	// if( !groups.containsKey(ar[2]) )
					a.groups.put(ar[2], new ArrayList<>());
				
				boolean r = a.groups.get(ar[2]).add(ar[1]);
				System.out.println("# " + ar[1] + " 데이터가 " + ar[2] +" 에 저장되었습니다.");
				break;
			case "백업":				
				a.save(a);
				break;
			case "종료":
				isRun = false;
				break;
			default :
				System.out.println("# 사용가능메뉴는 [저장, 삭제, 확인, 전체, 백업, 종료] 입니다.");
			}
			
		}
	}

}











