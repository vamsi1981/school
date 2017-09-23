package com.pkg.utilities;

import java.io.IOException;

public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();
        
        private ThreadLocal<String> threadLocal3 =
                new ThreadLocal<String>();
        
        private String threadLocal4 =
                new String();
        
        private Integer threadLocal2 = new Integer(23);
        
        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );
            threadLocal3.set("vamsi");
            threadLocal4= threadLocal4.concat("vamsi");
            threadLocal2++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get());
            System.out.println("threadLocal2 "+threadLocal2);
            System.out.println("threadLocal3 "+threadLocal3.get());
            System.out.println("threadLocal4 "+threadLocal4);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}
