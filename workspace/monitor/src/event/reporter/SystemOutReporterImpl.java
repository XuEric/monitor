package event.reporter;

public class SystemOutReporterImpl implements Reporter {

	@Override
	public void report(String s) {
		System.out.println(s);
	}

}
