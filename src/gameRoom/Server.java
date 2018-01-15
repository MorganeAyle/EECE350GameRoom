package gameRoom;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.*;

public class Server {
	
    private List<String> onlineUsers = new ArrayList<String> ();
    private List<String> busyUsers= new ArrayList<String> ();
    private List<String> chatUsersPlay= new ArrayList<String> ();
    private int port=2008;
    private ServerSocket serverSocket;
    private int portempTTT=2009;
    private int portempBS=2010;
    
    public Server() throws ClassNotFoundException {}
    
    private int countChatTTT=0;
    private int countAdminTTT=0;
    
    private String TitleTTT="";
    private String TitleBS="";
    
    public void acceptConnections() {
    	
        try
        {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e)
        {
            System.err.println("ServerSocket instantiation failure");
            e.printStackTrace();
            System.exit(0);
        }

        while (true) {
            try
            {
                Socket newConnection = serverSocket.accept();
                System.out.println("accepted connection");
				//now each client gets a threads that deals with its connection and requests //
                ServerThread st = new ServerThread(newConnection);
                new Thread(st).start();
				//now the server will continue waiting for other requests and the current user will be serviced
				// by the created thread //
            } 
            catch (IOException ioe)
            {
                System.err.println("server accept failed");
            }
        }
    }
    public static void main(String args[]) {

        Server server = null;
        try {
            server = new Server();
            
        } catch (ClassNotFoundException e) {
            //   System.out.println("unable to load JDBC driver");
            e.printStackTrace();
            System.exit(1);
        }

        server.acceptConnections();
    }

    class ServerThread implements Runnable {
    	private DataOutputStream DataOut = null;
        private BufferedReader input = null;
    	private Connection connection = null;
        private Statement statement = null;
        private Socket socket;
        

        public ServerThread(Socket socket) {
            this.socket = socket;
        }
        public boolean connectMySQL() {
            try {
                Class.forName("com.mysql.jdbc.Driver"); //set driver for mysql j connector
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameroom?autoReconnect=true&useSSL=false", "root", "our350projectrocks!");
                statement = connection.createStatement();
              //  JOptionPane.showMessageDialog(null, "Connection successful");
                return true;
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.toString());
                return false;
            }
        }
        public void run()
        {
        	
        	try {
                DataOut = new DataOutputStream(socket.getOutputStream());
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            } catch (IOException e) {
                e.printStackTrace();}
        	 connectMySQL();
        	boolean running = true;
        	while (running) {
                try {
                    String request = input.readLine();
                    System.out.println(request);
                    switch (request) {
                        case "check connection": 
                            DataOut.writeBytes("welcome\n");
                            break;
                        case "signup":
                            SignUp();
                            break;
                        case "login":
                            Login();
                            break;
                        case "send friend request":
                        	SendFriendRequest();
                        	break;
                        case "remove friend":
                        	RemoveFriend();
                        	break;
                        case "show notif":
                        	ShowNotif();
                        	break;
                        case "accept request":
                        	AcceptRequest();
                        	break;
                        case "reject request":
                        	RejectRequest();
                        	break;
                        case "send inst msg":
                        	SendInstMsg();
                        	break;
                        case "show inst msgs":
                        	ShowInstMsgs();
                        	break;
                        case "delete msg":
                        	DeleteMsg();
                        	break;
                        case "log out":
                        	CloseSocket();
                        	break;
                        case "play snake":
                        	playSnake();
                        	break;
                        case "fill profile":
                        	FillProfile();
                        	break;
                        case "change pass":
                        	ChangePass();
                        	break;
                        case "set status":
                        	SetStatus();
                        	break;
                        case "mail view":
                        	SetMailView();
                        	break;
                        case "gender view":
                        	SetGenderView();
                        	break;
                        case "country view":
                        	SetCountryView();
                        	break;
                        case "age view":
                        	SetAgeView();
                        	break;
                        case "friends view":
                        	SetFriendsView();
                        	break;
                        case "fill settings":
                        	FillSettings();
                        	break;
                        case "view friend profile":
                        	ViewFriendProfile();
                        	break;
                        case "get friend status":
                        	GetFriendStatus();
                        	break;
                        case "get requests":
                        	GetRequests();
                        	break;
                        case "send game request":
                        	SendGameRequest();
                        	break;
                        case "accept game request":
                        	AcceptDeclineGameRequest();
                        	break;
                        case "num friends":
                        	GetNumFriends();
                        	break;
                        case "check online":
                        	CheckOnline();
                        	break;
                        case "check available":
                        	CheckAvailable();
                        	break;
                        case "play":
                        	Play();
                        	break;
                        case "forgot pass":
                        	ForgotPass();
                        	break;
                        case"chat":
                        	Chat();
                        	break;
                        case "startChat":
                        	startChat();
                        	break;
                        case "dec count":
                        	DecCount();
                        	break;
                        case "play pac":
                        	PlayPac();
                        	break;
                      
                    }
                } 
                catch (IOException k)
                {
                    System.out.println(k);
                }
                catch (Exception e) {
                    System.out.println("Exception caught: " + e.toString());
                    running = true;
                    try {
                        DataOut.writeBytes("Failed: 0\n"); // Failed with code 0 means connection error and reconnection must be established
                    } catch (IOException e1) {
                        System.out.println("Exception caught: " + e1.toString());
                    }
                }
                
                }
        	
        	try
            {
                System.out.println("closing socket");
               statement.close();
               connection.close();
               DataOut.close();
               
            } 
            catch (IOException | SQLException e)
            {
            }
        }
        
