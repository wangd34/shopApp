package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Login_Sys.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class homePage {

	private JFrame homePageFrame;
	private JTextField searchTxt;
	private static ArrayList<String> products = new ArrayList<>();
	private static ArrayList<String> name = new ArrayList<>();
	private static ArrayList<Double> quantity = new ArrayList<>();
	private static ArrayList<Double> price = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage window = new homePage();
					window.homePageFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public homePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homePageFrame = new JFrame();
		homePageFrame.setTitle("Home Page");
		homePageFrame.setBounds(100, 100, 567, 371);
		homePageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homePageFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				homePageFrame.dispose();
			}
		});
		btnNewButton.setBounds(6, 284, 117, 29);
		homePageFrame.getContentPane().add(btnNewButton);
		
		searchTxt = new JTextField();
//		searchTxt.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				String search = searchTxt.getText().trim();
//				if(!(search.equals(""))) {
//					System.out.println(search);
//				}
//			}
//		});
		searchTxt.setBounds(24, 16, 130, 26);
		homePageFrame.getContentPane().add(searchTxt);
		searchTxt.setColumns(10);
		
		JTextArea proInfo = new JTextArea();
		JScrollPane pane = new JScrollPane(proInfo);
		proInfo.setBounds(290, 40, 250, 260);
		pane.setBounds(290, 40, 250, 260);
		homePageFrame.getContentPane().add(pane);
		
		String[] c = {"fruit", "meat", "drinks", "species"};
		JComboBox categ = new JComboBox(c);
		categ.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		categ.setModel(new DefaultComboBoxModel(new String[] {"none", "fruit", "meat", "drinks", "spicies"}));
		categ.setBounds(155, 17, 117, 25);
		homePageFrame.getContentPane().add(categ);
		
		JButton searchB = new JButton("Search");
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products.clear();
				proInfo.setText("");
				String msg = (String)categ.getSelectedItem();
				switch (msg) {
				case "fruit": 
					readInFile("fruit");
					proInfo.append(appendPro(products));
					break;
				case "meat":
					readInFile("meat");
					proInfo.append(appendPro(products));
					break;
				case "drinks":
					readInFile("drinks");
					proInfo.append(appendPro(products));
					break;
				case "spicies":
					readInFile("spicies");
					proInfo.append(appendPro(products));
					break;
				case "none":
					readInFile("products.txt");
					getInfo(products);	
					if(name.contains(searchTxt.getText())) {
						int i = name.indexOf(searchTxt.getText());
						proInfo.append(name.get(i) + "\t"
								+ quantity.get(i) + "\t" + price.get(i));
					} else {
						proInfo.append("Sorry. Your selected products might be run out of stock!");
					}
				}
			}			
		});
		searchB.setBounds(24, 43, 117, 29);
		homePageFrame.getContentPane().add(searchB);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(290, 16, 36, 16);
		homePageFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setBounds(371, 16, 61, 16);
		homePageFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(467, 16, 61, 16);
		homePageFrame.getContentPane().add(lblNewLabel_2);
	
	}
	

	public void readInFile(String fileName) {
		File file = new File(fileName);
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				products.add(in.nextLine());
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("false");
		}
	} 
	
	public String appendPro(ArrayList<String> a) {
		String list = "";
		for(int i = 0; i < a.size(); i++) {
			list += a.get(i) + "\n";
		}
		return list;
	}
	
	public void getInfo(ArrayList<String> str) {
		String[] tempt = new String[] {};
		for(int i = 0; i < str.size(); i++) {
			tempt = products.get(i).split("\t");
			name.add(tempt[0]);
			quantity.add(Double.parseDouble(tempt[1]));
			price.add(Double.parseDouble(tempt[2]));
		}
	}
}
