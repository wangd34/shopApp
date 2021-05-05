package functionalities;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Function.Products;
import Login_Sys.Login;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import pages.homePage;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JScrollPane;


public class addGoods extends JFrame {
	private JTextField Name;
	private JTextField Kind;
	private JTextField Num;
	private JTextField Price;
	private static ArrayList<Products> products = new ArrayList<Products>();
	private static ArrayList<Products> requests = new ArrayList<Products>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addGoods frame = new addGoods();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addGoods() {
		setTitle("addGoods");
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File goods = new File("products.txt");
				Double quantity = Double.parseDouble(Num.getText());
				Double price = Double.parseDouble(Price.getText());
				if(quantity < 0 || price < 0) {
					JOptionPane.showMessageDialog(null, "Check quantity and price!", "Error!", JOptionPane.PLAIN_MESSAGE);
				} else {
					Products p = new Products(Name.getText(), Kind.getText(), quantity, price);
					try {			
						addToStore(p);
						Name.setText(null);
						Kind.setText(null);
						Num.setText(null);
						Price.setText(null);
						JOptionPane.showMessageDialog(null, "Added Successfully!", "You can add other goods!", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception exc) {
					      System.out.println("Error");
					      exc.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(17, 247, 79, 22);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(17, 388, 79, 22);
		getContentPane().add(btnNewButton_1);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Name.setBounds(108, 49, 120, 42);
		getContentPane().add(Name);
		Name.setColumns(10);
		
		Kind = new JTextField();
		Kind.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Kind.setBounds(108, 97, 120, 42);
		getContentPane().add(Kind);
		Kind.setColumns(10);
		
		Num = new JTextField();
		Num.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Num.setColumns(10);
		Num.setBounds(108, 145, 120, 42);
		getContentPane().add(Num);
		
		Price = new JTextField();
		Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Price.setColumns(10);
		Price.setBounds(108, 193, 120, 42);
		getContentPane().add(Price);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Name.setText(null);
				Kind.setText(null);
				Num.setText(null);
				Price.setText(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(118, 247, 84, 22);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(17, 60, 79, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(17, 108, 79, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(17, 156, 79, 31);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(17, 204, 79, 22);
		getContentPane().add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(271, 49, 1, 213);
		getContentPane().add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 49, 240, 288);
		getContentPane().add(scrollPane);
		
		JTextArea stockInfo = new JTextArea();
		scrollPane.setViewportView(stockInfo);
		
		JButton btnNewButton_rf = new JButton("Refresh");
		btnNewButton_rf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products.clear();
				load();
				stockInfo.setText("");
				stockInfo.append(appendPro(products));
			}
		});
		btnNewButton_rf.setBounds(417, 342, 117, 29);
		getContentPane().add(btnNewButton_rf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(578, 49, 229, 288);
		getContentPane().add(scrollPane_1);
		
		JTextArea requestInfo = new JTextArea();
		scrollPane_1.setViewportView(requestInfo);
		stockInfo.append(getWarningString());
		load();
		stockInfo.append(appendPro(products));
		requestInfo.append(appendPro(requests));
	}
	
	public static void addToStore(Products p) {		
		try {
			FileWriter fw = new FileWriter("Products.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(p.appendP() + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void load() {
		File file1 = new File("products.txt");
		File file2 = new File("requests.txt");
		try {
			Scanner in1 = new Scanner(file1);
			Scanner in2 = new Scanner(file2);
			while(in1.hasNextLine()) {
				String[] tempt = in1.nextLine().split("\t");
				Products p = new Products(tempt[0], tempt[1], Double.parseDouble(tempt[2]), Double.parseDouble(tempt[3]));
				products.add(p);
			}
			while(in2.hasNextLine()) {
				String[] tempt = in2.nextLine().split("\t");
				Products p = new Products(tempt[0], tempt[1], Double.parseDouble(tempt[2]), Double.parseDouble(tempt[3]));
				requests.add(p);
			}
			in2.close();
		} catch (FileNotFoundException e) {
			System.out.println("false");
		}
	}
	
	public static String appendPro(ArrayList<Products> pro) {
		String tempt = "";
		for(Products p : pro) {
			tempt += p.appendP() + "\n";
		}
		return tempt;
	}
}
