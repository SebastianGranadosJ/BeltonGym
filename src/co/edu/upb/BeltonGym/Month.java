package co.edu.upb.BeltonGym;

import java.time.LocalDate;


public class Month {
	

	private double profitCardPayment = 0; // Total profit using as payment method Card Payment
	private double profitCashPayment = 0;  // Total profit using as payment method Cash Payment
	private double profitBankTransfer = 0;  // Total profit using as payment method Bank Transfer
	
	private int timesCardPayment = 0;// Total times that someone pay with Card Payment
	private int timesCashPayment = 0;// Total times that someone pay with Cash Payment
	private int timesBankTransfer = 0;// Total times that someone pay with Bank Transfer
	private int monthlySubs = 0;
	private double monthlyProfits = 0;

	java.time.Month month =   LocalDate.now().getMonth();
	int year = LocalDate.now().getYear();





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



	//Getters and setters
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

	public int getMonthlySubs() {
		return monthlySubs;
	}

	public void setMonthlySubs(int monthlySubs) {
		this.monthlySubs = monthlySubs;
	}

	public double getMonthlyProfits() {
		return monthlyProfits;
	}

	public void setMonthlyProfits(double monthlyProfits) {
		this.monthlyProfits = monthlyProfits;
	}
}