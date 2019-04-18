package ru.isalnikov.sportloto.socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ru.isalnikov.sportloto.util.UtilException.rethrowConsumer;
import static ru.isalnikov.sportloto.util.UtilException.uncheck;

/**
 * run $telnet localhost 8080
 *
 * https://www.youtube.com/watch?v=Yi_m6ju4MTQ
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class SimpleServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        ExecutorService service = Executors.newCachedThreadPool();

        System.out.println("SimpleServer start...");
        while (true) {
            Socket s = ss.accept();
            service.execute(() -> {

                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    OutputStream out = s.getOutputStream();
                    in.lines().forEach(
                       line -> {
                        try {
                            out.write(("Echo : " + line + "\n").getBytes());
                        } catch (IOException ex) {
                            Logger.getLogger(SimpleServer.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });
                    s.close();

                } catch (IOException e) {
                    System.err.println(e);
                }

            });

        }

    }

}
