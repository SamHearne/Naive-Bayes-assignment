import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;



//this class presents a simple gui
public class gui  extends JFrame implements ActionListener {
	
	public static int tempNo = 1;
	int test = 0;
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
	JLabel label1,label2,label3,label4,label5,label6;
		
		
	//panels are used to control where attributes will appear (see below)
	JPanel topPanel1;
	
		

	public gui(String title) {
	
	
		
		//Using a title given by control to title the border
		super(title);
			
			
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
			label1 = new JLabel("Temperature :");
			label2 = new JLabel("Aches :");
			label3 = new JLabel("Cough :");
			label4 = new JLabel("Sore Throat :");
			label5 = new JLabel("Recent Contact :");
			label6 = new JLabel("Result :");
			
			
			
			
			
			
			//creating jpanels
			
			topPanel1 = new JPanel();
			
			
			
			
			topPanel1.add(label1);
			topPanel1.add(TempBox);
			topPanel1.add(label2);
			topPanel1.add(AchesBox);
			topPanel1.add(label3);
			topPanel1.add(CoughBox);
			topPanel1.add(label4);
			topPanel1.add(ThroatBox);
			topPanel1.add(label5);
			topPanel1.add(RecentlyBox);
			topPanel1.add(label6);
			add(topPanel1,BorderLayout.NORTH);
			
			
			
			
			TempBox.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String currentQuantity = (String)TempBox.getSelectedItem();
							                    
							switch(currentQuantity) {
									                        	
								case "Hot":
									tempNo = 1;
									
									calc.calctest();
								
								break;
										                        		
								case "Cold":
									tempNo = 2;
									calc.calctest();
									
								break;
								
								
								
								case "Cool":
									tempNo = 3;
									calc.calctest();
									
								break;
								
								
								
								case "Normal":
									tempNo = 4;
									calc.calctest();
								
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
							calc.calctest();
							break;
									                        		
							case "No":
							Aches = false;
							calc.calctest();
							
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
								calc.calctest();
								
								break;
										                        		
								case "No":
								Cough = false;
								calc.calctest();
								
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
								calc.calctest();
								
								break;
										                        		
								case "No":
								Throat = false;
								calc.calctest();
								
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
								calc.calctest();
								
								break;
										                        		
								case "No":
								Recently = false;
								calc.calctest();
								
								break;
							}
							
						}
					}            
				);
			
			
			setVisible(true);
			
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}



















