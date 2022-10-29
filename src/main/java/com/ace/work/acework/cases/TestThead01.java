/*
package com.ace.work.acework.cases;

import lombok.extern.slf4j.Slf4j;

import static com.ace.work.acework.cases.DelayQueueUtil.*;

*/
/**
 * @author yd  惊蛰
 * @version 1.0
 * 功能描述：
 * @date 2022/5/28 10:38 上午
 *//*

@Slf4j
public class TestThead01<T> implements Runnable{


    @Override
    public void run() {
        while (true) {
            try {
                DelayMessage<T> delayMessage = (DelayMessage<T>) DELAY_QUEUE.take();
                // 只有当map里面有该uuid对应的消息，才执行回调方法
                if (CONSUMER_MAP.containsKey(delayMessage.getUuid())) {
                    // 执行回调方法
                    log.info("任务到期: "+Thread.currentThread().getName()+" msg:"+delayMessage.getBody());
                    log.info("队列: "+Thread.currentThread().getName()+" msg:"+THREAD_POOL.getQueue().size());
                    consumer.accept(delayMessage.getBody());
                    //execCall(consumer, delayMessage);
                }
            } catch (InterruptedException e) {
                log.info("InterruptedException "+"队列: "+Thread.currentThread().getName()+" msg:"+THREAD_POOL.getQueue().size());
                STARTING.set(false);
            }
        }
    }
}
*/
