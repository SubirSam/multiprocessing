package org.multiprocess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world!");
        System.out.println("today we are going for multiprocessing in java!!!!");
        // to create seperate process with external command
        ProcessBuilder processBuilder = new ProcessBuilder("java" ,"--version");
        ProcessBuilder processBuilder1 = new ProcessBuilder("ls","-l");
        ProcessBuilder processBuilder2 = new ProcessBuilder("system_profiler", "SPDisplaysDataType");
        // start the process and get process id to print
        Process p = processBuilder.start();
        System.out.println(p.pid());
        Process p1 = processBuilder1.start();
        System.out.println(p1.pid());
        Process p2 = processBuilder2.start();
        System.out.println(p2.pid());

        // Capture the output of process 1
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line1;
        while ((line1 = reader1.readLine()) != null) {
            System.out.println(line1);
        }

        // Capture the output of process 2
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String line2;
        while ((line2 = reader2.readLine()) != null) {
            System.out.println(line2);
        }

        // Capture the output of process 3
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        String line3;
        while ((line3 = reader3.readLine()) != null) {
            System.out.println(line3);
        }
        p.waitFor();
        p1.waitFor();
        p2.waitFor();
    }
}