package edu.hw6;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Task6 {
    private Task6() {}

    private final static int PORTS_AMOUNT = 49152;
    private final static int ROWS_AMOUNT = 101;

    private final static Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("MagicNumber")
    public static void portsScanner() throws IOException {
        ArrayList<String> status = new ArrayList<>();

        for (int i = 0; i <= PORTS_AMOUNT; ++i) {
            try (ServerSocket server = new ServerSocket(i)) {
                status.add("OPENED");
            } catch (IOException e) {
                status.add("CLOSED");
            }
        }

        Document document = Jsoup
            .connect("https://www.iana.org/assignments/service-names-port-numbers/service-names-port-numbers.xhtml?&page=3")
            .get();

        var rows = document.select("tr");
        LOGGER.info("%-10s%-6s%-10s%s".formatted("Protocol", "Port", "Status", "Description"));

        for (int i = 1; i <= ROWS_AMOUNT; ++i) {
            var cols = rows.get(i).select("td");

            int port = Integer.parseInt(cols.get(1).text());
            String protocol = cols.get(2).text().toUpperCase();
            String description = cols.get(3).text();

            String content = "%-10s%-6d%-10s%s".formatted(protocol, port, status.get(port), description);
            LOGGER.info(content);
        }
    }
}
