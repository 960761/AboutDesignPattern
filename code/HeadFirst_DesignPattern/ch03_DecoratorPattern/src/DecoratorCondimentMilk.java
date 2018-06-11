//concrete decorator class

public class DecoratorCondimentMilk extends DecoratorCondiment {
	ComponentBeer beer;
	
	public DecoratorCondimentMilk(ComponentBeer beer){ this.beer = beer;}
	public String getDesc(){return beer.getDesc() + &quot;, Milk&quot; ;}
	public double cost(){ return .20+beer.cost();}
}
