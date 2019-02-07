class Source03_UsingTool {
	public static void main(String[] args) {
		System.out.println("developed by saan");
		System.out.println("used editplus..");
	}
}
/*
	이 소스파일을 토대로 컴파일을 진행하기 위해서는
	javac 파일명(확장자포함해서)   으로 명령을 내려야 한다.
	이 작업을 도구로 등록할수 있다.
	상단메뉴 [도구] → [사용자 도구 구성] 
		도구 하나# (ctrl+1)
		프로그램 추가 / 메뉴이름 : 컴파일
		사용프로그램 : javac.exe / 인수 : 파일이름 / 디렉터리 : 파일디렉터리

		도구 둘# (ctrl+2)
		프로그램 추가 / 메뉴이름 : 실행
		사용프로그램 : java.exe   / 인수 : 인수내용묻기 / 디렉터리 : 파일디렉터리
		▶▶▶▶▶▶▶
		인수 : 확장자를 뺀 파일 이름  로 설정하고, 
		파일명과 class 하고 뒤에 붙여서 설정한 만들어야될 것의 이름을 일치

*/