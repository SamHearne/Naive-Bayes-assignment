import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




//this class presents a simple gui
public class gui  extends JFrame{
	
	

	//adding labels,buttons,panels etc
		JLabel label1,label2,label3,label4,label5,label6;
		
		
		//panels are used to control where attributes will appear (see below)
		JPanel topPanel1;
		
		

		public gui(String title) {
	
	
		
			//Using a title given by control to title the border
			super(title);
			
			
			
			
			//setting the size of the window and the layout
			setSize(600, 200);
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
			topPanel1.add(label2);
			topPanel1.add(label3);
			topPanel1.add(label4);
			topPanel1.add(label5);
			topPanel1.add(label6);
			add(topPanel1,BorderLayout.NORTH);
			
			
			setVisible(true);
	
	}
}