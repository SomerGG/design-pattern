## 设计模式
#### 设计模式的类型
- 创建型模式
    - 工厂模式
    - 抽象工厂模式
    - 单例模式
    - 建造者模式
    - 原型模式
- 结构型模式
    - 适配器模式
    - 桥接模式
    - 过滤器模式
    - 组合模式
    - 装饰器模式
    - 外观模式
    - 享元模式
    - 代理模式
- 行为型模式
    - 责任链模式
    - 命令模式
    - 解释器模式
    - 迭代器模式
    - 中介者模式
    - 备忘录模式
    - 观察者模式
    - 状态模式
    - 空对象模式
    - 策略模式
    - 模板模式
    - 访问者模式
- J2EE 模式
    - MVC 模式
    - 业务代表模式
    - 组合实体模式
    - 数据访问对象模式
    - 前端控制器模式
    - 拦截过滤器模式
    - 服务定位器模式
    - 传输对象模式
#### 设计模式六大原则
- 单一原则：一个类或接口、方法只做一件事；
- 开闭原则：对扩展开放，对修改关闭；
- 里氏代换原则：子类可以复用父类的功能，但是不能改变父类对功能；
- 依赖倒置原则：通过接口或抽象类，使得各模块之间不相互影响，实现松耦合；
- 接口隔离原则：降低耦合度，接口单独设计，互相隔离；
- 迪米特法则，又称最少知道原则：功能模块尽量独立；
- 合成复用原则：尽量使用聚合，组合，而不是继承。

### 工厂模式
**简单工厂模式**  
定义：指由一个工厂对象决定创建出哪一种产品类的实例。根据传入的参数，工厂根据判断逻辑生成相应的对象实例。 

适用场景：客户端只需要传入工厂类的参数，对于如何创建对象的逻辑不需要关心。

优点：只需要传入一个正确的参数，就可以得到所需要的对象，对于创建的过程无须关注。

缺点：工厂类的职责过重，增加新的产品需要修改工厂类的判断逻辑，违背类开闭原则。

**工厂方法模式**  
定义：定义一个创建对象的接口，但是让实现这个接口当类来决定示例化哪个类，工厂方法让类的实例化推迟到子类中进行。
每一个工厂生成各自对应的实例。

适用场景：创建对象需要大量重复到代码；客户端不依赖于产品类实例如何被创建、实现等细节。一个类通过其子类来指定创建哪个对象。

优点：用户只需关心所需产品对应到工厂，无须关心创建细节；加入新产品符合开闭原则，提供来系统的可扩展性。

缺点：类的个数容易过多，增加了代码结构的复杂度；增加了系统的抽象性和理解难度。

**抽象工厂模式**  
定义：指提供一个创建一系列相关或相互依赖对象的接口，无须指定它们具体的类。

适用场景：客户端不依赖于产品类实例如何被创建、实现等细节；强调一系列相关的产品对象（属于同一产品族）一起使用创建对象需要
大量重复的代码；提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。

优点：具体产品在应用层代码隔离，无须关心创建细节；将一个系列的产品族统一到一起创建。

缺点：规定了所有可能被创建的产品集合，产品族中扩展新的产品困难，需要修改抽象工厂的接口，违背了开闭原则；
增加了系统的抽象性和理解难度。

### 单例模式  
定义：确保一个类在任意情况下都绝对只有一个实例，并提供一个全局访问点。

适用场景：确保任何情况下都只有一个实例。例如：ServletContext、ServletConfig、ApplicationContext、DBPool

**饿汉式单例**  
在类加载的时候就立即初始化，并且创建单例对象。绝对线程安全，在线程还没有出现之前就已经实例化了，
不可能存在访问安全问题。  

优点：没有加任何的锁、执行效率高，用户体验上比懒汉式好。

缺点：类加载的时候就进行初始化，不管用不用都占着空间，浪费内存空间。

Spring 中 ioc 容器 ApplicationContext 本身就是典型的饿汉式单例。


**懒汉式单例**  
被外部类调用时才会加载。

简单懒汉式，通过给对象实例化的方法加锁 synchronized 进行返回唯一实例并保障线程安全，缺点是效率低，在线程数量较多，
如果 CPU 分配压力上升，会导致大批量线程出现阻塞，从而导致程序运行性能大幅度下降。

通过 synchronized、volatile 关键字的双重检查锁来保障线程安全和兼顾性能。当第一个线程调用对象初始化方法时，第二个
线程也可以调用该方法，当第一个线程进入 synchronized 时会上锁，第二个线程进入 Monitor 状态，出现阻塞，此时的阻塞
并不是基于整个类的阻塞，而是在实例化方法内部的阻塞，只要逻辑不是特别复杂，对于调用者而言感知不到。

