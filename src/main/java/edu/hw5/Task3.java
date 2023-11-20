package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private final static int FIRST = 1;
    private final static int SECOND = 2;
    private final static int THIRD = 3;

    public Optional<LocalDate> parseDate(String string) {
        ParsingChecker daysAgoChecker = new DaysAgoChecker(null);
        ParsingChecker timeIndicatorChecker = new TimeIndicatorChecker(daysAgoChecker);
        ParsingChecker slashFormatChecker = new SlashFormatChecker(timeIndicatorChecker);
        ParsingChecker dashFormatChecker = new DashFormatChecker(slashFormatChecker);
        return dashFormatChecker.check(string);
    }

    public abstract class ParsingChecker {
        public ParsingChecker nextChecker;

        public ParsingChecker(ParsingChecker nextChecker) {
            this.nextChecker = nextChecker;
        }

        public abstract Optional<LocalDate> check(String string);
    }

    public class DashFormatChecker extends ParsingChecker {
        public DashFormatChecker(ParsingChecker nextChecker) {
            super(nextChecker);
        }

        @Override
        public Optional<LocalDate> check(String string) {
            Pattern dashFormatPattern = Pattern.compile("^(\\d{1,4})-(\\d{1,2})-(\\d{1,2})$");
            Matcher matcher = dashFormatPattern.matcher(string);

            if (matcher.find()) {
                int year = Integer.parseInt(matcher.group(FIRST));
                int month = Integer.parseInt(matcher.group(SECOND));
                int day = Integer.parseInt(matcher.group(THIRD));
                return Optional.of(LocalDate.of(year, month, day));
            } else if (nextChecker != null) {
                return nextChecker.check(string);
            }

            return Optional.empty();
        }
    }

    public class SlashFormatChecker extends ParsingChecker {
        public SlashFormatChecker(ParsingChecker nextChecker) {
            super(nextChecker);
        }

        @Override
        public Optional<LocalDate> check(String string) {
            Pattern slashFormatPattern = Pattern.compile("^(\\d{1,2})/(\\d{1,2})/(\\d{1,4})$");
            Matcher matcher = slashFormatPattern.matcher(string);

            if (matcher.find()) {
                int year = Integer.parseInt(matcher.group(THIRD));
                int month = Integer.parseInt(matcher.group(SECOND));
                int day = Integer.parseInt(matcher.group(FIRST));
                return Optional.of(LocalDate.of(year, month, day));
            } else if (nextChecker != null) {
                return nextChecker.check(string);
            }

            return Optional.empty();
        }
    }

    public class TimeIndicatorChecker extends ParsingChecker {
        public TimeIndicatorChecker(ParsingChecker nextChecker) {
            super(nextChecker);
        }

        @Override
        public Optional<LocalDate> check(String string) {
            LocalDate curDate = LocalDate.now();
            Optional<LocalDate> res = Optional.empty();

            if (string.equalsIgnoreCase("today")) {
                res = Optional.of(curDate);
            } else if (string.equalsIgnoreCase("tomorrow")) {
                res = Optional.of(curDate.plusDays(1));
            } else if (string.equalsIgnoreCase("yesterday")) {
                res = Optional.of(curDate.minusDays(1));
            } else if (nextChecker != null) {
                return nextChecker.check(string);
            }

            return res;
        }
    }

    public class DaysAgoChecker extends ParsingChecker {
        public DaysAgoChecker(ParsingChecker nextChecker) {
            super(nextChecker);
        }

        @Override
        public Optional<LocalDate> check(String string) {
            LocalDate curDate = LocalDate.now();
            String oneDayAgo = "1 day ago";
            Pattern daysAgoPattern = Pattern.compile("^(\\d+) days ago$");
            Matcher matcher = daysAgoPattern.matcher(string);

            if (string.equalsIgnoreCase(oneDayAgo)) {
                return Optional.of(curDate.minusDays(1));
            } else if (matcher.find()) {
                int dayAgo = Integer.parseInt(matcher.group(1));
                return Optional.of(curDate.minusDays(dayAgo));
            } else if (nextChecker != null) {
                return nextChecker.check(string);
            }

            return Optional.empty();
        }
    }
}
