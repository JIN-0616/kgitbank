import java.util.Set;
import java.util.TreeSet;

/*
 *	Exercise02_Card 에서 ,
 *  LinkedHashSet이나 hashSet을 이용해서 Card 객체를 처리하면 별다른 문제가 없지만,
 *  TreeSet 객체를 이용해서 Card객체를 관리하면 처음부터 error가 발생한다.
 *  
 *  TreeSet 은 크기순 오름정렬되서 데이터를 확보되는 Set객체인데,
 *  실제 객체값에는 크기가 없기 때문에, 크기비교가 가능한 객체에 한해서만 관리가 되고,
 *    
 *  TreeSet 객체는, hashSet / equals 로 중복객체라고 판단하는게 아니라
 *  
 *  크기비교결과가 0일때 같은객체로 인식을 한다
 */
public class Source09_Duplicate {
	public static void main(String[] args) {
		Set<Double> ds = new TreeSet<>();
		Double d1 = new Double(3.14);
		Double d2 = new Double(3.13);
		System.out.println(ds.add(d1)); 
		
		System.out.println(ds.add(d2)); 
		System.out.println(d2.compareTo(d1));
		//이 작업은 TreeSet에서 add가 될때 콜하고 return 결과물 사용
		// -1이면 앞에 저장 1이면 뒤에 저장
		System.out.println(ds.toString());
		
		String s1 = "조조";
		String s2 = "조운";
		int n = s1.compareTo(s2); // s1-s2의 결과라고 생각을 하면 된다.
		System.out.println(n); 
		//만약 TreeSet에 이 두객체를 집어넣으면 조운부터 뽑힘
		
		Integer n1 = 3;
		Integer n2 = -1;
		int n3 = n1.compareTo(n2);
		System.out.println(n3);
		
		
		Card p1 = CardShop.random();
		Card p2 = CardShop.random();
		//System.out.println(p1-p2); //객체값을 빼는것은 불가능
		
		//TreeSet은 객체가 크기비교가능하게 설계
		// p1.compareTo(p2); 가능하게
	}
}
