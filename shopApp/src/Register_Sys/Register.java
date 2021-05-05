package Register_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Login_Sys.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Register {

	private JFrame regFrame;
	private final JLabel Register = new JLabel("Register");
	private JTextField txtfullname;
	private JTextField txtusername;
	private JTextField txtpassword;
	private JTextField txtconfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.regFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		regFrame = new JFrame();
		regFrame.setTitle("Regisration");
		regFrame.setBounds(100, 100, 450, 300);
		regFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		regFrame.getContentPane().setLayout(null);
		Register.setHorizontalAlignment(SwingConstants.CENTER);
		Register.setFont(new Font("SimSun", Font.BOLD, 24));
		Register.setBounds(150, 8, 164, 45);
		regFrame.getContentPane().add(Register);
		
		JSeparator separator = new JSeparator();
		separator.setToolTipText("");
		separator.setForeground(new Color(212, 212, 212));
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 50, 450, 16);
		regFrame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setToolTipText("");
		separator_1.setForeground(new Color(212, 212, 212));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 192, 460, 16);
		regFrame.getContentPane().add(separator_1);
		
		JLabel name = new JLabel("Full Name:");
		name.setBounds(22, 64, 76, 27);
		regFrame.getContentPane().add(name);
		
		JLabel username = new JLabel("User Name:");
		username.setBounds(22, 89, 76, 27);
		regFrame.getContentPane().add(username);
		
		JLabel password = new JLabel("Password:");
		password.setBounds(22, 115, 76, 27);
		regFrame.getContentPane().add(password);
		
		JLabel confirm = new JLabel("Confirm Password:");
		confirm.setBounds(22, 142, 117, 27);
		regFrame.getContentPane().add(confirm);
		
		txtfullname = new JTextField();
		txtfullname.setBounds(137, 65, 173, 21);
		regFrame.getContentPane().add(txtfullname);
		txtfullname.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(137, 92, 173, 21);
		regFrame.getContentPane().add(txtusername);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(137, 118, 248, 21);
		regFrame.getContentPane().add(txtpassword);
		
		txtconfirm = new JTextField();
		txtconfirm.setColumns(10);
		txtconfirm.setBounds(137, 145, 248, 21);
		regFrame.getContentPane().add(txtconfirm);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfullname.setText(null);
				txtusername.setText(null);
				txtpassword.setText(null);
				txtconfirm.setText(null);
			}
		});
		btnReset.setBounds(304, 211, 117, 29);
		regFrame.getContentPane().add(btnReset);
		
		JButton btnregister = new JButton("Register");
		btnregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtpassword.getText().equals(txtconfirm.getText())) {
					File acc = new File("accounts.txt");
				try {
				if(!acc.exists()) {
					acc.createNewFile();
				}
					FileWriter fw = new FileWriter(acc, true);
					BufferedWriter bufferedWriter = new BufferedWriter(fw);
					bufferedWriter.write("\n" + txtusername.getText() + "\t" + txtpassword.getText());
					bufferedWriter.close();
					txtfullname.setText(null);
					txtusername.setText(null);
					txtpassword.setText(null);
					txtconfirm.setText(null);
					JOptionPane.showMessageDialog(null, "You are a member of us!", "Signin Successfully!", JOptionPane.PLAIN_MESSAGE);
				    } catch (IOException exc) {
				      System.out.println("Error");
				      exc.printStackTrace();
				    }
				}else {
				    	txtconfirm.setText(null);}
			}
			
		});
		btnregister.setBounds(168, 211, 117, 29);
		regFrame.getContentPane().add(btnregister);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regFrame.dispose();
				Login.main(null);
			}
		});
		btnNewButton.setBounds(22, 211, 117, 29);
		regFrame.getContentPane().add(btnNewButton);
		
	}
}
