import java.util.ArrayList;
import java.util.Scanner;

//人間クラス
class Human{
  private String name;   //名前
  String job;    //職業
  int hp;
  int power;     //攻撃力
  int magical;   //魔力
  int speed;     //素早さ
  int defence;   //防御力
  
  //コンストラクタでパラメータを設定
  Human(String n, String j, int h, int p, int m, int s, int d){
      name = n;
      job = j;
      hp = h;
      power = p;
      magical = m;
      speed = s;
      defence = d;
  }
  
  //職業ごとに使用できるコマンドを表示する
  public void showFightCommand() {
	  System.out.println("攻撃");
	  switch(job){
	  		case  "戦士":
	  			System.out.println("強い攻撃");
	  			break;
	  			
	  		case "魔法使い":
	  			System.out.println("ファイア");
	  			System.out.println("サンダー");
	  			break;
	  		case "僧侶":
	  			System.out.println("回復");
	  			System.out.println("能力低下攻撃");
	  			System.out.println("能力情報行動");
	  			break;
	  		case "盗賊":
	  			System.out.println("盗む");
	  			break;
	  		case "勇者":
	  			System.out.println("回復");
	  			System.out.println("サンダー");
	  		default:
	  			break;
	  }
  }
  
  //名前を取得
  public String getName() {
	  return name;
  }
}

//男性クラス
class Man extends Human{
  private String sex = "男";
  Man(String n, String j, int h, int p, int m, int s, int d){
      super(n, j, h, p, m, s, d);
      System.out.println("この人は男性です");
      
  }
  @Override
  public void showFightCommand() {
	 super.showFightCommand();
	 System.out.println("力を溜める");
  }
}

//女性クラス
class Woman extends Human{
  private String sex = "女";
  Woman(String n, String j, int h, int p, int m, int s, int d){
      super(n, j, h, p, m, s, d);
      System.out.println("この人は女性です");
  }
  @Override
  public void showFightCommand() {
	  super.showFightCommand();
	  System.out.println("アピール");
  }
}

public class Hero {
  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.print("パーティーの人数を入力＞＞");
      int number = sc.nextInt();  //パーティーの人数

      //パーティーメンバー
      ArrayList<Human> party = new ArrayList<>();

      //パーティーメンバーのデータを入力
      for(int i = 0; i < number; i++){
    	  System.out.println("パーティーメンバーの情報を入力（項目間は半額スペース ）");
    	  if(i == 0) {
    		  System.out.println("名前 性別 職業 体力 攻撃力(数字) 魔力(数字) 素早さ(数字) 防御力(数字)");
    	  }
    	  String name = sc.next();
          String sex = sc.next();
          String job = sc.next();
          int hp = sc.nextInt();
          int power = sc.nextInt();
          int magical = sc.nextInt();
          int speed = sc.nextInt();
          int defence = sc.nextInt();
          if(sex.equals("男")){
              party.add(new Man(name, job, hp, power, magical, speed, defence));
          }
          else if(sex.equals("女")){ 
              party.add(new Woman(name, job, hp, power, magical, speed, defence));
          }
          else{
          }

      }
      
      //パーティメンバーのステータスを確認
      for(int i = 0; i < party.size(); i++) {
    	  System.out.println(party.get(i).getName() + "は"+ party.get(i).job);
    	  System.out.println("体力:" + party.get(i).hp);
    	  System.out.println("攻撃力：" + party.get(i).power);
    	  System.out.println("魔力：" + party.get(i).magical);
    	  System.out.println("素早さ" + party.get(i).speed);
    	  System.out.println("防御力" + party.get(i).defence);
    	  System.out.println();
      }
      
      System.out.print("だれのコマンドを確認しますか？");
      String partyMember = sc.next();
      
      //指定したメンバーが使えるコマンドを表示
      for(int i = 0; i < party.size(); i++) {
    	  if(partyMember.equals(party.get(i).getName())) {
    		  party.get(i).showFightCommand();
    	  }
    	  else {
    		  System.out.println("パーティーにはいません");
    	  }
      }
  }
}
