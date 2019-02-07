package Text;
/*
	2. SimpleDataFormat
	
	SimpleDataFormat df = new SimpleDataFormat("a hh:mm");
	String strData = df.format(new Data());
	
	SimpleDataFormat�� Data �ν��Ͻ��� String format���� �ٲ��ش�.
	
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
	
	* SimpleDataFormat : ��¥ (Date,calendar) ǥ�����
	 
	 y : ��		M : ��		d : ��		W : ��->��°��		w : �̹���->��°��		E : ����
	 
	 H : ��(24) h : ��(12)	m : ��		s : ��		S : 1/1000��		a : am/pm
*/
import java.text.*;
import java.util.*;
public class Chap14_2_SimpleDataFormat {
	public static void main(String[] args) {
		
		Date today = new Date();	// �ý����� ���� ��¥
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
		E ==> ��
		EEEE ==> ������
		h ==> 4
		hh ==> 04
		H ==> 4
		HH ==> 04
		m ==> 51
		mm ==> 51
		s ==> 49
		ss ==> 49
		S ==> 396
		a ==> ����
		*/
		
		Date mydate = new Date();	// �ý����� ���ó�¥
		sdf = new SimpleDateFormat("yyyy-MM-dd");
			//����� ����
		
		//mydate.setYear(12); -----> ���� �⵵�� �Է��� ��� �����⵵���� 1900�� ���� ����
		
		String mystr = "1985-03-20";
		
		try {
			mydate = sdf.parse(mystr);		//�ݵ�� ����ó���� �ʿ�� �Ѵ�
			// SimpleDateFormat�� parse�� �̿��Ͽ� ���� �Է°���
			// �Էº�
		} catch (ParseException e) {
			System.out.println("��¥���Ŀ� �����ּ���");
		}
		
		System.out.println(sdf.format(mydate));
		// ����� ������ ������� �ս��� ����
		// ��º�
		
		Calendar mycal = Calendar.getInstance();
		// Calendar <-------- Date
		System.out.println(mycal.get(Calendar.YEAR));	//2018
		
		mycal.add(Calendar.DATE, 20);	//��¥ ����
		System.out.println(mycal.get(Calendar.DATE));	//20
		
		mydate = mycal.getTime();
		// Date <---------- Calendar
		System.out.println(sdf.format(mydate));	//2018-11-20
		
	}
}
