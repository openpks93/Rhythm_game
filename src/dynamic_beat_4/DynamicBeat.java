package dynamic_beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic; //더블버퍼를 위한것
	
	//배경화면
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground4.jpg")).getImage();
	
	//메뉴바
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	//나가기버튼
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	
	
	//현 프로그램에서의 마우스의 좌표를 나타낸다
	private int mouseX, mouseY; 
	
	public DynamicBeat(){
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREAN_WIDTH, Main.SCREAN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		//나가기 버튼 위치와 크기 설정
				exitButton.setBounds(1245, 0, 30, 30);
				exitButton.setBorderPainted(false); // 
				exitButton.setContentAreaFilled(false);
				exitButton.setFocusPainted(false);
				exitButton.addMouseListener(new MouseAdapter(){
					@Override //마우스가 들어 갔을 때
					public void mouseEntered(MouseEvent e){
						exitButton.setIcon(exitButtonEnteredImage);
						
						//마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
						exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
						
					}
					
					@Override //마우스가 나왔을 때
					public void mouseExited(MouseEvent e){
						exitButton.setIcon(exitButtonBasicImage);
						
						//마우스가 나왔을때 원래의 모습으로 돌아온다
						exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						
					}
					
					@Override // 마우스가 종료 버튼을 눌렀을 때
					public void mousePressed(MouseEvent e){
						Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
						buttonPressedMusic.start();
						try{
							//버튼을 누를고 1초 정도 있다가 종료시킴
							Thread.sleep(1000);
						}catch(InterruptedException ex){
							ex.printStackTrace();
							
						}
						System.exit(0);
					}
				});
				add(exitButton);
		
		//메뉴바 위치와 크기 설정
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY(); //마우스리스너
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	@Override
	public void paint(Graphics g){
		screenImage = createImage(Main.SCREAN_WIDTH, Main.SCREAN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}
	public void screenDraw(Graphics g){
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
		
	}
	

}
