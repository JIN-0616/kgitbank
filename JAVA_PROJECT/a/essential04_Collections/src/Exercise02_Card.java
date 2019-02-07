import java.util.Set;
import java.util.TreeSet;


/*
 * �̰�ü�� ���߿� TreeSet���� ��ü������ �ؼ�
 * 	ũ������� ��ü���� Ȯ���ϰ� �Ϸ���,
 * 	�ٸ� ��ü�� �������� �̰�ü�� ū��,�������� �Ǵ��Ҽ� �ְ� �����صθ� �ȴ�.
 * 
 *  1. implements Comparable �� �����ϰ� 
 */

class Card implements Comparable<Card> {
	static String[] mode;
	static {
		mode = new String[] {"��Ŀ","����","����","������"};
	}
	String name;
	int type;
	public Card(String n, int t) {
		name = n;
		type = t;
	}
	
	public int compareTo(Card o) {
		// this - other ��������� ���� ��ġ�� ���Ͻ�Ű�� �ȴ�.
		// ���� ��� ������ ���Ͻ�Ű��, this �� ���� ��Ȳ�̰�, ����� ���Ͻ�Ű�� this�� ū��Ȳ��
		// 0�� ���Ͻ�Ű�� this�� other�� ���� ũ���� �Ǵ��� �Ͼ��.
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
		// �̸��� �����ְ� ������ ���� ��ü, �̸��� ���ٸ� type�� ���� �ְ� ������ü
		// �̸��� ����, Ÿ�Ե� ������ ���� ũ��� ó���ǰ� compareTo�� ����.
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
//������������������������������������������������������������������������������������
class CardShop {
	static Card random() {
		String[] name= "����,����,����,���,����".split(",");
		
		Card t = new Card(name[(int)(Math.random()*5)], (int)(Math.random()*4));
		return t;
	}
}
//������������������������������������������������������������������������������������
public class Exercise02_Card {
	public static void main(String[] args) {
		Set<Card> cards = new TreeSet<>();	// ctrl+shift+o
		System.out.println("7���� ī�� �̱�! ����!! ");
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
			System.out.println("�� " + m);
		}
		
		
	}
}



