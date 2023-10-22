package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    private final static String CONNECTION_CLOSED_MSG = "Соединение закрыто";
    //private final static String FAIL_EXECUTED_MSG = "Не удалось выполнить команду ";
    private final static String SUCCESSFUL_EXECUTED_MSG = "Команда \"%s\" успешно выполнена";
    private final static Logger LOGGER = LogManager.getLogger();

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public class ConnectionException extends RuntimeException {
        final Throwable cause;

        ConnectionException() {
            this.cause = null;
        }

        ConnectionException(Throwable cause) {
            this.cause = cause;
        }
    }

    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) {
            for (int i = 0; i < maxAttempts; ++i) {
                try {
                    manager.getConnection().execute(command);
                    return;
                } catch (Exception e) {
                    if (i == maxAttempts - 1) {
                        throw new ConnectionException(e);
                    }
                }
            }
        }
    }

    public class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            LOGGER.info(String.format(SUCCESSFUL_EXECUTED_MSG, command));
        }

        @Override
        public void close() throws Exception {
            LOGGER.info(CONNECTION_CLOSED_MSG);
        }
    }

    public class FaultyConnection implements Connection {
        static boolean isPrevThrowException = false;

        @Override
        public void execute(String command) {
            isPrevThrowException = !isPrevThrowException;

            if (isPrevThrowException) {
                throw new ConnectionException();
            }

            LOGGER.info(String.format(SUCCESSFUL_EXECUTED_MSG, command));
        }

        @Override
        public void close() throws Exception {
            LOGGER.info(CONNECTION_CLOSED_MSG);
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
