package gameRoom;

import java.util.*;   
import java.awt.*;   
import java.awt.event.*;   
import java.applet.*;   
import javax.swing.*;   
   
class Bingo extends JFrame implements Runnable   
{   
   
 final static int PLAYER =1;    
 final static int COMPUTER =0;   
   
 ClassLoader cl = this.getClass().getClassLoader();   
 Toolkit tk = Toolkit.getDefaultToolkit();   
   
 int game_state, num /* ä½ˆå­�æ•¸, ç•¶çŽ©å®¶æŠŠ25å€‹æ•¸å­—éƒ½ä½ˆå®Œå¾Œ é–‹å§‹é�Šæˆ² */, turn, winner=-1;   
 int connects[] = new int[2]; /* é›™æ–¹é€£ç·šæ•¸ */   
 int weight[] = new int[3]; /* è¨ˆç®—æ¬Šé‡�, w[0]=x w[1]=y w[2]=weight */   
 int locX, locY /* ä¸‹æ£‹ä½�ç½® */, count /* é€£æ£‹æ•¸ */, x, y /* æš«å­˜ä½�ç½® */, temp_value, displace_x=0, displace_y=0 /* ä½�ç§»é‡� */;   
 ArrayList steps = new ArrayList(); /* è¨˜éŒ„æ£‹æ­¥ */   
   
