package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Function.Products;
import functionalities.addGoods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class requestPage {

	private JFrame frmRequest;
	private JTextField requestTxt;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					requestPage window = new requestPage();
					window.frmRequest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public requestPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRequest = new JFrame();
		frmRequest.setTitle("Request");
		frmRequest.setBounds(100, 100, 450, 300);
		frmRequest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRequest.getContentPane().setLayout(null);
		
		requestTxt = new JTextField();
		requestTxt.setBounds(151, 109, 130, 26);
		frmRequest.getContentPane().add(requestTxt);
		requestTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("request");
		btnNewButton.setBounds(161, 150, 105, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String request = requestTxt.getText();
				addRequest(new Products(request));
				requestTxt.setText("");
				JOptionPane.showMessageDialog(null, "Your requests are added to the pending list! We will reply you ASAP!\n"
						+ "                            Thanks for your patience!", "Request Successfully!", JOptionPane.PLAIN_MESSAGE);
			}
		});
		frmRequest.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Type the good's name you want");
		lblNewLabel.setBounds(110, 81, 234, 16);
		frmRequest.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addGoods.main(null);
				frmRequest.dispose();
			}
		});
		btnNewButton_1.setBounds(6, 232, 117, 29);
		frmRequest.getContentPane().add(btnNewButton_1);
	}
	
	public static void addRequest(Products p) {
		try {
			FileWriter fw = new FileWriter("requests.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(p.appendP() + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
