

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Queue;
import java.awt.event.*; 
import java.util.LinkedList;


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private int shootCooldown;
	private int cSelect;
	private final int shootDelay;
	private String screen;
	private ArrayList<yCharacters> displayCharacters;
	private ImageIcon JJH;
	private yCharacters player;
	private Queue <zz_Enemies> enemies;
	private ArrayList<xx_UserMissle> uMissles;
	

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		screen = "START";
		displayCharacters = setupCharacters();
		cSelect = 0;
		JJH = new ImageIcon("jjh.jpg");
		enemies = setEnemies();
		uMissles = new ArrayList<>();
		shootCooldown = 0;
		shootDelay = 200;
		
		for(yCharacters c: displayCharacters) {
			
			System.out.println(c.toString());

		}
	
	}

	private Queue<zz_Enemies> setEnemies() {

		Queue<zz_Enemies> temp = new LinkedList<zz_Enemies>();

		temp.add(new zzz_Hanami());
		temp.add(new zzz_Mahito());
		temp.add(new zzz_Sukuna());
		return temp;

	}
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}

		public ArrayList<yCharacters> setupCharacters() {

			ArrayList<yCharacters> temp = new ArrayList<yCharacters>();

			temp.add(new zHonoredOne());
			temp.add(new zUnlimitedPotential());
			temp.add(new zBloodManipulator());
			temp.add(new zDeadlySentencing());

			return temp;

		}

	public void fireUserMissle() {
        if (shootCooldown == 0) {
            uMissles.add(new xx_UserMissle(player.getX() + player.getW() / 2 - 10, player.getY(), 50, 50));
            shootCooldown = shootDelay;
        }
    }

	public void moveUserMissles() {
        for (int i = uMissles.size() - 1; i >= 0; i--) {
            xx_UserMissle m = uMissles.get(i);
            m.setdx(5);
            if (m.getY() + m.getHeight() < 0) uMissles.remove(i);
        }
    }

	public void drawUserMissles(Graphics g2d) {
        for (xx_UserMissle m : uMissles) {
            g2d.drawImage(m.getPic().getImage(), m.getX(), m.getY(), m.getWidth(), m.getHeight(), this);
        }
    }
	
	private void cSelectOffScreenPrevent() {
		if (cSelect > 3) {
			cSelect = 3;
		}
		else if (cSelect < 0) {
			cSelect = 0;
		}
	}

	public void gameScreen(Graphics g2d) {

		switch(screen) {

			case "START":

				drawStart(g2d);
				cSelectOffScreenPrevent();

			break;

			case "L1":

			if (shootCooldown > 0) shootCooldown--;
			g2d.drawImage(JJH.getImage(),0,0, this);
			player.drawChar(g2d);
			player.moveCharacter();
			enemies.element().drawEnemy(g2d);
			moveUserMissles();
			drawUserMissles(g2d);
			g2d.setFont(new Font("Noto Sans JP", Font.BOLD, 25));
			g2d.setColor(Color.WHITE);
			g2d.drawString("Health:" + enemies.element().getHealth(), 900, 50);
		
		
		}
	}




	private void drawStart(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.WHITE);
    g2d.setFont(new Font("Noto Sans JP", Font.BOLD, 25));
	
	//i used claude to display the japanese characters vertically
    int lineHeight = g2d.getFontMetrics().getHeight();

    for (int i = 0; i < displayCharacters.size(); i++) {
        yCharacters c = displayCharacters.get(i);
        c.drawChar(g2d);

		if (i == cSelect) {
            g2d.setColor(Color.WHITE);
            g2d.drawRect(c.getX() - 5, c.getY() - 5, c.getW(), c.getH());
			g2d.drawString(c.geteName(), 100, 600);
			g2d.drawString("Health: " + c.getHealth(), 100,650);
			g2d.drawString("Cursed Energy:" + c.getCE(), 100, 700);
			g2d.drawString("Damage: " + c.getDamage(), 100, 750);

       }

	 	String name = c.getName();
        int textX = c.getX() - 40;
        int textY = c.getY() + lineHeight;

	   for (int j = 0; j < name.length(); j++) {
            g2d.drawString(String.valueOf(name.charAt(j)), textX, textY + j * lineHeight);
	   }

}
}

	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		gameScreen(g2d);


		twoDgraph.drawImage(back, null, 0, 0);

	}





	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();

		if (screen == "START") {
        if (key == 39) {
            cSelect = (cSelect + 1);
			System.out.println(cSelect);
        }
		if (key == 37) {
			cSelect = (cSelect - 1);
			System.out.println(cSelect);
		}

		if (key == 10) {
			player = displayCharacters.get(cSelect);
			player.setX(100);
			player.setY(100);
			screen = "L1";
		}



		

		
	}

	if (screen.equals("L1")){
		if (key == 84 ){
			enemies.remove();
		}
		if(key == 38) {
			player.setDy(-2);
		}
		if (key == 40) {
			player.setDy(2);
		}
		if (key == 39) {
			fireUserMissle();
		}
	}

	System.out.println(key);


		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(key == 38) {
			player.setDy(0);
		}
		if(key == 40) {
			player.setDy(0);
		}
		
	}
	
	
	

	
}

                                                                                                                                                                                                                                                               