通过类初始化的角度，使用内部类的方式来避免 synchronized 的性能消耗，利用内部类一定要在方法调用之前初始化，巧妙
避过线程安全问题。

**反射破坏单例**  
之前的单例模式（懒汉式和饿汉式）构造方法除了加上 private 以外，没有做任何处理，如果我们使用反射调用获取到私有的构造
方法，然后再调用初始化方法，就会生成两个不同的实例。通过在类的构造方法中加入限制（判断对象是否已经被初始化过）来防止
对象多次创建。

**序列化破坏单例**  
序列化：将对象在内存中的状态转换为字节码形式，从而转换为 IO 流，写入到其他地方（磁盘、网络 IO），将对象在内存中的地址
永久地保存下来  

反序列化：将保存的字节码转换为 IO 流，通过 IO 流的读取，将读取的内容转换为 Java 对象，在转换的过程中会重新创建对象
并分配地址。

重写 readResolve 方法
**注册式单例**  
将每一个实例都缓存到统一都容器中，使用唯一标识获取实例。  
枚举实现  
容器式单例实现

**单例模式优点**  
在内存中只有一个实例，减少内存的开销；避免对资源的多重占用；设置全局访问点，严格控制访问。

**单例模式的缺点**  
没有接口，扩展困难；如果要扩展单例对象，只能修改代码，违背了开闭原则；


### 原型模式  
定义：原型实例指定创建对象的种类，并且通过拷贝（克隆）这些原型创建新的对象。调用者不需要知道创建的细节，不用调用构造函数。
例如：BeanUtils.copy(), Json.parseObject(), Guava。

适用场景：
- 类初始化消耗资源较多
- new 一个对象需要非常繁琐的过程（数据准备、访问权限等）
- 构造函数比较复杂
- 循环体中生产大量的对象

**浅拷贝**  
对基本数据类型进行值传递，对引用数据类型进行引用传递（拷贝的是引用的地址），所有的引用对象
仍然指向原来的对象。

**深拷贝**  
对基本数据类型进行值传递，对引用数据类型，创建一个新对象，并复制其内容。

原型模式就是如何快速构建对象的方法总结，简单工厂将 setter、getter 封装到某个方法中。实现
JDK 提供的 Cloneable 接口，实现快速复制。

**原型模式的缺点**  
必须配备克隆方法；对克隆复杂对象或克隆出的对象进行复制改造时，易带来风险。

**克隆破坏单例**  
如果克隆的目标对象是单例对象，意味着深拷贝就会破坏单例，防止措施很简单，禁止深拷贝即可：要么
单例不实现 Cloneable 接口；要么重写 clone() 方法，在 clone 方法中返回单例对象即可。

**Arrays 的 copy 方法**  
实现 Cloneable 接口，调用 父类的 clone 方法，把对象内部的元素一个一个的迭代，再进行赋值，
最后调用 JVM 提供的 native 方法 arraycopy，然后重新分配内存给克隆后的新对象。


### 代理模式  
定义：为其他对象提供一种代理，以控制这个对象的访问。代理对象在客户端和目标对象之间起到中介作用。
属于结构型设计模式。

适用场景：保护目标对象；增强目标对象。

优点：将代理对象与真实被调用的目标对象分离；一定程度上降低了系统的耦合性，易于扩展；代理可以起到
保护目标对象的作用；增强目标对象的职责。

缺点：增加类的数目；在客户端和目标对象之前增加类代理对象，造成请求处理速度变慢；增加了
系统的复杂性。

**静态代理**  
显示地声明被代理的对象

缺点：如果目标对象的功能发生改变，代理类也需要跟着变动，违背了开闭原则。

**动态代理**  
动态配置和替换被代理的对象

**JDK 动态代理生成对象的步骤**
- 拿到被代理对象的引用（通过构造方法传入），并且通过反射获取到它的所有接口。
- JDK Proxy 类重新生成一个新的类并且实现了被代理类所有接口的方法。
- 动态生成 Java 代码（在内存中完成），把增强的逻辑加入到新生成的代码中。
- 编译生成新的 Java 代码的 class 文件。
- 加载并运行新的 class 文件，得到的类就是全新类。  
以上过程称为**字节码重组**

JDK 动态代理对目标对象的类型没有限制，但是被代理的类必须要实现一个接口，因为在生成代理类时，已经继承
了 Proxy 类，Java 不支持多继承，所以只能通过实现接口。JDK 内部会扫描接口里面的所有方法并进行覆盖（且覆盖后的方法都是 final 的），
并加入相关增强的逻辑，重新生成一个全新的 Proxy 类。

JDK 动态代理为什么会生成一个新的类？  
因为原来的类已经编译过了，无法进行修改，想在原来的类上进行功能增强，只能通过实现接口来重新生成一个全新的类，
并覆盖里面的方法，将增强的逻辑加入新的类中。

**CGLib 动态代理**  
