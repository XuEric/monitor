package event;

public class ProcessEvent {

	/* Format: host#user#exec#arg#instNo host�� ������������ip���ܹ�Ψһ��ʶ�����е�һ��AIXʵ�� */
	/*
	 * user���û���
	 */
	/*
	 * exec��ִ�г�����������java, find, db2agent
	 */
	/*
	 * arg�������������������ʹ��ͬһ��ִ�г����������Ĳ�ͬ����
	 */
	/*
	 * instNo������ͬ��ִ�г������ͳ������������ʵ�������
	 */
	/* ���磺 cbod������ʵ��1 :52.96.32.2#esb#java#cbod-1#1 */
	/* �ļ��������1 �� 52.96.32.2#esb#mp_main_exec#NA#1 */
	/* �ļ��������2�� /* 52.96.32.2#esb#mp_main_exec#NA#2 */
	private String procInstName = null; // ����ʵ������

	/*
	 * Format: host#user#exec#arg
	 */
	private String procName = null;// ��������
	private int instNo = -1;
	
	// these information come directly from "ps -ef"
	private String host;
	private String user;
	private int pid;
	private int ppid;
	private String stime;
	private String time;
	private String cmd;

	private String psOut;
	
	public ProcessEvent(String psOut) {
		this.psOut = psOut;
	}

	public String getPsOut() {
		return psOut;
	}

	public void setProcInstName(String procInstName) {
		this.procInstName = procInstName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setPpid(int ppid) {
		this.ppid = ppid;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setPsOut(String psOut) {
		this.psOut = psOut;
	}

	public ProcessEvent(String procInstName, String procName, String host,
			String user, int pid, int ppid, String stime, String time,
			String cmd) {
		super();
		this.procInstName = procInstName;
		this.procName = procName;
		this.host = host;
		this.user = user;
		this.pid = pid;
		this.ppid = ppid;
		this.stime = stime;
		this.time = time;
		this.cmd = cmd;
	}

	public String getProcInstName() {
		return procInstName;
	}

	public String getProcName() {
		return procName;
	}

	public String getHost() {
		return host;
	}

	public String getUser() {
		return user;
	}

	public int getPid() {
		return pid;
	}

	public int getPpid() {
		return ppid;
	}

	public String getStime() {
		return stime;
	}

	public String getTime() {
		return time;
	}

	public String getCmd() {
		return cmd;
	}

	public int getInstNo() {
		return instNo;
	}

	public void setInstNo(int instNo) {
		this.instNo = instNo;
	}
}
