package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public class Task5 {
    class HackerNews {
        private HackerNews() {}

        public static long[] hackerNewsTopStories() throws URISyntaxException, IOException, InterruptedException {
            try {
                var request = HttpRequest.newBuilder()
                    .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                    .GET()
                    .build();

                var response = newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

                return Arrays.stream(response.body()
                        .substring(1, response.body().length() - 1)
                        .split(",")).mapToLong(Long::parseLong)
                        .toArray();
            } catch (IOException e) {
                return new long[0];
            }
        }

        public static String news(long id) throws URISyntaxException, IOException, InterruptedException {
            var request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
                .GET()
                .build();

            var response = newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

            Pattern newsTitlePattern = Pattern.compile("\"title\":\"([^\"]*)\"");
            Matcher matcher = newsTitlePattern.matcher(response.body());

            return matcher.find() ? matcher.group(1) : "Unknown";
        }
    }
}
