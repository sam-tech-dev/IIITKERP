/**
 * 
 */
package scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Joey
 *
 */
public class Test {
	
public static void main(String[] args) throws SchedulerException {
	run();
}
public static void run()throws SchedulerException{
	 JobDetail job = JobBuilder.newJob(SecondaryJob.class)
             .withIdentity("MagiJob", "group2").build(); 
	
	 Trigger trigger1 = TriggerBuilder.newTrigger()
             .withIdentity("cronTrigger2", "group1")
             .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) 
             .build(); 
	
//	 Iterator<Scheduler> iterator = new StdSchedulerFactory().getAllSchedulers().iterator();
//	 while(iterator.hasNext()){
//		 
//		 System.out.println(iterator.next().getSchedulerName());
//	 }
	// Scheduler scheduler = new StdSchedulerFactory().getScheduler("NON_CLUSTERED");
	// System.out.println(scheduler.getSchedulerName());
	// scheduler.addJob(job, false);
	 Scheduler scheduler=MyApp.scheduler1;
	  scheduler.start();
	 scheduler.scheduleJob(job,trigger1);

     
//	Calendar today = Calendar.getInstance();
////	today.set(Calendar.HOUR_OF_DAY, 18);
////	today.set(Calendar.MINUTE,19);
////	today.set(Calendar.SECOND, 0);
//	today.set(Calendar.MILLISECOND, 200);
//
//	// every night at 2am you run your task
// timer = new Timer();
//	//timer.schedule(new Task(), today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms
//  //timer.cancel();
//	timer.schedule(new Task(), 0, 1000);
}




}
