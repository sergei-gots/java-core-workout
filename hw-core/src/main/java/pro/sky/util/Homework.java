package pro.sky.util;

public interface Homework {
    public void homework();

    public default void printTitle(String title) {
        System.out.println();
        ColorService.printInColor(title, ColorService.ANSI_GREEN);
        System.out.println();
    }

    public default void printTaskHeader(String task) {
        System.out.println();
        ColorService.printInColor(task, ColorService.ANSI_YELLOW);
        System.out.println();
    }
}
