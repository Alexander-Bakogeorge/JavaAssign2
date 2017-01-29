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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemovefItemListener implements ActionListener {

	//calls the remove first method on the object(only works on the traincar)
	//@param ActionEvent e, not used
	public void actionPerformed(ActionEvent e) {
		DrawComponent.list.get(0).removefirst();
	}

}