        private void SignUp() throws Exception {
        	String[] fromclient = input.readLine().split("//");
    //    	JOptionPane.showMessageDialog(null, fromclient);
			ResultSet rs_sign = statement.executeQuery("select * from users where Username ='" + fromclient[0] + "' or Mail = '" + fromclient[2] + "'");
			if (rs_sign.next() == true) //entry in table with this username already exists
			{ DataOut.writeBytes("failure\n"); }
			else {
				if (onlineUsers.size() < 100) {
		//			JOptionPane.showMessageDialog(null, "ds server");
			String sql1 = "insert into users (Username, Password, Mail, Gender, Country, Age, Messages, InstantMessages, Status, Friends, MailView, "
					+ "GenderView, CountryView, AgeView, FriendsView, TTTRequests, BSRequests) "
					+ "values ('" + fromclient[0] + "', '" + fromclient[1] + "', '" + fromclient[2] +"', '" + fromclient[3] + "','" + fromclient[4] +
					"', '" + fromclient[5] + "', '', '', '0', '0', 'true', 'true', 'true', 'true', 'true', '', '')";
			statement.executeUpdate(sql1);
			onlineUsers.add(fromclient[0]);
	//		JOptionPane.showMessageDialog(null, ("Signing up"));
			DataOut.writeBytes("success\n");
				} else {
					DataOut.writeBytes("cannot login now\n");
				}
			}
        }
        
        private void Login() throws Exception {
			String[] inFromUser = input.readLine().split("//");
		
		ResultSet rs_log = statement.executeQuery("select * from users where Username='" + inFromUser[0] + "'");
		if (rs_log.next()) { 
		if (rs_log.getString("Password").equals(inFromUser[1])) { 
			if (onlineUsers.size() < 10) {
			onlineUsers.add(inFromUser[0]);
		//	JOptionPane.showMessageDialog(null, "Logging in");
			onlineUsers.add(inFromUser[0]);
			DataOut.writeBytes("success\n"); 
			} else {
				DataOut.writeBytes("cannot login now\n");
			}
			}
		else { System.out.println("Password incorrect"); DataOut.writeBytes("failure\n");}
		} 
		else { System.out.println("Username incorrect"); DataOut.writeBytes("failure\n");}
        }
        
