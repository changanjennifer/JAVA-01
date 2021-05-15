#### 对Java NIO设计的一些认识



​        在没上课之前，对Java NIO，以为NIO 是非阻塞IO的意思。在听课之后，才理解了多种I/O模型。及Java NIO实际上是java 1.5以后提出的，与Java之前的阻塞模型（称为OIO，old IO) 相对应的，Java New IO,  并不仅仅是非阻塞式模型，也支持 I/O多路复用的通讯模型和异步I/O，能充分利用操作系统的更多epoll等技术，为高效的I/O通讯提供基础模型。

​        I/O读写的基础原理，是从内核缓冲区将用户所需资料进行缓冲区 进行复制。无论是Socket, 还是文件I/O操作，实际上都不是物理设备的直接操作，而是对缓存中资料的复制。Linux的I/O模型有如下5种：

- 阻塞式I/O

- 非阻塞式I/O

- I/O复用模型

- 信号驱动I/O模型

- 异步I/O模型

  从模型角度分析， I/O复用及信号驱动I/O和异步I/O，相比阻塞式I/O，能提供高可靠性、高吞吐量的通讯，适用于高并发的应用场景。 

#### Java NIO对象模型：

   在Java的NIO中，引入的几个主要对象模型为：

- ​     Buffer缓冲区：本质是内存数组，并提供了对数据的结构化访问及维护读写位置（limit) 等信息。 所有数据都是用缓冲区处理的，在读取数据时，它是直接读取缓冲区中的；写入时，写入到缓冲区中。

- ​     Channel 通道： 模拟了通讯连接，可以是与外部实体(硬件设备、文件及网络通讯socket)进行读/写，通道可以被打开及关闭，具有连接(connected)、断开(disconnected)等状态，可以单向也可以双向通讯。

- ​     Selector 多路复用器： 来轮询注册在其上的Channel, 发现某个或多个Channel， 若处于就绪状态，则进行I/O操作。可充分使用OS的 select/epoll功能。

  

#### Netty  NIO应用：

​         虽然Java NIO 提供了强大的模型能力，但这些对象的封装还比较初级，直接使用Java的NIO做通讯仍然相当不方便。一方面JAVA NIO类库有BUG，这些bug在之前很长一段时间都没能彻底解决。另一方面直接用NIO开发通讯程序，对工程师要求较高。因而，很多成熟的产品，其底层通讯都采用了Netty这一基于NIO的通讯框架。

​        Netty有着良好的封装，底层类库稳定可靠、开发效率高，已经成为业界公认的能提供高吞吐低延迟的可靠通讯框架之一。

​       Netty的基石之一，是其优秀的基于事件驱动的模型。而这个模型实现了大名鼎鼎的Reactor 线程模型，支持Reactor单线程模型、多线程模型，及主从多线程模型。



​      下图是个人理解的Java NIO 和Netty NIO通对象模型设计示意，从中去学习、理解Netty框架，以及模型建立的逐步抽象和实现过程。因为能力所限，图可能有错误之处，希望将来有时间仔细阅读Netty源码并实践时，能更新这部分的认知。

​       ![https://github.com/changanjennifer/JAVA-01/blob/main/Summary/images/NIO-jdknio%26Netty.png](https://github.com/changanjennifer/JAVA-01/blob/main/Summary/images/NIO-jdknio%26Netty.png)

   