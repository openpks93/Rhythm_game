package dynamic_beat_5;

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
	
	//배경화면 그림
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground4.jpg")).getImage();
	
	//메뉴바 그림
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	//나가기버튼 그림
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	//시작하기버튼 그림
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private JButton startButton = new JButton(startButtonBasicImage);

	//종료하기 버튼 그림
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private JButton quitButton = new JButton(quitButtonBasicImage);

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
				
				//시작하기 버튼 실행
				startButton.setBounds(40, 200, 400, 100);
				startButton.setBorderPainted(false); // 
				startButton.setContentAreaFilled(false);
				startButton.setFocusPainted(false);
				startButton.addMouseListener(new MouseAdapter(){
					@Override //마우스가 들어 갔을 때
					public void mouseEntered(MouseEvent e){
						startButton.setIcon(startButtonEnteredImage);
						
						//마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
						startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
						
					}
					
					@Override //마우스가 나왔을 때
					public void mouseExited(MouseEvent e){
						startButton.setIcon(startButtonBasicImage);
						
						//마우스가 나왔을때 원래의 모습으로 돌아온다
						startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						
					}
					
					@Override // 마우스가 종료 버튼을 눌렀을 때
					public void mousePressed(MouseEvent e){
						Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
						buttonPressedMusic.start();
						
						//////게임 시작 이벤트
						startButton.setVisible(false); //시작하기 버튼이 보이지 않게 한다
						quitButton.setVisible(false); //종료하기 버튼이 보이지 않게 한다
						background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
								.getImage(); // 게임 시작하기 화면
					}
				});
				add(startButton);
				
				//나가기버튼
				quitButton.setBounds(40, 330, 400, 100);
				quitButton.setBorderPainted(false); // 
				quitButton.setContentAreaFilled(false);
				quitButton.setFocusPainted(false);
				quitButton.addMouseListener(new MouseAdapter(){
					@Override //마우스가 들어 갔을 때
					public void mouseEntered(MouseEvent e){
						quitButton.setIcon(quitButtonEnteredImage);
						
						//마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
						quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
											}
					
					@Override //마우스가 나왔을 때
					public void mouseExited(MouseEvent e){
						quitButton.setIcon(quitButtonBasicImage);
						
						//마우스가 나왔을때 원래의 모습으로 돌아온다
						quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));						
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
				add(quitButton);
				
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
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
		
	}
	

}
