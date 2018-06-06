//Author:xin
//date:2018-6-6

//self-defined observer pattern

import java.util.*;

public class WeatherData implements Subject {
	private ArrayList observers;
	private float temp;
	private float humi;
	private float pre;
	
	public WeatherData(){
		observers = new ArrayList();
	}
	
	//implement interface method
	public void registerObserver(Observer o){
		observers.add(o);
	}
	public void removeObserver(Observer o){
		int i = observers.indexOf(o);
		if(i&gt;=0){
			observers.remove(i);
		}
	}
	public void notifyObservers(){
		for(int i=0;i&lt;observers.size();i++){
			Observer ob = (Observer)observers.get(i);
			ob.update(temp,humi,pre);
		}
	}
	
	//other methods
	public void measurementsChanged(){
		notifyObservers();
	}
	public void setMeasurements(float temp, float hum, float pre){
		this.temp = temp;
		this.humi = hum;
		this.pre = pre;
		
		measurementsChanged();
	}
	
}
