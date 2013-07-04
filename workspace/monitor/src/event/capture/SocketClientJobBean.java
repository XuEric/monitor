package event.capture;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


import event.ProcessEvent;
import event.ProcessEventBuilder;
import event.cep.EventService;

public class SocketClientJobBean extends QuartzJobBean {

	private String ip;
	private int port;
	private String cmd;
	private ProcessEventBuilder processEventBuilder;
	private EventService eventService;

	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		System.out.println("exec:" + new Date());
		// TODO: connect to remote agent, send command , then read the command
		// out
		String s = "...........";
		
		// TODO: build process event with builder
		ProcessEvent[] events = processEventBuilder.build(s);
		
		// TODO: send the event to event service
		for (ProcessEvent processEvent : events) {
			eventService.sendEvent(processEvent);
		}

	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public String getCmd() {
		return cmd;
	}

	public ProcessEventBuilder getProcessEventBuilder() {
		return processEventBuilder;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setProcessEventBuilder(ProcessEventBuilder processEventBuilder) {
		this.processEventBuilder = processEventBuilder;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

}