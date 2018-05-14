package dynamic_beat_16;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	private Graphics screenGraphic; // 더블버퍼를 위한것

	/////////////////////// 배경화면 그림/////////////////////////////
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground4.jpg")).getImage();

	/////////////// 메뉴바 그림/////////////////////////////////
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	////////////////////////// 나가기버튼 그림//////////////////
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	/////////////////////////// 시작하기버튼 그림////////////////////////
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private JButton startButton = new JButton(startButtonBasicImage);

	///////////////////////////// 종료하기 버튼 그림////////////////////////
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private JButton quitButton = new JButton(quitButtonBasicImage);

	/////////////////////// 왼쪽 오른쪽 버튼////////////////////
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private JButton rightButton = new JButton(rightButtonBasicImage);

	// 난이도 설정 이미지 및 버튼
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private JButton hardButton = new JButton(hardButtonBasicImage);

	// 뒤로가기 버튼 및 이미지
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private JButton backButton = new JButton(backButtonBasicImage);

	/////////////// 현 프로그램에서의 마우스의 좌표를 나타낸다
	private int mouseX, mouseY;

	////////////////// 처음에는 메인 화면이 아닌 시작화면 이라서
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	////////////////////// 트랙이라는 클라스를 사용 어떠한 변수들을 담을 수 있는 배열이다
	ArrayList<Track> trackList = new ArrayList<Track>();

	// 게임에 해당하는 시작화면
	private Image selectedImage;

	/////////////////// 곡 명을 보여줌///////////////
	private Image titleImage;

	/////////////// 선택음악//////////////////
	private Music selectedMusic;
	private int nowSelected = 0; // 선택괸곳을 의미

	private Music introMusic = new Music("introMusic.mp3", true); // 외부에서 선언해야
																	// 다른데서도 사용이
																	// 가능
	public static Game game;

	public DynamicBeat() {
		
		///////////////////////////////////////////////// 트랙설정///////////////////////////////////////////////////
		// Believer 0번쨰 인덱스 필드 값
		trackList.add(new Track("BelieverTitle.png", "BelieverStart.jpg", "BelieverGame.jpg", "Believer Selected.mp3",
				"Believer.mp3", "BELIEVER - Images Dragon"));
		// Best Mistake 첫번쨰 인덱스 필드 값
		trackList.add(new Track("BestMistakeTitle.png", "BestMistakeStart.jpg", "BestMistakeGame.jpg",
				"BestMistake Selected.mp3", "BestMistake.mp3", "Best Mistake - Ariana Grande"));
		// IF(만약에) 두번쨰 인덱스 필드 값
		trackList.add(new Track("IfTitle.png", "IfStart.jpg", "IfGame.jpg", "If Selected.mp3", 
				"If.mp3", "If - 권인하"));
		// Round and Round -한수지
		trackList.add(new Track("Round and Round Title.png", "Round and Round Start.jpg", "Round and Round Game.jpg",
				"Round and round Selected.mp3", "Round and round.mp3", "Round and Round(도꺠비OST) - 한수지"));
		// the four season 사계 - 거북이
		trackList.add(new Track("the four season Title.png", "the four season Start.jpg", "the four season Game.jpg",
				"the four season Selected.mp3", "the four season.mp3", "the four season - 거북이"));
		// Danza Kuduro -분노의 질주5 ost
		trackList.add(new Track("Danza Kuduro Title.png", "Danza Kuduro Start.jpg", "Danza Kuduro Game.jpg",
				"Danza Kuduro Selected.mp3", "Danza Kuduro.mp3", "Danza Kuduro(분노의 질주OST)"));
		// Let It Go - 겨울왕국 ost
		trackList.add(new Track("Let It Go Title.png", "Let It Go Start.jpg", "Let It Go Game.jpg",
				"Let It Go Selected.mp3", "Let It Go.mp3", "Let It Go(겨울왕국OST)"));
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREAN_WIDTH, Main.SCREAN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener()); // 입력키 받기

		////////////// 메인음악
		// Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		////////////////////// 나가기 버튼 위치와 크기 설정//////////////////
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false); //
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);

				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					// 버튼을 누를고 1초 정도 있다가 종료시킴
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		//////////////////////////// 왼쪽 버튼 실행과 위치 설정///////////////
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false); //
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// 왼쪽버튼 이벤트
				selectLeft();
			}
		});
		add(leftButton);

		// 오른쪽 버튼 실행과 위치 설정
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false); //
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);

				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// 오른쪽버튼 이벤트
				selectRight();
			}
		});
		add(rightButton);

		////////////////// easy mode 실행
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setBorderPainted(false); //
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);

				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// easy mode 이벤트
				gameStart(nowSelected, "Easy");
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
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);

				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// hard mode 이벤트
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);

		// 뒤로가기 버튼
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false); //
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);

				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// back button 이벤트
				backMain();
			}
		});
		add(backButton);

		//////////////// 시작하기 버튼 실행///////////////////////
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false); //
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);

				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();

				enterMain(); // enterMain함수를 불러서 사용해준다

				/*
				 * introMusic.close(); //메인음악 종료 selectTrack(0);//트랙을 실행 시켜준다
				 * 
				 * //////게임 시작 이벤트 startButton.setVisible(false); //시작하기 버튼이 보이지
				 * 않게 한다 quitButton.setVisible(false); //종료하기 버튼이 보이지 않게 한다
				 * leftButton.setVisible(true); //왼쪽버튼 보이게
				 * rightButton.setVisible(true); //오른쪽버튼 보이게
				 * easyButton.setVisible(true); //easy mode 버튼 보이게
				 * hardButton.setVisible(true); //hard mode 버튼 보이게 background =
				 * new ImageIcon(Main.class.getResource(
				 * "../images/mainBackground.jpg")) .getImage(); // 게임 시작하기 화면
				 * isMainScreen = true;
				 */ // --> 보기 안좋아서 이것을 함수로 만들어야함
			}
		});
		add(startButton);

		//////////////////////// 나가기버튼///////////////////////
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false); //
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 들어 갔을 때
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);

				// 마우스가 버튼쪽으로 갔을때 손모양으로 바뀐다
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

				// 마우스 버튼이 들어갔을때 음악이 나오게 한다 false 값을 준것은 단 한번만 실행시키기 위함
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override // 마우스가 나왔을 때
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);

				// 마우스가 나왔을때 원래의 모습으로 돌아온다
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스가 종료 버튼을 눌렀을 때
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					// 버튼을 누를고 1초 정도 있다가 종료시킴
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();

				}
				System.exit(0);
			}
		});
		add(quitButton);

		//////////////////////////// 메뉴바 위치와 크기 설정////////////////////////
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY(); // 마우스리스너
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
		g.drawImage(background, 0, 0, null); // add가된 것이 아니라 단순히 이미지만 보여줌
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if (isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g); // 메인 프레임에 추가된 요소를 보여준다 add를 보여줌
		try{
			Thread.sleep(5);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.repaint();

	}

	// 현제 선택된 곳의 번호를 매겨줌
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close(); // 어떠한 곡이 실행되고 있다면 종료시켜줌
		// 이미지변경
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage(); // 현제 선택된 음악의 이미지를 보여줌
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage(); // 현재 선택된 음악의 제목을 보여줌
		// 음악변경
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	// 왼쪽버튼 이벤트 상세
	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	// 오른쪽버튼이벤트 상세
	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

	/////////////////////////// 게임진행화면
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		// 각각의 버튼이 보이면 안됨 그래서 false값을 준다
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
	    game.start();	
		setFocusable(true); // 게임을 시작했을 때 메인에 키포드 포커스가 맞추어져야함

	}
	
	////////////////////////////

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
		game.close(); //게임을 종료시켜줌
	}

	public void enterMain() {
		startButton.setVisible(false); // 시작하기 버튼이 보이지 않게 한다
		quitButton.setVisible(false); // 종료하기 버튼이 보이지 않게 한다
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); // 게임
																										// 시작하기
																										// 화면
		isMainScreen = true;
		leftButton.setVisible(true); // 왼쪽버튼 보이게
		rightButton.setVisible(true); // 오른쪽버튼 보이게
		easyButton.setVisible(true); // easy mode 버튼 보이게
		hardButton.setVisible(true); // hard mode 버튼 보이게
		introMusic.close(); // 그냥하면 에러가 난다 introMusic은 안에서 선언되었기 때문에 똑같이 외부로 빼준다
		selectTrack(0);
	}

}
