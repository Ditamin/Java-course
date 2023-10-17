package edu.hw1;

public class Task1 {
    public int minutesToSeconds(String duration) {
        if ((duration == null) || (duration.split(":").length != 2)) {
            return -1;
        }

        for (int i = 0; i < duration.length(); ++i) {
            if (((duration.charAt(i) < '0') || (duration.charAt(i) > '9')) && (duration.charAt(i) != ':')) {
                return -1;
            }
        }

        final int secondsInMinute = 60;
        int minutes = Integer.parseInt(duration.split(":")[0]);
        int seconds = Integer.parseInt(duration.split(":")[1]);

        if (seconds >= secondsInMinute) {
            return -1;
        }

        return minutes * secondsInMinute + seconds;
    }
}
