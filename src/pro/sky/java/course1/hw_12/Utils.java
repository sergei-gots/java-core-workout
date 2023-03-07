package pro.sky.java.course1.hw_12;

final class Utils {
    public static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name should be defined and have at least one symbol in it.");
        }
    }
}
