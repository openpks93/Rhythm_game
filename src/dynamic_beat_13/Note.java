package dynamic_beat_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();

	private int x, y = 580 - 1000/Main.SLEEP_TIME * Main.NOTE_SPEED; // ��Ʈ�� ��ġ
	private String noteType;

	public Note(int x, /*int y, */String noteType) {
		this.x = x;
		//this.y = y;
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		if (noteType.equals("short")) {
			g.drawImage(noteBasicImage, x, y, null);
		} 
		else if (noteType.equals("long")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}
	
	//��Ʈ �������°�
	public void drop(){
		y += Main.NOTE_SPEED;
	}
	
	@Override 
	public void run(){
		try{
			while(true){
				drop();
				Thread.sleep(Main.SLEEP_TIME); //sleep time ��ŭ �����ְ�
			}
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}

}
