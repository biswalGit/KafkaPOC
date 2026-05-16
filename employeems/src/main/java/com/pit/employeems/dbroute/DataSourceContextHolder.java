package com.pit.employeems.dbroute;

public class DataSourceContextHolder {

    private static final ThreadLocal<String> context
            = new ThreadLocal<>();

    public static void set(String value) {
        context.set(value);
    }

    public static String get() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}

