import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//デスクトップアプリクラス
class desktopApp extends JFrame{
	
	desktopApp(String title){
		super(title);
		
		//ウィンドウのサイズを設定
		setSize(500, 500);
        //ウィンドウをデスクトップ上に表示する
        setVisible(true);

        //「×」ボタンで画面を閉じたらアプリケーションを終了する
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
	//表示するラベルを設定
	public void setLabel() {
        //画面上に表示するメッセージ
        JLabel jl = new JLabel("Hello");
        jl.setFont(new Font("MS 明朝", Font.PLAIN, 32));

        //メッセージを画面上部に表示させる
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setPreferredSize(new Dimension(100, 50));
        
        JPanel p = new JPanel();
        p.add(jl);
		
	    Container contentPane = getContentPane();
	    contentPane.add(p, BorderLayout.CENTER);
	}
}
public class desktop {
    public static void main(String args[]){

    	//コンストラクタの引数でアプリタイトルを設定
    	desktopApp jf = new desktopApp("title");
    	jf.setLabel();
    }
}
