package co.edu.upb.BeltonGym;
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
		
		
		List<User> users = new ArrayList<>();
		List<Plan> plans = new ArrayList<>();
		BusinessStatistics statsManager = new BusinessStatistics();

		plans = readJsonArrayListPlan(routePlanJson);
		users = readJsonArrayListUser(routeUserJson);
		statsManager = readJsonBusinessStatistics(routeStatsJson);
		
		 Scanner in = new Scanner(System.in);
         int choice,otro;
         otro=1;
		
		/*
	
	        plans.add(new Plan("1 Mes", 60000, "Plan mensual", 0, 1, 0));
	        plans.add(new Plan("2 Semanas", 35000, "Plan de 2 semanas", 14, 0 , 0));
	        plans.add(new Plan("1 Semana", 20000, "Plan de 1 semana", 7, 0 , 0));
	        plans.add(new Plan("1 Dia", 8000, "Plan diario", 1, 0 , 0));
	        plans.add(new Plan("1 Año", 660000, "Plan anual", 0, 0 , 1));
       
				
		/*
		users.add( new User("Angelica Rincon", 12, "0002129", "f"));
		users.get(users.size() - 1).setCurrentPlan(plans.get(0));
		users.get(users.size() - 1).setStatusPlan(false);
		users.get(users.size() - 1).setDateLastPayment(LocalDate.of(2002, Month.MARCH, 02));
		users.get(users.size() - 1).calDueDatePlan();
		
		users.add(new User("Samuel de Luque", 39, "10231921", "m"));
		users.get(users.size() - 1).setCurrentPlan(plans.get(1));
		users.get(users.size() - 1).setStatusPlan(false);
		users.get(users.size() - 1).setDateLastPayment(LocalDate.of(2002, Month.MARCH, 02));
		users.get(users.size() - 1).calDueDatePlan();
		
		users.add(new User("Ramon Martinez", 19, "109312821", "m"));
		users.get(users.size() - 1).setCurrentPlan(plans.get(2));
		users.get(users.size() - 1).setStatusPlan(false);
		users.get(users.size() - 1).setDateLastPayment(LocalDate.of(2002, Month.MARCH, 02));
		users.get(users.size() - 1).calDueDatePlan();
		
	*/
		
		
		
		//writeJsonArrayListPlan(routePlanJson, plans);
		//writeJsonArrayListUser(routeUserJson, users);
		//registerUser(users, plans, routeUserJson, statsManager, routeStatsJson, routePlanJson );
		//updateSubs(users, plans, routeUserJson, statsManager, routeStatsJson, routePlanJson);
        //menuFreezeDueDate(users, routeUserJson);
		
        //
        
		//menuUsers(users);

		
		//statsManager.menuDisplayBusinessData(users, plans);
		//menuPlans(plans);
		//banUsers(users,routeUserJson);
		
		//addPlan(plans,routePlanJson);
        //menuUsers(users);
		
            while(otro==1){
            	
                System.out.println("1. Menú de Usaurios");
                System.out.println("2. Estadísticas del Negocio");
                System.out.println("3. Registrar Usaurio");
                System.out.println("4. Renovar Suscripción");
                System.out.println("5. Congelar Mensualidad");
                System.out.println("6. Banear Usaurio");
                System.out.println("7. Menú de Planes");
                System.out.println("8. Añadir Plan");
                System.out.println("9. Notificaciones");
                System.out.println("10. Cerrar Programa");
                
                choice = in.nextInt();
                in.nextLine();
                switch(choice){
                    case 1:
                        menuUsers(users);
                        break;
                    case 2:
                        statsManager.menuDisplayBusinessData(users, plans);
                        break;
                    case 3:
                        registerUser(users, plans, routeUserJson, statsManager, routeStatsJson, routePlanJson );
                        break;
                    case 4:
                        updateSubs(users, plans, routeUserJson, statsManager, routeStatsJson, routePlanJson);
                        break;
                    case 5:
                        menuFreezeDueDate(users, routeUserJson);
                        break;
                    case 6:
                        banUsers(users,routeUserJson);
                        break;
                    case 7:
                    	Main.menuPlans(plans);
                        break;
                    case 8:
                    	addPlan(plans,routePlanJson);
                        break;
                    case 9:
                    	System.out.println("---------------NOTIFICACIONES---------------");
                    	notifyUsertDue(users);
                    	System.out.println("--------------------------------------------");
                        break;
                    default:
                    	System.out.println("Ingrese un valor valido");
                }
            }
            in.close();
        }// MAIN
	
	public static void updateSubs(List<User> users, List<Plan> plans, String routeUser, BusinessStatistics stats, String routeStats, String routePlan) {
		Scanner in = new Scanner(System.in);
		List<User> oldUsers = new ArrayList<>();
		int answer;
		int nmr;
		int indexUser;
		Plan selectedPlan;
		
			for (int ii = 0; ii < users.size(); ii++) {
				if (users.get(ii).isStatusPlan() == false) {
					oldUsers.add(users.get(ii));
					}
			}
		//System.out.println("Quiere renovar cliente?");
			System.out.println("Los siguientes son los usuarios con el plan vencido: ");
			for(int ii = 0; ii < oldUsers.size(); ii++) {
				nmr = ii + 1;
				System.out.println(nmr + ". " + oldUsers.get(ii).getName()+ " " + oldUsers.get(ii).getId());
			}
			
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
				
				stats.plusTotalSubs(1);
				stats.plusTotalProfits(selectedPlan.getValue());
				writeJsonBusinessStatistics(routeStats, stats);
				
				
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
			writeJsonArrayListUser(routeUser, users);
			writeJsonArrayListPlan(routePlan, plans);
			
			
	}//updateSubs()
	
	public static void notifyUserDue(User user) { //This function checks if clients plan have expired
		
		if(user.getDueDatePlan().compareTo(LocalDate.now()) < 0) {
			System.out.println(user.getDueDatePlan() + " El plan " + user.getCurrentPlan().getPlan() + " de " + user.getName() + " ha vencido");
		}
	}//NotifyUserDue

	public static void notifyUsertDue(List<User> users) {
		for(int ii = 0; ii < users.size(); ii++) {
			notifyUserDue(users.get(ii));
		}
	}//NotifyUserDue
	 
	public static void menuUsers(List<User> users) {
		Scanner t = new Scanner(System.in);
		int index;
		int nmr = 0;
		System.out.println("Los siguientes son los usuarios registrados: ");
		for(int ii = 0; ii < users.size(); ii++) {
			nmr = ii + 1;
			System.out.println(nmr + ". " + users.get(ii).getName() + " " + users.get(ii).getId());
		}
		
		System.out.println("Ingrese el numero del usuario al que desea ver la informacion: ");
		index = t.nextInt() - 1;
		t.nextLine();
		System.out.println("Nombre: " + users.get(index).getName());
		System.out.println("Edad: " + users.get(index).getAge());
		System.out.println("Genero: " + users.get(index).getGender());
		System.out.println("Id: " + users.get(index).getId());
		System.out.println("Plan actual: " + users.get(index).getCurrentPlan().getPlan());
		System.out.println("Estado del plan: " + users.get(index).statusPlanAsString());
		System.out.println("Fecha de ultimo pago: " + users.get(index).getDateLastPayment());
		System.out.println("Fecha de vencimiento del plan: " + users.get(index).getDueDatePlan());
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
		writeJsonBusinessStatistics(routeStats, stats);
		
		user.setCurrentPlan(currentPlan);
		currentPlan.incrementTotalTimesAdquired();
		user.setStatusPlan(true);
		user.setDateLastPayment(LocalDate.now());
		user.calDueDatePlan(); 
		
		users.add(user);
		writeJsonArrayListUser(routeUsers, users);
		writeJsonArrayListPlan(routePlan, plans);
	}//RegisterUser()
	
	public static Plan selectPlan(List<Plan> plans) {
		Scanner in = new Scanner(System.in);
		int indexPlan;
		
		System.out.println("Seleccione el plan que desea: ");
		for(int ii = 0; ii < plans.size(); ii++) {
			System.out.println( ii + 1 + ". " + plans.get(ii).getPlan());
		}
		indexPlan = in.nextInt() - 1;
		in.nextLine();
		return plans.get(indexPlan);
	}//SelectPlan()
	
	public static void writeJsonArrayListUser(String route, List<User> users) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			 objectMapper.registerModule(new JavaTimeModule());
			objectMapper.writeValue(new File(route), users);
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void writeJsonBusinessStatistics(String route, BusinessStatistics stats) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			 objectMapper.registerModule(new JavaTimeModule());
			objectMapper.writeValue(new File(route), stats);
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void writeJsonArrayListPlan(String route, List<Plan> plans) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			 objectMapper.registerModule(new JavaTimeModule());
			objectMapper.writeValue(new File(route), plans);
		} catch (IOException e) {
            e.printStackTrace();
        }
	}//WriteJsonArrayPlan()
	
	
	public static List<Plan> readJsonArrayListPlan(String route) {
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());

			return objectMapper.readValue(new File(route), new TypeReference<List<Plan>>() {});
			
			
			
		}catch(IOException e) {
            e.printStackTrace();
            return null;
        }
	}//ReadJsonArrayListPlan()
	
	public static List<User> readJsonArrayListUser(String route) {
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());

			return objectMapper.readValue(new File(route), new TypeReference<List<User>>() {});
			
			
			
		}catch(IOException e) {
            e.printStackTrace();
            return null;
        }
	}//ReadJsonArrayListUser()
