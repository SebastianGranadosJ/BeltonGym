package co.edu.upb.BeltonGym;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonManager {

	public static void writeJsonArrayListUser(String route, List<User> users) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());
	        objectMapper.writeValue(new File(route), users);
	      
	    } catch (IOException e) {
	        System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public static void writeJsonBusinessStatistics(String route, BusinessStatistics stats) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());
	        objectMapper.writeValue(new File(route), stats);
	        
	    } catch (IOException e) {
	        System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public static void writeJsonArrayListPlan(String route, List<Plan> plans) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());
	        objectMapper.writeValue(new File(route), plans);
	  
	    } catch (IOException e) {
	        System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public static List<Plan> readJsonArrayListPlan(String route) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());

	        return objectMapper.readValue(new File(route), new TypeReference<List<Plan>>() {});
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo JSON: " + e.getMessage());
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	}

	public static List<User> readJsonArrayListUser(String route) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());

	        return objectMapper.readValue(new File(route), new TypeReference<List<User>>() {});
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo JSON: " + e.getMessage());
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	}

	public static BusinessStatistics readJsonBusinessStatistics(String route) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());

	        return objectMapper.readValue(new File(route), new TypeReference<BusinessStatistics>() {});
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo JSON: " + e.getMessage());
	        e.printStackTrace();
	        return null;
	    }
	}
}
