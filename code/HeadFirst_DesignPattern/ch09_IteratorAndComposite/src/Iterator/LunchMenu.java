import java.util.ArrayList;

public class LunchMenu implements Menu { 
	ArrayList&lt;MenuItem&gt; menuItems; 
  
	public LunchMenu() { 
		menuItems = new ArrayList&lt;MenuItem&gt;(); 
     
		addItem(&quot;K&amp;B's Pancake Breakfast&quot;,  
			&quot;Pancakes with scrambled eggs, and toast&quot;,  
		    true, 
			2.99); 
  
	    addItem(&quot;Regular Pancake Breakfast&quot;,  
		    &quot;Pancakes with fried eggs, sausage&quot;,  
 			false, 
			2.99); 
 	} 
 
 
 	public void addItem(String name, String description, 
 	                    boolean vegetarian, double price) 
	{ 
 		MenuItem menuItem = new MenuItem(name, description, vegetarian, price); 
		menuItems.add(menuItem); 
	} 
   
 	public ArrayList&lt;MenuItem&gt; getMenuItems() { 
 		return menuItems; 
 	} 
    
 	public myIterator createIterator() { 
 		return new LunchMenuIterator(menuItems); 
 	} 
    
 	public String toString() { 
		return &quot;Lunch Menu&quot;; 
 	} 
 
 
 	// other menu methods here 
 } 
