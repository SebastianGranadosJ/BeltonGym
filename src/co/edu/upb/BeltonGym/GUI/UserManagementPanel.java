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
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class UserManagementPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementPanel frame = new UserManagementPanel();
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
	public UserManagementPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBox.border"));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBanner = new JPanel();
		panelBanner.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panelBanner, BorderLayout.NORTH);
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
		
		JPanel panel_1 = new JPanel();
		panelBanner.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Gestión de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panelFunctions = new JPanel();
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelLeft);
		panelLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelLeft.add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_3 = new JButton("Menú usuarios");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//When the button is press its gonna create this pannel
				MenuUsersPanel menuUsers = new MenuUsersPanel();
				menuUsers.setVisible(true);
				dispose();
				
				
			}
		});
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Registrar usuario");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUserPanel registerUserPanel = new RegisterUserPanel();
				registerUserPanel.setVisible(true);
				dispose();
			}
		});
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Banear usuario");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BanUnbanPanel banUnbanPanel = new BanUnbanPanel();
				banUnbanPanel.setVisible(true);
				dispose();
				
			}
		});
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("Renovar suscripción");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSubsPanel updateSubsPanel = new UpdateSubsPanel();
				updateSubsPanel.setVisible(true);
				dispose();
				
			}
		});
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Congelar suscripción");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FreezeDueDatePanel freezeDueDatePanel = new FreezeDueDatePanel();
				freezeDueDatePanel.setVisible(true);
				dispose();
			}
		});
		panel_3.add(btnNewButton_1);
		
		JTextArea txtrNotificacin = new JTextArea();
		txtrNotificacin.setText("Notificación");
		txtrNotificacin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(txtrNotificacin);
	}

}