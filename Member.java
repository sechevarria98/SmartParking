import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

public class Member extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel Welcome;
	private JPanel RegisterVehicle;
	private JPanel PaymentInfo;

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
	
	public Member() {
		setTitle("Parking Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(184, 0, 520, 461);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Welcome = new JPanel();
		Welcome.setBackground(Color.ORANGE);
		layeredPane.add(Welcome, "name_877158005728800");
		Welcome.setLayout(null);
		
		RegisterVehicle = new JPanel();
		RegisterVehicle.setBackground(Color.WHITE);
		layeredPane.add(RegisterVehicle, "name_877161108177500");
		RegisterVehicle.setLayout(null);
		
		PaymentInfo = new JPanel();
		PaymentInfo.setBackground(Color.CYAN);
		layeredPane.add(PaymentInfo, "name_877163265377800");
		PaymentInfo.setLayout(null);
		
		/*
		 * Navigation Bar Start
		 */
		JLabel home = new JLabel("Home");
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
		home.setBounds(10, 96, 164, 40);
		contentPane.add(home);
		
		JLabel reserve = new JLabel("Reserve Parking");
		reserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(RegisterVehicle);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		reserve.setForeground(Color.WHITE);
		reserve.setFont(new Font("Monospaced", Font.BOLD, 17));
		reserve.setBounds(10, 147, 164, 40);
		contentPane.add(reserve);
		
		JLabel payment = new JLabel("Payment Methods");
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
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("Monospaced", Font.BOLD, 17));
		logout.setBounds(10, 298, 164, 40);
		contentPane.add(logout);
		
		JLabel lblRegisterVehicle = new JLabel("Register Vehicle");
		lblRegisterVehicle.setForeground(Color.WHITE);
		lblRegisterVehicle.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblRegisterVehicle.setBounds(10, 247, 164, 40);
		contentPane.add(lblRegisterVehicle);
		
		/*
		 * Navigation Bar End
		 */
		
		/*
		 * Reserve Parking Portion
		 */
		
		JLabel lblNewLabel = new JLabel("Vehicle Details:");
		lblNewLabel.setFont(new Font("DialogInput", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 51, 129, 28);
		RegisterVehicle.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"'93 Toyota Paseo"}));
		comboBox.setBounds(10, 76, 334, 22);
		RegisterVehicle.add(comboBox);
		
		JLabel lblSelectPaymentMethods = new JLabel("Select Payment Method:");
		lblSelectPaymentMethods.setFont(new Font("DialogInput", Font.PLAIN, 12));
		lblSelectPaymentMethods.setBounds(10, 123, 189, 28);
		RegisterVehicle.add(lblSelectPaymentMethods);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Visa Ending in 2222"}));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(10, 152, 334, 22);
		RegisterVehicle.add(comboBox_1);
		
		JLabel lblLot = new JLabel("Lot:");
		lblLot.setFont(new Font("DialogInput", Font.PLAIN, 12));
		lblLot.setBounds(10, 198, 189, 28);
		RegisterVehicle.add(lblLot);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"A1"}));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(10, 230, 334, 22);
		RegisterVehicle.add(comboBox_2);
		
		JLabel lblParkingSpace = new JLabel("Parking Space");
		lblParkingSpace.setFont(new Font("DialogInput", Font.PLAIN, 12));
		lblParkingSpace.setBounds(10, 270, 189, 28);
		RegisterVehicle.add(lblParkingSpace);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"A1_1"}));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(10, 302, 334, 22);
		RegisterVehicle.add(comboBox_3);
		
		JButton btnNewButton = new JButton("Reserve");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(151, 381, 109, 39);
		RegisterVehicle.add(btnNewButton);
		
		/*
		 * End
		 * 
		 */
		
	}
}
