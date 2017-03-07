package listenableFutureUse;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Guava 为java并发编程提供了很多有用扩展，其主要接口为ListenableFuture，并借助于Future
 * 静态扩展
 * 	
 * 	继承Future的ListenableFuture，允许我们添加回调函数在线程运算完返回值或者方法执行完成
 * 		立即返回
 * 		Futures.addCallback(ListenableFuture<V>,FutureCallback<V>,Executor)
 * 
 * 
 * Guava中Futures对于Future扩展有：
 * 		1.transform:对于ListenableFuture的返回值进行转换
 * 		2.allAsList：对于ListenableFuture的合并，返回一个当所有Future成功时返回多个Future返回值组成的List
 * 		   对象。注：当其中一个Future失败或者取消的时候，将会进入失败或者取消
 * 		3.successfulAsList:和allAsList相似，唯一差别是对于失败或者取消的Future返回值用null替代。不会进入失败
 * 		  或者取消流程。
 * 		4.immediateFuture/immediateCancelledFuture：立即返回一个待返回值得ListenableFuture.
 * 		5.makeChecked: 将ListenableFuture 转换成CheckedFuture. CheckedFuture是一个ListenableFuture,其中包含了多个
 * 			版本的get方法，方法声明抛出异常，止痒是的创建一个在执行逻辑中可以抛出异常的Future更加容易
 * 		6.jdkFutureAdapters.listenInPoolThread(future):
 * @author Administrator
 *
 */
public class Demo01 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		
		@SuppressWarnings("rawtypes")
		ListenableFuture future1 = service.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws InterruptedException {
				Thread.sleep(1000);
				System.out.println("call future 1.");
				return 1;
			}
		});
		
		@SuppressWarnings("rawtypes")
		ListenableFuture future2 = service.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Thread.sleep(1000);
				System.out.println("call future 2.");
				//throw new RuntimeException("-----call future 2.");
				return 2;
			}
		});
		
		@SuppressWarnings("rawtypes")
		final ListenableFuture allFutures = Futures.allAsList(future1,future2);
		
		@SuppressWarnings("rawtypes")
		final ListenableFuture transform = Futures.transform(allFutures, new AsyncFunction<List<Integer>, Boolean>() {

			@Override
			public ListenableFuture apply(List<Integer> results) throws Exception {
				
				return Futures.immediateFuture(String.format("success future:%d", results.size()));
			}
		});
		//Futures.makeChecked(allFutures, mapper)
		Futures.addCallback(transform, new FutureCallback<Object>() {

			@Override
			public void onSuccess(Object result) {
				System.out.println(result.getClass());
				System.out.printf("success with : %s%n",result);
			}

			@Override
			public void onFailure(Throwable thrown) {
				System.out.printf("onFailure%s%n",thrown.getMessage());
			}
		});
	}
}
