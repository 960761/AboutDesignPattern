public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;
	
	public RemoteControl(){
		onCommands = new Command[4];
		offCommands = new Command[4];
		Command noCommand = new NoCommand();
		
		for(int i=0; i&lt;4; i++){
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}	
	
	public void setCommand(int slot, Command on, Command off){
		onCommands[slot] = on;
		offCommands[slot] = off;
	}
	
	public void onPressed(int slot){ 
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}
	public void offPressed(int slot){ 
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}
	public void undoPressed(){
		undoCommand.undo();
	}
	
	public String toString(){
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n----- Remote Control -----\n");
		for(int i=0; i<onCommands.length; i++){
			stringBuff.append( "[slot " + i + "]" + onCommands[i].getClass().getName() + "  " + offCommands[i].getClass().getName() + "\n");
			
		}
		
		return stringBuff.toString();
	}
}
