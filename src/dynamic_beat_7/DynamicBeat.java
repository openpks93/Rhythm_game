package dynamic_beat_7;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic; //������۸� ���Ѱ�
	
	///////////////////////���ȭ�� �׸�/////////////////////////////
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground4.jpg"))
			.getImage();
	
	///////////////�޴��� �׸�/////////////////////////////////
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	//////////////////////////�������ư �׸�//////////////////
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	///////////////////////////�����ϱ��ư �׸�////////////////////////
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private JButton startButton = new JButton(startButtonBasicImage);

	/////////////////////////////�����ϱ� ��ư �׸�////////////////////////
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	///////////////////////���� ������ ��ư////////////////////
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private JButton rightButton = new JButton(rightButtonBasicImage);

	///////////////�� ���α׷������� ���콺�� ��ǥ�� ��Ÿ����
	private int mouseX, mouseY; 
	
	//////////////////ó������ ���� ȭ���� �ƴ� ����ȭ�� �̶� 
	private boolean isMainScreen = false;
	
	//////////////////////Ʈ���̶�� Ŭ�󽺸� ��� ��� �������� ���� �� �ִ� �迭�̴�
	ArrayList<Track> trackList = new ArrayList<Track>(); 
	
	//���ӿ� �ش��ϴ� ����ȭ��
	private Image selectedImage;

	///////////////////�� ���� ������///////////////
	private Image titleImage;
	
	///////////////��������//////////////////
	private Music selectedMusic;
	private int nowSelected = 0; //���ñ����� �ǹ�
	
	
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
		
		//////////////��������
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
				
		///////////////////////Ʈ������////////////////
		//Believer   0���� �ε��� �ʵ� ��
		trackList.add(new Track("BelieverTitle.png", "BelieverStart.jpg",
				"BelieverGame.jpg","Believer Selected.mp3","Believer.mp3")); 
		//Best Mistake ù���� �ε��� �ʵ� ��
		trackList.add(new Track("BestMistakeTitle.png", "BestMistakeStart.jpg",
				"BestMistakeGame.jpg","BestMistake Selected.mp3","BestMistake.mp3"));
		//IF(���࿡) �ι��� �ε��� �ʵ� ��
		trackList.add(new Track("IfTitle.png", "IfStart.jpg",
				"IfGame.jpg","If Selected.mp3","If.mp3"));
		//Round and Round -�Ѽ���
		trackList.add(new Track("Round and Round Title.png", "Round and Round Start.jpg",
				"Round and Round Game.jpg","Round and Round Selected.mp3","Round and Round.mp3"));
		//the four season ��� - �ź���
		trackList.add(new Track("the four season Title.png", "the four season Start.jpg", "the four season Game.jpg",
				"the four season Selected.mp3", "the four season.mp3"));
		//Danza Kuduro -�г��� ����5 ost
		trackList.add(new Track("Danza Kuduro Title.png", "Danza Kuduro Start.jpg", "Danza Kuduro Game.jpg",
				"Danza Kuduro Selected.mp3", "Danza Kuduro.mp3"));
		//Let It Go - �ܿ�ձ� ost
		trackList.add(new Track("Let It Go Title.png", "Let It Go Start.jpg", "Let It Go Game.jpg",
				"Let It Go Selected.mp3", "Let It Go.mp3"));
		
		
		
		//////////////////////������ ��ư ��ġ�� ũ�� ����//////////////////
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
				
				////////////////////////////���� ��ư ����� ��ġ ����///////////////
				leftButton.setVisible(false);
				leftButton.setBounds(140, 310, 60, 60);
				leftButton.setBorderPainted(false); // 
				leftButton.setContentAreaFilled(false);
				leftButton.setFocusPainted(false);
				leftButton.addMouseListener(new MouseAdapter(){
					@Override //���콺�� ��� ���� ��
					public void mouseEntered(MouseEvent e){
						leftButton.setIcon(leftButtonEnteredImage);
						
						//���콺�� ��ư������ ������ �ո������ �ٲ��
						leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
						
					}
					
					@Override //���콺�� ������ ��
					public void mouseExited(MouseEvent e){
						leftButton.setIcon(leftButtonBasicImage);
						
						//���콺�� �������� ������ ������� ���ƿ´�
						leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						
					}
					
					@Override // ���콺�� ���� ��ư�� ������ ��
					public void mousePressed(MouseEvent e){
						Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
						buttonPressedMusic.start();
						//���ʹ�ư �̺�Ʈ
						selectLeft();
					}
				});
				add(leftButton);
				
				//������ ��ư ����� ��ġ ����
				rightButton.setVisible(false);
				rightButton.setBounds(1080, 310, 60, 60);
				rightButton.setBorderPainted(false); // 
				rightButton.setContentAreaFilled(false);
				rightButton.setFocusPainted(false);
				rightButton.addMouseListener(new MouseAdapter(){
					@Override //���콺�� ��� ���� ��
					public void mouseEntered(MouseEvent e){
						rightButton.setIcon(rightButtonEnteredImage);
						
						//���콺�� ��ư������ ������ �ո������ �ٲ��
						rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
						
						//���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
						Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
						buttonEnteredMusic.start();
						
					}
					
					@Override //���콺�� ������ ��
					public void mouseExited(MouseEvent e){
						rightButton.setIcon(rightButtonBasicImage);
						
						//���콺�� �������� ������ ������� ���ƿ´�
						rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						
					}
					
					@Override // ���콺�� ���� ��ư�� ������ ��
					public void mousePressed(MouseEvent e){
						Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
						buttonPressedMusic.start();
						//�����ʹ�ư �̺�Ʈ
						selectRight();
					}
				});
				add(rightButton);
				
				////////////////�����ϱ� ��ư ����///////////////////////
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
						introMusic.close(); //�������� ����
						selectTrack(0);//Ʈ���� ���� �����ش�
						//////���� ���� �̺�Ʈ
						startButton.setVisible(false); //�����ϱ� ��ư�� ������ �ʰ� �Ѵ�
						quitButton.setVisible(false); //�����ϱ� ��ư�� ������ �ʰ� �Ѵ�
						leftButton.setVisible(true); //���ʹ�ư ���̰�
						rightButton.setVisible(true); //�����ʹ�ư ���̰� 
						background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
								.getImage(); // ���� �����ϱ� ȭ��
						isMainScreen = true;
					}
				});
				add(startButton);
				
				////////////////////////�������ư///////////////////////
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
				
		////////////////////////////�޴��� ��ġ�� ũ�� ����////////////////////////
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
	
	}
	///////////////////////////////////////////////////////////////////
	@Override
	public void paint(Graphics g){
		screenImage = createImage(Main.SCREAN_WIDTH, Main.SCREAN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}
	public void screenDraw(Graphics g){
		g.drawImage(background, 0, 0, null); //add���� ���� �ƴ϶� �ܼ��� �̹����� ������
		if(isMainScreen){
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g); //���� �����ӿ� �߰��� ��Ҹ� �����ش� add�� ������
		this.repaint();
		
	}
	
	//���� ���õ� ���� ��ȣ�� �Ű���
	public void selectTrack(int nowSelected){
		if(selectedMusic != null)
			selectedMusic.close(); //��� ���� ����ǰ� �ִٸ� ���������
		//�̹�������
		titleImage = new ImageIcon(Main.class.getResource
				("../images/" + trackList.get(nowSelected).getTitleImage())).getImage(); //���� ���õ� ������ �̹����� ������
		selectedImage = new ImageIcon(Main.class.getResource
				("../images/" + trackList.get(nowSelected).getStartImage())).getImage(); //���� ���õ� ������ ������ ������
		//���Ǻ���
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	//���ʹ�ư �̺�Ʈ ��
	public void selectLeft(){
		if(nowSelected == 0)
			nowSelected = trackList.size() -1;
		else
			nowSelected--;
		selectTrack(nowSelected);		
	}

	//�����ʹ�ư�̺�Ʈ ��
	public void selectRight(){
		if(nowSelected == trackList.size() -1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

}
