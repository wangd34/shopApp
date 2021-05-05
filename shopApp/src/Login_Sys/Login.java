package Login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import Register_Sys.Register;
import functionalities.addGoods;
import pages.homePage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Login {

	private JFrame frmLogin;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	static ArrayList<String> acc = new ArrayList<>();
	static ArrayList<String> pswd = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Log in");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(147, 17, 164, 27);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setToolTipText("");
		separator.setForeground(new Color(212, 212, 212));
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 43, 450, 16);
		frmLogin.getContentPane().add(separator);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(52, 60, 88, 16);
		frmLogin.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 101, 61, 16);
		frmLogin.getContentPane().add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(192, 56, 190, 26);
		frmLogin.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(192, 96, 190, 26);
		frmLogin.getContentPane().add(txtPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setToolTipText("");
		separator_1.setForeground(UIManager.getColor("Separator.foreground"));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 179, 450, 16);
		frmLogin.getContentPane().add(separator_1);
		

		JComboBox id = new JComboBox();
		id.setBounds(249, 140, 143, 27);
		id.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Administrator", "Guest"}));
		frmLogin.getContentPane().add(id);
		
		JButton btnLogin = new JButton("LogIn");
		readInFile();
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UN = txtUserName.getText();
				String PSWD = txtPassword.getText();				
				boolean match = match(UN, PSWD);
				if(id.getSelectedItem().equals("Customer")) {
					if(match) {
						txtUserName.setText(null);
						txtPassword.setText(null);
						frmLogin.dispose();
						homePage.main(null);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Account", "Login Error", JOptionPane.ERROR_MESSAGE);
						txtUserName.setText(null);
						txtPassword.setText(null);
					}
				} else if(id.getSelectedItem().equals("Administrator")) {
					if(match) {
						txtUserName.setText(null);
						txtPassword.setText(null);
						frmLogin.dispose();
						addGoods.main(null);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Account", "Login Error", JOptionPane.ERROR_MESSAGE);
						txtUserName.setText(null);
						txtPassword.setText(null);
					}
				}
				else {
					txtUserName.setText(null);
					txtPassword.setText(null);
					frmLogin.dispose();
					homePage.main(null);
				}
			}
		});
		btnLogin.setBounds(192, 217, 117, 29);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnReg = new JButton("SignUp");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.main(null);
				frmLogin.dispose();
			}
		});
		btnReg.setBounds(321, 217, 117, 29);
		frmLogin.getContentPane().add(btnReg);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserName.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(51, 217, 117, 29);
		frmLogin.getContentPane().add(btnReset);
		
		JLabel lblNewLabel = new JLabel("Login as");
		lblNewLabel.setBounds(192, 134, 69, 33);
		frmLogin.getContentPane().add(lblNewLabel);
	}
	
	public void readInFile() {
		File file = new File("accounts.txt");
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				acc.add(in.next());
				pswd.add(in.next());
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean match(String s, String p) {
		int flag = acc.indexOf(s);
		if(flag == -1) {
			return false;
		} else {
			if(pswd.get(flag).equals(p)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
