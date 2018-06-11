public class Fan{
	public static final int HIGH = 3;
	public static final int LOW = 1;
	public static final int OFF = 0;
	String location;
	int speed;
	
	public Fan(String loca){
		this.location = loca;
		speed = OFF;
	}
	public void setHigh(){
		speed = HIGH;
		System.out.println(&quot;Fan high speed&quot;); 
	}
	public void setLow(){ 
		speed = LOW;
		System.out.println(&quot;Fan low speed&quot;); 
	}
	public void off(){
		speed = OFF;
		System.out.println(&quot;Fan is off&quot;); 
	}
	
	public int getSpeed(){ return speed; }
}
