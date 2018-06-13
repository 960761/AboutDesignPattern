### 问题：
现在有两个menu，
一个是lunchMenu class，使用的是arrayList 存储menu Item；
一个是dinnerMenu class，使用的是Array存储menu Items；
现在我们想将两个进行合并，具体就是可以使用waiter打印出所有的menu item；
设计printMenu()方法，因为两个类使用不同的数据结构存储menu Item，所以需要分别进行循环获取处理，如果再添加其他的menu，并使用不同的结构比如hashtable等存储，这时需要到printMenu()进行修改，而且printMenu()中会存在很多重复代码，如何优化？
### 解决方法：
根据“将变化的部分拿出来进行封装”的原则进行优化，可以看出，主要的变化部分是 循环获取 collection ele；
首先，就把这部分拿出来并封装成一个接口：
Interface myIterator{ 
	Boolean hasNext();
	Object next();
}
然后，针对两种menu创建各自的iterator实现以上接口，在这两个具体的iterator类中具体实现 循环获取元素 的操作；
lunchMenuIterator implements myIterator(){xxx}
dinnerMenuIterator implements myIterator(){xxx}
最后，需要在两种menu中添加函数用来提供各自的iterator，添加createIterator()函数。
至此，已经解决问题，但是可以看到createIterator()在两个menu中是共有的部分，所以可以再次将此函数拿出来封装成一个接口，这样做不仅减少了代码冗余，而且因为共同实现此接口使得两种menu利用多态可以互换。
Abstract Menu{ 
	Void createIterator();
}
涉及到两组类，一组是实现了menu得各种具体的menu；一组是实现myIterator的针对各种menu的iteratorz，这两组对象组，通过printMenu()联系到一起并完成所需操作。
### Iterator Pattern：
Provides a way to access the element of a collection of objects sequentially without exposing its underlying representation。
也即对于使用不同存储结构（arrayList, Array, hashtable等）的对象集合，只要能够提供提供iterator对象，都可以使用统一的接口进行循环获取单个元素的操作。
上面我们是自己定义的iterator接口，JAVA中已经提供了定义好的Iterator接口，而且除了hasNext(), next()方法外，还可以扩展其他方法。因此，使用iterator pattern时使用JAVA提供的iterator即可，如果JAVA提供的iterator interface不能满足 需求，也可以创建自己的iterator。
Iterator 模式的使用使得collection(menu)可以专注于存储menu item，而将 循环获取元素的操作 delegate给了iterator，这就体现了single responsibility的设计原则。
### Single Responsibility：
A class should have only one reason to change。
在设计的时候，每个类最多应该只关注一个单独的点，因为关注的点越多，引入的可变因素越多，后期出错的概率越大，也越难维护，所以前期设计时一定要注意这一个原则。
新的问题：
如果在上面的dinner menu中添加一个dessert menu，那么以上的printMenu方法就不再适用了，需要考虑新的方法，这里就引入了composite pattern.
### Composite pattern:
Allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets client treat individual objects and compositions of objects uniformly。
适用情景为 ：遍历树形数据。
这种模型允许我们对composite and individual objects进行相同的操作，在这里就表现为对menu item and menu都可以执行相同的操作。
模型类架构图：
首先需要定义一个虚父类component，将所有可以进行的操作放到里面；
Public abstract class Component {
Operation();
Add(component);
Remove(component);
getChild(int);
}
然后，针对composite and individual node实现两种类：
Class leaf { 
Operation();
}
Class composite {
	Add(component);
	Remove(component);
	getChild();
	operation();
}
我们可以看到，实现的这两个类对父类中的函数是有选择的进行Override的，因为有些操作对leaf而言是无意义的，而有的操作可能对composite是无意义的，所以选择性进行override。这也是父类component设计为虚类而非接口的原因，因为在父类中要对所有函数都进行default implementation。
针对关于menu的具体问题，类设计如下：
父类 MenuComponent
Public abstract class MenuComponent {
getName(){xx}
getDescription(){xx}
getPrice(){xx}
isVegetarian(){xx}
print(){xx}
add(component){xx}
remove(component){xx}
getChild(int){xx}
}
然后创建两个子类：
Class MenuItem{ xxx }
Class Menu { xxx }
最关键的地方在于以上三个类中所有method的具体实现。
将Iterator + composite两种模式结合起来：
需要在menuCompoent父类中添加createIterator()方法；
menuItem是没有iterator概念的，所以menuItemIterator直接返回NullIterator（类似于NoCommand的思想）；
menu返回的iterator定义为compositeIterator，这个的实现有些复杂。
可以看出，两种模式结合起来使用的总体架构和iterator是相似的，只是其中的menu 换成了menuComponent，而且每种具体iterator的实现更复杂了些，但总体类的架构是和之前的iterator相同的。
Demo code url:
https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/composite/menuiterator
