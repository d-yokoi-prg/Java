import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

//デスクトップアプリクラス
class desktopApp extends JFrame{
	
	desktopApp(String title){
		super(title);
		
		//ウィンドウのサイズを設定
		setSize(700, 500);
        //ウィンドウをデスクトップ上に表示する
        setVisible(true);

        //「×」ボタンで画面を閉じたらアプリケーションを終了する
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JLabel updateLabel(JLabel jl){
        return jl;
    }
	//表示するラベルを設定
	public void setParts() {
        //画面上に表示するメッセージ
        JLabel jl = new JLabel("アプリケーション");
        jl.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 32));

        //メッセージの大きさ、表示位置を指定
        jl.setBounds(200, 100, 500, 50);

        //ボタン
        JButton jb = new JButton("Enter");
        
        //クリックされたときのイベント
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                 jl.setText("クリックされました");
            } 
        });
        //ボタンの位置と大きさを指定
        jb.setBounds(250, 250, 100, 30);

        //パネルをを作成し、ラベルとボタンを追加
        JPanel p = new JPanel();
        p.setLayout(null);
        p.add(jl);
        p.add(jb);

	    Container contentPane = getContentPane();
	    contentPane.add(p, BorderLayout.CENTER);
	}

}
public class desktop {
    public static void main(String args[]){

    	//コンストラクタの引数でアプリタイトルを設定
    	desktopApp jf = new desktopApp("Javaアプリケーション");
    	jf.setParts();
    }
}

