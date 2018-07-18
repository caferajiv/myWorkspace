package patterns.behavioural.command;

public class TV {
	
	void onAction() {
		System.out.println("TV Switched On");
	}
	
	void offAction() {
		System.out.println("TV Switched Off");
	}
	
	void volumeUpAction() {
		System.out.println("TV Volume Up");
	}
	
	void volumeDownAction() {
		System.out.println("TV Volume Down");
	}

}
