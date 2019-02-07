import java.util.Set;
import java.util.TreeSet;

/*
 * Exercise02_Card 에서 , 
 * 	LinkedHashSet 이나 HashSet 을 이용해서 Card 객체를 처리하면 별다른 문제가 없지만,
 * 	TreeSet 객체를 이용해서 Card객체를 관리하면 처음부터 error가 발생한다. 
 * 
 *  TreeSet 은 크기순 오름정렬되서 데이터를 확보되는 Set 객체인데,
 *  실제 객체값에는 크기가 없기 때문에, 크기비교가 가능한 객체에 한해서만 관리가 되고,
 *  
 *  TreeSet 객체는, hashCode / equals 로 중복객체라고 판단하는게 아니라
 *  크기비교결과가 0일때 같은객체로 인식을 한다.
 */

public class Source09_Duplicate {
	public static void main(String[] args) {
		Set<Double> ds = new TreeSet<>();
		Double d1 = new Double(3.14);
		Double d2 = new Double(3.19);
		System.out.println(ds.add(d1));	// 3.14
		System.out.println(ds.add(d2));	// 3.13
		
		System.out.println(d2.compareTo(d1));	
		// 이 작업은 TreeSet에서 add 가 될때 콜하고 return 결과물이 사용된다. 
		System.out.println(ds.toString());
		
		
		Integer i1 = 3;
		Integer i2 = -1;
		System.out.println(i1.compareTo(i2));
		
		
		String s1= "조조";
		String s2 = "조운";
		// System.out.println(s1-s2);
		int n =s1.compareTo(s2);	// s1-s2 의 결과라고 생각을 하면 된다.
		System.out.println(n);
		// 만약 TreeSet에 이 두객체를 집어넣으면 조운부터 뽑힘.
		Card p1 = CardShop.random();
		Card p2 = CardShop.random();
		// System.out.println(p1-p2);
		p1.compareTo(p2);
	}
	
}
