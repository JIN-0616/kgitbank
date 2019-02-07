package test01;

import java.util.Scanner;

public class Hotel {
	Scanner sc;
	boolean flag;
	String[][] name;
	String[][] room;
	
	public Hotel() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		String[][] name = new String[3][5];
		String[][] room = new String[3][5];
		
		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < name[i].length; j++) {
				name[i][j] = String.valueOf((i+1)*100+(j+1));
			}
		}
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				room[i][j] = "";
			}
		}
		
		while(flag) {
			System.out.println();
			System.out.println("===== [�������Ŀ�� ���� ����] =====");
			for (int i = 0; i < name.length; i++) {
				for (int j = 0; j < name[i].length; j++) {
					System.out.print(name[i][j]+"	");					
				}
				System.out.println();
				for (int j = 0; j < room[i].length; j++) {
					System.out.print(room[i][j]+"	");
				}
				System.out.println();
				System.out.println("--------------------------------------");
			}
			System.out.print("1.���� 2.��� 3.map 4.����? ");
			String q1 = sc.nextLine();
			if(q1==null) {
				continue;
			}else if(Integer.valueOf(q1) != null) {
				if(1<=Integer.valueOf(q1) && 4>=Integer.valueOf(q1)) {
					switch(q1){
					case "1":
						System.out.print(">������ ����? ");
						String q2 = sc.nextLine();
						System.out.print(">��ȣ�� ����? ");
						String q3 = sc.nextLine();						
						if (q2 != null && q3 !=null) {
							int a = Integer.valueOf(q2);
							int b = Integer.valueOf(q3);
							if((1<=a && 3>=a) && 1<=b && 5>=b) {
								if(room[a-1][b-1].equals("")) {
									System.out.println(">������ �̸�?");
									String n = sc.nextLine();
									room[a-1][b-1] = n;
									System.out.println("���������� cheakIn �Ǿ����ϴ�.");
									System.out.println();
									continue;
								}else {
									System.out.println("�������� �ֽ��ϴ�.");
									System.out.println();
									continue;
								}								
							}else {
								System.out.println("������ ��ȣ���� �Է��Ͻÿ�");
								System.out.println();
								continue;
							}
						}						
						break;
					case "2":
						System.out.print(">������ ���? ");
						String b2 = sc.nextLine();
						System.out.print(">��ȣ�� ���? ");
						String b3 = sc.nextLine();						
						if (b2 != null && b3 !=null) {
							int a = Integer.valueOf(b2);
							int b = Integer.valueOf(b3);
							if((1<=a && 3>=a) && 1<=b && 5>=b) {
								if(!room[a-1][b-1].equals("")) {
									room[a-1][b-1] = "";
									System.out.println(">���������� CheakOut�Ǿ����ϴ�.");
									System.out.println();
									continue;
								}else {									
									System.out.println(">����ִ� ���Դϴ�.");
									System.out.println();
									continue;
								}								
							}else {
								System.out.println("������ ��ȣ���� �Է��Ͻÿ�");
								System.out.println();
								continue;
							}
						}
						break;
					case "3":						
						break;
					case "4":
						flag = false;
						System.out.println(">System Exit");
						break;
					}
				}else {
					System.out.println(">�ٽ� �Է�");
					continue;
				}
				
			}
				
		}
	}

	public static void main(String[] args) {
		// 101 - 105 , 301 - 305 [�������Ŀ������ ����]
		// 1.����, 2.���, 3.map, 4.����?
		// >������ ����?
		// >��ȣ�� ����?
		// # �̹� �������� ���Դϴ�.
		// # ���������� checkIn �Ǿ����ϴ�.
		Hotel h = new Hotel();
		

	}
	
	
	
}
