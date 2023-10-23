package co.edu.upb.BeltonGym.GUI;
import co.edu.upb.BeltonGym.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.GridLayout;
import java.awt.FlowLayout;

public class UpdateSubsPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	private String routeUserJson = "Users.json";
	private String routePlanJson = "Plans.json";
	private String routeStatsJson = "BusinessStatistics.json";
	
	private List<User> users = JsonManager.readJsonArrayListUser(routeUserJson);
	private List<User> inactiveUsers = Main.listReturnUserInactive(users);
	private List<Plan> plans =  JsonManager.readJsonArrayListPlan(routePlanJson);
	private BusinessStatistics statsManager = JsonManager.readJsonBusinessStatistics(routeStatsJson);
	private String payment = "";
	private String planString = "";
	private String message = "";
	private User selectedUser = null;
	private Plan selectedPlan;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UpdateSubsPanel() {
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
		panelBanner.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel mainPanel = new MainPanel();
				mainPanel.setVisible(true);
				dispose();
			}
		});
		panelBanner.add(btnNewButton, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Renovar Suscripción");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBanner.add(lblNewLabel, BorderLayout.CENTER);
		
		//panelFunctions
		
		JPanel panelFunctions = new JPanel();
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.setLayout(new GridLayout(1, 0, 0, 0));
		
		//PanelUsers
		JPanel panelUsers = new JPanel();
		panelUsers.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelFunctions.add(panelUsers);
		panelUsers.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSelectUser = new JPanel();
		panelSelectUser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelUsers.add(panelSelectUser, BorderLayout.SOUTH);
		panelSelectUser.setLayout(new BorderLayout(0, 0));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Usuario:");
		panelSelectUser.add(lblNewLabel_1, BorderLayout.WEST);
		
		JPanel panelTopData = new JPanel();
		panelTopData.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelUsers.add(panelTopData, BorderLayout.NORTH);
		panelTopData.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("# de Usuario");
		panelTopData.add(lblNewLabel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelTopData.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("ID                 ");
		panelTopData.add(lblNewLabel_4, BorderLayout.EAST);
		
		//User Basic Data
		JPanel panelUsersBasicData = new JPanel();
		panelUsersBasicData.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelUsers.add(panelUsersBasicData, BorderLayout.CENTER);
		panelUsersBasicData.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelUsersBasicData.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPaneUserData = new JTextPane();
		
		String usersBasicData = Main.stringUsersBasicData(inactiveUsers);
	
		textPaneUserData.setText(usersBasicData);
		textPaneUserData.setEditable(false);
		scrollPane.setViewportView(textPaneUserData);

		textField = new JTextField();
		panelSelectUser.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		
		//endPanelUserData
		
		//panelRight
		JPanel panelRight = new JPanel();
		panelFunctions.add(panelRight);
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelRight.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
	
		
		JPanel panelPlan = new JPanel();
		panelPlan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelPlan);
		panelPlan.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPlan.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Seleccione el nuevo plan:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel_5);
		
		JComboBox comboBoxPlan = new JComboBox();
		panelPlan.add(comboBoxPlan, BorderLayout.CENTER);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("");
		for(int ii = 0; ii < plans.size(); ii++) {
			model.addElement(plans.get(ii).getPlan());
		}
        comboBoxPlan.setModel(model);
        
		
		
		JPanel panelPayment = new JPanel();
		panelPayment.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelPayment);
		panelPayment.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPayment.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Seleccione el metodo de pago:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblNewLabel_6);
		
		JComboBox comboBoxPayment = new JComboBox();
		comboBoxPayment.setModel(new DefaultComboBoxModel(new String[] {"", "Efectivo", "Tarjeta", "Transferencia Bancaria"}));
		panelPayment.add(comboBoxPayment, BorderLayout.CENTER);
	
		
	
		
		JPanel panel_1 = new JPanel();
		panelRight.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Estado actual:");
		panel_4.add(lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(2);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.add(panel_6, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Renovar");
	
		panel_6.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_5.add(scrollPane_1, BorderLayout.CENTER);
		
		JTextPane txtPaneInfo = new JTextPane();
		scrollPane_1.setViewportView(txtPaneInfo);
		txtPaneInfo.setText("No se ha seleccionado un usuario");
		txtPaneInfo.setEditable(false);
		
		//endBanner
		
		//Listener Text choose User
	
		
		comboBoxPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la opción seleccionada del ComboBox
                planString = comboBoxPlan.getSelectedItem().toString();
                for(int ii = 0; ii <plans.size(); ii++) {
                	if (plans.get(ii).getPlan() == planString) {
                		
                		selectedPlan = plans.get(ii);
                	}
                
    
                }
            }
        });
		
		comboBoxPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la opción seleccionada del ComboBox
                payment = comboBoxPayment.getSelectedItem().toString();
           
            }
        });
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
                int inputInt = Integer.parseInt(input);
                message = "";
                selectedUser = inactiveUsers.get(inputInt - 1);
                message += Main.stringReturnUserData(selectedUser);
                txtPaneInfo.setText(message);
				
				if(payment != "" && planString != "" && selectedUser != null) {
					
					
					
					selectedUser.setCurrentPlan(selectedPlan);
					selectedUser.setStatusPlan(true);
					selectedUser.getCurrentPlan().incrementTotalTimesAdquired();
					selectedUser.setDateLastPayment(LocalDate.now());
					selectedUser.calDueDatePlan(); 
					selectedUser.addToHistory("Ha renovado con el plan: "+ selectedPlan.getPlan());
					statsManager.plusTotalSubs(1);
					statsManager.plusTotalProfits(selectedUser.getCurrentPlan().getValue());
				
					if(payment == "Tarjeta") {
						statsManager.plusProfitCardPayment(selectedUser.getCurrentPlan().getValue());
						statsManager.plusTimesCardPayment(1);
					}
					if(payment == "Efectivo") {
						statsManager.plusProfitCashPayment(selectedUser.getCurrentPlan().getValue());
						statsManager.plusTimesCashPayment(1);
					}
					if(payment == "Transferencia Bancaria") {
						statsManager.plusProfitBankTransfer(selectedUser.getCurrentPlan().getValue());
						statsManager.plusTimesBankTransfer(1);
					}
					
					JsonManager.writeJsonBusinessStatistics(routeStatsJson, statsManager);
					JsonManager.writeJsonArrayListUser(routeUserJson, users);
					JsonManager.writeJsonArrayListPlan(routePlanJson, plans);
					
					 String txtRegister ="SUSCRIPCIÓN EXITOSAMENTE RENOVADA " + "\n "+ 
							 "Nombre: " + selectedUser.getName() +"\n" +
							 "Documento de Identidad: " + selectedUser.getId() + "\n"+
							 "Plan: " + planString +"\n"+
							 "Metodo de pago: " + payment +"\n" + 
							 "Fecha de Suscripción: " + selectedUser.getDateLastPayment() + "\n"+
							 "Fecha de vencimiento: " + selectedUser.getDueDatePlan() + "\n";
				
				
		           	txtPaneInfo.setText(txtRegister);
		           	inactiveUsers = Main.listReturnUserInactive(users);
		           	 
		    		textPaneUserData.setText(Main.stringUsersBasicData(inactiveUsers));
		    		selectedUser = null;
				}
				else {
					message += "NO FUE POSIBLE RENOVAR LA SUSCRIPCIÓN \n";
					txtPaneInfo.setText(message);
				}
			}
		});
		
	}

}
