/**
 * 
 */
package scheduler;

import java.util.TimerTask;

/**
 * @author Joey
 *
 */
public class Task extends TimerTask {
int frustration=0;
	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("mag");
		frustration++;
	//	if(frustration>3)Test.timer.cancel();
//Test.timer.cancel();
	}

}
