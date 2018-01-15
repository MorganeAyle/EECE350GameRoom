package gameRoom;

import javax.swing.JOptionPane;

public class Main {
	
	private static int portemp=2015;
	private static TicTacToe ttt1;
	private static TicTacToe ttt2;
	private static String Player1;
	private static String Player2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(portemp>2020)
			portemp=2015;
		 Player1 = args[0];
		 Player2 = args[1];
		 ttt1= new TicTacToe(Player1, 1,"localhost",portemp,Player2);
		JOptionPane.showMessageDialog(null, ttt1);
		 ttt2= new TicTacToe(Player2,2,"localhost",portemp,Player1);
		portemp++;	
	}
	//public int  Score(String player){
//		if(player.equals(Player1))
//			return ttt1.winnedgame();
//		else if(player.equals(Player2))
//			return ttt2.winnedgame();
//		else return 0;
		
//	}

}
