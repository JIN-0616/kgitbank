package server;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankPool {
	Map<String , Account> pool;
	
	public BankPool() {
		pool = new HashMap<>();
	}
	
	public String create() {
		String str = UUID.randomUUID().toString();
		for(;;) {
			String id =  str.split("-")[0];
			if(!pool.containsKey(id)) {
				Account a =  new Account(id);
				pool.put(id, a);
				return "true#"+id;
			}
		}
	}
	
	public String get(String id, String pass) {
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
		
	public String add(String id, String pass, int a) {
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

	public String exist(String id) {
		if(pool.containsKey(id)) {
			return "true";
		}else {
			return "false";
		}
	}

	public String transfer(String id, String pass, String target, int ammount) {
		if(pool.containsKey(id)) {
			Account ac = pool.get(id);
			if(ac.validate(pass) && ac.balance >= ammount && pool.containsKey(target)) {
				ac.subBalance(ammount);
				pool.get(target).addBalance(ammount);
				return "true";
			}else {
				return "false";
			}
		}else {
			return "false#not exist";
		}
	}
	
	
}
