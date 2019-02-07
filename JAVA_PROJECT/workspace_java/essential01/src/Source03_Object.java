/*
 *	java.lang.Object 객체는..? 
 * 		특별히 extends를 설정하지 않으면 자동으로 설정되게 되 있다.
 * 	자바에서 사용되는 모든 객체들의 상위로 직접적이던, 간접적으로던 설정이 되게 되있다.
 *  java.lang.Object 에 설계된 기능들은 무조건 가질수 밖에 없다.  
 */
class Sword  {
	int atk;
	Sword() {
		super();	// 한단계 위(?) 객체의 생성자 호출 ??
		atk = 30;
	}
	boolean enchant() {
		if(Math.random() >0.66) {
			atk += 5;
			return true;
		}else {
			return false;
		}
	}
	public String toString() {
		return "Sword[ATK="+atk+"]";
	}
}
//────────────────────────────
public class Source03_Object {
	public static void main(String[] args) {
		Sword s = new Sword();
		boolean b = s.enchant();	// 이건 설계할때 만들어둔거고..
		System.out.println("b.."+ b );
		System.out.println(s.atk);
		
		String str = s.toString();	// 안만든거 같은데..?
		System.out.println("str =" + str);
		int c = s.hashCode();	// 왜 있는거지..?
		System.out.println("c =" + c);
		Sword s2 = s;
		System.out.println("equals? " + s.equals(s2) );	// 이건 또 머야..?
		/*
		 * 객체라면 어쩔수 없이 가지게되는 Object로 받은 기능은 
		 * 객체 설계에 맞춰서 꼭 변경을 해둬야되는건 아니지만, 해두는 편이 좋다.
		 * 
		 *  1. public String toString() : 
		 *  	객체 상태를 문자열화해서 리턴시키게 개조해두는 편
		 *     / 기본은 객체명@객체해시코드16진 한 값이 만들어지게 되있음.  
		 */
		Object ob = new Sword();	// 실객체를 Object 로 받아서 제어하면
		// ob.enchant();	// 이렇게 실제로 객체를 설계하면서 만든건 콜이 안되지만
		String obs = ob.toString();	// 원래 있는건 콜이 되고 , 그게 개조되있었다면..?
		System.out.println(obs);	// 
		// 이 원리가 응용되서 , System.out.println 이나, 그와 유사한 기능의 객체들이
		
		Sword s3 = new Sword();
		System.out.println(s3);		// 객체사용시 자동으로 콜이 되서 사용되는 상황이 있다.
		
		
	}
}






