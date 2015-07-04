package com.bionic.edu;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named
@Scope("request")
public class ReportBean implements Serializable{
	
	private Report report1;	
	private List<Report> report2;	
	private java.util.Date daily;
	private java.util.Date d1;
	private java.util.Date d2;
	private int qtyPeriod ;
	private double sumPeriod; 
	private BarChartModel barModelQty;
	private BarChartModel barModelSum;
	private int foodCatId;
	private int foodCatId2;
	
	@Inject
	OrdersService ordersService;	

	public java.util.Date getDaily() {
		return daily;
	}

	public void setDaily(java.util.Date daily) {
		this.daily = daily;
	}

	public java.util.Date getD1() {
		return d1;
	}

	public void setD1(java.util.Date d1) {
		this.d1 = d1;
	}

	public java.util.Date getD2() {
		return d2;
	}

	public void setD2(java.util.Date d2) {
		this.d2 = d2;
	}

	public Report getReport1() {
		return report1;
	}

	public void setReport1(Report report1) {
		this.report1 = report1;
	}
			
	public List<Report> getReport2() {
		return report2;
	}

	public void setReport2(List<Report> report2) {
		this.report2 = report2;
	}	


	public int getQtyPeriod() {
		return qtyPeriod;
	}

	public void setQtyPeriod(int qtyPeriod) {
		this.qtyPeriod = qtyPeriod;
	}

	public double getSumPeriod() {
		return sumPeriod;
	}

	public void setSumPeriod(double sumPeriod) {
		this.sumPeriod = sumPeriod;
	}
		
	public BarChartModel getBarModelQty() {
		return barModelQty;
	}

	public void setBarModelQty(BarChartModel barModelQty) {
		this.barModelQty = barModelQty;
	}

	public BarChartModel getBarModelSum() {
		return barModelSum;
	}

	public void setBarModelSum(BarChartModel barModelSum) {
		this.barModelSum = barModelSum;
	}	

	public int getFoodCatId() {
		return foodCatId;
	}

	public void setFoodCatId(int foodCatId) {
		this.foodCatId = foodCatId;
	}
	
	public int getFoodCatId2() {
		return foodCatId2;
	}

	public void setFoodCatId2(int foodCatId2) {
		this.foodCatId2 = foodCatId2;
	}
	
	//------------------------------------------------------------


	public Date getSQLDate (java.util.Date d){
		try{
		return new java.sql.Date(d.getTime());}
		catch (NullPointerException e){
			return java.sql.Date.valueOf(LocalDate.now());
		}
	}

	public void getReportDaily(){
		Date d = getSQLDate(daily);
		if(foodCatId==0){
			report1= ordersService.getSumQty(d);
		}
		else{
			report1= ordersService.getSumQtyFoodCat(d, foodCatId);
		}
	}	 
		 
	public void getReportPeriod(){
		Date d1SQL = getSQLDate(d1);
		Date d2SQL = getSQLDate(d2);		
		if(foodCatId2==0){
		report2=ordersService.getOrderReport(d1SQL, d2SQL);}
		else {
			report2=ordersService.getSumQtyFoodCatPeriod(d1SQL, d2SQL, foodCatId2);
		}
		for(Report r: report2){
			qtyPeriod = (int) (qtyPeriod+r.getQty());
			sumPeriod = sumPeriod + r.getSum();
		}
	}
	
	public void clickDaily() {		 
		 getReportDaily();
	     RequestContext requestContext = RequestContext.getCurrentInstance();	         
	     requestContext.update("form:display");	     
	}
	
	public void clickPeriod() {		 
		 getReportPeriod();
	     RequestContext requestContext = RequestContext.getCurrentInstance();	         
	     requestContext.update("formPeriod");		 
	    init();
	    
	}
	
	@PostConstruct
	public void init() {		
		createBarModelQty();
		createBarModelSum();
    }		
	
	 private void createBarModelQty() {	
		 Date d1SQL = getSQLDate(d2);
		 Date d2SQL = getSQLDate(d1);
		 LocalDate ld2 = d1SQL.toLocalDate();
		 LocalDate t1 = d2SQL.toLocalDate(); 
		 long days = Period.between(t1, ld2).getDays();
		 
		 barModelQty = new BarChartModel();	  	   
		 ChartSeries qty = new ChartSeries();
		 qty.setLabel("Qty");   
		 
		 
		 for (long i=0; i<=days; i++){	        	
			 Date d = Date.valueOf(t1);	
			 long qty1=0;
			 if(foodCatId2==0){
				 qty1 = ordersService.getQtyDate(d);
			}
			 else {
				 qty1 = ordersService.getQtyDateFC(d, foodCatId2); 
			 }
			 qty.set(d, qty1);    			
			 t1 = t1.plusDays(1);        	
		 }      
		 		 
		 barModelQty.addSeries(qty);

		 barModelQty.setTitle("Orders Qty Statictics");
		 barModelQty.setLegendPosition("ne");
	         
		 Axis xAxis = barModelQty.getAxis(AxisType.X);
		 xAxis.setLabel("Period");         
		 
		 Axis yAxis = barModelQty.getAxis(AxisType.Y);
		 yAxis.setLabel("Qty");
		 yAxis.setMin(0);     
	 }
	 
	 private void createBarModelSum() {	
		 Date d1SQL = getSQLDate(d2);
		 Date d2SQL = getSQLDate(d1);
		 LocalDate ld2 = d1SQL.toLocalDate();
		 LocalDate t1 = d2SQL.toLocalDate(); 
		 long days = Period.between(t1, ld2).getDays();
		 
		 barModelSum = new BarChartModel();	  	   
		 ChartSeries sum = new ChartSeries();
		 sum.setLabel("Sum");   
		 
		 
		 for (long i=0; i<=days; i++){	        	
			 Date d = Date.valueOf(t1);	
			 double summa=0;
			 if (foodCatId2==0){
				 summa = ordersService.getSumDate(d);
			}
			 else {
				 summa = ordersService.getSumDateFC(d, foodCatId2);
			 }
			 sum.set(d, summa);    			
			 t1 = t1.plusDays(1);        	
		 }      
		 		 
		 barModelSum.addSeries(sum);

		 barModelSum.setTitle("Orders Sum Statictics");
		 barModelSum.setLegendPosition("ne");
	         
		 Axis xAxis = barModelSum.getAxis(AxisType.X);
		 xAxis.setLabel("Period");         
		 
		 Axis yAxis = barModelSum.getAxis(AxisType.Y);
		 yAxis.setLabel("Sum");
		 yAxis.setMin(0);     
	 }
	 
	 
     
}
