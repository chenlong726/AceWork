//package com.ace.work.acework.cases;
//
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Map;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.function.Consumer;
//
///**
// * @author yd  惊蛰
// * @version 1.0
// * 功能描述：
// * @date 2022/5/22 7:00 下午
// */
//@Slf4j
//public class DelayQueueUtil {
//    private static final Map<String, Consumer<?>> CONSUMER_MAP = new ConcurrentHashMap<>();
//    private static final AtomicBoolean STARTING = new AtomicBoolean();
//
//    /**
//     * 延迟队列
//     */
//    private static final DelayQueue<DelayMessage<?>> DELAY_QUEUE = new DelayQueue<>();
//    private static final Integer DELAY_QUEUE_MAX_SIZE = 1000;
//
//    private static final int CORE_POOL_SIZE = 8;
//    private static final int MAXIMUM_POOL_SIZE = 20;
//    private static final long KEEP_ALIVE_TIME = 20;
//    private static final TimeUnit UNIT = TimeUnit.SECONDS;
//    private static final int MAXIMUM_ARRAY_SIZE = 1000;
//    private static final ThreadFactory THREAD__FACTORY = new ThreadFactoryBuilder().setNameFormat("java_delay_thread_%d").build();
//
//    /**
//     * 执行读取任务的线程池
//     */
//    public static final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(
//            CORE_POOL_SIZE,
//            MAXIMUM_POOL_SIZE,
//            KEEP_ALIVE_TIME,
//            UNIT,
//            new ArrayBlockingQueue<>(MAXIMUM_ARRAY_SIZE),
//            THREAD__FACTORY);
//
//
//    /**
//     * 提交一个延迟消息
//     * @param uuid 消息的uuid
//     * @param msg 消息对象
//     * @param consumer 延迟到期后回到方法
//     * @param delayTime 延迟时间，毫秒
//     * @param <T> 消息对象类型
//     * @return true: 提交成功
//     */
//    public  static <T> boolean submit(String uuid, T msg, Consumer<T> consumer, long delayTime) {
//        if(DELAY_QUEUE.size()>DELAY_QUEUE_MAX_SIZE){
//            log.warn("delay_queue size is exceed maxsize,can not add task! ");
//            return true;
//        }
//        DelayMessage<T> delayMessage = new DelayMessage<>(uuid, msg, delayTime);
//        addTask(uuid, consumer);
//        return DELAY_QUEUE.offer(delayMessage);
//    }
//
//    /**
//     * 取消一个延迟消息
//     * @param uuid 消息的uuid
//     * @return true: 取消成功
//     */
//    public static boolean cancel(String uuid) {
//        return CONSUMER_MAP.remove(uuid) != null;
//    }
//
//    /**
//     * 添加任务，懒加载开启消费线程
//     * @param uuid 消息的uuid
//     * @param consumer 回调方法
//     * @param <T> 消息对象类型
//     */
//    private static <T> void addTask(String uuid, Consumer<T> consumer) {
//        CONSUMER_MAP.put(uuid, consumer);
//
//        // STARTING 是false，则开启监听队列的线程
//        if (!STARTING.compareAndSet(false, true)) {
//            return;
//        }
//        THREAD_POOL.execute(() -> {
//            while (STARTING.get()) {
//                try {
//                    DelayMessage<T> delayMessage = (DelayMessage<T>) DELAY_QUEUE.take();
//                    // 只有当map里面有该uuid对应的消息，才执行回调方法
//                    if (CONSUMER_MAP.containsKey(delayMessage.getUuid())) {
//                        // 执行回调方法
//                        log.info("任务到期: "+Thread.currentThread().getName()+" msg:"+delayMessage.getBody());
//                        log.info("队列: "+Thread.currentThread().getName()+" msg:"+THREAD_POOL.getQueue().size());
//                        consumer.accept(delayMessage.getBody());
//                        //execCall(consumer, delayMessage);
//                        //throw new InterruptedException();
//                    }
//                } catch (InterruptedException e) {
//                    log.info("InterruptedException "+"队列: "+Thread.currentThread().getName()+" msg:"+THREAD_POOL.getQueue().size());
//                    STARTING.set(false);
//                }
//            }
//            try {
//                Thread.sleep(3000);
//                log.info("线程名称: "+Thread.currentThread().getName()+" 最终队列任务数:"+THREAD_POOL.getQueue().size());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
////    private static <T> void execCall(Consumer<T> consumer, DelayMessage<T> delayMessage) {
////        CONSUMER_MAP.remove(delayMessage.getUuid());
////        THREAD_POOL.execute(() ->{
////                    log.info("添加回调任务: "+Thread.currentThread().getName()+" msg:"+delayMessage.getBody());
////                    consumer.accept(delayMessage.getBody());
////                });
////        log.info("队列: "+Thread.currentThread().getName()+" msg:"+THREAD_POOL.getQueue().size());
////    }
//}
//
