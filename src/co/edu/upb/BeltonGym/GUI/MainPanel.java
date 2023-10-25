
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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

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
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelCenter);
		panelCenter.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 205, 394);
		panelCenter.add(lblNewLabel_1);
		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelLeft);
		panelLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelLeft.add(panel);
		
		//BUTTONS
		
		JButton btnMenuUsers = new JButton("Gestion de Usuarios");
		btnMenuUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//When the button is press its gonna create this pannel
				UserManagementPanel userManagementPanel = new UserManagementPanel();
				userManagementPanel.setVisible(true);
				dispose();
				
				
			}
		});
		panelLeft.add(btnMenuUsers);
		
		JPanel panel_2 = new JPanel();
		panelLeft.add(panel_2);
		
		JButton btnBanUser = new JButton("Gestion de Negocio");
		btnBanUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessManagementPanel businessManagementPanel = new BusinessManagementPanel();
				businessManagementPanel.setVisible(true);
				dispose();
			}
		});
		panelLeft.add(btnBanUser);
		
		JPanel panel_1 = new JPanel();
		panelLeft.add(panel_1);
		
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
