package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void portsScanner() throws IOException {
        Task6.portsScanner();
    }
}
