import java.util.Set;
import java.util.TreeSet;


/*
 * 이객체를 나중에 TreeSet으로 객체관리를 해서
 * 	크기순으로 객체값을 확보하게 하려면,
 * 	다른 객체와 비교했을때 이객체가 큰지,작은지를 판단할수 있게 설계해두면 된다.
 * 
 *  1. implements Comparable 을 설정하고 
 */

class Card implements Comparable<Card> {
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
	
	public int compareTo(Card o) {
		// this - other 결과값으로 사용될 수치를 리턴시키면 된다.
		// 예를 들어 음수를 리턴시키면, this 가 작은 상황이고, 양수를 리턴시키면 this가 큰상황임
		// 0을 리턴시키면 this와 other가 같은 크기라고 판단이 일어난다.
		/*
		if(type == o.type) {
			int c =name.compareTo(o.name);
			return c==0 ? 0 :(c<0 ? -1 : 1);
		} else {
			if(type < o.type)
				return -1;
			else
				return 1;
		}
		*/
		// 이름이 작은애가 무조건 작은 객체, 이름이 같다면 type이 작은 애가 작은객체
		// 이름도 같고, 타입도 같으면 같은 크기로 처리되게 compareTo를 변경.
		int c =name.compareTo(o.name);
		if(c < 0)
			return -1;
		else if(c > 0)
			return 1;
		else {
			return type == o.type ? 0 : (type<o.type ? -1 : 1);
		}
	}
	
	@Override
	public String toString() {
		return "{" + name+"(" + mode[type] +")}";
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode");
		return name.hashCode()* type ;
	}
	
	@Override
	public boolean equals(Object obj) {
		// System.out.println("Equals().." +this+"vs"+obj);
		if(obj instanceof Card) {
			Card o = (Card)obj;
			return name.equals(o.name) && type==o.type;
		}
		return false;
	}
}
//──────────────────────────────────────────
class CardShop {
	static Card random() {
		String[] name= "루피,조로,나미,우솝,샹디".split(",");
		
		Card t = new Card(name[(int)(Math.random()*5)], (int)(Math.random()*4));
		return t;
	}
}
//──────────────────────────────────────────
public class Exercise02_Card {
	public static void main(String[] args) {
		Set<Card> cards = new TreeSet<>();	// ctrl+shift+o
		System.out.println("7연속 카드 뽑기! 시작!! ");
		for(int cnt=1; cnt<=7; cnt++) {
			Card t = CardShop.random();
			String result = cnt+"'.. " + t.toString();
			if(!cards.contains(t)) {
				result += " NEW!";
			}
			System.out.println(result);
			cards.add(t);
		}
		System.out.println(cards.size() +"");
		for(Card m : cards) {
			System.out.println("→ " + m);
		}
		
		
	}
}



