package org.jiang.handler;

import org.jiang.model.MyBody;

public class MessageHanler {
    //没有设置默认的处理方法的时候，方法名是handleMessage
    //public void handleMessage(byte[] message){
    //    System.out.println("---------handleMessage-------------");
    //    System.out.println(new String(message));
    //}


    //通过设置setDefaultListenerMethod时候指定的方法名
    //public void onMessage(String message){
    //    System.out.println("---------onMessage-------------");
    //    System.out.println(message);
    //}

    public void onMessage(MyBody message){
        System.out.println("---------onMessage---MyBody-------------");
        System.out.println(message);
    }

    //以下指定不同的队列不同的处理方法名
    //public void onOrder(byte[] message){
    //    System.out.println("---------onorder-------------");
    //    System.out.println(new String(message));
    //}
    //
    //public void onPay(byte[] message){
    //    System.out.println("---------onpay-------------");
    //    System.out.println(new String(message));
    //}
    //
    //public void onInfo(byte[] message){
    //    System.out.println("---------oninfo-------------");
    //    System.out.println(new String(message));
    //}
}
