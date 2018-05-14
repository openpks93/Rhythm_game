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
	private Graphics screenGraphic; //������۸� ���Ѱ�
	
	//���ȭ��
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground4.jpg")).getImage();
	
	//�޴���
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	//�������ư
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	
	
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
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
		
	}
	

}
