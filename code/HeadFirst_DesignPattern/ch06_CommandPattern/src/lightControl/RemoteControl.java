public class RemoteControl {
	Command slot;
	
	public void setCommand(Command cmd){ this.slot = cmd; }
	public void lightOnPressed(){ slot.execute(); }
}
