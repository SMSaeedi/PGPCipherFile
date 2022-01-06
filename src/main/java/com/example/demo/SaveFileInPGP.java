package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

/**
 * Created by saeedi_m on 15/07/20.
 */

//PGP = pretty good privacy
public class SaveFileInPGP {

    private static String inFile = "file:///ManaFile/in/";
    private static String outFile = "file:///ManaFile/out/";
    private static final String key = "file:E:\\public.asc";

//    public static void encryption(String publicKey) throws Exception {
//        String cipheredFile = "file:E:\\OUT?fileName=mana_cardEnrollment_v01_13970907_01.out";
//        CamelContext camelContext = new DefaultCamelContext();
//        camelContext.addRoutes(new RouteBuilder() {
//            public void configure() throws Exception {
//                from(inFile).marshal().pgp(publicKey, "")
//                        .to(cipheredFile);
//            }
//        });
//        camelContext.start();
//        Thread.sleep(5000);
//        camelContext.stop();
//    }

//    public static void encryption1() throws Exception {
//        CamelContext camelContext = new DefaultCamelContext();
//        camelContext.addRoutes(new RouteBuilder() {
//            public void configure() throws FileNotFoundException {
//                String keyUserid = "";
//                from(from)
//                        .log("file received")
//                        .marshal().pgp(key, keyUserid)
//                        .to(to);
//            }
//        });
//        camelContext.start();
//        Thread.sleep(500);
//        camelContext.stop();
//    }

//    public static void main(String[] args) {
//        try {
//            SaveFileInPGP.encryption1();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) throws Exception {
//        MyCamel testMyCamel = new MyCamel();
//        Main main = testMyCamel.encrypt();
//        Thread.sleep(1000);
//        System.out.println("after run");
//        main.stop();
//    }

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.addRouteBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(inFile)
                        .log("file received")
                        .marshal().pgp(key, "")
                        .to(outFile);
            }
        });
        MyCamel r = new MyCamel(5000, camel);
        r.execute();
        camel.run();
    }
}