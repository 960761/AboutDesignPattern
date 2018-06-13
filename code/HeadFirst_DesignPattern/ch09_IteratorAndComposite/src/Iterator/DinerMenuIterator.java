public class DinerMenuIterator implements myIterator { 
 	MenuItem[] items; 
 	int position = 0; 
   
 	public DinerMenuIterator(MenuItem[] items) { 
		this.items = items; 
 	} 
  
 	public MenuItem next() { 
 		MenuItem menuItem = items[position]; 
 		position = position + 1; 
		return menuItem; 
	} 
   
 	public boolean hasNext() { 
 		if (position &gt;= items.length || items[position] == null) { 
 			return false; 
 		} else { 
 			return true; 
		} 
 	} 
}
