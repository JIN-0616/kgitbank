/*
	�ֽ� ���� �ùķ��̼��� ���ؼ� �����, �ֽ������� ��üȭ���ѵ���.
	# this ��� ���� ����ϴ� �� #
	this�� ��ü�� ��������� ������ ������ �� ��ü���� ������ ���� (����)
	
	this.    : ������� ��ü�� ������ �� �͵��� ����ϰ��� �Ҷ�
	this();  : �����ڿ����� ���� �ִ� ��������, �ٸ������ڷ� �Ѱܼ� ������Ű���� �Ҷ�

*/
class Stock {
	static int turn;

	static {
		turn = 0;
	}

	String product;
	int value;
	int ammount;
	
	Stock(String product) {
		/*
			this.product = product;
			this.value = 500;
			ammount = 100;
		*/
		this(product, 500);
//		System.out.println("Stock(String)");
	}

	Stock(String initProduct, int v) {
		product = initProduct;
		value = v;
		ammount = 0;
//		System.out.println("Stock(String, int)");
	}

	String current() {
	//	this(product, 500);	// this(); �� ���� �����ھȿ����� ��밡��
		return "Day."+ Stock.turn+ " : " + this.product +"  �� "+ value + " / "+ammount+" ������";
	}
	
	void change() {
		int value = this.value;	
		// �̰�ü�� ��������� ������ ������ �� ��������,
		// ���ν��� �����ϴµ� �־ ������ �ᵵ ������ ���а� ���� �ʴ´�.
		// �� ���ν��� �ȿ��� ���Ǵ� value ������, ��ü�� �����Ե� value�� �ƴ϶�
		// �� �ȿ��� ������  value ������ ���̰� �ȴ�.
		// �� ���ν����ȿ��� ��ü�� ���� ������ ���� ���� ���ؼ� �������� �Ǹ�
		// �׶� this�� �������ָ� �����ؼ� ����Ҽ� �ִ�.
		int high = (int)(value*1.3);
		if(high%100 !=0)
			high -= high%100;
		int low = (int)(value*0.7);
		if(low%100 !=0) {
			low += 100;
			low -= low%100;
		}
		/*
		high /=100;
		low /= 100;
		value = low +(int)(Math.random()*(high-low+1));
		value *= 100;
		*/
		value = low + (int)(Math.random()*(high-low+1) );
		value /= 100;
		value *= 100;
	//	System.out.println("value = "+ this.value + "/"+value);
		this.value = value;
		// ���ν��� �����Ҷ� ������ ��ġ�� �ʴ´ٸ�, ���� this�� �������ص� ������, 
		// ���ļ� �ΰ��� ���ٵǴ� ��Ȳ�� �ȴٸ�. this �� �ٿ��� �� ��ü�� ������ ������ �׷��� ���� ������
		// ����������� �ȴ�.
		// �Ϻη� ��ġ�� ��Ȳ�� �ִ�. �����ڳ� ���� Ư�������ͷ� �����ϰ� �ϴ� ������ ���ν��� �϶�
	}

}
