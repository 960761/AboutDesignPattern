import java.rmi.*;

public class MyRemoteClient {
	public static void main(String[] args){
		new MyRemoteClient().go();
	}
	
	public void go(){
		try{
			MyRemote service = (MyRemote)Naming.lookup(&quot;rmi://10.1.114.201/RemoteHi&quot;);
			
			String s = service.sayHi();
			System.out.println(s);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
