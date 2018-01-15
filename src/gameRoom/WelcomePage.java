package gameRoom;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import javafx.scene.control.ScrollPane;

import javax.swing.border.BevelBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class WelcomePage extends JFrame {
	

	private JFrame frame;
	public static Client client = new Client();
	
	private CardLayout gamesLayout;
	private CardLayout othersLayout;
	private CardLayout registerLayout;
	private CardLayout mainLayout;
	private JTextField usernameField;
	private JTextField loginBtn;
	private JTextField goToSignupBtn;
	private JPasswordField passwordField;
	private JTextField txtViewYourProfile;
	private JTextField txtViewYourScores;
	private JTextField txtFriends;
	private JTextField txtNotif;
	private JTextField usernameFieldS;
	private JTextField mailField;
	private JTextField countryField;
	private JPasswordField passwordFieldS;
	private JTextField ageField;
	private JTextField signUpBtn;
	private JTextField friendNameField;
	private JTextField txtAddFriend;
	private JTextField txtRemoveFriend;
	private JTextField txtViewFriendsProfile;
	private JTextField textField;
	private JTable table;
	private JTextField textNotification;
	private JTextField txtAccept;
	private JTextField txtReject;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField txtAccept_1;
	private JTextField txtReject_1;
	private JTextField txtYourMessages;
	private JTextField textAction;
	private JTextField textField_3;
	private JTextField txtMenu;
	private JTextField txtLogOut;
	private JTextField txtFriendsmode;
	private JTextField btnRefresh;
	private JTextField txtYouCanSend;
	private JTextField friendToSend;
	private JTextField btnSendRequestTTT;
	private JTextField txtYouCanSendBS;
	private JTextField friendToSendBS;
	private JTextField btnSendRequestBS;
	private JTextField btnReply;
	private JTextField btnDelete;
	private JTextField SendRequestResult;
	private JTextField NumRequestsTTT;
	private JTextField SendRequestResultBS;
	private JTextField NumRequestsBS;
	private JTextField SnakePlayBtn;
	private JTextField TicTacToePlayBtn;
	private JTextField btnGMttt;
	private JTextField btnCMttt;
	private JTextField btnFMttt;
	private JTextField Status;
	private JTextField ChangePassArea;
	private JTextField btnApply;
	private JTextField btnImport;
	private JTextField friendsFieldP;
	private JTextField ageFieldP;
	private JTextField countryFieldP;
	private JTextField genderFieldP;
	private JTextField mailFieldP;
	private JTextField userFieldP;
	private JTextField btnApplyStatus;
	private JTextField StatusField;
	private JTextField FriendName;
	private JTextField FriendStatus;
	private JTextField FriendView;
	private JTextField FriendValueView;
	private JTextField txtInbox;
	private JTextField RefreshInbox;
	private JTextField FriendNameInbox;
	private JTextField ResultInbox;
	private JTextField ResultSendInbox;
	private JTextField btnReplyInbox;
	private JTextField btnDeleteInbox;
	private JTextField RequestReceivedTTT;
	private JTextField txtAcceptRequestTTT;
	private JTextField txtDeclineRequestTTT;
	private JTextField RequestReceivedBS;
	private JTextField txtAcceptRequestBS;
	private JTextField txtDeclineRequestBS;
	
	private Timer tI = new Timer();
	private Timer tN = new Timer();
	private Timer tSB = new Timer();
	private Timer tFMttt = new Timer();
	private Timer tFMbs = new Timer();
	
	private JScrollPane scrollPane;
	private JTextField EmailHasBeenSent;
	private JTextField txtPleaseSignIn;
	private JTextField txtToGetYour;
	private JTextField txtThenTryLogging;
	private JTextField LoginForgotPass;
	private JTextField EnterUsername;
	private JTextField UserForgotPass;
	private JTextField TitleChatTTT;
	private JTextField maxChatTTT;
	private JTextField txtYouAreThe;
	private JTextField playBS;
	private JTextField btnGMBS;
	private JTextField btnCMBS;
	private JTextField btnFMBS;
	private JTextField TitleChatBS;
	private JTextField maxChatBS;
	private JTextField txtYouAreTheBS;
	private JTextField playPac;
	private JTextField txtPlay;
	private JTextField genderField;
	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setVisible() {
		frame.setVisible(true);
	}
	/**
	 * Create the application.
	 */
	public WelcomePage() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1090, 727);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainLayout = (CardLayout) frame.getContentPane().getLayout();
		
		mainLayout.show(frame.getContentPane(), "login");
		
		JPanel LoginOrSignup = new JPanel();
		frame.getContentPane().add(LoginOrSignup, "loginOrSignup");
		LoginOrSignup.setLayout(null);
		
		JPanel Logo = new JPanel();
		Logo.setBackground(Color.WHITE);
		Logo.setBounds(0, 0, 529, 680);
		LoginOrSignup.add(Logo);
		Logo.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(529, 0, 543, 680);
		LoginOrSignup.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel UserLogin = new JPanel();
		panel_2.add(UserLogin, "login");
		UserLogin.setBackground(Color.GRAY);
		UserLogin.setLayout(null);
		
		JPanel UserSignup = new JPanel();
		UserSignup.setBackground(Color.GRAY);
		panel_2.add(UserSignup, "signup");
		UserSignup.setLayout(null);
		
		// FORGOT PASSWORD PANEL
		JPanel ForgotPassword = new JPanel();
		ForgotPassword.setBackground(Color.GRAY);
		panel_2.add(ForgotPassword, "ForgotPassword");
		ForgotPassword.setLayout(null);
		
		// creating new panels
		
				JPanel Home = new JPanel();
				frame.getContentPane().add(Home, "home");
				Home.setLayout(null);
				
				JPanel SideBar = new JPanel();
				SideBar.setFont(new Font("Calibri", Font.BOLD, 16));
				SideBar.setForeground(Color.WHITE);
				SideBar.setBackground(Color.GRAY);
				SideBar.setBounds(0, 0, 244, 680);
				Home.add(SideBar);
				SideBar.setLayout(null);
		
		registerLayout = (CardLayout) panel_2.getLayout();
		
		// OTHERS PANEL
		
				JPanel others = new JPanel();
				others.setBackground(Color.WHITE);
				others.setBounds(244, 0, 828, 680);
				Home.add(others);
				others.setLayout(new CardLayout(0, 0));
				
				othersLayout = (CardLayout) others.getLayout();
				
				
				
				// FRIENDS PANEL
				
				JPanel Friends = new JPanel();
				Friends.setBackground(Color.WHITE);
				others.add(Friends, "friends");
				Friends.setLayout(null);
				
				// NOTIFICATIONS PANEL
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setOpaque(false);
				scrollPane.setAutoscrolls(true);
				scrollPane.setBackground(Color.WHITE);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				others.add(scrollPane, "scroll");
				JLayeredPane Notif = new JLayeredPane();
				Notif.setBackground(Color.WHITE);
				scrollPane.setViewportView(Notif);
				Notif.setAutoscrolls(true);
				scrollPane.getViewport().setBackground(Color.WHITE);
			
				// PROFILE PANEL
				JPanel Profile = new JPanel();
				Profile.setBackground(Color.WHITE);
				others.add(Profile, "Profile");
				Profile.setLayout(null);
				
				//FRIENDS PROFILE PANEL
				JPanel FriendsProfile = new JPanel();
				FriendsProfile.setBackground(Color.WHITE);
				others.add(FriendsProfile, "FriendProfile");
				FriendsProfile.setLayout(null);
				
				// INBOX PANEL
				JScrollPane InboxScroll = new JScrollPane();
				InboxScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				InboxScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				others.add(InboxScroll, "InboxScroll");
				JPanel Inbox = new JPanel();
				Inbox.setBackground(Color.WHITE);
				InboxScroll.setViewportView(Inbox);
				Inbox.setAutoscrolls(true);
				GroupLayout gl_Inbox = new GroupLayout(Inbox);
				gl_Inbox.setHorizontalGroup(
					gl_Inbox.createParallelGroup(Alignment.LEADING)
						.addGap(0, 645, Short.MAX_VALUE)
				);
				gl_Inbox.setVerticalGroup(
					gl_Inbox.createParallelGroup(Alignment.LEADING)
						.addGap(0, 581, Short.MAX_VALUE)
				);
				Inbox.setLayout(gl_Inbox);
				InboxScroll.getViewport().setBackground(Color.WHITE);
				
				
				
		/*		JScrollPane scrollPane = new JScrollPane(FriendsMode);
				scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(214, 0, 587, 489);
				JPanel contentPane = new JPanel(null);
				contentPane.setPreferredSize(others.getPreferredSize());
				contentPane.add(scrollPane);
				others.add(contentPane, "contentPane"); */
				
				//GAMESMENU panel
				
				JPanel GamesMenu = new JPanel();
				GamesMenu.setBackground(Color.WHITE);
				others.add(GamesMenu, "GamesMenu");
						
				GamesMenu.setLayout(new CardLayout(0, 0));
				
				gamesLayout = (CardLayout) GamesMenu.getLayout();
				
				JPanel AllGames = new JPanel();
				AllGames.setBackground(Color.WHITE);
				GamesMenu.add(AllGames, "AllGames");
				AllGames.setLayout(null);
				
				// TICTACTOE FRIEND MODE
				
				JScrollPane scrollTTTFriendsMode = new JScrollPane();
				scrollTTTFriendsMode.setAutoscrolls(true);
				scrollTTTFriendsMode.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollTTTFriendsMode.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				GamesMenu.add(scrollTTTFriendsMode, "scrollTTT");
				JPanel TTTFriendsMode = new JPanel();
			//	GamesMenu.add(TTTFriendsMode, "TTTFriendsMode");
				TTTFriendsMode.setBackground(Color.WHITE);
					
					GroupLayout gl_TTTFriendsMode = new GroupLayout(TTTFriendsMode);
					gl_TTTFriendsMode.setHorizontalGroup(
						gl_TTTFriendsMode.createParallelGroup(Alignment.LEADING)
							.addGap(0, 666, Short.MAX_VALUE)
					);
					gl_TTTFriendsMode.setVerticalGroup(
						gl_TTTFriendsMode.createParallelGroup(Alignment.LEADING)
							.addGap(0, 560, Short.MAX_VALUE)
					);
					scrollTTTFriendsMode.setViewportView(TTTFriendsMode);
					TTTFriendsMode.setLayout(gl_TTTFriendsMode);
					TTTFriendsMode.setAutoscrolls(true);
					scrollTTTFriendsMode.getViewport().setBackground(Color.WHITE);
					
					// TICTACTOE ALL MODES
					
					JPanel TicTacToeModes = new JPanel();
					GamesMenu.add(TicTacToeModes, "TTTModes");
					TicTacToeModes.setBackground(Color.WHITE);
					TicTacToeModes.setLayout(null);
					
					// TICTACTOE GM
					JPanel TTTGM = new JPanel();
					TTTGM.setBackground(Color.WHITE);
					GamesMenu.add(TTTGM, "TTTGM");
					TTTGM.setLayout(null);
					
					
					
					
					// BATTLESHIP FRIEND MODE
					
					JScrollPane scrollBS = new JScrollPane();
					scrollBS.setAutoscrolls(true);
					scrollBS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollBS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					GamesMenu.add(scrollBS, "scrollBS");
					JPanel BSFriendsMode = new JPanel();
				//	GamesMenu.add(TTTFriendsMode, "TTTFriendsMode");
					BSFriendsMode.setBackground(Color.WHITE);
						
						GroupLayout gl_BSFriendsMode = new GroupLayout(BSFriendsMode);
						gl_BSFriendsMode.setHorizontalGroup(
							gl_BSFriendsMode.createParallelGroup(Alignment.LEADING)
								.addGap(0, 666, Short.MAX_VALUE)
						);
						gl_BSFriendsMode.setVerticalGroup(
							gl_BSFriendsMode.createParallelGroup(Alignment.LEADING)
								.addGap(0, 560, Short.MAX_VALUE)
						);
						scrollBS.setViewportView(BSFriendsMode);
						BSFriendsMode.setLayout(gl_BSFriendsMode);
						BSFriendsMode.setAutoscrolls(true);
						scrollBS.getViewport().setBackground(Color.WHITE);
						
						// TICTACTOE ALL MODES
						
						JPanel BSModes = new JPanel();
						GamesMenu.add(BSModes, "BSModes");
						BSModes.setBackground(Color.WHITE);
						BSModes.setLayout(null);
						
						// TICTACTOE GM
						JPanel BSGM = new JPanel();
						BSGM.setBackground(Color.WHITE);
						TTTGM.setBackground(Color.WHITE);
						GamesMenu.add(BSGM, "BSGM");
						BSGM.setLayout(null);
				
				
				//__________________________ALL GAMES PANEL___________________________
					
				//Snake game
				JLabel SnakeIcon = new JLabel("");
				SnakeIcon.setBounds(44, 66, 103, 95);
				AllGames.add(SnakeIcon);
				SnakeIcon.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/snakee.png")));
				
				//Tic Tac Toe
				JLabel TTTIcon = new JLabel("");
				TTTIcon.setBounds(216, 66, 95, 95);
				AllGames.add(TTTIcon);
				TTTIcon.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/tictactoee.PNG")));
			
				
				JLabel lblOurLatestGames = new JLabel("  Our Latest Games!");
				lblOurLatestGames.setBounds(212, 0, 300, 50);
				AllGames.add(lblOurLatestGames);
				JSeparator separator_ourGames = new JSeparator();
				separator_ourGames.setBackground(new Color(32, 178, 170));
				separator_ourGames.setBounds(199, 51, 350, 1);
				AllGames.add(separator_ourGames);
				separator_ourGames.setForeground(new Color(32, 178, 170));
				lblOurLatestGames.setFont(new Font("Calibri", Font.PLAIN, 35));
				lblOurLatestGames.setForeground(new Color(32, 178, 170));
			
				
				SnakePlayBtn = new JTextField();
				SnakePlayBtn.setHorizontalAlignment(SwingConstants.CENTER);
				SnakePlayBtn.setBounds(48, 168, 90, 25);
				AllGames.add(SnakePlayBtn);
				SnakePlayBtn.setText("Play");
				SnakePlayBtn.setForeground(new Color(0, 0, 0));
				SnakePlayBtn.setFont(new Font("Calibri", Font.PLAIN, 14));
				SnakePlayBtn.setEditable(false);
				SnakePlayBtn.setColumns(10);
				SnakePlayBtn.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
				SnakePlayBtn.setBackground(new Color(255, 255, 255));
				
			
				SnakePlayBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (!tI.equals(0)) tI.cancel();
						if (!tN.equals(0)) tN.cancel();
						if (!tFMttt.equals(0)) tFMttt.cancel();
					client.playSnakeClient();
		 			}
				});
				
				TicTacToePlayBtn = new JTextField();
				TicTacToePlayBtn.setHorizontalAlignment(SwingConstants.CENTER);
				TicTacToePlayBtn.setBounds(219, 168, 90, 25);
				AllGames.add(TicTacToePlayBtn);
				TicTacToePlayBtn.setText("Play");
				TicTacToePlayBtn.setForeground(Color.BLACK);
				TicTacToePlayBtn.setFont(new Font("Calibri", Font.PLAIN, 14));
				TicTacToePlayBtn.setEditable(false);
				TicTacToePlayBtn.setColumns(10);
				TicTacToePlayBtn.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
				TicTacToePlayBtn.setBackground(Color.WHITE);
				
				JLabel iconBS = new JLabel("");
				iconBS.setHorizontalAlignment(SwingConstants.CENTER);
				iconBS.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/download (1).jpeg")));
				iconBS.setBounds(417, 66, 95, 95);
				AllGames.add(iconBS);
				
				playBS = new JTextField();
				playBS.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!tI.equals(0)) tI.cancel();
						if(!tFMttt.equals(0)) tFMttt.cancel();
						if(!tN.equals(0)) tN.cancel();
						Solitaire.main(new String[0]);
					}
				});
				playBS.setText("Play");
				playBS.setHorizontalAlignment(SwingConstants.CENTER);
				playBS.setForeground(Color.BLACK);
				playBS.setFont(new Font("Calibri", Font.PLAIN, 14));
				playBS.setEditable(false);
				playBS.setColumns(10);
				playBS.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
				playBS.setBackground(Color.WHITE);
				playBS.setBounds(417, 168, 90, 25);
				AllGames.add(playBS);
				
				JLabel iconPac = new JLabel("");
				iconPac.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/pacman.jpg")));
				iconPac.setHorizontalAlignment(SwingConstants.CENTER);
				iconPac.setBounds(601, 66, 95, 95);
				AllGames.add(iconPac);
				
				playPac = new JTextField();
				playPac.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						client.playPac();
					}
				});
				playPac.setText("Play");
				playPac.setHorizontalAlignment(SwingConstants.CENTER);
				playPac.setForeground(Color.BLACK);
				playPac.setFont(new Font("Calibri", Font.PLAIN, 14));
				playPac.setEditable(false);
				playPac.setColumns(10);
				playPac.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
				playPac.setBackground(Color.WHITE);
				playPac.setBounds(601, 168, 90, 25);
				AllGames.add(playPac);
				
				JLabel lblBingo = new JLabel("Bingo");
				lblBingo.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/bingo-.jpg")));
				lblBingo.setBounds(290, 259, 111, 74);
				AllGames.add(lblBingo);
				
				txtPlay = new JTextField();
				txtPlay.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						Bingo.main(new String[0]);
					}
				});
				txtPlay.setText("Play");
				txtPlay.setBounds(290, 333, 103, 22);
				AllGames.add(txtPlay);
				txtPlay.setColumns(10);
				
				TicTacToePlayBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (!tFMbs.equals(0)) tFMbs.cancel();
						if (!tI.equals(0)) tI.cancel();
						if (!tFMttt.equals(0)) tFMttt.cancel();
						if (!tN.equals(0)) tN.cancel();
						if (!tSB.equals(0)) tSB.cancel();
						gamesLayout.show(GamesMenu, "TTTModes");
		 			}
				});
				
				
				//______________________________TIC TAC TOE MODES______________________________
					
					
					JLabel lblTicTacToe = new JLabel(" TIC TAC TOE");
					lblTicTacToe.setForeground(new Color(32, 178, 170));
					lblTicTacToe.setFont(new Font("Calibri", Font.PLAIN, 35));
					lblTicTacToe.setBounds(292, 29, 190, 50);
					TicTacToeModes.add(lblTicTacToe);
					
					JSeparator separator_TTT = new JSeparator();
					separator_TTT.setForeground(new Color(32, 178, 170));
					separator_TTT.setBackground(new Color(32, 178, 170));
					separator_TTT.setBounds(232, 79, 340, 2);
					TicTacToeModes.add(separator_TTT);
					
					btnGMttt = new JTextField();
					btnGMttt.setHorizontalAlignment(SwingConstants.CENTER);
					btnGMttt.setEditable(false);
					btnGMttt.setText("Global Mode");
					btnGMttt.setForeground(Color.DARK_GRAY);
					btnGMttt.setFont(new Font("Calibri", Font.BOLD, 18));
					btnGMttt.setColumns(10);
					btnGMttt.setBorder(new LineBorder(new Color(178, 34, 34), 3, true));
					btnGMttt.setBounds(332, 325, 150, 50);
					TicTacToeModes.add(btnGMttt);

					btnCMttt = new JTextField();
					btnCMttt.setHorizontalAlignment(SwingConstants.CENTER);
					btnCMttt.setEditable(false);
					btnCMttt.setCaretColor(new Color(0, 0, 128));
					btnCMttt.setText("Computer Mode");
					btnCMttt.setForeground(Color.DARK_GRAY);
					btnCMttt.setFont(new Font("Calibri", Font.BOLD, 18));
					btnCMttt.setColumns(10);
					btnCMttt.setBorder(new LineBorder(new Color(0, 0, 139), 3, true));
					btnCMttt.setBounds(618, 325, 150, 50);
					TicTacToeModes.add(btnCMttt);
					
					btnFMttt = new JTextField();
					btnFMttt.setHorizontalAlignment(SwingConstants.CENTER);
					btnFMttt.setText("Friend Mode");
					btnFMttt.setForeground(Color.DARK_GRAY);
					btnFMttt.setFont(new Font("Calibri", Font.BOLD, 18));
					btnFMttt.setEditable(false);
					btnFMttt.setColumns(10);
					btnFMttt.setBorder(new LineBorder(Color.GREEN, 3, true));
					btnFMttt.setBounds(47, 325, 150, 50);
					TicTacToeModes.add(btnFMttt);
					
					
					//_________________________________________________TIC TAC TOE COMPUTERMODE___________________________________________________________
					btnCMttt.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {	//We can directly start the game	
							if (!tFMbs.equals(0)) tFMbs.cancel();
							if (!tI.equals(0)) tI.cancel();
							if (!tFMttt.equals(0)) tFMttt.cancel();
							if (!tN.equals(0)) tN.cancel();
							client.playGame("Tic Tac Toe","CM",client.username, "");
						}
					});
					
					
					
					
