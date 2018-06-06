//Author:xin
//Date: 2018-06-06

//Strategy Pattern Demo

public class oneDuck extends Duck {
	public oneDuck(){
		flyBehavior = new FlyWithWings();
	}
	
	public void display(){
		System.out.println(&quot;I am one duck that can fly&quot;);
	}
}
