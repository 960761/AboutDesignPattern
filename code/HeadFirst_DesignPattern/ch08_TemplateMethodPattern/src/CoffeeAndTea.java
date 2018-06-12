public abstract class CoffeeAndTea {
	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		if(customerWantCondiments()){addCondiments();}
	}
	
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater(){ System.out.println(&quot;Boiling water&quot;); }
	void pourInCup(){ System.out.println(&quot;Pouring into cup&quot;); };
	
	//hook function
	boolean customerWantCondiments(){
		return true;
	}
}
