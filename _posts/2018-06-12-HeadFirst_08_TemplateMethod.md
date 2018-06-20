### 问题的提出及解决：

准备一杯咖啡的类定义为： 

	Public  class coffee {  
		boilWater(){xx};  
		brewCoffee(){xx};  
		pourInCup(){xx};  
		addMilk(){xx};  
	}  

准备一杯茶的类定义为：  

	Public  class tea {  
		boilWater(){xx};  
		brewTea(){xx};  
		pourInCup(){xx};  
		addLemon(){xx};  
	}    
从上面可以看出，两种类的活动模式都是一样的，只是其中某些具体步骤不相同，以上设计会有很多重复代码，  

改进如下：  

	Public abstract class CoffeeAndTea{  
		Public void prepare(){  
			boilWater();  
			brew();  
			pourInCup();  
			addCondiment();  
		}  
		Void boilWater(){xx};  
		Void pourInCup(){xx};  
		Abstract void brew();  
		Abstract void addCondiment();  
	}  
然后具体到coffee and tea的时候，只需扩展以上类并具体实现虚方法即可，既保证了行为的灵活性，又最大程度利用了code reuse。  
### Template Method Pattern
Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.   
Template method let subclasses redefine certain steps of an algorithm without changing the algorithm’s structure。
### Demo
Click [here](https://github.com/960761/AboutDesignPattern/tree/master/code/HeadFirst_DesignPattern/ch08_TemplateMethodPattern/src) to see the demo code.
### 模型类设计图：
只需要一个虚类即可： 

	Abstract class AbstractClass {  
		Final void templateMethod(){  
			primitiveOperation1();  
			primitiveOperation2();  
			concreteOperation();  
		}  
		Abstract void primitiveOperation1();  
		Abstract void primitiveOperation2();  
		Void concreteOperation(){xx};  
	}  
具体的类拓展该虚类时负责实现具体的某些子函数。  
### Hook 函数：
A hook is a method that is declared in the abstract class, but only give an empty or default implementation。  
Hook的本质就是一个虚类中的方法，注意为非虚方法，因为子类可以不用理会，在需要的时候可以进行覆盖，这就给了子类更改父类行为的入口和自由（可改可不改）。  
因为这个函数是在父类中的，所以子类虽然可以通过override修改其具体行为，但是其调用则是由父类控制，这就引入了OO Hollywood principle。
### OO原则：
**Don’t call me, I will call you。**  
此原则主要用来解决不同level元素间混乱问题，hook的设计就体现了这一原则。  
Hook  enable low-level component(concrete class like Coffee) to hook into high-level component(abstract class CoffeeAndTea),   
but the high-level component decide how and when to call it.  
Template method模式既可以保持统一的架构，又可以满足行为具体化，且重复利用code reuse，所以在应用中经常用到。  
JAVA array中的sort()就是使用了这一模式。JFrame中的paint()函数则是hook应用的一个例子。 
### 对比
**Strategy pattern, template and factory**：
Strategy 和template两者很相似，都是将具体的行为delegate给其余的对象，但是实际上还是有很多不同的地方的：  
第一，	Strategy将整个algorithm的实现都delegate给了其他对象，template只将整个algorithm中某些steps代理给其他对象；  
第二，	Strategy 使用的是composition；template使用的是Inherence；  
第三，	Strategy侧重的是运行期间动态改变行为的灵活性；template侧重的是在不改变整体框架的前提下灵活实现某些步骤，并最大化利用code reuse；  
第四，	Factory method可以认为是template method 的一种特殊情况。  
