package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class Hogwarts {


    private final Faculty [] faculties;

    public Hogwarts(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public int getRandomFacultyIndex() {
        return HogwartsService.RANDOM.nextInt(faculties.length);
    }

    public Student getRandomStudentAtFaculty(int facultyIndex) {
        return faculties[facultyIndex].getRandomStudent();
    }

    public Student getRandomStudent() {
       return faculties[getRandomFacultyIndex()].getRandomStudent();
    }
}
