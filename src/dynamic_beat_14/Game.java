package dynamic_beat_14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	// ���ӻ��� �̹���
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	
	/////////////////////
	private String titleName; //���� �̸�
	private String difficulty; //���̵� ����
	private String musicTitle;
	private Music gameMusic;
	
	//��Ʈ ���� �ޱ�
	ArrayList<Note> noteList = new ArrayList<Note>();
	private boolean dropped;
	
	/////////���ӽ���
	public Game(String titleName, String difficulty, String musicTitle){
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	///////////////���ӻ� ����(�̹��� �ޱ�)
	public void screenDraw(Graphics2D g){
		//
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		
		//
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
		
		//��Ʈ�̹��� ��
		for(int i =0; i< noteList.size(); i++) //��Ʈ�� ������ ��ŭ �޴´�
		{
			Note note = noteList.get(i);		
			note.screenDraw(g);
		}
		
		//Ű �̸� �� �뷡 �̸� ���� ��
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702); //���� �̸�
		g.drawString(difficulty, 1190, 702); //���� ���̵�
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
	
	public void pressS(){
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void releaseS(){
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void pressD(){
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void releaseD(){
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void pressF(){
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void releaseF(){
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void pressSpace(){
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void releaseSpace(){
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void pressJ(){
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void releaseJ(){
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void pressK(){
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void releaseK(){
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void pressL(){
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void releaseL(){
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	@Override
	public void run(){
		dropNotes();
	}
	
	//������ ���������
	public void close(){
		gameMusic.close();
		this.interrupt(); 
	}
	
	//��Ʈ����
	public void dropNotes(){
		Beat[] beats = null;
		if(titleName.equals("BELIEVER - Images Dragon")){
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(1250, "S"),
					new Beat(1550, "S"),
					new Beat(1850, "S"),
					new Beat(2150, "S"),
					new Beat(2450, "S"),
					new Beat(2750, "S"),
					new Beat(3050, "S"),
					new Beat(3350, "S"),
					new Beat(4285, "L"),// ���� 4.3��
					new Beat(4350, "S"),
					new Beat(4750, "S"),
					new Beat(5050, "S"),
					new Beat(5350, "S"),
					new Beat(5650, "S"),
					new Beat(5950, "S"),
					new Beat(6250, "L"),
					new Beat(6550, "S"),
					new Beat(6850, "D"),
					new Beat(7150, "D"),
					new Beat(7450, "D"),
					new Beat(7750, "D"),
			};
		}
		else if(titleName.equals("Best Mistake - Ariana Grande")){
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(startTime, "S"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*4, "S"),
					new Beat(startTime + gap*6, "S"),
					new Beat(startTime + gap*8, "S"),
					new Beat(startTime + gap*10, "S"),
					new Beat(startTime + gap*12, "S"),
			};

		}
		else if(titleName.equals("If - ������")){
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(startTime, "S"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*4, "S"),
					new Beat(startTime + gap*6, "S"),
					new Beat(startTime + gap*8, "S"),
					new Beat(startTime + gap*10, "S"),
					new Beat(startTime + gap*12, "S"),
			};

		}
		else if(titleName.equals("Round and Round(���ƺ�OST) - �Ѽ���")){
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(startTime, "S"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*4, "S"),
					new Beat(startTime + gap*6, "S"),
					new Beat(startTime + gap*8, "S"),
					new Beat(startTime + gap*10, "S"),
					new Beat(startTime + gap*12, "S"),
			};
		}
		else if(titleName.equals("the four season - �ź���")){
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(startTime, "S"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*4, "S"),
					new Beat(startTime + gap*6, "S"),
					new Beat(startTime + gap*8, "S"),
					new Beat(startTime + gap*10, "S"),
					new Beat(startTime + gap*12, "S"),
			};
		}
		else if(titleName.equals("Danza Kuduro(�г��� ����OST)")){
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(startTime, "S"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*4, "S"),
					new Beat(startTime + gap*6, "S"),
					new Beat(startTime + gap*8, "S"),
					new Beat(startTime + gap*10, "S"),
					new Beat(startTime + gap*12, "S"),
			};
		}
		else if(titleName.equals("Let It Go(�ܿ�ձ�OST)")){
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(startTime, "S"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*4, "S"),
					new Beat(startTime + gap*6, "S"),
					new Beat(startTime + gap*8, "S"),
					new Beat(startTime + gap*10, "S"),
					new Beat(startTime + gap*12, "S"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()){
			if(beats[i].getTime() <= gameMusic.getTime()){
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped){
				try{
					Thread.sleep(5);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}
