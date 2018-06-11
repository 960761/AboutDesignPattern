public class PizzaStore1 extends PizzaStore {

	public Pizza createPizza(String item){
		if( item.equals(&quot;cheese&quot;) ){
			return new PizzaCheese();
		}else{ return null; }	
	}
}
