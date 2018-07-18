package patterns.behavioural.command;

public class TVOffCommand  implements Command{

	TV tv;
	
	public TVOffCommand(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		tv.offAction();
		
	}

	@Override
	public void undo() {

		tv.onAction();
	}

}
