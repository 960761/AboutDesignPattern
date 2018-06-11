public class PizzaStore2 extends PizzaStore {
	public Pizza createPizza(String item){
		if(item.equals(&quot;deggie&quot;) ){
			return new PizzaDeggie();
		}else { return null;} 
	}
}
