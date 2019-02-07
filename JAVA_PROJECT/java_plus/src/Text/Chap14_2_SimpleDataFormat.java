package Text;
/*
	2. SimpleDataFormat
	
	SimpleDataFormat df = new SimpleDataFormat("a hh:mm");
	String strData = df.format(new Data());
	
	SimpleDataFormat은 Data 인스턴스를 String format으로 바꿔준다.
	
	-------------------------------------------------------------------------------------------------
	Letter		Date of Time Component		Presentation		Examples
	-------------------------------------------------------------------------------------------------
	G			Era designator				Text				AD
	y			Year						Year                1996; 96      
	M			Month in year	            month				July; Jul; 07
	w			Week in year	            Number				27
	W           Week in month               Number            	2
	D           Day in year                 Number          	189
	d           Day in month                Number           	10
	F           Day in week in month        Number              2     
	E           Day in week                 Text          		Tuesday; Tue
	a           Am/Pm marker                Text           		PM
	H           Hour in day (0-23)          Number              0   
	k           Hour in day (1-24)          Number              24   
	K           Hour in am/pm (0-11)        Number              0     
	h           Hour in am/pm (1-12)        Number              12     
	m           Minute in hour              Number             	30
	s           Second in minute            Number              55 
	S           Millisecond                 Number         		978	 
	z           Time zone                   General time zone   Pacific Standard Time; PST; GMT-08:00     
	Z           Time zone                   RFC 822 time zone   -0800     
	-------------------------------------------------------------------------------------------------
	
	* SimpleDataFormat : 날짜 (Date,calendar) 표현방식
	 
	 y : 년		M : 월		d : 일		W : 달->몇째주		w : 이번해->몇째주		E : 요일
	 
	 H : 시(24) h : 시(12)	m : 분		s : 초		S : 1/1000초		a : am/pm
*/
import java.text.*;
import java.util.*;
public class Chap14_2_SimpleDataFormat {
	public static void main(String[] args) {
		
		Date today = new Date();	// 시스템의 오늘 날짜
		System.out.println(today);	// Wed Oct 31 04:51:49 KST 2018
		
		String[] sd_str = {"y","yyyy","M","MM","d","dd","W","w","E","EEEE","h","hh","H","HH","m","mm","s","ss","S","a"};
		
		SimpleDateFormat sdf;
		for (int i = 0; i < sd_str.length; i++) {
			sdf = new SimpleDateFormat(sd_str[i]);
			System.out.println(sd_str[i] + " ==> "+sdf.format(today));			
		}
		/*
		Wed Oct 31 04:51:49 KST 2018
		y ==> 2018
		yyyy ==> 2018
		M ==> 10
		MM ==> 10
		d ==> 31
		dd ==> 31
		W ==> 5
		w ==> 44
		E ==> 수
		EEEE ==> 수요일
		h ==> 4
		hh ==> 04
		H ==> 4
		HH ==> 04
		m ==> 51
		mm ==> 51
		s ==> 49
		ss ==> 49
		S ==> 396
		a ==> 오전
		*/
		
		Date mydate = new Date();	// 시스템의 오늘날짜
		sdf = new SimpleDateFormat("yyyy-MM-dd");
			//입출력 형식
		
		//mydate.setYear(12); -----> 직접 년도를 입력할 경우 기존년도에서 1900을 빼서 기재
		
		String mystr = "1985-03-20";
		
		try {
			mydate = sdf.parse(mystr);		//반드시 예외처리를 필요로 한다
			// SimpleDateFormat의 parse를 이용하여 쉽게 입력가능
			// 입력부
		} catch (ParseException e) {
			System.out.println("날짜형식에 맞춰주세요");
		}
		
		System.out.println(sdf.format(mydate));
		// 출력을 정해진 방식으로 손쉽게 가능
		// 출력부
		
		Calendar mycal = Calendar.getInstance();
		// Calendar <-------- Date
		System.out.println(mycal.get(Calendar.YEAR));	//2018
		
		mycal.add(Calendar.DATE, 20);	//날짜 연산
		System.out.println(mycal.get(Calendar.DATE));	//20
		
		mydate = mycal.getTime();
		// Date <---------- Calendar
		System.out.println(sdf.format(mydate));	//2018-11-20
		
	}
}
