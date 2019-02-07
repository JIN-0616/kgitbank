/*
 *  메인 흐름과 별도로 작동하는 다른 흐름이 필요하면,
 *  객체를 설계할때, extends Thread
 */

class CharPrint extends Thread{
	char start;
	char end;
	CharPrint(char s, char e){
		start = s;
		end = e;		
	}
	@Override
	public void run() { //메인으로 간주
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
			//	System.err.println(getName()+" : "+str); //에러출력
			}				
		}
	}
}

public class Source02_Thread {
	public static void main(String[] args) {
   //CharPrint t
		Thread t1 =new CharPrint('가','나');
		// run() 으로 호출하는 것은 무의미하다.		

		t1.start(); // 쓰레드 가동(병렬적으로 처리할 독립작업을 시작시키는)
		for (int cnt = 1; cnt <=10 ; cnt++) {
			System.out.println("-");
		}
		Thread t2 =new CharPrint('나', '다');
		t2.start();
		
	//	t1.stop(); //하지마라라고 deprecated 비추천 되어있다
		
		//프로그램 흐름은 main에서 진행하는 모든 쓰레드가 종료해야 프로그램이 종료가 된다.
		
		
		// 접속한 사용자를 처리할 객체를 만드는것
		
		// 기존 2중반복 (accept ( read,control,write))
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
Thread-0 : 가각갂갃간갅갆갇갈갉갊갋갌갍갎갏감갑값갓
Thread-0 : 갔강갖갗갘같갚갛개객갞갟갠갡갢갣갤갥갦갧
Thread-0 : 갨갩갪갫갬갭갮갯갰갱갲갳갴갵갶갷갸갹갺갻
Thread-0 : 갼갽갾갿걀걁걂걃걄걅걆걇걈걉걊걋걌걍걎걏
Thread-0 : 걐걑걒걓걔걕걖걗걘걙걚걛걜걝걞걟걠걡걢걣
Thread-0 : 걤걥걦걧걨걩걪걫걬걭걮걯거걱걲걳건걵걶걷
Thread-1 : 나낙낚낛난낝낞낟날낡낢낣낤낥낦낧남납낪낫
Thread-0 : 걸걹걺걻걼걽걾걿검겁겂것겄겅겆겇겈겉겊겋
Thread-1 : 났낭낮낯낰낱낲낳내낵낶낷낸낹낺낻낼낽낾낿
Thread-0 : 게겍겎겏겐겑겒겓겔겕겖겗겘겙겚겛겜겝겞겟
Thread-1 : 냀냁냂냃냄냅냆냇냈냉냊냋냌냍냎냏냐냑냒냓
Thread-0 : 겠겡겢겣겤겥겦겧겨격겪겫견겭겮겯결겱겲겳
Thread-1 : 냔냕냖냗냘냙냚냛냜냝냞냟냠냡냢냣냤냥냦냧
Thread-1 : 냨냩냪냫냬냭냮냯냰냱냲냳냴냵냶냷냸냹냺냻
Thread-1 : 냼냽냾냿넀넁넂넃넄넅넆넇너넉넊넋넌넍넎넏
Thread-1 : 널넑넒넓넔넕넖넗넘넙넚넛넜넝넞넟넠넡넢넣
Thread-1 : 네넥넦넧넨넩넪넫넬넭넮넯넰넱넲넳넴넵넶넷
Thread-0 : 겴겵겶겷겸겹겺겻겼경겾겿곀곁곂곃계곅곆곇
Thread-1 : 넸넹넺넻넼넽넾넿녀녁녂녃년녅녆녇녈녉녊녋
Thread-0 : 곈곉곊곋곌곍곎곏곐곑곒곓곔곕곖곗곘곙곚곛
Thread-1 : 녌녍녎녏념녑녒녓녔녕녖녗녘녙녚녛녜녝녞녟
Thread-0 : 곜곝곞곟고곡곢곣곤곥곦곧골곩곪곫곬곭곮곯
Thread-1 : 녠녡녢녣녤녥녦녧녨녩녪녫녬녭녮녯녰녱녲녳
Thread-0 : 곰곱곲곳곴공곶곷곸곹곺곻과곽곾곿관괁괂괃
Thread-0 : 괄괅괆괇괈괉괊괋괌괍괎괏괐광괒괓괔괕괖괗
Thread-1 : 녴녵녶녷노녹녺녻논녽녾녿놀놁놂놃놄놅놆놇
Thread-1 : 놈놉놊놋놌농놎놏놐놑높놓놔놕놖놗놘놙놚놛
Thread-0 : 괘괙괚괛괜괝괞괟괠괡괢괣괤괥괦괧괨괩괪괫
Thread-1 : 놜놝놞놟놠놡놢놣놤놥놦놧놨놩놪놫놬놭놮놯
Thread-0 : 괬괭괮괯괰괱괲괳괴괵괶괷괸괹괺괻괼괽괾괿
Thread-1 : 놰놱놲놳놴놵놶놷놸놹놺놻놼놽놾놿뇀뇁뇂뇃
Thread-1 : 뇄뇅뇆뇇뇈뇉뇊뇋뇌뇍뇎뇏뇐뇑뇒뇓뇔뇕뇖뇗
Thread-0 : 굀굁굂굃굄굅굆굇굈굉굊굋굌굍굎굏교굑굒굓
Thread-1 : 뇘뇙뇚뇛뇜뇝뇞뇟뇠뇡뇢뇣뇤뇥뇦뇧뇨뇩뇪뇫
Thread-0 : 굔굕굖굗굘굙굚굛굜굝굞굟굠굡굢굣굤굥굦굧
Thread-1 : 뇬뇭뇮뇯뇰뇱뇲뇳뇴뇵뇶뇷뇸뇹뇺뇻뇼뇽뇾뇿
Thread-1 : 눀눁눂눃누눅눆눇눈눉눊눋눌눍눎눏눐눑눒눓
Thread-1 : 눔눕눖눗눘눙눚눛눜눝눞눟눠눡눢눣눤눥눦눧
Thread-1 : 눨눩눪눫눬눭눮눯눰눱눲눳눴눵눶눷눸눹눺눻
Thread-1 : 눼눽눾눿뉀뉁뉂뉃뉄뉅뉆뉇뉈뉉뉊뉋뉌뉍뉎뉏
Thread-1 : 뉐뉑뉒뉓뉔뉕뉖뉗뉘뉙뉚뉛뉜뉝뉞뉟뉠뉡뉢뉣
Thread-1 : 뉤뉥뉦뉧뉨뉩뉪뉫뉬뉭뉮뉯뉰뉱뉲뉳뉴뉵뉶뉷
Thread-1 : 뉸뉹뉺뉻뉼뉽뉾뉿늀늁늂늃늄늅늆늇늈늉늊늋
Thread-1 : 늌늍늎늏느늑늒늓는늕늖늗늘늙늚늛늜늝늞늟
Thread-1 : 늠늡늢늣늤능늦늧늨늩늪늫늬늭늮늯늰늱늲늳
Thread-1 : 늴늵늶늷늸늹늺늻늼늽늾늿닀닁닂닃닄닅닆닇
Thread-1 : 니닉닊닋닌닍닎닏닐닑닒닓닔닕닖닗님닙닚닛
Thread-1 : 닜닝닞닟닠닡닢닣
Thread-0 : 굨굩굪굫구국굮굯군굱굲굳굴굵굶굷굸굹굺굻
Thread-0 : 굼굽굾굿궀궁궂궃궄궅궆궇궈궉궊궋권궍궎궏
Thread-0 : 궐궑궒궓궔궕궖궗궘궙궚궛궜궝궞궟궠궡궢궣
Thread-0 : 궤궥궦궧궨궩궪궫궬궭궮궯궰궱궲궳궴궵궶궷
Thread-0 : 궸궹궺궻궼궽궾궿귀귁귂귃귄귅귆귇귈귉귊귋
Thread-0 : 귌귍귎귏귐귑귒귓귔귕귖귗귘귙귚귛규귝귞귟
Thread-0 : 균귡귢귣귤귥귦귧귨귩귪귫귬귭귮귯귰귱귲귳
Thread-0 : 귴귵귶귷그극귺귻근귽귾귿글긁긂긃긄긅긆긇
Thread-0 : 금급긊긋긌긍긎긏긐긑긒긓긔긕긖긗긘긙긚긛
Thread-0 : 긜긝긞긟긠긡긢긣긤긥긦긧긨긩긪긫긬긭긮긯
Thread-0 : 기긱긲긳긴긵긶긷길긹긺긻긼긽긾긿김깁깂깃
Thread-0 : 깄깅깆깇깈깉깊깋까깍깎깏깐깑깒깓깔깕깖깗
Thread-0 : 깘깙깚깛깜깝깞깟깠깡깢깣깤깥깦깧깨깩깪깫
Thread-0 : 깬깭깮깯깰깱깲깳깴깵깶깷깸깹깺깻깼깽깾깿
Thread-0 : 꺀꺁꺂꺃꺄꺅꺆꺇꺈꺉꺊꺋꺌꺍꺎꺏꺐꺑꺒꺓
Thread-0 : 꺔꺕꺖꺗꺘꺙꺚꺛꺜꺝꺞꺟꺠꺡꺢꺣꺤꺥꺦꺧
Thread-0 : 꺨꺩꺪꺫꺬꺭꺮꺯꺰꺱꺲꺳꺴꺵꺶꺷꺸꺹꺺꺻
Thread-0 : 꺼꺽꺾꺿껀껁껂껃껄껅껆껇껈껉껊껋껌껍껎껏
Thread-0 : 껐껑껒껓껔껕껖껗께껙껚껛껜껝껞껟껠껡껢껣
Thread-0 : 껤껥껦껧껨껩껪껫껬껭껮껯껰껱껲껳껴껵껶껷
Thread-0 : 껸껹껺껻껼껽껾껿꼀꼁꼂꼃꼄꼅꼆꼇꼈꼉꼊꼋
Thread-0 : 꼌꼍꼎꼏꼐꼑꼒꼓꼔꼕꼖꼗꼘꼙꼚꼛꼜꼝꼞꼟
Thread-0 : 꼠꼡꼢꼣꼤꼥꼦꼧꼨꼩꼪꼫꼬꼭꼮꼯꼰꼱꼲꼳
Thread-0 : 꼴꼵꼶꼷꼸꼹꼺꼻꼼꼽꼾꼿꽀꽁꽂꽃꽄꽅꽆꽇
Thread-0 : 꽈꽉꽊꽋꽌꽍꽎꽏꽐꽑꽒꽓꽔꽕꽖꽗꽘꽙꽚꽛
Thread-0 : 꽜꽝꽞꽟꽠꽡꽢꽣꽤꽥꽦꽧꽨꽩꽪꽫꽬꽭꽮꽯
Thread-0 : 꽰꽱꽲꽳꽴꽵꽶꽷꽸꽹꽺꽻꽼꽽꽾꽿꾀꾁꾂꾃
Thread-0 : 꾄꾅꾆꾇꾈꾉꾊꾋꾌꾍꾎꾏꾐꾑꾒꾓꾔꾕꾖꾗
Thread-0 : 꾘꾙꾚꾛꾜꾝꾞꾟꾠꾡꾢꾣꾤꾥꾦꾧꾨꾩꾪꾫
Thread-0 : 꾬꾭꾮꾯꾰꾱꾲꾳꾴꾵꾶꾷꾸꾹꾺꾻꾼꾽꾾꾿
Thread-0 : 꿀꿁꿂꿃꿄꿅꿆꿇꿈꿉꿊꿋꿌꿍꿎꿏꿐꿑꿒꿓
Thread-0 : 꿔꿕꿖꿗꿘꿙꿚꿛꿜꿝꿞꿟꿠꿡꿢꿣꿤꿥꿦꿧
Thread-0 : 꿨꿩꿪꿫꿬꿭꿮꿯꿰꿱꿲꿳꿴꿵꿶꿷꿸꿹꿺꿻
Thread-0 : 꿼꿽꿾꿿뀀뀁뀂뀃뀄뀅뀆뀇뀈뀉뀊뀋뀌뀍뀎뀏
Thread-0 : 뀐뀑뀒뀓뀔뀕뀖뀗뀘뀙뀚뀛뀜뀝뀞뀟뀠뀡뀢뀣
Thread-0 : 뀤뀥뀦뀧뀨뀩뀪뀫뀬뀭뀮뀯뀰뀱뀲뀳뀴뀵뀶뀷
Thread-0 : 뀸뀹뀺뀻뀼뀽뀾뀿끀끁끂끃끄끅끆끇끈끉끊끋
Thread-0 : 끌끍끎끏끐끑끒끓끔끕끖끗끘끙끚끛끜끝끞끟
Thread-0 : 끠끡끢끣끤끥끦끧끨끩끪끫끬끭끮끯끰끱끲끳
Thread-0 : 끴끵끶끷끸끹끺끻끼끽끾끿낀낁낂낃낄낅낆낇
Thread-0 : 낈낉낊낋낌낍낎낏낐낑낒낓낔낕낖낗
*/