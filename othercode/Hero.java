import java.util.ArrayList;
import java.util.Scanner;

//人間クラス
class Human{
  private String name;   //名前
  String job;    //職業
  int power;     //攻撃力
  int magical;   //魔力
  int speed;     //素早さ
  int defence;   //防御力
  
  //コンストラクタでパラメータを設定
  Human(String n, String j, int p, int m, int s, int d){
      name = n;
      job = j;
      power = p;
      magical = m;
      speed = s;
      defence = d;
  }
  
  public String getName() {
	  return name;
  }
}

//男性クラス
class Man extends Human{
  private String sex = "男";
  Man(String n, String j, int p, int m, int s, int d){
      super(n, j, p, m, s, d);
      System.out.println("この人は男性です");
  }
}

//女性クラス
class Woman extends Human{
  private String sex = "女";
  Woman(String n, String j, int p, int m, int s, int d){
      super(n, j, p, m, s, d);
      System.out.println("この人は女性です");
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
    		  System.out.println("名前 性別 職業 攻撃力(数字) 魔力(数字) 素早さ(数字) 防御力(数字)");
    	  }
    	  String name = sc.next();
          String sex = sc.next();
          String job = sc.next();
          int power = sc.nextInt();
          int magical = sc.nextInt();
          int speed = sc.nextInt();
          int defence = sc.nextInt();
          if(sex.equals("男")){
              party.add(new Man(name, job, power, magical, speed, defence));
          }
          else if(sex.equals("女")){ 
              party.add(new Woman(name, job, power, magical, speed, defence));
          }
          else{
          }

      }
      for(int i = 0; i < party.size(); i++) {
    	  System.out.println(party.get(i).getName() + "は"+ party.get(i).job);
    	  System.out.println("攻撃力：" + party.get(i).power);
    	  System.out.println("魔力：" + party.get(i).magical);
    	  System.out.println("素早さ" + party.get(i).speed);
    	  System.out.println("防御力" + party.get(i).defence);
    	  System.out.println();
      }
  }
}
