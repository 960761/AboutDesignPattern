import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	public String sayHi(){ return &quot;Server says, hi&quot;; }
	public MyRemoteImpl() throws RemoteException {}
	public static void main(String[] args){
		try{
			MyRemote service = new MyRemoteImpl();
			Naming.rebind(&quot;//localhost/RemoteHi&quot;, service);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
