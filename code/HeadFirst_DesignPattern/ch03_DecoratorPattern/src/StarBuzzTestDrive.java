//author: xin
//date: 2018-6-7
//demo for Decorator pattern

public class StarBuzzTestDrive {
	public static void main(String[] args){
		//one way to implement
		ComponentBeer beerFinalT = new ComponentBeerEspresso();
		System.out.println(&quot;This is the basic&quot; + beerFinalT.getDesc());
		
		ComponentBeer beerFinalA = new DecoratorCondimentMocha(beerFinalT);
		System.out.println(&quot;This is decorated by &quot; + beerFinalA.getDesc());
		
		ComponentBeer beerFinalB = new DecoratorCondimentMilk(beerFinalA);
		System.out.println(&quot;This is decorated by &quot; + beerFinalB.getDesc());
		
		System.out.println(beerFinalB.getDesc() + &quot;$&quot; + beerFinalB.cost());
		
		
		//second way
		ComponentBeer beerFinal = new ComponentBeerEspresso();	
		beerFinal = new DecoratorCondimentMocha(beerFinal);		
		beerFinal = new DecoratorCondimentMilk(beerFinal);
		
		System.out.println(beerFinal.getDesc() + &quot;$&quot; + beerFinal.cost());
		
		//third way
		ComponentBeer beerFinal3 = new DecoratorCondimentMilk( new DecoratorCondimentMocha( new ComponentBeerEspresso() ) );
		System.out.println(beerFinal3.getDesc() + &quot;$&quot; + beerFinal3.cost());
	}
}
