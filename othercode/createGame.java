import java.util.*;

class Game{
    private String name;
    private String genre;
    private int prise;
    Game(String n, String g, int p){
        name = n;
        genre = g;
        prise = p;
    }
    public String getName(){
        return name;
    }
    public String getGenre(){
        return genre;
    }
    public int getPrise(){
        return prise;
    }

    @override
    public void playFight(){
        System.out.println("遊び方");
    }
}

class Action extends Game{
    Action(String n, int p){
        super(n, "アクション", p);
    }
    public void playFight(){
        System.out.println("キャラクターを動かす");
    }
}

class RPG extends Game{
    RPG(String n, int p){
        super(n, "RPG", p);
    }
    public void playFight(){
        System.out.println("コマンド入力");
    }
}

class Shooting extends Game{
    Shooting(String n, int p){
        super(n, "シューティング", p);
    }
    public void playFight(){
        System.out.println("打つ");
    }
}

public class createGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in, "Shift-JIS");
        int num = sc.nextInt();
        Vector<Game> game = new Vector<>();
        for(int i = 0; i < num; i++){
            String name = sc.next();
            String genre = sc.next();
            int prise = sc.nextInt();

            switch(genre){
                case "アクション":
                    game.add(new Action(name, prise));
                    break;
                case "RPG":
                    game.add(new RPG(name, prise));
                    break;
                case "シューティング":
                    game.add(new Shooting(name, prise));
                    break;
                default:
                    break;
            }
        }
        int n = sc.nextInt();
        int sum = 0;
        game.get(n-1).playFight();

        for(int i = 0; i < game.size(); i++){
            sum = sum + game.get(i).getPrise();
        }
        System.out.println(sum);
    }
}
