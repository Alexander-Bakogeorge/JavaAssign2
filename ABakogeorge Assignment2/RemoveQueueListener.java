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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveQueueListener implements ActionListener {

	//removes a queue object from the first avaliable one in a list of trailcars
	//@param ActionEvent e, not used
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < DrawComponent.list.size(); i++){
			if(DrawComponent.list.get(i).color == Color.RED)
			{
				if(DrawComponent.list.get(i) != DrawComponent.list.get(0) && DrawComponent.list.get(i).box != 0){
					DrawComponent.queue.add(DrawComponent.list.get(i).box);
					DrawComponent.list.get(i).box = 0;
				}
				else if(DrawComponent.list.get(i).next.box != 0){
					DrawComponent.queue.add(DrawComponent.list.get(i).next.box);
					DrawComponent.list.get(i).next.box = 0;
				}
				else if(DrawComponent.list.get(i).next.next.box != 0){
					DrawComponent.queue.add(DrawComponent.list.get(i).next.next.box);
					DrawComponent.list.get(i).next.next.box = 0;
				}
				else if(DrawComponent.list.get(i).next.next.next.box != 0){
					DrawComponent.queue.add(DrawComponent.list.get(i).next.next.next.box);
					DrawComponent.list.get(i).next.next.next.box = 0;
				}
				else if(DrawComponent.list.get(i).next.next.next.next.box != 0){
					DrawComponent.queue.add(DrawComponent.list.get(i).next.next.next.next.box);
					DrawComponent.list.get(i).next.next.next.next.box = 0;
				}
				else if(DrawComponent.list.get(i).next.next.next.next.next.box != 0){
					DrawComponent.queue.add(DrawComponent.list.get(i).next.next.next.next.next.box);
					DrawComponent.list.get(i).next.next.next.next.next.box = 0;
				}
				
			}
			
		}

	}

}
