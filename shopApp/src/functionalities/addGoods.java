package functionalities;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.io.FileWriter;
import java.io.IOException;

public class addGoods extends JFrame {
	private JTextField Name;
	private JTextField Kind;
	private JTextField Num;
	private JTextField Price;

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
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What product do you want to add ?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 0, 425, 80);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter following four requirments: Name, Kind, Num, Price.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(41, 66, 749, 85);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File goods = new File("products.txt");
				try {
			          if (Kind.getText().equals("fruit")) {
			        	  File file1 = new File("fruit");
			              FileWriter fw1 = new FileWriter(file1,true);
			              BufferedWriter bw1 = new BufferedWriter(fw1);
			              bw1.write("\n" + Name.getText() + "\t" + Num.getText() + "\t" + Price.getText());
			              bw1.newLine();
			              bw1.close();
			          }
			          if (Kind.getText().equals("drinks")) {
			        	  File file2 = new File("drinks");
			              FileWriter fw2 = new FileWriter(file2,true);
			              BufferedWriter bw2 = new BufferedWriter(fw2);
			              bw2.write(Name.getText() + "\t" + Num.getText() + "\t" + Price.getText());
			              bw2.newLine();
			              bw2.close();
			          }
			          if (Kind.getText().equals("meat")) {
			        	  File file3 = new File("meat");
			              FileWriter fw3 = new FileWriter(file3,true);
			              BufferedWriter bw3 = new BufferedWriter(fw3);
			              bw3.write(Name.getText() + "\t" + Num.getText() + "\t" + Price.getText());
			              bw3.newLine();
			              bw3.close();
			          }
			          if (Kind.getText().equals("spices")) {
			        	  File file4 = new File("spices");
			              FileWriter fw4 = new FileWriter(file4,true);
			              BufferedWriter bw4 = new BufferedWriter(fw4);
			              bw4.write(Name.getText() + "\t" + Num.getText() + "\t" + Price.getText());
			              bw4.newLine();
			              bw4.close();
			          }	
				FileWriter fw = new FileWriter(goods, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fw);
				bufferedWriter.write(Name.getText() + "\t" + Kind.getText() + "\t" + Num.getText() + "\t" + Price.getText() + "\n");
				bufferedWriter.close();
				Name.setText(null);
				Kind.setText(null);
				Num.setText(null);
				Price.setText(null);
				JOptionPane.showMessageDialog(null, "Added Successfully!", "You can add other goods!", JOptionPane.PLAIN_MESSAGE);
		     } catch (IOException exc) {
		      System.out.println("Error");
		      exc.printStackTrace();
		     }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(167, 325, 120, 49);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(545, 325, 120, 49);
		getContentPane().add(btnNewButton_1);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Name.setBounds(105, 179, 120, 42);
		getContentPane().add(Name);
		Name.setColumns(10);
		
		Kind = new JTextField();
		Kind.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Kind.setBounds(282, 179, 120, 42);
		getContentPane().add(Kind);
		Kind.setColumns(10);
		
		Num = new JTextField();
		Num.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Num.setColumns(10);
		Num.setBounds(464, 179, 120, 42);
		getContentPane().add(Num);
		
		Price = new JTextField();
		Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Price.setColumns(10);
		Price.setBounds(654, 179, 120, 42);
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
		btnNewButton_2.setBounds(341, 324, 120, 50);
		getContentPane().add(btnNewButton_2);
	}
}
