# Observer Pattern

Author: Xin  
Date: 2018-6-4

### 问题
有一个已经实现了的气象观测站app，现在想实时显示天气数据，怎么做？
### 解决方法  
Observer模式非常好理解，可以参照预订报纸来进行理解，之前GUI中很多action listener也是基于此。  
**Observer pattern**:  
defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.  
体现的OO原则： **Loose Coupling 松耦合**
### 具体实现：
先定义两个接口：发布者Subject 和 订购者（观察者）Observer  
Public interface Subject {  
	registerObserver(Observer o);  
removeObserver(Observer o);  
notifyObservers();  
}  
Public  interface Observer {  
	Update(Subject sub);  
}  
**如何使用：**  
Public class weatherData implements Subject {  
	  private ArrayList observers;//用来存储自己的observers  
  public WeatherData(){observers = new ArrayList();}    
	//implement interface method  
	public void registerObserver(Observer o){  observers.add(o);  }  
	public void removeObserver(Observer o){  
		int i = observers.indexOf(o);  
		if(i&gt;=0){observers.remove(i);}  
	}  
	public void notifyObservers(){  
		for(int i=0;i&lt;observers.size();i++){  
			Observer ob = (Observer)observers.get(i);  
			ob.update(this);  
		}  
	}  
             //custom methods  
	dataChanged(){  
		notifyObservers();  
}  
}  
Public class update implements Observer {  
	Private Subject subject;  
	Public void update(Subject sub){  
		subject = sub;  
		//use data to do sth here  
}  
} 

### Demo
Check [here](https://github.com/960761/AboutDesignPattern/tree/master/code/HeadFirst_DesignPattern/ch02_ObserverPattern) for Weather station demo.

### 总结
这种模式特别常用，所以JAVA有内置实现，  
Observable class 对应Subject；  
Observer interface对应 Observer；  
Observable class常用方法：addOberver(), deleteObserver(), notifyObservers(), setChanged()；  
Observer interface方法：update(Observable ob, Object args);    

其中，Observable一方发送更新有两种方式：  
notifyObservers(Object arg);  这种为push方式，即将数据发给observer；  
notifyObservers();  这种为pull方式，即observer自己索取数据，这种方式需要在obserable中定义getter函数。  

**在notifyObservers之前，一定要setChanged()；** 

因为observable为类而非接口，所以JAVA built-in observer的使用受到限制，如果我们自己的类已经是一个子类了，那就没办法使用了，这时就需要自己实现observer模式。除了java.util，其余如java bean, spring等也提供了observer的实现。
