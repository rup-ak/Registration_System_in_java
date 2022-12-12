package registration;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Registration extends JFrame {

//	public Image img_log = new ImageIcon(Registration.class.getResource("./icon/studenthomepage.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
//	private Image img_userid = new ImageIcon(Registration.class.getResource("./icon/userid.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
//	private Image img_pass = new ImageIcon(Registration.class.getResource("./icon/password.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUserName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmailAddress;
	private JTextField txtMobileNo;
	private JLabel lblIconLogo;
	private JLabel lblNoWarn = new JLabel("");
//	private JLabel lblWarMess = new JLabel("");
//	private JLabel lblWarMess_1 = new JLabel("");
//	private JLabel lblWarMess_2 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(1380,733);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(386, 169, 225, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUserName.getText().equals("UserName")) {
					txtUserName.setText("");
				}else
				{
					txtUserName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserName.getText().equals(""))
					txtUserName.setText("UserName");
				
			}
		});
		txtUserName.setBorder(null);
		txtUserName.setFont(new Font("Arial", Font.PLAIN, 13));
		txtUserName.setText("UserName");
		txtUserName.setBounds(10, 0, 215, 42);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(386, 239, 165, 42);
		contentPane.add(panel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
					
				}else
				{
					txtPassword.selectAll();
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals(""))
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 0, 215, 42);
		panel_1.add(txtPassword);
		
		JButton showPass = new JButton("show");
		   showPass.setForeground(new Color(255, 255, 255));
		showPass.setBounds(549, 239, 62, 42);
		  showPass.setBorder(new EmptyBorder(0, 0, 0, 0));
		    showPass.setFocusable(false);
		    showPass.setFocusPainted(false);
		    showPass.setFont(new Font("Segoe UI", Font.BOLD, 15));
		    showPass.setBackground(new Color(0, 0, 0));
		    showPass.setBorderPainted(false);
		    showPass.addActionListener(e->
		    {
		    	if(showPass.getText().equals("show"))
		    	{
		    		txtPassword.setEchoChar('\u0000');
		    		showPass.setText("hide");
		    	}
		    	else
		    	{
		    		txtPassword.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		    		showPass.setText("show");
		    	}
		    });
		getContentPane().add(showPass);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(64, 169, 225, 42);
		contentPane.add(panel_2);
		
		txtFirstName = new JTextField();
		txtFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFirstName.getText().equals("First Name")) {
					  txtFirstName.setText("");
					//  txtFirstName.setBackground(Color.GRAY);
				}
				else 
				{
					txtFirstName.selectAll();
				}
				
			}
//			@Override
//			public void focusLost(FocusEvent e) {
//			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtFirstName.getText().equals(""))
					txtFirstName.setText("First Name");
				
				
			}
		});
		txtFirstName.setBorder(null);
		txtFirstName.setFont(new Font("Arial", Font.PLAIN, 13));
		txtFirstName.setText("First Name");
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(10, 0, 215, 42);
		panel_2.add(txtFirstName);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(64, 239, 225, 42);
		contentPane.add(panel_2_1);
		
		txtLastName = new JTextField();
		txtLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLastName.getText().equals("Last Name")) {
					txtLastName.setText("");
				}else 
				{
					txtLastName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLastName.getText().equals(""))
					txtLastName.setText("Last Name");
			}
		});
		txtLastName.setBorder(null);
		txtLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 0, 215, 42);
		panel_2_1.add(txtLastName);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(64, 305, 225, 42);
		contentPane.add(panel_2_2);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmailAddress.getText().equals("Email Address")) {
					txtEmailAddress.setText("");
				}else 
				{
					txtLastName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmailAddress.getText().equals(""))
					txtEmailAddress.setText("Email Address");
			}
		});
		
		txtEmailAddress.setBorder(null);
		txtEmailAddress.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmailAddress.setText("Email Address");
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(10, 0, 215, 42);
		panel_2_2.add(txtEmailAddress);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(386, 305, 225, 42);
		contentPane.add(panel_2_3);
		
		txtMobileNo = new JTextField();
		txtMobileNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMobileNo.getText().equals("Mobile No.")) {
					txtMobileNo.setText("+8801");
				}else
				{
					txtMobileNo.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMobileNo.getText().equals("+8801"))
					txtMobileNo.setText("Mobile No.");
			}
		});
		txtMobileNo.setBorder(null);
		txtMobileNo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMobileNo.setText("Mobile No.");
		txtMobileNo.setColumns(10);
		txtMobileNo.setBounds(10, 0, 215, 42);
		panel_2_3.add(txtMobileNo);
		
		lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(new Rectangle(0, 0, 2, 2));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon("D:\\Java\\Login\\icon\\studentlogin.png"));//Here will be the location of the image
		lblIconLogo.setBounds(208, 0, 261, 147);
		contentPane.add(lblIconLogo);
		
		JLabel lblNewUser = new JLabel("New User Registration");
		lblNewUser.setForeground(Color.WHITE);
		lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUser.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewUser.setBounds(223, 116, 238, 42);
		contentPane.add(lblNewUser);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegister.setBackground(new Color(60, 175, 80));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegister.setBackground(new Color(50, 205, 50));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnRegister.setBackground(new Color(80, 155, 100));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnRegister.setBackground(new Color(40, 220, 40));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegister.setBackground(new Color(70, 185, 90));
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String firstName=txtFirstName.getText();
				String lastName=txtLastName.getText();
				String emailID=txtEmailAddress.getText();
				String userID=txtUserName.getText();
				String password=txtPassword.getText();
				String mobileno=txtMobileNo.getText();
				int len=mobileno.length();
				
