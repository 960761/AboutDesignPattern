public class ObserverIns1 implements Observer, Display {
	private float temp;
	private float humi;
	private float pre;
	private Subject weatherData;
	
	public ObserverIns1(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temp, float humi, float pre){
		this.temp = temp;
		this.humi = humi;
		this.pre = pre;
		display();
	}
	public void display(){
		System.out.println(&quot;Current Conditions: &quot; + temp + &quot;F degrees and &quot; + humi + &quot;% humidity and &quot; + pre + &quot; pressue.&quot;);
	}
}
