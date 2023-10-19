package edu.hw2;

public class Task3 {
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public class ConnectionException extends RuntimeException {}

    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) { ... }
    }

    public class StableConnection implements Connection {

        @Override
        public void execute(String command) {

        }

        @Override
        public void close() throws Exception {

        }
    }

    public class FaultyConnection implements Connection {

        @Override
        public void execute(String command) {

        }

        @Override
        public void close() throws Exception {

        }
    }

    public class DefaultConnectionManager implements ConnectionManager {
        private static boolean isPrevFaultyConnect = false;

        @Override
        public Connection getConnection() {
            isPrevFaultyConnect = !isPrevFaultyConnect;
            return isPrevFaultyConnect ? new FaultyConnection() : new StableConnection();
        }
    }

    public class FaultyConnectionManager implements ConnectionManager {

        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }
}
