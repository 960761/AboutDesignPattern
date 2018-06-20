### 问题：
现在有一个遥控器，要用来控制家里的电器，比如灯，风扇等，眼下有的就是遥控器和厂家提供的灯，风扇的类；如何设计类来实现遥控灯和风扇？
### 解决方法：
先通过点餐来对比理解 Command模式：  
首先，客人点餐，makeOrder()；  
然后，服务员将order传递到后厨，并提醒后厨接单；orderUp()；  
最后，后厨负责做饭；prepareOrder()；  
从上面可以看到，服务员和后厨是互相解耦的，任何一个order 只要实现了orderUp()方法都可以被服务员调用(orderup, make a request)，触发实际的操作(prepare order)  

**以开灯为例来简单实现提出的遥控器问题：**  
首先定义统一接口（类似于orderUp()）command：

    Public interface Command { public void execute(); } 

然后实现具体命令：  

    Public class lightOnCommand implements Command{  
      Light light;  
      Public lightOnCommand(Light light){this.light = light; }//将具体的receiver 传给command  
      Public void execute(){ light.on(); }// 执行具体的操作  
    } 

最后使用此command:  

    Public class control(){  
      Command slot;  
      SetCommand(Command cmd){ this.slot = cmd;}//这里将具体的command传给control  
      Public void runCmd(){ slot. Execute(); }  
    }

运行： 

        Control control;  
        Light light = new Light();  
        lightOnCommand  onCmd = new lightOnCommand(light); //传入具体的receiver and action，创建具体command  
        control.setCommand(onCmd);//传入invoker  
        control.runCmd(); 

### Demo
Click [here](https://github.com/960761/AboutDesignPattern/tree/master/code/HeadFirst_DesignPattern/ch06_CommandPattern/src) for two demos.

### Command pattern:
核心思想为：   
separate  object making a request from object that receive and execute the request
### 模式类构建模型：
首先，要有receiver 类，也即接受request的物体，这里要定义出具体的操作，比如light, light.on()；  
其次，创建抽象command类和具体的command类；也即具体实现command–excute()方法，也即将receiver, action进行连接；  
最后，将以上concrete command传给invoker（这里为control）就可以触发实现具体的command了。  
### 总结：
这种模式的本质思想和实现方式和第一种strategy模式基本是相同的，侧重点不同，  
strategy模式侧重的是将变化的行为拿出来进行单独封装，利用组合的形式动态绑定具体行为；  
command模式侧重的是请求和具体实现的分离，将具体的实现拿出去单独封装，也是利用组合的形式来实现。  
