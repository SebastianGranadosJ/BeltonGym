package co.edu.upb.BeltonGym.GUI;
import co.edu.upb.BeltonGym.*;
import java.awt.EventQueue;

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
import javax.swing.SwingUtilities;
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
		panelLeft.add(btnMenuPlans);
		
		JButton btnBanUser = new JButton("Banear Usuario");
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
		panelCenter.add(btnFreezeDueDate);
		
		JButton btnAddPlan = new JButton("Crear Plan");
		panelCenter.add(btnAddPlan);
		
		JButton btnMenuStatistics = new JButton("Estadísticas");
		panelCenter.add(btnMenuStatistics);
		
		JPanel PanelNotificaciones = new JPanel();
		PanelNotificaciones.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(PanelNotificaciones);
		
		JLabel lblNotificaciones = new JLabel("Notificaciones:");
		lblNotificaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		PanelNotificaciones.add(lblNotificaciones);

		JTextArea txtNotificaciones = new JTextArea();
		txtNotificaciones.setEditable(false);
		PanelNotificaciones.add(txtNotificaciones);
		
		addNotification(txtNotificaciones, "Notificación Ejemplo 1");
        addNotification(txtNotificaciones, "Notificación Ejemplo 2");
        addNotification(txtNotificaciones, "Notificación Ejemplo 3");

        // Boton eliminar Notificaciones
        JButton clearButton = new JButton("Borrar Todas");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearNotifications(txtNotificaciones);
            }
        });
        PanelNotificaciones.add(clearButton);
    }

    // Notificacion que se pueda borrar 
    private void addNotification(JTextArea textArea, String notificationText) {
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BorderLayout());

        JLabel notificationLabel = new JLabel(notificationText);
        notificationPanel.add(notificationLabel, BorderLayout.CENTER);

        JButton deleteButton = new JButton("X");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText().replace(notificationText + "\n", ""));
            }
        });
        notificationPanel.add(deleteButton, BorderLayout.EAST);

        textArea.append(notificationText + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());

        textArea.add(notificationPanel);
    }

    // Borrar Notificaciones
    private void clearNotifications(JTextArea textArea) {
        textArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainPanel mainPanel = new MainPanel();
                mainPanel.setVisible(true);
            }
        });
    }

}
