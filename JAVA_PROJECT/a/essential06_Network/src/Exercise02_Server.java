import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Exercise02_Server {
	public static void main(String[] args) {
		List<String> seats = new ArrayList<>();
		seats.add("1-A");
		seats.add("4-H");
		System.out.println("[server] starting");
		long t1 = System.currentTimeMillis();
		try {
			ServerSocket server = new ServerSocket(56789); // 서버에서 개방할 포트
			long t2 = System.currentTimeMillis();
			System.out.println("[server] startup in " + (t2 - t1) + " ms");

			Socket socket = server.accept(); //
			System.out.println("[server] connected by " + socket.getRemoteSocketAddress());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			while (!socket.isClosed()) {
				String req;
				try {
					req = (String) ois.readObject();
				} catch (IOException e) {
					socket.close();
					break;
				}
				System.out.println("[server] received request : " + req);
				String[] reqs = req.split("#");
				String resp = null;
				switch (reqs[0]) {
				case "reserve":
					if (seats.contains(reqs[1])) {
						resp = "false";
					} else {
						resp = "true";
						seats.add(reqs[1]);
					}
					break;
				case "cancel":
					if (seats.contains(reqs[1])) {
						resp = "true";
						seats.remove(reqs[1]);
					} else {
						resp = "false";
					}
					break;
				case "all":
					break;
				default:
					resp = "unknown";
				}
				oos.writeObject(resp);
				System.out.println("[server] sent response : " + resp);
			}

			server.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[server] main error : " + e.toString());
			System.out.println("[server] terminated");
		}

	}
}
