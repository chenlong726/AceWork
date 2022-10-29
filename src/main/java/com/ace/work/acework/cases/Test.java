//package com.ace.work.acework.cases;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.UUID;
//
///**
// * @author yd  惊蛰
// * @version 1.0
// * 功能描述：
// * @date 2022/5/22 7:04 下午
// */
//@Slf4j
//public class Test {
//
//    public static void main(String[] args) {
//        log.info(System.currentTimeMillis() + "");
//        long delayTime = 1000;
//        // lambda表达式，将getMsg()，当做回调方法，来接收延迟消息
//        for(int i=0;i<20;i++){
//            DelayQueueUtil.submit(UUID.randomUUID().toString(), "消息"+i, Test::getMsg, delayTime+i*1000 );
//        }
//        log.info(" main "+DelayQueueUtil.THREAD_POOL.getCorePoolSize()+"\n"+
//                 " main "+DelayQueueUtil.THREAD_POOL.getPoolSize()+"\n"+
//                 " main "+DelayQueueUtil.THREAD_POOL.getTaskCount()+"\n"+
//                 " main "+DelayQueueUtil.THREAD_POOL.getCorePoolSize());
//        while(true){
//            try {
//                Thread.sleep(500);
//                log.info("队列数量："+DelayQueueUtil.THREAD_POOL.getQueue().size()
//                        +" 任务数量："+DelayQueueUtil.THREAD_POOL.getTaskCount()
//                        +" 活跃线程数量："+DelayQueueUtil.THREAD_POOL.getActiveCount());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static void getMsg(String msg) {
//        log.info("getMsg: "+Thread.currentThread().getName()+" msg:"+msg);
//    }
//}
//
///*
//输出：
//09:31:43.478 [main] INFO com.emdata.videomonitor.biz.thread.camera.DelayQueueUtil - 1617154303476
//09:31:43.513 [main] INFO com.emdata.videomonitor.biz.thread.camera.DelayQueueUtil - main
//09:31:45.514 [java_delay_thread_2] INFO com.emdata.videomonitor.biz.thread.camera.DelayQueueUtil - 消息1
//09:31:48.514 [java_delay_thread_3] INFO com.emdata.videomonitor.biz.thread.camera.DelayQueueUtil - 消息2
//*/
//
//