        private boolean AreFriends(String Friend1, String Friend2) throws SQLException {
        	boolean friends = false;
        	ResultSet rs1 =  statement.executeQuery("select * from friends where Friend1 = '" + Friend1 + "' and Friend2 = '" + Friend2 + "'");
        	boolean A=rs1.next();
        	ResultSet rs2 =  statement.executeQuery("select * from friends where Friend2 = '" + Friend1 + "' and Friend1 = '" + Friend2 + "'");
        	boolean B= rs2.next();
        
        	if (A == false && B == false) {
        		//statement.executeUpdate("insert into friends (Friend1, Friend2) values ('" + toAdd[0] + "', '" + toAdd[1] + "')");
        		friends = false;
        	} else friends = true;
        	return friends;
        }
        
        private void SendFriendRequest() throws Exception {
        	String input1=input.readLine();
        	String[] toAdd = input1.split("//");
        
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + toAdd[1] + "'");
        	boolean bool = rs.next();
        	
        	if (bool) {
        		ResultSet rs2 = statement.executeQuery("select * from users where Username = '" + toAdd[1] + "'");
        		rs2.next();
        		String req = rs2.getString("Messages");
        		boolean friends = AreFriends(toAdd[0], toAdd[1]);
        		if (!friends) {
        			if (req.equals("")) {
        				statement.executeUpdate("update users set Messages = 'friendRequest#" + toAdd[0] + "' where Username = '" + toAdd[1] + "'");
        			}
        			else {
        				List <String> msgs = new ArrayList<String>(Arrays.asList(req.split("//")));
        				if (!msgs.contains("friendRequest#" + toAdd[0])) {
        				msgs.add("friendRequest#" + toAdd[0]);
        				String toStore = "";
        				for (int i = 0; i < msgs.size(); i++) {
        					if (i == 0) {toStore = msgs.get(0);}
        					else {toStore =  toStore + "//" + msgs.get(i); }
        				}
        				statement.executeUpdate("update users set Messages = '" + toStore + "' where Username = '" + toAdd[1] + "'");
        				} else {
        					DataOut.writeBytes("duplicate request\n");
        				}
        			}
        		DataOut.writeBytes("request sent\n");
        		}
        		else{
        		DataOut.writeBytes("already friends\n");
        		}
        	}
        	else {
        		DataOut.writeBytes("username doesn't exist\n");
        	}
        }
        
        private void RemoveFriend() throws Exception {
        	String []toRemove = input.readLine().split("//");
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + toRemove[1] + "'");
        	
        	if (rs.next()) {
        	boolean friends = AreFriends(toRemove[0], toRemove[1]);
        	if (friends) {
        		statement.executeUpdate("delete from friends where Friend1 = '" + toRemove[0] + "' and Friend2= '" + toRemove[1] + "'"); 
        		statement.executeUpdate("delete from friends where Friend1= '" + toRemove[1] + "' and Friend2 = '" + toRemove[0] + "'"); 
        		ResultSet rs2 = statement.executeQuery("select * from users where username = '" + toRemove[0] + "'");
            	rs2.next();
            	int num1 = rs2.getInt("Friends");
            	num1--;
            	statement.executeUpdate("update users set Friends = '" + num1 + "' where Username = '" + toRemove[0] + "'");
            	ResultSet rs3 = statement.executeQuery("select * from users where username = '" + toRemove[1] + "'");
            	rs3.next();
            	int num2 = rs3.getInt("Friends");
            	num2--;
            	statement.executeUpdate("update users set Friends = '" + num2 + "' where Username = '" + toRemove[1] + "'");
        		DataOut.writeBytes("success\n");
        	}
        	else {
        		DataOut.writeBytes("not friends\n");
        	}
        	}
        	else {
        		DataOut.writeBytes("username doesn't exist\n");
        	}
        }
        
        private void ShowNotif() throws Exception {
        	String user = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	String msgs = rs.getString("Messages");
        	if (msgs.equals("")) {
				DataOut.writeBytes("no notif\n");
			}
        	else {
        	
        		DataOut.writeBytes(msgs + "\n");
        	}
        }
        
        private void AcceptRequest() throws Exception {
        	String user = input.readLine();
        	System.out.println(user);
        	String friend = input.readLine();
        	System.out.println(friend);
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	List <String> msgs = new ArrayList<String>(Arrays.asList(rs.getString("Messages").split("//")));
        	boolean remove = msgs.remove("friendRequest#" + friend);
        	System.out.println(remove);
        	String toStore = "";
			for (int i = 0; i < msgs.size(); i++) {
				if (i == 0) toStore = msgs.get(0);
				else toStore = toStore + "//" + msgs.get(i);
			}
        	System.out.println(msgs);
        	statement.executeUpdate("update users set Messages = '" + toStore + "' where Username = '" + user + "'");
        	statement.executeUpdate("insert into friends (Friend1, Friend2) values ('" + user + "', '" + friend + "')");
        	ResultSet rs2 = statement.executeQuery("select * from users where username = '" + user + "'");
        	rs2.next();
        	int num1 = rs2.getInt("Friends");
        	num1++;
        	statement.executeUpdate("update users set Friends = '" + num1 + "' where Username = '" + user + "'");
        	ResultSet rs3 = statement.executeQuery("select * from users where username = '" + friend + "'");
        	rs3.next();
        	int num2 = rs3.getInt("Friends");
        	num2++;
        	statement.executeUpdate("update users set Friends = '" + num2 + "' where Username = '" + friend + "'");
        }
        
        private void RejectRequest() throws Exception {
        	String user = input.readLine();
        	System.out.println(user);
        	String friend = input.readLine();
        	System.out.println(friend);
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	List <String> msgs = new ArrayList<String>(Arrays.asList(rs.getString("Messages").split("//")));
        	boolean remove = msgs.remove("friendRequest#" + friend);
        	System.out.println(remove);
        	String toStore = "";
			for (int i = 0; i < msgs.size(); i++) {
				if (i == 0) toStore = msgs.get(0);
				else toStore = toStore + "//" + msgs.get(i);
			}
        	System.out.println(msgs);
        	statement.executeUpdate("update users set Messages = '" + toStore + "' where Username = '" + user + "'");
        }
        
        private void SendInstMsg() throws Exception {
        	String user = input.readLine();
        	System.out.println(user);
        	String friend = input.readLine();
        	System.out.println(friend);
        	String message = input.readLine();
        	System.out.println(message);
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + friend + "'");
        	boolean bool = rs.next();
        //	List <String> msgs = new ArrayList<String>(Arrays.asList(rs.getString("InstantMessages").split("//")));
        	
    
        	if (bool) {
        		ResultSet rs2 = statement.executeQuery("select * from users where Username = '" + friend + "'");
        		rs2.next();
        		String msgs = rs2.getString("InstantMessages");
        		boolean friends = AreFriends(user, friend);
        		if (friends) {
        			if (msgs.equals("")) { 
        				statement.executeUpdate("update users set InstantMessages = '" + user + "@" + message + "' where Username = '" + friend + "'"); }
        			else {
        			String toStore = msgs + "//" + user + "@" + message;
        				statement.executeUpdate("update users set InstantMessages = '" + toStore + "' where Username = '" + friend + "'");
        			}
        		DataOut.writeBytes("message sent\n");
        			
        		}
        		else{
        		DataOut.writeBytes("not friends\n");
        		}
        	}
        	else {
        		DataOut.writeBytes("username doesn't exist\n");
        	}
        }
        
        private void ShowInstMsgs() throws Exception {
        	String user = input.readLine();
       
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	String msgs = rs.getString("InstantMessages");
        	if (msgs.equals("")) {
				DataOut.writeBytes("no inst msgs\n");
			}
        	else {
        		
        		DataOut.writeBytes(msgs + "\n");
        	}
        }
        
        private void DeleteMsg() throws Exception {
        	String user = input.readLine();
        	String friend = input.readLine();
        	String message = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	List <String> msgs = new ArrayList<String>(Arrays.asList(rs.getString("InstantMessages").split("//")));
        	boolean remove = msgs.remove(friend + "@" + message);
        	System.out.println(remove);
        	String toStore = "";
			for (int i = 0; i < msgs.size(); i++) {
				if (i == 0 ) { toStore = msgs.get(0); }
				else toStore = toStore +  "//" + msgs.get(i);
			}
        	System.out.println(msgs);
        	statement.executeUpdate("update users set InstantMessages = '" + toStore + "' where Username = '" + user + "'");
        }
        
        private void CloseSocket() {
        	 //_________________________________________________________________________________
            // onlineUsers.remove("");
        	
        }
        
        private void playSnake() throws Exception{
        	 //Define the window where the game is going to run
        	String user = input.readLine();
        	busyUsers.add(user);
       		JFrame obj= new JFrame();
       		Gameplay gameplay= new Gameplay();
       		
       	//Specify the properties of the frame
       		obj.setBounds(10, 10, 905, 700);
       		obj.setBackground(Color.GRAY); //check si on peut mettre image
       		obj.setResizable(false); //we don't want the user to change dimensions
       		obj.setVisible(true);
       	//	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       		obj.add(gameplay);
       		
       		obj.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                	busyUsers.remove(user);
            //        JOptionPane.showMessageDialog(null, gameplay.Score());
                }
            });

           }
        
        private void FillProfile() throws Exception {
        	String user = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	String info = rs.getString("Status") + "//" + user + "//" + rs.getString("Mail") + "//" + rs.getString("Gender") + "//" + rs.getString("Country") + "//" + rs.getString("Age") + "//" + rs.getString("Friends");
        	
        	DataOut.writeBytes(info + "\n");
        }
        
        private void GetNumFriends() throws Exception {
        	String user = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username ='" + user + "'");
        	rs.next();
        	String num = rs.getString("Friends");
        	DataOut.writeBytes(num + "\n");
        }
        
        private void ChangePass() throws Exception {
        	String user = input.readLine();
        	String pass = input.readLine();
        	statement.executeUpdate("update users set Password = '" + pass + "' where Username = '" + user + "'");
        }
        
        private void SetStatus() throws Exception {
        	String user = input.readLine();
        	String status = input.readLine();
        	statement.executeUpdate("update users set Status = '" + status + "' where Username = '" + user + "'");
        }
        
        private void SetMailView() throws Exception {
        	String user = input.readLine();
        	String view = input.readLine();
        	statement.executeUpdate("update users set MailView = '" + view + "' where Username = '" + user + "'");
        }
        
        private void SetGenderView() throws Exception {
        	String user = input.readLine();
        	String view = input.readLine();
        	statement.executeUpdate("update users set GenderView = '" + view + "' where Username = '" + user + "'");
        }
        
        private void SetCountryView() throws Exception {
        	String user = input.readLine();
        	String view = input.readLine();
        	statement.executeUpdate("update users set CountryView = '" + view + "' where Username = '" + user + "'");
        }
        
        private void SetAgeView() throws Exception {
        	String user = input.readLine();
        	String view = input.readLine();
        	statement.executeUpdate("update users set AgeView = '" + view + "' where Username = '" + user + "'");
        }
        
        private void SetFriendsView() throws Exception {
        	String user = input.readLine();
        	String view = input.readLine();
        	statement.executeUpdate("update users set FriendsView = '" + view + "' where Username = '" + user + "'");
        }
        
        private void FillSettings() throws Exception {
        	String user = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	String settings = rs.getString("MailView") + "//" + rs.getString("GenderView") + "//" + rs.getString("CountryView") + "//" + rs.getString("AgeView") + "//" + rs.getString("FriendsView");
        	DataOut.writeBytes(settings + "\n");
        }
        
        private void ViewFriendProfile() throws Exception {
        	String user = input.readLine();
        	String friend = input.readLine();
        	
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + friend + "'");
        	boolean bool = rs.next();
        	if (bool) {
        		boolean friends = AreFriends(user, friend);
        		if (friends) {
        			
        			ResultSet rs2 = statement.executeQuery("select * from users where Username = '" + friend + "'");
                	rs2.next();
                	String toReturn = "";
                	if (rs2.getString("MailView").equals("true")) toReturn = toReturn + "MailView#" + rs2.getString("Mail") + "//";
                	if (rs2.getString("GenderView").equals("true")) toReturn = toReturn + "GenderView#" + rs2.getString("Gender") + "//";
                	if (rs2.getString("CountryView").equals("true")) toReturn = toReturn + "CountryView#" + rs2.getString("Country") + "//";
                	if (rs2.getString("AgeView").equals("true")) toReturn = toReturn + "AgeView#" + rs2.getString("Age") + "//";
                	if (rs2.getString("FriendsView").equals("true")) toReturn = toReturn + "FriendsView#" + rs2.getString("Friends") + "//";
                	
                	DataOut.writeBytes(toReturn + "\n");
        		}
        		else {
        			DataOut.writeBytes("not friends\n");
        		}
        	}
        	else {
        		DataOut.writeBytes("username doesn't exist\n");
        	}
        }
        
        private void GetFriendStatus() throws Exception {
        	String friend = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + friend + "'");
        	rs.next();
        	DataOut.writeBytes(rs.getString("Status") + "\n");
        }
        
        private void GetRequests() throws Exception {
        	String game = input.readLine();
        	String user = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	
        	String requests = rs.getString(game);
        	if (requests.equals("")) DataOut.writeBytes("no requests\n");
        	else DataOut.writeBytes(requests + "\n");
        }
        
        private void SendGameRequest() throws Exception {
        	String game = input.readLine();
        	String user = input.readLine();
        	String friend = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + friend + "'");
        	boolean bool = rs.next();
        //	List <String> msgs = new ArrayList<String>(Arrays.asList(rs.getString("InstantMessages").split("//")));
        	
        	if (bool) {
        		ResultSet rs2 = statement.executeQuery("select * from users where Username = '" + friend + "'");
        		rs2.next();
        		List <String> requests = new ArrayList<String>(Arrays.asList(rs2.getString(game).split("//")));
        		
        		boolean friends = AreFriends(user, friend);
        		if (friends) {
        			if (requests.get(0).equals("")) { 
        				statement.executeUpdate("update users set " + game + " = '" + user + "' where Username = '" + friend + "'"); 
        				DataOut.writeBytes("request sent\n");
        				}
        			else if (requests.contains(user)) DataOut.writeBytes("duplicate request\n");
        			else {
        				requests.add(user);
        				String toStore = "";
        				for (int i = 0; i < requests.size(); i++)
        					if (i == 0) toStore = requests.get(i);
        					else 
        					toStore = toStore + "//" + requests.get(i);
        				statement.executeUpdate("update users set " + game + " = '" + toStore + "' where Username = '" + friend + "'");
        				DataOut.writeBytes("request sent\n");
        			}
        		}
        		else{
        		DataOut.writeBytes("not friends\n");
        		}
        	}
        	else {
        		DataOut.writeBytes("username doesn't exist\n");
        	}
        }
        
        private void AcceptDeclineGameRequest() throws Exception {
        	String game = input.readLine();
        	String user = input.readLine();
        	String friend = input.readLine();
        	ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
        	rs.next();
        	List <String> requests =  new ArrayList <String>(Arrays.asList(rs.getString(game).split("//")));
        	requests.remove(friend);
        	String toStore = "";
			for (int i = 0; i < requests.size(); i++)
				if (i == 0) toStore = requests.get(i);
				else 
				toStore = toStore + "//" + requests.get(i);
			statement.executeUpdate("update users set " + game + " = '" + toStore + "' where Username = '" + user + "'");
        }
		private void CheckOnline() throws Exception{
			String user=input.readLine();
			boolean status=onlineUsers.contains(user);
			if(status==true)
				DataOut.writeBytes("Online\n");
			else DataOut.writeBytes("No\n");
			
		}
		
		private void CheckAvailable() throws Exception{
			String user=input.readLine();
			boolean status=busyUsers.contains(user);
			if(status==false)
				DataOut.writeBytes("Available\n");
			else DataOut.writeBytes("No\n");
		}
		private void Play() throws Exception{
			String game=input.readLine();
			String mode=input.readLine();
			String Player1=input.readLine();
			String Player2=input.readLine();
			busyUsers.add(Player1);
			busyUsers.add(Player2);
			
		//	JOptionPane.showMessageDialog(null, game + mode + Player1 + Player2);
			
			//ajouter une condition pour Snake
			
			//Check if Tic Tac Toe Computer Mode
			if(game.equals("Tic Tac Toe") && mode.equals("CM")){
				
			}
			
			//Check if Tic Tac Toe Friends Mode
			if(game.equals("Tic Tac Toe") && mode.equals("FM")){
				
		//		JOptionPane.showMessageDialog(null, game + mode + Player1 + Player2);
				//if(portempTTT==2024) portempTTT=2020;
				String [] args = {Player1, Player2};
				Main.main(args);
			//	portempTTT++;
			}
			//Check if Battle Ship Friends Mode
			if(game.equals("Battle Ship") && mode.equals("FM")){
		//		JOptionPane.showMessageDialog(null, game + mode + Player1 + Player2);
				String[] argss={Player1, Player2};
				
			}
	
		}
		
		
		private void ForgotPass() throws Exception {
			String user = input.readLine();
			ResultSet rs = statement.executeQuery("select * from users where Username = '" + user + "'");
			boolean bool =rs.next();
		//	JOptionPane.showMessageDialog(null, bool);
			if (!bool) DataOut.writeBytes("failure\n");
			else {
				String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		        StringBuilder salt = new StringBuilder();
		        Random rnd = new Random();
		        while (salt.length() < 18) { // length of the random string.
		            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		            salt.append(SALTCHARS.charAt(index));
		        }
		        String saltStr = salt.toString();
		//        JOptionPane.showMessageDialog(null, saltStr);
				ResultSet rs2 = statement.executeQuery("select * from users where Username = '" + user + "'");
				rs2.next();
				String mail = rs2.getString("Mail");
				statement.executeUpdate("update users set Password = '" + saltStr + "' where Username = '" + user + "'");
	//			JOptionPane.showMessageDialog(null, mail);
				String [] args = {mail, user, saltStr};
				SendEmail.main(args);
				
				DataOut.writeBytes("success\n");
			}
		}
		
		private void Chat()
		{
			String game="";
			String username="";
			try {
				 game=input.readLine();
				 username=input.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(game.equals("Tic Tac Toe"))
			{
				if(countChatTTT==0)
					try {
						DataOut.writeBytes("Admin\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else if(countChatTTT<countAdminTTT)
				{
					String[] arguments = new String[] {"localhost", username,TitleTTT};
					new ChatClient().main(arguments,portempTTT);
					countChatTTT++;
					try {
						DataOut.writeBytes("join\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					try {
						countChatTTT--;
						DataOut.writeBytes("Error\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
		}
		private void startChat()
		{
			String game="";
			String countAdmin="";
			String Title="";
			String username="";
			
			try {
				game = input.readLine();
				countAdmin=input.readLine();
				Title=input.readLine();
				username=input.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(game.equals("Tic Tac Toe"))
			{
				countAdminTTT=Integer.parseInt(countAdmin);
				TitleTTT=Title;
				String[] arguments = new String[] {"localhost", username,TitleTTT};
				new ChatClient().main(arguments,portempTTT);
				countChatTTT++;
		//		JOptionPane.showMessageDialog(null, countChatTTT);
				
				
			}
		}
		
		private void DecCount() throws IOException {
			String user = input.readLine();
			String game = input.readLine();
			String quit = input.readLine();
			if (game.equals("Tic Tac Toe")) {
				countChatTTT--;
	//			JOptionPane.showMessageDialog(null, countChatTTT);
				System.out.print(countChatTTT);
				if (quit.equals("yes")) {
					busyUsers.remove(user);
				} else {
					busyUsers.remove(user);
					chatUsersPlay.add(user);
					System.out.println(chatUsersPlay);
					if (chatUsersPlay.size() >= 2) {
						String Player1 = chatUsersPlay.get(0);
						String Player2 = chatUsersPlay.get(1);
						chatUsersPlay.remove(Player1);
						chatUsersPlay.remove(Player2);
						String [] args = {Player1, Player2};
						Main.main(args);
						
					}
				}
				
			}
		}
		
		private void PlayPac() {
			 Pacman c = new Pacman();
		}
    }
    }


