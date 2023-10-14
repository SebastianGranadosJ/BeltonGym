package co.edu.upb.BeltonGym.GUI;
import co.edu.upb.BeltonGym.*;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import java.awt.Button;
import java.awt.Panel;

public class MenuUsersPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String routeUserJson = "Users.json";
	private List <User> users =JsonManager.readJsonArrayListUser(routeUserJson);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsersPanel frame = new MenuUsersPanel();
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
	public MenuUsersPanel() {
		
		
	
		
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
		
		JLabel lblNewLabel = new JLabel("Menú de Usuarios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBanner.add(lblNewLabel, BorderLayout.CENTER);
		//endBanner
		
		
		
		//PanelFunctions
		JPanel panelFunctions = new JPanel();
		contentPane.add(panelFunctions, BorderLayout.CENTER);
		panelFunctions.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.setLayout(new GridLayout(1, 0, 0, 0));
		
		//PanelUsers
		JPanel panelUsers = new JPanel();
		panelUsers.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelFunctions.add(panelUsers);
		panelUsers.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSelectUser = new JPanel();
		panelSelectUser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelUsers.add(panelSelectUser, BorderLayout.SOUTH);
		panelSelectUser.setLayout(new BorderLayout(0, 0));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Usuario:");
		panelSelectUser.add(lblNewLabel_1, BorderLayout.WEST);
		
		JPanel panelTopData = new JPanel();
		panelTopData.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelUsers.add(panelTopData, BorderLayout.NORTH);
		panelTopData.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("# de Usuario");
		panelTopData.add(lblNewLabel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelTopData.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("ID                 ");
		panelTopData.add(lblNewLabel_4, BorderLayout.EAST);
		
		//User Basic Data
		JPanel panelUsersBasicData = new JPanel();
		panelUsersBasicData.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelUsers.add(panelUsersBasicData, BorderLayout.CENTER);
		panelUsersBasicData.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelUsersBasicData.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPaneUserBasicData = new JTextPane();
		
		String usersBasicData = Main.stringUsersBasicData(users);
	
		textPaneUserBasicData.setText(usersBasicData);
		textPaneUserBasicData.setEditable(false);
		scrollPane.setViewportView(textPaneUserBasicData);
		

		
	
		
		
		
		//EndUsersBasicData
	
		
	
		
		JScrollPane panelInfo = new JScrollPane();
		panelInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelInfo);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelInfo.setColumnHeaderView(panelTitle);
		
		JLabel lblNewLabel_5 = new JLabel("Información más detallada");
		panelTitle.add(lblNewLabel_5);
		
		JPanel panelToTextInfo = new JPanel();
		panelInfo.setViewportView(panelToTextInfo);
		panelToTextInfo.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setEditable(false);
		panelToTextInfo.add(textPaneInfo, BorderLayout.CENTER);
		
		textField = new JTextField();
		panelSelectUser.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		 textField.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Obtener el texto ingresado por el usuario
	                String input = textField.getText();
	                int inputInt = Integer.parseInt(input);
	                textPaneInfo.setText(Main.stringReturnUserData(users, inputInt));
	               
	            }
	        });
		
		//endPanelFunctions
	}

}
