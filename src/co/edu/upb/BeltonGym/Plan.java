package co.edu.upb.BeltonGym;
import java.time.LocalDate;
import java.time.Month;
public class Plan {
	
	private String plan;
    private double value;
    private int durationDay = 0;
    private int durationMonth = 0;
    private int durationYear = 0;
    private String description;
    private int totalTimesAdquired = 0;



    // Constructor
    public Plan() {
    }
    public Plan(String plan, double value, String description, int durationDay, int durationMonth, int durationYear) {
        this.plan = plan;
        this.value = value;
        this.description = description;
        this.durationDay = durationDay;
        this.durationMonth = durationMonth;
        this.durationYear = durationYear;
    }
    //getters and setter
    public int getDurationDay() {
		return durationDay;
	}

	public void setDurationDay(int durationDay) {
		this.durationDay = durationDay;
	}

	public int getDurationMonth() {
		return durationMonth;
	}

	public void setDurationMonth(int durationMonth) {
		this.durationMonth = durationMonth;
	}

	public int getDurationYear() {
		return durationYear;
	}

	public void setDurationYear(int durationYear) {
		this.durationYear = durationYear;
	}

	// Getters y setters
    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public double getValue() {
        return value;
    }


    public String getDescription() {
        return description;
    }

   
    public int getTotalTimesAdquired() {
		return totalTimesAdquired;
	}
	public void setTotalTimesAdquired(int totalTimesAdquired) {
		this.totalTimesAdquired = totalTimesAdquired;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void incrementTotalTimesAdquired() {
        totalTimesAdquired++;
    }

}
