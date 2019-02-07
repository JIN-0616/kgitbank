package net.hb.day12;

import java.util.Scanner;

 class Hotel{
	 boolean[ ] motel=new boolean[5];
	 int roomsu=5;
	 String sm="호텔이름기억";
	 
	public Hotel( ) {  } //기본생성자생략가능
	public Hotel(String name) { this.sm=name; } //생성자
		
	public void input(int roomNumber) {//non-static, 입실체크 
	  if(motel[roomNumber-1]==true) {
		 System.out.println(roomNumber+"방은 다른고객이 예약하셨습니다.");  
	  }else {
	   motel[roomNumber-1]=true;
	   System.out.println(roomNumber+"방에 입실하셨습니다.");  
	  }
	}//input end
	
	public void output(int roomNumber) {//non-static, 퇴실체크 
	  if(motel[roomNumber-1]==true) { 
		  motel[roomNumber-1]=false; 
		 System.out.println(roomNumber+"방에서 퇴실 하셨습니다.");  
	  }else {
	   System.out.println(roomNumber+"방 빈방이라서 퇴실처리실패입니다.");  
	  }
	}//output end
	
	public void list( ) { //non-static, 방예약 상태 표시 
	  System.out.println("***** " + sm +  " map ***** ");
	  for(int i=0; i<roomsu; i++) {
		 if(motel[i]==true) {
		    System.out.println("  "+(i+1)+"방은 사용중입니다");;	 
		 }else {
		   System.out.println("  "+(i+1)+"방은 예약가능한 빈방입니다");;	 
		 }
	  }//for end
	  System.out.println( );
	}//list end	
 }//Hotel class END===============================================

public class TestHotel {
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  Hotel LG=new Hotel( "부다페스트호텔" );
	  TestHotel my=new TestHotel( );
	  
	  while(true) {
	   int Num=1;
	   System.out.print("\n1.입실 2.퇴실  3.map  4.종료 ? ");
	   int select=sc.nextInt();
	   if(select==1) {Num=my.user("입실", 5); LG.input(Num);}
	   else if(select==2) {Num=my.user("퇴실", 5); LG.output(Num);} 
	   else if(select==3) {LG.list( ); }
	   else if(select==4) {break;}
	  }//while end
	  
	  System.out.println("\n예약관련 프로그램종료되었습니다") ;
	}//main end	
	
	public int user( String msg, int max) { //non-static,리턴값,매개인자 2개있음 
	  Scanner sc=new Scanner(System.in);
	  int a=0;
	   do {
	     System.out.println();
	     System.out.print("  >> " + msg +" 하실방번호 입력? " );
	     a=sc.nextInt();
	   }while(a<1 || a>max);
	  return a;
	}//user end
	
}//TestHotel class END==========================================


