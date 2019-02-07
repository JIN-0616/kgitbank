
public class Source09_Array {
	static boolean[] makeSample(){
		boolean[] sheet = new boolean[ 5+(int)(Math.random()*10)];
		for(int idx=0;idx<sheet.length;idx++) { //모든칸을 순서대로 접근
				// == idx<=sheet.length-1;
			if(Math.random()>0.5)
				continue;
			sheet[idx] = true;
		}
		return sheet;
	}
	public static void main(String[] args) {
		// 배열객체는 데이터를 저장하는 변수에 [0],[1] 차례대로 번호를 설정해두고,
		// 그 인덱스를 통해 실제 데이터를 저장한다거나, 확인한다거나 할수 있게 되었다.
	
		boolean[] sheet = makeSample();
		System.out.println("sample ..");
		for(int idx=0;idx<sheet.length;idx++) { 		// 0 -> length-1
			System.out.println( (idx+1) + " : " +sheet[idx]);
		}		
		//System.out.println(sheet.toString()); //이걸로 일괄 확인할수 있게 구현은 불가능하다.
		System.out.println();
		
		// 배열로 데이터를 저장시켜두고, 자주 하는 작업이
		// - 특정상태를 가진 데이터 개수 확인하는 작업
		// true 개수 세고, 전체 데이터중 true 의 비중은?
		int count=0;
		for(int idx=0;idx<sheet.length;idx++) {
			if(sheet[idx])
				count++;
		}
		System.out.println("TrueCount = "+count);
		double per = (double)count/sheet.length;
		System.out.println("sheet.length = "+sheet.length);
		System.out.println("% = "+per);
		
		//#####################
		int cnt=0;
		for (int idx = 0; idx < sheet.length; idx++) {
			if(sheet[idx]) {
				cnt++;
			}
		}
		System.out.println("FIND true = "+cnt);
		double r = (double)cnt/sheet.length*100 ;  //퍼센트처리 나누고 *100
		System.out.println("TRUE data = "+r+"%");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
