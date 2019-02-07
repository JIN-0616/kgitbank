import javax.swing.JDialog;

/*
 * 병행처리가 필요할 때 Thread 를 설계하는 법
 * 
 *  1. extends Thread
 *  2. implements Runnable
 *  3. anonymous class (익명클래스)
 */

class Terror implements Runnable{
	String t;
	Terror(String t){
		this.t=t;
	}
	@Override
	public void run() {
		for (int cnt = 1; cnt <=10; cnt++) {
			JDialog d = new JDialog();
				d.setTitle(t);
				int s = 100 + (int)(Math.random()*200);
				int x = 0 +(int)(Math.random()*1000);
				d.setSize(s, s);
				d.setLocation(x, x);
				d.setVisible(true);
		}
	}	
}

public class Source03_Thread {
	public static void main(String[] args) {
		Terror r = new Terror("T E R R O R"); // Runnable
		Thread t = new Thread(r);
		t.start();
		//---------------------------------------------
		Thread tt = new Thread() { //일반클래스도 바로 구현하면서 생성가능			
			@Override
			public void run() {
				for (int cnt = 1; cnt <=100; cnt++) {
					System.out.println("1111");
				}
			}
		}; //설계해서 쓰고 버리기
		tt.start();
		
		//---------------------------------------------
		new Thread(new Runnable() {//익명 메소드
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}); //괄호처리 주의할것
		
		//---------------------------------------------
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		}.start();
		
		
		
	}
}