 int[][] dir = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };   
 boolean[] dir2 = new boolean[8];    
    
 String message;   
   
 Font font=new Font("new_font", Font.BOLD, 20);   
 Grid grids[][][] = new Grid[2][5][5];   
   
 Image temp;   
 JPanel[] boardPanel = new JPanel[2];   
 JPanel containerPanel = new JPanel();   
   
 final static int Start =0;   
 final static int Select =1;   
 final static int Playing =2;   
 final static int End =3;   
   
 final static int nil=-1; /* ç„¡æ–¹å�‘ */   
 final static int oblique_1 =0; /* å�³ä¸Šå�‘å·¦ä¸‹ */   
 final static int oblique_2 =1; /* å·¦ä¸Šå�‘å�³ä¸‹ */   
 final static int horizontal =2; /* æ©«å�‘ */   
 final static int vertical=3; /* ç›´å�‘ */   
   
 Bingo()   
 {   
  super("è³“æžœ");   
   
  for(int i=0; i<2; i++)   
  {   
   boardPanel[i] = new JPanel();   
   boardPanel[i].setLayout(new GridLayout(5, 5, 0, 0));   
   boardPanel[i].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);   
   
   for(int j=0; j<5; j++)   
    for(int k=0; k<5; k++)      
    {   
     grids[i][j][k] = new Grid(i, j, k);    
     boardPanel[i].add(grids[i][j][k]);   
    }   
   
   containerPanel.add(boardPanel[i], BorderLayout.CENTER);   
  }    
   
  getContentPane().add(containerPanel, BorderLayout.CENTER);      
   
  game_state=Start;   
  ThreadStart();   
   
  setResizable(false);   
  setSize(150, 250);   
  setVisible(true);   
  setLocationRelativeTo(null);   
 }   
   
 public static void main(String[] arg)   
 {   
  Bingo application = new Bingo();   
 // application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
 }   
   
 public void ReStart()   
 {   
  for(int i=0; i<2; i++)   
  {   
   connects[i]=0;   
   
   for(int j=0; j<5; j++)   
    for(int k=0; k<5; k++)   
     grids[i][j][k].Initial();   
  }   
   
  num=weight[2]=0;   
  winner=-1;   
  steps.clear();   
  game_state=Select;   
 }   
   
 /* é›»è…¦éš¨æ–°é‡�æ–°æ´—å€¼ */   
   
 public void washValue()    
 {   
  for(int i=0; i<5; i++)   
   for(int j=0; j<5; j++)   
   {   
    temp_value=grids[COMPUTER][i][j].getValue();   
   
    x=(int)(Math.random()*5);    
    y=(int)(Math.random()*5);   
   
    grids[COMPUTER][i][j].setValue(grids[COMPUTER][x][y]);   
    grids[COMPUTER][x][y].setValue(temp_value);     
   }   
 }   
   
 /* ç•¶ä¸€æ–¹ä¸‹å®Œå¾Œ å�¦ä¸€æ–¹ä¹Ÿä¸‹å�Œä¸€å€‹å€¼ */   
   
 public void redo(int value)   
 {   
  for(int i=0; i<5; i++)   
   for(int j=0; j<5; j++)   
   {   
    if(grids[turn][i][j].getValue()==value)   
    {   
     grids[turn][i][j].setSelected(true);   
         
     break;   
    }   
   }   
 }   
   
 public void WinCheck()   
 {   
  if(game_state==Playing)   
  {   
   WinCheck(oblique_1);   
   repaint();   
  }   
 }   
   
 public void WinCheck(int direction)   
 {   
  count=1;   
     
  switch(direction)   
  {   
   case oblique_1: displace_x=1;   
                   displace_y=-1;   
                   break;   
   
   case oblique_2: displace_x=displace_y=1;   
                   break;   
   
   case horizontal: displace_x=1;   
                    displace_y=0;   
                    break;   
                              
   case vertical: displace_x=0;   
                  displace_y=1;   
                  break;   
  }   
   
  x=locX+displace_x;   
  y=locY+displace_y;   
   
  while(x>=0 && x<5 && y>=0 && y<5 && grids[turn][x][y].getSelected())   
  {   
   count=count+1;   
   x=x+displace_x;   
   y=y+displace_y;   
  }   
   
  x=locX-displace_x;   
  y=locY-displace_y;   
    
  while(x>=0 && x<5 && y>=0 && y<5 && grids[turn][x][y].getSelected())   
  {   
   count=count+1;   
   x=x-displace_x;   
   y=y-displace_y;   
  }   
     
  if(count>=5)   
  {   
   x=locX;   
   y=locY;   
   
   while(x>=0 && x<5 && y>=0 && y<5 && grids[turn][x][y].getSelected())   
   {   
    grids[turn][x][y].setConnected(direction);   
    x=x+displace_x;   
    y=y+displace_y;   
   }   
   
   x=locX-displace_x;   
   y=locY-displace_y;   
   
   while(x>=0 && x<5 && y>=0 && y<5 && grids[turn][x][y].getSelected())   
   {   
    grids[turn][x][y].setConnected(direction);   
    x=x-displace_x;   
    y=y-displace_y;   
   }   
   
   connects[turn]=connects[turn]+1;   
     
   if(connects[turn]>=5)   
   {   
    game_state=End;   
    winner=turn;   
    ThreadStart();   
   }   
  }   
   
  if(direction!=vertical)   
   WinCheck(direction+1);   
 }   
   
   
 public void BingoRandom()   
 {   
  int i, j;   
   
  if(!grids[COMPUTER][2][2].getSelected()) /* æ­£ä¸­å¤®çš„ä½�ç½® */   
   i=j=2;   
  else   
  {   
   do   
   {       
    i=(int)(Math.random()*5);    
    j=(int)(Math.random()*5);   
   }while(grids[COMPUTER][i][j].getSelected());   
  }   
      
  grids[COMPUTER][i][j].setSelected(true);   
  turn=PLAYER;   
  redo(grids[COMPUTER][i][j].getValue());   
 }   
   
 public void BingoAI()   
 {   
  for(int i=0; i<5; i++)   
   for(int j=0; j<5; j++)   
   {   
    if(!grids[COMPUTER][i][j].getSelected())   
     BingoAI2(i, j);   
   }   
   
  if(weight[2]>1)   
  {   
   //System.out.println(weight[2]);   
   weight[2]=0;   
   
   grids[COMPUTER][weight[0]][weight[1]].setSelected(true);   
   
   turn=PLAYER;   
   redo(grids[COMPUTER][weight[0]][weight[1]].getValue());   
  }   
  else   
   BingoRandom();   
 }   
   
 public void BingoAI2(int i, int j)   
 {   
  locX=i;   
  locY=j;   
   
  int w=0, direction=oblique_1;   
     
  while(direction!=nil)   
  {   
   switch(direction)   
   {   
    case oblique_1: displace_x=1;   
                    displace_y=-1;   
                    direction=oblique_2;   
   
                    break;   
   
    case oblique_2: displace_x=displace_y=1;   
                    direction=horizontal;   
                       
                    break;   
   
    case horizontal: displace_x=1;   
                     displace_y=0;   
                     direction=vertical;   
                       
                     break;   
                              
    case vertical: displace_x=0;   
                   displace_y=1;   
                   direction=nil;   
   
                   break;   
   }   
   
   w=w+calculateWeight(displace_x, displace_y);   
  }   
   
  if(w>weight[2])   
  {   
   weight[0]=locX;   
   weight[1]=locY;   
   weight[2]=w;   
  }   
 }   
   
 public int calculateWeight(int displace_x, int displace_y)   
 {   
  int w=0;   
  count=0;   
   
  x=locX;   
  y=locY;   
   
  while(x>=0 && x<5 && y>=0 && y<5)   
  {   
   if(grids[COMPUTER][x][y].getSelected())   
    w=w+1;   
   
   count=count+1;   
   x=x+displace_x;   
   y=y+displace_y;   
  }   
   
  x=locX-displace_x;   
  y=locY-displace_y;   
    
  while(x>=0 && x<5 && y>=0 && y<5)   
  {   
   if(grids[COMPUTER][x][y].getSelected())   
    w=w+1;   
   
   count=count+1;   
   x=x-displace_x;   
   y=y-displace_y;   
  }   
   
  if(w==4) /* èª¿é‡�å·²æœ‰å››å€‹è¢«é�¸æ“‡çš„è¡Œåˆ—æ¯”é‡� */   
   w=w+1;    
   
  return (count==5)? w*w: 0;   
 }   
   
 public void ThreadStart()   
 {   
  new Thread(this).start();   
 }   
    
 public void run()   
 {   
  try   
  {   
   switch(game_state)   
   {   
    case Start: Thread.sleep(2000);   
                game_state=Select;    
                repaint();   
   
                break;   
   
    case End: repaint();   
              Thread.sleep(1500);   
              ReStart();   
              repaint();   
   
              break;   
   }   
  }   
  catch(InterruptedException ex)   
  {   
  }   
 }   
   
 public void paint(Graphics g)   
 {   
  super.paint(g);   
    
  switch(game_state)   
  {   
   case Start: g.drawString("2006.4  by Yu Lin Tao", 16, 200);   
               g.setFont(font);   
               g.setColor(Color.BLUE);   
               g.drawString("Bingo", getWidth()/3, 120);   
   
               break;   
   
   case Select:   
   case Playing:   
   case End:    
            g.drawString("", 2, 75);   
            g.drawString("C: "+connects[COMPUTER], 2, 89);   
            g.drawString("", 2, 180);   
            g.drawString("C: "+connects[PLAYER], 2, 194);   
   
            if(winner!=-1)   
            {   
             g.setFont(font);   
             g.setColor(Color.BLUE);   
             message = winner==PLAYER? "":"";   
             g.drawString(message, 40, 130);   
            }   
   
            break;   
  }   
 }   
    
 public void undo()   
 {   
  if(steps.size()>0)   
  {   
   for(int i=0; i<2; i++)   
   {   
    ((Grid)steps.get(steps.size()-1)).Initial();   
    steps.remove(steps.size()-1);   
   }   
  }   
 }   
   
 public void undoNum()   
 {   
  if(steps.size()>0)   
  {   
   num=num-1;   
   
   ((Grid)steps.get(steps.size()-1)).Initial();   
   steps.remove(steps.size()-1);   
  }   
 }   
   
 private class Grid extends JPanel implements MouseListener   
 {   
  int x, y, value, owner;   
  boolean choice, selected, connected;   
  boolean[] direction = new boolean[4];   
   
  public Grid(int own, int x, int y)   
  {   
   owner=own;   
   this.x=x;   
   this.y=y;   
   
   Initial();   
   
   addMouseListener(this);   
  }   
   
  public void mousePressed(MouseEvent event)   
  {   
   int button=event.getButton();   
   
   if(owner==PLAYER)   
   {   
    switch(game_state)   
    {   
     case Select: if(button==MouseEvent.BUTTON1)   
                  {   
                   if(value==0 && num<25)   
                   {   
                    value=num=num+1;   
                    steps.add(this);   
   
                    if(num==25)   
                    {   
                     steps.clear(); /* æ´—æŽ‰å·²ä¸‹æ•¸å­— */   
                     washValue();   
                     game_state=Playing;   
                    }   
    
                    repaint();   
                   }   
                  }   
                  else   
                   undoNum();   
   
                  break;   
   
     case Playing: if(button==MouseEvent.BUTTON1)   
                   {   
                    if(!selected)    
                    {   
                     steps.add(this);   
                     turn=PLAYER;   
                     setSelected(true);   
   
                     if(game_state==Playing)   
                     {   
                      turn=COMPUTER;   
                      redo(value);     
   
                      if(game_state==Playing)   
                       BingoAI();   
                     }                        
                    }   
                   }   
                   else    
                   {   
                    if(steps.size()!=0)   
                     undo();   
                   }   
   
                   break;   
   
     default: break;   
   
    }   
   }   
  }   
   
  public void mouseEntered(MouseEvent event)   
  {    
   if(owner==PLAYER && game_state!=Start)   
    setChoice(true);   
  }   
     
  public void mouseExited(MouseEvent event)   
  {   
   if(owner==PLAYER && game_state!=Start)   
    setChoice(false);   
  }   
   
  public void mouseClicked(MouseEvent event)   
  {   
  }   
   
  public void mouseReleased(MouseEvent event)   
  {   
  }   
   
  public Dimension getPreferredSize()    
  {    
   return new Dimension(20, 20);   
  }   
   
  public Dimension getMinimumSize()    
  {   
   return getPreferredSize();   
  }   
   
  public int getOwner()   
  {   
   return owner;   
  }   
   
  public int getLocX()    
  {   
   return x;   
  }   
   
  public int getLocY()    
  {   
   return y;   
  }   
   
  public int getValue()    
  {   
   return value;   
  }   
   
  public void Initial()    
  {   
   value= owner==COMPUTER? x*5+(y+1): 0;   
   choice=selected=connected=false;   
   
   for(int i=0; i<direction.length; i++)   
    direction[i]=false;   
   
   repaint();   
  }   
   
  public void setValue(int new_value)    
  {   
   value=new_value;   
   repaint();   
  }   
   
  public void setValue(Grid gird)   
  {   
   value=gird.getValue();   
   repaint();   
  }   
   
  public void setChoice(boolean choice)   
  {   
   this.choice=choice;   
   repaint();   
  }   
   
  public boolean getSelected()   
  {   
   return selected;   
  }   
   
  public void setSelected(boolean select)   
  {   
   selected=select;   
   
   if(select)   
   {   
    locX=x;   
    locY=y;   
    WinCheck();   
   }   
   
   repaint();   
  }   
   
  public boolean getConnected()   
  {   
   return connected;   
  }   
   
  public void setConnected(boolean connect)   
  {   
   connected=connect;   
   repaint();   
  }   
   
  public void setConnected(int direct)   
  {   
   connected=direction[direct]=true;   
   repaint();   
  }   
   
  public void paintComponent(Graphics g)   
  {   
   super.paintComponent(g);   
   
   //g.drawString(x+" "+y, 1, 10);   
   
   if(game_state!=Start)   
   {   
    g.drawRect(0, 0, 19, 19);   
   
    if(choice)   
     setBackground(Color.WHITE);   
    else if(connected)   
     setBackground(Color.RED);   
    else if(selected)   
     setBackground(Color.YELLOW);   
    else if(value!=0 && owner==PLAYER)   
     setBackground(Color.LIGHT_GRAY);   
    else    
     setBackground(Color.GRAY);   
   
    for(int i=0; i<direction.length; i++)   
    {   
     if(direction[i])   
     {   
      g.setColor(Color.WHITE);   
   
      switch(i)   
      {   
       case oblique_1: g.drawLine(0, 0, 20, 20);   
                       break;   
   
       case oblique_2: g.drawLine(20, 0, 0, 20);   
                       break;   
   
       case horizontal: g.drawLine(10, 0, 10, 20);   
                        break;   
   
       case vertical: g.drawLine(0, 10, 20, 10);   
                      break;   
      }   
     }        
    }   
   
    g.setColor(Color.BLACK);   
   
    if((owner==PLAYER && value!=0) || (selected || connected))   
     g.drawString(""+value, (value>=10? 4: 7), 15);   
   }   
  }   
 }   
   
}   

