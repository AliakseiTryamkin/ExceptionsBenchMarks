package org.example;

import javax.naming.NameNotFoundException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("ALL")
public class GeneralFlowRun {

    public static void main(String[] args) {
        try {
            testException(-5);
            testException(15);
        } catch(FileNotFoundException e) {
            //some logic
            System.out.println("FileNotFoundException");
        } catch(IOException e) {
            //some logic
            System.out.println("IOException");
        } finally {
            System.out.println("Releasing resources");
        }
    }

    public static void testException(int i) throws IOException {
        if (i < 0) {
            throw new FileNotFoundException("Negative Integer " + i);
        } else if (i > 10) {
            throw new IOException("Only supported for index 0 to 10");
        }
    }

    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        try {
            return br.readLine();
        } finally {
            br.close();
            fr.close();
        }
    }

    static String readFirstLineFromFileWithFinallyBlock1(String path) throws IOException {
        try(FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        }
    }

    static String readFirstLineFromFileWithFinallyBlock2(String path) throws IOException {
        final FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        try(fr; br) {
            return br.readLine();
        }
    }

    public static int findAge(String name) {
        try {
            String ageAsString = findUser(name);
            return ageAsString.length();
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    private static String findUser(String name) throws NameNotFoundException {
        if (name == null) {
            throw new NameNotFoundException();
        }
        return name;
    }

    public static int findAgeNoEx(String name) {
        String ageAsString = findUserNoEx(name);
        return ageAsString.length();
    }

    private static String findUserNoEx(String name) {
        if (name == null) {
            return "";
        }
        return name;
    }

//    public void parseFile(String filePath) throws IOException {
//        try {
//            //code that forms an exception
//        } catch(IOException ex) {
//            LOGGER.error("IOException: ", ex);
//            throw ex;
//        }
//    }

    private String getName() {
        String name = "David";
        try {
            throw new IOException();
        } finally {
            return name;
        }
    }

}