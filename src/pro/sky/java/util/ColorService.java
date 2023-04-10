package pro.sky.java.util;

public class ColorService {
    public static final String ANSI_WHITE = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = ANSI_WHITE;

    public static void resetConsoleColor() {
        System.out.print(ANSI_RESET);
    }

    public static void installConsoleColor(String color) {
        System.out.print(color);
    }

    public static void printInColor(String s, String color) {
        installConsoleColor(color);
        System.out.print(s);
        resetConsoleColor();
    }

    public static void printHeaderInColor(String header) {
        printInColor(header, ANSI_YELLOW);
    }

    public static void printInterfaceNameInColor(String interfaceName) {
        printInColor(interfaceName, ANSI_CYAN);
    }
    public static void printClassNameInColor(String interfaceName) {
        printInColor(interfaceName, ANSI_GREEN);
    }

    public static void printTermInColor(String interfaceName) {
        printInColor(interfaceName, ANSI_YELLOW);
    }

}