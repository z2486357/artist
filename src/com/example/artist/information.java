package com.example.artist;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class information extends Activity {
	String [] name = new String [100];
	String [] picture = new String [100];
	String [] info = new String [100];
	int num;
	Thread t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.information);
		ImageView bback= (ImageView)findViewById(R.id.back);
		bback.setOnClickListener(backcl);
		Intent intent = getIntent();
		String message = intent.getStringExtra("message");
		num = Integer.parseInt(message); 
		t = new Thread(r0);
		t.start();
		TextView tv= (TextView)findViewById(R.id.textView2);
		tv.setMovementMethod(new ScrollingMovementMethod());
	}
	private Button.OnClickListener backcl = new Button.OnClickListener() {
		public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(information.this, gps.class);
		startActivity(intent);
		finish();
		}
	};

	private Runnable r0 = new Runnable() {
		public void run() {
			mH.sendEmptyMessage(0);
		}
	};
	
	
	private Handler mH = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				name[0]="台積館";
				name[1]="無聲的對話";
				name[2]="奕園";
				name[3]="昇華";
				name[4]="清齋前面";
				name[5]="痕";
				name[6]="清鏡";
				name[7]="清華園";
				name[8]="大禮堂";
				name[9]="湖畔";
				name[10]="湖心亭";
				name[11]="鳳凰";
				name[12]="藝術中心";
				name[13]="候鳥蜂巢";
				name[14]="雕塑公園";
				name[15]="陽光走廊";
				name[16]="沉思者";
				name[17]="日晷";
				name[18]="過程";
				name[19]="簡冊立柱";
				picture[0]="information0";
				picture[1]="information1";
				picture[2]="information2";
				picture[3]="information3";
				picture[4]="information4";
				picture[5]="information5";
				picture[6]="information6";
				picture[7]="information7";
				picture[8]="information8";
				picture[9]="information9";
				picture[10]="information10";
				picture[11]="information11";
				picture[12]="information12";
				picture[13]="information13";
				picture[14]="information14";
				picture[15]="information15";
				picture[16]="information16";
				picture[17]="information17";
				picture[18]="information18";
				picture[19]="information19";
				info[0]="台積館大樓挑空區域上方的媒嫁科技成為附近景觀的亮點，遠眺時那耀眼的紅立方體、藍錐體、圓管、與圓球塑造出優雅浪漫的線條，也彷彿如法國新興市鎮的都會空間軸線潛移默化地改善環境氣質。世界知名藝術家新宮晉精準地掌握機械動力的原理，新宮晉在動力雕塑（Kinetic Sculpture）這塊領域是將動態的藝術品發揮得淋漓盡致，他擅長於藝術作品中結合機械原理、自然動力與藝術思維，藉著風、水、光影，進而使作品與環境優雅地對話，展現大自然風華。";
				info[1]="這是日本藝術家新宮晉在2007年11月初設置，這件名為「無聲的對話」大型動能雕刻，位於校園中樞地點的美麗山丘上。環繞其外的是灰色基調的人文社會學院，白色的生命科學院，與通往清華大學台積館的新校園道路。";
				info[2]="藝術家楊尊智先生規劃整體公共藝術塑造與動線配置，黑子白子共為一體、虛與實合而為一的奕園入口意象獲得各界好評，進入奕園時見到黑子造型，待周遊一趟，離開時，又見一粒純白嶄新的棋子，奕園入口以不銹鋼蝕刻呈現樸實字體，題字為沈校長好友金庸先生所書，順勢接著中、日、韓等六位國際圍棋大師的說明立牌，包括每人之書法、經典棋局與生平，個個都是山頭的氣勢隱然成形，依序為吳清源「中和」、木谷實「仁風」、林海峰「玄妙」、陳祖德「超越自我」、曹薰鉉「無心」和聶衛平的「冲天」。一路上水溝蓋上石版錯落著圍棋界奉為金科玉律《圍棋十訣》：不得貪勝、入界宜緩、攻彼顧我、棄子爭先、捨小就大、逢危須棄、慎勿輕速、動須相應、彼強自保、勢孤取和。木製欄杆上的圍棋概念及規則是良好的基本圍棋教育，熟悉此九法便可對弈。";
				info[3]="操場爬竿旁「昇華」表現出景觀雕塑的磅礡意念，拔地而起的驚心動魄氣勢，尤其是山壁紋路的銳勁與奔放，是景觀雕塑家闡釋台灣地理現象的特殊風格。";
				info[4]="2013年清華大學校園增添清齋公共藝術，清齋公共藝術恰巧位於宿舍整體區域的核心廣場空間，此件由楊智富設計與玻璃藝術家郭原森共同建造的公共藝術，由四片彩繪鋼構作品為主體，係衍生自楊智富庭園計畫系列粉塵沾染概念，彷彿是對世界各地前來的莘莘學子展開歡迎之姿，欣賞者感受到藝術家所模塑的色溫與色系，人可挪移至某定點而體認三片彩繪鋼構色塊交融合而為一的感受，藝術家將實驗性的藝術形態帶入整體空間，因而當下的意識流動重塑每次交接撞擊的藝術語彙，觀眾也成了創作變奏元素，經過藝術語彙辯證與想像的過程而能有所啟悟，師生民眾徜徉體驗藝術揮灑的能量、無限的想像與思辯能力。";
				info[5]="藝術家高燦興駐校後捐贈放置於總圖前的雕塑作品「痕」，質感剛柔並濟，手焊處理塊面優雅細膩，造形虛實相演，既深沈又浪漫。藝術場域均可在校園藝術文化地圖中按圖索驥，藝術地圖囊括所有公共藝術地點及校園藝術場域，原是為嘉惠校園師生而製作，無心插柳也成為他校製作藝術地圖或集體創作的藍本，也有民眾跨國索取，折疊後僅巴掌大的地圖意義非凡。我總是喜歡說公共藝術所提供給民眾的美學觀點是多樣化的，不管你對眼前公共藝術是讚賞抑或是批判，它激起民眾對環境的注目、關懷、參與，並有深刻的互動與對話。";
				info[6]="藝術家王存武先生創作的「清鏡」是台灣早期公共藝術示範案例之一，建置費用來自文建會規劃全國公共藝術示範計畫的節餘款項。位於鴿子廣場的清鏡門、天鏡、人鏡、地影與民眾互動的方式巧妙各有不同，清華人路經人鏡，可借鏡瞥見自然環境中自我身影，此非梳妝鏡中的鏡像，耐人尋味。素黑的地鏡提供學生、民眾留言抑或彩繪的畫板，地影自然成了最受歡迎的親子空間，常常看到許多小朋友蹲在地上塗鴉，清鏡地影堪稱最能實踐民眾參與的公共藝術園地。";
				info[7]="北京清華的二校門是清朝皇家園林「小五爺園」的宮門，也是北京清華最早的校門。「清華園」三個大字刻於中間拱門之上，字體渾圓飽滿。因後來新建校門，此門便被稱為二校門。在行政大樓後方，有座以等比例縮小的二校門，用以表示兩校之間的一脈相承。";
				info[8]="我是大禮堂";
				info[9]="人工開鑿的成功湖，湖面廣闊，有小橋通往湖心亭，岸旁楊柳依依，偶有一、二白鷺飛來，點綴碧水綠皮，景致生動迷人。昆明湖小巧精緻，湖面荷葉田田，對岸是繁花綠叢的九重葛花廊，亦自成趣味。為紀念梅貽琦校長而闢的梅園，種植400多株海樹，每屆冬盡春來，滿園梅花霜白耀眼，是清大著名的一景。新校區梅谷是人文學院所在地，相思湖即坐落其中，湖畔挺立的孟宗竹與湖面低翔的白鷺鷥，使梅谷有如一幅和諧的山水畫。";
				info[10]="波光粼粼的成功湖湖心處有座中國式涼亭，因位處湖心故通稱「湖心亭」。但此亭早在1986年命名為「寄梅亭」，係校友胡光麃用以紀念早期校長－周貽春先生（字寄梅）。而連接湖岸與湖心亭間的橋於1965年建立，是1943級校友翟克併為紀念其兄翟克恭〈亦為校友〉，捐贈通往湖心島的橋一座，即為「克恭橋」。";
				info[11]="「鳳凰」位於大禮堂前方草坪松林旁帶給人們溫馨感人的共同記憶，許多老校友仍定時尋覓其蹤跡，造形雖非圓潤光滑，剛毅堅強的雛鳥造形卻也質樸清新。";
				info[12]="位於第二綜合大樓，目前展覽廳(第二綜合大樓1樓)每年約展出六至八檔展出，主要以臺灣中青輩藝術家的作品為主要目標，特別鼓勵較無機會參與商業畫廊體系的藝術家參展。";
				info[13]="候鳥於天空自由翱翔，倦了歸巢休憩，忽又悠然展翅飛向遠方。本公共藝術作品希望發揮候鳥的豐富意涵，以簡單純淨的雕塑形體，提供清華會館的過客與歸人們一個親切怡然的藝術空間，期望清華會館的使用者們，不僅在此紓解旅途的疲憊，也得到心靈上的舒展。";
				info[14]="是08級學生給學校的一份禮物，經過大家的手，以拼貼馬賽克完成的雕塑群。連接教育館的一樓的展覽廳、日光走廊以及後方的藝術工坊、雕塑教室。位處藝術展覽與創作空間的綠帶上。一般『大人』較少經過這個區域，像是微血管一般分流到這條路徑的行人，多半是學生。點點空間都帶給行路人微妙的驚喜。這個地方有著奇妙的氛圍，跟紐約蘇活區的形成很像。交錯著藝術創作的活力，與邊陲區域的破落，希望這個公園裡能種下溫暖活潑的生命力。";
				info[15]="清大陽光走廊與藝術工坊是位於通識教育中心的側邊與後方的開放性展示空間，幾年前經過清大校方的整理後，歷年來展出過各類型的展覽，是天賦異稟年輕藝術家嘗試戶外開放性展示空間的絕佳場地。";
				info[16]="本校物理系73級校友、辛耘企業股份有限公司謝宏亮董事長，11月1日將個人珍貴的收藏，羅丹的代表作品：「沈思者」巨型銅雕捐贈母校，除作為母校百年校慶的賀禮外，也希望讓自己的收藏成為學弟學妹們的祝福，以及讓校園裡多一些藝術與人文的美。";
				info[17]="日晷的設計在嘗試著體現「自強不息，厚德載物」的清華精神，晷體南北橫向紀錄著太陽的東起日落的運行，即象徵「天行健，君子以自強不息」；晷體本身的厚重更是象徵「地勢坤，君子以厚德載物」。在圓盤上的藍白錯綜的顏色則呈現天空的意象，並強調了日晷與天的關係。在晷體開了一個洞，希望透過這一個洞來窺看東西方世界。";
				info[18]="立法院三讀通過文化藝術獎助條例，在設置辦法尚未通過與執行之前，清大創舉是自動自發執行首件公開徵件公共藝術案例，陳正勳、蕭麗虹與動機系師生合作的「過程」位於校門口工一館入口空間，以新建大樓工程節餘款為經費，首獎由竹圍工作室藝術家奪魁，闡述人生、求學生活、個體互動間的循環關係，由底部大圓盤中的千顆迴力球可衝入蜿蜒至天花板的透明管，再湧向壁面透明管，後落至地面回流至大圓盤中，過程週而復始。近20年光陰的作品，內部機械裝置老化，動力循環過程經細心維護至今仍可以運作。";
				info[19]="清大遠在尚未有公共藝術概念之前，七十年代清華便聘請景觀雕塑藝術家楊英風先生規劃校園，幾件景觀雕塑於此時應運而生，兩件為水泥雕塑，藉著質樸至極的媒材，反映出溫文儒雅的清大傳統校風。校門景觀校誌雕塑以簡冊立柱造型有迎納賓客意趣，三層平行排列的水泥主體，中間三道橫線裝飾則類似簡冊的繩線，經過藝術家的巧思設計，校誌巍峨、韌勁有力，意味著跨入學術殿堂的學子，即將開展學習的扉頁。";
				//名
				((TextView)findViewById(R.id.textView1)).setText(name[num]);
				//圖
				ImageView imageView1 = (ImageView) findViewById( R.id.imageView1);
				String uri = "@drawable/";
				uri=uri+picture[num];
				int imageResource = getResources().getIdentifier(uri, null, getPackageName());
				Drawable image = getResources().getDrawable(imageResource);
				imageView1.setImageDrawable(image);
				//資訊
				((TextView)findViewById(R.id.textView2)).setText(info[num]);
			}
		}
	};
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

