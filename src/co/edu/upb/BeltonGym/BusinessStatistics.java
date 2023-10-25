package co.edu.upb.BeltonGym;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class BusinessStatistics {
	private int totalSubs = 0;
	private double totalProfits = 0;
	
	private double profitCardPayment = 0; // Total profit using as payment method Card Payment
	private double profitCashPayment = 0;  // Total profit using as payment method Cash Payment
	private double profitBankTransfer = 0;  // Total profit using as payment method Bank Transfer
	
	private int timesCardPayment = 0;// Total times that someone pay with Card Payment
	private int timesCashPayment = 0;// Total times that someone pay with Cash Payment
	private int timesBankTransfer = 0;// Total times that someone pay with Bank Transfer
	
	private MonthStats currentMonth = new MonthStats();
	
	List<MonthStats>historyMonths = new ArrayList<>();

	public BusinessStatistics() {
	
	} 
	//----------------Functions--------------------
	public String menuDisplayMonthsData() {
		String dataReturn = "";
		for(int ii = 0; ii< historyMonths.size(); ii++) {
			dataReturn += historyMonths.get(ii).monthDataAsString() + "\n";
		}
		return dataReturn;
	}
	public void addCurrentMont() {
		historyMonths.add(currentMonth);
	}
	public void incrementTotalUsers() {
        totalSubs++;
	}
	public String displayPlanAdquisitionStatistics(List<Plan> plans) {	 
        String stringReturn = "Plan / Cantidad de veces adquirido / Ganancias\n";
        for (int ii = 0; ii < plans.size(); ii++) {
        	double gain = 0;
			int a = plans.get(ii).getTotalTimesAdquired();
			gain = (a  * plans.get(ii).getValue());
        	stringReturn += plans.get(ii).getPlan() + ":   " + plans.get(ii).getTotalTimesAdquired() + " veces   " + gain + "$\n" ;	
        }
        return stringReturn;
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
	 public String menuDisplayBusinessData(List<User> users, List<Plan> plans) {
		 
		 String returnString = "";
		 
		 returnString += "----------Estadisticas Generales----------\n";
		 
		 returnString += "Las ganancias del negocio son: " + getTotalProfits() + "\n";
		
		 returnString +="El total de suscripccion adquiridas es: " + getTotalSubs()  + "\n" ;
		
		 returnString += "Las suscripcciones activas son: " + activeSuscriptions(users) + "\n";
		 
		 returnString += "Las suscripcciones inactivas son: " + inactiveSuscriptions(users) + "\n\n"; 
		 
		 returnString += "Ganancias de pago con tarjeta: " + profitCardPayment + "\n";
		 returnString += "Ganancias de pago con efectivo: " + profitCashPayment + "\n";
		 returnString += "Ganancias de trasnferencias bancarias: " + profitBankTransfer + "\n\n";
		 returnString += "Veces pagadas con tarjeta: " + timesCardPayment + "\n";
		 returnString += "Veces pagadas con efectivo: " +timesCashPayment + "\n";
		 returnString += "Veces pagadas con trasnferencias bancarias: " + timesBankTransfer + "\n\n";
		 
		 returnString += displayPlanAdquisitionStatistics(plans) + "\n";
		 
		 return returnString;
		 
	 }//MenuDisplayBusinessData()
	 
	 public String profitPlans(List<Plan> plans) {
		 String returnString = "";
			for (int ii = 0; ii < plans.size(); ii++) {
				double gain = 0;
				int a = plans.get(ii).getTotalTimesAdquired();
				gain = (a  * plans.get(ii).getValue());
				returnString += "El plan " + plans.get(ii).getPlan() + ":   " + gain+ " $\n"; 
			}
			return returnString;
		}//profitPlans
	 public String monthsBasicData (List<MonthStats>historyMonths) {
		 String monthReturn = "";
		 int cnt;
		 cnt = historyMonths.size() - 1;
		 int index;
		 
		 for (int ii = 0; ii < cnt; ii++) {
			 index = ii + 1;
			 monthReturn += index + ". " + historyMonths.get(cnt).nameMonth();
			 cnt--;
		 }
		 return monthReturn;
	 }
	 public void haveMonthChange() {
		 if (currentMonth.getMonth() != LocalDate.now().getMonth()) {
			 MonthStats currentMonth = new MonthStats(); 
			 historyMonths.add(currentMonth);
			 
		 }
		 
	 }
	//---------------------Plus Amount----------------------------------
	public void plusTotalSubs(int amt) {
			totalSubs += amt;
			currentMonth.plusMonthlySubs(amt);
		}
		
	public void plusTotalProfits(double amt) {
			totalProfits += amt;
			currentMonth.plusMonthlyProfits(amt);
		}
		
	public void plusProfitCardPayment(double amt) {
			profitCardPayment += amt;
			currentMonth.plusProfitCardPayment(amt);
		}
		
	public void plusProfitCashPayment(double amt) {
			profitCashPayment += amt;
			currentMonth.plusProfitCashPayment(amt);
		}
		
	public void plusProfitBankTransfer(double amt) {
			profitBankTransfer += amt;
			currentMonth.plusProfitBankTransfer(amt);
		}
		
		
	public void plusTimesCardPayment(int amt) {
			timesCardPayment += amt;
			currentMonth.plusTimesCardPayment(amt);
		}
		
	public void plusTimesCashPayment(int amt) {
			timesCashPayment += amt;
			currentMonth.plusTimesCashPayment(amt);
		}
		
	public void plusTimesBankTransfer(int amt) {
			timesBankTransfer += amt;
			currentMonth.plusTimesBankTransfer(amt);
		}


	
	//------------------------Getters and Setters-----------------------------
	public int getTotalSubs() {
		return totalSubs;
	}

	public void setTotalSubs(int totalSubs) {
		this.totalSubs = totalSubs;
	}

	public double getTotalProfits() {
		return totalProfits;
	}

	public void setTotalProfits(double totalProfits) {
		this.totalProfits = totalProfits;
	}

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
	
	public MonthStats getCurrentMonth() {
		return currentMonth;
	}
	public void setCurrentMonth(MonthStats currentMonth) {
		this.currentMonth = currentMonth;
	}
	public List<MonthStats> getHistoryMonths() {
		return historyMonths;
	}
	public void setHistoryMonths(List<MonthStats> historyMonths) {
		this.historyMonths = historyMonths;
	}
}
