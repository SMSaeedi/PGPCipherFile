//package com.example.demo;
//
//import com.didisoft.pgp.PGPLib;
//import lw.bouncycastle.openpgp.PGPException;
//
//import java.io.*;
//
//public class CipherFile {
//
//    public static void main(String[] args) {
//        CipherFile cipherFile = new CipherFile();
//        try {
//            cipherFile.encryption1();
//        } catch (PGPException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void encryption() throws PGPException {
//        PGPLib pgp = new PGPLib();
//        boolean asciiArmor = false;
//        boolean withIntegrityCheck = false;
//        try {
//            pgp.encryptFile("input.in", "public.asc", "output.in", asciiArmor, withIntegrityCheck);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void encryption1() throws PGPException {
//        PGPLib pgp = new PGPLib();
//        boolean asciiArmor = false;
//        boolean withIntegrityCheck = false;
//        InputStream inStream = null;
//        InputStream key = null;
//        OutputStream outStream = null;
//
//        try {
//            inStream = new FileInputStream("F:\\Grant-Https\\branches\\PGPCipherFile\\src\\main\\resources\\input.in");
//            key = new FileInputStream("F:\\Grant-Https\\branches\\PGPCipherFile\\src\\main\\resources\\public.asc");
//            outStream = new FileOutputStream("F:\\Grant-Https\\branches\\PGPCipherFile\\src\\main\\resources\\output.in");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            pgp.encryptStream(inStream, "input.in", key, outStream, asciiArmor, withIntegrityCheck);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}