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
	private Graphics screenGraphic; //������۸� ���Ѱ�
	
	//���ȭ�� �׸�
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground4.jpg")).getImage();
	
	//�޴��� �׸�
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	//�������ư �׸�
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	//�����ϱ��ư �׸�
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private JButton startButton = new JButton(startButtonBasicImage);

	//�����ϱ� ��ư �׸�
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private JButton quitButton = new JButton(quitButtonBasicImage);

	//�� ���α׷������� ���콺�� ��ǥ�� ��Ÿ����
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
		
		//������ ��ư ��ġ�� ũ�� ����
				exitButton.setBounds(1245, 0, 30, 30);
				exitButton.setBorderPainted(false); // 
				exitButton.setContentAreaFilled(false);
				exitButton.setFocusPainted(false);
				exitButton.addMouseListener(new MouseAdapter(){
					@Override //���콺�� ��� ���� ��
					public void mouseEntered(MouseEvent e){
						exitButton.setIcon(exitButtonEnteredImage);
						
						//���콺�� ��ư������ ������ �ո������ �ٲ��
						exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
						
					}
					
					@Override //���콺�� ������ ��
					public void mouseExited(MouseEvent e){
						exitButton.setIcon(exitButtonBasicImage);
						
						//���콺�� �������� ������ ������� ���ƿ´�
						exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						
					}
					
					@Override // ���콺�� ���� ��ư�� ������ ��
					public void mousePressed(MouseEvent e){
						Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
						buttonPressedMusic.start();
						try{
							//��ư�� ������ 1�� ���� �ִٰ� �����Ŵ
							Thread.sleep(1000);
						}catch(InterruptedException ex){
							ex.printStackTrace();
							
						}
						System.exit(0);
					}
				});
				add(exitButton);
				
				//�����ϱ� ��ư ����
				startButton.setBounds(40, 200, 400, 100);
				startButton.setBorderPainted(false); // 
				startButton.setContentAreaFilled(false);
				startButton.setFocusPainted(false);
				startButton.addMouseListener(new MouseAdapter(){
					@Override //���콺�� ��� ���� ��
					public void mouseEntered(MouseEvent e){
						startButton.setIcon(startButtonEnteredImage);
						
						//���콺�� ��ư������ ������ �ո������ �ٲ��
						startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
						
					}
					
					@Override //���콺�� ������ ��
					public void mouseExited(MouseEvent e){
						startButton.setIcon(startButtonBasicImage);
						
						//���콺�� �������� ������ ������� ���ƿ´�
						startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						
					}
					
					@Override // ���콺�� ���� ��ư�� ������ ��
					public void mousePressed(MouseEvent e){
						Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
						buttonPressedMusic.start();
						
						//////���� ���� �̺�Ʈ
						startButton.setVisible(false); //�����ϱ� ��ư�� ������ �ʰ� �Ѵ�
						quitButton.setVisible(false); //�����ϱ� ��ư�� ������ �ʰ� �Ѵ�
						background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
								.getImage(); // ���� �����ϱ� ȭ��
					}
				});
				add(startButton);
				
				//�������ư
				quitButton.setBounds(40, 330, 400, 100);
				quitButton.setBorderPainted(false); // 
				quitButton.setContentAreaFilled(false);
				quitButton.setFocusPainted(false);
				quitButton.addMouseListener(new MouseAdapter(){
					@Override //���콺�� ��� ���� ��
					public void mouseEntered(MouseEvent e){
						quitButton.setIcon(quitButtonEnteredImage);
						
						//���콺�� ��ư������ ������ �ո������ �ٲ��
						quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
											}
					
					@Override //���콺�� ������ ��
					public void mouseExited(MouseEvent e){
						quitButton.setIcon(quitButtonBasicImage);
						
						//���콺�� �������� ������ ������� ���ƿ´�
						quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));						
					}
					
					@Override // ���콺�� ���� ��ư�� ������ ��
					public void mousePressed(MouseEvent e){
						Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
						buttonPressedMusic.start();
						try{
							//��ư�� ������ 1�� ���� �ִٰ� �����Ŵ
							Thread.sleep(1000);
						}catch(InterruptedException ex){
							ex.printStackTrace();
							
						}
						System.exit(0);
					}
				});
				add(quitButton);
				
		//�޴��� ��ġ�� ũ�� ����
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY(); //���콺������
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
