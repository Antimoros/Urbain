package launcher;

import gui.MainGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	
public class StarterUrbain implements Runnable {
	
	public void run()  {
		
        final JFrame starter = new JFrame("StarterUrbain");
        final JPanel panel = new JPanel();
        final JButton startGame = new JButton("Start");
        final JButton loadGame = new JButton("Load Game");
        final JButton howToPlay = new JButton("How to Play");
        
        starter.setLocation(400,180);
        starter.setResizable(false);
        starter.setSize(400, 340);
                
        panel.setBackground(Color.BLACK);
        
        startGame.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {

        		if (JOptionPane.showConfirmDialog(
        				starter, 
        				"Are you sure you want to start a New Game ?", 
        				"Confirm",
        				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        					
        			MainGUI gameMainGUI = new MainGUI("Urbain");
        			Thread gameThread = new Thread(gameMainGUI);
        			gameThread.start();
        					
        		}
        	}
          });
        
        loadGame.addActionListener(new ActionListener() {
            
        	public void actionPerformed(ActionEvent e) {
            }
          });
        
        howToPlay.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	ImageIcon char1 = new ImageIcon("img/character1.png");
                JOptionPane.showMessageDialog(starter,
                        "Here are the rules \n\n"+
                        "1) Choose a difficulty. \n" +
                        "2) Choose your Character(s). \n" +
                        "3) Make your Character's dreams real ! \n\n" +
                        "How to Play: \n\n" +
                        "Press z to move Up \n" +
                        "Press s to move Down \n" +
                        "Press q to move Left \n" +
                        "Press d to move Right \n" ,
                        "How to play" ,
                        JOptionPane.PLAIN_MESSAGE, char1);
            }
          });
		
        panel.add(startGame);
        panel.add(loadGame);
        panel.add(howToPlay);
		 
        starter.add(panel,BorderLayout.SOUTH);
        starter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        starter.setVisible(true);
    }

}
