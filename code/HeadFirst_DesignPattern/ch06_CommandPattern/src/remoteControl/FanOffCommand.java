public class FanOffCommand implements Command {
	Fan fan;
	int prevSpeed;
		
	public FanOffCommand(Fan fan){ this.fan = fan;}
	public void execute(){ 
		prevSpeed = fan.getSpeed();	
		fan.off(); 
	}
	public void undo(){
		if(prevSpeed == Fan.HIGH){ fan.setHigh();}
		else if(prevSpeed == Fan.LOW){ fan.setLow(); }
		else if(prevSpeed == Fan.OFF){ fan.off();}
	}
}
