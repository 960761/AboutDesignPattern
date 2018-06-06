//JAVA built-in observer

import java.util.Observable;
import java.util.Observer;

public class ObserverIns2 implements Observer, Display {
	Observable observable;
	private float temp;
	private float humi;
	private float pres;
	
	public ObserverIns2(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public void update(Observable obs, Object arg){
		if(obs instanceof WeatherData2){
			WeatherData2 data = (WeatherData2)obs;
			this.temp = data.getTemp();
			this.humi = data.getHumi();
			this.pres = data.getPres();
			
			display();
		}
	}
	
	public void display(){
		System.out.println(&quot;Current Conditions: &quot; + temp + &quot;F degrees and &quot; + humi + &quot;% humidity and &quot; + pres + &quot; pressue.&quot;);
	}
}
