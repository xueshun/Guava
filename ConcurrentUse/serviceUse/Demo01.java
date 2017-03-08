package serviceUse;
/**
 * Guava包里的Service接口用于封装一个服务对象的运行状态、包括start和stop等方法。
 * 例如web服务器，RPC服务器、计时器等可以实现这个接口。
 * 对此类服务的状态管理并不轻松、需要对服务的开启/关闭进行妥善管理、特别是在多线程环境下尤为复杂。
 * Guava包提供了一些基础类帮助你管理复杂的状态转换逻辑和同步细节。
 * @author Administrator
 * 
 * 一个服务正常生命周期有：
       
       Service.State.NEW
       Service.State.STARTING
       Service.State.RUNNING
       Service.State.STOPPING
       Service.State.TERMINATED   
       
       服务一旦被停止就无法再重新启动了。
       如果服务在starting、running、stopping状态出现问题、会进入Service.State.FAILED.状态。
       调用 startAsync()方法可以异步开启一个服务,同时返回this对象形成方法调用链。
       注意：只有在当前服务的状态是NEW时才能调用startAsync()方法，
       因此最好在应用中有一个统一的地方初始化相关服务。
       停止一个服务也是类似的、使用异步方法stopAsync() 。
       但是不像startAsync(),多次调用这个方法是安全的。
       这是为了方便处理关闭服务时候的锁竞争问题。
       
   Service也提供了一些方法用于等待服务状态转换的完成：
   		1.addListener() 方法一部添加监听器，此方法允许你添加一个Service.Listener,
   			它会在每次服务状态转换的时候被调用。注意：最好在服务启动之前添加Listener(这
   			时的状态是NEW),否则之前已发生的状态转换时间是无法再新添加的Listener上被重新触发的
   		2.awaitRunning().同步使用。这个方法不能被打断、不强制捕获异常、一旦服务启动就会返回。
   			如果服务没有成功启动，会抛出IllegalStateException异常。
   		          同样的， awaitTerminated() 方法会等待服务达到终止状态（TERMINATED 或者 FAILED）。
   		          两个方法都有重载方法允许传入超时时间。
   		          
   	Guava 
   		1.AbstractIdleService类简单实现了Service接口、其在running状态时不会执行任何动作–
   			因此在running时也不需要启动线程–但需要处理开启/关闭动作。
   			要实现一个此类的服务，只需继承AbstractIdleService类，然后自己实现startUp() 和
   			shutDown()方法就可以了。
   			
       	    protected void startUp() {
		    	servlets.add(new GcStatsServlet());
		    }
	        protected void shutDown() {}
	        
	    2.AbstractExecutionThreadService 通过单线程处理启动、运行、和关闭等操作。你必须重载run()方法，同时需要能响应停止服务的请求。
	    	具体的实现可以在一个循环内做处理：
	    	public void run(){
	    		while(isRunning()){
	    			//perform a unit of work
	    		}
	    	}
	    	另外，你还可以重载triggerShutdown()方法让run()方法结束返回。
	    	重载startUp()和shutDown()方法是可选的，不影响服务本身状态的管理
	    	
	    	 protected void startUp() {
				dispatcher.listenForConnections(port, queue);
			}
			protected void run() {
				 Connection connection;
				  while ((connection = queue.take() != POISON)) {
				     process(connection);
				   }
			}
			protected void triggerShutdown() {
				  dispatcher.stopListeningForConnections(queue);
				  queue.put(POISON);
			}
			
			
		3.AbstractScheduledService类用于在运行时处理一些周期性的任务。
			子类可以实现 runOneIteration()方法定义一个周期执行的任务，以及相应的startUp()
			和shutDown()方法。为了能够描述执行周期，你需要实现scheduler()方法。
			通常情况下，你可以使用AbstractScheduledService.Scheduler类提供的两种调度器：
			newFixedRateSchedule(initialDelay, delay, TimeUnit)  
			和newFixedDelaySchedule(initialDelay, delay, TimeUnit)，类似于JDK并发包中
			ScheduledExecutorService类提供的两种调度方式。
			如要自定义schedules则可以使用 CustomScheduler类来辅助实现；
			
		4.AbstractService 如需要自定义的线程管理，可以通过扩展AbstractService类来实现。
			一般情况下，使用上面的几个实现类就已经
 
 */
public class Demo01 {

}
