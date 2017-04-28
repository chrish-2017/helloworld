package test.helloworld.web.bean;

import java.io.Serializable;

public class WfLeave implements Serializable {
	private static final long serialVersionUID = 1L;
	private String leaveid;
	private String name;
	private Integer leaveCount;
	private String leaveReason;
	private String instanceid;

	public String getLeaveid() {
	 	return leaveid;
	}
	
	public void setLeaveid(String leaveid) {
	 	this.leaveid = leaveid;
	}
	
	public String getName() {
	 	return name;
	}

	public void setName(String name) {
	 	this.name = name;
	}

	public Integer instanceid() {
	 	return leaveCount;
	}

	public void setLeaveCount(Integer leaveCount) {
	 	this.leaveCount = leaveCount;
	}

	public String getLeaveReason() {
	 	return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
	 	this.leaveReason = leaveReason;
	}

	public String getInstanceid() {
	 	return instanceid;
	}

	public void setInstanceid(String instanceid) {
	 	this.instanceid = instanceid;
	}
}