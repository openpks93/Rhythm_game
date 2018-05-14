package dynamic_beat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic; // ������۸� ���Ѱ�

	/////////////////////// ���ȭ�� �׸�/////////////////////////////
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground4.jpg")).getImage();

	/////////////// �޴��� �׸�/////////////////////////////////
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	////////////////////////// �������ư �׸�//////////////////
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	/////////////////////////// �����ϱ��ư �׸�////////////////////////
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private JButton startButton = new JButton(startButtonBasicImage);

	///////////////////////////// �����ϱ� ��ư �׸�////////////////////////
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private JButton quitButton = new JButton(quitButtonBasicImage);

	/////////////////////// ���� ������ ��ư////////////////////
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private JButton rightButton = new JButton(rightButtonBasicImage);

	// ���̵� ���� �̹��� �� ��ư
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private JButton hardButton = new JButton(hardButtonBasicImage);

	// �ڷΰ��� ��ư �� �̹���
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private JButton backButton = new JButton(backButtonBasicImage);

	// ���ӻ��� �̹���
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();

	/////////////// �� ���α׷������� ���콺�� ��ǥ�� ��Ÿ����
	private int mouseX, mouseY;

	////////////////// ó������ ���� ȭ���� �ƴ� ����ȭ�� �̶�
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	////////////////////// Ʈ���̶�� Ŭ�󽺸� ��� ��� �������� ���� �� �ִ� �迭�̴�
	ArrayList<Track> trackList = new ArrayList<Track>();

	// ���ӿ� �ش��ϴ� ����ȭ��
	private Image selectedImage;

	/////////////////// �� ���� ������///////////////
	private Image titleImage;

	/////////////// ��������//////////////////
	private Music selectedMusic;
	private int nowSelected = 0; // ���ñ����� �ǹ�

	private Music introMusic = new Music("introMusic.mp3", true); // �ܺο��� �����ؾ�
																	// �ٸ������� �����
																	// ����

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREAN_WIDTH, Main.SCREAN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		////////////// ��������
		// Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();

		/////////////////////// Ʈ������////////////////
		// Believer 0���� �ε��� �ʵ� ��
		trackList.add(new Track("BelieverTitle.png", "BelieverStart.jpg", "BelieverGame.jpg", "Believer Selected.mp3",
				"Believer.mp3"));
		// Best Mistake ù���� �ε��� �ʵ� ��
		trackList.add(new Track("BestMistakeTitle.png", "BestMistakeStart.jpg", "BestMistakeGame.jpg",
				"BestMistake Selected.mp3", "BestMistake.mp3"));
		// IF(���࿡) �ι��� �ε��� �ʵ� ��
		trackList.add(new Track("IfTitle.png", "IfStart.jpg", "IfGame.jpg", "If Selected.mp3", "If.mp3"));
		// Round and Round -�Ѽ���
		trackList.add(new Track("Round and Round Title.png", "Round and Round Start.jpg", "Round and Round Game.jpg",
				"Round and round Selected.mp3", "Round and round.mp3"));
		// the four season ��� - �ź���
		trackList.add(new Track("the four season Title.png", "the four season Start.jpg", "the four season Game.jpg",
				"the four season Selected.mp3", "the four season.mp3"));
		// Danza Kuduro -�г��� ����5 ost
		trackList.add(new Track("Danza Kuduro Title.png", "Danza Kuduro Start.jpg", "Danza Kuduro Game.jpg",
				"Danza Kuduro Selected.mp3", "Danza Kuduro.mp3"));
		// Let It Go - �ܿ�ձ� ost
		trackList.add(new Track("Let It Go Title.png", "Let It Go Start.jpg", "Let It Go Game.jpg",
				"Let It Go Selected.mp3", "Let It Go.mp3"));

		////////////////////// ������ ��ư ��ġ�� ũ�� ����//////////////////
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false); //
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					// ��ư�� ������ 1�� ���� �ִٰ� �����Ŵ
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();

				}
				System.exit(0);
			}
		});
		add(exitButton);

		//////////////////////////// ���� ��ư ����� ��ġ ����///////////////
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false); //
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// ���ʹ�ư �̺�Ʈ
				selectLeft();
			}
		});
		add(leftButton);

		// ������ ��ư ����� ��ġ ����
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false); //
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// �����ʹ�ư �̺�Ʈ
				selectRight();
			}
		});
		add(rightButton);

		////////////////// easy mode ����
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setBorderPainted(false); //
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// easy mode �̺�Ʈ
				gameStart(nowSelected, "easy");

			}
		});
		add(easyButton);

		///////////////// hard mode
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);
		hardButton.setBorderPainted(false); //
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// hard mode �̺�Ʈ
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);

		// �ڷΰ��� ��ư
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false); //
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// back button �̺�Ʈ
				backMain();

			}
		});
		add(backButton);

		//////////////// �����ϱ� ��ư ����///////////////////////
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false); //
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();

				enterMain(); // enterMain�Լ��� �ҷ��� ������ش�

				/*
				 * introMusic.close(); //�������� ���� selectTrack(0);//Ʈ���� ���� �����ش�
				 * 
				 * //////���� ���� �̺�Ʈ startButton.setVisible(false); //�����ϱ� ��ư�� ������
				 * �ʰ� �Ѵ� quitButton.setVisible(false); //�����ϱ� ��ư�� ������ �ʰ� �Ѵ�
				 * leftButton.setVisible(true); //���ʹ�ư ���̰�
				 * rightButton.setVisible(true); //�����ʹ�ư ���̰�
				 * easyButton.setVisible(true); //easy mode ��ư ���̰�
				 * hardButton.setVisible(true); //hard mode ��ư ���̰� background =
				 * new ImageIcon(Main.class.getResource(
				 * "../images/mainBackground.jpg")) .getImage(); // ���� �����ϱ� ȭ��
				 * isMainScreen = true;
				 */ // --> ���� �����Ƽ� �̰��� �Լ��� ��������
			}
		});
		add(startButton);

		//////////////////////// �������ư///////////////////////
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false); //
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override // ���콺�� ��� ���� ��
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);

				// ���콺�� ��ư������ ������ �ո������ �ٲ��
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// ���콺 ��ư�� ������ ������ ������ �Ѵ� false ���� �ذ��� �� �ѹ��� �����Ű�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // ���콺�� ������ ��
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);

				// ���콺�� �������� ������ ������� ���ƿ´�
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ���콺�� ���� ��ư�� ������ ��
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					// ��ư�� ������ 1�� ���� �ִٰ� �����Ŵ
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();

				}
				System.exit(0);
			}
		});
		add(quitButton);

		//////////////////////////// �޴��� ��ġ�� ũ�� ����////////////////////////
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY(); // ���콺������
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

	}

	///////////////////////////////////////////////////////////////////
	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREAN_WIDTH, Main.SCREAN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); // add���� ���� �ƴ϶� �ܼ��� �̹����� ������
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if (isGameScreen) {
			g.drawImage(noteRouteImage, 228, 30, null);
			g.drawImage(noteRouteImage, 332, 30, null);
			g.drawImage(noteRouteImage, 436, 30, null);
			g.drawImage(noteRouteImage, 540, 30, null);
			g.drawImage(noteRouteImage, 640, 30, null);
			g.drawImage(noteRouteImage, 744, 30, null);
			g.drawImage(noteRouteImage, 848, 30, null);
			g.drawImage(noteRouteImage, 952, 30, null);
			g.drawImage(noteRouteLineImage, 224, 30, null);
			g.drawImage(noteRouteLineImage, 328, 30, null);
			g.drawImage(noteRouteLineImage, 432, 30, null);
			g.drawImage(noteRouteLineImage, 536, 30, null);
			g.drawImage(noteRouteLineImage, 740, 30, null);
			g.drawImage(noteRouteLineImage, 844, 30, null);
			g.drawImage(noteRouteLineImage, 948, 30, null);
			g.drawImage(noteRouteLineImage, 1052, 30, null);
			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgementLineImage, 0, 580, null);
			g.drawImage(noteBasicImage, 228, 120, null);
			g.drawImage(noteBasicImage, 332, 580, null);
			g.drawImage(noteBasicImage, 436, 500, null);
			g.drawImage(noteBasicImage, 540, 340, null);
			g.drawImage(noteBasicImage, 640, 340, null);
			g.drawImage(noteBasicImage, 744, 325, null);
			g.drawImage(noteBasicImage, 848, 305, null);
			g.drawImage(noteBasicImage, 952, 305, null);
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Images Dragon - BELIEVER", 20, 702);
			g.drawString("Easy", 1190, 702);
			g.setFont(new Font("Arial", Font.PLAIN, 26));
			g.setColor(Color.DARK_GRAY);
			g.drawString("S", 270, 609);
			g.drawString("D", 374, 609);
			g.drawString("F", 478, 609);
			g.drawString("Space Bar", 580, 609);
			g.drawString("J", 784, 609);
			g.drawString("K", 889, 609);
			g.drawString("L", 993, 609);
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Elephant", Font.BOLD, 30));
			g.drawString("000000", 565, 702);

		}
		paintComponents(g); // ���� �����ӿ� �߰��� ��Ҹ� �����ش� add�� ������
		this.repaint();

	}

	// ���� ���õ� ���� ��ȣ�� �Ű���
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close(); // ��� ���� ����ǰ� �ִٸ� ���������
		// �̹�������
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage(); // ���� ���õ� ������ �̹����� ������
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage(); // ���� ���õ� ������ ������ ������
		// ���Ǻ���
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	// ���ʹ�ư �̺�Ʈ ��
	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	// �����ʹ�ư�̺�Ʈ ��
	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

	////// ��������ȭ��
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		// ������ ��ư�� ���̸� �ȵ� �׷��� false���� �ش�
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
	}

	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}

	public void enterMain() {
		startButton.setVisible(false); // �����ϱ� ��ư�� ������ �ʰ� �Ѵ�
		quitButton.setVisible(false); // �����ϱ� ��ư�� ������ �ʰ� �Ѵ�
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); // ����
																										// �����ϱ�
																										// ȭ��
		isMainScreen = true;
		leftButton.setVisible(true); // ���ʹ�ư ���̰�
		rightButton.setVisible(true); // �����ʹ�ư ���̰�
		easyButton.setVisible(true); // easy mode ��ư ���̰�
		hardButton.setVisible(true); // hard mode ��ư ���̰�
		introMusic.close(); // �׳��ϸ� ������ ���� introMusic�� �ȿ��� ����Ǿ��� ������ �Ȱ��� �ܺη� ���ش�
		selectTrack(0);
	}

}
