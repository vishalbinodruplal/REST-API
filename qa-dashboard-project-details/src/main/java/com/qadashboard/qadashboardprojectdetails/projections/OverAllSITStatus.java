package com.qadashboard.qadashboardprojectdetails.projections;

public class OverAllSITStatus {
	
	public String releaseTime;
	public double passPercent;
	public double failPercent;
	
	public OverAllSITStatus(){
		
	}
	
	public OverAllSITStatus(String releaseTime, double passPercent,
			double failPercent) {
		super();
		this.releaseTime = releaseTime;
		this.passPercent = passPercent;
		this.failPercent = failPercent;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public double getPassPercent() {
		return passPercent;
	}

	public void setPassPercent(double passPercent) {
		this.passPercent = passPercent;
	}

	public double getFailPercent() {
		return failPercent;
	}

	public void setFailPercent(double failPercent) {
		this.failPercent = failPercent;
	}
	
	

}
