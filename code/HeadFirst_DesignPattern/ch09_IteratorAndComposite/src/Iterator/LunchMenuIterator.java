import java.util.ArrayList; 

public class LunchMenuIterator implements myIterator { 
 	ArrayList&lt;MenuItem&gt; items; 
	int position = 0; 
   
 	public LunchMenuIterator(ArrayList&lt;MenuItem&gt; items) { 
 		this.items = items; 
 	} 
   
 	public MenuItem next() { 
 		MenuItem item = items.get(position); 
 		position = position + 1; 
		return item; 
 	} 
   
 	public boolean hasNext() { 
 		if (position &gt;= items.size()) { 
 			return false; 
 		} else { 
			return true; 
 		} 
 	} 
 } 
