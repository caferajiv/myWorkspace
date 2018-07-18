package patterns.behavioural.command;

public class TVVolumeUpCommand implements Command{
	
	TV tv;
	public TVVolumeUpCommand(TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.volumeUpAction();
		
	}
	@Override
	public void undo() {
		tv.volumeDownAction();
	}

}
