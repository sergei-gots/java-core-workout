package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class Hogwarts {
    private Faculty [] faculties = {
            new GriffindorFaculty(),
            null,
            null,
            null
    };

    public Faculty getRandomFaculty() {
        return faculties[0];
    }
}
