import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField createUserN;
	private JTextField usr;
	private JLabel createNamelbl;
	private JLabel createUsrNamelbl;
	private JLabel createPasslbl;
	private JLabel lblName;
	private JLabel lblPass;
	private JPasswordField pass;
	private JPasswordField createPass;
	
	
	static String url = "jdbc:postgresql://localhost/Temporary";
	static String user = "postgres";
	static String password = "abc123";
	static String userName = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
		setTitle("Parking Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 315, 427);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*
		 * Labels
		 */
		
		JLabel lblNewLabel = new JLabel("Welcome Back!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setBounds(86, 103, 169, 27);
		panel.add(lblNewLabel);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setForeground(Color.BLACK);
		lblCreateAccount.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCreateAccount.setBounds(432, 98, 175, 27);
		contentPane.add(lblCreateAccount);
		
		lblName = new JLabel("User Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		lblName.setBounds(86, 168, 82, 20);
		panel.add(lblName);
		
		lblPass = new JLabel("Password:");
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		lblPass.setBounds(86, 219, 82, 20);
		panel.add(lblPass);
		
		createNamelbl = new JLabel("Name:");
		createNamelbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		createNamelbl.setBounds(432, 154, 82, 20);
		contentPane.add(createNamelbl);
		
		createUsrNamelbl = new JLabel("User Name:");
		createUsrNamelbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		createUsrNamelbl.setBounds(432, 193, 82, 20);
		contentPane.add(createUsrNamelbl);
		
		createPasslbl = new JLabel("Password:");
		createPasslbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		createPasslbl.setBounds(432, 235, 82, 20);
		contentPane.add(createPasslbl);
		
		/*
		 * End
		 */
		
		/*
		 * Text field
		 */
		
		usr = new JTextField();
		usr.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		usr.setColumns(10);
		usr.setBackground(Color.WHITE);
		usr.setBounds(86, 188, 146, 20);
		panel.add(usr);
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setBounds(432, 173, 146, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		createUserN = new JTextField();
		createUserN.setBackground(Color.WHITE);
		createUserN.setColumns(10);
		createUserN.setBounds(432, 213, 146, 20);
		contentPane.add(createUserN);
		
		pass = new JPasswordField();
		pass.setBackground(Color.WHITE);
		pass.setBounds(86, 240, 146, 20);
		panel.add(pass);
		
		createPass = new JPasswordField();
		createPass.setBackground(Color.WHITE);
		createPass.setBounds(432, 252, 146, 20);
		contentPane.add(createPass);
		
		/*
		 * End
		 */
		
		
		/*
		 * Buttons
		 */
		
		JButton SignUpBtn = new JButton("Sign Up");
		SignUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
					String query = "SELECT * FROM member WHERE username = '" + createUserN.getText() + "'";
					
					Statement s = conn.createStatement();
					ResultSet r = s.executeQuery(query);
					
					if(r.next()) {
						JOptionPane.showMessageDialog(null, "User name already taken");
					}
					else {
						String query_1 = "INSERT INTO member(name, username, password, mem_type) VALUES( '" + name.getText() + "','" + createUserN.getText() + "', '" + createPass.getText() + "', 'member');";
						Statement st = conn.createStatement();
						st.execute(query_1);
						
						name.setText("");
						createUserN.setText("");
						createPass.setText("");
						JOptionPane.showMessageDialog(null, "Account created successfully");
					}
					
				}catch (SQLException ev) {
					System.out.println(ev.getMessage());
				}
			}
		});
		SignUpBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		SignUpBtn.setBackground(Color.WHITE);
		SignUpBtn.setBounds(467, 323, 89, 27);
		contentPane.add(SignUpBtn);
		
		JButton SignInBtn = new JButton("Sign In");
		SignInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
					userName = usr.getText();
					String query = "SELECT * FROM member WHERE username = '" + userName + "'";
					String uPass = pass.getText();
					Statement s = conn.createStatement();
					ResultSet r = s.executeQuery(query);
					
					
					while (r.next()) {
						if (uPass.equals(r.getString("password"))) {
							Member mem = new Member();
							mem.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Username or password is incorrect");
						}
					}
				}catch (SQLException ev) {
					System.out.println(ev.getMessage());
				}
			}
		});
		SignInBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		SignInBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		SignInBtn.setBackground(Color.WHITE);
		SignInBtn.setBounds(116, 284, 89, 27);
		panel.add(SignInBtn);
		
		
		/*
		 * End
		 */
	}
}


