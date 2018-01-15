package gameRoom;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	
	private int score = 0;
	private	int[] snakexlength= new int[750];
	private	int[] snakeylength= new int[750];
	
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	
	private int[] enemyxpos = {25,50,75,100,125,150, 175, 200, 225, 250, 275, 300, 325, 350,
			375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725,
			750, 775, 800, 825, 850};
	
	private int[] enemyypos = {75,100,125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
			375, 400, 425, 450, 475, 500, 525, 550, 575, 600,625};	
	
	private int scores=0;
	
	//To add the enemy:Elements needed
	private ImageIcon enemyimage;
	
	private  Random random= new Random();
	private int xpos=random.nextInt(34);
	private int ypos=random.nextInt(23);	
	
	private int lengthsnake=3;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private int moves=0;
	
	//movement of snake and speed
	
	private Timer timer;
	private int delay=100;
	
	private ImageIcon snakeimage;
	
	private ImageIcon titleImage;

//constructor
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer= new Timer(delay, this);
		timer.start();
	}
	
	public int Score() {
		return this.score;
	}
	
	//method to draw everything on the panel
	public void paint(Graphics g)
	{
		if(moves==0) //executed at the beginning of the game only
		{
			//Define default position of the snake
			snakexlength[2]=50;
			snakexlength[1]=75;
			snakexlength[0]=100;
			
			snakeylength[2]=100;
			snakeylength[1]=100;
			snakeylength[0]=100;
			
		}
		//Set the boarder of the title 
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//Set the title image
		titleImage= new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//Set the boarder of the playing area
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
	
		//Set the background for the gameplay, chercher une image pour plus tard
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575); //should be multiple of 25
		
		//draw score
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 16));
		g.drawString("Score : "+scores, 780, 30);
		
		//draw length of snake
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 16));
		g.drawString("Length : "+lengthsnake, 780, 60);
		
		//define default position of snake: top-left area
		//draw the snake, without movement
		
		rightmouth=new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int a=0; a<lengthsnake;a++)
		{
			
			//a==0 -> face
			
			if(a==0 && right)
			{
				rightmouth=new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && left)
			{
				leftmouth=new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && down)
			{
				downmouth=new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
				
			if(a==0 && up)
			{
				upmouth=new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			//a!=0 -> not face
			
			if(a!=0)
			{
				snakeimage=new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
		}
		
		enemyimage= new ImageIcon("C:\\Users\\Morgane\\Desktop\\GameRoom code snake\\enemy.jpg");
		
		if((enemyxpos[xpos])==snakexlength[0] && (enemyypos[ypos])==snakeylength[0])
		{
			lengthsnake++;
			if(delay>30)
			{
			delay=delay-5;
			timer.setDelay(delay);
			}
			else delay=30;
			xpos=random.nextInt(34);
			ypos=random.nextInt(23);
			scores++;
		}
		enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
		
		//Dealing with collisions
		for(int e=1; e<lengthsnake; e++)
		{
			if(snakexlength[e]==snakexlength[0] && snakeylength[e]==snakeylength[0])
			{
				//Display game over
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 100));
				g.drawString("Game Over ! ",150, 340);
				
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 80));
				g.drawString("Your Score: " + scores, 190, 440);
				
				this.score = scores;
				
				//We don't want the snake to move in any direction
				right=false;
				left=false;
				up=false;
				down=false;
				
		//		delay=300;

		/*		snakexlength[2]=50;
				snakexlength[1]=75;
				snakexlength[0]=100;
				
				snakeylength[2]=100;
				snakeylength[1]=100;
				snakeylength[0]=100;
				
				moves=0;
				scores=0;
				lengthsnake=3; */

			/*	try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} */
				break;

			}
			
		}
	//	repaint();
		
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(right)
		{
			for(int r=lengthsnake-1; r>=0; r--)
			{
				snakeylength[r+1]=snakeylength[r];
			}
			for(int r=lengthsnake;r>=0;r--)
			{
				if(r==0) snakexlength[r]=snakexlength[r]+25;
				else snakexlength[r]=snakexlength[r-1];
				
				if(snakexlength[r]>850) snakexlength[r]=25;
			}
			
			repaint();
		}
		if(left)
		{
			for(int r=lengthsnake-1; r>=0; r--)
			{
				snakeylength[r+1]=snakeylength[r];
			}
			for(int r=lengthsnake;r>=0;r--)
			{
				if(r==0) snakexlength[r]=snakexlength[r]-25;
				else snakexlength[r]=snakexlength[r-1];
				
				if(snakexlength[r]<25) snakexlength[r]=850;
			}
			
			repaint();
			
		}
		if(up)
		{

			for(int r=lengthsnake-1; r>=0; r--)
			{
				snakexlength[r+1]=snakexlength[r];
			}
			for(int r=lengthsnake;r>=0;r--)
			{
				if(r==0) snakeylength[r]=snakeylength[r]-25;
				else snakeylength[r]=snakeylength[r-1];
				
				if(snakeylength[r]<70) snakeylength[r]=625;
			}
			
			repaint();
			
		}
		if(down)
		{
			for(int r=lengthsnake-1; r>=0; r--)
			{
				snakexlength[r+1]=snakexlength[r];
			}
			for(int r=lengthsnake;r>=0;r--)
			{
				if(r==0) snakeylength[r]=snakeylength[r]+25;
				else snakeylength[r]=snakeylength[r-1];
				
				if(snakeylength[r]>625) snakeylength[r]=80;
			}
			
			repaint();
			
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	//Note that in our implementation we don't want a snake moving to the 
	//right to immediately start moving left (snake collide / itself)
	//idem for up and down
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			moves++;
			if(! left) right=true;
			else right=false;

			up=false;
			down=false;			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			moves++;
			if(! right) left=true;
			else  left=false;
			
			up=false;
			down=false;			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			moves++;
			if(! down) up=true;
			else up=false;
	
			left=false;
			right=false;			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			moves++;
			if(! up) down=true;
			else down=false;
			right=false;
			left=false;			
		}
		
	//enable key listener for space bar
	if(e.getKeyCode()==KeyEvent.VK_SPACE)
	{
		//When the space bar is set, the user wants to restart the game
		up=false;
		left=false;
		down=false;
		right=false;		
		
		moves=0;
		scores=0;
		lengthsnake=3;
		
		repaint();
		
		
	}
		
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
	
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}
}
