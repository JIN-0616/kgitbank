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
			System.out.println("===== [쉐리톤워커힐 투숙 상태] =====");
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
			System.out.print("1.투숙 2.퇴실 3.map 4.종료? ");
			String q1 = sc.nextLine();
			if(q1==null) {
				continue;
			}else if(Integer.valueOf(q1) != null) {
				if(1<=Integer.valueOf(q1) && 4>=Integer.valueOf(q1)) {
					switch(q1){
					case "1":
						System.out.print(">몇층에 투숙? ");
						String q2 = sc.nextLine();
						System.out.print(">몇호에 투숙? ");
						String q3 = sc.nextLine();						
						if (q2 != null && q3 !=null) {
							int a = Integer.valueOf(q2);
							int b = Integer.valueOf(q3);
							if((1<=a && 3>=a) && 1<=b && 5>=b) {
								if(room[a-1][b-1].equals("")) {
									System.out.println(">투숙객 이름?");
									String n = sc.nextLine();
									room[a-1][b-1] = n;
									System.out.println("성공적으로 cheakIn 되었습니다.");
									System.out.println();
									continue;
								}else {
									System.out.println("투숙객이 있습니다.");
									System.out.println();
									continue;
								}								
							}else {
								System.out.println("지정된 층호수를 입력하시오");
								System.out.println();
								continue;
							}
						}						
						break;
					case "2":
						System.out.print(">몇층에 퇴실? ");
						String b2 = sc.nextLine();
						System.out.print(">몇호에 퇴실? ");
						String b3 = sc.nextLine();						
						if (b2 != null && b3 !=null) {
							int a = Integer.valueOf(b2);
							int b = Integer.valueOf(b3);
							if((1<=a && 3>=a) && 1<=b && 5>=b) {
								if(!room[a-1][b-1].equals("")) {
									room[a-1][b-1] = "";
									System.out.println(">성공적으로 CheakOut되었습니다.");
									System.out.println();
									continue;
								}else {									
									System.out.println(">비어있는 방입니다.");
									System.out.println();
									continue;
								}								
							}else {
								System.out.println("지정된 층호수를 입력하시오");
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
					System.out.println(">다시 입력");
					continue;
				}
				
			}
				
		}
	}

	public static void main(String[] args) {
		// 101 - 105 , 301 - 305 [쉐리톤워커힐투숙 상태]
		// 1.투숙, 2.퇴실, 3.map, 4.종료?
		// >몇층에 투숙?
		// >몇호에 투숙?
		// # 이미 투숙중인 방입니다.
		// # 성공적으로 checkIn 되었습니다.
		Hotel h = new Hotel();
		

	}
	
	
	
}
