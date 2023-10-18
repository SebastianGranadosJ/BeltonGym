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
public class FreezeDueDatePanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldDays;

	private String routeUserJson = "Users.json";
	private String routePlanJson = "Plans.json";
	private String routeStatsJson = "BusinessStatistics.json";
	
	
	private List<User> users = JsonManager.readJsonArrayListUser(routeUserJson);
	private List<Plan> plans =  JsonManager.readJsonArrayListPlan(routePlanJson);
	private BusinessStatistics statsManager = JsonManager.readJsonBusinessStatistics(routeStatsJson);
	
	private List<User> activeUsers = Main.listReturnUserActive(users);
	private String dataActiveUsers = Main.stringUsersBasicDataWithDue(users);
	private String message = "Esperando datos.";
	private boolean allFields = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreezeDueDatePanel frame = new FreezeDueDatePanel();
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
	public FreezeDueDatePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
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
		
		JLabel lblNewLabel = new JLabel("Congelar Suscripción");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBanner.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelFunctions = new JPanel();
		panelFunctions.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		FlowLayout fl_panelLeft = (FlowLayout) panelLeft.getLayout();
		fl_panelLeft.setHgap(40);
		panelFunctions.add(panelLeft, BorderLayout.WEST);
		
		JPanel panelRight = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelRight.getLayout();
		flowLayout.setHgap(40);
		panelFunctions.add(panelRight, BorderLayout.EAST);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButton = new JPanel();
		panelCenter.add(panelButton, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Congelar");
		
		panelButton.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panelCenter.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelOther = new JPanel();
		panel_1.add(panelOther, BorderLayout.SOUTH);
		panelOther.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelSelectUser = new JPanel();
		panelSelectUser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelOther.add(panelSelectUser);
		panelSelectUser.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelSelectUser.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		textFieldUser = new JTextField();
		textFieldUser.setText("");
		panel.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panelSelectUser.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese un usuario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panelDays = new JPanel();
		panelDays.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelOther.add(panelDays);
		panelDays.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panelDays.add(panelInput, BorderLayout.EAST);
		panelInput.setLayout(new BorderLayout(0, 0));
		
		textFieldDays = new JTextField();
		textFieldDays.setText("");
		panelInput.add(textFieldDays);
		textFieldDays.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panelDays.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Ingrese el numero de dias que va a congelar");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout_2 = (FlowLayout) panelInfo.getLayout();
		flowLayout_2.setVgap(3);
		panelOther.add(panelInfo);
		
		JLabel labelMessage = new JLabel(message);
		panelInfo.add(labelMessage);
		
		JPanel panelUsers = new JPanel();
		panel_1.add(panelUsers, BorderLayout.CENTER);
		panelUsers.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTopData = new JPanel();
		panelUsers.add(panelTopData, BorderLayout.NORTH);
		panelTopData.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("#");
		panelTopData.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		panelTopData.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		panelTopData.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Vencimiento");
		panelTopData.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		panelUsers.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPaneUsers = new JTextPane();
		textPaneUsers.setText(dataActiveUsers);
		textPaneUsers.setEditable(false);
		scrollPane.setViewportView(textPaneUsers);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allFields = true;
				
				if(textFieldDays.getText().isBlank()) {
					allFields = false;
					message = "Seleccione el numero de dias por el que desea congelar el plan.";
				}
				
				if(textFieldUser.getText().isBlank()) {
					allFields = false;
					message = "Seleccione el numero de usuario que desea congelar.";
				}
				
				
				
				if(allFields) {
					
					int daysToFreeze = Integer.parseInt(textFieldDays.getText());
					int index = Integer.parseInt(textFieldUser.getText()) - 1;
					User user = users.get(index);
				    
					LocalDate lastDueDate = user.getDueDatePlan();
				    LocalDate newDueDate = lastDueDate.plusDays(daysToFreeze);
				    user.setDueDatePlan(newDueDate);
				    user.addToHistory("Se ha congelado el plan por " + daysToFreeze + " dias.");
				    JsonManager.writeJsonArrayListUser(routeUserJson, users);
				    dataActiveUsers = Main.stringUsersBasicDataWithDue(users);
				    textPaneUsers.setText(dataActiveUsers);
					message = "La plan de " + user.getName() + " ahora vence el " + newDueDate;
					textFieldDays.setText("");
					textFieldUser.setText("");
					
					
				}
				labelMessage.setText(message);
				
			}
		});
	}

}
