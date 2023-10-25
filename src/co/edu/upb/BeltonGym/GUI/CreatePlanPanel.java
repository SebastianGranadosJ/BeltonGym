

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

public class CreatePlanPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private String routePlanJson = "Plans.json";
	private String routeStatsJson = "BusinessStatistics.json";
	private String message = "Esperando datos.";
	private List<Plan> plans =  JsonManager.readJsonArrayListPlan(routePlanJson);
	private BusinessStatistics statsManager = JsonManager.readJsonBusinessStatistics(routeStatsJson);
	private boolean allFields;
	private JTextField textFieldName;
	private JTextField textFieldValue;
	private JTextField textFieldDays;
	private JTextField textFieldMonths;
	private JTextField textFieldYears;
	private JTextField textFieldDescrip;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePlanPanel frame = new CreatePlanPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreatePlanPanel() {

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
				BusinessManagementPanel businessManagementPanel = new BusinessManagementPanel();
				businessManagementPanel.setVisible(true);
				dispose();
			}
		});
		panelBanner.add(btnNewButton, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Crear Nuevo Plan");
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
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelAge.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel panelID = new JPanel();
		panelID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelID);
		panelID.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Dias de Duración:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelID.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel panelGender = new JPanel();
		panelGender.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelGender);
		panelGender.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Meses de Duración:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelGender.add(lblNewLabel_5, BorderLayout.CENTER);
		
		JPanel panelPlan = new JPanel();
		panelPlan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelPlan);
		panelPlan.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Años de Duración:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlan.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JPanel panelPayment = new JPanel();
		panelPayment.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAttribute.add(panelPayment);
		panelPayment.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Descripción:");
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
		
		
		textFieldName = new JTextField();
		textFieldName.setText("");
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNameInput.add(textFieldName, BorderLayout.CENTER);
		panelNameInput.setLayout(new BorderLayout(0, 0));
		
		textFieldName = new JTextField();
		panelNameInput.add(textFieldName);
		textFieldName.setColumns(10);
		textFieldName.setColumns(10);
		
		JPanel panelAgeInput = new JPanel();
		panelAgeInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelAgeInput);
		panelAgeInput.setLayout(new BorderLayout(0, 0));
		

		
		textFieldValue = new JTextField();
		panelAgeInput.add(textFieldValue);
		textFieldValue.setColumns(10);
	
		
		JPanel panelIdInput = new JPanel();
		panelIdInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelIdInput);
		panelIdInput.setLayout(new BorderLayout(0, 0));
		

		
		textFieldDays = new JTextField();
		panelIdInput.add(textFieldDays);
		textFieldDays.setColumns(10);

	
		JPanel panelGenderInput = new JPanel();
		panelGenderInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelGenderInput);
		panelGenderInput.setLayout(new BorderLayout(0, 0));
		
		textFieldMonths = new JTextField();
		panelGenderInput.add(textFieldMonths, BorderLayout.CENTER);
		textFieldMonths.setColumns(10);
		
		JPanel panelPlanInput = new JPanel();
		panelPlanInput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelImput.add(panelPlanInput);
		panelPlanInput.setLayout(new BorderLayout(0, 0));
		
		textFieldYears = new JTextField();
		panelPlanInput.add(textFieldYears, BorderLayout.CENTER);
		textFieldYears.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panelImput.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textFieldDescrip = new JTextField();
		panel_1.add(textFieldDescrip);
		textFieldDescrip.setColumns(10);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("");
		for(int ii = 0; ii < plans.size(); ii++) {
			model.addElement(plans.get(ii).getPlan());
		}
        
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
        
        JLabel lblNewLabel_1 = new JLabel("Ingrese los datos del nuevo plan, cuando todos los campos esten rellenados presione crear.");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(lblNewLabel_1);
        
        JPanel panelRegister = new JPanel();
        contentPane.add(panelRegister, BorderLayout.SOUTH);
        
        JButton btnNewButton_1 = new JButton("Crear");
       
        panelRegister.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		allFields = true;
        		
        		if(textFieldDescrip.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible crear el plan, porfavor ingrese una DESCRIPCIÓN.";
        		
        		}
        		
        		if(textFieldYears.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible crear el plan, porfavor ingrese cuantos AÑOS dura el plan.";
        		
        		}
        		
        		if(textFieldMonths.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible crear el plan, porfavor ingrese cuantos MESES dura el plan.";
        		
        		}
        		
        		if(textFieldDays.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible crear el plan, porfavor ingrese cuantos DIAS dura el plan.";
        		}
        		if(textFieldValue.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible crear el plan, porfavor ingrese un VALOR.";
        		}
        		if(textFieldName.getText().isBlank()) {
        			allFields = false;
        			message = "No es posible crear el plan, porfavor ingrese un NOMBRE.";
        		}
        		
        		labelMessages.setText(message);
        	
        		if(allFields) {
        			Plan plan = new Plan();
        			
        			labelMessages.setText("Exitosamente registrado.");
        			plan.setPlan(textFieldName.getText());
        			plan.setValue(Integer.parseInt(textFieldValue.getText()));
        			plan.setDurationDay(Integer.parseInt(textFieldDays.getText()));
        			plan.setDurationMonth(Integer.parseInt(textFieldMonths.getText()));
        			plan.setDurationYear(Integer.parseInt(textFieldYears.getText()));
        			plan.setDescription(textFieldDescrip.getText());
        		
        			plans.add(plan);
					JsonManager.writeJsonBusinessStatistics(routeStatsJson, statsManager);
					JsonManager.writeJsonArrayListPlan(routePlanJson, plans);
					
					message = "Se ha registrado exitosamente el plan  " + plan.getPlan();
					labelMessages.setText(message);
			
		    		
		    		textFieldName.setText("");
		    		textFieldValue.setText("");
		    		textFieldDays.setText("");
		    		textFieldMonths.setText("");
		    		textFieldYears.setText("");
		    		textFieldDescrip.setText("");
		    		
		    		
        		}
        		
        		
        	}
        });
	
		//endBanner
	}

}
