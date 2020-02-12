package cn.xysomer.create.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 并发器
 */
public class ConcurrentExecutor {

    /**
     * @param runHandler
     * @param executeCount    发起请求总数
     * @param concurrentCount 同时并发执行的线程数
     * @throws Exception
     */
    public static void execute(final RunHandler runHandler, int executeCount, int concurrentCount) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();//创建线程池
        //信号量，用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(concurrentCount);
        //闭锁，可实现计数量递减
        final CountDownLatch countDownLatch = new CountDownLatch(executeCount);
        for (int i = 0; i < executeCount; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //执行此方法用于获取执行许可，若未释放线程数不超过 executeCount 时，允许通行，否则阻塞等待，直到获取到许可。
                        semaphore.acquire();//获取许可
                        runHandler.handler();

                        //释放许可
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();//闭锁值个数减1
                }
            });
        }
        countDownLatch.await();//进入阻塞等待，直到闭锁的值为0时，阻塞才释放，继续往下执行
        executorService.shutdown();//停止接收新任务，原来的任务继续执行
    }

    public interface RunHandler {
        void handler();
    }
}