public static BusinessStatistics readJsonBusinessStatistics(String route) {
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());

			return objectMapper.readValue(new File(route), new TypeReference<BusinessStatistics>() {});
			
			
			
		}catch(IOException e) {
            e.printStackTrace();
            return null;
        }
	}//ReadJsonArrayListUser()
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
    	writeJsonArrayListPlan(routePlans, plans);
    }
	public static void menuFreezeDueDate(List<User> users, String route) { // this function freezes the plan and creates a new due date
			
	        Scanner scanner = new Scanner(System.in);
			int index;
			int nmr = 0;
			List<User> usersActive = new ArrayList<>();
			
			for(int ii = 0; ii < users.size(); ii++) {
				if(users.get(ii).isStatusPlan())
					usersActive.add(users.get(ii));
			}
			
			System.out.println("Los siguientes son los usuarios activos: ");
			
			for(int ii = 0; ii < usersActive.size(); ii++) {
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

            System.out.println("El plan de " + usersActive.get(index).getName() + " ha sido congelado por " + daysToFreeze + " días.");
            System.out.println("La antigua fecha de vencimiento era: " + lastDueDate);
            System.out.println("La nueva fecha de vencimiento es: " + usersActive.get(index).getDueDatePlan());
            writeJsonArrayListUser(route, users);
    }//MenuFreeseDueDate()
	public static void registerPayment(Plan plan, BusinessStatistics stats, String routeStats) {
		Scanner in = new Scanner(System.in);
		int choice;
		
		System.out.println("Metodos de pago: " );
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
				writeJsonBusinessStatistics(routeStats, stats);
				break;
			} 
			case 2: {
				stats.plusProfitCashPayment(plan.getValue());
				stats.plusTimesCashPayment(1);
				System.out.println("Has registrado exitosamente tu metodo de pago en efectivo");
				writeJsonBusinessStatistics(routeStats, stats);
				break;
			}
			case 3: {
				stats.plusProfitBankTransfer(plan.getValue());
				stats.plusTimesBankTransfer(1);
				System.out.println("Has registrado exitosamente tu metodo de pago por transferencia bancaria");
				writeJsonBusinessStatistics(routeStats, stats);
				break;
			}
			default:
				System.out.println("No existe la opción que ingresaste");
			}
	
	}
