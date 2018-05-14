package dynamic_beat_14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();

	private int x, y = 580 - (1000/Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; // 노트의 위치
	private String noteType;

	public Note(String noteType) {
		if(noteType.equals("S")){
			x = 228;
		}
		else if(noteType.equals("D")){
			x = 332;
		}
		else if(noteType.equals("F")){
			x = 436;
		}
		else if(noteType.equals("Space")){
			x = 540;
		}
		else if(noteType.equals("J")){
			x = 744;
		}
		else if(noteType.equals("K")){
			x = 848;
		}
		else if(noteType.equals("L")){
			x = 952;
		}
		this.noteType = noteType;
		
	}

	public void screenDraw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} 
		else{
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}
	
	//노트 떨어지는거
	public void drop(){
		y += Main.NOTE_SPEED;
	}
	
	@Override 
	public void run(){
		try{
			while(true){
				drop();
				Thread.sleep(Main.SLEEP_TIME); //sleep time 만큼 쉴수있게
			}
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}

}
