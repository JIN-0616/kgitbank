import javax.swing.JDialog;

/*
 * ����ó���� �ʿ��� �� Thread �� �����ϴ� ��
 * 
 *  1. extends Thread
 *  2. implements Runnable
 *  3. anonymous class (�͸�Ŭ����)
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
		Thread tt = new Thread() { //�Ϲ�Ŭ������ �ٷ� �����ϸ鼭 ��������			
			@Override
			public void run() {
				for (int cnt = 1; cnt <=100; cnt++) {
					System.out.println("1111");
				}
			}
		}; //�����ؼ� ���� ������
		tt.start();
		
		//---------------------------------------------
		new Thread(new Runnable() {//�͸� �޼ҵ�
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}); //��ȣó�� �����Ұ�
		
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
