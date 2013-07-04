package event.capture;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SocketClientCaptureJob implements Job {
	private String remoteIp;
	private int remotePort;
	private String osCommand;
	
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap config = arg0.getJobDetail().getJobDataMap();
	}
	
}
