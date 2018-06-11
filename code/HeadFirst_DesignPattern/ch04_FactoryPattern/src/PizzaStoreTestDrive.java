//author xin
//date 2018.6.8

//factory method pattern
public class PizzaStoreTestDrive {

	public static void main(String[] args){
		PizzaStore1 s1 = new PizzaStore1();
		Pizza p1 = s1.orderPizza(&quot;cheese&quot;);
		System.out.println(&quot;Here is your pizza: &quot; + p1.getName());
	
		PizzaStore2 s2 = new PizzaStore2();
		Pizza p2 = s2.orderPizza(&quot;deggie&quot;);
		System.out.println(&quot;Here is your pizza: &quot; + p2.getName());
	}

}
