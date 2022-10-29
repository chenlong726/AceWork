package com.ace.work.acework.cases;

/**
 * @author yd  惊蛰
 * @version 1.0
 * 功能描述：
 * @date 2022/5/22 8:18 下午
 */
public class FunctionService {
    public static void  sendMsg (String msg){
        System.out.println("thread: "+Thread.currentThread().getName()+" msg:"+msg);
    }
}
