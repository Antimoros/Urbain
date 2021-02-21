package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;
import engine.process.StatiqueElementManager;


public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	
	private final static Dimension mainGUISize = new Dimension(ResponsiveMode.responsiveScreenSize);
	
	private final static Dimension dashboardSize = new Dimension(ResponsiveMode.screenWidth, ResponsiveMode.screenHeight);
	private final static Dimension hudSize = new Dimension(ResponsiveMode.screenWidth, ResponsiveMode.screenHeight/8);
	private final static Dimension eventSize = new Dimension(ResponsiveMode.screenWidth/12, ResponsiveMode.screenHeight);
	
	
	private GameDisplay dashboard;
	private HudDisplay hud;
	private EventDisplay event;
	
	private Map map;
	private MobileElementManager manager;
	private StatiqueElementManager managerStatique;

	public MainGUI(String title) {
		super(title);
		Image logo = Toolkit.getDefaultToolkit().getImage("img/character1.png");
		setIconImage(logo);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);

		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		managerStatique = GameBuilder.buildInitStatique(map);
		
		dashboard = new GameDisplay(map, manager, managerStatique);
		hud = new HudDisplay();
		event = new EventDisplay();

		MouseControls mouseControls = new MouseControls();
		
		dashboard.addMouseListener(mouseControls);
		hud.addMouseListener(mouseControls);
		event.addMouseListener(mouseControls);

		dashboard.setPreferredSize(dashboardSize);
		contentPane.add(dashboard, BorderLayout.CENTER);
		
		hud.setPreferredSize(hudSize);
		contentPane.add(hud, BorderLayout.SOUTH);
		
		event.setPreferredSize(eventSize);
		contentPane.add(event, BorderLayout.EAST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(mainGUISize);
		setResizable(true);
	}

	@Override
	public void run() {
		
		managerStatique.generateBuilding();
		
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			manager.nextRound();
			dashboard.repaint();
			hud.repaint();
			event.repaint();
		}
	}

	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

			case 'q':
				manager.moveLeftMovableCharacter();
	
				break;
			case 'd':
				manager.moveRightMovableCharacter();

				break;
			case 'z':
				manager.moveUpMovableCharacter();
				
				break;
			case 's':
				manager.moveDownMovableCharacter();
				
				break;
			case 'm':
				manager.generateLoot();
				
			case '4':
				manager.moveLeftMovableCharacter2();
	
				break;
			case '6':
				manager.moveRightMovableCharacter2();

				break;
			case '8':
				manager.moveUpMovableCharacter2();
				
				break;
			case '5':
				manager.moveDownMovableCharacter2();
				
				break;
				
				
				
			case 'j':
				manager.moveLeftMovableCharacter3();
	
				break;
			case 'l':
				manager.moveRightMovableCharacter3();

				break;
			case 'i':
				manager.moveUpMovableCharacter3();
				
				break;
			case 'k':
				manager.moveDownMovableCharacter3();
				
				break;
				
				
				
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

}
