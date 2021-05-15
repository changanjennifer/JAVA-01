#### Java并发编程的知识点总结



##### Java 并发编程概述

​         由于CPU多核技术的普及，及互联网技术的发展，分布式应用需要支持多线程高并发应用，及更充分地利用CPU资源和OS资源。 由诸多大神，包括Doug Lea主持设计实现的Java 并发程序类库，为Java提供高效的高并发应用提供了基础。

​        多线程执行时，会因为资源竞争和线程间资源共享和同步等因素，出现线程安全问题。线程安全指在多线程环境下，保证多个线程并发执行同一段代码时，不会出现不确定的结果，也不会出现与单线程执行不一致的结果，也就是保证多线程对共享状态操作的正确性。

并发相关的几个性质：

- 原子性（Atomicity): 指令必须有不可分割性。Java中对基本类型的读取和赋值操作是原子性的。

- 可见性(Visibility): 在什么情况下一个线程的效果对于另一个线程是可见的。Java中volatile指令保证变量的可见性。(synchronized 和Lock也保证同一时刻只有一个线程获取锁，并在释放之前将资料的修改同步到主存中)

- 有序性(Ordering): Java允许编译器和处理器对指令进行重排，重排序过程不会影响单线程执行，但会影响到多线程并发执行的正确性。volatile ，synchronized, Lock指令能保证一定的"有序性"。Java设计上遵循happens-before原则。

  

JDK1.6之后，Java提供了并发工具类包 java.util.concurrent (简称JUC)， 对并发编程中所需的模型及工具进行了良好的封装。

#### JUC的一些工具类包

##### 锁： 

-    Lock：开销小，可中断的锁 
-    Condition：Lock对象上的信号，类似于wait/notify
-    ReentrantLock：可重入锁，公平或非公平锁
-    ReadWriteLock：读写锁，适用于读多写少的并发情况
-    LockSupport : 锁定当前线程

##### 原子操作类：

  JUC提供了一些原子操作类，用于实现需要体现原子性的情景，AtomicInteger，AtomicLong,AtomicAddr等。

线程池相关：

​     Executor, ExecutorService,  Future(回调), Cal

lable(回调）,

##### 线程间协作：

​    JUC提供多个线程工具类：CountDownLatch,  CyclicBarrier,Semaphore等。

##### 安全集合类：

​    JAVA 原有的一些集合类（LinkedList, HashMap等）在并发环境下，会发生写冲突及读写冲突。

​    JUC 基于锁及无锁的机制，设计了一系列的线程安全的集合类，

- 以CopyOnWriteArrayList 为例，在多线程下集合类做了特殊的处理。 无锁并发读，但对于写入操作加锁，并且更新时是在一个副本上做更新（GC young区时用复制，old区用本区内的移动），而不是直接在原数据上做更新， 这样保证读写分离，数据最终的一致性。

- ConcurrentHashMap 在JDK1.7用分段加锁的方式，提高加锁的效率，在1.8中，用大的数组，CAS无锁机制实现并发处理。

##### 其他内容包括：

- ThreadLocal,  

- 并行stream 


将Java并发的内容整理成思维导图如下：

![https://github.com/changanjennifer/JAVA-01/blob/main/Summary/images/Java-multithread.png](https://github.com/changanjennifer/JAVA-01/blob/main/Summary/images/Java-multithread.png)







