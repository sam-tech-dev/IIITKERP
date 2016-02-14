/**
 * 
 */
package scheduler;

/**
 * @author Joey
 *
 */
import java.util.Date;

 
import org.quartz.JobExecutionContext; 
import org.quartz.JobExecutionException; 
  
public class SecondaryJob implements org.quartz.Job{  
      
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job --->>> Hello Megha! Time is " + new Date());
        }  
} 
