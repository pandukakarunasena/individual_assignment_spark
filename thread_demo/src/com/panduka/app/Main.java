package com.panduka.app;

class Task1 implements Runnable{

    synchronized  Task1(){

    }
    @Override public void run() {
        for( int i = 0; i < 50; i++){
            System.out.println( Thread.currentThread().getName()+ ": task 1 is running");
        }
    }

}


class Task2 implements Runnable{

    @Override public void run() {
        for( int i = 0; i < 50; i++){
            System.out.println( Thread.currentThread().getName() + ": task 2 is running");
        }
    }

}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println( );

        Thread task1 = new Thread( new Task1());
        Thread task2 = new Thread( new Task2());

        task1.start();
        task2.start();

        //task1.join();
        //task2.join();

        System.out.println( Thread.currentThread().getName() + ": hello world");
    }
}
