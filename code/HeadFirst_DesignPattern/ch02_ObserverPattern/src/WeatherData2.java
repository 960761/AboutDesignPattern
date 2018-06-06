//JAVA built-in observer pattern

import java.util.Observable;
import java.util.Observer;

public class WeatherData2 extends Observable {
	private float temp;
	private float humi;
	private float pres;
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}
	public void setMeasurements(float temp, float hum, float pre){
		this.temp = temp;
		this.humi = hum;
		this.pres = pre;
		
		measurementsChanged();
	}
	public float getTemp(){return temp;}
	public float getHumi(){return humi;}
	public float getPres(){return pres;}
}
