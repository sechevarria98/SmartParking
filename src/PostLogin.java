import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PostLogin extends JFrame {

	private JPanel contentPane;
	private JTextField CreditCard;
	private JTextField PaymentAddress;
	private JTextField LicensePlateNumber;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostLogin frame = new PostLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Login log = new Login();
	DBLogin lg = new DBLogin();
	String url = lg.url;
	String user = lg.user;
	String password = lg.password;
	String userName = log.userName;
	String cUserName = log.cUserName;
	
	public PostLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Just A Few More Steps . . .");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(169, 26, 342, 61);
		contentPane.add(lblNewLabel);
		
		CreditCard = new JTextField();
		CreditCard.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		CreditCard.setBackground(Color.WHITE);
		CreditCard.setBounds(79, 169, 303, 20);
		contentPane.add(CreditCard);
		CreditCard.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Credit/Debit Card Number");
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(79, 137, 183, 21);
		contentPane.add(lblNewLabel_1);
		
		PaymentAddress = new JTextField();
		PaymentAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		PaymentAddress.setBackground(Color.WHITE);
		PaymentAddress.setBounds(79, 240, 303, 20);
		contentPane.add(PaymentAddress);
		PaymentAddress.setColumns(10);
		
		LicensePlateNumber = new JTextField();
		LicensePlateNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		LicensePlateNumber.setBackground(Color.WHITE);
		LicensePlateNumber.setBounds(79, 304, 162, 20);
		contentPane.add(LicensePlateNumber);
		LicensePlateNumber.setColumns(10);
		
		JLabel lblEnterPaymentAddress = new JLabel("Enter Payment Address");
		lblEnterPaymentAddress.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		lblEnterPaymentAddress.setBounds(79, 208, 183, 21);
		contentPane.add(lblEnterPaymentAddress);
		
		JLabel lblEnterLicensePlate = new JLabel("Enter License Plate Number");
		lblEnterLicensePlate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		lblEnterLicensePlate.setBounds(79, 271, 183, 21);
		contentPane.add(lblEnterLicensePlate);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
					String query = "Select * From userLogin WHERE username = '" + cUserName + "'" ;
					
					Statement s = conn.createStatement();
					ResultSet r = s.executeQuery(query);
					
					while (r.next()) {
						int id = r.getInt("id");
						String query_1 = "INSERT INTO customer (id, credit_card, payment_address, license_number) values (" + id + ", " + CreditCard.getText() + ", '" + PaymentAddress.getText() + "', '" + LicensePlateNumber.getText() + "');\r\n" + "";
						Statement st = conn.createStatement();
						st.execute(query_1);
					}					
					
					JOptionPane.showMessageDialog(null, "Account Created Successfully");
					
					Login log = new Login();
					log.setVisible(true);
					dispose();
					
					
				}catch (SQLException ev) {
					System.out.println(ev.getMessage());
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnNewButton.setBounds(534, 271, 89, 57);
		contentPane.add(btnNewButton);
	}

}
