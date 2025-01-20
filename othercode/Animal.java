import java.util.Scanner;

class Animals{
    String name;

    Animals(String n){
        name = n;
    }
    public void Move(int n){
        switch(n){
            case 0:
                System.out.println(name + "は歩く");
                break;
            case 1:
                System.out.println(name + "は走る");
                break;
            case 2:
                System.out.println(name + "は食べる");
                break;
            case 3:
                System.out.println(name + "は寝る");
            case 4:
                Syste.out.println(name + "は泳ぐ");
            default:
                break;
        }
    }
    public void getName(){
        System.out.println(name);
    }
}

class Dog extends Animals{
    Dog(String n){
        super(n);
    }
    public void Move(int n){
        if(n <= 3){
            super.Move(n);
        }
        else{
            switch (n){
                case 5:
                    System.out.println("お手");
                    break;
                case 6:
                    System.out.println("おかわり");
                    break;
                case 7:
                    System.out.println("伏せ");
                    break;
                case 8:
                    System.out.println("お座り");
                default:
                    break;
            }
        }
    }
}

class Cat extends Animals{
    Cat(String s){
        super(s);
    }
    public void Move(int n){
        if(n <= 4){
            super.Move(n);
        }
        else{
            switch (n) {
                case 5:
                    System.out.println("毛つぐろいをする");
                    break;
                case 6:
                    System.out.println("爪を研ぐ");
                case 7:
                    System.out.println("木の上に登る");
                case 8:
                    System.out.println("狭いところに入る");
                default:
                    break;
            }
        }
    }
}

class test{
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        Dog pochi = new Dog("ポチ");
        System.out.print("数字を入力：0～8＞＞");
        int n = sc.nextInt();
        pochi.Move(n);
    }
}
