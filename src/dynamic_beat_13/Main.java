package dynamic_beat_13;

public class Main {
	
	//화면 크기 설정 final을 사용한 이유는 고정으로 설정 햇기때문 바뀌지 않는다!!
	public static final int SCREAN_WIDTH =1280;
	public static final int SCREAN_HEIGHT=720; 
	
	//노트 속도 설정
	public static final int NOTE_SPEED= 7;
	public static final int SLEEP_TIME = 10; // 노트가 무한정 떨어지는것을 막아준다

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new DynamicBeat();

	}

}
