package patterns.behavioural.command;

public class TVOnCommand implements Command{

	TV tv ;

	public TVOnCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.onAction();
	}

	@Override
	public void undo() {
		tv.offAction();

	}

}
