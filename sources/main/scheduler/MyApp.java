/**
 * 
 */
package scheduler;

import java.util.Iterator;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @author Joey
 *
 */
public class MyApp {
	static Scheduler scheduler1;
	public static void main(String[] args) {
		run();
	}
	public static void run(){
		try { 
			JobDetail job = JobBuilder.newJob(Job.class)
					.withIdentity("JoeyJob", "group1").build(); 

			Trigger trigger1 = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger1", "group1") 
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")) 
					.build(); 

			scheduler1 = new StdSchedulerFactory().getScheduler();



			scheduler1.start();
			System.out.println(scheduler1.getSchedulerInstanceId());
			scheduler1.scheduleJob(job,trigger1);
			//	scheduler1.scheduleJob(job2, trigger2);
			Thread.sleep(1000000);

			scheduler1.shutdown();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
