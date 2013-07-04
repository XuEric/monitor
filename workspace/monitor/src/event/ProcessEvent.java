package event;

public class ProcessEvent {

	/* Format: host#user#exec#arg#instNo host： 主机名，或者ip，能够唯一标识网络中的一个AIX实例 */
	/*
	 * user：用户名
	 */
	/*
	 * exec：执行程序名，例如java, find, db2agent
	 */
	/*
	 * arg：程序参数，用于区分使用同一个执行程序名启动的不同进程
	 */
	/*
	 * instNo：用相同的执行程序名和程序参数启动的实例的序号
	 */
	/* 例如： cbod适配器实例1 :52.96.32.2#esb#java#cbod-1#1 */
	/* 文件传输进程1 ： 52.96.32.2#esb#mp_main_exec#NA#1 */
	/* 文件传输进程2： /* 52.96.32.2#esb#mp_main_exec#NA#2 */
	private String procInstName = null; // 进程实例名称

	/*
	 * Format: host#user#exec#arg
	 */
	private String procName = null;// 进程名称
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
