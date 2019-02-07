package baseball;

public class Hitter {
	String name;	// ������ �̸�
	int cnt;	// true �� ȸ��
	int in, out, middle;	// ��, �ƿ�, ��� ���� ĥ�� �ִ� �ɷ�
	
	public Hitter(String name) {
		this.name = name;		
	}
	// �� ��ü�� �̸��� �����ؼ� ����� �ְ� �����ڸ� ���� (�������� 0���� ����)
	// �� ������ �ܺ� ��Ű�������� �����ϰ� access
	public boolean swing(Ball target) {
		/*
			���޹��� �� ��ü�� type �� speed�� �����ؼ� true,false�� ����ó�� -1(�ٱ�) 0 (�߾�), 1(����)
			-1�ΰ�쿣 out=0 �϶� 80~100���̸� 50�ۼ�Ʈ true , ������ false
					   out=1 �϶� 80~100���̴� 100�ۼ�Ʈ true, 100~120�� 50�ۼ�Ʈ true, �� �̻��� false
					   out=2 �϶� 80~100���̴� 100�ۼ�Ʈ , 100~120�� 100�ۼ�Ʈ true, ���̻��� 50�ۼ�Ʈ			
			0�ΰ�쿣  middle �� ���� �Ȱ���
			1�ΰ�쿣 in�� ���� �Ȱ��� Ȯ��
		*/
		int per;	
		switch(target.course) {
		case -1 :
			per = out;	break;
		case 0 :
			per = middle;	break;
		default :	
			per = in;	break;
		}
		if(target.speed >= 120) {
			if(per == 2 ) {
				if(Math.random()>0.5) {
					cnt++;
					return true;
				}
			}
		} else if(target.speed>=100) {
			if(per ==2) {
				return true;
			} else if(per==1) {
				if(Math.random()>0.5) {
					cnt++;
					return true;
				}
			}
		} else {
			if(per ==2 || per == 1) {
				return true;
			}else if(per==0) {
				if(Math.random()>0.5) {
					cnt++;
					return true;
				}
			}
		}
		return false;
	}

	public String current() {
		// �÷��̾��̸�: hit count ����, in,out,middle �� �� ������ ���ڿ� �����
		return name+ " / "+cnt+"���� Ÿ�ݼ��� / �ڽ����� (��:" +in+ ",�߾�:" + middle + ",�ٱ�:" + out + ")";
	}

	public void levelUp(int mode) {
		if(mode == -1) {
			this.out ++;
			if(out>=3)
				out = 2;
		}else if(mode==0) {
			this.middle ++;
			middle =  middle>=3 ? 2: middle;
		}else {
			if(in<2)
				this.in ++;
		}
	}

}