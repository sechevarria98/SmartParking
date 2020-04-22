import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField usrC;
	private JTextField passC;
	private JTextField usr;
	private JTextField pass;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblPassword;
	private JLabel label_1;
	private JLabel label_2;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 315, 427);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Back!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setBounds(86, 144, 169, 27);
		panel.add(lblNewLabel);
		
		usr = new JTextField();
		usr.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		usr.setColumns(10);
		usr.setBackground(Color.WHITE);
		usr.setBounds(86, 218, 146, 20);
		panel.add(usr);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBackground(Color.WHITE);
		pass.setBounds(86, 262, 146, 20);
		panel.add(pass);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setForeground(Color.BLACK);
		lblCreateAccount.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCreateAccount.setBounds(432, 98, 175, 27);
		contentPane.add(lblCreateAccount);
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setBounds(432, 173, 146, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		usrC = new JTextField();
		usrC.setBackground(Color.WHITE);
		usrC.setColumns(10);
		usrC.setBounds(432, 213, 146, 20);
		contentPane.add(usrC);
		
		passC = new JTextField();
		passC.setBackground(Color.WHITE);
		passC.setColumns(10);
		passC.setBounds(432, 255, 146, 20);
		contentPane.add(passC);
		
		label_1 = new JLabel("User Name:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		label_1.setBounds(86, 198, 82, 20);
		panel.add(label_1);
		
		label_2 = new JLabel("Password:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		label_2.setBounds(86, 243, 82, 20);
		panel.add(label_2);
		
		JLabel signInBtn = new JLabel("Log In");
		signInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signInBtn.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		signInBtn.setHorizontalAlignment(SwingConstants.CENTER);
		signInBtn.setForeground(Color.WHITE);
		signInBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		signInBtn.setBounds(86, 323, 146, 27);
		panel.add(signInBtn);
		
		lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(432, 154, 82, 20);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("User Name:");
		label.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		label.setBounds(432, 193, 82, 20);
		contentPane.add(label);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblPassword.setBounds(432, 235, 82, 20);
		contentPane.add(lblPassword);
		
		JLabel logInBtn = new JLabel("Sign Up");
		logInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logInBtn.setBackground(new Color(0, 0, 128));
		logInBtn.setOpaque(true);
		logInBtn.setHorizontalAlignment(SwingConstants.CENTER);
		logInBtn.setForeground(Color.WHITE);
		logInBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		logInBtn.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		logInBtn.setBounds(432, 315, 146, 27);
		contentPane.add(logInBtn);
	}
}

