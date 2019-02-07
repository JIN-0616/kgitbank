package net.hb.day12;

import java.util.Scanner;

 class Hotel{
	 boolean[ ] motel=new boolean[5];
	 int roomsu=5;
	 String sm="ȣ���̸����";
	 
	public Hotel( ) {  } //�⺻�����ڻ�������
	public Hotel(String name) { this.sm=name; } //������
		
	public void input(int roomNumber) {//non-static, �Խ�üũ 
	  if(motel[roomNumber-1]==true) {
		 System.out.println(roomNumber+"���� �ٸ����� �����ϼ̽��ϴ�.");  
	  }else {
	   motel[roomNumber-1]=true;
	   System.out.println(roomNumber+"�濡 �Խ��ϼ̽��ϴ�.");  
	  }
	}//input end
	
	public void output(int roomNumber) {//non-static, ���üũ 
	  if(motel[roomNumber-1]==true) { 
		  motel[roomNumber-1]=false; 
		 System.out.println(roomNumber+"�濡�� ��� �ϼ̽��ϴ�.");  
	  }else {
	   System.out.println(roomNumber+"�� ����̶� ���ó�������Դϴ�.");  
	  }
	}//output end
	
	public void list( ) { //non-static, �濹�� ���� ǥ�� 
	  System.out.println("***** " + sm +  " map ***** ");
	  for(int i=0; i<roomsu; i++) {
		 if(motel[i]==true) {
		    System.out.println("  "+(i+1)+"���� ������Դϴ�");;	 
		 }else {
		   System.out.println("  "+(i+1)+"���� ���డ���� ����Դϴ�");;	 
		 }
	  }//for end
	  System.out.println( );
	}//list end	
 }//Hotel class END===============================================

public class TestHotel {
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  Hotel LG=new Hotel( "�δ��佺Ʈȣ��" );
	  TestHotel my=new TestHotel( );
	  
	  while(true) {
	   int Num=1;
	   System.out.print("\n1.�Խ� 2.���  3.map  4.���� ? ");
	   int select=sc.nextInt();
	   if(select==1) {Num=my.user("�Խ�", 5); LG.input(Num);}
	   else if(select==2) {Num=my.user("���", 5); LG.output(Num);} 
	   else if(select==3) {LG.list( ); }
	   else if(select==4) {break;}
	  }//while end
	  
	  System.out.println("\n������� ���α׷�����Ǿ����ϴ�") ;
	}//main end	
	
	public int user( String msg, int max) { //non-static,���ϰ�,�Ű����� 2������ 
	  Scanner sc=new Scanner(System.in);
	  int a=0;
	   do {
	     System.out.println();
	     System.out.print("  >> " + msg +" �Ͻǹ��ȣ �Է�? " );
	     a=sc.nextInt();
	   }while(a<1 || a>max);
	  return a;
	}//user end
	
}//TestHotel class END==========================================


