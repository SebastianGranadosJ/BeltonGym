package co.edu.upb.BeltonGym;
import java.util.List;
import java.time.LocalDate;

public class User {

    private String name;
    private int age;
    private String gender; // m = masculino, f = femenino
    private String id;
    private Plan currentPlan;
    private boolean statusPlan;
    private LocalDate dateLastPayment;
    private LocalDate dueDatePlan;
    private boolean banned = false;
    private String history = "";

    public User() {

    }

    public User(String name, int age, String id, String gender) {
        setName(name);
        setAge(age);
        setId(id);
        setGender(gender);
    }

    public void calDueDatePlan() { // Calculate dueDatePlan
        LocalDate dateTmp;

        dateTmp = dateLastPayment.plusDays(currentPlan.getDurationDay());
        dateTmp = dateTmp.plusMonths(currentPlan.getDurationMonth());
        dateTmp = dateTmp.plusYears(currentPlan.getDurationYear());

        setDueDatePlan(dateTmp);

    }

    //Fecha Historial
    public void addToHistory(String action) {
        LocalDate currentDate = LocalDate.now();
        String entry = currentDate.toString() + " - " + this.name + " (" + this.id + "): " + action;
        this.history += entry + "\n";
    }

    //------------------Getters and Setters------------------//
    public String getHistory() {
        return history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Plan getCurrentPlan() {
        return currentPlan;
    }

    public void setCurrentPlan(Plan currentPlan) {
        this.currentPlan = currentPlan;
    }

    public boolean isStatusPlan() {
        return statusPlan;
    }

    public String statusPlanAsString() {
        if (statusPlan) {
            return "Activo";
        } else {
            return "Vencido";
        }
    }

    public void setStatusPlan(boolean statusPlan) {
        this.statusPlan = statusPlan;
    }

    public LocalDate getDateLastPayment() {
        return dateLastPayment;
    }

    public void setDateLastPayment(LocalDate dateLastPayment) {
        this.dateLastPayment = dateLastPayment;
    }

    public LocalDate getDueDatePlan() {
        return dueDatePlan;
    }

    public void setDueDatePlan(LocalDate dueDatePlan) {
        this.dueDatePlan = dueDatePlan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isBanned() {
        return banned;
    }

    public String bannedAsString() {
        if (banned) {
            return "BANNED";
        } else {
            return "No Banned";
        }
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

	public void setHistory(String history) {
		this.history = history;
	}
    public static void updatePlanStatus(List<User> users) {
        LocalDate currentDate = LocalDate.now();

        for (User user : users) {
            if (user.isStatusPlan()) {
                LocalDate dueDate = user.getDueDatePlan();
                if (currentDate.isAfter(dueDate)) {
                    user.setStatusPlan(false); // Cambia el estado del plan a inactivo
                    user.addToHistory("Plan vencido");
                }
            }
        }
    }

}
