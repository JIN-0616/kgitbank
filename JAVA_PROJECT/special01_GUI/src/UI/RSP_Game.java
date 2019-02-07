package UI;

import java.util.Scanner;

public class RSP_Game {
	int choice;
	int auto;
	boolean attack;
	boolean isRun;

	void start() {		
		isRun = true;
		attack = Math.random()>0.5;
	}
	
	int[] input() {
		//System.out.println("AI의 선택 : " + auto);
		//System.out.print("나의 선택 : ");
		// String [] mode = new String[] {"묵","찌","빠"};		
//		switch(choice) {
//		case 0:System.out.println("묵"); break;
//		case 1:System.out.println("찌"); break;
//		case 2:System.out.println("빠"); break;
//		}
//		System.out.print("AI의 선택 : ");
//		switch(auto) {
//		case 0:System.out.println("묵"); break;
//		case 1:System.out.println("찌"); break;
//		case 2:System.out.println("빠"); break;
//		}		
		auto = (int)(Math.random()*3);
		int [] rst = {choice, auto}; 
		return rst;
		
	}
	String tell() {
		String str;
		if(choice == auto){
			str = "승부가 났다! \n";
			if (attack){
				str +="공격자 '나'의 승리!, AI의 패배!\n";
				isRun = false;
			}else{
				str +="수비자 '나'의 패배!, AI의 승리!\n";
				isRun = false;
			}
		}else{			
			str = "승부가 나지 않았다.\n";
			if( choice==0 && auto==2|| choice==1 && auto==0|| choice==2 && auto==1 ) {
				if(attack == true) { 
					attack = !attack ;
					str +="공격권이 바뀌었다. \n";
				}else 
					str +="공격권이 바뀌지 않았다.\n";	
			}else if( choice==0 && auto==1 || choice==1 && auto==2 || choice==2 && auto==0  ){
				if(attack == false) {
					str +="공격권이 바뀌었다.\n";
					attack = !attack;
				}else 
					str +="공격권이 바뀌지 않았다.\n";					
			}else {
				str +="공격권이 바뀌지 않았다.\n";	
			}
		}
		return str;
	

	}	
}