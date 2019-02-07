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
 * �� �����͸� ����Ҷ�, � ������� �صδ°� ��Ȯ���ϱ� �����.
 * 	
 * 		1. Ű���� ������ �� ���� ������ write (�̹��)
 * 		2. �ϳ��� ���Ͽ� �����͸� �и��ؼ� write
 * 
 */
public class DataPool {
	File dir;
	DataPool() {
		dir = new File(System.getProperty("user.home"), "saves");
		System.out.println(dir.getAbsolutePath());
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}
	
	public boolean save(Map<String, List<String>> t) {
		try {
			for(String key : t.keySet()) {
				ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(new File(dir, key)));
				List<String> val = t.get(key);
				dos.writeObject(val);
				dos.close();
			}
			return true;
		}catch(IOException e) {
			System.out.println("save failed.."+ e.getMessage());
			return false;
		}
	}
	
	
	public boolean saveData(Map<String, List<String>> t) {
		try {
			for(String key : t.keySet()) {
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(dir, key)));
				List<String> val = t.get(key);
				for(String n : val) {
					dos.writeUTF(n);
				}
				dos.close();
			}
			return true;
		}catch(IOException e) {
			System.out.println("save failed.."+ e.getMessage());
			return false;
		}
	}
	
	public Map<String, List<String>> load() {
		Map map = new TreeMap<>();
		File[] childs = dir.listFiles();
		try {
			for(File c : childs) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(c));	
				List<String> li = (List<String>)ois.readObject();
				map.put(c.getName(), li);
				ois.close();
			}
			return map;
		}catch(ClassNotFoundException |IOException e) {
			for(File c : childs) {
				c.delete();
			}
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Map<String, List<String>> loadData() {
		Map map = new TreeMap<>();
		try {
			File[] childs = dir.listFiles();
			for(File c : childs) {
				List<String> li = new ArrayList<>();
				DataInputStream dis = new DataInputStream(new FileInputStream(c));
				while(dis.available()>0) {
					String d= dis.readUTF(); 
					li.add(d);
				}
				map.put(c.getName(), li);
				dis.close();
			}
			return map;
		}catch(IOException e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	//====================================================================
	public boolean saveOtherData(Map<String, List<String>> t) {
		try {
			File target = new File(dir, "alldatas");
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(target));
			for(String key : t.keySet()) {
				dos.writeUTF(key);
				List<String> val= t.get(key);
				dos.writeInt(val.size());
				for(String v : val) {
					dos.writeUTF(v);
				}
			}
			dos.close();
			return true;
		}catch(IOException e) {
			System.out.println("save failed.."+ e.getMessage());
			return false;
		}
	}
	public boolean saveOtherObject(Map<String, List<String>> t) {
		try {
			File target = new File(dir, "alldatas");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target));
			oos.writeObject(t);
			
			oos.close();
			return true;
		}catch(IOException e) {
			System.out.println("save failed.."+ e.getMessage());
			return false;
		}
	}
	
	
}
