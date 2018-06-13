public class WaiterTestDrive {
	public static void main(String[] args){
		LunchMenu lm = new LunchMenu();
		DinerMenu dm = new DinerMenu();
		Waiter w = new Waiter(lm, dm);
		w.printMenu();
	}
}
