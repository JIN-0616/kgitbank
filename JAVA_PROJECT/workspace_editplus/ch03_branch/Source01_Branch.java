/*
	chap01, chap02�� ��ġ�鼭
	���α׷����� ����Ҽ� �ִ� ������ ������, �����Ϳ� �����ϴ� ����,
	�����͸� �����ϴ� ��, ������ִ� �����͸� ���� �����ϴ� ���꿡 ���Ͽ� ���캸�Ҵ�.

	�װ� �̿��ؼ�
	�غ�� �����Ϳ� ����ڷκ��� �Է¹��� �����͸� ����,
	���ϴ� ����� �����س��� ���� �����۾��� �غ��Ҵ�.

	������, ��� ������ �ϱ� ���� �۾��� ������ �ϴٺ���,
	������ ���¿� ���� �ٸ� ó���� �ʿ��� ��찡 ����� �ȴ�.

	���� ���, ���� �������ݰ� �����ϰ� 100����, (50����)�� ��� ���ݤ������� ���״µ�,
	�̷� �ֽİŷ����� ���, ȣ�� ���� ��� ������ �����ؼ� 
	�������ݿ� ���� ���� ������ �ٸ��� ó���Ѵ�.
	������� 5000-10000�� ���̴� 10�� ���� / 50000-100000���̴� 100�������� ������ �Ǳ⶧����
	������ ���¿� ���� �ٸ� ó���� �Ͼ�� �۾� ������ �ؾ��Ѵ�.

	�̰� �����ϴµ� ���Ǵ°� branch ���̰�, �� branch�� �����ϴµ� ���Ǵ°�
	if - else (�����ͻ���) / switch (�����Ͱ�) �� �ΰ��� �����̴�.

	if - else ����
*/

class Source01_Branch {
	public static void main(String[] args) 	{
		System.out.print("Insert coin> ");
		int coin = Integer.valueOf(System.console().readLine());

		// ������ �������� ��찡 �׷��� ���� ��쿡 ó���� �޶����� �Ѵٸ�
		// ������ ���� � �߰��ؼ�, if�� branch��
		// coin100�̻��̰�, 100���� �Է��������� �۵��� �� �ְ� ����
		if(coin>=100 && coin%100==0){ //������ ���� Ȯ���� ���� Ǫ���ϰ� ������ &&Ȥ�� ||�� �Ἥ ����
			// ������϶� { }�� �۵���ų���� ���� ���� ȯ����� ���� / ture, false
			int life = coin/100;
			System.out.println(life +" life gained");
		}else{
			System.out.println("[System] invalied coin : "+ coin);
			System.out.println("[System] Sorry");
		}
		System.out.println(");
		System.out.println("[System] terminate");

	}
}