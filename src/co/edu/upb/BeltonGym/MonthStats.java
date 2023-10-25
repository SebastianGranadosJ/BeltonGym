package co.edu.upb.BeltonGym;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;

public class MonthStats {
	
	private Month month = LocalDate.now().getMonth();
	private int year = LocalDate.now().getYear();
	private int monthlySubs = 0;
	private double monthlyProfits = 0;
	
	private double profitCardPayment = 0; // Total profit using as payment method Card Payment
	private double profitCashPayment = 0;  // Total profit using as payment method Cash Payment
	private double profitBankTransfer = 0;  // Total profit using as payment method Bank Transfer
	
	private int timesCardPayment = 0;// Total times that someone pay with Card Payment
	private int timesCashPayment = 0;// Total times that someone pay with Cash Payment
	private int timesBankTransfer = 0;// Total times that someone pay with Bank Transfer

	public MonthStats() {
	}
	public Month getMonth() {
		return month;
	}
	public String nameMonth() {
		String name = month + " " + year + ".";
		return name;
	}

	public void setMonth(Month month) {
		this.month = month;
	}
	public void displayPlanAdquisitionStatistics(List<Plan> plans) {	 
        System.out.println("Plan / Cantidad de veces adquirido");
        for (int ii = 0; ii < plans.size(); ii++) {
        	System.out.println(plans.get(ii).getPlan() + ": " + plans.get(ii).getTotalTimesAdquired() + " veces");	
        }
    }
	
	 public static int activeSuscriptions(List<User> users) {
	        int activeClients = 0;
	        
	        for (int ii = 0; ii < users.size(); ii++) {
	           if(users.get(ii).isStatusPlan()) {
	        	   activeClients ++;
	           }
	        }
	        
	        return activeClients;
	    }//ActiveSuscription()
	 
	 public static int inactiveSuscriptions(List<User> users) {
	        int inactiveClients = 0;
	        
	        for (int ii = 0; ii < users.size(); ii++) {
	           if(users.get(ii).isStatusPlan() == false) {
	        	   inactiveClients ++;
	           }
	        }
	        
	        return inactiveClients;
	    }//InactiveSuscription()
	 public void profitPlans(List<Plan> plans) {
			for (int ii = 0; ii < plans.size(); ii++) {
				double gain = 0;
				int a = plans.get(ii).getTotalTimesAdquired();
				gain = (a  * plans.get(ii).getValue());
				System.out.println("El plan " + plans.get(ii).getPlan() + " ha generado: " + gain+ " $"); 
			}
		}//profitPlans
	 
	 public String monthDataAsString () {
		 String dataReturn = "";
		 
		 dataReturn += "Mes: " + month + "\n";
		 dataReturn += "Ganancias Mensuales: " + monthlyProfits + "\n";
		 dataReturn += "Subscripciones Mensuales: " + monthlySubs + "\n\n";
		 dataReturn += "Ganancias de pago con tarjeta: " + profitCardPayment + "\n";
		 dataReturn += "Ganancias de pago con efectivo: " + profitCashPayment + "\n";
		 dataReturn += "Ganancias de trasnferencias bancarias: " + profitBankTransfer + "\n\n";
		 dataReturn += "Veces pagadas con tarjeta: " + timesCardPayment + "\n";
		 dataReturn += "Veces pagadas con efectivo: " +timesCashPayment + "\n";
		 dataReturn += "Veces pagadas con trasnferencias bancarias: " + timesBankTransfer + "\n";
		 dataReturn += "----------------------------------------------------------------";
		 
		 return dataReturn;
	 }
	 
	 
	 
	//---------------------Plus Amount----------------------------------
	public void plusMonthlySubs(int amt) {
			monthlySubs += amt;
	}
	public void plusMonthlyProfits(double amt) {
		monthlyProfits += amt;
	}
	public void plusProfitCardPayment(double amt) {
		profitCardPayment += amt;
	}
	
	public void plusProfitCashPayment(double amt) {
		profitCashPayment += amt;
	}
	
	public void plusProfitBankTransfer(double amt) {
		profitBankTransfer += amt;
	}
	
	
	public void plusTimesCardPayment(int amt) {
		timesCardPayment += amt;
	}
	
	public void plusTimesCashPayment(int amt) {
		timesCashPayment += amt;
	}
	
	public void plusTimesBankTransfer(int amt) {
		timesBankTransfer += amt;
	}

	
	//------------------------Getters and Setters-----------------------------

	public double getProfitCardPayment() {
		return profitCardPayment;
	}

	public void setProfitCardPayment(double profitCardPayment) {
		this.profitCardPayment = profitCardPayment;
	}

	public double getProfitCashPayment() {
		return profitCashPayment;
	}

	public void setProfitCashPayment(double profitCashPayment) {
		this.profitCashPayment = profitCashPayment;
	}

	public double getProfitBankTransfer() {
		return profitBankTransfer;
	}

	public void setProfitBankTransfer(double profitBankTransfer) {
		this.profitBankTransfer = profitBankTransfer;
	}

	public int getTimesCardPayment() {
		return timesCardPayment;
	}

	public void setTimesCardPayment(int timesCardPayment) {
		this.timesCardPayment = timesCardPayment;
	}

	public int getTimesCashPayment() {
		return timesCashPayment;
	}

	public void setTimesCashPayment(int timesCashPayment) {
		this.timesCashPayment = timesCashPayment;
	}

	public int getTimesBankTransfer() {
		return timesBankTransfer;
	}

	public void setTimesBankTransfer(int timesBankTransfer) {
		this.timesBankTransfer = timesBankTransfer;
	}

	public int getMonthlyySubs() {
		return monthlySubs;
	}

	public void setMonthlyySubs(int monthlyySubs) {
		this.monthlySubs = monthlyySubs;
	}

	public double getMonthlyProfits() {
		return monthlyProfits;
	}

	public void setMonthlyProfits(double monthlyProfits) {
		this.monthlyProfits = monthlyProfits;
	}
	@Override
	public String toString() {
		return "MonthStats [month=" + month + ", year=" + year + ", monthlySubs=" + monthlySubs + ", monthlyProfits="
				+ monthlyProfits + ", profitCardPayment=" + profitCardPayment + ", profitCashPayment="
				+ profitCashPayment + ", profitBankTransfer=" + profitBankTransfer + ", timesCardPayment="
				+ timesCardPayment + ", timesCashPayment=" + timesCashPayment + ", timesBankTransfer="
				+ timesBankTransfer + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonthlySubs() {
		return monthlySubs;
	}
	public void setMonthlySubs(int monthlySubs) {
		this.monthlySubs = monthlySubs;
	}

	
	
}
	