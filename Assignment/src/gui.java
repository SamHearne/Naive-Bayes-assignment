import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;




//this class presents a simple gui
public class gui  extends JFrame implements ActionListener {
	
	public static int tempNo = 1;
	float test = 0;
	public static boolean Cough = true;
	public static boolean Aches = true;
	public static boolean Throat = true;
	public static boolean Recently = true;
	ProbCalc calc = new ProbCalc();
	
	String[] tempOptions = {"Hot","Cold","Cool","Normal"};
	String[] Options = {"Yes","No"};
	
	//
	JComboBox temp,AchesBox,CoughBox,ThroatBox,RecentlyBox;
	JLabel lbltest = new JLabel();
	
	
	//adding labels,buttons,panels etc
	JLabel temperatureLabel,achesLabel,coughLabel,soreThroatLabel,contactLabel,resultLabel;
		
	//creating buttons. The link button uses your default browser to open 
	//John Hopkins university of medicines page on the corona virus
	JButton Check,Link;
	
	
	
	//panels are used to control where attributes will appear (see below)
	JPanel topPanel,bottomPanel;
	
		

	public gui(String title) {
	
	
		
		//Using a title given by control to title the border
		super(title);
			
			
		
		//creating comboBoxes to hold each option
		JComboBox TempBox = new JComboBox(tempOptions);
		JComboBox AchesBox = new JComboBox(Options);
		JComboBox CoughBox = new JComboBox(Options);
		JComboBox ThroatBox = new JComboBox(Options);
		JComboBox RecentlyBox = new JComboBox(Options);
			
		//setting the size of the window and the layout
		setSize(1000, 200);
		BorderLayout bl1 = new BorderLayout();
		setLayout(bl1);
			
			
			
			
			
		//creating labels
		temperatureLabel = new JLabel("Temperature :");
		achesLabel = new JLabel("Aches :");
		coughLabel = new JLabel("Cough :");
		soreThroatLabel = new JLabel("Sore Throat :");
		contactLabel = new JLabel("Recent Contact :");
		resultLabel = new JLabel();
			
			
			
		//Creating a button to allow the user to check results
		Check = new JButton("Check results");
		Check.addActionListener(this);
		Link= new JButton("Corona Virus information");
		Link.addActionListener(this);
			
			
			
			
			
		//creating jpanels
		topPanel = new JPanel();
		bottomPanel = new JPanel();
			
			
			
			
		topPanel.add(temperatureLabel);
		topPanel.add(TempBox);
		topPanel.add(achesLabel);
		topPanel.add(AchesBox);
		topPanel.add(coughLabel);
		topPanel.add(CoughBox);
		topPanel.add(soreThroatLabel);
		topPanel.add(ThroatBox);
		topPanel.add(contactLabel);
		topPanel.add(RecentlyBox);
		bottomPanel.add(Check);
		bottomPanel.add(Link);
			
		bottomPanel.add(resultLabel);
		
		add(topPanel,BorderLayout.NORTH);
		add(bottomPanel,BorderLayout.SOUTH);
			
			
		//The following action listeners are used to check which option is selected in each combobox
		//and then change the corresponding variable to that option.
		TempBox.addActionListener(
				
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String currentQuantity = (String)TempBox.getSelectedItem();
							                    
					switch(currentQuantity) {
									                        	
						case "Hot":
							tempNo = 1;
									
									
								
						break;
										                        		
						case "Cold":
							tempNo = 2;
									
									
						break;
								
								
								
						case "Cool":
							tempNo = 3;
									
									
						break;
								
								
								
						case "Normal":
							tempNo = 4;
									
								
						break;
					}
				}
			}            
		);
			
			
			
			
			
			
			
			
			
			
			
		AchesBox.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String currentQuantity = (String)AchesBox.getSelectedItem();
								                       
						switch(currentQuantity) {
								                        	
							case "Yes":
							Aches = true;
						
							break;
									                        		
							case "No":
							Aches = false;
							
							
							break;
						}
						
					}
				}            
			);
					
		
		CoughBox.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String currentQuantity = (String)CoughBox.getSelectedItem();
									                       
					switch(currentQuantity) {
									                        	
						case "Yes":
						Cough = true;
								
								
						break;
										                        		
						case "No":
						Cough = false;
								
								
						break;
					}
				}
			}            
		);
			
			
			
			
			
		ThroatBox.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String currentQuantity = (String)ThroatBox.getSelectedItem();
									                       
					switch(currentQuantity) {
									                        	
						case "Yes":
						Throat = true;
								
								
						break;
										                        		
						case "No":
						Throat = false;
								
								
						break;
					}
							
				}
			}            
		);
			
		
		
		RecentlyBox.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String currentQuantity = (String)RecentlyBox.getSelectedItem();
									                       
					switch(currentQuantity) {
									                        	
						case "Yes":
						Recently = true;
							
								
						break;
										                        		
						case "No":
						Recently = false;
								
								
						break;
					}
							
				}
			}            
		);
			
			
		setVisible(true);
			
	}



	//This will return the result of the currently selected options once the check result button is pressed
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Check) {
			
		
		test = calc.calctest();
		resultLabel.setText("Chance of having corona is " + test);
		}
		
		
		if(e.getSource() == Link) {
			try {
			    Desktop.getDesktop().browse(new URL("https://coronavirus.jhu.edu/map.html").toURI());
			} catch (Exception d) {}
		}
	}
}




















