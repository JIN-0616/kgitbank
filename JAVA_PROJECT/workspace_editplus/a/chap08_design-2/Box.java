/*
	extends �� �̿��� ����� ����,�˾ƵѰ͵�

	1. extends �� ���(����,�θ�,����,���� Ÿ����)�� ������ �ǰ�, 
	extends�� ����صξ���߸� �����ϴ�. 

	2. extends �� ���� ����Ǵ� ��ü�� ����(�θ�)�� ����ҿ� access ���� �ʴ´�.
	access �ܰ迡 ���� ������ �ȵǴ°͵��� �������� �ִ�.

	3. super Ű���带 �̿��ؾ� �ɶ��� �ִ�.
*/
package design;

// public final class Box 
public class Box {		
	int data;
	protected boolean flag;
	public double rate;

	public Box(int n) {
		System.out.println("box instance created!");
	}


	public String inform() {
		return data+", "+ flag +", " + rate;
	}
}