public class FanHighCommand implements Command {
	Fan fan;
	int prevSpeed;
		
	public FanHighCommand(Fan fan){ this.fan = fan;}
	public void execute(){ 
		prevSpeed = fan.getSpeed();		
		fan.setHigh(); 
	}
	public void undo(){
		if(prevSpeed == Fan.HIGH){ fan.setHigh();}
		else if(prevSpeed == Fan.LOW){ fan.setLow(); }
		else if(prevSpeed == Fan.OFF){ fan.off();}
	}
}
