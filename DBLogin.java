import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DBLogin extends JFrame {

	private JPanel contentPane;	
	private JTextField url1;
	private JTextField usr;
	private JPasswordField pass;
	
	static String url;
	static String user;
	static String password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBLogin frame = new DBLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DBLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 332, 442);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		usr = new JTextField();
		usr.setBackground(Color.WHITE);
		usr.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		usr.setBounds(43, 100, 202, 20);
		panel_1.add(usr);
		usr.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		pass.setBackground(Color.WHITE);
		pass.setBounds(43, 181, 202, 20);
		panel_1.add(pass);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblUsername.setBounds(43, 75, 86, 14);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblPassword.setBounds(43, 156, 86, 14);
		panel_1.add(lblPassword);
		
		JLabel lblUrl = new JLabel("Url:");
		lblUrl.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblUrl.setBounds(43, 237, 86, 14);
		panel_1.add(lblUrl);
		
		url1 = new JTextField();
		url1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		url1.setBounds(43, 262, 202, 20);
		panel_1.add(url1);
		url1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ex. postgres");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 10));
		lblNewLabel.setBounds(43, 131, 76, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblExPassword = new JLabel("Ex. password");
		lblExPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 10));
		lblExPassword.setBounds(43, 212, 76, 14);
		panel_1.add(lblExPassword);
		
		JLabel lblEx = new JLabel("Ex. jdbc:postgresql://localhost/OnlineGroceryStore");
		lblEx.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 10));
		lblEx.setBounds(43, 293, 255, 14);
		panel_1.add(lblEx);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				url = url1.getText();
				user = usr.getText();
				password = pass.getText();
				
				try (Connection conn = DriverManager.getConnection(url, user, password)){
					System.out.println("Connected to the PostgreSQL server successfully.");
					
					Login log = new Login();
					log.setVisible(true);
					dispose();
					
				}catch (SQLException ev) {
					System.out.println(ev.getMessage());
			   	}
			}
		});
		btnLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnLogin.setBounds(110, 343, 89, 37);
		panel_1.add(btnLogin);
		
	}	
	
}
