
/*
 *  I/O : (Input, Output) 작섭시 사용하는 객체에 대해서 알아보자.
 *  
 *  Input (입력) 은 프로그램에 필요한 데이터를 확보하는(읽어들이는) 작업을 의미하고,
 *  Output(출력) 은 프로그램에 발생한 데이터를 내보내는(써 내보내는) 작업을 의미한다.
 *   
 *  이때가지 입,출력 작업을 안해본건 아니다. 
 *    -입력은 System.console().readLine() 혹은  new Scanner(System.in) 객체 생성해서
 *   nextLine() 같은 기능을 cmd 창에서의 입력이나, JOptionPane, TextField같은 객체를 이용해서
 *   GUI 환경에서도 데이터를 입력받아 확보를 해서 사용해왔다.
 *    -출력 역시, System.out.println() 같은걸 이용해서 cmd창에 출력이나, GUI 환경에서도 
 *   데이터를 출력도 처리해보았다. 
 *   
 *   이런 작업을 데이터 입출력이라고 부르는데,
 *    IO 객체를 좀더 공부하면 파일이나, 네트워크를 이용한 데이터 입출력도 가능해진다.
 *    
 *   파일을 대상으로 한 입출력객체를 다루는 법을 익히면, 세이브, 로드 를 구현할수 있게 되고,
 *   네트워크망을 이용한 입출력객체를 다루는 법을 익히면, 클라이언트-서버 방식의 프로그램을
 *   구현할수 있게 한다.
 *   
 *   	파일입출력 -> 프로그램 상태와 관계없이(구동여부관계없이) 데이터 보존이 가능
 *   
 *   일단 파일을 대상으로 한 입출력부터 살펴보자.
 */
import java.io.*;
public class Source07_Output {
	public static void main(String[] args) {
		// 파일에 데이터를 내보내는(출력) 작업을 하고자 할때는, FileOutputStream 객체를
		// 이미 있는 파일로부터 데이터를 읽어내는(입력)작업을 할때는,FileInputStream 객체를 사용
		// Exception Handle이 거의 필수적으로 일어나게 된다.
		
		// File객체 혹은 String 으로 출력하고자 하는 대상 파일을 설정
			//cf) String 으로 설정시 내부에서 File객체로
		
		try {			//default - workspace기준, 드라이브표기 c:\\(2개) 경로마다 \\ 2개로표기
			FileOutputStream fos = new FileOutputStream("output.data");
			// 대상파일을 만들어서 출력 준비를 함, 파일경로명, String은 자동변환
			// 기존파일 존재여부 상관없이 새롭게 타겟파일을 설정(덮어씌움)하여 생성 (0바이트)
			fos.write(45); 	// IOException, 데이터를 내보내고,
			fos.write(145);	// 45-->16진수 2D , 메모장의 경우 byte값을 문자열로 인식
							// 출력물 2진데이터 (byte출력)
			
			//fos.write(byte[]); //바이트배열 전체 혹은 일부
			
			// 의미있는 데이터(사람이름, 승수, 현재 레벨 기타 등등)을 출력하고자 할때는
			// 이 상태로는 출력이 힘들고 다른 객체를 사용해야 한다.
			
			fos.close();
			// 작업이 끝나면, 파일과 출력을 하기 위해서 시스템적으로 연결되어있는 걸 해제
			System.out.println("try success");			
			
		} catch (FileNotFoundException e) {
			// 출력할수 없는 대상을 지정할때 발생, 폴더는 파일로 덮어씌울수 없음
			// 파일 출력 권한이 없거나, 접근권한이 없을때 발생
			System.out.println("fail..."+e.toString());
		} catch (IOException e) {
			System.out.println("fail..."+e.toString());

		}

	}
}
