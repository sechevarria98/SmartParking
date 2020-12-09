import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Member extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel Welcome;
	private JPanel ReserveParking;
	private JPanel PaymentInfo;
	private JTextField Pm_edit;
	private JTextField Pm_newCC;
	private JTextField Pm_newPA;
	private JTextField RP_hour;
	private JTextField RP_Min;
	private JTextField RV_LicensePlateNumber;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member frame = new Member();
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
	
	public Member() {
		
		setTitle("Parking Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(184, 0, 520, 461);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		onCreateProcess();
		
		//======================== PANELS ========================//
		
		Welcome = new JPanel();
		Welcome.setBackground(Color.WHITE);
		layeredPane.add(Welcome, "name_877158005728800");
		Welcome.setLayout(null);
		
		ReserveParking = new JPanel();
		ReserveParking.setBackground(Color.WHITE);
		layeredPane.add(ReserveParking, "name_877161108177500");
		ReserveParking.setLayout(null);
		
		PaymentInfo = new JPanel();
		PaymentInfo.setBackground(Color.WHITE);
		layeredPane.add(PaymentInfo, "name_877163265377800");
		PaymentInfo.setLayout(null);
		
		JPanel RegisterVehicle = new JPanel();
		RegisterVehicle.setBackground(Color.WHITE);
		layeredPane.add(RegisterVehicle, "name_931208445262400");
		RegisterVehicle.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 520, 32);
		PaymentInfo.add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 520, 32);
		Welcome.add(panel);
		panel.setLayout(null);
		
		JPanel RP_Panel = new JPanel();
		RP_Panel.setLayout(null);
		RP_Panel.setBackground(Color.BLACK);
		RP_Panel.setBounds(0, 0, 520, 32);
		ReserveParking.add(RP_Panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(0, 0, 520, 32);
		RegisterVehicle.add(panel_3);
		
		JPanel addCard = new JPanel();
		addCard.setBackground(Color.WHITE);
		layeredPane.add(addCard, "name_946320695720300");
		addCard.setLayout(null);
		
		JPanel editCard = new JPanel();
		editCard.setBackground(Color.WHITE);
		layeredPane.add(editCard, "name_945667623579800");
		editCard.setLayout(null);
		
		JPanel deleteCard = new JPanel();
		deleteCard.setBackground(Color.WHITE);
		layeredPane.add(deleteCard, "name_947372868425900");
		deleteCard.setLayout(null);
		
		JPanel Pm_AddPanel = new JPanel();
		Pm_AddPanel.setLayout(null);
		Pm_AddPanel.setBackground(Color.BLACK);
		Pm_AddPanel.setBounds(0, 0, 520, 32);
		addCard.add(Pm_AddPanel);
		
		JPanel Pm_SavePanel = new JPanel();
		Pm_SavePanel.setLayout(null);
		Pm_SavePanel.setBackground(Color.BLACK);
		Pm_SavePanel.setBounds(0, 0, 520, 32);
		editCard.add(Pm_SavePanel);
		
		JPanel PM_DeletePanel = new JPanel();
		PM_DeletePanel.setLayout(null);
		PM_DeletePanel.setBackground(Color.BLACK);
		PM_DeletePanel.setBounds(0, 0, 520, 32);
		deleteCard.add(PM_DeletePanel);
		
		
		//======================== END ========================//
		
		//======================== HOME ========================//
		
		JLabel name = new JLabel("");
		name.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		name.setBounds(145, 130, 115, 20);
		Welcome.add(name);
		
		JLabel ID = new JLabel("");
		ID.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		ID.setBounds(145, 88, 115, 20);
		Welcome.add(ID);
		
		//======================== END ========================//
		
		
		//======================== IMPORTANT LABLES ========================//
	
		JLabel UserNamelbl = new JLabel(userName);
		UserNamelbl.setForeground(Color.WHITE);
		UserNamelbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		UserNamelbl.setBounds(69, 11, 105, 14);
		panel.add(UserNamelbl);
		
		JLabel UserNamelbl_1 = new JLabel(userName);
		UserNamelbl_1.setForeground(Color.WHITE);
		UserNamelbl_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		UserNamelbl_1.setBounds(73, 11, 105, 14);
		RP_Panel.add(UserNamelbl_1);

		JLabel UserNamelbl_2 = new JLabel(userName);
		UserNamelbl_2.setForeground(Color.WHITE);
		UserNamelbl_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		UserNamelbl_2.setBounds(75, 11, 105, 14);
		panel_2.add(UserNamelbl_2);
		
		JLabel UserNamelbl_3 = new JLabel(userName);
		UserNamelbl_3.setForeground(Color.WHITE);
		UserNamelbl_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		UserNamelbl_3.setBounds(73, 11, 105, 14);
		panel_3.add(UserNamelbl_3);
		
		JLabel UserNamelbl_4 = new JLabel(userName);
		UserNamelbl_4.setForeground(Color.WHITE);
		UserNamelbl_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		UserNamelbl_4.setBounds(71, 11, 105, 14);
		Pm_AddPanel.add(UserNamelbl_4);
		
		JLabel UserNamelbl_5 = new JLabel(userName);
		UserNamelbl_5.setForeground(Color.WHITE);
		UserNamelbl_5.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		UserNamelbl_5.setBounds(74, 11, 105, 14);
		Pm_SavePanel.add(UserNamelbl_5);
		
		JLabel UserNamelbl_6 = new JLabel(userName);
		UserNamelbl_6.setForeground(Color.WHITE);
		UserNamelbl_6.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		UserNamelbl_6.setBounds(71, 11, 105, 14);
		PM_DeletePanel.add(UserNamelbl_6);
		
		JLabel Memberlbl = new JLabel("");
		Memberlbl.setBounds(145, 174, 151, 25);
		Welcome.add(Memberlbl);
		Memberlbl.setForeground(Color.BLACK);
		Memberlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		
		JLabel addresslbl = new JLabel("");
		addresslbl.setForeground(Color.BLACK);
		addresslbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		addresslbl.setBounds(145, 230, 151, 25);
		Welcome.add(addresslbl);
		
		//======================== END ========================//

		//======================== MISC. LABELS ========================//
		
		JLabel RP_VehicleDetailslbl = new JLabel("License Plate");
		RP_VehicleDetailslbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_VehicleDetailslbl.setBounds(10, 51, 129, 28);
		ReserveParking.add(RP_VehicleDetailslbl);
		
		JLabel RP_Paymentlbl = new JLabel("Select Payment Method");
		RP_Paymentlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_Paymentlbl.setBounds(10, 123, 189, 28);
		ReserveParking.add(RP_Paymentlbl);
		
		JLabel RP_Lotlbl = new JLabel("Lot");
		RP_Lotlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_Lotlbl.setBounds(10, 185, 189, 28);
		ReserveParking.add(RP_Lotlbl);
		
		JLabel RP_Datelbl = new JLabel("Date");
		RP_Datelbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_Datelbl.setBounds(10, 248, 189, 28);
		ReserveParking.add(RP_Datelbl);
		
		JLabel RP_AmountTimelbl = new JLabel("Amount of Time");
		RP_AmountTimelbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_AmountTimelbl.setBounds(222, 248, 189, 28);
		ReserveParking.add(RP_AmountTimelbl);
		
		JLabel RP_hrlbl = new JLabel("hrs");
		RP_hrlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_hrlbl.setBounds(270, 282, 24, 28);
		ReserveParking.add(RP_hrlbl);
		
		JLabel RP_Minlbl = new JLabel("min");
		RP_Minlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_Minlbl.setBounds(350, 282, 24, 28);
		ReserveParking.add(RP_Minlbl);
		
		JLabel Pm_SelectCC = new JLabel("Select Credit/Debit Card");
		Pm_SelectCC.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		Pm_SelectCC.setBounds(23, 155, 189, 28);
		editCard.add(Pm_SelectCC);
		
		JLabel Pm_editCC = new JLabel("Credit/Debit Card Number");
		Pm_editCC.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		Pm_editCC.setBounds(23, 236, 189, 28);
		editCard.add(Pm_editCC);
		
		JLabel label_9 = new JLabel("Username:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		label_9.setBounds(10, 11, 66, 14);
		Pm_SavePanel.add(label_9);
		
		JLabel Pm_CClbl = new JLabel("New Credit/Debit Card Number");
		Pm_CClbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		Pm_CClbl.setBounds(62, 129, 200, 28);
		addCard.add(Pm_CClbl);
		
		JLabel Pm_Palbl = new JLabel("Payment Address");
		Pm_Palbl.setHorizontalAlignment(SwingConstants.LEFT);
		Pm_Palbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		Pm_Palbl.setBounds(62, 199, 200, 28);
		addCard.add(Pm_Palbl);
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		label_1.setBounds(10, 11, 66, 14);
		Pm_AddPanel.add(label_1);
		
		JLabel Pm_delCC = new JLabel("Select Credit/Debit Card Number");
		Pm_delCC.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		Pm_delCC.setBounds(38, 139, 189, 28);
		deleteCard.add(Pm_delCC);
		
		JLabel RV_LPNlbl = new JLabel("License Plate Number");
		RV_LPNlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RV_LPNlbl.setBounds(116, 139, 189, 28);
		RegisterVehicle.add(RV_LPNlbl);
		
		JLabel lbl_usr = new JLabel("Username:");
		lbl_usr.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		lbl_usr.setForeground(Color.WHITE);
		lbl_usr.setBounds(10, 11, 66, 14);
		panel.add(lbl_usr);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		lblName.setBounds(50, 130, 54, 20);
		Welcome.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		lblId.setBounds(50, 88, 54, 20);
		Welcome.add(lblId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 117, 283, 2);
		Welcome.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(39, 161, 283, 2);
		Welcome.add(separator_1);
		
		JLabel memberlbl = new JLabel("Membership");
		memberlbl.setBounds(49, 174, 96, 25);
		Welcome.add(memberlbl);
		memberlbl.setForeground(Color.BLACK);
		memberlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(39, 210, 283, 2);
		Welcome.add(separator_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		lblAddress.setBounds(50, 223, 96, 25);
		Welcome.add(lblAddress);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(39, 259, 283, 2);
		Welcome.add(separator_3);
	
		JLabel label = new JLabel("Username:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		label.setBounds(10, 11, 66, 14);
		RP_Panel.add(label);
		
		JLabel label_4 = new JLabel("Username:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		label_4.setBounds(10, 11, 66, 14);
		panel_2.add(label_4);
		
		JLabel label_8 = new JLabel("Username:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		label_8.setBounds(10, 11, 66, 14);
		panel_3.add(label_8);
		
		JLabel label_14 = new JLabel("Username:");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		label_14.setBounds(10, 11, 66, 14);
		PM_DeletePanel.add(label_14);
		
		//======================== END ========================//
		
		//======================== NAV BAR ========================//
		
		JLabel home = new JLabel(" Home");
		home.setBackground(Color.DARK_GRAY);
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Welcome);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		home.setForeground(Color.WHITE);
		home.setFont(new Font("Monospaced", Font.BOLD, 17));
		home.setBounds(0, 96, 184, 40);
		contentPane.add(home);
		
		JLabel reserve = new JLabel("Reserve Parking");
		reserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(ReserveParking);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		reserve.setForeground(Color.WHITE);
		reserve.setFont(new Font("Monospaced", Font.BOLD, 17));
		reserve.setBounds(10, 147, 164, 40);
		contentPane.add(reserve);
		
		JLabel payment = new JLabel("Payment Methods");
		payment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		payment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(PaymentInfo);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		payment.setForeground(Color.WHITE);
		payment.setFont(new Font("Monospaced", Font.BOLD, 17));
		payment.setBounds(10, 196, 164, 40);
		contentPane.add(payment);
		
		JLabel logout = new JLabel("Logout");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("Monospaced", Font.BOLD, 17));
		logout.setBounds(10, 298, 164, 40);
		contentPane.add(logout);
		
		JLabel lblRegisterVehicle = new JLabel("License Plate");
		lblRegisterVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(RegisterVehicle);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		lblRegisterVehicle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegisterVehicle.setForeground(Color.WHITE);
		lblRegisterVehicle.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblRegisterVehicle.setBounds(10, 247, 164, 40);
		contentPane.add(lblRegisterVehicle);
		
		JLabel BecomeMemberlbl = new JLabel("Become a Member!");
		BecomeMemberlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				becomeMember();
			}
		});
		BecomeMemberlbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BecomeMemberlbl.setForeground(Color.WHITE);
		BecomeMemberlbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		panel.add(BecomeMemberlbl);
		
		//======================== END ========================//
		
		//======================== RESERVE PARKING SCREEN ========================//
		
		JDateChooser RP_DateChooser = new JDateChooser();
		RP_DateChooser.setBounds(10, 287, 189, 20);
		ReserveParking.add(RP_DateChooser);
		
		JComboBox<String> RP_Lot = new JComboBox<String>();
		RP_Lot.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		RP_Lot.setModel(new DefaultComboBoxModel<String>(new String[] {"Parking Lot A", "Parking Lot B", "Parking Lot C"}));
		RP_Lot.setBackground(Color.WHITE);
		RP_Lot.setBounds(10, 210, 334, 22);
		ReserveParking.add(RP_Lot);
		
		JComboBox<String> RP_Licenseplate = new JComboBox<String>();
		RP_Licenseplate.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		RP_Licenseplate.setBackground(Color.WHITE);
		RP_Licenseplate.setBounds(10, 76, 334, 22);
		ReserveParking.add(RP_Licenseplate);
		
		JComboBox<String> RP_PaymentMethods = new JComboBox<String>();
		RP_PaymentMethods.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		RP_PaymentMethods.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		RP_PaymentMethods.setBackground(Color.WHITE);
		RP_PaymentMethods.setBounds(10, 152, 334, 22);
		ReserveParking.add(RP_PaymentMethods);
		
		RP_hour = new JTextField();
		RP_hour.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		RP_hour.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		RP_hour.setHorizontalAlignment(SwingConstants.TRAILING);
		RP_hour.setBounds(222, 287, 45, 20);
		ReserveParking.add(RP_hour);
		RP_hour.setColumns(10);
		
		RP_Min = new JTextField();
		RP_Min.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		RP_Min.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		RP_Min.setHorizontalAlignment(SwingConstants.TRAILING);
		RP_Min.setColumns(10);
		RP_Min.setBounds(299, 287, 45, 20);
		ReserveParking.add(RP_Min);
		
		JButton RP_ReserveBtn = new JButton("Reserve");
		RP_ReserveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp_license_number = RP_Licenseplate.getSelectedItem.toString();
				String temp_date = RP_DateChooser.getDate.toString();
				int temp_hour = RP_hour.getText();
				int temp_min = RP_Min.getText();
				String temp_lot = RP_Lot.getSelectedItem().toString();

				revserveSpace(temp_license_number, temp_date, temp_hour, temp_min, temp_lot);
				
			}
		});
		RP_ReserveBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RP_ReserveBtn.setBackground(Color.WHITE);
		RP_ReserveBtn.setBounds(401, 411, 109, 39);
		ReserveParking.add(RP_ReserveBtn);
		
		//======================== END ========================//
		
		//======================== PAYMENT METHODS SCREEN ========================//
		
		JLabel Pm_Add = new JLabel("   Add a Credit/Debit Card");
		Pm_Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(addCard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		Pm_Add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Pm_Add.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		Pm_Add.setForeground(Color.WHITE);
		Pm_Add.setBackground(Color.BLACK);
		Pm_Add.setOpaque(true);
		Pm_Add.setBounds(122, 145, 245, 45);
		PaymentInfo.add(Pm_Add);
		
		JLabel Pm_Edit = new JLabel("   Edit a Existing Credit/Debit Card");
		Pm_Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(editCard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		Pm_Edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Pm_Edit.setOpaque(true);
		Pm_Edit.setForeground(Color.WHITE);
		Pm_Edit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		Pm_Edit.setBackground(Color.BLACK);
		Pm_Edit.setBounds(122, 198, 245, 45);
		PaymentInfo.add(Pm_Edit);
		
		JLabel Pm_Del = new JLabel("   Delete a Existing Credit/Debit Card");
		Pm_Del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(deleteCard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		Pm_Del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Pm_Del.setOpaque(true);
		Pm_Del.setForeground(Color.WHITE);
		Pm_Del.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		Pm_Del.setBackground(Color.BLACK);
		Pm_Del.setBounds(122, 254, 245, 45);
		PaymentInfo.add(Pm_Del);
		
		JComboBox<Long> Pm_ChooseCC = new JComboBox<Long>();
		Pm_ChooseCC.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		Pm_ChooseCC.setBackground(Color.WHITE);
		Pm_ChooseCC.setBounds(23, 187, 334, 22);
		editCard.add(Pm_ChooseCC);
		
		Pm_edit = new JTextField();
		Pm_edit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		Pm_edit.setBackground(Color.WHITE);
		Pm_edit.setBounds(23, 267, 200, 20);
		editCard.add(Pm_edit);
		Pm_edit.setColumns(10);
		
		JButton Pm_SaveBtn = new JButton("Save");
		Pm_SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tmp_credit_card = Pm_edit.getText();
				String tmp_update_card = Pm_ChooseCC.getSelectedItem.toString;

				updateCard(tmp_credit_card, tmp_update_card);
			}
		});
		Pm_SaveBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		Pm_SaveBtn.setBackground(Color.WHITE);
		Pm_SaveBtn.setBounds(23, 320, 334, 37);
		editCard.add(Pm_SaveBtn);
		
		Pm_newCC = new JTextField();
		Pm_newCC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		Pm_newCC.setColumns(10);
		Pm_newCC.setBackground(Color.WHITE);
		Pm_newCC.setBounds(62, 168, 243, 20);
		addCard.add(Pm_newCC);
		
		Pm_newPA = new JTextField();
		Pm_newPA.setColumns(10);
		Pm_newPA.setBackground(Color.WHITE);
		Pm_newPA.setBounds(62, 238, 243, 20);
		addCard.add(Pm_newPA);
		
		JButton Pm_addBtn = new JButton("Add");
		Pm_addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String new_credit_card = Pm_newCC.getText();
				String new_payment_address = Pm_newPA.getText();
				addcreditcard(new_credit_card, new_payment_address);
			}
		});
		Pm_addBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		Pm_addBtn.setBackground(Color.WHITE);
		Pm_addBtn.setBounds(62, 297, 243, 37);
		addCard.add(Pm_addBtn);
		
		JComboBox<Long> Pm_ChooseDelCC = new JComboBox<Long>();
		Pm_ChooseDelCC.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		Pm_ChooseDelCC.setBackground(Color.WHITE);
		Pm_ChooseDelCC.setBounds(38, 178, 334, 22);
		deleteCard.add(Pm_ChooseDelCC);
		
		JButton Pm_DelBtn = new JButton("Delete");
		Pm_DelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chosen_card = Pm_ChooseDelCC.getSelectedItem().toString();
				deleteChosenCard(chosen_card);
			}
		});
		Pm_DelBtn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		Pm_DelBtn.setBackground(Color.WHITE);
		Pm_DelBtn.setBounds(38, 248, 334, 37);
		deleteCard.add(Pm_DelBtn);

		//======================== END ========================//
		
		//======================== REGISTER LICENSE SCREEN ========================//
		
		RV_LicensePlateNumber = new JTextField();
		RV_LicensePlateNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		RV_LicensePlateNumber.setColumns(10);
		RV_LicensePlateNumber.setBackground(Color.WHITE);
		RV_LicensePlateNumber.setBounds(116, 178, 200, 20);
		RegisterVehicle.add(RV_LicensePlateNumber);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Permanent", "Temporary"}));
		comboBox.setBackground(Color.WHITE);
		RegisterVehicle.add(comboBox);
		
		JLabel lblLicenseType = new JLabel("License Type");
		lblLicenseType.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RegisterVehicle.add(lblLicenseType);
		
		JLabel lblUpgradingToMember = new JLabel("Upgrading to member allows you");
		lblUpgradingToMember.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RegisterVehicle.add(lblUpgradingToMember);
		
		JLabel lblToAddA = new JLabel("to add a temporary plate");
		lblToAddA.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		RegisterVehicle.add(lblToAddA);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp_license_number = RV_LicensePlateNumber.getText.toString();
				registerLicenseNumber(temp_license_number);
			}
		});
		btnRegister.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(227, 299, 89, 37);
		RegisterVehicle.add(btnRegister);
		
		//======================== END ========================//
		
	}

	private void onCreateProcess() 
	{
		String membership_type = null;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			
			String query = "Select * from userlogin, customer\r\n" + 
					"Where userlogin.id = customer.id\r\n" + 
					"And username = '" + userName +"'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			while(r.next()) {
				
				membership_type = r.getString("mem_type");
				ID.setText(r.getString("id"));
				name.setText(r.getString("name"));
				Memberlbl.setText(r.getString("mem_type"));
				addresslbl.setText(r.getString("payment_address"));
				Pm_ChooseDelCC.addItem(r.getLong("credit_card"));
				Pm_ChooseCC.addItem(r.getLong("credit_card"));
			}
			
			differentiateMembership();

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	private void differentiateMembership()
	{
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			
			String query = "";
			if(membership_type.equals("Member")) {
				query = 	"SELECT * FROM customer,  userLogin, member\r\n" + 
						"WHERE userLogin.id = customer.id\r\n" + 
						"AND userLogin.id = member.id\r\n" +
						"AND username = '" + userName + "'";
				
				Statement s = conn.createStatement();
				ResultSet r = s.executeQuery(query);
				while(r.next()) {
					String cc = r.getString("credit_card");
					String cc_1 = "";
					if (cc.length() > 4) {
						cc_1 = cc.substring(cc.length() - 4);
					}
					else {
						cc_1 = cc;
					}
					RP_PaymentMethods.addItem("Visa ending in " + cc_1);
					RP_Licenseplate.addItem(r.getString("license_number"));
					RP_Licenseplate.addItem(r.getString("tempplate1"));
					RP_Licenseplate.addItem(r.getString("tempplate2"));
				}
			}
			else {
				query = 	"SELECT * FROM customer,  userLogin\r\n" + 
						"WHERE userLogin.id = customer.id\r\n" + 
						"AND username = '" + userName + "'";
				
				Statement s = conn.createStatement();
				ResultSet r = s.executeQuery(query);
				while(r.next()) {
					String cc = r.getString("credit_card");
					String cc_1 = "";
					if (cc.length() > 4) {
						cc_1 = cc.substring(cc.length() - 4);
					}
					else {
						cc_1 = cc;
					}
					RP_PaymentMethods.addItem("Visa ending in " + cc_1);
					RP_Licenseplate.addItem(r.getString("license_number"));
				}
			}

			creationProccess();
				
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private void becomeMember()
	{
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			String select_all_query = "SELECT * FROM customer, userLogin\r\n" + 
							"WHERE customer.id = userLogin.id\r\n" + 
							"AND username = '" + userName + "'";

			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(select_all_query);
			
			while(r.next()) {
				int id = r.getInt("id");
				
				String update_query = "UPDATE userLogin SET mem_type = 'Member'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(update_query);
				
				String insert_query = "INSERT INTO member(id) Values(" + id + ")";	
				JOptionPane.showMessageDialog(null, "Thank You, " + userName + " for becoming a member");
				
				Statement st = conn.createStatement();
				st.executeQuery(insert_query);
				
			}
			
		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}

	private void revserveSpace(String tmp_license, String tmp_date, String tmp_hour, String tmp_min, String tmp_lot)
	{
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			String update_query = null;
			String select_query = null;
			if (tmp_lot.equals("Parking Lot A")) {
				
				select_query = "SELECT * FROM parkinglotA";
				
				Statement st = conn.createStatement();
				ResultSet r = st.executeQuery(select_query);
				
				while(r.next()) {
					int parkingspace = r.getInt("parkingspace");
					if (parkingspace < 5) {
						update_query = "UPDATE ParkingLotA\r\n" + 
								"SET parkingspace = parkingspace + 1,\r\n" + 
								"	license_number = '" + tmp_license + "',\r\n" + 
								"	reservation_date = '" + tmp_date + "',\r\n" + 
								"	reservation_hour = " + tmp_hour + ",\r\n" + 
								"	reservation_minutes = " + tmp_min + "";
						JOptionPane.showMessageDialog(null, "Parking Space reserved");
					}
					else {
						JOptionPane.showMessageDialog(null, "Parking Lot A is full");
					}
				}
				
			}
			else if (tmp_lot.equals("Parking Lot B")) {
				select_query = "SELECT * FROM parkinglotB";
				
				Statement st = conn.createStatement();
				ResultSet r = st.executeQuery(select_query);
				
				while(r.next()) {
					int parkingspace = r.getInt("parkingspace");
					if (parkingspace < 5) {
						update_query = "UPDATE ParkingLotB\r\n" + 
								"SET parkingspace = parkingspace + 1,\r\n" + 
								"	license_number = '" + tmp_license + "',\r\n" + 
								"	reservation_date = '" + tmp_date + "',\r\n" + 
								"	reservation_hour = " + tmp_hour + ",\r\n" + 
								"	reservation_minutes = " + tmp_min + "";
						JOptionPane.showMessageDialog(null, "Parking Space reserved");

					}
					else {
						JOptionPane.showMessageDialog(null, "Parking Lot B is full");
					}
				}
			}
			else if (tmp_lot.equals("Parking Lot C")) {
				select_query = "SELECT * FROM parkinglotC";
				
				Statement st = conn.createStatement();
				ResultSet r = st.executeQuery(select_query);
				
				while(r.next()) {
					int parkingspace = r.getInt("parkingspace");
					if (parkingspace < 5) {
						update_query = "UPDATE ParkingLotC\r\n" + 
								"SET parkingspace = parkingspace + 1,\r\n" + 
								"	license_number = '" + tmp_license + "',\r\n" + 
								"	reservation_date = '" + tmp_date + "',\r\n" + 
								"	reservation_hour = " + tmp_hour + ",\r\n" + 
								"	reservation_minutes = " + tmp_min + "";
						JOptionPane.showMessageDialog(null, "Parking Space reserved");
					}
					else {
						JOptionPane.showMessageDialog(null, "Parking Lot C is full");
					}
				}
			}	
			
			Statement s = conn.createStatement();
			s.executeUpdateupdate_query);
			
			
		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}

	private void updateCard(String tmp_cc, String which_card)
	{
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			String query = 	"SELECT * FROM customer, userLogin\r\n" + 
							"WHERE customer.id = userLogin.id\r\n" + 
							"AND username = '" + userName + "'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			
			while(r.next()) {
				String query_1 = 	"Update Customer Set credit_card = " + temp_cc + "\r\n" + 
									"WHERE credit_card = " + which_card + "\r\n" + "";
				
				Statement st = conn.createStatement();
				st.executeUpdate(query_1);
				
				
				Pm_edit.setText("");
				JOptionPane.showMessageDialog(null, "Credit/Debit Card has been edited");
			}
			
		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}

	private void addcreditcard(String tmp_card, String tmp_payment_address)
	{
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			String query = 	"SELECT * FROM customer, userLogin\r\n" + 
							"WHERE customer.id = userLogin.id\r\n" + 
							"AND username = '" + userName + "'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			
			while(r.next()) {
				int id = r.getInt("id");
				String license = r.getString("license_number");
				String query_1 = "INSERT INTO customer (id, credit_card, payment_address, license_number)\r\n" + 
									"VALUES(" + id + ", " +  tmp_card  + ", '" + tmp_payment_address + "', '" + license +"')";
				
				Pm_newCC.setText("");
				Pm_newPA.setText("");
				JOptionPane.showMessageDialog(null, "Credit/Debit Card has been added");
				
				Statement st = conn.createStatement();
				st.executeQuery(query_1);
				
			}
			
		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}

	private void deleteChosenCard(String tmp_card)
	{
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			String query = 	"SELECT * FROM customer, userLogin\r\n" + 
							"WHERE customer.id = userLogin.id\r\n" + 
							"AND username = '" + userName + "'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			
			while(r.next()) {
				String LN = r.getString("license_number");
				String query_1 = 	"DELETE FROM customer\r\n" + 
									"WHERE credit_card = " + tmp_card;
				
				JOptionPane.showMessageDialog(null, "Credit/Debit Card has been deleted");
				Statement st = conn.createStatement();
				st.executeQuery(query_1);
			
			}
			
		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}

	private void creationProccess()
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			
			String query = "SELECT * FROM userLogin WHERE username = '" + userName + "'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			while(r.next()) {
				String membership = r.getString("mem_type");
				if (membership.equals("Non-member")) {
					lblUpgradingToMember.setBounds(116, 218, 200, 32);
					lblToAddA.setBounds(116, 249, 200, 32);
					BecomeMemberlbl.setBounds(372, 11, 112, 14);
				}
				else if (membership.equals("Member")) {
					comboBox.setBounds(116, 229, 200, 22);
					lblLicenseType.setBounds(116, 199, 189, 28);
				}
			}
			
		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}

	private void registerLicenseNumber(String tmp_license) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
					
			String query = "SELECT * FROM userLogin WHERE username = '" + userName + "'";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			while(r.next()) {
				int id = r.getInt("id");
				String membership = r.getString("mem_type");
				if (membership.equals("Non-member")) {
					String query_3 = "UPDATE customer SET license_number = '" + tmp_license + "'\r\n" + 
							"WHERE id = " + id + "";

					Statement stmt = conn.createStatement();
					stmt.executeUpdate(query_3);
					
					JOptionPane.showMessageDialog(null, "Permanent Plate added");

				}
				else if (membership.equals("Member")) {
					
					if (comboBox.getSelectedItem().toString().equals("Temporary")) {
						String query_1 = "UPDATE member SET tempplate1 = '" + tmp_license + "'\r\n" + 
									"WHERE id = " + id + "";
						
						Statement st = conn.createStatement();
						st.executeUpdate(query_1);
						
						JOptionPane.showMessageDialog(null, "Temp Plate added");
					}
					else if (comboBox.getSelectedItem().toString().equals("Permanent")) {
						String query_2 = "UPDATE customer SET license_number = '" + tmp_license + "'\r\n" + 
								"WHERE id = " + id + "";

						Statement stmt = conn.createStatement();
						stmt.executeUpdate(query_2);
						
						JOptionPane.showMessageDialog(null, "Permanent Plate added");

					}
					
				}
			}
			
		}catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}
}
