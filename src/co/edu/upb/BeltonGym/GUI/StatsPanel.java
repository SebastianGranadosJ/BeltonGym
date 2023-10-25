package co.edu.upb.BeltonGym.GUI;
import co.edu.upb.BeltonGym.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.FlowLayout;

public class StatsPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String routeUserJson = "Users.json";
	private String routePlanJson = "Plans.json";
	private String routeStatsJson = "BusinessStatistics.json";
	
	private BusinessStatistics statsManager = JsonManager.readJsonBusinessStatistics(routeStatsJson);
	private List <User> users =JsonManager.readJsonArrayListUser(routeUserJson);
	private List<Plan> plans =  JsonManager.readJsonArrayListPlan(routePlanJson);
	private String generalStats = statsManager.menuDisplayBusinessData(users, plans );
	private String monthStats = statsManager.menuDisplayMonthsData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsPanel frame = new StatsPanel();
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
	public StatsPanel() {

	
		
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
		
		JLabel lblNewLabel = new JLabel("Estadísticas del Negocio");
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
		
		

		
	
		
		
		
		//EndUsersBasicData
	
		
	
		
		JScrollPane panelInfo = new JScrollPane();
		panelInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFunctions.add(panelInfo);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelInfo.setColumnHeaderView(panelTitle);
		
		JLabel lblNewLabel_5 = new JLabel("Estadísticas generales");
		panelTitle.add(lblNewLabel_5);
		
		JPanel panelToTextInfo = new JPanel();
		panelToTextInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelInfo.setViewportView(panelToTextInfo);
		panelToTextInfo.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setText(generalStats);
		textPaneInfo.setEditable(false);
		panelToTextInfo.add(textPaneInfo, BorderLayout.CENTER);
		JPanel panelUsers = new JPanel();
		panelUsers.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelFunctions.add(panelUsers);
		panelUsers.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTopData = new JPanel();
		panelTopData.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelUsers.add(panelTopData, BorderLayout.NORTH);
		panelTopData.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Estadísticas mensuales");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelTopData.add(lblNewLabel_2);
		
		//User Basic Data
		JPanel panelUsersBasicData = new JPanel();
		panelUsersBasicData.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelUsers.add(panelUsersBasicData, BorderLayout.CENTER);
		panelUsersBasicData.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelUsersBasicData.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPanemMonthBasicStats = new JTextPane();
		
		String usersBasicData = Main.stringUsersBasicData(users);
	
		textPanemMonthBasicStats.setText(monthStats);
		textPanemMonthBasicStats.setEditable(false);
		scrollPane.setViewportView(textPanemMonthBasicStats);
		
		//endPanelFunctions
	}
}


