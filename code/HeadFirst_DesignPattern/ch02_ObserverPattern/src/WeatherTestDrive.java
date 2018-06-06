public class WeatherTestDrive {
	public static void main(String[] args){
		System.out.println(&quot;my own observer pattern&quot;);
		
    //self-defined observer pattern
		WeatherData data = new WeatherData();
		ObserverIns1 dis = new ObserverIns1(data);
		data.setMeasurements(72,50,80);
		data.setMeasurements(80,70,65);
		
    //Java built-in observer pattern
		System.out.println(&quot;Java built-in observer pattern&quot;);
		WeatherData2 data2 = new WeatherData2();
		ObserverIns2 dis2 = new ObserverIns2(data2);
		data2.setMeasurements(72,50,80);
		data2.setMeasurements(80,70,65);
		
	}
}
