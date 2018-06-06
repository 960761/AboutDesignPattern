//Author:xin
//Date: 2018-06-06

//Strategy Pattern Demo

public class DuckTestDrive {
	public static void main(String[] args){
		Duck one = new oneDuck();//initiate with FlyWithWings behavior
		one.performFly();
		
		System.out.println("I can change my fly behavior dynamically, cool!");
		one.setFlyBehavior(new FlyAsRocket());
		one.performFly();
	}
}
