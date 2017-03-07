package loadingCacheUse;

import java.util.concurrent.Callable;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * cache的参数说明
 * 	　回收的参数：
　　1. 大小的设置：CacheBuilder.maximumSize(long)  CacheBuilder.weigher(Weigher)  CacheBuilder.maxumumWeigher(long)
　　2. 时间：expireAfterAccess(long, TimeUnit) expireAfterWrite(long, TimeUnit)
　　3. 引用：CacheBuilder.weakKeys() CacheBuilder.weakValues()  CacheBuilder.softValues()
　　4. 明确的删除：invalidate(key)  invalidateAll(keys)  invalidateAll()
　　5. 删除监听器：CacheBuilder.removalListener(RemovalListener)
　　

　　refresh机制：
　　1. LoadingCache.refresh(K)  在生成新的value的时候，旧的value依然会被使用。
　　2. CacheLoader.reload(K, V) 生成新的value过程中允许使用旧的value
　　3. CacheBuilder.refreshAfterWrite(long, TimeUnit) 自动刷新cache
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) throws Exception {
		Cache<String, String>cache = CacheBuilder
				.newBuilder()
				.maximumSize(1000)
				.build();
		String resultVal = cache.get("jerry", new Callable<String>() {

			@Override
			public String call() throws Exception {
				String strProValue = "hello " +"jerry"+"!";
				return strProValue;
			}
		});
		
		 System.out.println("jerry value : " + resultVal);
		
		resultVal = cache.get("peida", new Callable<String>() {  
            public String call() {  
                String strProValue="hello "+"peida"+"!";                
                return strProValue;
            }  
        });  
        System.out.println("peida value : " + resultVal);  
	}
}
