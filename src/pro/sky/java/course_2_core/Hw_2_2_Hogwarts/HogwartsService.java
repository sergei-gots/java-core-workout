package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

import java.util.Random;

import static java.lang.System.*;

public class HogwartsService {


    public static Random RANDOM = new Random();

    public static Hogwarts createHogwartsInsance() {
        Hogwarts hogwarts = new Hogwarts();
        return hogwarts;
    }

    public static int generateQuality() {
        return RANDOM.nextInt(101);
    }

    private static void printComparisonResult(boolean result, Student[] students, String betweenExp) {
        if(result) {
            out.println(students[0].getName() + betweenExp + students[1].getName() + '.');
        }
        else {
            out.println(students[1].getName() + betweenExp + students[0].getName() + '.');
        }
    }

    public static void compareAndShowStudentsByGeneralTraits(Student[] students) {
        out.println();
        printComparisonResult(students[0].getSorcery() > students[1].getSorcery(),
                students,
                " has more power of magic than ");
        printComparisonResult(students[0].getTransgressionDistance() > students[1].getTransgressionDistance(),
                students,
                " has longer distance of transgression than ");
        out.println();
    }

    public static void compareAndShowStudentsWithinFaculty(Student[] students) {
        if (students[0].getClass() != students[1].getClass()) {
            throw new IllegalArgumentException("Students should be members of the same faculty.");
        }
        out.println();

        printComparisonResult(students[0].getFacultySpecificTraitsIndex() >
                students[1].getFacultySpecificTraitsIndex(), 
                students,  
                " is better " + students[0].getTribeName() + " than ");
        out.println();

    }

    public static Student getRandomStudent(Hogwarts hogwarts) {
        return hogwarts.getRandomFaculty().getRandomStudent();
    }

    public static Student[] get2RandomStudentsToCompare(Hogwarts hogwarts) {
        Student student1 = getRandomStudent(hogwarts);
        Student student2 = null;
        do {
            student2 = getRandomStudent(hogwarts);
        } while (student1 == student2);
        return new Student[]{student1, student2};
    }

    public static Student[] get2RandomHogwartsStudentsTheSameFacultyToCompare(Hogwarts hogwarts) {
        Faculty faculty = hogwarts.getRandomFaculty();
        Student student1 = faculty.getRandomStudent();
        Student student2 = null;
        do {
            student2 = faculty.getRandomStudent();
        } while (student1 == student2);
        return new Student[]{student1, student2};
    }

    public static void printRandomStudentInfo(Hogwarts hogwarts) {
        out.println(getRandomStudent(hogwarts));
    }

    public static void printRandomStudentsCompareInfo(Hogwarts hogwarts) {
        compareAndShowStudentsByGeneralTraits(get2RandomStudentsToCompare(hogwarts));
    }


    public static void printRandomStudentsTheSameFacultyCompareInfo(Hogwarts hogwarts) {
        compareAndShowStudentsWithinFaculty(get2RandomHogwartsStudentsTheSameFacultyToCompare(hogwarts));
    }
}