//______________________________BATTLSE SHIP MODES______________________________
					
					
					JLabel lblBS = new JLabel("MONOPOLY");
					lblBS.setForeground(new Color(32, 178, 170));
					lblBS.setFont(new Font("Calibri", Font.PLAIN, 35));
					lblBS.setBounds(302, 0, 190, 50);
					BSModes.add(lblBS);
					
					JSeparator separator_BS = new JSeparator();
					separator_BS.setForeground(new Color(32, 178, 170));
					separator_BS.setBackground(new Color(32, 178, 170));
					separator_BS.setBounds(210, 54, 340, 2);
					BSModes.add(separator_BS);

					btnGMBS = new JTextField();
					btnGMBS.setHorizontalAlignment(SwingConstants.CENTER);
					btnGMBS.setEditable(false);
					btnGMBS.setText("Global Mode");
					btnGMBS.setForeground(Color.DARK_GRAY);
					btnGMBS.setFont(new Font("Calibri", Font.BOLD, 18));
					btnGMBS.setColumns(10);
					btnGMBS.setBorder(new LineBorder(new Color(178, 34, 34), 3, true));
					btnGMBS.setBounds(356, 319, 150, 50);
					BSModes.add(btnGMBS);

					btnCMBS = new JTextField();
					btnCMBS.setHorizontalAlignment(SwingConstants.CENTER);
					btnCMBS.setEditable(false);
					btnCMBS.setCaretColor(new Color(0, 0, 128));
					btnCMBS.setText("Computer Mode");
					btnCMBS.setForeground(Color.DARK_GRAY);
					btnCMBS.setFont(new Font("Calibri", Font.BOLD, 18));
					btnCMBS.setColumns(10);
					btnCMBS.setBorder(new LineBorder(new Color(0, 0, 139), 3, true));
					btnCMBS.setBounds(619, 319, 150, 50);
					BSModes.add(btnCMBS);
					
					btnFMBS = new JTextField();
					btnFMBS.setHorizontalAlignment(SwingConstants.CENTER);
					btnFMBS.setText("Friend Mode");
					btnFMBS.setForeground(Color.DARK_GRAY);
					btnFMBS.setFont(new Font("Calibri", Font.BOLD, 18));
					btnFMBS.setEditable(false);
					btnFMBS.setColumns(10);
					btnFMBS.setBorder(new LineBorder(Color.GREEN, 3, true));
					btnFMBS.setBounds(52, 319, 150, 50);
					BSModes.add(btnFMBS);
					
					
					//_________________________________________________BATTLE SHIP GLOBALMODE___________________________________________________________
					//Start a chat and set the rule or enter an existing chat. 
					btnGMBS.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if (!tI.equals(0)) tI.cancel();
							if (!tFMttt.equals(0)) tFMttt.cancel();
							if (!tN.equals(0)) tN.cancel();
							gamesLayout.show(GamesMenu, "BSGM");
							
							//commencer la chat
							//A mettre dans la chat
							//client.playGame("Tic Tac Toe","GM",client.username,"randomblabla");

						}
					});
					//_________________________________________________BATTLE SHIP COMPUTERMODE___________________________________________________________
					btnCMBS.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {	//We can directly start the game	
							if (!tFMbs.equals(0)) tFMbs.cancel();
							if (!tI.equals(0)) tI.cancel();
							if (!tFMttt.equals(0)) tFMttt.cancel();
							if (!tN.equals(0)) tN.cancel();
							client.playGame("Battle Ship","CM",client.username, "");
						}
					});
		
		// ______________________________________________________LOGIN PANEL______________________________________________________
		
		JLabel accountLabel = new JLabel("ALREADY HAVE AN ACCOUNT?");
		accountLabel.setBounds(79, 35, 265, 27);
		accountLabel.setFont(new Font("Calibri", Font.BOLD, 19));
		accountLabel.setForeground(Color.WHITE);
		UserLogin.add(accountLabel);
		
		usernameField = new JTextField();
		usernameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				usernameField.setText("");
			}
		});
		usernameField.setBounds(139, 118, 205, 33);
		usernameField.setBorder(null);
		usernameField.setFont(new Font("Calibri", Font.PLAIN, 18));
		usernameField.setForeground(Color.WHITE);
		usernameField.setBackground(Color.GRAY);
		UserLogin.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel newUser = new JLabel("NEW TO OUR GAMEROOM?");
		newUser.setBounds(84, 485, 265, 27);
		newUser.setForeground(Color.WHITE);
		newUser.setFont(new Font("Calibri", Font.BOLD, 19));
		UserLogin.add(newUser);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(84, 154, 324, 2);
		UserLogin.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(84, 234, 324, 2);
		UserLogin.add(separator2);
		
		JLabel forgotPass = new JLabel("Forgot password?");
		forgotPass.setBounds(320, 272, 211, 40);
		forgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registerLayout.show(panel_2, "ForgotPassword");
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				if (!tN.equals(0)) tN.cancel();
			}
		});
		forgotPass.setForeground(Color.WHITE);
		forgotPass.setFont(new Font("Calibri", Font.BOLD, 17));
		UserLogin.add(forgotPass);
		
		
		JLabel lblUsernameOrPassword = new JLabel("Username or Password Incorrect");
		lblUsernameOrPassword.setVisible(false);
		lblUsernameOrPassword.setForeground(Color.RED);
		lblUsernameOrPassword.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUsernameOrPassword.setBounds(84, 75, 324, 16);
		UserLogin.add(lblUsernameOrPassword);
		
		JLabel lblCannotLoginNow = new JLabel("Cannot login now. Try again later!");
		lblCannotLoginNow.setVisible(false);
		lblCannotLoginNow.setForeground(Color.RED);
		lblCannotLoginNow.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCannotLoginNow.setBounds(84, 75, 324, 16);
		UserLogin.add(lblCannotLoginNow);
		
		
		JLabel iconRouge = new JLabel("");
		iconRouge.setFont(new Font("Calibri", Font.BOLD, 18));
		iconRouge.setForeground(Color.WHITE);
		iconRouge.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/notif.png")));
		iconRouge.setBounds(175, 421, 25, 25);
		iconRouge.setHorizontalTextPosition(JLabel.CENTER);
		iconRouge.setVerticalTextPosition(JLabel.CENTER);
		SideBar.add(iconRouge);
		
		
		JLabel iconRouge2 = new JLabel("");
		iconRouge2.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/notif.png")));
		iconRouge2.setVerticalTextPosition(SwingConstants.CENTER);
		iconRouge2.setHorizontalTextPosition(SwingConstants.CENTER);
		iconRouge2.setForeground(Color.WHITE);
		iconRouge2.setFont(new Font("Calibri", Font.BOLD, 18));
		iconRouge2.setBounds(154, 496, 25, 25);
		SideBar.add(iconRouge2);
		
		loginBtn = new JTextField();
		loginBtn.setHorizontalAlignment(SwingConstants.CENTER);
		loginBtn.setText("LOGIN");
		loginBtn.setEditable(false);
		loginBtn.setBounds(84, 360, 380, 49);
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				if (!tN.equals(0)) tN.cancel();
				String response = client.logInClient(usernameField.getText(), passwordField.getText());
				if (response.equals("success")) {
					client.username = usernameField.getText();
					mainLayout.show(frame.getContentPane(), "home");
					othersLayout.show(others, "GamesMenu");
					textField_3.setText("Hello, " + client.username + "!");
					
					tSB = new Timer();
					
					tSB.scheduleAtFixedRate(
						    new TimerTask()
						    {
						        public void run()
						        {
						        	SideBar.remove(iconRouge);
						        	SideBar.remove(iconRouge2);
						        	SideBar.remove(txtFriends);
						        	
						        	String num = client.getNumFriends();
						        	List<String> notif = client.showNotifClient();
						        	List<String> msgs = client.showInstMsgClient();
						        	
						        	if (!(notif == null || notif.size() == 0 || notif.get(0).equals("")))
						        	{
						        		int size = notif.size();
							        	String notifSize = Integer.toString(size);
						        		SideBar.add(iconRouge);
						        		iconRouge.setText(notifSize);
						        	}
						        	if (!(msgs == null || msgs.size() == 0 || msgs.get(0).equals("")))
						        	{
						        		int size2 = msgs.size();
							        	String msgsSize = Integer.toString(size2);
						        		SideBar.add(iconRouge2);
						        		iconRouge2.setText(msgsSize);
						        	}
						        	SideBar.add(txtFriends);
						        	if (num.equals("0"))
						        		txtFriends.setText("Friends");
						        	else txtFriends.setText("Friends   " + num);
						        	txtFriends.addMouseListener(new MouseAdapter() {
						    			@Override
						    			public void mouseClicked(MouseEvent arg0) {
						    				if (!tFMbs.equals(0)) tFMbs.cancel();
						    				if (!tI.equals(0)) tI.cancel();
											if (!tFMttt.equals(0)) tFMttt.cancel();
											if (!tN.equals(0)) tN.cancel();
											
						    				othersLayout.show(others, "friends");
						    				friendNameField.setText("");
						    				textField.setText("");
						    			}
						    			@Override
						    			public void mouseEntered(MouseEvent e) {
						    				txtFriends.setBounds(12, 364, 220, 28);
						    			}
						    			@Override
						    			public void mouseExited(MouseEvent e) {
						    				txtFriends.setBounds(12, 371, 220, 28);
						    			}
						    		});
						        	SideBar.revalidate();
						        	SideBar.repaint();
						        }
						    },
						    0,      // run first occurrence immediatetly
						    2000); // run every two seconds
				}
				else if (response.equals("failure")) {
					lblUsernameOrPassword.setVisible(true);
				}
				else if (response.equals("cannot login now")) {
					lblUsernameOrPassword.setVisible(false);
					lblCannotLoginNow.setVisible(true);
				}
				
 			}
		});
		loginBtn.setFont(new Font("Calibri", Font.BOLD, 19));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setColumns(10);
		loginBtn.setBorder(null);
		loginBtn.setBackground(new Color(0, 204, 204));
		UserLogin.add(loginBtn);
		
		goToSignupBtn = new JTextField();
		goToSignupBtn.setHorizontalAlignment(SwingConstants.CENTER);
		goToSignupBtn.setText("SIGN UP NOW!");
		goToSignupBtn.setEditable(false);
		goToSignupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registerLayout.show(panel_2, "signup");
			}
		});
		goToSignupBtn.setBounds(84, 544, 380, 49);
		goToSignupBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		goToSignupBtn.setForeground(Color.WHITE);
		goToSignupBtn.setColumns(10);
		goToSignupBtn.setBackground(Color.GRAY);
		UserLogin.add(goToSignupBtn);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
			}
		});
		passwordField.setBounds(139, 196, 205, 33);
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 18));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.GRAY);
		UserLogin.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(81, 128, 23, 23);
		label.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/Person 22.png")));
		UserLogin.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(81, 208, 23, 23);
		label_1.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/lock2.png")));
		UserLogin.add(label_1);
		
		// ______________________________________________________SIGNUP PANEL______________________________________________________
		
		
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(74, 94, 355, 2);
		UserSignup.add(separator_4);
		
		usernameFieldS = new JTextField();
		usernameFieldS.setForeground(Color.WHITE);
		usernameFieldS.setFont(new Font("Calibri", Font.PLAIN, 18));
		usernameFieldS.setColumns(10);
		usernameFieldS.setBorder(null);
		usernameFieldS.setBackground(Color.GRAY);
		usernameFieldS.setBounds(162, 60, 205, 33);
		UserSignup.add(usernameFieldS);
		
		JLabel lblUsername = new JLabel("  USERNAME");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 13));
		lblUsername.setBounds(74, 62, 76, 29);
		UserSignup.add(lblUsername);
		
		JLabel lblMail = new JLabel(" MAIL");
		lblMail.setForeground(Color.WHITE);
		lblMail.setFont(new Font("Calibri", Font.BOLD, 13));
		lblMail.setBounds(74, 193, 76, 29);
		UserSignup.add(lblMail);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(74, 226, 355, 2);
		UserSignup.add(separator_5);
		
		mailField = new JTextField();
		mailField.setForeground(Color.WHITE);
		mailField.setFont(new Font("Calibri", Font.PLAIN, 18));
		mailField.setColumns(10);
		mailField.setBorder(null);
		mailField.setBackground(Color.GRAY);
		mailField.setBounds(155, 190, 274, 33);
		UserSignup.add(mailField);
		
		JLabel lblCountry = new JLabel(" COUNTRY");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Calibri", Font.BOLD, 13));
		lblCountry.setBounds(74, 352, 76, 29);
		UserSignup.add(lblCountry);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(79, 379, 350, 2);
		UserSignup.add(separator_6);
		
		countryField = new JTextField();
		countryField.setForeground(Color.WHITE);
		countryField.setFont(new Font("Calibri", Font.PLAIN, 18));
		countryField.setColumns(10);
		countryField.setBorder(null);
		countryField.setBackground(Color.GRAY);
		countryField.setBounds(162, 345, 205, 33);
		UserSignup.add(countryField);
		
		JLabel lblPassword = new JLabel(" PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 13));
		lblPassword.setBounds(74, 131, 76, 29);
		UserSignup.add(lblPassword);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(74, 158, 355, 2);
		UserSignup.add(separator_7);
		
		passwordFieldS = new JPasswordField();
		passwordFieldS.setForeground(Color.WHITE);
		passwordFieldS.setBorder(null);
		passwordFieldS.setFont(new Font("Calibri", Font.PLAIN, 18));
		passwordFieldS.setBackground(Color.GRAY);
		passwordFieldS.setBounds(162, 122, 205, 33);
		UserSignup.add(passwordFieldS);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(74, 299, 355, 2);
		UserSignup.add(separator_8);
		
		JLabel lblGender = new JLabel(" GENDER");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Calibri", Font.BOLD, 13));
		lblGender.setBounds(74, 267, 76, 29);
		UserSignup.add(lblGender);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(79, 458, 350, 2);
		UserSignup.add(separator_9);
		
		JLabel lblAge = new JLabel(" AGE");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAge.setBounds(74, 431, 76, 29);
		UserSignup.add(lblAge);
		
		ageField = new JTextField();
		ageField.setForeground(Color.WHITE);
		ageField.setFont(new Font("Calibri", Font.PLAIN, 18));
		ageField.setColumns(10);
		ageField.setBorder(null);
		ageField.setBackground(Color.GRAY);
		ageField.setBounds(162, 422, 205, 33);
		UserSignup.add(ageField);
		
		genderField = new JTextField();
		genderField.setForeground(Color.WHITE);
		genderField.setFont(new Font("Calibri", Font.PLAIN, 18));
		genderField.setColumns(10);
		genderField.setBorder(null);
		genderField.setBackground(Color.GRAY);
		genderField.setBounds(155, 258, 274, 33);
		UserSignup.add(genderField);
		
		JLabel lblUsernameOrMail = new JLabel("Username or Mail already exists");
		lblUsernameOrMail.setVisible(false);
		lblUsernameOrMail.setForeground(Color.RED);
		lblUsernameOrMail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUsernameOrMail.setBounds(74, 25, 324, 16);
		UserSignup.add(lblUsernameOrMail);
		
		JLabel lblSignUpSuccessful = new JLabel("Sign up successful but cannot login now.");
		lblSignUpSuccessful.setVisible(false);
		lblSignUpSuccessful.setForeground(Color.RED);
		lblSignUpSuccessful.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSignUpSuccessful.setBounds(74, 25, 324, 16);
		UserSignup.add(lblSignUpSuccessful);
		
		signUpBtn = new JTextField();
		signUpBtn.setHorizontalAlignment(SwingConstants.CENTER);
		signUpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				if (!tN.equals(0)) tN.cancel();
				if (!tSB.equals(0)) tSB.cancel();
				String response = client.signUpClient(usernameFieldS.getText(), passwordFieldS.getText(), mailField.getText(), genderField.getText(), countryField.getText(), ageField.getText());
		//		JOptionPane.showMessageDialog(null, response);
				if (response.equals("success")) {
					client.username = usernameFieldS.getText();
					mainLayout.show(frame.getContentPane(), "home");
					othersLayout.show(others, "GamesMenu");
					textField_3.setText("Hello, " + client.username + "!");
					
					tSB = new Timer();
					
					tSB.scheduleAtFixedRate(
						    new TimerTask()
						    {
						        public void run()
						        {
						        	SideBar.remove(iconRouge);
						        	SideBar.remove(iconRouge2);
						        	SideBar.remove(txtFriends);
						        	SideBar.add(txtFriends);
						        	String num = client.getNumFriends();
						        	List<String> notif = client.showNotifClient();
						        	List<String> msgs = client.showInstMsgClient();
						        	
						        	if (!(notif == null || notif.size() == 0 || notif.get(0).equals("")))
						        	{
						        		int size = notif.size();
							        	String notifSize = Integer.toString(size);
						        		SideBar.add(iconRouge);
						        		iconRouge.setText(notifSize);
						        	}
						        	if (!(msgs == null || msgs.size() == 0 || msgs.get(0).equals("")))
						        	{
						        		int size2 = msgs.size();
							        	String msgsSize = Integer.toString(size2);
						        		SideBar.add(iconRouge2);
						        		iconRouge2.setText(msgsSize);
						        	}
						      //  	JOptionPane.showMessageDialog(null, num);
						        	if (num.equals("0"))
						        		txtFriends.setText("Friends");
						        	else txtFriends.setText("Friends   " + num);
						        	txtFriends.addMouseListener(new MouseAdapter() {
						    			@Override
						    			public void mouseClicked(MouseEvent arg0) {
						    				if (!tFMbs.equals(0)) tFMbs.cancel();
						    				if (!tI.equals(0)) tI.cancel();
											if (!tFMttt.equals(0)) tFMttt.cancel();
											if (!tN.equals(0)) tN.cancel();
											
						    				othersLayout.show(others, "friends");
						    				friendNameField.setText("");
						    				textField.setText("");
						    			}
						    			@Override
						    			public void mouseEntered(MouseEvent e) {
						    				txtFriends.setBounds(12, 364, 220, 28);
						    			}
						    			@Override
						    			public void mouseExited(MouseEvent e) {
						    				txtFriends.setBounds(12, 371, 220, 28);
						    			}
						    		});
						        	SideBar.revalidate();
						        	SideBar.repaint();
						        }
						    },
						    0,      // run first occurrence immediatetly
						    2000); // run every two seconds
				}
				else if (response.equals("failure")) {
					lblUsernameOrMail.setVisible(true);
				}
				else if (response.equals("cannot login now")) {
					lblUsernameOrMail.setVisible(false);
					lblSignUpSuccessful.setVisible(true);
				}
			}
		});
		signUpBtn.setText("SIGN UP");
		signUpBtn.setForeground(Color.WHITE);
		signUpBtn.setFont(new Font("Calibri", Font.BOLD, 19));
		signUpBtn.setEditable(false);
		signUpBtn.setColumns(10);
		signUpBtn.setBorder(null);
		signUpBtn.setBackground(new Color(0, 204, 204));
		signUpBtn.setBounds(79, 558, 380, 49);
		UserSignup.add(signUpBtn);
		
		
		
		
		//_______________________________________________________________FORGOT PASSWORD PANEL__________________________________________________________________-
		
		EmailHasBeenSent = new JTextField();
		EmailHasBeenSent.setBorder(null);
		EmailHasBeenSent.setHorizontalAlignment(SwingConstants.CENTER);
		EmailHasBeenSent.setForeground(Color.WHITE);
		EmailHasBeenSent.setText("An email has been sent to your e-mail address.");
		EmailHasBeenSent.setFont(new Font("Calibri", Font.BOLD, 24));
		EmailHasBeenSent.setBackground(Color.GRAY);
		EmailHasBeenSent.setBounds(12, 276, 519, 56);
		EmailHasBeenSent.setColumns(10);
		
		txtPleaseSignIn = new JTextField();
		txtPleaseSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseSignIn.setText("Please sign in to this account to get");
		txtPleaseSignIn.setFont(new Font("Calibri", Font.BOLD, 22));
		txtPleaseSignIn.setForeground(Color.WHITE);
		txtPleaseSignIn.setBackground(Color.GRAY);
		txtPleaseSignIn.setBorder(null);
		txtPleaseSignIn.setBounds(12, 387, 519, 41);
		txtPleaseSignIn.setColumns(10);
		
		txtToGetYour = new JTextField();
		txtToGetYour.setText("your new password");
		txtToGetYour.setHorizontalAlignment(SwingConstants.CENTER);
		txtToGetYour.setForeground(Color.WHITE);
		txtToGetYour.setFont(new Font("Calibri", Font.BOLD, 22));
		txtToGetYour.setColumns(10);
		txtToGetYour.setBorder(null);
		txtToGetYour.setBackground(Color.GRAY);
		txtToGetYour.setBounds(12, 420, 519, 41);
		
		txtThenTryLogging = new JTextField();
		txtThenTryLogging.setText("Then try logging in again.");
		txtThenTryLogging.setHorizontalAlignment(SwingConstants.CENTER);
		txtThenTryLogging.setForeground(Color.WHITE);
		txtThenTryLogging.setFont(new Font("Calibri", Font.BOLD, 22));
		txtThenTryLogging.setColumns(10);
		txtThenTryLogging.setBorder(null);
		txtThenTryLogging.setBackground(Color.GRAY);
		txtThenTryLogging.setBounds(12, 498, 519, 41);
		
		LoginForgotPass = new JTextField();
		LoginForgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registerLayout.show(panel_2, "login");
			}
		});
		LoginForgotPass.setText("LOGIN");
		LoginForgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		LoginForgotPass.setForeground(Color.WHITE);
		LoginForgotPass.setFont(new Font("Calibri", Font.BOLD, 24));
		LoginForgotPass.setEditable(false);
		LoginForgotPass.setColumns(10);
		LoginForgotPass.setBorder(null);
		LoginForgotPass.setBackground(new Color(0, 204, 204));
		LoginForgotPass.setBounds(69, 584, 414, 56);
		
		
		EnterUsername = new JTextField();
		EnterUsername.setText("Please enter your username:");
		EnterUsername.setHorizontalAlignment(SwingConstants.CENTER);
		EnterUsername.setForeground(Color.WHITE);
		EnterUsername.setFont(new Font("Calibri", Font.BOLD, 24));
		EnterUsername.setColumns(10);
		EnterUsername.setBorder(null);
		EnterUsername.setBackground(Color.GRAY);
		EnterUsername.setBounds(12, 31, 519, 56);
		ForgotPassword.add(EnterUsername);
		
		ForgotPassword.add(EmailHasBeenSent);
		ForgotPassword.add(txtPleaseSignIn);
		ForgotPassword.add(txtToGetYour);
		ForgotPassword.add(txtThenTryLogging);
		ForgotPassword.add(LoginForgotPass);
		EmailHasBeenSent.setVisible(false);
		txtPleaseSignIn.setVisible(false);
		txtToGetYour.setVisible(false);
		txtThenTryLogging.setVisible(false);
		LoginForgotPass.setVisible(false);
		
		UserForgotPass = new JTextField();
		UserForgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = UserForgotPass.getText();
				String response = client.forgotPass(user);
				if (response.equals("success")) {
					EmailHasBeenSent.setVisible(true);
					txtPleaseSignIn.setVisible(true);
					txtToGetYour.setVisible(true);
					txtThenTryLogging.setVisible(true);
					LoginForgotPass.setVisible(true);
				}
			}
		});
		UserForgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		UserForgotPass.setForeground(Color.WHITE);
		UserForgotPass.setFont(new Font("Calibri", Font.BOLD, 20));
		UserForgotPass.setColumns(10);
		UserForgotPass.setBackground(Color.GRAY);
		UserForgotPass.setBounds(69, 100, 414, 56);
		ForgotPassword.add(UserForgotPass);
		
		// ______________________________________________________SIDE BAR______________________________________________________
		
		
		JLabel OurLogo = new JLabel("");
		OurLogo.setIcon(new ImageIcon(WelcomePage.class.getResource("/gameRoom/s (1).jpg")));
		OurLogo.setBounds(26, 13, 180, 119);
		SideBar.add(OurLogo);
		

    	txtFriends = new JTextField();
		txtFriends.setHorizontalAlignment(SwingConstants.CENTER);
		txtFriends.setEditable(false);
		txtFriends.setForeground(Color.WHITE);
		txtFriends.setFont(new Font("Calibri", Font.BOLD, 20));
		txtFriends.setColumns(10);
		txtFriends.setBorder(null);
		txtFriends.setBackground(Color.GRAY);
		txtFriends.setBounds(12, 371, 220, 28);
		SideBar.add(txtFriends);
   
		txtViewYourProfile = new JTextField();
		txtViewYourProfile.setHorizontalAlignment(SwingConstants.CENTER);
		txtViewYourProfile.setEditable(false);
		txtViewYourProfile.setFont(new Font("Calibri", Font.BOLD, 20));
		txtViewYourProfile.setForeground(Color.WHITE);
		txtViewYourProfile.setBorder(null);
		txtViewYourProfile.setBackground(Color.GRAY);
		txtViewYourProfile.setText("View your profile");
		txtViewYourProfile.setBounds(12, 224, 220, 28);
		SideBar.add(txtViewYourProfile);
		txtViewYourProfile.setColumns(10);
		
		txtViewYourScores = new JTextField();
		txtViewYourScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				txtViewYourScores.setBounds(12, 291, 220, 28);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtViewYourScores.setBounds(12, 298, 220, 28);
			}
		});
		txtViewYourScores.setHorizontalAlignment(SwingConstants.CENTER);
		txtViewYourScores.setEditable(false);
		txtViewYourScores.setText("View your scores");
		txtViewYourScores.setForeground(Color.WHITE);
		txtViewYourScores.setFont(new Font("Calibri", Font.BOLD, 20));
		txtViewYourScores.setColumns(10);
		txtViewYourScores.setBorder(null);
		txtViewYourScores.setBackground(Color.GRAY);
		txtViewYourScores.setBounds(12, 298, 220, 28);
		SideBar.add(txtViewYourScores);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 255, 220, 2);
		SideBar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 330, 220, 2);
		SideBar.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 399, 220, 2);
		SideBar.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 473, 220, 2);
		SideBar.add(separator_3);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(12, 175, 220, 2);
		SideBar.add(separator_10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.GRAY);
		textField_3.setBounds(12, 145, 220, 28);
		SideBar.add(textField_3);
		
		
		
		txtMenu = new JTextField();
		txtMenu.setBackground(new Color(0, 204, 204));
		txtMenu.setFont(new Font("Calibri", Font.BOLD, 18));
		txtMenu.setForeground(Color.WHITE);
		txtMenu.setEditable(false);
		txtMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				if (!tN.equals(0)) tN.cancel();
				othersLayout.show(others, "GamesMenu");
				gamesLayout.show(GamesMenu, "AllGames");
				
				tSB = new Timer();
				
				tSB.scheduleAtFixedRate(
					    new TimerTask()
					    {
					        public void run()
					        {
					        	SideBar.remove(iconRouge);
					        	SideBar.remove(iconRouge2);
					        	SideBar.remove(txtFriends);
					        	
					        	String num = client.getNumFriends();
					        	List<String> notif = client.showNotifClient();
					        	List<String> msgs = client.showInstMsgClient();
					        	
					        	if (!(notif == null || notif.size() == 0 || notif.get(0).equals("")))
					        	{
					        		int size = notif.size();
						        	String notifSize = Integer.toString(size);
					        		SideBar.add(iconRouge);
					        		iconRouge.setText(notifSize);
					        	}
					        	if (!(msgs == null || msgs.size() == 0 || msgs.get(0).equals("")))
					        	{
					        		int size2 = msgs.size();
						        	String msgsSize = Integer.toString(size2);
					        		SideBar.add(iconRouge2);
					        		iconRouge2.setText(msgsSize);
					        	}
					      //  	JOptionPane.showMessageDialog(null, num);
					        	SideBar.add(txtFriends);
					        	if (num.equals("0"))
					        		txtFriends.setText("Friends");
					        	else txtFriends.setText("Friends   " + num);
					        	txtFriends.addMouseListener(new MouseAdapter() {
					    			@Override
					    			public void mouseClicked(MouseEvent arg0) {
					    				if (!tFMbs.equals(0)) tFMbs.cancel();
					    				if (!tI.equals(0)) tI.cancel();
										if (!tFMttt.equals(0)) tFMttt.cancel();
										if (!tN.equals(0)) tN.cancel();
										
					    				othersLayout.show(others, "friends");
					    				friendNameField.setText("");
					    				textField.setText("");
					    			}
					    			@Override
					    			public void mouseEntered(MouseEvent e) {
					    				txtFriends.setBounds(12, 364, 220, 28);
					    			}
					    			@Override
					    			public void mouseExited(MouseEvent e) {
					    				txtFriends.setBounds(12, 371, 220, 28);
					    			}
					    		});
					        	SideBar.revalidate();
					        	SideBar.repaint();
					        }
					    },
					    0,      // run first occurrence immediatetly
					    2000); // run every two seconds
			}
		});
		txtMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtMenu.setText("Menu");
		txtMenu.setBounds(12, 632, 64, 35);
		SideBar.add(txtMenu);
		txtMenu.setColumns(10);
		
		txtLogOut = new JTextField();
		txtLogOut.setBackground(new Color(0, 204, 204));
		txtLogOut.setForeground(Color.WHITE);
		txtLogOut.setFont(new Font("Calibri", Font.BOLD, 18));
		txtLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				if (!tN.equals(0)) tN.cancel();
				if (!tSB.equals(0)) tSB.cancel();
				mainLayout.show(frame.getContentPane(), "loginOrSignup");
				client.closeSocket();
			}
		});
		txtLogOut.setEditable(false);
		txtLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogOut.setText("Log out");
		txtLogOut.setColumns(10);
		txtLogOut.setBounds(168, 632, 64, 35);
		SideBar.add(txtLogOut);

		
		// ______________________________________________________TICTACTOE FRIENDSMODE PANEL______________________________________________________
		 	
		
		JLabel WelcomeTTTFriend = new JLabel("Welcome to TicTacToe's Friends Mode!");
		WelcomeTTTFriend.setFont(new Font("Calibri", Font.PLAIN, 18));
		WelcomeTTTFriend.setBounds(12, 13, 347, 26);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(12, 37, 318, 2);
		separator_11.setBackground(Color.GRAY);
		separator_11.setForeground(Color.GRAY);
		
		txtYouCanSend = new JTextField();
		txtYouCanSend.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtYouCanSend.setBorder(null);
		txtYouCanSend.setBackground(Color.WHITE);
		txtYouCanSend.setEditable(false);
		txtYouCanSend.setText("You can send instant messages to your friends and invite them to play with you!");
		txtYouCanSend.setBounds(12, 52, 515, 26);
		txtYouCanSend.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblTo.setBounds(12, 102, 27, 16);
		
		friendToSend = new JTextField();
		friendToSend.setBorder(new LineBorder(new Color(171, 173, 179)));
		friendToSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				friendToSend.setText("");
			}
		});
		friendToSend.setBounds(43, 99, 116, 22);
		friendToSend.setColumns(10);
		
		btnSendRequestTTT = new JTextField();
		btnSendRequestTTT.setForeground(Color.WHITE);
		btnSendRequestTTT.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSendRequestTTT.setBackground(new Color(0, 204, 204));
		btnSendRequestTTT.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
		btnSendRequestTTT.setEditable(false);
		btnSendRequestTTT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String response = client.SendGameRequest("TTTRequests", friendToSend.getText());
				if (response.equals("request sent")) SendRequestResult.setText("Your game request has been sent to " + friendToSend.getText() + "!");
				else if (response.equals("duplicate request")) 
					SendRequestResult.setText("Your game request has already been sent to " + friendToSend.getText() + ".");
				else if (response.equals("not friends"))
					SendRequestResult.setText("You are not friends with " + friendToSend.getText() + ".");
				else if (response.equals("username doesn't exist"))
					SendRequestResult.setText("This username doesn't exist.");
			}
		});
		btnSendRequestTTT.setHorizontalAlignment(SwingConstants.CENTER);
		btnSendRequestTTT.setText("SendRequest");
		btnSendRequestTTT.setBounds(462, 99, 92, 22);
		btnSendRequestTTT.setColumns(10);
		
		JLabel YourRequests = new JLabel("Your requests:");
		YourRequests.setFont(new Font("Calibri", Font.PLAIN, 15));
		YourRequests.setBounds(12, 243, 144, 22);
		
		SendRequestResult = new JTextField();
		SendRequestResult.setFont(new Font("Calibri", Font.ITALIC, 16));
		SendRequestResult.setBackground(Color.WHITE);
		SendRequestResult.setBorder(null);
		SendRequestResult.setEditable(false);
		SendRequestResult.setBounds(154, 158, 279, 22);
		SendRequestResult.setColumns(10);
		
		NumRequestsTTT = new JTextField();
		NumRequestsTTT.setBackground(Color.WHITE);
		NumRequestsTTT.setEditable(false);
		NumRequestsTTT.setBounds(171, 242, 312, 22);
		NumRequestsTTT.setColumns(10);	
		
		btnFMttt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tN.equals(0)) tN.cancel();
				TTTFriendsMode.add(NumRequestsTTT);
				TTTFriendsMode.add(SendRequestResult);
				TTTFriendsMode.add(friendToSend);
				tFMttt = new Timer();

			tFMttt.scheduleAtFixedRate(
			    new TimerTask()
			    {
			        public void run()
			        {
			        	List<Component> compList = new ArrayList<Component>(Arrays.asList(TTTFriendsMode.getComponents()));
			        	compList.remove(friendToSend);
			        	compList.remove(NumRequestsTTT);
			        	compList.remove(SendRequestResult);
			        	for (Component c: compList) {
			        		TTTFriendsMode.remove(c);
			        	}
						TTTFriendsMode.add(WelcomeTTTFriend);
						TTTFriendsMode.add(txtYouCanSend);
						TTTFriendsMode.add(lblTo);
						TTTFriendsMode.add(btnSendRequestTTT);
						TTTFriendsMode.add(separator_11);
					//	friendToSend.setText("");
					//	SendRequestResult.setText("");
					//	NumRequestsTTT.setText("");
						gamesLayout.show(GamesMenu, "scrollTTT");
					//	gamesLayout.show(GamesMenu, "TTTFriendsMode");
						List <String> requests = client.getRequests("TTTRequests");
				
						if (requests == null) { NumRequestsTTT.setText("You have 0 requests"); }
						else if (requests.get(0).equals("")) { NumRequestsTTT.setText("You have 0 requests"); }
						else {
							int offset = 0;
							int num = requests.size();
							if (num == 1) NumRequestsTTT.setText("You have 1 request");
							else NumRequestsTTT.setText("You have " + num + " requests");
							for (int i = 0; i<num; i++) {
							String friend = requests.get(i);
							RequestReceivedTTT = new JTextField();
							RequestReceivedTTT.setBounds(12, 313 + offset, 421, 35);
							RequestReceivedTTT.setEditable(false);
							RequestReceivedTTT.setText(requests.get(i) + " sent you a game request!");
							TTTFriendsMode.add(RequestReceivedTTT);
							RequestReceivedTTT.setColumns(10);
							
							txtAcceptRequestTTT = new JTextField();
							txtAcceptRequestTTT.setText("Accept");
							txtAcceptRequestTTT.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									client.AcceptDeclineGameRequest("TTTRequests", friend);
								//Check if the user who sent the request is still online
									boolean onlineFr= client.checkOnline(friend);
									boolean availableFr=client.CheckAvailable(friend);
								//voir comment on veut le design pour display friend offline ou friend busy right now.
									if(onlineFr==true && availableFr==true)
									{
										client.playGame("Tic Tac Toe","FM",client.username, friend);
		//_____________________________________Apres changer pour snake si ca marche; playGame au lieu de playSnake
									}
									
								}
							});
							
							txtAcceptRequestTTT.setHorizontalAlignment(SwingConstants.CENTER);
							txtAcceptRequestTTT.setForeground(Color.WHITE);
							txtAcceptRequestTTT.setFont(new Font("Calibri", Font.BOLD, 16));
							txtAcceptRequestTTT.setEditable(false);
							txtAcceptRequestTTT.setColumns(10);
							txtAcceptRequestTTT.setBorder(null);
							txtAcceptRequestTTT.setBackground(new Color(0, 204, 204));
							txtAcceptRequestTTT.setBounds(445, 319 + offset, 92, 22);
							TTTFriendsMode.add(txtAcceptRequestTTT);
					
							
							txtDeclineRequestTTT = new JTextField();
							txtDeclineRequestTTT.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									client.AcceptDeclineGameRequest("TTTRequests", friend);
									SendRequestResult.setText("You declined " + friend + "'s request."); // a enlever apres
								}
							});
							txtDeclineRequestTTT.setText("Decline");
							txtDeclineRequestTTT.setHorizontalAlignment(SwingConstants.CENTER);
							txtDeclineRequestTTT.setForeground(Color.WHITE);
							txtDeclineRequestTTT.setFont(new Font("Calibri", Font.BOLD, 16));
							txtDeclineRequestTTT.setEditable(false);
							txtDeclineRequestTTT.setColumns(10);
							txtDeclineRequestTTT.setBorder(null);
							txtDeclineRequestTTT.setBackground(Color.GRAY);
							txtDeclineRequestTTT.setBounds(549, 319 + offset, 92, 22);
							TTTFriendsMode.add(txtDeclineRequestTTT);
							
							offset = offset + 100;
							
							if (offset > 300) {
								TTTFriendsMode.setPreferredSize(new Dimension (500, 300 + offset));
								
								scrollTTTFriendsMode.revalidate();
								scrollTTTFriendsMode.repaint();
							}
						}
						
						}
						TTTFriendsMode.revalidate();
						TTTFriendsMode.repaint();
			        }
			    },
			    0,      // run first occurrence immediatetly
			    2000); // run every 5 seconds
			}
		});
		
		
		
		//////////////////////////////////////////////////////////////////////////////
		
		//_______________________________________________CHAT GLOBAL MODE TTT__________________________________________________________________________
		
		TitleChatTTT = new JTextField();
		TitleChatTTT.setBounds(425, 426, 177, 33);
		TTTGM.add(TitleChatTTT);
		TitleChatTTT.setVisible(false);
		TitleChatTTT.setColumns(10);
		
		maxChatTTT = new JTextField();
		maxChatTTT.setBounds(425, 541, 177, 33);
		TTTGM.add(maxChatTTT);
		maxChatTTT.setVisible(false);
		maxChatTTT.setColumns(10);
		
		JLabel lblTitleTTT = new JLabel("Choose a title:");
		lblTitleTTT.setFont(new Font("Calibri", Font.BOLD, 17));
		lblTitleTTT.setBounds(164, 435, 159, 16);
		TTTGM.add(lblTitleTTT);
		lblTitleTTT.setVisible(false);
		
		JLabel lblMaxTTT = new JLabel("Set the maximum number of participants:");
		lblMaxTTT.setFont(new Font("Calibri", Font.BOLD, 17));
		lblMaxTTT.setBounds(55, 540, 311, 25);
		TTTGM.add(lblMaxTTT);
		lblMaxTTT.setVisible(false);
		
		txtYouAreThe = new JTextField();
		txtYouAreThe.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(204, 51, 51), null));
		txtYouAreThe.setEnabled(false);
		txtYouAreThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtYouAreThe.setFont(new Font("Calibri", Font.BOLD, 20));
		txtYouAreThe.setText("You are the admin of this chat!");
		txtYouAreThe.setBounds(110, 312, 610, 50);
		TTTGM.add(txtYouAreThe);
		txtYouAreThe.setColumns(10);
		txtYouAreThe.setVisible(false);
		
		JButton btnYES = new JButton("YES :(");
		btnYES.setBorder(new LineBorder(new Color(204, 51, 51), 2, true));
		btnYES.setFont(new Font("Calibri", Font.BOLD, 16));
		btnYES.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gamesLayout.show(GamesMenu, "AllGames");
				client.DecCount("Tic Tac Toe", "yes");
				tSB = new Timer();
				
				tSB.scheduleAtFixedRate(
					    new TimerTask()
					    {
					        public void run()
					        {
					        	SideBar.remove(iconRouge);
					        	SideBar.remove(iconRouge2);
					        	SideBar.remove(txtFriends);
					        	
					        	String num = client.getNumFriends();
					        	List<String> notif = client.showNotifClient();
					        	List<String> msgs = client.showInstMsgClient();
					        	
					        	if (!(notif == null || notif.size() == 0 || notif.get(0).equals("")))
					        	{
					        		int size = notif.size();
						        	String notifSize = Integer.toString(size);
					        		SideBar.add(iconRouge);
					        		iconRouge.setText(notifSize);
					        	}
					        	if (!(msgs == null || msgs.size() == 0 || msgs.get(0).equals("")))
					        	{
					        		int size2 = msgs.size();
						        	String msgsSize = Integer.toString(size2);
					        		SideBar.add(iconRouge2);
					        		iconRouge2.setText(msgsSize);
					        	}
					      //  	JOptionPane.showMessageDialog(null, num);
					        	SideBar.add(txtFriends);
					        	if (num.equals("0"))
					        		txtFriends.setText("Friends");
					        	else txtFriends.setText("Friends   " + num);
					        	txtFriends.addMouseListener(new MouseAdapter() {
					    			@Override
					    			public void mouseClicked(MouseEvent arg0) {
					    				if (!tFMbs.equals(0)) tFMbs.cancel();
					    				if (!tI.equals(0)) tI.cancel();
										if (!tFMttt.equals(0)) tFMttt.cancel();
										if (!tN.equals(0)) tN.cancel();
										
					    				othersLayout.show(others, "friends");
					    				friendNameField.setText("");
					    				textField.setText("");
					    			}
					    			@Override
					    			public void mouseEntered(MouseEvent e) {
					    				txtFriends.setBounds(12, 364, 220, 28);
					    			}
					    			@Override
					    			public void mouseExited(MouseEvent e) {
					    				txtFriends.setBounds(12, 371, 220, 28);
					    			}
					    		});
					        	SideBar.revalidate();
					        	SideBar.repaint();
					        }
					    },
					    0,      // run first occurrence immediatetly
					    2000); // run every two seconds
			}
		});
		btnYES.setBounds(182, 479, 171, 25);
		TTTGM.add(btnYES);
		btnYES.setVisible(false);
		
		
		JButton NoPlay = new JButton("No, I want to play!");
		NoPlay.setBorder(new LineBorder(new Color(204, 51, 0), 2, true));
		NoPlay.setFont(new Font("Calibri", Font.BOLD, 16));
		NoPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				client.DecCount("Tic Tac Toe", "no");
			}
		});
		NoPlay.setBounds(493, 479, 171, 25);
		TTTGM.add(NoPlay);
		NoPlay.setVisible(false);
		
		JLabel lblStartChat = new JLabel("Start Chat");
		lblStartChat.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStartChat.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Je vais avoir ddeuc text field et on doit lire leur contenus;
				if (!tSB.equals(0)) tSB.cancel();
				String countAdminTTT=maxChatTTT.getText();
				String titleTTT=TitleChatTTT.getText();
				client.StartChat(countAdminTTT, titleTTT, "Tic Tac Toe", client.username);
				TitleChatTTT.setVisible(false);
				maxChatTTT.setVisible(false);
				lblTitleTTT.setVisible(false);
				lblMaxTTT.setVisible(false);
				txtYouAreThe.setText("We hope you enjoyed this chat! Do you really want to quit?");
				txtYouAreThe.setVisible(true);
				lblStartChat.setVisible(false);
				btnYES.setVisible(true);
				NoPlay.setVisible(true);
			}
		});
		lblStartChat.setBounds(681, 594, 90, 33);
		TTTGM.add(lblStartChat);
		lblStartChat.setVisible(false);
		
				JButton btnChatTTT = new JButton("Chat");
				btnChatTTT.setBorder(null);
				btnChatTTT.setHorizontalTextPosition(SwingConstants.CENTER);
				btnChatTTT.setIcon(null);
				btnChatTTT.setBackground(new Color(0, 204, 204));
				btnChatTTT.setForeground(Color.BLACK);
				btnChatTTT.setFont(new Font("Calibri", Font.BOLD, 24));
				TTTGM.add(btnChatTTT);
				btnChatTTT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (!tSB.equals(0)) tSB.cancel();
						int state= client.chat("Tic Tac Toe", client.username);
						if(state==0) //He is the administrator  
						{
							TitleChatTTT.setVisible(true);
							maxChatTTT.setVisible(true);
							lblTitleTTT.setVisible(true);
							lblMaxTTT.setVisible(true);
							txtYouAreThe.setVisible(true);
							lblStartChat.setVisible(true);
							
						}
						else if (state==1) //Error
						{
							tSB = new Timer();
							
							tSB.scheduleAtFixedRate(
								    new TimerTask()
								    {
								        public void run()
								        {
								        	SideBar.remove(iconRouge);
								        	SideBar.remove(iconRouge2);
								        	SideBar.remove(txtFriends);
								        	
								        	String num = client.getNumFriends();
								        	List<String> notif = client.showNotifClient();
								        	List<String> msgs = client.showInstMsgClient();
								        	
								        	if (!(notif == null || notif.size() == 0 || notif.get(0).equals("")))
								        	{
								        		int size = notif.size();
									        	String notifSize = Integer.toString(size);
								        		SideBar.add(iconRouge);
								        		iconRouge.setText(notifSize);
								        	}
								        	if (!(msgs == null || msgs.size() == 0 || msgs.get(0).equals("")))
								        	{
								        		int size2 = msgs.size();
									        	String msgsSize = Integer.toString(size2);
								        		SideBar.add(iconRouge2);
								        		iconRouge2.setText(msgsSize);
								        	}
								      //  	JOptionPane.showMessageDialog(null, num);
								        	SideBar.add(txtFriends);
								        	if (num.equals("0"))
								        		txtFriends.setText("Friends");
								        	else txtFriends.setText("Friends   " + num);
								        	txtFriends.addMouseListener(new MouseAdapter() {
								    			@Override
								    			public void mouseClicked(MouseEvent arg0) {
								    				if (!tFMbs.equals(0)) tFMbs.cancel();
								    				if (!tI.equals(0)) tI.cancel();
													if (!tFMttt.equals(0)) tFMttt.cancel();
													if (!tN.equals(0)) tN.cancel();
													
								    				othersLayout.show(others, "friends");
								    				friendNameField.setText("");
								    				textField.setText("");
								    			}
								    			@Override
								    			public void mouseEntered(MouseEvent e) {
								    				txtFriends.setBounds(12, 364, 220, 28);
								    			}
								    			@Override
								    			public void mouseExited(MouseEvent e) {
								    				txtFriends.setBounds(12, 371, 220, 28);
								    			}
								    		});
								        	SideBar.revalidate();
								        	SideBar.repaint();
								        }
								    },
								    0,      // run first occurrence immediatetly
								    2000); // run every two seconds
							txtYouAreThe.setText("This chat is currently full. Try again later!");
							txtYouAreThe.setVisible(true);
						}
						
						else {
							txtYouAreThe.setText("We hope you enjoyed this chat! Do you really want to quit?");
							txtYouAreThe.setVisible(true);
							lblStartChat.setVisible(false);
							btnYES.setVisible(true);
							NoPlay.setVisible(true);
						}
					}
				});
				btnChatTTT.setBounds(90, 153, 153, 50);
				
				JLabel TTTGMlbl = new JLabel("TIC TAC TOE GLOBAL MODE");
				TTTGMlbl.setHorizontalAlignment(SwingConstants.CENTER);
				TTTGMlbl.setForeground(new Color(32, 178, 170));
				TTTGMlbl.setFont(new Font("Calibri", Font.PLAIN, 35));
				TTTGMlbl.setBounds(201, 22, 420, 50);
				TTTGM.add(TTTGMlbl);
				
				JSeparator TTTGMsep = new JSeparator();
				TTTGMsep.setForeground(new Color(32, 178, 170));
				TTTGMsep.setBackground(new Color(32, 178, 170));
				TTTGMsep.setBounds(166, 70, 479, 2);
				TTTGM.add(TTTGMsep);
				
				

				//_________________________________________________TIC TAC TOE GLOBALMODE___________________________________________________________
				//Start a chat and set the rule or enter an existing chat. 
				btnGMttt.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						if (!tFMbs.equals(0)) tFMbs.cancel();
						if (!tI.equals(0)) tI.cancel();
						if (!tFMttt.equals(0)) tFMttt.cancel();
						if (!tN.equals(0)) tN.cancel();
						TitleChatTTT.setVisible(false);
						maxChatTTT.setVisible(false);
						lblTitleTTT.setVisible(false);
						lblMaxTTT.setVisible(false);
						txtYouAreThe.setVisible(false);
						txtYouAreThe.setText("You are the admin of this chat!");
						lblStartChat.setVisible(false);
						btnYES.setVisible(false);
						NoPlay.setVisible(false);
						gamesLayout.show(GamesMenu, "TTTGM");
						
						//commencer la chat
						//A mettre dans la chat
						//client.playGame("Tic Tac Toe","GM",client.username,"randomblabla");

					}
				});
				
				
				
				// ______________________________________________________BATLLESHIP FRIENDSMODE PANEL______________________________________________________
			 	
				
				JLabel WelcomeBSFriend = new JLabel("Welcome to Battle Ship's Friends Mode!");
				WelcomeBSFriend.setFont(new Font("Calibri", Font.PLAIN, 18));
				WelcomeBSFriend.setBounds(12, 13, 347, 26);
				
				JSeparator separatorBSFM = new JSeparator();
				separatorBSFM.setBounds(12, 37, 318, 2);
				separatorBSFM.setBackground(Color.GRAY);
				separatorBSFM.setForeground(Color.GRAY);
				
				txtYouCanSendBS = new JTextField();
				txtYouCanSendBS.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtYouCanSendBS.setBorder(null);
				txtYouCanSendBS.setBackground(Color.WHITE);
				txtYouCanSendBS.setEditable(false);
				txtYouCanSendBS.setText("You can send instant messages to your friends and invite them to play with you!");
				txtYouCanSendBS.setBounds(12, 52, 515, 26);
				txtYouCanSendBS.setColumns(10);
				
				JLabel lblToBS = new JLabel("To:");
				lblToBS.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblToBS.setBounds(12, 102, 27, 16);
				
				friendToSendBS = new JTextField();
				friendToSendBS.setBorder(new LineBorder(new Color(171, 173, 179)));
				friendToSendBS.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						friendToSendBS.setText("");
					}
				});
				friendToSendBS.setBounds(43, 99, 116, 22);
				friendToSendBS.setColumns(10);
				
				btnSendRequestBS = new JTextField();
				btnSendRequestBS.setForeground(Color.WHITE);
				btnSendRequestBS.setFont(new Font("Calibri", Font.BOLD, 16));
				btnSendRequestBS.setBackground(new Color(0, 204, 204));
				btnSendRequestBS.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
				btnSendRequestBS.setEditable(false);
				btnSendRequestBS.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						String response = client.SendGameRequest("BSRequests", friendToSendBS.getText());
						if (response.equals("request sent")) SendRequestResultBS.setText("Your game request has been sent to " + friendToSendBS.getText() + "!");
						else if (response.equals("duplicate request")) 
							SendRequestResultBS.setText("Your game request has already been sent to " + friendToSendBS.getText() + ".");
						else if (response.equals("not friends"))
							SendRequestResultBS.setText("You are not friends with " + friendToSendBS.getText() + ".");
						else if (response.equals("username doesn't exist"))
							SendRequestResultBS.setText("This username doesn't exist.");
					}
				});
				btnSendRequestBS.setHorizontalAlignment(SwingConstants.CENTER);
				btnSendRequestBS.setText("SendRequest");
				btnSendRequestBS.setBounds(462, 99, 92, 22);
				btnSendRequestBS.setColumns(10);
				
				JLabel YourRequestsBS = new JLabel("Your requests:");
				YourRequestsBS.setFont(new Font("Calibri", Font.PLAIN, 15));
				YourRequestsBS.setBounds(12, 243, 144, 22);
				
				SendRequestResultBS = new JTextField();
				SendRequestResultBS.setFont(new Font("Calibri", Font.ITALIC, 16));
				SendRequestResultBS.setBackground(Color.WHITE);
				SendRequestResultBS.setBorder(null);
				SendRequestResultBS.setEditable(false);
				SendRequestResultBS.setBounds(154, 158, 279, 22);
				SendRequestResultBS.setColumns(10);
				
				NumRequestsBS = new JTextField();
				NumRequestsBS.setBackground(Color.WHITE);
				NumRequestsBS.setEditable(false);
				NumRequestsBS.setBounds(171, 242, 312, 22);
				NumRequestsBS.setColumns(10);	
				
				btnFMBS.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (!tI.equals(0)) tI.cancel();
						if (!tN.equals(0)) tN.cancel();
						if (!tFMbs.equals(0)) tFMbs.cancel();
						BSFriendsMode.add(NumRequestsBS);
						BSFriendsMode.add(SendRequestResultBS);
						BSFriendsMode.add(friendToSendBS);
						tFMbs = new Timer();

					tFMbs.scheduleAtFixedRate(
					    new TimerTask()
					    {
					        public void run()
					        {
					        	List<Component> compListBS = new ArrayList<Component>(Arrays.asList(BSFriendsMode.getComponents()));
					        	compListBS.remove(friendToSendBS);
					        	compListBS.remove(NumRequestsBS);
					        	compListBS.remove(SendRequestResultBS);
					        	for (Component c: compListBS) {
					        		BSFriendsMode.remove(c);
					        	}
								BSFriendsMode.add(WelcomeBSFriend);
								BSFriendsMode.add(txtYouCanSendBS);
								BSFriendsMode.add(lblToBS);
								BSFriendsMode.add(btnSendRequestBS);
								BSFriendsMode.add(separatorBSFM);
							//	friendToSend.setText("");
							//	SendRequestResult.setText("");
							//	NumRequestsTTT.setText("");
								gamesLayout.show(GamesMenu, "scrollBS");
							//	gamesLayout.show(GamesMenu, "TTTFriendsMode");
								List <String> requests = client.getRequests("BSRequests");
						
								if (requests == null) { NumRequestsBS.setText("You have 0 requests"); }
								else if (requests.get(0).equals("")) { NumRequestsBS.setText("You have 0 requests"); }
								else {
									int offset = 0;
									int num = requests.size();
									if (num == 1) NumRequestsBS.setText("You have 1 request");
									else NumRequestsBS.setText("You have " + num + " requests");
									for (int i = 0; i<num; i++) {
									String friend = requests.get(i);
									RequestReceivedBS = new JTextField();
									RequestReceivedBS.setBounds(12, 313 + offset, 421, 35);
									RequestReceivedBS.setEditable(false);
									RequestReceivedBS.setText(requests.get(i) + " sent you a game request!");
									BSFriendsMode.add(RequestReceivedBS);
									RequestReceivedBS.setColumns(10);
									
									RequestReceivedBS = new JTextField();
									RequestReceivedBS.setText("Accept");
									RequestReceivedBS.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent arg0) {
											client.AcceptDeclineGameRequest("BSRequests", friend);
										//Check if the user who sent the request is still online
											boolean onlineFr= client.checkOnline(friend);
											boolean availableFr=client.CheckAvailable(friend);
										//voir comment on veut le design pour display friend offline ou friend busy right now.
											if(onlineFr==true && availableFr==true)
											{
												client.playGame("Battle Ship","FM",client.username, friend);
				//_____________________________________Apres changer pour snake si ca marche; playGame au lieu de playSnake
											}
											
										}
									});
									
									RequestReceivedBS.setHorizontalAlignment(SwingConstants.CENTER);
									RequestReceivedBS.setForeground(Color.WHITE);
									RequestReceivedBS.setFont(new Font("Calibri", Font.BOLD, 16));
									RequestReceivedBS.setEditable(false);
									RequestReceivedBS.setColumns(10);
									RequestReceivedBS.setBorder(null);
									RequestReceivedBS.setBackground(new Color(0, 204, 204));
									RequestReceivedBS.setBounds(445, 319 + offset, 92, 22);
									BSFriendsMode.add(RequestReceivedBS);
							
									
									txtDeclineRequestBS = new JTextField();
									txtDeclineRequestBS.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent arg0) {
											client.AcceptDeclineGameRequest("BSRequests", friend);
											SendRequestResultBS.setText("You declined " + friend + "'s request."); // a enlever apres
										}
									});
									txtDeclineRequestBS.setText("Decline");
									txtDeclineRequestBS.setHorizontalAlignment(SwingConstants.CENTER);
									txtDeclineRequestBS.setForeground(Color.WHITE);
									txtDeclineRequestBS.setFont(new Font("Calibri", Font.BOLD, 16));
									txtDeclineRequestBS.setEditable(false);
									txtDeclineRequestBS.setColumns(10);
									txtDeclineRequestBS.setBorder(null);
									txtDeclineRequestBS.setBackground(Color.GRAY);
									txtDeclineRequestBS.setBounds(549, 319 + offset, 92, 22);
									BSFriendsMode.add(txtDeclineRequestBS);
									
									offset = offset + 100;
									
									if (offset > 300) {
										BSFriendsMode.setPreferredSize(new Dimension (500, 300 + offset));
										
										scrollBS.revalidate();
										scrollBS.repaint();
									}
								}
								
								}
								BSFriendsMode.revalidate();
								BSFriendsMode.repaint();
					        }
					    },
					    0,      // run first occurrence immediatetly
					    2000); // run every 5 seconds
					}
				});
				
				
				
				//////////////////////////////////////////////////////////////////////////////
				
				//_______________________________________________CHAT GLOBAL MODE BS__________________________________________________________________________
				
				TitleChatBS = new JTextField();
				TitleChatBS.setBounds(425, 437, 116, 22);
				BSGM.add(TitleChatBS);
				TitleChatBS.setVisible(false);
				TitleChatBS.setColumns(10);
				
				maxChatBS = new JTextField();
				maxChatBS.setBounds(425, 514, 116, 22);
				BSGM.add(maxChatBS);
				maxChatBS.setVisible(false);
				maxChatBS.setColumns(10);
				
				JLabel lblTitleBS = new JLabel("Choose a title:");
				lblTitleBS.setBounds(155, 440, 159, 16);
				BSGM.add(lblTitleBS);
				lblTitleBS.setVisible(false);
				
				JLabel lblMaxBS = new JLabel("Set the maximum number of participants:");
				lblMaxBS.setBounds(155, 517, 239, 16);
				BSGM.add(lblMaxBS);
				lblMaxBS.setVisible(false);
				
				txtYouAreTheBS = new JTextField();
				txtYouAreTheBS.setText("You are the admin of this chat!");
				txtYouAreTheBS.setBounds(217, 341, 284, 22);
				BSGM.add(txtYouAreTheBS);
				txtYouAreTheBS.setColumns(10);
				txtYouAreTheBS.setVisible(false);
				
				JLabel lblStartChatBS = new JLabel("Start Chat");
				lblStartChatBS.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//Je vais avoir ddeuc text field et on doit lire leur contenus;
						String countAdminBS=maxChatBS.getText();
						String titleBS=TitleChatBS.getText();
						client.StartChat(countAdminBS, titleBS, "Battle Ship", client.username);
					}
				});
				lblStartChatBS.setBounds(401, 596, 89, 16);
				BSGM.add(lblStartChatBS);
				lblStartChatBS.setVisible(false);
				
						JButton btnChatBS = new JButton("Chat");
						BSGM.add(btnChatBS);
						btnChatBS.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								int state= client.chat("Battle Ship", client.username);
								if(state==0) //He is the administrator  
								{
									TitleChatBS.setVisible(true);
									maxChatBS.setVisible(true);
									lblTitleBS.setVisible(true);
									lblMaxBS.setVisible(true);
									txtYouAreTheBS.setVisible(true);
									lblStartChatBS.setVisible(true);
								}
								else if (state==1) //Error
								{
									txtYouAreTheBS.setText("This chat is currently full. Try again later!");
									txtYouAreTheBS.setVisible(true);
								}
							}
						});
						btnChatBS.setBounds(90, 160, 121, 72);
						
						JLabel BSGMlbl = new JLabel("MONOPOLY GLOBAL MODE");
						BSGMlbl.setHorizontalAlignment(SwingConstants.CENTER);
						BSGMlbl.setForeground(new Color(32, 178, 170));
						BSGMlbl.setFont(new Font("Calibri", Font.PLAIN, 35));
						BSGMlbl.setBounds(201, 22, 420, 50);
						BSGM.add(BSGMlbl);
						
						JSeparator BSGMsep = new JSeparator();
						BSGMsep.setForeground(new Color(32, 178, 170));
						BSGMsep.setBackground(new Color(32, 178, 170));
						BSGMsep.setBounds(166, 70, 479, 2);
						BSGM.add(BSGMsep);
						
						JLabel btnScoreBSGM = new JLabel("Score");
						btnScoreBSGM.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								
							}
						});
						btnScoreBSGM.setHorizontalAlignment(SwingConstants.CENTER);
						btnScoreBSGM.setBounds(452, 171, 89, 33);
						BSGM.add(btnScoreBSGM);
						
				
		
		
		// ______________________________________________________NOTIFICATIONS PANEL ______________________________________________________
		
		
		
		txtYourMessages = new JTextField();
		txtYourMessages.setBackground(Color.WHITE);
		txtYourMessages.setEditable(false);
		txtYourMessages.setText("Your messages:");
		Notif.setLayer(txtYourMessages, 0);
		GroupLayout gl_Notif = new GroupLayout(Notif);
		gl_Notif.setHorizontalGroup(
			gl_Notif.createParallelGroup(Alignment.LEADING)
				.addGap(0, 668, Short.MAX_VALUE)
		);
		gl_Notif.setVerticalGroup(
			gl_Notif.createParallelGroup(Alignment.LEADING)
				.addGap(0, 583, Short.MAX_VALUE)
		);
		Notif.setLayout(gl_Notif);
		txtYourMessages.setBounds(12, 31, 217, 22);
		
		txtYourMessages.setColumns(10);
		
		
		textAction = new JTextField();
		textAction.setBackground(Color.WHITE);
		textAction.setEditable(false);
		textAction.setBounds(265, 31, 274, 22);
		textAction.setColumns(10);
		
		txtNotif = new JTextField();
		txtNotif.setHorizontalAlignment(SwingConstants.CENTER);
		txtNotif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				tN=new Timer();
				tN.scheduleAtFixedRate(
					    new TimerTask()
					    {
					        public void run()
					        {
					        	Notif.removeAll();
								Notif.add(txtYourMessages);
								Notif.add(textAction);
					        	othersLayout.show(others, "scroll");
								List<String> notifList = client.showNotifClient();
								if (notifList == null) { textAction.setText("You have 0 notifications"); }
								else if (notifList.get(0).equals("")) { textAction.setText("You have 0 notifications"); }
								else {
									int offset = 0;
									int num = notifList.size();
								for (int i = 0; i<num; i++) {
								String [] msg = notifList.get(i).split("#");
								if (msg[0].equals("friendRequest")){
									
									txtReject_1 = new JTextField();
									txtReject_1.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											textAction.setText("You rejected " + msg[1] + "'s request.");
											client.rejectRequestClient(msg[1]);		
											}
									});
									txtReject_1.setText("REJECT");
									txtReject_1.setEditable(false);
									txtReject_1.setHorizontalAlignment(SwingConstants.CENTER);
									txtReject_1.setForeground(Color.WHITE);
									txtReject_1.setFont(new Font("Calibri", Font.BOLD, 16));
									txtReject_1.setBackground(Color.GRAY);
									txtReject_1.setBorder(null);
									Notif.setLayer(txtReject_1, 1);
									txtReject_1.setBounds(400, 124 + offset, 116, 22);
									Notif.add(txtReject_1);
									txtReject_1.setColumns(10);
									
									txtAccept_1 = new JTextField();
									txtAccept_1.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent arg0) {
											client.acceptRequestClient(msg[1]);
											textAction.setText("You are now friends with " + msg[1] + "!");
										}
									});
									txtAccept_1.setBorder(null);
									txtAccept_1.setHorizontalAlignment(SwingConstants.CENTER);
									txtAccept_1.setText("ACCEPT");
									txtAccept_1.setEditable(false);
									txtAccept_1.setForeground(Color.WHITE);
									txtAccept_1.setFont(new Font("Calibri", Font.BOLD, 16));
									txtAccept_1.setBackground(new Color(0, 204, 204));
									Notif.setLayer(txtAccept_1, 1);
									txtAccept_1.setBounds(400, 92 + offset, 116, 22);
									Notif.add(txtAccept_1);
									txtAccept_1.setColumns(10);
									
									textField_1 = new JTextField();
									textField_1.setBounds(12, 80 + offset, 527, 77);
									textField_1.setText(msg[1] + " sent you a friend request!");
									Notif.add(textField_1);
									textField_1.setColumns(10);
									
									offset = offset + 100;
									
									if (offset > 500) {
										Notif.setPreferredSize(new Dimension(500, 100 + offset));
										Notif.revalidate();
									}
								}
								}
								} 
								Notif.revalidate();
								Notif.repaint();
					        }
					    },
					    0,      // run first occurrence immediatetly
					    2000); // run every two seconds
				
		
			} 
			@Override
			public void mouseEntered(MouseEvent e) {
				txtNotif.setBounds(12, 439, 220, 28);
				iconRouge.setBounds(175, 414, 25, 25);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtNotif.setBounds(12, 446, 220, 28);
				iconRouge.setBounds(175, 421, 25, 25);
			}
		});
		txtNotif.setEditable(false);
		txtNotif.setText("Notifications");
		txtNotif.setForeground(Color.WHITE);
		txtNotif.setFont(new Font("Calibri", Font.BOLD, 20));
		txtNotif.setColumns(10);
		txtNotif.setBorder(null);
		txtNotif.setBackground(Color.GRAY);
		txtNotif.setBounds(12, 446, 220, 28);
		SideBar.add(txtNotif);
		
		// ______________________________________________________FRIENDS PANEL ______________________________________________________

		// _____________________________________________________ADD FRIEND  ______________________________________________________
		
		friendNameField = new JTextField();
		friendNameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				friendNameField.setText("");
			}
		});
		friendNameField.setForeground(Color.GRAY);
		friendNameField.setFont(new Font("Calibri", Font.PLAIN, 18));
		friendNameField.setBackground(Color.WHITE);
		friendNameField.setBounds(260, 212, 300, 30);
		Friends.add(friendNameField);
		friendNameField.setColumns(10);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Calibri", Font.ITALIC, 18));
		textField.setEditable(false);
		textField.setBounds(225, 466, 360, 30);
		Friends.add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment(JTextField.CENTER);
		
		txtAddFriend = new JTextField();
		txtAddFriend.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = friendNameField.getText();
				String response = client.sendFriendRequestClient(name);
				
				if (response.equals("request sent")) {
					textField.setText("Your friend request has been sent to " + name + "!");
				}
				else if (response.equals("username doesn't exist")) {
					textField.setText("This username doesn't exist.");
				}
				else if (response.equals("already friends")) {
					textField.setText("You are already friends with " + name + ".");
				}
				else if (response.equals("duplicate request")) {
					textField.setText("Your request has already been sent to " + name +".");
				}
			}
		});
		
		txtAddFriend.setFont(new Font("Calibri", Font.BOLD, 18));
		txtAddFriend.setForeground(Color.WHITE);
		txtAddFriend.setBackground(new Color(0, 204, 204));
		txtAddFriend.setText("Send Friend Request");
		txtAddFriend.setEditable(false);
		txtAddFriend.setBounds(41, 327, 160, 65);
		Friends.add(txtAddFriend);
		txtAddFriend.setColumns(10);
		
		// _____________________________________________________REMOVE FRIEND ______________________________________________________
		
		txtRemoveFriend = new JTextField();
		txtRemoveFriend.setHorizontalAlignment(SwingConstants.CENTER);
		txtRemoveFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = friendNameField.getText();
				String response = client.removeFriend(name);
				
				if (response.equals("success")) {
					textField.setText("You are no longer friends with " + name + ".");
				}
				else if (response.equals("not friends")) {
					textField.setText("You are not friends with " + name + ".");
				}
				else if (response.equals("username doesn't exist")) {
					textField.setText("This username doesn't exist.");
				}
	
			}
		});
		txtRemoveFriend.setText("Remove Friend");
		txtRemoveFriend.setForeground(Color.WHITE);
		txtRemoveFriend.setFont(new Font("Calibri", Font.BOLD, 18));
		txtRemoveFriend.setEditable(false);
		txtRemoveFriend.setColumns(10);
		txtRemoveFriend.setBackground(Color.GRAY);
		txtRemoveFriend.setBounds(324, 327, 160, 65);
		Friends.add(txtRemoveFriend);
		
		// _____________________________________________________VIEW FRIENDS PROFILE ______________________________________________________
		// ACTION ON BUTTON CLICKED IN "FRIENDS PROFIL PANEL"
		
		txtViewFriendsProfile = new JTextField();
		txtViewFriendsProfile.setHorizontalAlignment(SwingConstants.CENTER);
		txtViewFriendsProfile.setText("View Friend's Profile");
		txtViewFriendsProfile.setForeground(Color.WHITE);
		txtViewFriendsProfile.setFont(new Font("Calibri", Font.BOLD, 18));
		txtViewFriendsProfile.setEditable(false);
		txtViewFriendsProfile.setColumns(10);
		txtViewFriendsProfile.setBackground(new Color(0, 204, 204));
		txtViewFriendsProfile.setBounds(609, 327, 160, 65);
		Friends.add(txtViewFriendsProfile);
		
		JLabel lblEnterUsernameHere = new JLabel("Enter Username Here:");
		lblEnterUsernameHere.setForeground(Color.GRAY);
		lblEnterUsernameHere.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEnterUsernameHere.setBounds(324, 156, 152, 43);
		Friends.add(lblEnterUsernameHere);
		
		
		//_____________________________________________________________PROFILE PANEL____________________________________________________
		
		JSeparator separatorProfile = new JSeparator();
		separatorProfile.setOrientation(SwingConstants.VERTICAL);
		separatorProfile.setForeground(Color.GRAY);
		separatorProfile.setBackground(Color.GRAY);
		separatorProfile.setBounds(411, 13, 2, 654);
		Profile.add(separatorProfile);
		
		JLabel ProfilePicture = new JLabel("");
		ProfilePicture.setBounds(138, 13, 170, 150);
		Profile.add(ProfilePicture);
		
		Status = new JTextField();
		Status.setBackground(Color.WHITE);
		Status.setEditable(false);
		Status.setHorizontalAlignment(SwingConstants.CENTER);
		Status.setBounds(12, 176, 387, 32);
		Profile.add(Status);
		Status.setColumns(10);
		
		JLabel lblUsernameP = new JLabel("Username");
		lblUsernameP.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsernameP.setBounds(12, 240, 120, 30);
		Profile.add(lblUsernameP);
		
		JLabel lblEmailP = new JLabel("Email");
		lblEmailP.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmailP.setBounds(12, 291, 120, 30);
		Profile.add(lblEmailP);
		
		JLabel lblGenderP = new JLabel("Gender");
		lblGenderP.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblGenderP.setBounds(12, 350, 120, 30);
		Profile.add(lblGenderP);
		
		JLabel lblCountryP = new JLabel("Country");
		lblCountryP.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCountryP.setBounds(12, 410, 120, 30);
		Profile.add(lblCountryP);
		
		JLabel lblAgeP = new JLabel("Age");
		lblAgeP.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAgeP.setBounds(12, 478, 120, 30);
		Profile.add(lblAgeP);
		
		JLabel lblNumberOfFriendsP = new JLabel("Number of friends");
		lblNumberOfFriendsP.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNumberOfFriendsP.setBounds(12, 540, 120, 30);
		Profile.add(lblNumberOfFriendsP);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Calibri", Font.BOLD, 19));
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setBounds(591, 13, 72, 27);
		Profile.add(lblSettings);
		
		JLabel lblChangePass = new JLabel("Edit Password");
		lblChangePass.setFont(new Font("Calibri", Font.BOLD, 16));
		lblChangePass.setBounds(441, 45, 166, 22);
		Profile.add(lblChangePass);
		
		ChangePassArea = new JTextField();
		ChangePassArea.setBounds(441, 80, 222, 32);
		Profile.add(ChangePassArea);
		ChangePassArea.setColumns(10);
		
		btnApply = new JTextField();
		btnApply.setBackground(Color.LIGHT_GRAY);
		btnApply.setFont(new Font("Calibri", Font.BOLD, 16));
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ChangePassArea.getText().equals(""))
				client.ChangePassClient(ChangePassArea.getText());
			}
		});
		btnApply.setEditable(false);
		btnApply.setHorizontalAlignment(SwingConstants.CENTER);
		btnApply.setText("Apply");
		btnApply.setBounds(740, 80, 72, 22);
		Profile.add(btnApply);
		btnApply.setColumns(10);
		
		JLabel lblAddeditProfilePicture = new JLabel("Add/Edit Profile Picture");
		lblAddeditProfilePicture.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAddeditProfilePicture.setBounds(447, 230, 212, 32);
		Profile.add(lblAddeditProfilePicture);
		
		btnImport = new JTextField();
		btnImport.setBackground(Color.LIGHT_GRAY);
		btnImport.setFont(new Font("Calibri", Font.BOLD, 16));
		btnImport.setEditable(false);
		btnImport.setHorizontalAlignment(SwingConstants.CENTER);
		btnImport.setText("Import");
		btnImport.setBounds(740, 234, 72, 22);
		Profile.add(btnImport);
		btnImport.setColumns(10);
		
		JLabel lblSetFriendsViewer = new JLabel("Set/Modify Friend Viewer Permissions");
		lblSetFriendsViewer.setFont(new Font("Calibri", Font.BOLD, 19));
		lblSetFriendsViewer.setBounds(474, 275, 309, 32);
		Profile.add(lblSetFriendsViewer);
		
		JLabel lblNewLabel = new JLabel("Allow friends to view your:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(447, 320, 344, 27);
		Profile.add(lblNewLabel);
		
		JCheckBox EmailBox = new JCheckBox("Email");
		EmailBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		EmailBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (EmailBox.isSelected()) client.MailViewClient(true);
				else client.MailViewClient(false);
			}
		});
		EmailBox.setBackground(Color.WHITE);
		EmailBox.setBounds(514, 364, 163, 25);
		Profile.add(EmailBox);
		
		JCheckBox GenderBox = new JCheckBox("Gender");
		GenderBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		GenderBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (GenderBox.isSelected()) client.GenderViewClient(true);
				else client.GenderViewClient(false);
			}
		});
		GenderBox.setBackground(Color.WHITE);
		GenderBox.setBounds(514, 413, 163, 25);
		Profile.add(GenderBox);
		
		JCheckBox CountryBox = new JCheckBox("Country");
		CountryBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		CountryBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (CountryBox.isSelected()) client.CountryViewClient(true);
				else client.CountryViewClient(false);
			}
		});
		CountryBox.setBackground(Color.WHITE);
		CountryBox.setBounds(514, 461, 163, 25);
		Profile.add(CountryBox);
		
		JCheckBox AgeBox = new JCheckBox("Age");
		AgeBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		AgeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (AgeBox.isSelected()) client.AgeViewClient(true);
				else client.AgeViewClient(false);
			}
		});
		AgeBox.setBackground(Color.WHITE);
		AgeBox.setBounds(514, 518, 163, 25);
		Profile.add(AgeBox);
		
		JCheckBox NumFriendsBox = new JCheckBox("Number of friends");
		NumFriendsBox.setFont(new Font("Calibri", Font.PLAIN, 16));
		NumFriendsBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (NumFriendsBox.isSelected()) client.FriendsViewClient(true);
				else client.FriendsViewClient(false);
			}
		});
		NumFriendsBox.setBackground(Color.WHITE);
		NumFriendsBox.setBounds(514, 570, 163, 25);
		Profile.add(NumFriendsBox);
		
		friendsFieldP = new JTextField();
		friendsFieldP.setBackground(Color.WHITE);
		friendsFieldP.setFont(new Font("Calibri", Font.PLAIN, 16));
		friendsFieldP.setEditable(false);
		friendsFieldP.setBounds(165, 539, 234, 30);
		Profile.add(friendsFieldP);
		friendsFieldP.setColumns(10);
		
		ageFieldP = new JTextField();
		ageFieldP.setBackground(Color.WHITE);
		ageFieldP.setFont(new Font("Calibri", Font.PLAIN, 16));
		ageFieldP.setEditable(false);
		ageFieldP.setBounds(165, 477, 234, 30);
		Profile.add(ageFieldP);
		ageFieldP.setColumns(10);
		
		countryFieldP = new JTextField();
		countryFieldP.setBackground(Color.WHITE);
		countryFieldP.setFont(new Font("Calibri", Font.PLAIN, 16));
		countryFieldP.setEditable(false);
		countryFieldP.setBounds(165, 409, 234, 30);
		Profile.add(countryFieldP);
		countryFieldP.setColumns(10);
		
		genderFieldP = new JTextField();
		genderFieldP.setBackground(Color.WHITE);
		genderFieldP.setFont(new Font("Calibri", Font.PLAIN, 16));
		genderFieldP.setEditable(false);
		genderFieldP.setBounds(165, 349, 234, 30);
		Profile.add(genderFieldP);
		genderFieldP.setColumns(10);
		
		mailFieldP = new JTextField();
		mailFieldP.setBackground(Color.WHITE);
		mailFieldP.setFont(new Font("Calibri", Font.PLAIN, 16));
		mailFieldP.setEditable(false);
		mailFieldP.setBounds(165, 290, 234, 30);
		Profile.add(mailFieldP);
		mailFieldP.setColumns(10);
		
		userFieldP = new JTextField();
		userFieldP.setBackground(Color.WHITE);
		userFieldP.setFont(new Font("Calibri", Font.PLAIN, 16));
		userFieldP.setEditable(false);
		userFieldP.setBounds(165, 239, 234, 30);
		Profile.add(userFieldP);
		userFieldP.setColumns(10);
		
		JLabel lblAddeditStatus = new JLabel("Add/Edit Status");
		lblAddeditStatus.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAddeditStatus.setBounds(447, 141, 166, 22);
		Profile.add(lblAddeditStatus);
		
		btnApplyStatus = new JTextField();
		btnApplyStatus.setBackground(Color.LIGHT_GRAY);
		btnApplyStatus.setFont(new Font("Calibri", Font.BOLD, 16));
		btnApplyStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!StatusField.getText().equals(""))
				client.SetStatusClient(StatusField.getText());
			}
		});
		btnApplyStatus.setEditable(false);
		btnApplyStatus.setText("Apply");
		btnApplyStatus.setHorizontalAlignment(SwingConstants.CENTER);
		btnApplyStatus.setColumns(10);
		btnApplyStatus.setBounds(740, 141, 72, 22);
		Profile.add(btnApplyStatus);
		
		StatusField = new JTextField();
		StatusField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatusField.setText("");
			}
		});
		StatusField.setText("Write something about youself...");
		StatusField.setHorizontalAlignment(SwingConstants.CENTER);
		StatusField.setColumns(10);
		StatusField.setBounds(425, 181, 387, 32);
		Profile.add(StatusField);
		
		
		
		txtViewYourProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tI.equals(0)) tI.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				if (!tN.equals(0)) tN.cancel();
				
				othersLayout.show(others, "Profile");
				String [] info = new String[7];
				info = client.fillProfileClient();
				if (info[0].equals("0")) Status.setText("");
				else Status.setText(info[0]);
				userFieldP.setText(info[1]);
				mailFieldP.setText(info[2]);
				genderFieldP.setText(info[3]);
				countryFieldP.setText(info[4]);
				ageFieldP.setText(info[5]);
				friendsFieldP.setText(info[6]);
				StatusField.setText("Write something about yourself...");
				String [] settings = new String[5];
				settings = client.FillSettingsClient();
				if (settings[0].equals("true")) EmailBox.setSelected(true);
				else EmailBox.setSelected(false);
				if (settings[1].equals("true")) GenderBox.setSelected(true);
				else GenderBox.setSelected(false);
				if (settings[2].equals("true")) CountryBox.setSelected(true);
				else CountryBox.setSelected(false);
				if (settings[3].equals("true")) AgeBox.setSelected(true);
				else AgeBox.setSelected(false);
				if (settings[4].equals("true")) NumFriendsBox.setSelected(true);
				else NumFriendsBox.setSelected(false);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				txtViewYourProfile.setBounds(12, 217, 220, 28);			
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
				txtViewYourProfile.setBounds(12, 224, 220, 28);
			}
		});
		
		
		//___________________________________________________INBOX PANEL__________________________________________________________________
		
		
		FriendNameInbox = new JTextField();
		FriendNameInbox.setFont(new Font("Calibri", Font.PLAIN, 17));
		FriendNameInbox.setColumns(10);
		FriendNameInbox.setBorder(new LineBorder(new Color(171, 173, 179)));
		FriendNameInbox.setBounds(88, 97, 116, 22);
		
		
		JLabel labelToInbox = new JLabel("To:");
		labelToInbox.setFont(new Font("Calibri", Font.BOLD, 18));
		labelToInbox.setBounds(36, 101, 27, 16);
		
		
		JLabel YoursMessagesInbox = new JLabel("Your messages:");
		YoursMessagesInbox.setFont(new Font("Calibri", Font.PLAIN, 15));
		YoursMessagesInbox.setBounds(88, 242, 218, 22);
		
		
		ResultInbox = new JTextField();
		ResultInbox.setEditable(false);
		ResultInbox.setColumns(10);
		ResultInbox.setBackground(Color.WHITE);
		ResultInbox.setBounds(247, 241, 312, 22);
		
		
		ResultSendInbox = new JTextField();
		ResultSendInbox.setFont(new Font("Calibri", Font.ITALIC, 16));
		ResultSendInbox.setEditable(false);
		ResultSendInbox.setColumns(10);
		ResultSendInbox.setBorder(null);
		ResultSendInbox.setBackground(Color.WHITE);
		ResultSendInbox.setBounds(247, 98, 279, 22);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(53, 139, 531, 90);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
			}
		});
		
		
		JButton btnSendInbox = new JButton("Send");
		btnSendInbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String friend = FriendNameInbox.getText();
				String msg = textArea.getText();
				String response = client.sendInstMsgClient(friend, msg);
				if (response.equals("message sent")) {
					ResultSendInbox.setText("Your message has been sent to " + friend + "!");
				}
				else if (response.equals("not friends")) {
					ResultSendInbox.setText("You are not friends with " + friend + ".");
				}
				else if (response.equals("username doesn't exist")) {
					ResultSendInbox.setText("This username doesn't exist.");
				}
			}
		});
		btnSendInbox.setBounds(540, 64, 97, 25);
		
		
		
		///////////////////////////////////////////////////////////

			
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		txtInbox = new JTextField();
		txtInbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!tFMbs.equals(0)) tFMbs.cancel();
				if (!tFMttt.equals(0)) tFMttt.cancel();
				if (!tN.equals(0)) tN.cancel();
				Inbox.add(ResultInbox);
				Inbox.add(ResultSendInbox);
				Inbox.add(FriendNameInbox);
				textArea.setBorder(new LineBorder(new Color(171, 173, 179)));
				Inbox.add(textArea);
				ResultInbox.setText("");
				ResultSendInbox.setText("");
				tI = new Timer();
				tI.scheduleAtFixedRate(
				    new TimerTask()
				    {
				        public void run()
				        {	
				        	List<Component> compList = new ArrayList<Component>(Arrays.asList(Inbox.getComponents()));
				        	compList.remove(FriendNameInbox);
				        	compList.remove(textArea);
				        	compList.remove(ResultInbox);
				        	compList.remove(ResultSendInbox);
				        	for (Component c: compList){
				        		Inbox.remove(c);
				        	}
							Inbox.add(labelToInbox);
							Inbox.add(YoursMessagesInbox);
							Inbox.add(btnSendInbox);
				        	
						//	ResultSendInbox.setText("");
						//	ResultInbox.setText("");
							othersLayout.show(others, "InboxScroll");
					//		othersLayout.show(others, "Inbox");
							
							List<String> msgList = client.showInstMsgClient();
						
							if (msgList == null) { ResultInbox.setText("You have 0 messages"); }
							else {
								int offset = 0;
								int num = msgList.size();
								if (num == 1 ) {ResultInbox.setText("You have 1 message"); } 
								else { ResultInbox.setText("You have " + num + " messages"); }
								for (int i = 0; i<num; i++) {
							String [] msg = msgList.get(i).split("@");
							
							
								JTextArea MsgInboxArea = new JTextArea();
								MsgInboxArea.setText("<" + msg[0] + ">" + "\n" + msg[1]);
								MsgInboxArea.setEditable(false);
								MsgInboxArea.setBorder(new LineBorder(new Color(0, 0, 0)));
								MsgInboxArea.setBounds(57, 316 + offset, 407, 76);
								Inbox.add(MsgInboxArea);
								
								btnReplyInbox = new JTextField();
								btnReplyInbox.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										client.deleteMsgClient(msg[0], msg[1]);
										FriendNameInbox.setText(msg[0]);
										textArea.setText("Type your reply message here.");
									}
								});
								btnReplyInbox.setText("Reply");
								btnReplyInbox.setHorizontalAlignment(SwingConstants.CENTER);
								btnReplyInbox.setForeground(Color.WHITE);
								btnReplyInbox.setFont(new Font("Calibri", Font.BOLD, 16));
								btnReplyInbox.setEditable(false);
								btnReplyInbox.setColumns(10);
								btnReplyInbox.setBorder(null);
								btnReplyInbox.setBackground(new Color(0, 204, 204));
								btnReplyInbox.setBounds(476, 323 + offset, 92, 22);
								Inbox.add(btnReplyInbox);
								
								btnDeleteInbox = new JTextField();
								btnDeleteInbox.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										client.deleteMsgClient(msg[0], msg[1]);
										ResultSendInbox.setText("You deleted " + msg[0] + "'s message.");
									}
								});
								btnDeleteInbox.setText("Delete");
								btnDeleteInbox.setHorizontalAlignment(SwingConstants.CENTER);
								btnDeleteInbox.setForeground(Color.WHITE);
								btnDeleteInbox.setFont(new Font("Calibri", Font.BOLD, 16));
								btnDeleteInbox.setEditable(false);
								btnDeleteInbox.setColumns(10);
								btnDeleteInbox.setBorder(null);
								btnDeleteInbox.setBackground(Color.GRAY);
								btnDeleteInbox.setBounds(476, 358 + offset, 92, 22);
								Inbox.add(btnDeleteInbox);
								
								offset = offset + 100;
								}
								
							}
							Inbox.revalidate();
							Inbox.repaint();
				        }
				    },
				    0,      // run first occurrence immediatetly
				    2000); // run every two seconds
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtInbox.setBounds(12, 513, 220, 28);
				iconRouge2.setBounds(154, 488, 25, 25);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtInbox.setBounds(12, 520, 220, 28);
				iconRouge2.setBounds(154, 496, 25, 25);
			}
		});
		txtInbox.setText("Inbox");
		txtInbox.setHorizontalAlignment(SwingConstants.CENTER);
		txtInbox.setForeground(Color.WHITE);
		txtInbox.setFont(new Font("Calibri", Font.BOLD, 20));
		txtInbox.setEditable(false);
		txtInbox.setColumns(10);
		txtInbox.setBorder(null);
		txtInbox.setBackground(Color.GRAY);
		txtInbox.setBounds(88, 521, 70, 28);
		SideBar.add(txtInbox);
		
		JSeparator SBsep = new JSeparator();
		SBsep.setBounds(12, 548, 220, 2);
		SideBar.add(SBsep);
	
		
	
		
		
	
		//_____________________________________________________________FRIENDS PROFILE PANEL____________________________________________________
		
		JLabel FriendsProfilePicture = new JLabel("");
		FriendsProfilePicture.setBounds(40, 28, 203, 150);
		
		FriendName = new JTextField();
		FriendName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FriendName.setBounds(275, 99, 287, 42);
		FriendName.setColumns(10);
		
		FriendStatus = new JTextField();
		FriendStatus.setFont(new Font("Tahoma", Font.ITALIC, 16));
		FriendStatus.setHorizontalAlignment(SwingConstants.CENTER);
		FriendStatus.setBounds(40, 191, 522, 32);
		FriendStatus.setColumns(10);
		
		txtViewFriendsProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String friend = friendNameField.getText();
				List<String> response = client.ViewFriendProfileClient(friend);
				if (response.get(0).equals("not friends")) textField.setText("You are not friends with " + friend + ".");
				else if (response.get(0).equals("username doesn't exist")) textField.setText("This username doesn't exist.");
				else {
					FriendsProfile.removeAll();
					FriendsProfile.add(FriendsProfilePicture);
					FriendsProfile.add(FriendName);
					FriendsProfile.add(FriendStatus);
					othersLayout.show(others, "FriendProfile");
					int offset = 0;
					for (int i = 0; i < response.size(); i++) {
						String [] toShow = new String[2];
						toShow = response.get(i).split("#");
						if (toShow[0].equals("")) break;
						else {
							FriendView = new JTextField();
							FriendView.setFont(new Font("Tahoma", Font.PLAIN, 16));
							FriendView.setHorizontalAlignment(SwingConstants.CENTER);
							FriendView.setBounds(72, 247 + offset, 159, 32);
							FriendsProfile.add(FriendView);
							FriendView.setColumns(10);
							
							FriendValueView = new JTextField();
							FriendValueView.setHorizontalAlignment(SwingConstants.CENTER);
							FriendValueView.setColumns(10);
							FriendValueView.setBounds(290, 248 + offset, 253, 32);
							FriendsProfile.add(FriendValueView);
							
							if (toShow[0].equals("MailView")) {
								FriendView.setText("Email:");
								FriendValueView.setText(toShow[1]);
							}
							else if (toShow[0].equals("GenderView")) {
								FriendView.setText("Gender:");
								FriendValueView.setText(toShow[1]);
							}
							else if (toShow[0].equals("CountryView")) {
								FriendView.setText("Country:");
								FriendValueView.setText(toShow[1]);
							}
							else if (toShow[0].equals("AgeView")) {
								FriendView.setText("Age:");
								FriendValueView.setText(toShow[1]);
							}
							else if (toShow[0].equals("FriendsView")) {
								FriendView.setText("Number of friends:");
								FriendValueView.setText(toShow[1]);
							}
						}
						offset = offset + 45;
					}
					FriendName.setText(friend + "'s Profile");
					String friendStatus = client.getFriendStatusClient(friend);
					if (friendStatus.equals("0")) FriendStatus.setText("");
					else FriendStatus.setText(friendStatus);
					FriendsProfile.revalidate();
					FriendsProfile.repaint();
				}
			}
		});
		
	}
}
