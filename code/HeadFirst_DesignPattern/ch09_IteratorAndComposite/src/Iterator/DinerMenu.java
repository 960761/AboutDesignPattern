public class DinerMenu implements Menu { 
 	static final int MAX_ITEMS = 6; 
 	int numberOfItems = 0; 
 	MenuItem[] menuItems; 
    
 	public DinerMenu() { 
 		menuItems = new MenuItem[MAX_ITEMS]; 
   
		addItem(&quot;Vegetarian BLT&quot;, 
 			&quot;(Fakin') Bacon with lettuce &amp; tomato on whole wheat&quot;, true, 2.99); 
 		addItem(&quot;BLT&quot;, 
 			&quot;Bacon with lettuce &amp; tomato on whole wheat&quot;, false, 2.99); 
 		addItem(&quot;Soup of the day&quot;, 
 			&quot;Soup of the day, with a side of potato salad&quot;, false, 3.29); 
 	} 
    
 	public void addItem(String name, String description,  
 	                     boolean vegetarian, double price)  
 	{ 
 		MenuItem menuItem = new MenuItem(name, description, vegetarian, price); 
 		if (numberOfItems &gt;= MAX_ITEMS) { 
 			System.err.println(&quot;Sorry, menu is full!  Can't add item to menu&quot;); 
 		} else { 
 			menuItems[numberOfItems] = menuItem; 
			numberOfItems = numberOfItems + 1; 
 		} 
 	} 
   
 	public MenuItem[] getMenuItems() { 
 		return menuItems; 
 	} 
    
 	public myIterator createIterator() { 
		return new DinerMenuIterator(menuItems); 
 		// To test Alternating menu items, comment out above line, 
		// and uncomment the line below. 
 		//return new AlternatingDinerMenuIterator(menuItems); 
 	} 
   
	// other menu methods here 
 } 
