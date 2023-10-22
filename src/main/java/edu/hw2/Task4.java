package edu.hw2;

public class Task4 {
    private Task4() {}

    public static CallingInfo callingInfo() {
        StackTraceElement stackElement = Thread.currentThread().getStackTrace()[2];
        return new CallingInfo(stackElement.getClassName(), stackElement.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
