package co.edu.upb.BeltonGym.GUI;
import co.edu.upb.BeltonGym.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class RegisterUserPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUserPanel frame = new RegisterUserPanel();
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
	public RegisterUserPanel() {
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
		
		JLabel lblNewLabel = new JLabel("Registrar Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBanner.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelFunctions = new JPanel();
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los siguiente datos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panelTitle.add(lblNewLabel_1);
		
		JPanel panelData = new JPanel();
		panel.add(panelData, BorderLayout.CENTER);
		panelData.setLayout(new BorderLayout(0, 0));
		
		JPanel panelRegister = new JPanel();
		panelData.add(panelRegister, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		panelRegister.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panelData.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelAttribute = new JPanel();
		panelAttribute.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panelAttribute);
		panelAttribute.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelName = new JPanel();
		panelAttribute.add(panelName);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		panelName.add(lblNewLabel_2);
		
		JPanel panelAge = new JPanel();
		panelAttribute.add(panelAge);
		
		JPanel panelID = new JPanel();
		panelAttribute.add(panelID);
		
		JPanel panelGender = new JPanel();
		panelAttribute.add(panelGender);
		
		JPanel panelPlan = new JPanel();
		panelAttribute.add(panelPlan);
		
		JPanel panelImput = new JPanel();
		panelImput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panelImput);
		panelImput.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelFunctions.add(scrollPane);
		
		//endBanner
	}

}
