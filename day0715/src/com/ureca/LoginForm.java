package com.ureca;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.ureca.DBUtil;

@SuppressWarnings("serial")
public class LoginForm extends JFrame implements ActionListener
{
    public JTextField tf_id;
    public JPasswordField tf_pass;
    public JButton bt_login,bt_join;
	JLabel la_id, la_pass, la_img;

	JFrame serviceFrame;
	DBUtil dbUtil;
	
  public LoginForm()
	{
		dbUtil = DBUtil.getInstance();
		setTitle("Login Form");
		
		tf_id = new JTextField();			  
		tf_pass = new JPasswordField();
		
		bt_login = new JButton("로그인");
		bt_join = new JButton("신규가입");
	
	    la_id = new JLabel("I  D");
		la_pass = new JLabel("Password");
		
		tf_id.setBounds(80,30,100,25);
		tf_pass.setBounds(80,65,100,25);
		bt_login.setBounds(90,110,80,25);
		bt_join.setBounds(190,30,90,25);
		la_id.setBounds(8,30,80,25);
		la_pass.setBounds(8,65,90,25);
		
		setLayout(null);
		add(tf_id);
		add(tf_pass);
		add(bt_login);
		add(bt_join);
		add(la_id);
		add(la_pass);
		
		setBounds(300,200,300,180);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		serviceFrame = new JFrame("서비스화면");
		la_img = new JLabel(new ImageIcon("image/won.jpg"));
		serviceFrame.add(la_img);
		serviceFrame.setBounds(400,200,800,600);


		bt_login.addActionListener(this);
	
	}//생성자   
  
   public void showMsg(String msg) {
      JOptionPane.showMessageDialog(this, msg);
   }
    
   public static void main(String[] args) {
	  new LoginForm();
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌렸티비");
		String id = tf_id.getText();
		String pwd = tf_pass.getText();
		loginProcess(id, pwd);
	}

	public void loginProcess(String id, String pwd) {

		try {
			Connection conn = dbUtil.getConnection();

//			String sql = "select count(*) cnt from member where id='"+id+"' and pwd='"+pwd+"'";
//			Statement stmt = conn.createStatement();

			String sql = "select count(*) cnt from member where id=? and pwd=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // DB니까 1부터 인덱스 시작, id
			pstmt.setString(2, pwd); // password

//			ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs = pstmt.executeQuery(); // DB에 sql 실행 요청, sql문은 이미 보냈으니 안보냄
			rs.next();
//			int cnt = rs.getInt(1);
			int cnt = rs.getInt("cnt");

			if (cnt > 0) {
				showMsg("로그인 성공");
				serviceFrame.setVisible(true);
			} else {
				showMsg("로그인 실패");
			}

			dbUtil.close(rs, pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}
}//LoginForm