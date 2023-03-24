package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

import java.util.Random;

import static java.lang.System.out;

public class HogwartsService {


    public static Random RANDOM = new Random();

    public static Hogwarts createHogwartsInstance() {
        return new Hogwarts(new Faculty[]{
                new Faculty(instatiateGriffindorStudents()),
                new Faculty(instatiateHufflepuffStudents()),
                new Faculty(instatiateSlytherinStudents()),
                new Faculty(instatiateRavenclawStudents())

        });
    }

    public static Student[] instatiateGriffindorStudents() {
        return new Student[]{
                new GriffindorStudent("Harry Potter"),
                new GriffindorStudent("Hermione Granger"),
                new GriffindorStudent("Ron Weasley")
        };
    }

    private static Student[] instatiateHufflepuffStudents() {
        return new Student[]{
                new HufflepuffStudent("Zacharias Smith"),
                new HufflepuffStudent("Cedric Diggory"),
                new HufflepuffStudent("Justin Finch-Fletchley")
        };
    }

    private static Student[] instatiateSlytherinStudents() {
        return new Student[]{
                new SlytherinStudent("Draco Malfoy"),
                new SlytherinStudent("Graham Montague"),
                new SlytherinStudent("Gregory Goyle")
        };
    }

    private static Student[] instatiateRavenclawStudents() {
        return new Student[]{
                new RavenclawStudent("Cho Chang"),
                new RavenclawStudent("Padma Patil"),
                new RavenclawStudent("Marcus Belby")
        };
    }

    public static int generateTraitIndex() {
        return RANDOM.nextInt(101);
    }

    private static void printComparisonResult(boolean result, Student[] students, String betweenExp) {
        if (result) {
            out.println(students[0].getName() + betweenExp + students[1].getName() + '.');
        } else {
            out.println(students[1].getName() + betweenExp + students[0].getName() + '.');
        }
    }

    private static void printHeader(String header) {
        out.println();
        printSeparator();
        out.print("===== ");
        out.println(header);
    }

    private static void printFooter() {
        printSeparator();
        out.println();
    }

    private static void printComparisonHeader(String department, Student[] students) {
        printHeader("COMPARE TWO " + department + " STUDENTS:");
        printSeparator();
        out.println(students[0] +
                "\n===== VS ===============================\n" +
                students[1]);
        printSeparator();
    }

    private static void printSeparator() {
        out.println("================================================================================================");
    }

    public static void compareAndShowStudentsByGeneralTraits(Student[] students) {

        printComparisonHeader("Hogwarts", students);
        printComparisonResult(students[0].getSorcery() > students[1].getSorcery(),
                students,
                " has more power of magic than ");
        printComparisonResult(students[0].getTransgressionDistance() > students[1].getTransgressionDistance(),
                students,
                " has longer distance of transgression than ");
        printFooter();
    }

    public static void compareAndShowStudentsWithinFaculty(Student[] students) {
        if (students[0].getClass() != students[1].getClass()) {
            throw new IllegalArgumentException("Students should be members of the same faculty.");
        }
        printComparisonHeader(students[0].getFacultyName(), students);

        printComparisonResult(students[0].getFacultySpecificTraitsIndex() >
                        students[1].getFacultySpecificTraitsIndex(),
                students,
                " is better " + students[0].getTribeName() + " than ");
        printFooter();
    }

    public static Student getRandomStudent(Hogwarts hogwarts) {
        return hogwarts.getRandomStudent();
    }

    public static Student[] get2RandomStudentsToCompare(Hogwarts hogwarts) {
        Student student1 = getRandomStudent(hogwarts);
        Student student2;
        do {
            student2 = getRandomStudent(hogwarts);
        } while (student1 == student2);
        return new Student[]{student1, student2};
    }

    public static Student[] get2RandomHogwartsStudentsTheSameFacultyToCompare(Hogwarts hogwarts) {
        int facultyIndex = hogwarts.getRandomFacultyIndex();
        Student student1 = hogwarts.getRandomStudentAtFaculty(facultyIndex);
        Student student2;
        do {
            student2 = hogwarts.getRandomStudentAtFaculty(facultyIndex);;
        } while (student1 == student2);
        return new Student[]{student1, student2};
    }

    public static void printRandomStudentInfo(Hogwarts hogwarts) {
        printHeader("STUDENT INFO:");
        out.println(getRandomStudent(hogwarts));
        printFooter();
    }

    public static void printRandomStudentsCompareInfo(Hogwarts hogwarts) {
        compareAndShowStudentsByGeneralTraits(get2RandomStudentsToCompare(hogwarts));
    }


    public static void printRandomStudentsTheSameFacultyCompareInfo(Hogwarts hogwarts) {
        compareAndShowStudentsWithinFaculty(get2RandomHogwartsStudentsTheSameFacultyToCompare(hogwarts));
    }
}
