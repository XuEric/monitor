package event.cep;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import event.ProcessEvent;
import event.listener.UpdateListenerWithEpl;

public class EventService {
	private static EventService instance;
	private static EPServiceProvider epService;
	static {
		instance = new EventService();
		Configuration config = new Configuration();
		config.addEventTypeAutoName(ProcessEvent.class.getPackage().getName());
		epService = EPServiceProviderManager.getDefaultProvider(config);

	}
	
	public static EventService getInstance() {
		return instance;
	}

	public void addListener(UpdateListenerWithEpl listener) {
		EPStatement statement = epService.getEPAdministrator().createEPL(
				listener.getEpl());
		statement.addListener(listener);
	}

	public void sendEvent(Object event) {
		epService.getEPRuntime().sendEvent(event);
	}
}
