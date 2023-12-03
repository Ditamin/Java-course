package edu.hw8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
    class FamousQuotesServer {
        private static final HashMap<String, String> QUOTES = new HashMap<>(Map.of(
            "личности", "Не переходи на личности там, где их нет",
            "оскорбления", "Если твои противники перешли на личные оскорбления,"
                + " будь уверена — твоя победа не за горами",
            "глупый", "Чем ниже интеллект, тем громче оскорбления"
        ));

        private final static int N_THREADS = 5;
        private final static int PORT = 3345;
        private static ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

        public void run() {
            try (ServerSocket server = new ServerSocket(PORT)) {
                while (true) {
                    Socket client = server.accept();
                    executor.execute(new MonoThreadClientHandler(client));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public class MonoThreadClientHandler implements Runnable {
            static Socket client;

            MonoThreadClientHandler(Socket client) {
                MonoThreadClientHandler.client = client;
            }

            @Override
            public void run() {
                try {
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());
                    DataInputStream in = new DataInputStream(client.getInputStream());

                    while (!client.isClosed()) {
                        String message = in.readUTF();

                        if (QUOTES.containsKey(message)) {
                            out.writeUTF(QUOTES.get(message));
                        } else {
                            out.writeUTF("Не найдено цитаты с таким словом");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Client {

    }
}
