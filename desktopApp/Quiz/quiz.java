import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class appDesktop extends JFrame{
	//出題する問題
	private String[] Question ={"1+1の計算結果は？", "”り”から始まる赤い果物は？", "約1億年前に地球上に存在した大型の生物は？", 
								"ピカチュウは何タイプ？", "ドラえもんは元々何色だった？"};
	//問題に対しての答え
	private String[] Answer = {"2", "りんご", "恐竜", "でんき", "黄色"};
	
	//問題選択用のランダム変数
	private Random rand = new Random();
	private int n = rand.nextInt(Question.length);
	
	//コンストラクタでデスクトップを設定
	appDesktop(String title){
		super(title);
		
		//デスクトップのサイズを指定
		setSize(700, 500);
		
		//デスクトップを画面上に表示
	    setVisible(true);

	    //「×」ボタンで画面を閉じたらアプリケーションを終了する
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //ラベルを表示
		JLabel mondai = new JLabel("問題");
        mondai.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 32));
        mondai.setBounds(200, 100, 500, 50);
        
        //選ばれた問題を表示
        JLabel qu = new JLabel(Question[n]);
        qu.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 32));
        qu.setBounds(200, 120, 1000, 100);
	    
        //テキストフィールドを表示
	    JTextField jf = new JTextField(20);
	    jf.setText("ここに回答を入力");
	    jf.setBounds(200, 200, 200, 30);;
	    
        //正誤判定用のラベルを表示
        JLabel ans = new JLabel();
        ans.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 32));
        ans.setBounds(200, 400, 300, 50);
	    
        //回答送信用のボタンを表示
	    JButton jb = new JButton("回答");
	    
        //クリックされたときのイベント
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	checkAnswer(jf.getText(), ans);
            } 
        });
        //ボタンの位置と大きさを指定
        jb.setBounds(250, 250, 100, 30);
	    
	    JPanel p = new JPanel();
	    p.setLayout(null);
	    
	    p.add(mondai);
	    p.add(qu);
	    p.add(jf);
	    p.add(jb);
	    p.add(ans);
	    
	    Container contentPane = getContentPane();
	    contentPane.add(p, BorderLayout.CENTER);
	    
	}
	
	//回答の正誤判定メソッド
	public void checkAnswer(String s,  JLabel j) {
		if(s.equals(Answer[n])) {
			j.setText("正解");
		}
		else {
			j.setText("不正解");
		}
	}
}

public class quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		appDesktop dt = new appDesktop("超簡易クイズアプリ");
	}

}
