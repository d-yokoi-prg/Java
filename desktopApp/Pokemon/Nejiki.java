import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class App extends JFrame{
    private int count = 1;  //勝利数
    private int loop = 0;   //周回数
    private ImageIcon pkmn;
    private String[] path = {"./battleCount/pikachu.png",
    "./battleCount/dodaitosu.png",
    "./battleCount/gokazaru.png",
    "./battleCount/enperuto.png",
    "./battleCount/rucario.png",
    "./battleCount/gaburiasu.png",
    "./battleCount/arceus.png"};
    private JLabel img = new JLabel();
    JPanel jp = new JPanel();
    App(){
        super("ネジキ");
        
        setSize(500, 300);
        setResizable(false);

        // テキスト
        JLabel label = new JLabel("現在" + (loop+1) + "周目、" + count + "戦中");
        label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 32));
        label.setBounds(20, 50, 500, 50);
        jp.add(label);
        // ボタン
        JButton win = new JButton("勝ち");
        JButton lose = new JButton("負け");

        win.setBounds(40, 180, 100, 50);
        lose.setBounds(150, 180, 100, 50);

        // 勝利カウント
        win.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(loop < 7){
                    winCount(label);
                }
            }
        });

        // リセット
        lose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                clearCount(label);
            }
        });

        jp.setLayout(null);
        jp.add(win);
        jp.add(lose);

        pkmn = new ImageIcon(path[0]);
        img.setIcon(pkmn);
        img.setBounds(250, -50, 250, 400);
        jp.add(img);

        add(jp);

        //ウィンドウをデスクトップ上に表示する
        setVisible(true);

        //「×」ボタンで画面を閉じたらアプリケーションを終了する
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void winCount(JLabel jl){
        count++;
        if(count >= 7){
            loop++;
            count = 1;
        }
        // 49勝したらCLEAR
        if(loop+1 == 8){
            jl.setText("Congratulations!");
        }
        else{
            ImageIcon upIcon = new ImageIcon(path[loop]);
            jl.setText("現在" + (loop+1) + "周目、" + count + "戦中");
            img.setIcon(upIcon);
        }
    }
    public void clearCount(JLabel jl){
        loop = 0;
        count = 1;
        ImageIcon upIcon = new ImageIcon(path[loop]);
        jl.setText("現在" + (loop+1) + "周目、" + count + "戦中");
        img.setIcon(upIcon);
    }
}

public class Nejiki {
    public static void main(String[] args){
        App app = new App();
    }
}
