package co.edu.upb.BeltonGym.GUI;
import co.edu.upb.BeltonGym.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class RegisterUserPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldId;
	
	private String routeUserJson = "Users.json";
	private String routePlanJson = "Plans.json";
	private String routeStatsJson = "BusinessStatistics.json";
	
	
	private List<User> users = JsonManager.readJsonArrayListUser(routeUserJson);
	private List<Plan> plans =  JsonManager.readJsonArrayListPlan(routePlanJson);
	private BusinessStatistics statsManager = JsonManager.readJsonBusinessStatistics(routeStatsJson);
	private String payment = "";
	private String gender = "";
	private String planString = "";
	private Plan planUser = null;
	private String message = "Esperando datos.";
	private boolean allFields;
	

	public RegisterUserPanel() {
	
		//Attributes new User
	
		
		
		
		//
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBox.border"));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	//Banner
		
		
		JPanel panelBanner = new JPanel();
		contentPane.add(panelBanner, BorderLayout.NORTH);
		panelBanner.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelBanner.setLayout(new BorderLayout(0, 20));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagementPanel userManagementPanel = new UserManagementPanel();
				userManagementPanel.setVisible(true);
				dispose();
			}
		});
		panelBanner.add(btnNewButton, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Registrar Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBanner.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelFunctions = new JPanel();
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelData = new JPanel();
		panel.add(panelData);
		
		panelData.setLayout(new BorderLayout(0, 0));
		
		JPanel panelImputs = new JPanel();
		panelData.add(panelImputs);
		panelImputs.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAttribute = new JPanel();
		panelAttribute.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImputs.add(panelAttribute, BorderLayout.WEST);
		panelAttribute.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelName = new JPanel();
		panelName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelName);
		panelName.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelName.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panelAge = new JPanel();
		panelAge.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelAge);
		panelAge.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Edad:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelAge.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel panelID = new JPanel();
		panelID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelID);
		panelID.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Documento de Identidad:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelID.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel panelGender = new JPanel();
		panelGender.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelGender);
		panelGender.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Genero:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelGender.add(lblNewLabel_5, BorderLayout.CENTER);
		
		JPanel panelPlan = new JPanel();
		panelPlan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelPlan);
		panelPlan.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Plan:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlan.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JPanel panelPayment = new JPanel();
		panelPayment.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelPayment);
		panelPayment.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Metodo de Pago:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panelPayment.add(lblNewLabel_7, BorderLayout.CENTER);
		
		JPanel panelImput = new JPanel();
		panelImput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImputs.add(panelImput);
		panelImput.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelNameInput = new JPanel();
		panelNameInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelNameInput);
		panelNameInput.setLayout(new BorderLayout(0, 0));
		
		
		textFieldName = new JTextField();
		textFieldName.setText("");
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNameInput.add(textFieldName, BorderLayout.CENTER);
		textFieldName.setColumns(10);
		
		JPanel panelAgeInput = new JPanel();
		panelAgeInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelAgeInput);
		panelAgeInput.setLayout(new BorderLayout(0, 0));
		
		textFieldAge = new JTextField();
		textFieldAge.setText("");
		textFieldAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelAgeInput.add(textFieldAge, BorderLayout.CENTER);
		textFieldAge.setColumns(10);
		
		JPanel panelIdInput = new JPanel();
		panelIdInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelIdInput);
		panelIdInput.setLayout(new BorderLayout(0, 0));
		
		textFieldId = new JTextField();
		textFieldId.setText("");
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelIdInput.add(textFieldId, BorderLayout.CENTER);
		textFieldId.setColumns(10);
	
		JPanel panelGenderInput = new JPanel();
		panelGenderInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelGenderInput);
		panelGenderInput.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxGender.setToolTipText("Seleccione");
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Femenino"}));
		comboBoxGender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la opción seleccionada del ComboBox
                 gender = comboBoxGender.getSelectedItem().toString();
            }
        });
		
		panelGenderInput.add(comboBoxGender, BorderLayout.CENTER);
		
		JPanel panelPlanInput = new JPanel();
		panelPlanInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelPlanInput);
		panelPlanInput.setLayout(new BorderLayout(0, 0));
		
		JComboBox<String> comboBoxPlan = new JComboBox<>();
		comboBoxPlan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxPlan.setMaximumRowCount(30);
		comboBoxPlan.setToolTipText("");
		panelPlanInput.add(comboBoxPlan, BorderLayout.CENTER);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("");
		for(int ii = 0; ii < plans.size(); ii++) {
			model.addElement(plans.get(ii).getPlan());
		}
        comboBoxPlan.setModel(model);
        
		
		comboBoxPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la opción seleccionada del ComboBox
                planString = comboBoxPlan.getSelectedItem().toString();
                for(int ii = 0; ii <plans.size(); ii++) {
                	if (plans.get(ii).getPlan() == planString) {
                		planUser = plans.get(ii);
                	
                	}
                
                }
            }
        });
		
		
		
		
        JPanel panelPaymentInput = new JPanel();
        panelPaymentInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panelImput.add(panelPaymentInput);
        panelPaymentInput.setLayout(new BorderLayout(0, 0));
        
        JComboBox comboBoxPayment = new JComboBox();
        comboBoxPayment.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBoxPayment.setModel(new DefaultComboBoxModel(new String[] {"", "Efectivo", "Tarjeta", "Transferencia Bancaria"}));
        panelPaymentInput.add(comboBoxPayment, BorderLayout.CENTER);
        
        JPanel panelMessages = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelMessages.getLayout();
        flowLayout.setVgap(10);
        panel.add(panelMessages, BorderLayout.SOUTH);
        
        JLabel labelMessages = new JLabel(message);
        panelMessages.add(labelMessages);
        
        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
        flowLayout_1.setVgap(12);
        panel.add(panel_2, BorderLayout.NORTH);
        
        JLabel lblNewLabel_1 = new JLabel("Ingrese los datos del nuevo usuario, cuando todos los campos esten rellenados presione registrar.");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(lblNewLabel_1);
        
        JPanel panelRegister = new JPanel();
        contentPane.add(panelRegister, BorderLayout.SOUTH);
        
        JButton btnNewButton_1 = new JButton("Registrar");
       
        panelRegister.add(btnNewButton_1);
        comboBoxPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la opción seleccionada del ComboBox
               payment = comboBoxPayment.getSelectedItem().toString();
             
            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		allFields = true;
        		
        		if(payment == "") {
        			allFields = false;
        			message = "No es posible registrar el usuario, porfavor seleccione un METODO DE PAGO.";
        		
        		}
        		
        		if(planString == "") {
        			allFields = false;
        			message = "No es posible registrar el usuario, porfavor seleccione un PLAN.";
        		
        		}
        		
        		if(gender == "") {
        			allFields = false;
        			message = "No es posible registrar el usuario, porfavor seleccione un GENERO.";
        		
        		}
        		
        		if(textFieldId.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible registrar el usuario, porfavor ingrese el DOCUMENTO DE IDENTIDAD.";
        		}
        		if(textFieldAge.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible registrar el usuario, porfavor ingrese la EDAD.";
        		}
        		if(textFieldName.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible registrar el usuario, porfavor ingrese el NOMBRE.";
        		}
        		
        		labelMessages.setText(message);
        	
        		if(allFields) {
        			User user = new User();
        			
        			labelMessages.setText("Exitosamente registrado.");
        			user.setName(textFieldName.getText());
        			user.setAge(Integer.parseInt(textFieldAge.getText()));
        			user.setId(textFieldId.getText());
        			user.setGender(gender);
        			user.setCurrentPlan(planUser);
        			

					statsManager.plusTotalSubs(1);
					statsManager.plusTotalProfits(user.getCurrentPlan().getValue());
				
				
					user.getCurrentPlan().incrementTotalTimesAdquired();
					user.setStatusPlan(true);
					user.setDateLastPayment(LocalDate.now());
					user.calDueDatePlan(); 
					
					if(payment == "Tarjeta") {
						statsManager.plusProfitCardPayment(user.getCurrentPlan().getValue());
						statsManager.plusTimesCardPayment(1);
					}
					if(payment == "Efectivo") {
						statsManager.plusProfitCashPayment(user.getCurrentPlan().getValue());
						statsManager.plusTimesCashPayment(1);
					}
					if(payment == "Transferencia Bancaria") {
						statsManager.plusProfitBankTransfer(user.getCurrentPlan().getValue());
						statsManager.plusTimesBankTransfer(1);
					}
					
					users.add(user);
					user.addToHistory("Se ha registrado con el plan: " + user.getCurrentPlan().getPlan());
					JsonManager.writeJsonBusinessStatistics(routeStatsJson, statsManager);
					JsonManager.writeJsonArrayListUser(routeUserJson, users);
					JsonManager.writeJsonArrayListPlan(routePlanJson, plans);
					
					message = "Se ha registrado exitosamente al usuario " + user.getName();
					labelMessages.setText(message);
			
		    		planString = "";
		    		payment = "";
		    		
		    		textFieldName.setText("");
		    		textFieldAge.setText("");
		    		textFieldId.setText("");
		    		
		    		comboBoxGender.setSelectedItem("");
		    		comboBoxPlan.setSelectedItem("");
		    		comboBoxPayment.setSelectedItem("");
		    		
		    		
        		}
        		
        		
        	}
        });
	
		//endBanner
	}

}
