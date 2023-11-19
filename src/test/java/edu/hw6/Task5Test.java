package edu.hw6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    void  getTopNewsTest() throws URISyntaxException, IOException, InterruptedException {
        Task5.HackerNews.hackerNewsTopStories();
        Assertions.assertThatNoException();
    }

    @Test
    void  getNewsTitleTest() throws URISyntaxException, IOException, InterruptedException {
        String ans = "JDK 21 Release Notes";
        var newsTitle = Task5.HackerNews.news(37570037);
        Assertions.assertThat(newsTitle).isEqualTo(ans);
    }
}
