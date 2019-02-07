/*
 * I/O (Input,Output) 작업에 사용되는 객체에 대해서 알아보자.
 * 
 *  Input (입력) 은 프로그램에 필요한 데이터를 확보하는(읽어들이는) 작업을 의미하고,
 * 	Output(출력) 은 프로그램에 발생한 데이터를 내보내는(써내려가는) 작업을 의미한다. 
 *  
 *  이때까지 입,출력 작업을 안해본건 아니다. 
 *  	System.console().readLine() 혹은, Scanner 객체를 이용한 nextLine() 같은
 *   기능을 이용해서 cmd 창에서의 입력, 
 *   그리고 JOptionPane, TextField같은객체를 이용해서 GUI 환경에서도 데이터를 입력받아 
 *   확보를 해서 사용해왔다. 
 *   	출력 역시, System.out.println() 같은걸 이용해서 cmd창에 출력이나, 
 *   GUI 환경에서도 데이터를 출력도 처리해보았다.
 *   
 *     이런 작업을 데이터 입출력이라고 부르는데,
 *    IO 객체를 좀더 공부하면 파일이나, 네트워크를 이용한 데이터 입출력도 가능해진다.
 *     
 *  파일을 대상으로 입출력객체를 다루는 법을 익히면, 세이브,로드 를 구현할수 있게 되고,
 *  네트워크망을 이용한 입출력객체를 다루는 법을 익히면, 클라이언트-서버 방식의 프로그램을
 *  구현할수 있게 된다.    
 *	
 *	일단은 파일을 대상으로 한 입출력부터 살펴보자.  
 */
import java.io.*;

public class Source07_Ouput {
	public static void main(String[] args) {
		// 파일에 데이터를 내보내는(출력) 작업을 하고자 할때는, FileOutputStream 객체를
		// 이미 있는 파일로부터 데이터를 읽어내는(입력)작업을 할때는 FileInputStream 객체를 사용
		// 하면 된다. Exception Handle 이 거의 필수적으로 일어나게 된다.

		
		// File객체 혹은 String 으로 출력하고자 하는 대상 파일을 설정.
			// (cf. String 으로 설정시 내부에서 File 객체로 처리함 / File 객체 사용은 잠시 보류.)
		try {
			FileOutputStream fos = new FileOutputStream("output.data");	
			// 대상파일을 만들어서 출력 준비를 함. 기존에 파일이 있던 없던 새롭게 타겟파일을 만듬.
			fos.write(45);	// 데이터를 내보내고,
			fos.write(145);	// 데이터를 내보내고,
			// 의미있는 데이터(사람이름, 승수, 현재 레벨 기타등등)를 출력을 하고자
			// 이상태로는 출력이 힘들고 다른 객체를 사용해야 한다.
			fos.close();	// 작업이 끝나면, 파일과 출력을 하기 위해서 시스템으로 연결되어있는 걸 해제
			System.out.println("try success");
			
			
		}catch(FileNotFoundException e) {
			// 출력 할수없는 대상을 지정할때 발생.
			System.out.println("fail .." + e.toString());
		}catch(IOException e) {
			System.out.println("fail .." + e.toString());
		}
	}
}









