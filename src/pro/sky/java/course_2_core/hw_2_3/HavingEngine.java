package pro.sky.java.course_2_core.hw_2_3;

public interface HavingEngine {
    default void checkEngine() {
        System.out.println("Проверяем двигатель");
    }
}
