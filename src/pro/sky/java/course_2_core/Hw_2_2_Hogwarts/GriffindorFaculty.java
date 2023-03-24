package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class GriffindorFaculty extends Faculty {
    public GriffindorFaculty() {
        students = new Student[] {
            new GriffindorStudent("Harry Potter"),
            new GriffindorStudent("Hermione Granger"),
            new GriffindorStudent("Ron Weasley"),
        };
    }
}
