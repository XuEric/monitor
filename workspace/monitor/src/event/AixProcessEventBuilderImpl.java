package event;

import java.util.ArrayList;
import java.util.List;


public class AixProcessEventBuilderImpl implements ProcessEventBuilder {

	@Override
	public ProcessEvent[] build(String s) {
		List<ProcessEvent> l = new ArrayList<ProcessEvent>();
		//TODO: 根据命令输出，生成ProcessEvent数组
		
		return (ProcessEvent[]) l.toArray();
	}

}
