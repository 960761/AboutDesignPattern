import java.rmi.*;
import java.rmi.server.*;

public interface MyRemote extends Remote{
	public String sayHi() throws RemoteException;
}
