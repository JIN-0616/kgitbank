
import java.io.*;

public class Source20_CharInput {
	public static void main(String[] args) {
		
		// InputStreamReader ? 
		
		File t = new File("v해적왕v");
		try(
			InputStreamReader isr = new InputStreamReader(new FileInputStream(t));	
				) {
			String sum = "";
			for(int cnt=1; cnt<=3; cnt++) {
				int n = isr.read();
				System.out.println(n + " / " + (char)n + " / ");
				sum += (char)n;
			}
			
			char[] c = new char[10];
			while(true) {
				int n = isr.read(c);
				if(n == -1)
					break;
				sum += new String(c, 0, n);
			}
			System.out.println(sum);
			
		}catch(IOException e) {
			System.out.println("[시스템] Input Failed");
		}
		
	}
}
