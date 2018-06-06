//author:xin
//date:2018-6-6

//self-defined observer pattern

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
