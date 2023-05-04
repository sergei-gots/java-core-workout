package pro.sky.course_2_core.l_2_13_mockito;

public class StudentValueGenerator {
    public static final int DEFAULT_AGE_MIN = 1;
    public static final int DEFAULT_AGE_MAX = 160;

    public int generateAgeInRange(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public int generateAge() {
        return generateAgeInRange(DEFAULT_AGE_MIN, DEFAULT_AGE_MAX);
    }

}
