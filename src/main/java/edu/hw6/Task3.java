package edu.hw6;

import java.io.FileInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

public class Task3 {
    private Task3() {}

    public static final AbstractFilter IS_REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter IS_READABLE = Files::isReadable;
    public static final AbstractFilter IS_WRITABLE = Files::isWritable;
    public static final AbstractFilter IS_EXECUTABLE = Files::isExecutable;

    public static AbstractFilter largeThan(int size)  {
        return entry -> entry.toFile().length() > size;
    }

    public static AbstractFilter lessThan(int size)  {
        return entry -> entry.toFile().length() < size;
    }

    public static AbstractFilter hasExtension(String extension)  {
        return entry -> entry.toString().endsWith('.' + extension);
    }

    public static AbstractFilter regexContains(String regex)  {
        Pattern pattern = Pattern.compile(regex);
        return entry -> pattern.matcher(entry.getFileName().toString()).find();
    }

    public static AbstractFilter magicNumber(int... args)  {
        return entry -> {
            byte[] symbol = new byte[args.length];

            try (FileInputStream reader = new FileInputStream(entry.toFile())) {
                reader.read(symbol, 0, args.length);
            }

            for (int i = 0; i < args.length; ++i) {
                if (Byte.toUnsignedInt(symbol[i]) != args[i]) {
                    return false;
                }
            }

            return true;
        };
    }

    public static AbstractFilter globMatches(String glob) {
        final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
        return entry -> matcher.matches(entry.getFileName());
    }

    public interface AbstractFilter extends DirectoryStream.Filter<Path> {
        default AbstractFilter and(AbstractFilter other) {
            return (t) -> accept(t) && other.accept(t);
        }
    }
}
