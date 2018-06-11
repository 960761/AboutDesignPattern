### 问题：
一个披萨店，最开始的时候，类设计为  
Public  class pizzastore {  
	Pizza pizza;  
	Public Pizza orderPizza(String type){  
		If(type == “type1”){ pizza = new Pizza1(); }  
		Else if(type == “type2”){ pizza = new Pizza2(); }  
		Return pizza;  
}  
}   

可以看到当pizza  type变化时 ，这个类代码需要改变，因此当pizza店扩张后，增加更多pizza type时，代码的改变将是一个很严重的问题，怎么解决？  
### 解决方法
**改进一：**  
根据 “将变化的部分拿出来进行封装”的原则，进行改进：  
将创建部分代码拿出来封装成一个类：   
Public class pizzaFactory {  
	Public createPizza(String type){  
		If(type == “type1”){ pizza = new Pizza1(); }  
		Else if(type == “type2”){ pizza = new Pizza2(); }  
		Return pizza;  
}  
}  
原来的类设计改为：  
Public  class pizzastore {  
	pizzaFactory fac; //添加一个引用到pizza factory  
	public PizzaStore(PizzaFactory pf){this.fac  = pf;}  
	Public Pizza orderPizza(String type){  
		Pizza pizza = fac.createPizza(type);  
		Return pizza;  
}  
}   
这时有两个类，pizzaStore, pizzaFactory，两者为组合关系，这样改进后，type改变时，只需改变pizzaFactory即可。  
如果我们需要两种pizza，只需要创建两个pizzaFactory即可，new pizzaFactory1(), new pizzaFactory2()，但是还要在 pizzaStore类 里面进行改动，所以还需要进一步改进。  

**改进二：**  
Public  abstract pizzaStore {  
	Public orderPizza(String type){  
		Pizza pizza = createPizza(type);  
		Return pizza;  
}    
Public abstract Pizza createPizza(String type);    
}      
将pizzaFactory类改为createPizza method，但是定义为abstract类型，需要子类去具体实现。  
这样当需要不同类型的pizza时，对pizzaStore进行扩展即可，扩展时在子类中对具体的pizza type通过createPizza进行创建，这时就不需要去改动pizzaStore的类源码了。  
这里涉及到两大类组：pizzaStore类组和pizza类组。两大类组之间为平行关系。它们通过createPizza method进行连接。  
这里的关键就是abstract createPizza  method和abstract  pizzaStore类的设计。其中的createPizza abstract method就是今天要讲的工厂方法模型。  
工厂方法模型的本质思想为，将对象创建的过程拿出来进行封装，并抽象，让子类来实现具体对象的创建。  
可以看出来，其实每种模式都是更高程度抽象的结果，比如这里就是将之前具体的类pizzaStore抽象成一个抽象类。  
### Factory Method Pattern:
Defines an interface(abstract method) for creating an object, but let subclasses decide which class to instantiate, Factory method lets a class defer instantiation to subclasses.  

### Demo
Click [here](https://github.com/960761/AboutDesignPattern/tree/master/code/HeadFirst_DesignPattern/ch04_FactoryPattern/src) for Demo.

**模型类设计图：**    
两大类组：  
Product组，即上面的pizza组，要创建的东西；  
Creator 组，即上面的pizzastore组，使用这些东西的对象；  
每一组最上层都为一个抽象类，两个类组通过factory method即abstract method in creator class连接起来。  

涉及到的一个OO原则：  
**Dependency Inversion Principle**：  
Depend on abstractions, do not depend on concrete classes。  
具体到我们这个例子，最开始pizzastore（high level）是要依赖于concrete pizza(low level)的，后来通过factory method并更改类设计，使得pizza store(high-level) and pizza(low-level)全部都依赖于abstraction(factory method)。
这个原则是一个很重要的原则，很大程度上也是一种思维模式。要训练这种从high level 到low level的思考设计模式。
### Abstract Factory Pattern:
Provides an interface for creating families of related or dependent objects without specifying their concrete classes.  
可以理解为：  
Factory method模式用于创建一个对象时；  
Abstract Factory模式用于创建一组相互关联的对象时。  
抽象工厂模式理解也能够理解，但是因为举例子的时候和工厂方法模式放在了一起，所以对抽象工厂模式的使用还有些迷糊，希望有一个单纯只使用抽象工厂模式的例子。
