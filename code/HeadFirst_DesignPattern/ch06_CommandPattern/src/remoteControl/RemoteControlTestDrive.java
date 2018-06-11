//author xin
//date 2018-6-11

public class RemoteControlTestDrive {
	public static void main(String[] args){
		//initiate receivers	
		Light light = new Light();
		Fan fan = new Fan(&quot;living room&quot;);
		
		//initiate concrete commands
		LightOnCommand lightOnCmd = new LightOnCommand(light);
		LightOffCommand lightOffCmd = new LightOffCommand(light);
		FanHighCommand fanHighCmd = new FanHighCommand(fan);
		FanLowCommand fanLowCmd = new FanLowCommand(fan);
		FanOffCommand fanOffCmd = new FanOffCommand(fan);
		
		//set command
		RemoteControl control = new RemoteControl();
		control.setCommand(0, lightOnCmd, lightOffCmd);
		control.setCommand(1, fanHighCmd, fanOffCmd);
		control.setCommand(2, fanLowCmd, fanOffCmd);
		
		System.out.println(control);
		
		control.onPressed(0);
		control.undoPressed();
		control.offPressed(0);
		control.undoPressed();
		
		control.onPressed(1);//high
		control.offPressed(1);//off
		System.out.println("please undo: ");
		control.undoPressed();//high
		control.onPressed(2);//low
		control.offPressed(2);//off
		System.out.println("please undo: ");
		control.undoPressed();//low
		control.offPressed(2);
	}
}
