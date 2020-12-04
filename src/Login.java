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
	//Panel
	private JPanel contentPane;

	//Text Fields
	private JTextField nameTextField;
	private JTextField createuserTextField;
	private JTextField userTextField;

	//Labels
	private JLabel nameLabel;
	private JLabel createusernameLabel;
	private JLabel createpasswordLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel createLabel
	private JLabel welcomeLabel

	//Password Fields
	private JPasswordField pass;
	private JPasswordField newPassword;

	
	DBLogin lg = new DBLogin();
	String url = lg.url;
	String user = lg.user;
	String password = lg.password;

	static String currentUser = null;
	private String currentName = null;
	private String currentPassword;

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
		
		//======================== LABELS ========================//
		
		welcomeLabel = new JLabel("Welcome Back!");
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		welcomeLabel.setBounds(86, 103, 169, 27);
		panel.add(welcomeLabel);
		
		createLabel = new JLabel("Create Account");
		createLabel.setForeground(Color.BLACK);
		createLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		createLabel.setBounds(432, 98, 175, 27);
		contentPane.add(createLabel);
		
		usernameLabel = new JLabel("User Name:");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		usernameLabel.setBounds(86, 168, 82, 20);
		panel.add(usernameLabel);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		passwordLabel.setBounds(86, 219, 82, 20);
		panel.add(passwordLabel);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		nameLabel.setBounds(432, 154, 82, 20);
		contentPane.add(nameLabel);
		
		createusernameLabel = new JLabel("User Name:");
		createusernameLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		createusernameLabel.setBounds(432, 193, 82, 20);
		contentPane.add(createusernameLabel);
		
		createpasswordLabel = new JLabel("Password:");
		createpasswordLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		createpasswordLabel.setBounds(432, 235, 82, 20);
		contentPane.add(createpasswordLabel);
		
		//======================== END ========================//
		
		//======================== TEXTFIELDS ========================//
		
		userTextField = new JTextField();
		userTextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		userTextField.setColumns(10);
		userTextField.setBackground(Color.WHITE);
		userTextField.setBounds(86, 188, 146, 20);
		panel.add(userTextField);
		
		nameTextField = new JTextField();
		nameTextField.setBackground(Color.WHITE);
		nameTextField.setBounds(432, 173, 146, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		createuserTextField = new JTextField();
		createuserTextField.setBackground(Color.WHITE);
		createuserTextField.setColumns(10);
		createuserTextField.setBounds(432, 213, 146, 20);
		contentPane.add(createuserTextField);
		
		pass = new JPasswordField();
		pass.setBackground(Color.WHITE);
		pass.setBounds(86, 240, 146, 20);
		panel.add(pass);
		
		newPassword = new JPasswordField();
		newPassword.setBackground(Color.WHITE);
		newPassword.setBounds(432, 252, 146, 20);
		contentPane.add(newPassword);
		
		//======================== END ========================//
		
		
		//======================== BUTTONS ========================//
		
		JButton SignUpBtn = new JButton("Sign Up");
		SignUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentUser = createuserTextField.getText();
				currentPassword = newPassword.getText();
				currentName = nameTextField.getText();
				onSignUp(currentUser, currentPassword, currentName);
			}
		});
		SignUpBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		SignUpBtn.setBackground(Color.WHITE);
		SignUpBtn.setBounds(467, 323, 89, 27);
		contentPane.add(SignUpBtn);
		
		JButton SignInBtn = new JButton("Sign In");
		SignInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentUser = userTextField.getText();
				currentPassword = pass.getText();
				onLogin(currentUser, currentPassword);
			}
		});
		SignInBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		SignInBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		SignInBtn.setBackground(Color.WHITE);
		SignInBtn.setBounds(116, 284, 89, 27);
		panel.add(SignInBtn);
		
		
		//======================== END ========================//
	}

	private void onLogin(String tmp_user, String tmp_pass) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			// query string for DB
			String query = "SELECT * FROM userLogin WHERE username = '" + tmp_user + "'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			
			if(r.next()) {
				// checking if current row column matches the password
				if (tmp_pass.equals(r.getString("password"))) {
					Member mem = new Member();
					mem.setVisible(true);
					dispose();
				}
				else {
					// matched user name in the DB but not the password
					JOptionPane.showMessageDialog(null, "Password is incorrect");
				}
			}
			else {
				// user name wasn't in the database
				JOptionPane.showMessageDialog(null, "Username is incorrect");
			}
		}catch (SQLException err) {
			System.out.println(err.getMessage());
		}
	}

	private void onSignUp(String tmp_user, String tmp_password, , String tmp_name) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			// verify that this username doesen't already exist in the database
			String verify_username_query = "SELECT * FROM userLogin WHERE username = '" + tmp_user + "'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(verify_username_query);
			
			if(r.next()) {
				JOptionPane.showMessageDialog(null, "This username has already been taken.");
				return;
			}

			// reaching this point insert into the database
			String newuser_query = "INSERT INTO userLogin(name, username, password) VALUES( '" + tmp_name + "','" + tmp_user + "', '" + tmp_password + "'" + ");";
			Statement st = conn.createStatement();
			st.execute(newuser_query);
			
			nameTextField.setText("");
			createuserTextField.setText("");
			newPassword.setText("");
			
			PostLogin lg = new PostLogin();
			lg.setVisible(true);
			dispose();
			
		}catch (SQLException err) {
			System.out.println(err.getMessage());
		}
	}
}
