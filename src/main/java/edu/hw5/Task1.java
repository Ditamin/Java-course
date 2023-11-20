package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Task1 {
    static final long MINUTES_IN_HOUR = 60;
    static final long SECONDS_IN_MINUTES = 60;
    static final long SECONDS_IN_HOUR = SECONDS_IN_MINUTES * MINUTES_IN_HOUR;

    public String averageTimeUsing(String strings) {
        long count = strings.lines().count();

        if (count == 0) {
            ++count;
        }

        long avgTime = strings.lines().map(line -> {
            String[] timeInAndOut = line.split(" - ");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm");

            try {
                Date timeIn = sdf.parse(timeInAndOut[0]);
                Date timeOut = sdf.parse(timeInAndOut[1]);

                if (timeIn.after(timeOut)) {
                    throw new IllegalArgumentException();
                }

                return Duration.between(timeIn.toInstant(), timeOut.toInstant()).toSeconds();
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }).reduce(0L, Long::sum) / count;
        long minutes = avgTime / SECONDS_IN_MINUTES % MINUTES_IN_HOUR;
        long hours = avgTime / SECONDS_IN_HOUR;
        return String.format("%dч %dм", hours, minutes);
    }
}
