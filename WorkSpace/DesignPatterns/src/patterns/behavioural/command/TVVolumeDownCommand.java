package patterns.behavioural.command;

public class TVVolumeDownCommand implements Command {

	TV tv;
	
	public TVVolumeDownCommand(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		tv.volumeDownAction();
		
	}

	@Override
	public void undo() {
		tv.volumeUpAction();
		
	}

}
