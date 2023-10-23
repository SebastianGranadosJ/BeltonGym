package co.edu.upb.BeltonGym.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import co.edu.upb.BeltonGym.BusinessStatistics;
import co.edu.upb.BeltonGym.JsonManager;
import co.edu.upb.BeltonGym.Main;
import co.edu.upb.BeltonGym.Plan;
import co.edu.upb.BeltonGym.User;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

public class BanUnbanPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;

	private String routeUserJson = "Users.json";
	private String routePlanJson = "Plans.json";
	private String routeStatsJson = "BusinessStatistics.json";
	
	
	private List<User> users = JsonManager.readJsonArrayListUser(routeUserJson);
	private List<Plan> plans =  JsonManager.readJsonArrayListPlan(routePlanJson);
	private BusinessStatistics statsManager = JsonManager.readJsonBusinessStatistics(routeStatsJson);
	
	private String dataUsers = Main.stringUsersBasicDataWithBanStatus(users);
	private String message = "Esperando datos.";
	private boolean allFields = false;
	private User selectedUser = null;
	/**

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanUnbanPanel frame = new BanUnbanPanel();
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
	public BanUnbanPanel() {
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
		
		JLabel lblNewLabel = new JLabel("Banear/Desbanear Usuario");
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
		
		JButton btnBanUnban = new JButton("Banear / Desbanear");
		
		panelButton.add(btnBanUnban);
		
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
		
		JCheckBox checkBoxConfirm = new JCheckBox("Confirmo      ");
		panelInput.add(checkBoxConfirm, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panelDays.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel labelConfirm = new JLabel("Esperando selección de usuario");
		labelConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(labelConfirm);
		
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
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		panelTopData.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		panelUsers.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPaneUsers = new JTextPane();
		textPaneUsers.setText(dataUsers);
		textPaneUsers.setEditable(false);
		scrollPane.setViewportView(textPaneUsers);
		
		btnBanUnban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allFields = true;
				
				if(checkBoxConfirm.isSelected() == false) {
					allFields = false;
					message = "Marque confirmar si desea continuar con la acción.";
				}
				
				if(selectedUser == null) {
					allFields = false;
					message = "Ingrese el numero de usuario que desea seleccionar.";
				}
				
				
				
				if(allFields) {
					
					if(selectedUser.isBanned()) {
						selectedUser.setBanned(false);
						selectedUser.addToHistory("El usuario ha sido desbaneado");
						message = "La usuario " + selectedUser.getName() + " ha sido desbaneado.";
					}
					else {
						selectedUser.setBanned(true);
						selectedUser.addToHistory("El usuario ha sido baneado");
						message = "La usuario " + selectedUser.getName() + " ha sido baneado.";
					}
					
				   
				    JsonManager.writeJsonArrayListUser(routeUserJson, users);
				    dataUsers = Main.stringUsersBasicDataWithBanStatus(users);
				    textPaneUsers.setText(dataUsers);
					
				    checkBoxConfirm.setSelected(false);;
					textFieldUser.setText("");
					selectedUser = null;
					
					
				}
				labelMessage.setText(message);
				
			}
		});
		textFieldUser.getDocument().addDocumentListener(new DocumentListener() {
			  public void insertUpdate(DocumentEvent e) {
	                updateLabel();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                updateLabel();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                updateLabel();
	            }

	            private void updateLabel() {
	            	if(Main.isInteger(textFieldUser.getText())){
		            	if((0 <= Integer.parseInt(textFieldUser.getText())-1) && (Integer.parseInt(textFieldUser.getText() ) - 1<users.size() ) ) {
		            		selectedUser = users.get(Integer.parseInt(textFieldUser.getText())-1);
		            		if(selectedUser.isBanned()) {
		            			labelConfirm.setText("Desea desbanear al usuario " + selectedUser.getName() + " ?");
		            			btnBanUnban.setText("Desbanear");
		            			
		            		}
		            		else {
		            			labelConfirm.setText("Desea banear al usuario " + selectedUser.getName() + " ?");
		            			btnBanUnban.setText("Banear");
		            		}
		            		
		            	}else {
		            		labelConfirm.setText("Esperando selección de usuario");
		            		btnBanUnban.setText("Banear / Desbanear");
		            		selectedUser = null;
		            	}
	            	}else {
	            		labelConfirm.setText("Esperando selección de usuario");
	            		btnBanUnban.setText("Banear / Desbanear");
	            		selectedUser = null;
	            	}
	            }
			
        });
	}

}
