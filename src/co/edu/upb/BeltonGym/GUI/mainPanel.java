package co.edu.upb.BeltonGym.GUI;

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

public class mainPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPanel frame = new mainPanel();
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
	public mainPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBox.border"));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelName = new JPanel();
		panelName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelName, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Belton Gym Software");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelName.add(lblNewLabel);
		
		JPanel panelFunctions = new JPanel();
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelLeft);
		panelLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnMenuUsers = new JButton("Menú de Usuarios");
		panelLeft.add(btnMenuUsers);
		
		JButton btnUpdateSubs = new JButton("Renovar Suscripción");
		panelLeft.add(btnUpdateSubs);
		
		JButton btnMenuPlans = new JButton("Menú de Planes");
		panelLeft.add(btnMenuPlans);
		
		JButton btnBanUser = new JButton("Banear Usuario");
		panelLeft.add(btnBanUser);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelCenter);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnRegisterUser = new JButton("Registrar Usuario");
		panelCenter.add(btnRegisterUser);
		
		JButton btnFreezeDueDate = new JButton("Congelar Suscripción");
		panelCenter.add(btnFreezeDueDate);
		
		JButton btnAddPlan = new JButton("Crear Plan");
		panelCenter.add(btnAddPlan);
		
		JButton btnMenuStatistics = new JButton("Estadísticas");
		panelCenter.add(btnMenuStatistics);
		
		JPanel panelRight = new JPanel();
		panelRight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelRight);
	}

}
