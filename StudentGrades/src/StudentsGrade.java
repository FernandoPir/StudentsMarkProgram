/**
 * Programmer: Fernando Pires Rui
 * Date: 02/06/2021
 * Name: Students Grades
 * This program will create a interface that the user can add 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DecimalFormat;

import java.math.RoundingMode;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class StudentsGrade extends JFrame {
	
	private JPanel contentPane;
	private JTextField Test1;
	private JTextField Test2;
	private JTextField Test3;
	private JTextField Test4;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField something;
	
	
	
	
	
	
		//Creating The variables to be used
		String [][] student = new String [7][17];
		int count;
		
		//https://www.codegrepper.com/code-examples/java/java+limit+output+to+2+decimal+places+java
	    DecimalFormat format = new DecimalFormat("##.00");
	    
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsGrade frame = new StudentsGrade();
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
	public StudentsGrade() {
		
		// Creating the title of JFrame
		setTitle("Student Grades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Create the title
		JLabel Title = new JLabel("Students Grades");
		Title.setForeground(new Color(0, 0, 205));
		Title.setFont(new Font("Tahoma", Font.BOLD, 25));
		Title.setBounds(185, 11, 222, 34);
		contentPane.add(Title);
		
		// Creating a label written "Test 1" 
		JLabel Test1Label = new JLabel("Test 1");
		Test1Label.setBounds(10, 96, 46, 14);
		contentPane.add(Test1Label);
		
		// Creating the box for the user input the first mark
		Test1 = new JTextField();
		Test1.setBounds(110, 93, 54, 20);
		contentPane.add(Test1);
		Test1.setColumns(10);
			
		// Creating a label written "Test 2"
		JLabel Test2Label = new JLabel("Test 2");
		Test2Label.setBounds(10, 130, 46, 14);
		contentPane.add(Test2Label);
		
		// Creating a box for the user input the second mark
		Test2 = new JTextField();
		Test2.setBounds(110, 127, 54, 20);
		contentPane.add(Test2);
		Test2.setColumns(10);
		
		// Creating a label written "Test 3"
		JLabel Test3Label = new JLabel("Test 3");
		Test3Label.setBounds(10, 164, 46, 14);
		contentPane.add(Test3Label);
		
		// Creating a box for the user input the third mark
		Test3 = new JTextField();
		Test3.setBounds(110, 161, 54, 20);
		contentPane.add(Test3);
		Test3.setColumns(10);
		
		// Creating a label written "Test 4"
		JLabel Test4Label = new JLabel("Test 4");
		Test4Label.setBounds(10, 199, 46, 14);
		contentPane.add(Test4Label);
		
		// Creating a box for the user input the forth mark
		Test4 = new JTextField();
		Test4.setBounds(110, 196, 54, 20);
		contentPane.add(Test4);
		Test4.setColumns(10);
		
		// Creating a label written "First Name:"
		JLabel FirstNameLabel = new JLabel("First Name:");
		FirstNameLabel.setBounds(10, 59, 76, 14);
		contentPane.add(FirstNameLabel);
		
		// Creating a box for the user input their first name
		FirstName = new JTextField();
		FirstName.setBounds(109, 56, 140, 20);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		
		// Creating a label wriiten "Last Name:"
		JLabel LastNamesLabel = new JLabel("Last Name:");
		LastNamesLabel.setBounds(259, 56, 66, 14);
		contentPane.add(LastNamesLabel);
		
		// Creating a box for the user input their last name
		LastName = new JTextField();
		LastName.setBounds(339, 56, 159, 20);
		contentPane.add(LastName);
		LastName.setColumns(10);
		
		// Creating a Text area to display the students' information
		JTextArea Output = new JTextArea();
		Output.setColumns(10);
		Output.setBackground(Color.WHITE);
		Output.setEditable(false);
		Output.setBounds(155, 252, 434, 366);
		contentPane.add(Output);
		JScrollPane scrollPane = new JScrollPane(Output);
		scrollPane.setBounds(93, 264, 405, 326);
		contentPane.add(scrollPane);
		
		
		// Creating a button to add the student information
		JButton AddBtn = new JButton("Add");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// If the are already 15 studdent added, the program will not let the user add more.
				if (count == 15) {
					JOptionPane.showMessageDialog(null, "You already reached the total number of students");
					return;
				}
				
				// Creating local variables to store the user's  input
				double test1 = 0;
				double test2 = 0;
				double test3 = 0;
				double test4 = 0;
				String firstName = FirstName.getText();
				String lastName = LastName.getText();
				
				//	Handling the exception if the user didn't enter the name
				if (lastName.length() == 0 || firstName.length() == 0 ) {
					JOptionPane.showMessageDialog(null, "Please, enter your name");
					return;
				}
				
				try {
					test1 = Double.parseDouble(Test1.getText());
					test2 = Double.parseDouble(Test2.getText());
					test3 = Double.parseDouble(Test3.getText());
					test4 = Double.parseDouble(Test4.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "The number must be a decimal number.");
					return;
				}	
				
				// Checking if the first or last name has a number
				if(firstName.matches(".*\\d.*") || lastName.matches(".*\\d.*")) {
					JOptionPane.showMessageDialog(null, "The name must not contain numbers");
					return;
				}
				
				// Checking if the mark is in the range of 0 to 100
				if (test1 >100 || test1 < 0 || test2 >100 || test2 < 0 || test3 > 100 || test3 < 0 ||test4 > 100 || test4 < 0) {
					JOptionPane.showMessageDialog(null, " The number must be between 0 and 100");
					return;
					

				}
				student[0][count] = firstName;
				student[1][count] = lastName;
				student[2][count] = Double.toString(test1);
				student[3][count] = Double.toString(test2);
				student[4][count] = Double.toString(test3);
				student[5][count] = Double.toString(test4);			
					count++;
			}
		});
		AddBtn.setBounds(272, 92, 61, 23);
		contentPane.add(AddBtn);
		
		// Creating a button to show the average of the student's marks
		JButton StudenAverageBtn = new JButton("Student Average");
		
		/**
		 * This action will display the studens' average for their 4 marks 
		 */
		StudenAverageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Output.setText(null);
				double num = 0; 
				double unroundedAverage = 0;
				String average = " ";
				Output.setText("First Name" + "\t" + "Last Name" + "\t" + "\t" + "Test 1" + "\t" + "Test 2" + "\t" + "Test 3" + "\t" +  "test 4" + "\t" + "Student Average" +" " + "\n" + " " +"\n");
					for (int col = 0; col < count; col++) {
						for (int row = 0; row <= 5; row++) {
					
							if (row >= 2 && row <=5) { 
								num += Double.parseDouble(student[row][col]);
							}
							if (row >= 2 && row <= 5) { 
								Output.append(student[row][col] + "\t");
				
							}else if (row == 1){
									if (student[1][col].length() >= 14 ){
										Output.append(student[1][col] + "\t");
							
									} else {
										Output.append(student[1][col] + "\t\t");
							
									}
							} else {
								Output.append(student[0][col] + "\t");
								
							}
						}
						 unroundedAverage  = num / 4;
						 format.setRoundingMode(RoundingMode.HALF_UP);
						 average = format.format(unroundedAverage);
						 student[6][col] = average;
						 Output.append("         " + student[6][col]);
						 Output.append("\n");
						 num = 0;
					}
				}
	
		});
		StudenAverageBtn.setBounds(375, 92, 140, 23);
		contentPane.add(StudenAverageBtn);
		
		// Creating a button to list the student information
		JButton ListBtn = new JButton("List");
		
		/**
		 * This action will display all the 4 courses average
		 */
		ListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Output.setText(null);
				Output.setText("First Name" + "\t" + "Last Name" + "\t" + "\t" + "Test 1" + "\t" + "Test 2" + "\t" + "Test 3" + "\t" +  "test 4" + "\n" + " " +"\n");
				for (int col = 0; col < count; col++) {
					for (int row = 0; row < 6; row++) {
						if (row >= 2) { 
							Output.append(student[row][col] + "\t ");
					
						}else if(row == 1){
							if (student[row][col].length() >= 14 ){
								Output.append(student[row][col] + "\t ");
								
							} else {
								Output.append(student[row][col] + "\t\t ");
								
							}
						}else{
							Output.append(student[row][col] + "\t");
						}
					}   
					Output.append("\n");
				}
			}
		});
		ListBtn.setBounds(272, 138, 61, 23);
		contentPane.add(ListBtn);
		
		// Creating a button to show the average of the class marks
		JButton CourseAverageBtn = new JButton("Course Average");
		CourseAverageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 for (int c = 2; c <= 5; c++ ) {
					double num = 0;
					double unroundedAverage = 0; 
					String average = " ";
					 for (int i = 0; i < count; i++) {
						 num += Double.parseDouble(student[c][i]); 
					 }
					 if (c == 2) {
						 Output.append(" " + "\n");
						 Output.append("  Course Average:\t");
					 }
					 
					 unroundedAverage  = num / count;
					 format.setRoundingMode(RoundingMode.HALF_UP);
					 average = format.format(unroundedAverage);
					 student[c][count+1] = average;
					 Output.append("\t " + student[c][count+1]);
					 unroundedAverage = 0;
				 }
			}
		});
		CourseAverageBtn.setBounds(375, 138, 140, 23);
		contentPane.add(CourseAverageBtn);
		
		// Creating the Button to exit the program
		JButton ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ExitBtn.setBounds(321, 182, 66, 23);
		contentPane.add(ExitBtn);
		
		something = new JTextField();
		something.setBackground(Color.WHITE);
		something.setEditable(false);
		something.setText("");
		something.setBounds(424, 650, 136, 20);
		contentPane.add(something);
		something.setColumns(10);
	}
}
