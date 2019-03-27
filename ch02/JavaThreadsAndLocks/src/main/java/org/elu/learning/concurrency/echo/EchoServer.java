package org.elu.learning.concurrency.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void echo() throws IOException {
        class ConnectionHandler implements Runnable {
            private InputStream in;
            private OutputStream out;

            private ConnectionHandler(Socket socket) throws IOException {
                in = socket.getInputStream();
                out = socket.getOutputStream();
            }

            public void run() {
                try {
                    int n;
                    byte[] buffer = new byte[1024];
                    while ((n = in.read(buffer)) != -1) {
                        out.write(buffer, 0, n);
                        out.flush();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        ServerSocket server = new ServerSocket(4567);
        while (true) {
            Socket socket = server.accept();
            Thread handler = new Thread(new ConnectionHandler(socket));
            handler.start();
        }
    }
}
