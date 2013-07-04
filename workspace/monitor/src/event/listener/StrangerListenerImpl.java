package event.listener;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.espertech.esper.client.EventBean;

import event.reporter.Reporter;

public class StrangerListenerImpl implements UpdateListenerWithEpl {
	private static final String epl = "select distinct procName, cmd "
			+ "from ProcessEvent.win:time(3 sec) output every 3 seconds";

	private List<String> whitelist;
	private Reporter reporter;

	public StrangerListenerImpl(List<String> whitelist, Reporter reporter) {
		super();
		this.whitelist = whitelist;
		this.reporter = reporter;
	}

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		Hashtable<String, EventBean> events = new Hashtable<String, EventBean>();
		System.out.print("updated:");
		for (EventBean event : newEvents) {
			events.put((String) event.get("procName"), event);
		}
		
		//删除在白名单中的进程
		events.keySet().removeAll(whitelist);

		//报告异常进程
		for (Iterator<String> iterator = events.keySet().iterator(); iterator
				.hasNext();) {
			String s = iterator.next();
			reporter.report("stranger: " + s + ", CMD:"+ events.get(s).get("cmd"));
		}

		events.clear();
		return;
	}

	@Override
	public String getEpl() {
		return epl;
	}

}
