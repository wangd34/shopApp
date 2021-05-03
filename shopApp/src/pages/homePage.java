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
import Function.Products;
import javax.swing.JTable;

public class homePage {

	private JFrame homePageFrame;
	private JTextField searchTxt;
	private static ArrayList<Products> products = new ArrayList<>();
	private static ArrayList<Products> shoppingCart = new ArrayList<>();
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
		homePageFrame.setBounds(100, 100, 718, 406);
		homePageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homePageFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				homePageFrame.dispose();
			}
		});
		btnNewButton.setBounds(24, 302, 117, 29);
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
		proInfo.setBounds(290, 40, 340, 260);
		pane.setBounds(290, 40, 340, 260);
		homePageFrame.getContentPane().add(pane);
		
		String[] c = {"fruit", "meat", "drinks", "species"};
		JComboBox categ = new JComboBox(c);
		categ.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		categ.setModel(new DefaultComboBoxModel(new String[] {"none", "fruit", "meat", "drinks", "spicies", "all"}));
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
					readInFile("spicy");
					proInfo.append(appendPro(products));
					break;
				case "all":
					readInFile("Products.txt");
					
					if(searchTxt.getText().isEmpty()) {
						proInfo.append(appendPro(products));
					} else {
						if(searchPro(searchTxt.getText()) != -1) {
							proInfo.append(appendPro(products.get(searchPro(searchTxt.getText()))));
						} else {
							proInfo.append("Sorry");
						}
					}
					break;
				case "none":
					readInFile("products.txt");					
					if(searchPro(searchTxt.getText()) != -1) {
						proInfo.append(appendPro(products.get(searchPro(searchTxt.getText()))));
					} else {
						proInfo.append("Sorry");
					}
					break;
				}
			}			
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 93, 229, 207);
		homePageFrame.getContentPane().add(scrollPane);
		
		JTextArea SCtext = new JTextArea();
		scrollPane.setViewportView(SCtext);
		
		searchB.setBounds(24, 43, 117, 29);
		homePageFrame.getContentPane().add(searchB);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(290, 16, 36, 16);
		homePageFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(371, 16, 61, 16);
		homePageFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(580, 16, 61, 16);
		homePageFrame.getContentPane().add(lblNewLabel_2);
		
		JButton addBtn = new JButton("add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SCtext.setText("");
				String[] tempt = proInfo.getText().split("\t");
				Products p = new Products(tempt[0], tempt[1], Double.parseDouble(tempt[2]), Double.parseDouble(tempt[3]));
				addSC(p);
				SCtext.append(appendPro(shoppingCart));
			}
		});
		addBtn.setBounds(155, 43, 117, 29);
		homePageFrame.getContentPane().add(addBtn);
		
		
		
		JButton RFSCbtn = new JButton("Empty");
		RFSCbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emptyShoppingCart();
				SCtext.append(appendPro(shoppingCart));
				SCtext.setText("");
			}
		});
		RFSCbtn.setBounds(153, 302, 117, 29);
		homePageFrame.getContentPane().add(RFSCbtn);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(472, 16, 61, 16);
		homePageFrame.getContentPane().add(lblNewLabel_3);
	
	}
	

	public void readInFile(String fileName) {
		File file = new File(fileName);
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String[] tempt = in.nextLine().split("\t");
				Products p = new Products(tempt[0], tempt[1], Double.parseDouble(tempt[2]), Double.parseDouble(tempt[3]));
				products.add(p);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("false");
		}
	} 
	
	public String appendPro(ArrayList<Products> a) {
		String list = "";
		for(int i = 0; i < a.size(); i++) {
			list += a.get(i).appendP() + "\n";
		}
		return list;
	}
	
	public String appendPro(Products p) {
		
		return p.appendP();
	}
	
	public void addSC(Products p){
		shoppingCart.add(p);
	}
	
	public int searchPro(String p) {
		ArrayList<String> name = new ArrayList<>();
		for(Products a : products) {
			name.add(a.getName());
		}		
		int index = name.indexOf(p);
		return index;
	}
	
	public void emptyShoppingCart() {
		
		shoppingCart.clear();
	}
}
