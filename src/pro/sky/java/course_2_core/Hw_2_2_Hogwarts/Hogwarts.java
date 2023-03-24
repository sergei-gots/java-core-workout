package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class Hogwarts {


    private final Faculty [] faculties;

    public Hogwarts(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public Faculty getRandomFaculty() {
        return faculties[HogwartsService.RANDOM.nextInt(faculties.length)];
    }
}
