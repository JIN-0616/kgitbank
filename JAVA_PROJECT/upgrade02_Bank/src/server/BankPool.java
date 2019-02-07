package server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;

public class BankPool implements Serializable{
	Map<String , Account> pool;
	
//	Gson gson = new Gson();
	
	public BankPool() {
		pool = new HashMap<>();
	}
	
	public String create() {
		String str = UUID.randomUUID().toString();
		for(;;) {
			String id =  str.split("-")[0];		// 8-4-4-4-12 (총 32개) 구조를 분해
			if(!pool.containsKey(id)) {
				Account a =  new Account(id);
				pool.put(id, a);
				return "true#"+id;
			}
		}
	}
	
	public String get(String id, String pass) {		//id/pw 넘겨서 확인 계좌받아옴, 계좌확인
		if(pool.containsKey(id)) {
			Account ac = pool.get(id);
			if(ac.validate(pass)) {
				return "true#"+id+"#"+ac.balance;
			}else {
				return "false#not equal";
			}
		}else {
			return "false#not exist";
		}
	}
		
	public String add(String id, String pass, int a) { // 맞을때만 돈 입력
		if(pool.containsKey(id)) {
			Account ac = pool.get(id);
			if(ac.validate(pass)) {
				ac.addBalance(a); 
				return "true";
			}else {
				return "false#not equal";
			}
		}else {
			return "false#not exist";
		}
	}
	
	public String transfer(String id, String pass, int a, String toid) {
		if(pool.containsKey(id)) {
			Account ac = pool.get(id);
			if(ac.validate(pass)) {
				if(pool.containsKey(toid)) {
					Account toac = pool.get(toid);
					if(ac.subBalance(a)) {
						toac.addBalance(a);
						return "true";
					}else {
						return "false#not enough your money";
					}
				}else {
					return "false#send id not exist";
				}
			}else {
				return "false#password not equal";
			}
		}else{
			return "false#id not exist";
		}
	}

	public String sub(String id, String pass, int a) {
		if(pool.containsKey(id)) {
			Account ac = pool.get(id);
			if(ac.validate(pass)) {
				if(ac.subBalance(a)) {
					return "true";
				}else {
					return "false#not enough your money";
				}				
			}else {
				return "false#password not equal";
			}
		}else{
			return "false#id not exist";
		}
	}

	public String modifypass(String id, String pass, String newpass) {
		if(pool.containsKey(id)) {
			Account ac = pool.get(id);
			if (ac.validate(pass)) {
				ac.modifyPass(newpass);
				return "new pass true";
			}else {
				return "false#password not equal";
			}
		}else{
			return "false#id not exist";
		}
	}	
	public String modifypass(String id, String pass) {
		if(pool.containsKey(id)) {
			Account ac = pool.get(id);
			if(ac.pass==null) {
				ac.modifyPass(pass);
				return "true";
			}else {
				return "false#password not equal";
			}
		}else{
			return "false#id not exist";
		}
	}

	public String exist(String id) {
		if(pool.containsKey(id)) {
			return "true";
		}else {
			return "false";			
		}
	}
	
}
