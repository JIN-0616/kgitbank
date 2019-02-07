package lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Pattern_Macher {
/*
	자바 정규식 기본정리 : Matcher, Pattern, find(), group()

	정규식을 사용하면 문자열(String)이 특정 패턴과 일치하는지 여부를 확인하거나,
	패턴에 맞는 값을 찾아내거나, 해당 값을 새로운 값으로 바꿀 수 있다.

	이 방법이 일목요연하게 작성되어 있는 곳이 마땅히 보이지 않았기에 직접 정리해서 써본다.

	1. matches (일치하는지 확인)

	target 은 대상이 되는 문자열(문장)을 담는 변수이고,
	regEx는 정규식(Regular Expression) 을 담는 변수라고 해보자.
*/
	public void isEqualRegEx() {
	    String target = "나는 2008년도에 입학했다.";
	    String regEx = ".*\\d{1}.*";
	    // String regEx = ".*[0-9].*"; 와 동일함
	  
	    if (target.matches(regEx)) {
	        System.out.println("일치");	   
	    } else {
	        System.out.println("불일치");
	    }
	}
/*	
	여기서 regEx 는 ".*\\d{1}.*"; 이다.
	즉 여기서 target.matches(regEx) 는 숫자가 1개라도 포함되어 있느냐고 묻는 것이다.
	(".*" 는 모든 복수의 문자이고, "\\d{1}"는 한 자리 숫자이므로.)

	이 경우 2008, 이렇게 숫자가 4개나 있으니까 당연히 "일치"가 출력되겠지.
	만약 regEx 값이 바뀐다면 어떨까?

// ".*\\d{1}.*"
	regEx == ".*\\d{1}.*"; // -> 일치
	regEx == ".*[0-9].*" ; //-> 일치 ([0-9]는 \\d{1} 와 정확히 같은 뜻임)

	regEx == ".*[0-9][0-9][0-9][0-9].*" -> 일치 (숫자 4자리)
	regEx == ".*[0-9][0-9][0-9][0-9][0-9].*" -> 불일치 (숫자 5자리)

	regEx == ".*\\d{1,4}.*" -> 일치 (숫자 1자리 이상 4자리 이하)
	regEx == ".*\\d{2,5}.*" -> 일치 (숫자 2자리 이상 5자리 이하)
	regEx == ".*\\d{5,6}.*" -> 불일치 (숫자 5자리 이상 6자리 이하)

	요런 식으로 되겠다.

	2. replaceAll (패턴에 맞는 값을 새로운 값으로 치환)
	
*/
	public void replaceRegEx1() {
	    String target = "나는 2008년도에 입학했다.";
	    String regEx = "[0-9]";
	    Pattern pat = Pattern.compile(regEx);
	  
	    Matcher m = pat.matcher(target);
	    String result = m.replaceAll("2"); // 패턴과 일치할 경우 "2"로 변경
	     
	    System.out.println("출력 : " + result);
	    // 출력 : 나는 2222년도에 입학했다.
	}
/*
 	여기서 regEx 변수 값은 "[0-9]" 이다. 그러니까 위 소스는 1자리 숫자들을 "2"로 치환하게 된다.
	결과는 당연히 "나는 2222년도에 입학했다."가 된다.

	위 함수를 3줄로 줄이면 아래와 같다.
*/
	public void replaceRegEx() {
	    String target = "나는 2008년도에 입학했다.";
	    String regEx = "[0-9]";
	    System.out.println("출력 : " + target.replaceAll(regEx, "2"));
	}
/*
	String 객체에 replaceAll 라는 멤버함수가 있다. 이게 더 낫다.
	전자는 Pattern 객체와 Matcher 객체를 추가로 임포트하는데, 후자는 String 객체만 있으면 되니까.


	3-1. find(), group() (패턴에 맞는 값 1개씩 찾아내기)

	요 find랑 group이라는 함수가 특이한데 Matcher 의 멤버함수다.
	일단 단순무식한 코드로 배워보자.
*/
	public void findRegEx(){
	    String target = "나는 2008년도에 입학했다.";
	    String regEx = "[0-9]";

	    // 정규식(regEx)을 패턴으로 만들고,
	    Pattern pat = Pattern.compile(regEx);
	    // 패턴을 타겟 스트링(target)과 매치시킨다.
	    Matcher match = pat.matcher(target);

	    System.out.println(match.find());  // true
	    System.out.println(match.group()); // 2
	     
	    System.out.println(match.find());  // true
	    System.out.println(match.group()); // 0
	     
	    System.out.println(match.find());  // true
	    System.out.println(match.group()); // 0
	     
	    System.out.println(match.find());  // true
	    System.out.println(match.group()); // 8
	     
	    System.out.println(match.find());  // false
	    System.out.println(match.group()); // 에러 발생! (IllegalStateException)
	}
/*
	Pattern에 compile로 정규식(regEx)을 담고, Matcher에 타겟 스트링(target)을 담는게 먼저다.

	그 다음 Matcher의 find() 함수를 쓰면 1번째 값을 찾아내고, true 혹은 false를 반환한다.
	group() 을 쓰면 방금 찾은 1번째 스트링이 튀어나온다.

	다시 find()를 쓰면 2번째 값을 찾고, group()을 쓰면 2번째 값이 튀어나오고... 이런 식이다.

	보면 2, 0, 0, 8 까지 잘 가다가 (숫자가 더 이상 없으므로 당연히) 5번째에서 에러가 나는데,
	따라서 에러가 나지 않도록 코드를 쓴다면 아래와 같이 작성해야 마땅하겠다.

	...(전략)...

	    if (match.find()) {
	        System.out.println(match.group());
	    }

	...(후략)...


	3-2. find(), group() (패턴에 맞는 값 모두 찾아내기)
	3-1에서 설명한 바를 잘 정리한게 아래 메서드다.

*/
	public void findAllRegEx(){
	    String target = "나는 2008년도에 입학했다.";
	    String regEx = "[0-9]";

	    Pattern pat = Pattern.compile(regEx); 
	    Matcher match = pat.matcher(target);
	     
	    int matchCount = 0;
	    while (match.find()) {
	        System.out.println(matchCount + " : " + match.group());
	        matchCount++;
	    }
	    System.out.println("총 개수 : " + matchCount);
	     
	    // 0 : 2
	    // 1 : 0
	    // 2 : 0
	    // 3 : 8
	    // 총 개수 : 4
	}

//	보시다시피 while문을 사용해 find()가 false가 될 때까지 루프를 돌리면 된다.


}
