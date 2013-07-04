package com.ibm.event;

import java.util.ArrayList;
import java.util.Hashtable;

public class ProcessEventContainer {
	private Hashtable<String, ArrayList<ProcessEvent>> container = new Hashtable<String, ArrayList<ProcessEvent>>();

	public int getProcessInstance(String processName) {
		if (!container.containsKey(processName))
			return 0;

		return container.get(processName).size();
	}

	public void addProcess(ProcessEvent pe) {
		if (!container.containsKey(pe.getProcName())) {
			ArrayList<ProcessEvent> l = new ArrayList<ProcessEvent>();
			l.add(pe);
			container.put(pe.getProcName(), l);
			return;
		}

		container.get(pe.getProcName()).add(pe);
		return;
	}
}
