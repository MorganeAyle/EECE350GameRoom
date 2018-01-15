package gameRoom;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

import javax.swing.JOptionPane;

public class Client {
	
	public DataOutputStream outToServer;
	public BufferedReader inFromServer;
	public Socket clientSocket;
	public String username;
//	public LinkedList<String> friends = new LinkedList();
	public String request(String s)
	{
		
	try {
		outToServer.writeBytes(s);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String ok = "";
	try {
		ok = inFromServer.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ok;
		
	}
	
	public Client(){
	try{
		clientSocket = new Socket("localhost", 2008);
		System.out.println("Client now running ...");
		// These streams are for the same purpose as in the server side //
		outToServer = new DataOutputStream(clientSocket.getOutputStream());
		inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		/*if (inFromServer.readLine().equals("Update your username")) { 
			username = inFromServer.readLine();
			System.out.println(username);
		}*/
		} 
		catch (UnknownHostException ex) {// catch the exceptions //
			ex.printStackTrace();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String logInClient(String username, String password) {
		String returnResponse = null;
		try {
			outToServer.writeBytes("login\n" );
			outToServer.writeBytes(username + "//" + password + "\n");
			String response = inFromServer.readLine();
			if (response.equals("success")) {
				this.username = username;
				returnResponse = "success";
			}
			else if (response.equals("failure")) {
				returnResponse = "failure";
			}
			else if (response.equals("cannot login now")) {
				returnResponse = "cannot login now";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public String signUpClient(String username, String password, String mail, String gender, String country, String age) {
		String returnResponse = null;
		try {
			outToServer.writeBytes("signup\n");
			outToServer.writeBytes(username + "//" + password + "//" + mail + "//" + gender + "//" + country + "//" + age + "\n");
			String response = inFromServer.readLine();
//			JOptionPane.showMessageDialog(null, response);
			if (response.equals("failure")) {
				returnResponse = "failure";
			}
			else if (response.equals("success")) {
				this.username = username;
				returnResponse = "success";
			}
			else if (response.equals("cannot login now")) {
				returnResponse = "cannot login now";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public String sendFriendRequestClient(String friendName) {
		String returnResponse = null;
		
		try {
			outToServer.writeBytes("send friend request\n");
			outToServer.writeBytes(this.username + "//" + friendName + "\n");
			returnResponse = inFromServer.readLine(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public String removeFriend(String friendName) {
		String returnResponse = null;
		try {
			outToServer.writeBytes("remove friend\n");
			outToServer.writeBytes(this.username + "//" + friendName + "\n");
			returnResponse = inFromServer.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public List<String> showNotifClient() {
		List<String> returnResponse = null;
		try { 
			outToServer.writeBytes("show notif\n");
			outToServer.writeBytes(this.username + "\n");
			String response = inFromServer.readLine();
			if (!response.equals("no notif")) {
				returnResponse = new ArrayList<String>(Arrays.asList(response.split("//")));
			}
		}catch (IOException e2) {
			e2.printStackTrace();
		}
		return returnResponse;
	}
	
	public void acceptRequestClient(String friendName) {
		try {
			outToServer.writeBytes("accept request\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(friendName + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rejectRequestClient(String friendName) {
		try {
			outToServer.writeBytes("reject request\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(friendName + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String sendInstMsgClient(String friendName, String message) {
		String returnResponse = "";
		try {
			outToServer.writeBytes("send inst msg\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(friendName + "\n");
			outToServer.writeBytes(message + "\n");
			returnResponse = inFromServer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public List<String> showInstMsgClient() {
		List<String> returnResponse = null;
		try { 
			outToServer.writeBytes("show inst msgs\n");
			outToServer.writeBytes(this.username + "\n");
			String response = inFromServer.readLine();
			if (!response.equals("no inst msgs")) {
			
				returnResponse = new ArrayList<String>(Arrays.asList(response.split("//")));
			}
		}catch (IOException e2) {
			e2.printStackTrace();
		}
		return returnResponse;
	}
	
	public void deleteMsgClient(String friendName, String message) {
		try {
			outToServer.writeBytes("delete msg\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(friendName + "\n");
			outToServer.writeBytes(message + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeSocket() {
		try {
			outToServer.close();
			inFromServer.close();
			clientSocket.close();
			
		} catch (IOException e) {
		}
	}
	
	public void playSnakeClient() { //since one mode only
		try {
			outToServer.writeBytes("play snake\n");
			outToServer.writeBytes(this.username + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playTicTacToeClient(String mode){
		try {
			outToServer.writeBytes("play tictactoe\n");			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String[] fillProfileClient() {
		String [] returnReponse = new String[7];
		try {
			outToServer.writeBytes("fill profile\n");
			outToServer.writeBytes(this.username + "\n");
			String info = inFromServer.readLine();
			returnReponse = info.split("//");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnReponse;
		}
	
	public String getNumFriends() {
		String returnResponse = "";
		try {
			outToServer.writeBytes("num friends\n");
			outToServer.writeBytes(this.username + "\n");
			returnResponse = inFromServer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public String getFriendStatusClient(String friendName) {
		String returnResponse = "";
		try {
			outToServer.writeBytes("get friend status\n");
			outToServer.writeBytes(friendName + "\n");
			returnResponse = inFromServer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
		}
	
	public void ChangePassClient(String newPass) {
		try {
			outToServer.writeBytes("change pass\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(newPass + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SetStatusClient(String status) {
		try {
		outToServer.writeBytes("set status\n");
		outToServer.writeBytes(this.username + "\n");
		outToServer.writeBytes(status + "\n");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void MailViewClient(boolean view) {
		try {
			outToServer.writeBytes("mail view\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(view + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void GenderViewClient(boolean view) {
		try {
			outToServer.writeBytes("gender view\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(view + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CountryViewClient(boolean view) {
		try {
			outToServer.writeBytes("country view\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(view + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AgeViewClient(boolean view) {
		try {
			outToServer.writeBytes("age view\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(view + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void FriendsViewClient(boolean view) {
		try {
			outToServer.writeBytes("friends view\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(view + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] FillSettingsClient() {
		String [] returnReponse = new String[5];
		try {
			outToServer.writeBytes("fill settings\n");
			outToServer.writeBytes(this.username + "\n");
			String settings = inFromServer.readLine();
			returnReponse = settings.split("//");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnReponse;
	}
	
	public List<String> ViewFriendProfileClient(String friendName) {
		List<String> returnResponse = null;
		try {
			outToServer.writeBytes("view friend profile\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(friendName + "\n");
			String response = inFromServer.readLine();
			returnResponse = new ArrayList<String>(Arrays.asList(response.split("//")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public List<String> getRequests(String game) {
		List<String> returnResponse = null;
		try { 
			outToServer.writeBytes("get requests\n");
			outToServer.writeBytes(game + "\n");
			outToServer.writeBytes(this.username + "\n");
			String response = inFromServer.readLine();
		
			if (!response.equals("no requests")) {
				returnResponse = new ArrayList<String>(Arrays.asList(response.split("//")));
			}
		}catch (IOException e2) {
			e2.printStackTrace();
		}
		return returnResponse;
	}
	
	public String SendGameRequest(String game, String friend) {
		String returnResponse = "";
		try {
			outToServer.writeBytes("send game request\n");
			outToServer.writeBytes(game + "\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(friend + "\n");
			returnResponse = inFromServer.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnResponse;
	}
	
	public void AcceptDeclineGameRequest(String game, String friend) {
		try {
			outToServer.writeBytes("accept game request\n");
			outToServer.writeBytes(game + "\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(friend + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean checkOnline(String friend)
	{
		String returnResponse="";
		try {
			outToServer.writeBytes("check online\n");
			outToServer.writeBytes(friend + "\n");
			returnResponse=inFromServer.readLine();	
			JOptionPane.showMessageDialog(null, returnResponse);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(returnResponse.equals("Online"))
		return true;
		else return false;
		
	}
	public boolean CheckAvailable(String friend)
	{
		String returnResponse="";
		try {
			outToServer.writeBytes("check available\n");
			outToServer.writeBytes(friend + "\n");
			returnResponse=inFromServer.readLine();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(returnResponse.equals("Available"))
		return true;
		else return false;}
	

	public void playGame(String game,String mode, String Player1, String Player2){
		try {
			outToServer.writeBytes("play\n");
			outToServer.writeBytes(game + "\n");
			outToServer.writeBytes(mode+ "\n");
			outToServer.writeBytes(Player1+ "\n");
			outToServer.writeBytes(Player2+ "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String forgotPass(String user) {
		String returnResponse = "";
		try {
			outToServer.writeBytes("forgot pass\n");
			outToServer.writeBytes(user + "\n");
			returnResponse = inFromServer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return returnResponse;
	}
	
	public int chat(String game, String username)
	{
		String message;
		try {
			outToServer.writeBytes("chat\n");
			outToServer.writeBytes(game+"\n");
			outToServer.writeBytes(username+"\n");	
			message=inFromServer.readLine();
			if(message.equals("Admin")) return 0;
			else if(message.equals("Error")) return 1;
			else return 2;
				} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 3;
	}
	
	public void StartChat(String countAdmin, String Title, String game,String name)
	{
		try {
			outToServer.writeBytes("startChat\n");
			outToServer.writeBytes(game+"\n");
			outToServer.writeBytes(countAdmin+"\n");	
			outToServer.writeBytes(Title+"\n");
			outToServer.writeBytes(name+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DecCount(String game, String quit) {
		try {
			outToServer.writeBytes("dec count\n");
			outToServer.writeBytes(this.username + "\n");
			outToServer.writeBytes(game + "\n");
			outToServer.writeBytes(quit + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playPac() {
		try {
			outToServer.writeBytes("play pac\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 }
