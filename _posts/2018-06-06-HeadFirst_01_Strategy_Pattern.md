# Strategy Pattern

Author: Xin  
Date: 2018-6-4   

### 问题： 
一款已经成熟实现的鸭子游戏，在原先的基础上面需要添加 fly的行为，怎么做？  
方法：  
方法1： 在父类中添加 fly方法，问题是，并不是所有的子类都有这个行为；  
方法2：将Fly 设计为interface，有这种行为的子类实现接口，这会大量改动代码且duplicate code存在，而且若以后fly改变，还需要大量修改代码。  

### 解决方法:  

首先，将 fly这种行为从duck类中拿出来进行封装，每种类型鸭子的飞行不一样，所以fly这种行为是不断变化的，不仅拿出来，还要封装和抽象化；  

然后，将fly定义为一个类，这个类中只有fly方法，但并不实现它，然后再定义继承自它的子类，在子类中具体实现。  
因为一个类不可以同时继承两个类，但却可以实现多个接口，所以将fly定义成接口。其实，接口的实质就是一个方法抽象类。  

最终方案的类设计结构为：  

将Fly单独拿出来定义为  
	interface FlyBehavior { 

		  public void fly();    
	}

具体的飞行种类定义为实现它的类：

	Class FlyType1 implements FlyBehavior{       
		Public void fly(){   concrete operation  }  
	}  

	Class FlyType2 implements FlyBehavior{  
		Public void fly(){  concreate operation  }  
	} 


### 如何使用：  

*父类的设计：*  

将flyBehavior这种行为包含在duck类中，作为其一个成员，并定义一个调用fly的方法； 

Class Duck {  
	FlyBehavior fb;  
	Public void performFly(){ fb.fly(); }  
}  

*子类的设计：*  

子类中需要初始化FlyBehavior这个变量，只有初始化后才可以调用具体的方法

	Class oneDuck extends Duck {  
		Public oneDuck() { fb = new FlyType1(); } //构造函数中进行初始化  
	}  

使用时，直接 oneDuck.performFly()；就可以了，这个时候就是调用的flyType1这种实现。  

*父类的改进：*  
以上还只能在子类的构造过程中选择具体的飞行实现方法，在父类中添加setFly方法：  

	Class Duck {  
		FlyBehavior fb;  
		setFly(FlyBehavior fbb){fb = fbb; }  
		Public void performFly(){ fb.fly(); }  
	}  

使用时：  
oneDuck.setFly(new FlyType2());  
oneDuck.performFly();  
这就可以在runtime时动态改变fly行为了。 

### Demo  
Check [here](https://github.com/960761/AboutDesignPattern/tree/master/code/HeadFirst_DesignPattern/ch01_StrategyPattern/src) for Duck Demo.

### 设计模式总结： 

以上解决问题的方法就被称为  
**Strategy pattern** :   
defines a family of algorithms, encapsulates each one, and makes them interchangeable, Strategy lets the algorithms vary independently from clients that use it.  

将变化的行为设计为抽象方法类（也即interface），以往都是在使用这种接口时进行实现，比如，若oneDuck有这种行为，则在oneduck中具体实现，而这种模式中，则是将实现也拿出来进行封装，也即设计不同的实现类实现这个接口，而不是在使用者中实现。
在使用这种模式时用到多态概念： flybehavior = new flyType1(); 等同于 animal = new Dog();  

这个模式涉及到**OO的三大原则**：  

**原则1**：将变化的部分拿出来进行封装（将fly拿出来进行封装）；  

**原则2**：针对接口抽象化而不是具体的实现（对fly类进行抽象化而不是具体实现）；  

**原则3**：更多使用composition而非Inherence（将fly作为DUCK的成员变量而不是继承）。  


**Strategy pattern 关键词：**  

方法抽象化
