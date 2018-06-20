### OO 基础：
Abstraction 抽象  
Encapsulation 封装  
Polymorphism 多态  
Inheritance 继承  
### OO原则：
Encapsulate what varies;  
Favor composition over inheritance;  
Program to interfaces, not implementation;  
Strive for loosely coupled designs between objects that interact;  
Classes should be open for extension but closed for modification;  
Depend on abstractions, do not depend on concrete classes;  
Only talk to your immediate friends;  
Don’t call us, we will call you;  
A class should have only one reason to change.  
### 常用设计模式概述：
**Strategy：**  
将算法实现进行封装，动态选择实现方式，使用composition + delegate 思想实现；  

**Observer：**  
监听模式  

**Decorator：**  
在不改变原有类代码前提下，动态添加新功能，虽然可以使用 inheritance实现，但是继承只能静态添加，动态要使用composition + delegate思想实现；

**Factory：**  
将 类创建 过程抽象封装；

**Singleton：**  
用于只需要一个类实例情形；

**Command：**  
将 方法调用和触发 进行抽象封装，和strategy有些相似，但是两者的设计目的是不同的，比如，用户发出fly的请求，strategy侧重实现各种具体的fly行为；而command则是，根据用户发出fly or speak or else等各种不同种类的请求进行具体响应，侧重方法调用的实现，将make a quest 和 execute the action分离开来。在实现上面，也是使用了composition + delegate思想。

**Adapter：**  
用来将一种类（接口）变换成另一种类（接口），基于inheritance  + composition 思想实现这种模式；

**Façade：**  
用于简化接口；基于composition思想实现这种模式；

**Template Method ：**   
适用于框架里的部分具体化，即将某个算法实现中的部分进行抽象封装，基于Inheritance思想实现，Factory method可以看成template method的一种特例；

**Iterator：**  
适用于对不同存储结构的一组数据进行统一的循环读取操作；

**Composite：**  
适用于处理tree-structured data 树形数据的情形；

**State：**  
状态的改变，composition  + delegate思想；

**Remote Proxy：**  
基于RMI的原理，适用于不同JVM间有交流的情形。



### 常用设计模式列表比较

|名字|定义|示例 |实现|备注|
|-|-|-|-|-|
|Strategy	|将算法实现进行封装抽象，动态选择实现方式	|比如Duck的fly行为有多种具体方式	|Composition + delegate|	
|Decorator	|不改变原类代码前提下动态添加新行为	|Coffee order system	|Inheritance + composition|	
|Command	|将 方法调用和触发 进行抽象封装	|Remote control	|Composition + delegate	|和strategy相似，但两者设计目的不同，比如，用户发出fly的请求，strategy侧重实现各种具体的fly行为；而command根据用户发出fly or speak or else等各种不同种类的请求进行响应，侧重方法调用的实现，将make a quest 和 execute the action分离开来
|Adapter	|将一种类（接口）转换为另一种类（接口）	|Goose &gt; duck	|Inheritance + composition|	
|Facade	|用于简化涉及到多个对象的接口	|Home theatre	|composition|	
|Template	|适用于框架里的部分具体化，即将某个算法实现中的部分进行抽象封装	|Make coffee and tea	|inheritance	|Factory method为它的一个特例，注意和Strategy的区别|
|Factory	|将 类创建过程 进行封装和抽象	|Make pizza	inheritance	||衍生出Abstract Factory模式
|Observer	|监听对象	|Weather report	abstract	|
|Singleton	|用于某种类只需要一个对象的情形|	thread|	Static + private|	
|Iterator	|适用于对不同存储结构的一组数据进行统一的循环读取操作	|两种menu的组合	|delegate	|
|Composite	|适用于处理tree-structured data 树形数据的情形	|Submenu 	|delegate|	
|State	|涉及到不同状态之间转换的情形	|Game ball	|Composition + delegate|	
|Remote Proxy|	不同的JVM间相互调用|	Remote  monitor|	RMI| 	Proxy 功能很强大，也很负责，根据功能分为很多种类|
