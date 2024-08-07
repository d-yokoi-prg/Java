import java.awt.Font;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class desktop {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        //コンストラクタの引数でアプリタイトルを設定
        JFrame jf = new JFrame("Hello World");


        //デスクトップに表示する画面のサイズ（幅、高さ）
        jf.setSize(500, 500);

        //画面上に表示するメッセージ
        JLabel jl = new JLabel("Hello");
        jl.setFont(new Font("MS 明朝", Font.PLAIN, 32));

        //メッセージを画面上部に表示させる
        jl.setVerticalAlignment(JLabel.TOP);
        jf.add(jl);

        //ウィンドウをデスクトップ上に表示する
        jf.setVisible(true);

        //「×」ボタンで画面を閉じたらアプリケーションを終了する
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
