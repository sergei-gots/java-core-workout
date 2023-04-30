package pro.sky.course_2_core.hw_2_2_hogwarts.hogwarts;

public class Hogwarts {


    private final Faculty [] faculties;

    public Hogwarts(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public int getRandomFacultyIndex() {
        return HogwartsService.RANDOM.nextInt(faculties.length);
    }

    public HogwartsStudent getRandomStudentAtFaculty(int facultyIndex) {
        return faculties[facultyIndex].getRandomStudent();
    }

    public HogwartsStudent getRandomStudent() {
       return faculties[getRandomFacultyIndex()].getRandomStudent();
    }
}
