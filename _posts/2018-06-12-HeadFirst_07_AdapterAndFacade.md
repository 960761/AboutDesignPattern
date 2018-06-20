## Aapter and Facade pattern

### Adapter pattern:
可以使用 电源转换器 来理解这种模式。  
Converts the interface of a class into another interface that the client expect. Adapters let classes work together that couldn’t otherwise because of incompatiable interface。  
主要目的是为了两种接口不兼容的class可以兼容；
### 简单示例：
Public  interface Duck { void quack(); void fly(); }  
Public interface Turkey { void gobble(); void fly(); }   
现在client想使用duck，但是我们只有turkey，这时就需要一个adapter  

	Public class TurkeyAdapter implements Duck {  
		Turkey turkey;  
		Public TurkeyAdatpter(Turkey tk){ this.turkey = tk; }  
		Void quack(){ turkey.goggle(); }  
		Void fly(){turkey.fly(); }  
	}  
### 模型类架构图：
涉及到两个：target(duck)，即需要的类； adaptee(turkey)，现有的类，需要被转换的类  
设计adapter:  使其实现target，并包含adaptee，使用adaptee的方法实现target的方法。  
**使用实例：**  
以前的JAVA中，使用Enumerators来循环获取集合中的单个元素；现在则多是使用Iterator来实现这一个功能，这个时候就可以使用adapter来使得原来的expose Enumerator interface的代码可以使用Iterator功能。
### Façade pattern:
Provides  a unified interface to a set of interfaces in a subsystem。  
即对于涉及到多个对象调用多个方法的情况下，对这些对象和方法进行集合封装。
### 简单示例：
一个家庭影院涉及到好多类，比如灯光，声响，荧幕等；  
需要watch movie时，分别要调用light.on(), sound.on(), screen.on()等，会与很多个对象打交道，这时候就可以使用Façade，  
定义public class façade {} 将涉及到的object都集合到façade里面，并将watch movie所需要的操作集合进一个函数watechMovie()里面。 
### Demo
Headfirst给出的关于adapter 和 facade的demo都非常简单，这里就没有给出代码。
### OO原则：  
least knowledge- talk only to your immediate friend，尽量减少类相互间的依赖和耦合。  
其中一条：  
not to call methods on objects that were returned from calling other methods, but we can call methods of instance variable and function paremeters.  
### 对比
以下三种模式都使用到class composition，但是侧重点各不相同：  
**Adapter** wrap class to change its interface;  
**Façade** wrap several objects to simplify the interface;  
**Decorator** wrap object to add new behaviors。   
