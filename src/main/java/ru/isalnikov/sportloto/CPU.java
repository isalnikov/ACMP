package ru.isalnikov.sportloto;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * https://github.com/wizzardo/highloadcup/blob/master/src/main/java/ru/highloadcup/App.java
 * 
 * @author Igor Salnikov isalnikov.com
 */
public class CPU {

    public static String exec(String cmd) {
        try {
            Process process;
            process = Runtime.getRuntime().exec(cmd);
            int result = process.waitFor();
//            if (result != 0)
//                throw new IllegalArgumentException("Process ended with code: " + result);

            byte[] bytes = new byte[1024];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = process.getInputStream();
            InputStream err = process.getErrorStream();
            int read;
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.write("\n".getBytes());
            while ((read = err.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            err.close();
            out.close();
            return new String(out.toByteArray(), StandardCharsets.UTF_8).trim();
        } catch (IOException | InterruptedException e) {
        }
        return null;
    }
    
    private static void bindIoThreadToCpu() {
        String exec = exec("ps -aux");
        exec = Arrays.stream(exec.split("\n")).filter(s -> s.contains("solution.jar") || s.contains("solution-all-1.0-SNAPSHOT.jar")).findFirst().get();
        System.out.println(exec);
        String[] split = exec.split("\\s+");
        String pid = split[1];
        System.out.println("pid: " + pid);
        exec = exec("jstack " + pid);
//        System.out.println(exec);
        for (int i = 0; i < Math.min(Runtime.getRuntime().availableProcessors(), 4); i++) {
            bindIoThreadToCpu(i, exec);
        }
//        exec = Arrays.stream(exec.split("\n")).filter(s -> s.contains("Thread-0")).findFirst().get();
//        System.out.println(exec);
//        String threadID = TextTools.find(exec, Pattern.compile("nid=0x([0-9a-fA-F]+)"), 1);
//        System.out.println("threadID: " + threadID + " " + Integer.parseInt(threadID, 16));
//        exec = exec("taskset -p -c 0 " + Integer.parseInt(threadID, 16));
//        System.out.println(exec);
//        exec = exec("chrt -f -p 20 " + Integer.parseInt(threadID, 16));
//        System.out.println(exec);
    }

    private static void bindIoThreadToCpu(int i, String jstack) {
        String exec = Arrays.stream(jstack.split("\n")).filter(s -> s.contains("IOThread-" + i)).findFirst().get();
       // String threadID = TextTools.find(exec, Pattern.compile("nid=0x([0-9a-fA-F]+)"), 1);
       // System.out.println("threadID: " + threadID + " " + Integer.parseInt(threadID, 16));
       // exec = exec("taskset -p -c " + i + " " + Integer.parseInt(threadID, 16));
        System.out.println(exec);
    }
}
