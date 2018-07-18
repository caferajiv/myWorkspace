package patterns.behavioural.command;

public class LightOnCommand implements Command{

	Light light;
	public LightOnCommand(Light light) {
		this.light = light;
	}
	@Override
	public void execute() {
		light.onAction();
		
	}

	@Override
	public void undo() {
		light.offAction();
		
	}

}
