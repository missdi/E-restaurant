package com.bionic.edu;

import java.sql.Date;

public class Report {
	private double sum;
	private long qty;
	private Date dt;
	
	public Report() {}
		
	public Report(long qty, double sum) {		
		this.sum = sum;		
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "Report [sum=" + sum + ", qty=" + qty + "]";
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	
	
}
