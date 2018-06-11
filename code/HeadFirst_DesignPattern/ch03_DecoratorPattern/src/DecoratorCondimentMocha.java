//concrete decorator class

public class DecoratorCondimentMocha extends DecoratorCondiment {
	ComponentBeer beer;
	
	public DecoratorCondimentMocha(ComponentBeer beer){ this.beer = beer;}
	public String getDesc(){return beer.getDesc() + &quot;, Mocha&quot; ;}
	public double cost(){ return .20+beer.cost();}
}
