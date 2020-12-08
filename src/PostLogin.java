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
	
	// panels
	private JPanel contentPane;

	// text fields
	private JTextField CreditCard;
	private JTextField PaymentAddress;
	private JTextField LicensePlateNumber;

	// labels
	private JLabel miscLabel
	private JLabel cardLabel
	private JLabel paymentaddressLabel
	private JLabel licensenumberLabel

	// buttons
	private JButton contiueButton
	
	private Login log = new Login();
	private DBLogin lg = new DBLogin();
	private String url = lg.url;
	private String user = lg.user;
	private String password = lg.password;
	private String userName = log.userName;
	private String currentUser = log.currentUser;
	
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
	
	public PostLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//======================== LABELS ========================//

		miscLabel = new JLabel("Just A Few More Steps . . .");
		miscLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		miscLabel.setHorizontalAlignment(SwingConstants.CENTER);
		miscLabel.setBounds(169, 26, 342, 61);
		contentPane.add(miscLabel);

		cardLabel = new JLabel("Enter Credit/Debit Card Number");
		cardLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		cardLabel.setBounds(79, 137, 183, 21);
		contentPane.add(cardLabel);

		paymentaddressLabel = new JLabel("Enter Payment Address");
		paymentaddressLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		paymentaddressLabel.setBounds(79, 208, 183, 21);
		contentPane.add(paymentaddressLabel);
		
		licensenumberLabel = new JLabel("Enter License Plate Number");
		licensenumberLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		licensenumberLabel.setBounds(79, 271, 183, 21);
		contentPane.add(licensenumberLabel);

		//======================== END ========================//

		//======================== Text Fields ========================//
		
		CreditCard = new JTextField();
		CreditCard.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		CreditCard.setBackground(Color.WHITE);
		CreditCard.setBounds(79, 169, 303, 20);
		contentPane.add(CreditCard);
		CreditCard.setColumns(10);
		
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

		//======================== END ========================//

		//======================== Buttons ========================//
		
		contiueButton = new JButton("Next");
		contiueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String credit_card = CreditCard.getText();
				String payment_address = PaymentAddress.getText();
				String license_number = LicensePlateNumber.getText();

				if (temp_cc.length() < 15) {
					JOptionPane.showMessageDialog(null, "credit card length invalid");
					CreditCard.requestFocus();
				} else {
					onContinue(credit_card, payment_address, license_number);
				}
			}
		});
		contiueButton.setBackground(Color.WHITE);
		contiueButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		contiueButton.setBounds(534, 271, 89, 57);
		contentPane.add(contiueButton);

		//======================== END ========================//
	}

	private void onContinue(String temp_cc, String temp_pp, String temp_lp) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			String find_query = "Select * From userLogin WHERE username = '" + currentUser + "'" ;
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(find_query);
			
			while (r.next()) {
				int id = r.getInt("id");
				String insert_query = "INSERT INTO customer (id, credit_card, payment_address, license_number) values (" + id + ", " + temp_cc + ", '" + temp_pp + "', '" + temp_lp + "');\r\n" + "";
				Statement st = conn.createStatement();
				st.execute(insert_query);
			}					
			JOptionPane.showMessageDialog(null, "Account Created Successfully");
			Login log = new Login();
			log.setVisible(true);
			dispose();

		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}

}
