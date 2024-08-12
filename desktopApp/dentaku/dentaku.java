import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Desktop extends JFrame{
	private ArrayList<Integer> number = new ArrayList<>();	//計算用
	private String[] kigo = {"＋", "－", "×", "÷"};
	private String keisan = "";
	Desktop(String s){
		//スーパークラスのコンストラクタでタイトルを設定
		super(s);
		
		//デスクトップのサイズを設定
		setSize(250, 300);
		
		//サイズを固定する
		//setResizable(false);
		
		//デスクトップを表示する
		setVisible(true);
		
		//数値を表示
		JLabel result = new JLabel("0");
		result.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 32));
		result.setBounds(0, -30, 500, 100);

		
		//数字のボタンを設定
		JButton[] numBtm = new JButton[10];
		for(int i = 0; i <= 9; i++) {
			numBtm[i] = new JButton(String.valueOf(i+1));
			if(i == 9) {
				numBtm[i] = new JButton(String.valueOf(0));
			}
			int ii = i;
			//ボタンが押された処理を設定
			numBtm[i].addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e){
					updateNum(numBtm[ii].getText(), result);
	            } 
	        });
		}
		
		//1～9のボタンを設定
		int n = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				numBtm[n].setBounds(50 * j, 50 * (i+1), 50, 50);
				n++;
			}
			
		}
		
		//最下層のボタンを設定
		numBtm[9].setBounds(50, 200, 50, 50);		//0ボタン
		
		//クリアボタン
		JButton clear = new JButton("C");
		clear.setBounds(0, 200, 50, 50);
		clear.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e){
				resetNum(result);
            } 
			
		});
		
		JButton togo = new JButton("=");
		togo.setBounds(100, 200, 50, 50);
		clear.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e){
            } 
			
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(result);
	
		for(int i = 0; i <= 9; i++) {
			panel.add(numBtm[i]);

		}
		panel.add(clear);
		panel.add(togo);
		
		
        //「×」ボタンで画面を閉じたらアプリケーションを終了する
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	    Container contentPane = getContentPane();
	    contentPane.add(panel, BorderLayout.CENTER);
	}
	
	//数字を入力するメソッド
	public void updateNum(String s, JLabel jl) {
		if(jl.getText().equals("0")) {
			jl.setText(s);
		}
		else {
			String ss = jl.getText() + s;
			jl.setText(ss);
		}
	}
	
	//入力された値をリセットするメソッド
	public void resetNum(JLabel jl) {
		jl.setText("0");
	}
	
	//計算するメソッド

}

public class dentaku{
	public static void main(String[] args) {
		Desktop  desktop = new Desktop("電卓");
	}
}
