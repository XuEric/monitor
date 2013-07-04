package com.ibm.event.capture;

import java.util.ArrayList;
import java.util.List;

import com.ibm.event.AixProcessEventBuilderImpl;
import com.ibm.event.ProcessEvent;
import com.ibm.event.ProcessEventBuilder;
import com.ibm.event.cep.EventService;
import com.ibm.event.listener.StrangerListenerImpl;
import com.ibm.event.reporter.SystemOutReporterImpl;

public class Main {

	public static void main(String[] args) {

		List<String> whiteList = new ArrayList<String>();
		whiteList.add("proc_10");
		whiteList.add("proc_11");
		whiteList.add("proc_12");
		whiteList.add("proc_13");
		whiteList.add("proc_14");
		whiteList.add("proc_15");
		whiteList.add("proc_16");
		whiteList.add("proc_17");
		whiteList.add("proc_18");

		EventService.getInstance()
				.addListener(
						new StrangerListenerImpl(whiteList,
								new SystemOutReporterImpl()));

		ProcessEventBuilder builder = new AixProcessEventBuilderImpl();

		for (int x = 0; x < 10; x++) {
			ProcessEvent[] peList = builder.build("zzzzzzz");
			for (ProcessEvent processEvent : peList) {
				EventService.getInstance().sendEvent(processEvent);
			}

			sleep(1);
		}
	}

	public static void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}
}
