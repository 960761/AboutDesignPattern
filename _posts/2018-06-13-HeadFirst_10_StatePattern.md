### 问题：
眼下有一款游戏机Gamball，有四种状态，四种行为，一种状态到另一种状态通过一种action进行转换，现在 已知其状态转移图，需要构建实现代码。
### 解决方法：
最开始想到的是最原始的过程式编程，把每种action作为中心，判断可能的当前状态和转换到的状态，  
Void insert(){  
	If(state == xx){xxx}  
	If(state == xx){xxx}  
}  
当新增加一种状态时，需要做很大的代码改动，而且以上根本没有用到OO思想，
**改进如下：**
我们以每种状态为中心，当前状态在四种行为下的反应为具体实现，让每种状态自己管理自己的状态转移。  

首先，设计 state 接口  
Interface state { insertQ(); ejectQ(); }  
然后，每种具体的状态implement state interface，并具体实现四种行为下的状态转移；  
最后，定义GameMachine类，在类中包含各种具体状态的reference，并一直指示current state，  
因为最终client action都是对game machine操作的，所以这这个类中也要定义四种action method，但是具体的实现则是delegate  to current state来实现。  
比如GameMachine中，void intertQ(){ current.insertQ(); }  
改进之后，不仅符合OO原则，而且容易扩展，如果增加一种状态，只需创建一个新的state class即可。  
### State pattern:
Allows an object to alter its behavior when its internal state changes, the object will appear to change its class.  

### 模型类架构图：
一个抽象state class ，可以为抽象类（如果需要默认实现），也可以为接口；  
多个具体的state class，用来具体实现状态转移action；  
一个context，用来和外界直接接触并操作，即上面例子里的gameMachine。  
### Strategy and state：
两种实现的形式很相似，但是初衷和侧重点不同：  
Strategy 侧重an alternative to subclassing，动态选择，有操作者选择某种确定的具体行为；  
State 侧重an alternative to putting lots of conditionals in your context，动态选择，但是选择哪一个不是由外界决定的，而是由context的内在state决定的。
