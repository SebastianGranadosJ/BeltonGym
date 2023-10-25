package co.edu.upb.BeltonGym.GUI;
import co.edu.upb.BeltonGym.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class MainPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MainPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBox.border"));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBanner = new JPanel();
		panelBanner.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelBanner, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Belton Gym Software");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBanner.add(lblNewLabel);
		
		JPanel panelFunctions = new JPanel();
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelLeft);
		panelLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		//BUTTONS
		
		JButton btnMenuUsers = new JButton("Menú de Usuarios");
		btnMenuUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//When the button is press its gonna create this pannel
				MenuUsersPanel menuUsers = new MenuUsersPanel();
				menuUsers.setVisible(true);
				dispose();
				
				
			}
		});
		panelLeft.add(btnMenuUsers);
		
		JButton btnUpdateSubs = new JButton("Renovar Suscripción");
		btnUpdateSubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSubsPanel updateSubsPanel = new UpdateSubsPanel();
				updateSubsPanel.setVisible(true);
				dispose();
				
			}
		});
		panelLeft.add(btnUpdateSubs);
		
		JButton btnMenuPlans = new JButton("Menú de Planes");
		btnMenuPlans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPlansPanel menuPlansPanel = new MenuPlansPanel();
				menuPlansPanel.setVisible(true);
				dispose();
			}
		});
		panelLeft.add(btnMenuPlans);
		
		JButton btnBanUser = new JButton("Banear Usuario");
		btnBanUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BanUnbanPanel banUnbanPanel = new BanUnbanPanel();
				banUnbanPanel.setVisible(true);
				dispose();
				
			}
		});
		panelLeft.add(btnBanUser);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnRegisterUser = new JButton("Registrar Usuario");
		btnRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUserPanel registerUserPanel = new RegisterUserPanel();
				registerUserPanel.setVisible(true);
				dispose();
			}
		});
		panelCenter.add(btnRegisterUser);
		
		JButton btnFreezeDueDate = new JButton("Congelar Suscripción");
		btnFreezeDueDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FreezeDueDatePanel freezeDueDatePanel = new FreezeDueDatePanel();
				freezeDueDatePanel.setVisible(true);
				dispose();
			}
		});
		panelCenter.add(btnFreezeDueDate);
		
		JButton btnAddPlan = new JButton("Crear Plan");
		btnAddPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePlanPanel createPlanPanel = new CreatePlanPanel();
				createPlanPanel.setVisible(true);
				dispose();
			}
		});
		panelCenter.add(btnAddPlan);
		
		JButton btnMenuStatistics = new JButton("Estadísticas");
		btnMenuStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsPanel statsPanel = new StatsPanel();
				statsPanel .setVisible(true);
				dispose();
			}
		});
		panelCenter.add(btnMenuStatistics);
		
		JPanel panelRight = new JPanel();
		panelRight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelRight);
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnNotificaciones = new JTextPane();
		txtpnNotificaciones.setEditable(false);
		txtpnNotificaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnNotificaciones.setText("Notificaciones");
		panelRight.add(txtpnNotificaciones, BorderLayout.CENTER);
	}

}
