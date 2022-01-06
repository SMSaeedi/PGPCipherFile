package com.example.demo;

import org.apache.camel.main.Main;

/**
 * Created by saeedi_m on 18/08/20.
 */

public class MyCamel implements Runnable {

    private long waitingFor = -1;
    private Main camel;

    public MyCamel(long waitingFor, Main camel) {
        this.waitingFor = waitingFor;
        this.camel = camel;
    }

    public void execute() {
        Thread thread = new Thread(this);
        System.out.println("before run");
        thread.start();
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                this.wait(waitingFor);
            }
        } catch (InterruptedException e) {
            e.getMessage();
            e.printStackTrace();
        }
        try {
            System.out.println("after run");
            camel.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    private Main main = new Main();
    private String inFile = "file:///ManaFile/in/";
    private static String outFile = "file:///ManaFile/out/";
    private static final String key = "file:E:\\public.asc";

    public MyCamel(String inFile) {
        this.inFile = inFile;
    }

    public MyCamel() {
    }

    public Main encrypt() {
        main.addRouteBuilder(new RouteBuilder() {
            public void configure() {
                from(inFile)
                        .log("file received")
                        .marshal().pgp(key, "")
                        .to(outFile);
            }
        });
        Thread t = new Thread(this);
        t.start();
        return main;
    }*/

//    @Override
//    public void run() {
//        try {
//           main.run();
//        } catch (Exception e) {
//            e.getMessage();
//            e.printStackTrace();
//        }
//    }
}