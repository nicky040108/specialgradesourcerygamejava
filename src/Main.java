import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =1200;
	private static final int HEIGHT=900;
	
	public Main () {
		super("Special Grade Sourcery");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		setBackground(Color.BLACK);
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}


}