public static void banUsers(List <User> users, String routeUsers) {
		
		Scanner t = new Scanner(System.in);
		int index;
		int nmr = 0;
		int choice;
		System.out.println("Los siguientes son los usuarios registrados: ");
		for(int ii = 0; ii < users.size(); ii++) {
			nmr = ii + 1;
			System.out.println(nmr + ". " + users.get(ii).getName() + " " + users.get(ii).getId() + " " + users.get(ii).bannedAsString());
		}
		System.out.println("Ingrese el numero del usuario que desea ver: ");
		index = t.nextInt() - 1;
		t.nextLine();
		User user = users.get(index);
		if(user.isBanned() == false) {
			System.out.println("Desea banear a este usuario: " );
			System.out.println("1. Si 2.No" );
			choice = t.nextInt();
			t.nextLine();
			if(choice == 1) {
				System.out.println("El usuario " + users.get(index).getName() + "ha sido baneado");
				user.setBanned(true);
				writeJsonArrayListUser(routeUsers, users);
			}else {
				System.out.println("Accion cancelada ");
			}
		}else {
			System.out.println("Desea desbanear a este usuario: ");
			System.out.println("1. Si 2.No" );
			choice = t.nextInt();
			t.nextLine();
			if(choice == 1) {
				System.out.println("El usuario " + users.get(index).getName() + "ha sido desbaneado");
				user.setBanned(false);
				writeJsonArrayListUser(routeUsers, users);
			}else {
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
	        System.out.println("Duración: " + plan.getDurationYear() + " años con " +
	                           plan.getDurationMonth() + " meses y " +
	                           plan.getDurationDay() + " días");
	        System.out.println();
	    }
}
	
	
}
