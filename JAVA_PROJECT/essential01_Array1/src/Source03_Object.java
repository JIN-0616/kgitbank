/*
 *  java.lang.Object 객체는?
 *  	특별히 extends를 설정하지 않으면 자동으로 설정되게 되어 있다.
 *  
 *  자바에서 사용되는 모든 객체들의 상위로 직접적이던, 간접적으로던 설정이 되게 되있다.
 *  
 *  java.lang.Object 에서 설계된 기능들을 무조건 가질수 밖에 없다.
 */
class Sword{ //[extends Object]
	int atk;
	
	Sword(){
		super(); // 한단계 위 객체의 생성자 호출을 직접 기술
		atk = 30;
	}
	
	boolean enchant() {
		if(Math.random()>0.8) {
			atk += 5;
			return true;
		}else {
			return false;
		}
	}
	//원본이 public --> public, 필수는 아니나 해두면 유용함
	public String toString() {
		return "Sword[ATK="+atk+"]";
	}
}


//--------------------------------------------------------------
public class Source03_Object {
	public static void main(String[] args) {
		Sword s = new Sword();
		boolean b = s.enchant();	//설계할때 만들어둔건 이거
		System.out.println("b.. "+b);
		System.out.println(s.atk);
		
		String str = s.toString(); 		//안만든거 같은데?
		System.out.println("str = "+str);
		int c = s.hashCode();		//왜 있는거지?
		System.out.println("c = "+c);
		Sword s2 = s;
		System.out.println("equals? "+s.equals(s2)); //이건 또 뭐야?
		
		/*
		 * 객체라면 어쩔수없이 가지게되는 Object로 받은 기능은
		 * 객체 설꼐 맞춰서 꼭 변경을 해둬야되는건 아니지만, 해두는 편이 좋다.
		 * 
		 *  1. public String toString()
		 *    - 객체 상태를 문자열로 리턴시키게 재설정(오버라이드)
		 *    - (default)객체명@객체해시코드16진 한 값이 만들어지게 되있음
		 *    
		 *     public String toString() {
        		return getClass().getName() + "@" + Integer.toHexString(hashCode());
       			}
		 */
		
		Object ob = new Sword();	// 실객체를 Object를 받아서 제어하면
		// ob.enchant();	//이렇게 실제로 객체를 설계하면서 만든건 콜이 안되지만
		String obs = ob.toString(); // 원래 있는건 콜이 되고, 그게 개조되어있었다면?
		System.out.println(obs);
		//이 원리가 응용되서, System.out.println 이나, 그와 유사한 기능의 객체들이
		
		Sword s3 = new Sword();
		System.out.println(s3);		//객체 사용시 자동으로 콜이되서 사용되는 상황이 있다.
		
		System.out.println(); //객체값을 출력하려할때 toString내용을 받아서 리턴함
		
		/*
		 *  b.. false
			30
			str = Sword@6d06d69c //
			c = 1829164700
			equals? true
			
			
			b.. false
			30
			str = Sword[ATK=30]  //
			c = 1829164700
			equals? true
			
		 */	

	}
	

	
}
