package co.edu.upb.BeltonGym;



import  co.edu.upb.BeltonGym.GUI.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
    	
        String routeUserJson = "Users.json";
        String routePlanJson = "Plans.json";
        String routeStatsJson = "BusinessStatistics.json";
        
        List<User> users = JsonManager.readJsonArrayListUser(routeUserJson);
        List<Plan> plans = JsonManager.readJsonArrayListPlan(routePlanJson);
        BusinessStatistics statsManager = JsonManager.readJsonBusinessStatistics(routeStatsJson);

		MainPanel mainPanel = new MainPanel();
		mainPanel.setVisible(true);
           
            
        }// MAIN

           
    
    
	public static List<User> listReturnUserInactive(List<User> users) {
		List<User> oldUsers = new ArrayList<>();
		for (int ii = 0; ii < users.size(); ii++) {
			if (users.get(ii).isStatusPlan() == false) {
				oldUsers.add(users.get(ii));
				}
		}
		return oldUsers;
	}
	public static List<User> listReturnUserActive(List<User> users) {
		List<User> activeUsers = new ArrayList<>();
		for (int ii = 0; ii < users.size(); ii++) {
			if (users.get(ii).isStatusPlan() == true) {
				activeUsers.add(users.get(ii));
				}
		}
		return activeUsers;
	}
	
	public static void updateSubs(List<User> users, List<Plan> plans, String routeUser, BusinessStatistics stats, String routeStats, String routePlan) {
		Scanner in = new Scanner(System.in);
		List<User> oldUsers = listReturnUserInactive(users);
		int answer;

		int indexUser;
		Plan selectedPlan;
			System.out.println("Usuario que su plan vencido: ");
			System.out.println(stringUsersBasicData(oldUsers));
			System.out.println("Ingrese el numero del usuario al que desea Renovar la suscripción: ");
			indexUser = in.nextInt() - 1;
			in.nextLine();
			
			System.out.println("Desea renovar la suscripccion de:  " + oldUsers.get(indexUser).getName() + " " + oldUsers.get(indexUser).getId());
			System.out.println("1. Si 2.No" );
			answer = in.nextInt();
			in.nextLine();
			
			
			
			if(answer == 1) {
				
				selectedPlan = selectPlan(plans);
				registerPayment(selectedPlan, stats, routeStats);
				
				oldUsers.get(indexUser).setCurrentPlan(selectedPlan);
				selectedPlan.incrementTotalTimesAdquired();
				
				oldUsers.get(indexUser).setStatusPlan(true);
				oldUsers.get(indexUser).setDateLastPayment(LocalDate.now());
				oldUsers.get(indexUser).calDueDatePlan();
				oldUsers.get(indexUser).addToHistory("Ha renovado su suscripción.");
				stats.plusTotalSubs(1);
				stats.plusTotalProfits(selectedPlan.getValue());
				JsonManager.writeJsonBusinessStatistics(routeStats, stats);
				
				
				System.out.println("Suscripccion Renovada" );
				System.out.println();
				
				System.out.println("Cliente " + oldUsers.get(indexUser).getName() + " " + oldUsers.get(indexUser).getId() + " renovado: ");
				System.out.println();
				
				System.out.println("Nombre: " + oldUsers.get(indexUser).getName());
				System.out.println("Edad: " + oldUsers.get(indexUser).getAge());
				System.out.println("Genero: " + oldUsers.get(indexUser).getGender());
				System.out.println("Id: " + oldUsers.get(indexUser).getId());
				System.out.println("Plan actual: " + oldUsers.get(indexUser).getCurrentPlan().getPlan());
				System.out.println("Estado del plan: " + oldUsers.get(indexUser).statusPlanAsString());
				System.out.println("Fecha de ultimo pago: " + oldUsers.get(indexUser).getDateLastPayment());
				System.out.println("Fecha de vencimiento del plan: " + oldUsers.get(indexUser).getDueDatePlan());
			}
			JsonManager.writeJsonArrayListUser(routeUser, users);
			JsonManager.writeJsonArrayListPlan(routePlan, plans);
			
			
	}//updateSubs()
	public static void notifyUserDue(User user) { //This function checks if clients plan have expired
		
		if(user.getDueDatePlan().compareTo(LocalDate.now()) < 0) {
			System.out.println(user.getDueDatePlan() + " El plan " + user.getCurrentPlan() + " de " + user.getName() + " ha vencido");
		}
	}//NotifyUserDue

	public static void notifyUsertDue(List<User> users) {
		for(int ii = 0; ii < users.size(); ii++) {
			notifyUserDue(users.get(ii));
		}
	}//NotifyUserDue
	
	public static String stringPlanBasicData(List<Plan> plans) {
		String planData = "";
		int nmr;
		for(int ii = 0; ii < plans.size(); ii++) {
			nmr = ii + 1;
			planData +=  nmr + ".      " + plans.get(ii).getPlan() +  "      	"  + plans.get(ii).getValue() + "\n";
		}
		
		return planData;
	}
	public static String stringPlanData(List<Plan> plans, int ii) {
		Plan plan = plans.get(ii);
		String planData = "";
		planData += "Plan #" + (ii + 1) + "\n";
		planData += "Nombre: " + plan.getPlan() +"\n";
		planData += "Descripción: " + plan.getDescription() +"\n";
		planData += "Valor: " + plan.getValue() + "\n";
		planData += "Duración: " + plan.getDurationYear() + " años con "
                + plan.getDurationMonth() + " meses y "
                + plan.getDurationDay() + " días" + "\n"
				+ "Total de veces adquirido: " + plan.getTotalTimesAdquired() + "\n";	
		return planData;
	}
	 public static String stringUsersBasicData(List<User> users) {
		 String usersBasicData = "";
		 int nmr = 0;
		 
		 for(int ii = 0; ii < users.size(); ii++) {
				nmr = ii + 1;
				usersBasicData += nmr + ".      " + users.get(ii).getName() + "      " + users.get(ii).getId() +"\n";
			}
		 
		 return usersBasicData;
	 }
	 public static String stringUsersBasicDataWithDue(List<User> users) {
		 String usersBasicData = "";
		 int nmr = 0;
		 
		 for(int ii = 0; ii < users.size(); ii++) {
				nmr = ii + 1;
				usersBasicData += nmr + ".      " + users.get(ii).getName() + "      " + users.get(ii).getId() + "      " + users.get(ii).getDueDatePlan() +"\n";
			}
		 
		 return usersBasicData;
	 }
	 public static String stringReturnUserData(List<User> users, int ii) { //This method return user's data as String
		 	String stringReturn = "";
			int index = ii - 1;
			
			stringReturn += "Nombre: " + users.get(index).getName() +"\n";
			stringReturn += "Edad: " + users.get(index).getAge() + "\n";
			stringReturn += "Genero: " + users.get(index).getGender()+"\n";
			stringReturn += "Id: " + users.get(index).getId()+"\n";
			stringReturn += "Plan actual: " + users.get(index).getCurrentPlan().getPlan()+"\n";
			stringReturn += "Estado del plan: " + users.get(index).statusPlanAsString()+"\n";
			stringReturn += "Fecha de ultimo pago: " + users.get(index).getDateLastPayment()+"\n";
			stringReturn += "Fecha de vencimiento del plan: " + users.get(index).getDueDatePlan()+"\n";
			stringReturn += "-----Historial de Usuario-----" + "\n";
			stringReturn += users.get(index).getHistory()+"\n";
			
			
			return stringReturn;
	 }
	 public static String stringReturnUserData(User user) { //This method return user's data as String
		 	String stringReturn = "";			
			stringReturn += "Nombre: " + user.getName() +"\n";
			stringReturn += "Edad: " + user.getAge() + "\n";
			stringReturn += "Genero: " + user.getGender()+"\n";
			stringReturn += "Id: " + user.getId()+"\n";
			stringReturn += "Plan actual: " + user.getCurrentPlan().getPlan()+"\n";
			stringReturn += "Estado del plan: " + user.statusPlanAsString()+"\n";
			stringReturn += "Fecha de ultimo pago: " + user.getDateLastPayment()+"\n";
			stringReturn += "Fecha de vencimiento del plan: " + user.getDueDatePlan()+"\n";
			stringReturn += "-----Historial de Usuario-----" + "\n";
			stringReturn += user.getHistory()+"\n";
			
			return stringReturn;
	 }
	public static void menuUsers(List<User> users) {
		
		int index;
		int nmr = 0;
		System.out.println("Los siguientes son los usuarios registrados: ");
		 
		System.out.println(stringUsersBasicData(users));
		Scanner t =   new Scanner(System.in); 
		System.out.println("Ingrese numero de usuario que desea seleccionar ");
		index = t.nextInt();
		t.nextLine();
		System.out.println(stringReturnUserData(users, index));
		

		
	}//MenuUsers()
	
	public static void registerUser(List<User> users, List<Plan> plans, String routeUsers, BusinessStatistics stats, String routeStats, String routePlan) {
		Scanner cc = new Scanner(System.in); 
		
		String name;
		int age;
		String id;
		String gender;
		Plan currentPlan;
		
		
		System.out.println("Ingrese nombre del usuario: ");
		name = cc.nextLine();
		System.out.println("Ingrese edad del usuario: ");
		age = cc.nextInt();
		cc.nextLine();
		System.out.println("Ingrese documento de identidad del usuario: ");
		id = cc.nextLine();
		System.out.println("Ingrese genero del usuario: ");
		gender = cc.nextLine();
		System.out.println("Ingrese el plan que va a adquirir el usuario: ");
		currentPlan = selectPlan(plans);
		registerPayment(currentPlan, stats, routeStats);
		
		User user = new User(name,age, id, gender);
		
		stats.plusTotalSubs(1);
		stats.plusTotalProfits(currentPlan.getValue());
		
		
		user.setCurrentPlan(currentPlan);
		currentPlan.incrementTotalTimesAdquired();
		user.setStatusPlan(true);
		user.setDateLastPayment(LocalDate.now());
		user.calDueDatePlan(); 
		user.addToHistory("Se ha registrado.");
		
		users.add(user);
		JsonManager.writeJsonBusinessStatistics(routeStats, stats);
		JsonManager.writeJsonArrayListUser(routeUsers, users);
		JsonManager.writeJsonArrayListPlan(routePlan, plans);
	}//RegisterUser()
	

    public static Plan selectPlan(List<Plan> plans) {
        Scanner in = new Scanner(System.in);

        System.out.println("Planes Disponibles:");
        for (int i = 0; i < plans.size(); i++) {
            Plan plan = plans.get(i);
            System.out.println((i + 1) + ". " + plan.getPlan());
        }

        System.out.println("Elija un plan ingresando el número correspondiente:");
        int choice = in.nextInt();

        if (choice >= 1 && choice <= plans.size()) {
            return plans.get(choice - 1);
        } else {
            System.out.println("Selección no válida. Seleccionando el primer plan por defecto.");
            return plans.get(0);
        }
    }
    

    public static void addPlan(List<Plan> plans, String routePlans) {
        String nombre;
        String description;
        int durationYear, durationMonth, durationDay;
        int value;
        Scanner in = new Scanner(System.in);

        System.out.println("Nombre del plan: ");
        nombre = in.nextLine();
        System.out.println("Ingrese el costo del plan: ");
        value = in.nextInt();
        in.nextLine();
        System.out.println("Ingrese una breve descripción del plan: ");
        description = in.nextLine();
        System.out.println("Ingrese cuantos años va a durar el plan: ");
        durationYear = in.nextInt();
        in.nextLine();
        System.out.println("Ingrese cuantos meses va a durar el plan: ");
        durationMonth = in.nextInt();
        in.nextLine();
        System.out.println("Ingrese cuantos dias va a durar el plan: ");
        durationDay = in.nextInt();
        in.nextLine();

        plans.add(new Plan(nombre, value, description, durationDay, durationMonth, durationYear));
        JsonManager.writeJsonArrayListPlan(routePlans, plans);
    }

    public static void menuFreezeDueDate(List<User> users, String route) { // this function freezes the plan and creates a new due date

        Scanner scanner = new Scanner(System.in);
        int index;
        int nmr = 0;
        List<User> usersActive = new ArrayList<>();

        for (int ii = 0; ii < users.size(); ii++) {
            if (users.get(ii).isStatusPlan()) {
                usersActive.add(users.get(ii));
            }
        }

        System.out.println("Los siguientes son los usuarios activos: ");

        for (int ii = 0; ii < usersActive.size(); ii++) {
            nmr = ii + 1;
            System.out.println(nmr + ". " + usersActive.get(ii).getName() + " " + usersActive.get(ii).getId());
        }

        System.out.println("Ingrese el numero del usuario al que desea congelar su mensualidad: ");
        index = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Ingrese el número de días para congelar el plan:");
        int daysToFreeze = scanner.nextInt();
        scanner.nextLine();

        LocalDate lastDueDate = usersActive.get(index).getDueDatePlan();
        LocalDate newDueDate = lastDueDate.plusDays(daysToFreeze);
        usersActive.get(index).setDueDatePlan(newDueDate);
        usersActive.get(index).addToHistory("Ha congelado su mensualidad por " + daysToFreeze + " días.");

        System.out.println("El plan de " + usersActive.get(index).getName() + " ha sido congelado por " + daysToFreeze + " días.");
        System.out.println("La antigua fecha de vencimiento era: " + lastDueDate);
        System.out.println("La nueva fecha de vencimiento es: " + usersActive.get(index).getDueDatePlan());
        JsonManager.writeJsonArrayListUser(route, users);
    }//MenuFreeseDueDate()

    public static void registerPayment(Plan plan, BusinessStatistics stats, String routeStats) {
        Scanner in = new Scanner(System.in);
        int choice;

        System.out.println("Metodos de pago: ");
        System.out.println("1. Pago con Tarjeta");
        System.out.println("2. Pago en efectivo");
        System.out.println("3. Transferencia bancaria");

        System.out.println();
        System.out.println("Elija su método de pago: ");
        choice = in.nextInt();

        switch (choice) {
            case 1: {
                stats.plusProfitCardPayment(plan.getValue());
                stats.plusTimesCardPayment(1);
                System.out.println("Has registrado exitosamente tu metodo de pago con tarjeta");
                JsonManager.writeJsonBusinessStatistics(routeStats, stats);
                break;
            }
            case 2: {
                stats.plusProfitCashPayment(plan.getValue());
                stats.plusTimesCashPayment(1);
                System.out.println("Has registrado exitosamente tu metodo de pago en efectivo");
                JsonManager.writeJsonBusinessStatistics(routeStats, stats);
                break;
            }
            case 3: {
                stats.plusProfitBankTransfer(plan.getValue());
                stats.plusTimesBankTransfer(1);
                System.out.println("Has registrado exitosamente tu metodo de pago por transferencia bancaria");
                JsonManager.writeJsonBusinessStatistics(routeStats, stats);
                break;
            }
            default:
                System.out.println("No existe la opción que ingresaste");
        }

    }

    public static void banUsers(List<User> users, String routeUsers) {

        Scanner t = new Scanner(System.in);
        int index;
        int nmr = 0;
        int choice;
        System.out.println("Los siguientes son los usuarios registrados: ");
        for (int ii = 0; ii < users.size(); ii++) {
            nmr = ii + 1;
            System.out.println(nmr + ". " + users.get(ii).getName() + " " + users.get(ii).getId() + " " + users.get(ii).bannedAsString());
        }
        System.out.println("Ingrese el numero del usuario que desea ver: ");
        index = t.nextInt() - 1;
        t.nextLine();
        User user = users.get(index);
        if (user.isBanned() == false) {
            System.out.println("Desea banear a este usuario: ");
            System.out.println("1. Si 2.No");
            choice = t.nextInt();
            t.nextLine();
            if (choice == 1) {
                System.out.println("El usuario " + users.get(index).getName() + "ha sido baneado");
                user.setBanned(true);
                user.addToHistory("Ha sido baneado.");
                JsonManager.writeJsonArrayListUser(routeUsers, users);
            } else {
                System.out.println("Accion cancelada ");
            }
        } else {
            System.out.println("Desea desbanear a este usuario: ");
            System.out.println("1. Si 2.No");
            choice = t.nextInt();
            t.nextLine();
            if (choice == 1) {
                System.out.println("El usuario " + users.get(index).getName() + "ha sido desbaneado");
                user.setBanned(false);
                user.addToHistory("Ha sido desbaneado.");
                JsonManager.writeJsonArrayListUser(routeUsers, users);
            } else {
                System.out.println("Accion cancelada ");
            }
        }//BannedUsers

    }

    public static void menuPlans(List<Plan> plans) {
        System.out.println("Planes Disponibles:");
        for (int i = 0; i < plans.size(); i++) {
            Plan plan = plans.get(i);
            System.out.println("Plan #" + (i + 1));
            System.out.println("Nombre: " + plan.getPlan());
            System.out.println("Descripción: " + plan.getDescription());
            System.out.println("Valor: " + plan.getValue());
            System.out.println("Duración: " + plan.getDurationYear() + " años con "
                    + plan.getDurationMonth() + " meses y "
                    + plan.getDurationDay() + " días");
            System.out.println();
        }
    }
    
    public static void menuUserHistory(List<User> users) {
    Scanner in = new Scanner(System.in);

    System.out.println("Seleccione un usuario para ver su historial:");
    for (int i = 0; i < users.size(); i++) {
        System.out.println((i + 1) + ". " + users.get(i).getName());
    }

    int userIndex = in.nextInt() - 1;
    in.nextLine();  // Limpiar el buffer del scanner

    if (userIndex >= 0 && userIndex < users.size()) {
        User selectedUser = users.get(userIndex);
        System.out.println("Historial de " + selectedUser.getName() + ":");
        System.out.println(selectedUser.getHistory());
    } else {
        System.out.println("Selección de usuario no válida.");
    }
}
}
   

