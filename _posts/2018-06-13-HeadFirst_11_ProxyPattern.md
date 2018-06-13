### 问题：
接着从pattern 10的问题看，  
Game ball游戏获得空前成功，多个地方都建有game machine，每个地方的game machine都在本地运行之前利用state pattern设计良好的程序，如今想在总部得到全部的game machine明细，包括地点，名字和状态，因为game machine是分布于各个地方的，所以程序位于不同的JVM上面。
### 解决方法：
如果只是打印本地game machine的状态，只需要设计一个GameMonitor类，在里面传入game machine reference，然后调用其相关get函数或许所需的状态即可。  
而如今各地的game machine是位于不同的JVM上面，因为我们需要能够访问不同JVM上面的game machine类的get函数，所以需要提供一种解决方法。  
这里就是用到了remote proxy 模式，  
**A remote proxy acts as a local representative to a remote object**

它的本质是JAVA RMI机制，  
**RMI gives a way to find objects in a remote JVM and allows us to invoke their methods。**

**RMI 的本质为**：
本地client需要访问异地service，使用RMI的实质过程为：    

首先，client所在的server 应该有一个 client helper，也称为remote proxy，也即它就代表我们要访问的异地service；    
Service所在的server 也有一个service helper； 

过程为：     
client访问本地的client helper(proxy)，这种访问就是local  invoke，是可以的；    
Client helper通过network底层机制来和remote server进行通讯，将invoke method信息发送给service helper；    
Service helper 收到invoke information后调用service，这个时候为local invoke。     
这样就实现了client remote invoke service的过程。    
JAVA内置支持RMI，其中client helper即stub，  service helper即skeleton。  

### 实现简单的RMI：
这里，将jabdw3420作为server， jabdw3421作为client，    
最终的目的是在3421上面可以调用3420上面的java类定义的sayHi()方法。    

**实现步骤：**  

首先，将3420上面的java类变成remote service，

**1.Make a remote interface**
这个interface作用是 defines the remote methods you want client  to call.  
Public interface myRemote extends Remote{  
Public String sayHi() throws RemoteException;  
}  
三点要注意，  
第一，必须extends Remote；第二，必须throw RemoteException；第三，里面的method涉及到的参数或返回值必须为primitive or serializable。

**2.Make a remote implementation**
也即实现上面定义的remote interface  
  Public class myRemoteImpl extends UnicastRemoteObject implements myRemote {  
	Public String sayHi(){ return “server say, hi” ; }  
	Public myRemoteImpl () throws RemoteException {}  
}  
注意两点，  
第一，一定要extend UnicastRemoteObject；第二，因为UnicastRemoteObject会抛出异常，所以这里也要定义一个空的构建函数，目的就是为了将父类抛出的异常继续throw。

**3.生成stub and skeleton**
使用RMI工具生成。   
首先要对implementation进行compile生成class  
然后要在implementation class所在的目录运行  rmic myRemoteImpl  
就会在当前目录下生成stub, skeleton，默认命名为 xx_Stub,  xx_Skeleton，实际上只会生成stub没有skeleton。  

**4.注册service**  
到这里为止生成service已经成功，还需要进行注册,这里需要两个操作
首先，另外打开一个terminal，运行rmiregistry；  
然后，还需要进行rebind，rebind的代码可以自己选择放在哪里，这里将其放在implementation上面，因此最后的implementation就变成了以下：  
  Public class myRemoteImpl extends UnicastRemoteObject implements myRemote {  
	Public String sayHi(){ return “server say, hi” ; }  
	Public myRemoteImpl () throws RemoteException {}  
	public static void main(String[] args){  
		try{  
			MyRemote service = new MyRemoteImpl();  
			Naming.rebind(&quot;//localhost/RemoteHi&quot;, service);  
		}catch(Exception ex){  
			ex.printStackTrace();  
		}  
	}  
}    

至此就准备成功了，可以使用了。  
**在client端使用时，步骤如下：**

首先，将server端的myRemote.class,  myRemoteImpl_Stub.class拷贝到client端正确目录下（client端代码所在处）  
然后，书写调用myRemote的代码  
		try{  
			MyRemote service = (MyRemote)Naming.lookup(&quot;rmi://10.1.114.201/RemoteHi&quot;);  
			
			String s = service.sayHi();
			System.out.println(s);
		}catch(Exception ex){
			ex.printStackTrace();
		}
最关键的是Naming.lookup的使用，用来查找所需要的proxy，其中的参数为server service所在的位置，这里为3420 IP地址。  
最后，运行，  
首先在server 端开启terminal运行rmiregistry  
然后在server 端运行rebind所在代码，这里就是myRemoteImpl（因为这个错误调试很长时间）  
然后在client端正常编译运行即可。 
### Simple RMI demo
Click [here](https://github.com/960761/AboutDesignPattern/tree/master/code/HeadFirst_DesignPattern/ch11_ProxyPattern/src/simpleRMI) for simple RMI code.
### game machine的具体实现：
Server 端的service已有，即为gameMachine何一组具体的state class;  
需要编写remote和remoteImpl，这里创建 GameMachineRemote；其中的GameMachineRemoteImpl就在 GameMachine class的基础上面修改而成；  
然后编写GameMachineTest将Naming.rebind()放在这里执行；  
在client端创建GameMonitor，使其包含GameMachineRemote reference，并调用其get函数获取所需状态；  
最后使用GameMonitorTestDrive进行测试。  
### Proxy Pattern
Provides a surrogate(代孕) or placeholder for another object to control access to it。  

Proxy pattern 的变种非常多，除了remote proxy之外还有很多很多种的proxy，书中还给出了 virtual proxy和protection proxy的两个示例，除此外还提到Firewall proxy, Caching proxy等等多种。所以，Proxy模式的功能非常强大，概念也有些难以理解，变种特别特别多，需要花费很大时间和精力去真正全面了解和消化。
