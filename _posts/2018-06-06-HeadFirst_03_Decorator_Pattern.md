### 问题：
星巴克咖啡因为公司扩展，需要一个新的order system ，咖啡中可以加入各种配料，所以计算最终的花费就成了一个问题，如何设计才能够既满足新的要求又不去改动已有的代码？
### 解决方法：
方法1：为每种选择方案创建类，会造成大量的类，维护起来很困难；  
方法2：将配料价格先提前加入进去，在base class中实现，每种咖啡只需在此基础上加入自己的价格即可，  
这种方法的问题是，如果配料的种类或或价格改变，就需要改动base class code，而且如果加入新的咖啡种类不能加入这些配料又会是个问题，再比如要多份配料等都会成为问题，带来code change。  

**OO原则**：OPEN-CLOSEprinciple:  classes should be open for extension , but closed for modification。  
满足open-close原则意味着更多层次的抽象，会使得代码更复杂，所以不需要也不能够所有的代码都满足这个原则，而是挑选日后最容易发生需求改变的部分使用这个原则进行设计。
### Decorator pattern
Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.  
这种模式就是利用open-close原则，适用于在不改动原来class的基础上扩展class的功能。  
想要扩展原有类的功能最常用的为inherance，但是继承只能在compile时静态扩展，如果要动态扩展，只能使用composition + delegate，Decorator模式就是基于composition思想的实现。  
Decorator，顾名思义，就是加上一层层的装饰品，在原有class（每一种单纯咖啡）的基础上加入一层层的外包裹（decorator，这里指各种配料），当需要调用方法的时候，先一层层往里调用，返回结果时从最里面一层层的返回对应的值，然后每一层加入自己的值，最后就得到了最后的值。
### Decorator模式类设计原型：
首先设计两个基本抽象类，被包装的类，这里指beer类，称为component； 包装类，这里称为Decorator类，也是一个抽象类，  
要注意的是Decorator和Component的关系，两者既是inherence，又是composition，具体表现为Decorator类一方面继承自Component，另一方面还包含Component，这种关系理解起来有一些绕，之所以decorator要继承component是为了保证两者类型是相同的，这样才可以使用多态原理，decorator之所以要包含component很好理解，因为这种模式的目的就是为它添加一些新的功能。  
然后，构建具体的component, decorator类；  
最后根据具体需求创建具体的component类，“包装”上需要的decorator类，实现所需功能。
### 具体使用：
以starbuzz coffee为例来实现一下：
首先设计抽象component, decorator类，这里为beverage（咖啡抽象类）, condimentDecorator（配料抽象类），  
然后创建具体类：  
Concrete component :  Espresso extends beverage, Decaf extends beverage等具体的coffee，
Concrete decorator: Milk extends condimentDecorator, Mocha extends condimentDecorator等具体的配料，  
注意concrete decorator类的实现：  

Public class Milk extends condimentDecorator {  
	  Beverage beer; //包含对被包装对象的引用  
	  Public Milk(Beverage br){this.beer = br;}  
	Public String getDesc(){ return   beer.getDesc +”, Milk” ; }  
	Public double cost(){ return .20+beer.cost() ;}    
  }  
### 举例实现：  
计算一种加有 milk, mocha的espresso的价格：  
首先，创建espresso :  Beverage beer = new Espresso();  
然后，添加Milk，创建添加有milk的beer:  Beverage beer1 = new Milk(beer);//将被包装的espresson传进去  
然后，再添加mocha，Beverage beer2 = new Mocha(beer1); // 此时被包装的为beer1  
最后计算价格，调用beer2.cost();即可，  
具体过程为，beer2.cost会调用被包装的beer1.cost()，beer1会去调用espresso的价格，最后得到espresso的价格后，返回到beer1，beer1附加上milk cost(20)，返回给beer2，beer2会附加上mocha cost(15)，最终得到返回值即为espresso + milk + mocha的总价格。
### 总结
在JAVA自身的API中也有很多地方用到这种模式，比如JAVA I/O中的inputstream, fileInputStream。  
其中input stream 为component，有很多种具体的基本读入操作比如fileinputstream, stringbufferInputstream等；FilterInputStream为decorator，有BufferedInputStream, DataInputStream等各种decorator实现各种定制化的读入操作。  
借用这种模式，可以很容易地扩展现有的input stream，  
比如实现一种将输入中的大写字母转换为小写字母的读入inputstream，可以设计一个继承自FilterInputStream的类，也即decarator，在这个decarator中添加自己想要的功能，然后用这个decorator去包装需要的基本输入操作即可。  
Decorator pattern的缺点是，会产生大量的类，增加代码数量。在使用这种模式时要注意这个特点，慎重选择。
