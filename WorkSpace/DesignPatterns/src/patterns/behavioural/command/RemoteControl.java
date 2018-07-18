package patterns.behavioural.command;

public class RemoteControl {
	
	public static void main(String[] args) {
		TV tv = new TV();
		
		Command tvOnCommand = new TVOnCommand(tv);
		
		Command tvOffCommand = new TVOffCommand(tv);
		
		Button tvOnButton = new Button(tvOnCommand);
		tvOnButton.press();
		
		Button tvOffButton = new Button(tvOffCommand);
		tvOffButton.press();
	}
	
	
	
	
	static class Button {
		
		Command command;
		
		public Button(Command command) {
			this.command = command;
		}
		void press() {
			command.execute();
		}
	}
	

}
