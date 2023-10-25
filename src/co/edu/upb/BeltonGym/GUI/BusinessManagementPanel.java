package co.edu.upb.BeltonGym.GUI;

import java.awt.EventQueue;

import co.edu.upb.BeltonGym.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BusinessManagementPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessManagementPanel frame = new BusinessManagementPanel();
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
	public BusinessManagementPanel() {
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
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel mainPanel = new MainPanel();
				mainPanel.setVisible(true);
				dispose();
			}
		});
		panelBanner.add(btnNewButton_1, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panelBanner.add(panel_5, BorderLayout.CENTER);
		
		JLabel lblGestionDeNegocio = new JLabel("Gestion de Negocio");
		lblGestionDeNegocio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(lblGestionDeNegocio);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_3 = new JButton("Estadisticas");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsPanel statsPanel = new StatsPanel();
				statsPanel.setVisible(true);
				dispose();
			}
		});
		
		panel_2.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JButton btnNewButton = new JButton("Menú de planes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPlansPanel menuPlansPanel = new MenuPlansPanel();
				menuPlansPanel.setVisible(true);
				dispose();
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JButton btnNewButton_2 = new JButton("Agregar plan");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePlanPanel createPlanPanel = new CreatePlanPanel();
				createPlanPanel.setVisible(true);
				dispose();
			}
		});
		panel_2.add(btnNewButton_2);
		
		JTextArea txtrNotificacion = new JTextArea();
		txtrNotificacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNotificacion.setText("Notificación");
		panel.add(txtrNotificacion);
	}

}
