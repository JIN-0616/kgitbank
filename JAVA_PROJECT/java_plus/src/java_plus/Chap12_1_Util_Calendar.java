package java_plus;

import java.util.Calendar;

/*
	1.Calendar
	Calendar 클래스도 Date클래스처럼 날짜와 시간에 관한 정보를 표현할 때 사용한다.
	(Calendar 클래스를 Date클래스보다 더 권장)
	※Calendar 클래스는 추상 클래스로 생성자를 제공하지 않는다.
	 -따라서 Calendar 클래스의 객체를 생성하기 위해 new 연산자를 사용할 수 없다.
	 -추상 클래스이므로 객체를 직접 생성할 수 없지만,
	  getInstance() 메서드를 이용하여 시스템의 날짜와 시간의 객체를 얻어올 수 있다.
	
	int get(int field)
	  //날짜에서 표현할 수 있는 값은 다 상수값으로 제공
	  //calendar 클래스는 날짜와 시간 표현을 위해 다양한 상수를 제공하고 있다.
	
	Calendar class
	1970년 1월 1일부터 특정 값으로 진보해 오면서 날짜와 시각에 대한 조작을 수행할 수 있도록 제공되는
	abstract class 이다.	
*/
public class Chap12_1_Util_Calendar {
	public static void main(String[] args) {
		/*
		Calendar today = Calendar.getInstance(); // 오늘 날자를 받음
	//	get(날짜필드)--필드 값을 int로 받아옴
	//	Calendar.YEAR.....-날짜필드(년도, 월, 일..)
		
		//날짜
		System.out.println("년도"+today.get(Calendar.YEAR));
		System.out.println("월"+today.get(Calendar.MONTH));
		//Calendar.MONTH
		// *실제 월 1 2 3 4 5 6 7 8 9 10 11 12
		// *표기 월 0 1 2 3 4 5 6 7 8 9  10 11
		
		System.out.println("일"+today.get(Calendar.DATE));
		System.out.println("요일"+today.get(Calendar.DAY_OF_WEEK));
		//이번주 들어 몇번째 날
		//Calendar.DAY_OF_WEEK
			// 일 월 화 수 목 금 토
			// 1  2  3  4  5  6  7
		System.out.println("올해 현재 일수"+today.get(Calendar.DAY_OF_YEAR));
		
		//시간
		System.out.println("12시간"+today.get(Calendar.HOUR)); //12시간
		System.out.println("24시간"+today.get(Calendar.HOUR_OF_DAY)); //24시간
		System.out.println("분"+today.get(Calendar.MINUTE));
		System.out.println("초"+today.get(Calendar.SECOND));
		System.out.println("1/1000초"+today.get(Calendar.MILLISECOND));
		System.out.println("am/pm"+today.get(Calendar.AM_PM)); //오전=0,오후=1
		
		//set(년,월,일)
		//set(날짜필드,int) - 날짜 값을 지정함(달의 자료형에 유의)
		
		//getTimeInMillis() - 날짜에 해당하는 long return
		//setTimeInMillis(long) - long을 인수로 날짜형태로 계산
		//						- 값은 1/1000초 : 하루 1000*60*69*24
		//						- 1970-1-1을 기준으로 날짜 시작
		
	//	System.out.println(myday.before(today)); //myday가 today 이전인지
	//	System.out.println(myday.after(today));  //myday가 today 이후인지
		*/
		//=====================================================================
		
		Calendar today = Calendar.getInstance();
		// 지금의 날짜, 시간 값을 받아온다.
		System.out.println(today);
		Calendar myday = Calendar.getInstance();
		myday.set(1985,3,15); //1985-3-15
		//myday.set(Calenday.YEAR, 2012); //날짜필드, 값
		
		System.out.println(today.get(Calendar.YEAR));
		myday.get((Calendar.YEAR)+1);
		
		//System.out.println(today-myday); //바로 계산 불가
		//gettimemillis()
		System.out.println(today.getTimeInMillis());
		long mylong = myday.getTimeInMillis();
		Calendar myday2 = Calendar.getInstance();
		System.out.println("mylong"+mylong);
		myday2.setTimeInMillis(mylong);
		System.out.println("my2년도"+myday2.get(Calendar.YEAR));
		long day_between = today.getTimeInMillis() - myday.getTimeInMillis();
		// 1000*60*60*24
		System.out.println("today-myday="+(day_between/(1000*60*60*24)/365));
		// 1970-1-1을 기준으로 날짜시작
		
		//---------------------------------------------------------------------
		// 날짜
		System.out.println("년도 "+today.get(Calendar.YEAR));
		System.out.println("월 "+today.get(Calendar.MONTH));
					//Calendar.MONTH
			// 실제 월 1 2 3 4 5 6 7 8 9 10 11 12
			// 표기 월 0 1 2 3 4 5 6 7 8  9 10 11
		
		System.out.println("일 "+today.get(Calendar.DATE));
		System.out.println("요일 "+today.get(Calendar.DAY_OF_WEEK));
		// 이번주 들어 몇번째 날
					// Calendar.DAY_OF_WEEK
					// 일 월 화 수 목 금 토
					// 1  2  3  4  5  6  7
		System.out.println("올해 현재 일수 "+today.get(Calendar.DAY_OF_YEAR));
		
		//---------------------------------------------------------------------
		// 시간
		System.out.println("12시간 " + today.get(Calendar.HOUR));
		System.out.println("24시간 " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 " + today.get(Calendar.MINUTE));
		System.out.println("초 " + today.get(Calendar.SECOND));
		System.out.println("1/1000초 " + today.get(Calendar.MILLISECOND));
		System.out.println("오전/오후 " + today.get(Calendar.AM_PM)); //오전=0,오후=1
		
		// 생일이 얼마나 남았는지 계산
		myday.set(Calendar.YEAR, today.get(Calendar.YEAR));
		
		if(today.getTimeInMillis()>myday.getTimeInMillis()) {
			//올해 생일이 지났는지
			myday.set(Calendar.YEAR, today.get(Calendar.YEAR)+1);
			//지났다면 생일을 내년으로 바꿈
		}
		System.out.println("오늘 : "+print(today));
		System.out.println("도래할 생일 : "+print(myday));
		long dday = myday.getTimeInMillis()-today.getTimeInMillis();
		System.out.println("d- "+dday/(1000*60*60*24));
		
	}
	static String print(Calendar cc) {
		return cc.get(Calendar.YEAR)+"-"+(cc.get(Calendar.MONTH)+1)+"-"+cc.get(Calendar.DATE);
	}
}
