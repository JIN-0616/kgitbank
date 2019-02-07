/*
 *  ���� �帧�� ������ �۵��ϴ� �ٸ� �帧�� �ʿ��ϸ�,
 *  ��ü�� �����Ҷ�, extends Thread
 */

class CharPrint extends Thread{
	char start;
	char end;
	CharPrint(char s, char e){
		start = s;
		end = e;		
	}
	@Override
	public void run() { //�������� ����
		/*
		int cnt =0;
		for (char c = start; c < end; c++) {			
			synchronized (System.out) {
								
			}	
		}
		System.out.println();
		*/
		char c = start;
		while(c<end) {
			String str = "";
			for (int cnt = 1; cnt <= 20; cnt++) {	
				str += c++;				
				if(c==end)
					break;
			}
			synchronized (System.out) {
				System.out.println(getName()+" : "+str);
			//	System.err.println(getName()+" : "+str); //�������
			}				
		}
	}
}

public class Source02_Thread {
	public static void main(String[] args) {
   //CharPrint t
		Thread t1 =new CharPrint('��','��');
		// run() ���� ȣ���ϴ� ���� ���ǹ��ϴ�.		

		t1.start(); // ������ ����(���������� ó���� �����۾��� ���۽�Ű��)
		for (int cnt = 1; cnt <=10 ; cnt++) {
			System.out.println("-");
		}
		Thread t2 =new CharPrint('��', '��');
		t2.start();
		
	//	t1.stop(); //���������� deprecated ����õ �Ǿ��ִ�
		
		//���α׷� �帧�� main���� �����ϴ� ��� �����尡 �����ؾ� ���α׷��� ���ᰡ �ȴ�.
		
		
		// ������ ����ڸ� ó���� ��ü�� ����°�
		
		// ���� 2�߹ݺ� (accept ( read,control,write))
	}
}
/*
-
-
-
-
-
-
-
-
-
-
Thread-0 : �����A�B���C�D���������E�F�G�H�I��������
Thread-0 : ���������J�����������K�L���M�N�O���P�Q�R
Thread-0 : �S�T�U�V�����W�������X�Y�Z�a�b�c�����d�e
Thread-0 : ���f�g�h���i�j�k�l�m�n�o�p�q�r���s���t�u
Thread-0 : �v�w�x�y�z�����Á������ā�������������
Thread-0 : �������������������������ŰƁ����ǁ�����
Thread-1 : ���������������������������A�B�C�����D��
Thread-0 : �Ɂ��ʁ����������˰́��ͰΰϰЁ����ѰҰ�
Thread-1 : ���������E���F�������G�H���I�J�K���L�M�N
Thread-0 : �ԁ������Ձ������ց��������������װ؁���
Thread-1 : �O�P�Q�R�����S���³ÆT�U�V�W�X�Y�ĳņZ�a
Thread-0 : �ڰہ������������ܰݰށ��߁�����ၽ����
Thread-1 : �Ɔb�c�d�ǆe�f�g�h�i�j�k�Ȇl�m�n�o�Ɇp�q
Thread-1 : �r�s�t�u�v�w�x�y�z����������������������
Thread-1 : �������������������������ʳˆ��̳͆�����
Thread-1 : �Ά��ϳІ��������ѳ҆��ӳԳՆ�����������
Thread-1 : �׳؆����ن������چ��������������۳܆���
Thread-0 : �����ð��İ���ŁƁǰ�ȁɰ�ʁˁ�
Thread-1 : �޳߆�������������ᆺ���↼�����ㆿ����
Thread-0 : ��́΁ϰ�ЁсҁӁԁՁցװ�ذ�فځہ�
Thread-1 : �ÆĆų��Ɔǳ��Ȇɳ�ʆˆ̳�͆Ά�
Thread-0 : �݁ށ߁�����������������
Thread-1 : ��Іц҆ӆԆՆֆ׆؆نچۆ܆݆ކ߆����
Thread-0 : ������������������������������
Thread-0 : ���������������������������������A�B�C�D
Thread-1 : ����������������������
Thread-1 : ���������������������������������
Thread-0 : ���E�F�G���H�I�J���K�L�M�N�O�P�Q�R���S�T
Thread-1 : �����A�B�C�D�E�F�G�H�I�J���K�L�M�N�O�P�Q
Thread-0 : �����U�V�W�X�Y�Z�����a�b���c�d�e���f�g�h
Thread-1 : �R�S�T�U�V�W�X�Y�Z�a�b�c�d�e�f�g�h�i�j�k
Thread-1 : �l�m�n�o�p�q�r�s���t�u�v���w�x�y���z����
Thread-0 : �i�j�k�l�����m���n���o�p�q�r�s�t���u�v�w
Thread-1 : ����������������������������������������
Thread-0 : ���x�y�z��������������������������������
Thread-1 : ����������������������������������������
Thread-1 : ����������������������������������������
Thread-1 : ����������������������������������������
Thread-1 : �������ÇćŇƇǇȇɇʴ��ˇ͇̇·χЇ�
Thread-1 : ���҇ӇԇՇևׇ؇هڇۇ܇݇އ߇������
Thread-1 : ��������촵���ﴶ����򴷇���
Thread-1 : �����������������������A�B�C�D�E�����F�G
Thread-1 : �H�I�J�K���L�M�N�O�P�Q�R�����S�T�U���V�W
Thread-1 : �X�Y�Z�a�����b�c�d�e�f�ôĴňg�h�i�j�k
Thread-1 : �ƴǈl�Ȉm�ɴʈn�o�p�ˈq�̈r�s�t�͈u�v�w
Thread-1 : �Έx�y�z��������������������������������
Thread-1 : �ϴЈ����ш������҈��ӈ����������ԴՈ���
Thread-1 : ���׈��������؈�
Thread-0 : ����������������������������������������
Thread-0 : ���������ñĂ����������űƂ����ǂ�����
Thread-0 : �Ȃ����������������������ɱʂ�����������
Thread-0 : �˂����������������������ÂĂłƂǂȱ�
Thread-0 : �ɂʂ˂̂͂΂ςбͱ΂тұςӂԂձЂւׂ�
Thread-0 : �قڂۂܱѱ҂ݱӂނ߂�������Ԃ���
Thread-0 : �Ղ���ւ���������������������
Thread-0 : ���������ױ؃A�B�كC�D�ڱ۱܃E�F�G�H�I�J
Thread-0 : �ݱރK�߃L���M�N�O�P�Q�R��S�T�U�V�W�X�Y
Thread-0 : �Z�a�b�c�d�e�f�g�h�i�j�k�l�m�n�o�p�q�r�s
Thread-0 : ���t�u��v�w���x��y�z��������郄��
Thread-0 : ����샆�����탉�������񃋃����򃎱�
Thread-0 : ����������������������������������������
Thread-0 : ����������������������������������������
Thread-0 : ����������������������������������������
Thread-0 : �����������������ÃăŃƃǃȃɃʃ˃̃�
Thread-0 : �΃σЃу҃ӃԃՃփ׃؃كڃۃ܃݃ރ߃���
Thread-0 : �������ⲫ���岬�������청����
Thread-0 : �����������󲲲��������������������
Thread-0 : �����A�B���C�D���E���F�G�H�I�J�K���L�M�N
Thread-0 : ���O�P�Q���R�S�T�U�V�W�X�Y�Z�a�����b�c�d
Thread-0 : �e���f�g���h�i�j�k�l�m�n�o�p�q�r�s�t�u�v
Thread-0 : �w�x�y�z������������������������������
Thread-0 : �Ä��������������Ĳń��Ƅ��ǲȲɄ�������
Thread-0 : �ʲ˄������������̄���������������������
Thread-0 : �Ͳ΄������������ϲЄ�������������������
Thread-0 : ���������������òфĄńƄǄȄɲ҄ʄ˄�
Thread-0 : �ӄ̈́΄ϲԄЄф҄ӄԄՄֲղքׄ؄ٲׄڄ�
Thread-0 : �܄݄ބ߲؄����������������
Thread-0 : ��������������������ٲڄ����ۄ����A
Thread-0 : �܅B�C�D�E�F�G�ݲ޲߅H���I���J�K�L�M�N
Thread-0 : ��O�P�Q�R�S�T�U��V�W�X�Y�Z�a�b�c�d�e�f
Thread-0 : ���g�h�i�j�k�l���m�n��o�p�q��r�s�t
Thread-0 : �u�v�w�x���y�z�텁�����������������
Thread-0 : �����������������������򅕅���������
Thread-0 : ���������󅟅���������������������������
Thread-0 : ����������������������������������������
Thread-0 : �������������²������ò��Ĳ��Ņƅǳ��ȅ�
Thread-0 : �ʅ˅̅ͅ΅υЅх҅ӅԅՅօׅ؅مڅۅ܅�
Thread-0 : �ޅ߅������峢����糤���곥����
Thread-0 : �����񳦳��򳨅󳩅����������
*/