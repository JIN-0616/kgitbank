package pregame.login;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.manager.ExistingUser;
import data.network.ServerNetworkStart;
import data.user.User;

public class SignUpServer {
		ServerNetworkStart serverNet;
	
		// ȸ������ ���� �� ����
		public static int SUCCESS = 1011;
		public static int FAILED = 1012;
		
		// Request
		public Map<String, Object> request;
		
		// ������ - �⺻ ����
		public SignUpServer(ServerNetworkStart serverNet, Map request) {
				this.serverNet = serverNet;
				this.request = request;
		}

		// ȸ������ �޼ҵ�
		/* 
		 * ȸ�����Խ� :
		 * 
		 */
		public void signUp(Map request) {
			User user = (User) request.get("user");
			Map<String, Object> response = new Hashtable<String, Object>();
			response.put("mode", "join");
			if (ExistingUser.existingUsers.contains(user)) {
				response.put("result", FAILED);
			} else {
				response.put("result", SUCCESS);
			}
			try {
				serverNet.oos.writeObject(response);
				if ((int) response.get("result") == SUCCESS) {					
					ExistingUser.existingUsers.add(user);
					ExistingUser.saveUsers();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
