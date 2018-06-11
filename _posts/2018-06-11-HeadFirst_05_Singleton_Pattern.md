### 单例模式：
顾名思义，单例模式就是只允许每个class有一个且只有一个对象生成，在有些使用中会需要这种应用。  

实现方式为：  
Public class Singleton {  
	Private static Singleton uniqueInstance;  
	Private Singleton(){}  
	Public static Singleton getInstance(){   
		If(uniqueInstance == null){ uniqueInstance = new Singleton();}  
		Return uniqueInstance;   
}  
}  
在多线程在中会出现问题，可以使用以下解决方法：  
1.	将getInstance方法进行synchronized，这种方式会对性能造成一些影响；  
2.	使用eager instantiation，  
Public class Singleton {  
	Private static Singleton uniqueInstance = new Singleton();  
	Private Singleton(){}  
	Public static Singleton getInstance(){ return uniqueInstance; }  
}  
 	这种方式使得JVM 在load class的时候会生成一个实例，可以确保在任何thread访问之前创建。  
  当有多个classloader时也会产生多个instance，所以记得指定一种特定的classloader。  
3.	在之前的基础上面，只将new 部分synchronized，这种方法不适用于java 1.4 and earlier。  
Public class Singleton {  
	Private volatile static Singleton uniqueInstance;  
	Private Singleton(){}  
	Public static Singleton getInstance(){  
		If(uniqueInstance == null){  
			Synchronized (Singleton.class){  
				If(uniqueInstance == null){ uniqueInstance = new Singleton(); }  
}  
}  
		Return uniqueInstance;  
}  
}  

目前没有合适的示例来帮助理解。
