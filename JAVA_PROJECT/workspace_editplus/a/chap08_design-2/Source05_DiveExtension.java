/*
	3. super ��� Ű���带 ����ؾߵǴ� ��Ȳ�� �������� �ִ�.
	- ����(�θ�)�ʿ� �Ű����� ���� �����ڰ� �������� �ʴ´ٸ�, ������ ����� �ٲ���� �ϴµ�
	�̶� �� Ű���尡 ���δ�.
	- ����ϰ��� �ϴ� ������, ����� �θ����� �����ϰ� ������ super�� �������ټ� �ִ�. 
	- (����, extends �ɰ� �����Ҷ� ������ �ִµ� �ִ� �̸����� 
		�ٽ� �� ������ �Լ��� ����°� ����Ѵ�. �׷����� �ݵ�� super , this �̷��� �����ؼ� ó���ؾߵȴ�.)
*/
class Talent {
	Talent(String s) {
		System.out.println("Talent created.."+ s);
	}
	Talent(int s) {
		System.out.println("Talent created.."+ s);
	}
	String tell() {
		if(Math.random()>0.5)
			return "�ȳ��ϼ���";
		else
			return "�ݰ����ϴ�";
	}
}
class Actor extends Talent {
	Actor() {
		// new Talent("??");
		super(11);
		System.out.println("Actor created");
	}
	
	String performance(boolean mode) {
		if(mode) {
			return "(ȭ���� ���)"+ super.tell();
		}else {
			return "(������ �ϸ�)"+ super.tell();
		}
	}

}


class MovieStar extends Actor {
	MovieStar() {
		// new Actor() �̷� ������ �ڵ带 �ۼ��ؾߵ�����, ������ �ڵ����� super();
		System.out.println("MovieStar created");
	}
}
//=======================================================================
class Source05_DiveExtension {
	public static void main(String[] args) 	{
		Actor a = new Actor();
		String m = a.tell();
		System.out.println(m);
		String z = a.performance(false);
		System.out.println(z);
		// new MovieStar();


		/*
			Container ��ü�� �ϳ� ����
		*/
		// Container c = new Container();	
		/*
			���࿡ �����ϰ��� �ϴ� ��ü�� extends �� ���ؼ� ����� ��ü���,
			extends �� �ֻ������� �ϳ��� ���ʴ�� ��������鼭 ��ü�� �ϼ��ȴ�.
			�� �� ���ܰ��� ��ü�� ������Ű�� �������� 
			�Ű����� ���� ������ �����ڸ� ã�Ƽ� �����ǰ� ���ִ�.
		*/
	
	}
}