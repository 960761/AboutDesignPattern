//Author:xin
//Date: 2018-06-06

//Strategy Pattern Demo

public abstract class Duck {
	
  FlyBehavior flyBehavior;
	
  //constructor
	public Duck(){
	}

	public void performFly(){
		flyBehavior.fly();
	}  
   //set fly behavior at runtime
   public void setFlyBehavior(FlyBehavior fb){
		flyBehavior = fb;
	}
  
  //other methods
	public void swim(){
		System.out.println(&quot;All ducks float, even decoys!&quot;);
	}
	public abstract void display();

}
