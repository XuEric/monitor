package com.ibm.event.listener;

import com.espertech.esper.client.UpdateListener;

public interface UpdateListenerWithEpl extends UpdateListener {
	public String getEpl();
}
