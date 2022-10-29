package com.ace.work.acework.cases;


import lombok.Getter;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yd  惊蛰
 * @version 1.0
 * 功能描述：
 * @date 2022/5/22 7:01 下午
 */
@Getter
public class DelayMessage<T> implements Delayed {

    private static final AtomicLong atomic = new AtomicLong(0);

    private final long n;

    private String uuid;

    /**
     * 消息内容
     */
    private T body;

    /**
     * 到期时间，这个是必须的属性因为要按照这个判断延时时长。
     */
    private long executeTime;

    /**
     * 延迟毫秒数
     */
    private long delayTime;

    public DelayMessage(String uuid, T body, long delayTime) {
        this.uuid = uuid;
        this.n = atomic.getAndIncrement();
        this.body = body;
        this.delayTime = delayTime;
        this.executeTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this) {
            return 0;
        }
        if (other instanceof DelayMessage) {
            DelayMessage x = (DelayMessage) other;
            long diff = executeTime - x.executeTime;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else if (n < x.n) {
                return -1;
            } else {
                return 1;
            }
        }
        long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : (d < 0 ? -1 : 1);
    }
}

