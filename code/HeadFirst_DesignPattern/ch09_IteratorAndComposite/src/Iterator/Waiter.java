public class Waiter {
	Menu LunchMenu;
	Menu DinerMenu;
	
	public Waiter(Menu LunchM, Menu DinerM){
		this.LunchMenu = LunchM;
		this.DinerMenu = DinerM;
	}
	
	public void printMenu(){
		myIterator lunchMenuIterator = LunchMenu.createIterator();
		myIterator dinerMenuIterator = DinerMenu.createIterator();
		
		System.out.println(&quot;MENU\n-----\nLUNCH&quot;);
		printMenuItem(lunchMenuIterator);
		
		System.out.println(&quot;MENU\n-----\nDINER&quot;);
		printMenuItem(dinerMenuIterator);		
	}
	
	private void printMenuItem(myIterator iter){
		while( iter.hasNext() ){
			MenuItem item = (MenuItem)iter.next();
			System.out.println(item.getName() + &quot;,&quot;);
			System.out.println(item.getPrice() + &quot;,&quot;);
			System.out.println(item.getDescription() + &quot;,&quot;);
		}

	}
}
