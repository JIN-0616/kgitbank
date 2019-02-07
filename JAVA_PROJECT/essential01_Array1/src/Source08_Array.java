
public class Source08_Array {
	public static void main(String[] args) {
		/*
		 * 미리 데이터를 설정해두고 배열을 만들면..
		 */
		String[] mode = new String[] {"묵","찌","빠"};
		
		for(int i=1;i<=5;i++) {
			int auto =(int)(Math.random()*3);
			System.out.println(auto + " / "+mode[auto]);
		}
		
		String[] first = new String[] {"김","이","박","최","정","강","조","윤","장","임"};
		String[] last = new String[] {"하준","도원","서준","시루","만준","하원","서윤","서연","하은","지우"};
		
		int fidx =(int)(Math.random()*first.length);
		int lidx =(int)(Math.random()*last.length);
		
		String name = first[fidx]+last[lidx];
		System.out.println("당신의 이번생은 ["+name+"] 으로 살게됩니다.");
		
	}
}
