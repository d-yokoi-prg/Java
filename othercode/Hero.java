package javaApp;

import java.util.ArrayList;
import java.util.Scanner;

//人間クラス
class Human{
  String name;
  String job;
  int power;
  int magical;
  int speed;
  int defence;
  Human(String n, String j, int p, int m, int s, int d){
      name = n;
      job = j;
      power = p;
      magical = m;
      speed = s;
      defence = d;
  }
}

//男性クラス
class Man extends Human{
  String sex = "男";
  Man(String n, String j, int p, int m, int s, int d){
      super(n, j, p, m, s, d);
  }
}

//女性クラス
class Woman extends Human{
  String sex = "女";
  Woman(String n, String j, int p, int m, int s, int d){
      super(n, j, p, m, s, d);
  }
}

public class Hero {
  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int number = sc.nextInt();  //パーティーの人数

      //パーティーメンバー
      ArrayList<Human> party = new ArrayList<>();

      //パーティーメンバーのデータを入力
      for(int i = 0; i < number; i++){
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
    	  System.out.println(party.get(i).name + "は"+ party.get(i).job);
    	  System.out.println("攻撃力：" + party.get(i).power);
    	  System.out.println("魔力：" + party.get(i).magical);
    	  System.out.println("素早さ" + party.get(i).speed);
    	  System.out.println("防御力" + party.get(i).defence);
    	  System.out.println();
      }
  }
}
