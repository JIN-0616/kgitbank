import java.util.Scanner;

public class Case_RSP_Game {
	public static void main(String[] args) 	{
		Scanner cin = new Scanner(System.in);
		boolean attack = Math.random()>0.5;
		System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);
		System.out.print("이번턴의 선택(묵:0, 찌:1, 빠:2) : ");
		int choice = Integer.valueOf(cin.nextLine());
		//==================================================================
		int auto = (int)(Math.random()*3); // 0, 1, 2
		System.out.println("\n===========");
		//System.out.println("AI의 선택 : " + auto);
		System.out.print("나의 선택 : ");
		// String [] mode = new String[] {"묵","찌","빠"};		
		switch(choice) {
		case 0:System.out.println("묵"); break;
		case 1:System.out.println("찌"); break;
		case 2:System.out.println("빠"); break;
		}
		System.out.print("AI의 선택 : ");
		switch(auto) {
		case 0:System.out.println("묵"); break;
		case 1:System.out.println("찌"); break;
		case 2:System.out.println("빠"); break;
		}
		System.out.println("===========");

		if(choice == auto){
			System.out.println("승부가 났다!");
			if (attack = true){
				System.out.println("공격자 '나'의 승리!, AI의 패배!");
			}else{
				System.out.println("수비자 '나'의 패배!, AI의 승리!");
			}
		}else{
			System.out.println("승부가 나지 않았다.");
			if( choice==0 && auto==2|| choice==1 && auto==0|| choice==2 && auto==1 ) {
				if(attack == true) { 
					attack = !attack ;
					System.out.println("공격권이 바뀌었다.");
					System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);
				}else 
					System.out.println("공격권이 바뀌지 않았다.");	
			}else if( choice==0 && auto==1 || choice==1 && auto==2 || choice==2 && auto==0  ){
				if(attack == false) {
					System.out.println("공격권이 바뀌었다.");
					attack = !attack;
					System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);
				}else 
					System.out.println("공격권이 바뀌지 않았다.");					
			}else {
				System.out.println("공격권이 바뀌지 않았다.");
				System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);

		
			}
		}						
	}
}