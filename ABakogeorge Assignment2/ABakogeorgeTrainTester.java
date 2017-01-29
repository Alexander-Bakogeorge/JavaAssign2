//******************************************//
//	NAME: ALEXANDER BAKOGEORGE				//
//	DATE: April 8th, 2016					//
//	PROGRAM: CPS209 ASSIGNMENT 2			//
//------------------------------------------//
//	This program allows the user to draw	//
//	a train car, rail cars, and a queue of 	//
//	container crates to the screen. The		//
//	user is then able to manipulate the 	//
//	objects, moving them around the screen.	//
//	The user can then link rail cars and 	//
//	the train car together, and using the 	//
//	menu, hook the rail cars behind the 	//
//	train car, or at the end of the list	//
//	Afterwards, the user can remove the 	//
//	rail cars through the menu, from either	//
//	the front or the back as well. the user	//
//	can also add and remove the containers 	//
//	from the queue, and add them to the 	//
//	rail cars								//
//******************************************//

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Main Method
public class ABakogeorgeTrainTester {

	//ArrayList<Vehicle> list = new ArrayList<Vehicle>();
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		//Add a new frame and resize it
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);   
	    frame.setLayout(new BorderLayout());
	    
	    //Creates a new DrawComponent object and adds it to the frame
	    DrawComponent drawer = new DrawComponent();
	    frame.add(drawer);
	    
	    //Makes a new JMenuBar and adds it to the frame
	    JMenuBar menubar = new JMenuBar();
	    frame.setJMenuBar(menubar);
	    
	    //Makes the drop down menu file
	    JMenu file = new JMenu("File");
	    menubar.add(file);
	    
	    //Adds the buttons new and exit to the drop down menu
	    JMenuItem newitem = new JMenuItem("New");
	    JMenuItem exit = new JMenuItem("Exit");
	    file.add(newitem);
	    file.add(exit);
	    
	    //Adds the respective action listeners to each button
	    ActionListener listen1 = new ExitItemListener();
	    ActionListener listen2 = new NewItemListener();
	    exit.addActionListener(listen1);
	    newitem.addActionListener(listen2);
	    
	    //Makes the drop down menu list
	    JMenu list = new JMenu("List");
	    menubar.add(list);
	    
	    //Adds the buttons Add First, Add Last, Remove First, and Remove last to the drop down menu
	    JMenuItem addf = new JMenuItem("Add First");
	    JMenuItem addl = new JMenuItem("Add Last");
	    JMenuItem rmf = new JMenuItem("Remove First");
	    JMenuItem rml = new JMenuItem("Remove Last");
	    list.add(addf);
	    list.add(addl);
	    list.add(rmf);
	    list.add(rml);
	    
	    //Adds the respective action listeners to each button
	    ActionListener listen3 = new AddfItemListener();
	    addf.addActionListener(listen3);
	    ActionListener listen4 = new AddlItemListener();
	    addl.addActionListener(listen4);
	    ActionListener listen5 = new RemovefItemListener();
	    rmf.addActionListener(listen5);
	    ActionListener listen6 = new RemovelItemListener();
	    rml.addActionListener(listen6);
	    
	    //Makes the drop down menu Queue
	    JMenu queue = new JMenu("Queue");
	    menubar.add(queue);
	    
	    //Adds the buttons Remove and Add to the drop down menu
	    JMenuItem rm = new JMenuItem("Remove");
	    JMenuItem add = new JMenuItem("Add");
	    queue.add(rm);
	    queue.add(add);
	     
	    //Adds the respective action listeners to the buttons
	    ActionListener listen7 = new AddQueueListener();
	    add.addActionListener(listen7);
	    ActionListener listen8 = new RemoveQueueListener();
	    rm.addActionListener(listen8);
	    
	    //sets the frame to visible 
	    frame.setVisible(true);
	}
	
	

}
