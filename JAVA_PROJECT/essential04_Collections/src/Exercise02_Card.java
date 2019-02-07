import java.util.Set;
import java.util.TreeSet;

/*
 * 이 객체를 나중에 TreeSet으로 객체관리를 해서
 *  크기순으로 객체값을 확보하게 하려면,
 *  다른 객체와 비교했을때, 이 객체가 큰지,작은지를 구현해서
 *  리턴시키면 된다.
 *  
 *  ##########################################################
 *  
 *  ※ TreeSet은 hashCode(), equals()를 사용하지 않는다.
 *  
 *  ※ 실제 처리 순서 : TreeSet 
 *  
 *  1. implements Comparable<E> 을 설정하고
 *       
 *  2. add unimplements method<E>
 *  	@Override
 *		public int compareTo(E e) {
 *		
 *		return 0;
 *	------------------------------->
 *		@Override
 *		public int compareTo(E e) {
 *	}
 *   ##########################################################
 *
 */

class Card implements Comparable<Card> {
						//제네릭설정시 설정값끼리만 비교가능, 안붙이면 Object
	static String[] mode;
	static {
		mode = new String[] {"탱커","딜러","힐러","서포터"};
	}
	
	String name;
	int type;
	
	public Card(String n, int t) {
		name = n;
		type = t;
	}
	
	@Override
	public int compareTo(Card o) {
		// this - other 결과값으로 사용할 수치를 return 시키면 된다.
		// 예를들어 음수를 리턴시키면 this가 작은 상황이고,
		// 양수를 리턴시키면 this가 더 큰 상황임
		// 0를 리턴시키면 this와 other가 같은 크기라고 판탄이 일어난다.
		//System.out.println("compareTo() called");
		/*
		if(type == o.type) {
			int c = name.comapreTo(o.name);
			return c==0 ? 0 : (c<0 ? -1 : 1);
		}else {
			if(type< o.type)
				return -1;
			else
				return 1;
		}
		*/
		
		//이름이 작은에가 무조건 작은 객체, 이름이 같다면 type이 작은 애가 같은객체
		//이름도 같고, 타입도 같으면 같은 크기로 처리되게 compareTo를 변경
		
		/* //--------------------------기존 var------------------------
		if(name.compareTo(o.name)<0) {
			return -1;			
		}else if(name.compareTo(o.name)>0){
			return 1;
		}else {			
//			if(type< o.type)
//				return -1;
//			else if(type>o.type)
//				return 1;
//			else
//				return 0;			
			return type==o.type ? 0 : (type<o.type ? -1 : 1 );
		}
		*/ //--------------------------축약 var------------------------
		int compare = name.compareTo(o.name);
		return (compare==0) ? (type - o.type) : (compare<0 ? -1 : 1);
		
		/* ------------------------teacher A------------------------
		int c= name.comapreTo(o.name);
		if(c<0)
			return -1;
		else if(c> 0)
			return 1;
		else{
			return type==o.type ? 0 : (type<o.type ? -1 : 1);
		}
		--------------------------------------------------------------
		*/
	}
		
	@Override
	public String toString() {
		return "{"+name+" ("+mode[type] +")}";
	}
	
	@Override
	public int hashCode() {
		int a = 0;
		for (int i = 0; i < CardShop.name.length; i++) {
			if(CardShop.name[i].equals(name)) {
				a = i+1;
			}
		}
		return (a*a+1)*3+(type*type)*3;
		//String의 경우 분해하면 더 개별적?
		
		//teachers A
		//return name.hashCode() * type;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Card) {
			Card other = (Card)obj;
			return other.mode[type].equals(this.mode[type]) && other.name.equals(this.name) ;
			//return name.equals(o.name) && type==other.type; //더 간단
		}else {
			return false;
		}	
	}


}
//----------------------------------------------------------------------------------
class CardShop{
	static String[] name = "루피,조로,나미,우솝,상디".split(",");
	static Card random() {		
		Card t = new Card(name[(int)(Math.random()*5)], (int)(Math.random()*4));		
		return t;
	}
}
//----------------------------------------------------------------------------------
public class Exercise02_Card {
	public static void main(String[] args) {
		Set<Card> cards = new TreeSet<>();	//ctrl+shift+O	
							//hashSet -> TreeSet
		System.out.println("7연속 카드 뽑기! 시작!! ");
		for (int cnt = 1; cnt <=7; cnt++) {
			Card t = CardShop.random();
			String result = cnt+"'s pick = "+t.toString();
			if( !cards.contains(t) ) {
				result += " NEW!";
			}
			System.out.println(result);
			//System.out.println(t.toString()+", hashCode= "+t.hashCode());
			System.out.println();
			cards.add(t);
		}
		//System.out.println(cards.size());
		System.out.println(cards.size()+"");
		for (Card card : cards) {
			System.out.println("-->"+ card);
		}
	}
}
