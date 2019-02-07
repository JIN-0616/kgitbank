import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * 이 데이터를 출력할때 어떤 방식으로 해두는게 재확보하기 편하나
 * 
 * 		1. 키 별로 파일을 다 만들어서 데이터 write
 * 		2. 하나의 파일에 데이터를 분리해서 write
 */

public class DataPool {
	File dir;
	DataPool() {
		dir = new File(System.getProperty("user.home"), "saves");
		System.out.println(dir.getAbsolutePath());
		if(!dir.exists()) { //다른프로그램에서 saves 사용하고있으면 에러날듯
			dir.mkdirs();
		}
	}
	//Obejct 새로만든 버전 save
	public boolean save(Map<String,List<String>> t) {
		try {
			for (String key : t.keySet()) {
				ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(new File(dir, key)));
				List<String> val = t.get(key);
				dos.writeObject(val);
				dos.close();
			}
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	//Obejct 새로만든 버전 load
	public Map<String, List<String>> load(){
		Map<String, List<String>> map = new TreeMap<>();
		File[] childs = dir.listFiles();
		try {
			for (File c : childs) {
				ObjectInputStream dis = new ObjectInputStream(new FileInputStream(c));
				List<String> li = (List<String>)dis.readObject();
				map.put(c.getName(), li);
				dis.close();				
			}	
			return map;
			
		}catch(ClassNotFoundException | IOException e) {
			for(File c: childs) {
				c.delete();
			}			
			System.out.println("load fail.."+e.getMessage());
			return null;
		}	
					

	}
	//기존
	public boolean saveData(Map<String,List<String>> t) {
		try {
			for (String key : t.keySet()) {
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(dir, key)));
				List<String> val = t.get(key);
				for (String n : val) {
					dos.writeUTF(n);
				}
				dos.close();
			}
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//기존
	public Map<String, List<String>> loadData(){
		Map<String, List<String>> map = new TreeMap<>();
		try {
			File[] childs = dir.listFiles();
			for (File c : childs) {
				List<String> li = new ArrayList<>();
				DataInputStream dis = new DataInputStream(new FileInputStream(c));
				while(dis.available()>0) {
					String d = dis.readUTF();
					li.add(d);
				}
				map.put(c.getName(), li);
				dis.close();				
			}	
			return map;
			
		}catch(IOException e) {
			System.out.println("load fail.."+e.getMessage());
			return null;
		}	
					

	}
	//===============================================================================
	// 이런방식은 3번씩 잘라서 load해야함 load()어려움
	// 2가지 방식의 동시 사용은 힘들듯
	public boolean saveOthersData(Map<String,List<String>> t) {
		try {
			File target = new File(dir, "allDatas");
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(target));
			for (String key : t.keySet()) {
				dos.writeUTF(key);
				List<String> val = t.get(key);
				dos.writeInt(val.size());
				for (String n : val) {
					dos.writeUTF(n);
				}				
			}
			dos.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean saveOthersObject(Map<String,List<String>> t) {
		try {
			File target = new File(dir, "allDatas");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target));
			oos.writeObject(t); //통채로 출력하는 방법 , 복원도 맵을 통채로
			oos.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Map<String, List<String>> loadOthersObject(){ 
		Map<String, List<String>> map = null;
		File[] childs = dir.listFiles();
		try {		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir));
			map = (Map)ois.readObject();
			ois.close();				
			return map;			
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("load fail.."+e.getMessage());
			return null;
		}	
	}	
}
