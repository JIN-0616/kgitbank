import java.util.Scanner;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class QuizMaker extends Thread {
	String num;

	QuizMaker(String n) {
		this.num = n;
	}

	public void run() {
		int n = Integer.parseInt(num);
		String name = getName();
		for (int cnt = 1; cnt <= 3; cnt++) {
			String in = JOptionPane.showInputDialog(new JFrame(), name + "\n������ ���� : " + n + "\n�������� �˰� ����?");
			
			double rst = Math.pow(n, Integer.parseInt(in));
			JOptionPane.showMessageDialog(new JFrame(), name+"\n"+n+"�� "+in+" ������ " + rst +" ��.");
		}

	}

}

public class Excersice03_Thread {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		for (;;) {
			System.out.println("�����Է�");
			String str = cin.nextLine();
			System.out.println("[Thread-Main] �Էµȼ��� : " + str);
			Thread t = new QuizMaker(str);
			t.start();
		}

	}
}