//				String msg = "" + firstName;
//                msg += " \n";
                if (len != 14 || txtFirstName.getText().equals("First Name") || txtUserName.getText().equals("UserName")
                		|| txtPassword.getText().equals("Password")) 
                {
//                	if(len != 14)
//                		lblNoWarn.setText("Please enter a valid number!!");
//                	else if(txtFirstName.getText().equals("First Name"))
//                		lblWarMess.setText("Enter the First Name");
//                	else if(txtFirstName.getText().equals("UserName"))
//                		lblWarMess_1.setText("Enter the User Name");
//                	else  if(txtFirstName.getText().equals("Password"))
//                		lblWarMess_2.setText("Enter the Password");
//                	
                    //JOptionPane.showMessageDialog(btnRegister, "Enter a valid mobile number");
                	lblNoWarn.setText("Please enter a valid number!!\nAnd Fill the required info!!");
                } else {
                	
                	//connect with sql and store the data
                	
                	try {
                    	Class.forName("com.mysql.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "");

                        String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userID + "','" +
                            password + "','" + emailID + "','" + mobileno + "')";

                        Statement sta = connection.createStatement();
                        int x = sta.executeUpdate(query);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(btnRegister, "This is alredy exist");
                        } else {
                            JOptionPane.showMessageDialog(btnRegister,
                                "Welcome, " + firstName + "\nYour account is sucessfully created");
                        }
                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

                
			}
		});
		
		btnRegister.setBorder(null);
		btnRegister.setBackground(new Color(50, 205, 50));
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial", Font.BOLD, 18));
		btnRegister.setBounds(260, 390, 178, 42);
		contentPane.add(btnRegister);
		
		lblNoWarn.setForeground(Color.RED);
		lblNoWarn.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNoWarn.setBounds(386, 358, 288, 28);
		contentPane.add(lblNoWarn);
		
		JLabel lblReq1 = new JLabel("*Required");
		lblReq1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReq1.setForeground(new Color(255, 0, 0));
		lblReq1.setBounds(74, 214, 73, 14);
		contentPane.add(lblReq1);
		
		JLabel lblReq1_1 = new JLabel("*Required");
		lblReq1_1.setForeground(Color.RED);
		lblReq1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReq1_1.setBounds(388, 214, 73, 14);
		contentPane.add(lblReq1_1);
		
		JLabel lblReq1_2 = new JLabel("*Required");
		lblReq1_2.setForeground(Color.RED);
		lblReq1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReq1_2.setBounds(386, 280, 73, 14);
		contentPane.add(lblReq1_2);
		
//		lblWarMess.setForeground(Color.RED);
//		lblWarMess.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblWarMess.setBounds(171, 215, 118, 13);
//		contentPane.add(lblWarMess);
//		
//		lblWarMess_1.setForeground(Color.RED);
//		lblWarMess_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblWarMess_1.setBounds(493, 215, 118, 13);
//		contentPane.add(lblWarMess_1);
//		
//		lblWarMess_2.setForeground(Color.RED);
//		lblWarMess_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblWarMess_2.setBounds(493, 281, 118, 13);
//		contentPane.add(lblWarMess_2);
		setLocationRelativeTo(null);
	}
}
