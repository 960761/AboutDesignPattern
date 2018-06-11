public class RemoteControlTestDrive {
	public static void main(String[] args){
		RemoteControl control = new RemoteControl();
		LightOnCommand onCmd = new LightOnCommand(new Light());
		
		control.setCommand(onCmd);
		control.lightOnPressed();
	}
}
