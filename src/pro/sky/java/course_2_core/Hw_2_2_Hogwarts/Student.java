package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public abstract class Student {
    private String name;
    private int sorcery;
    private int transgressionDistance;

    public Student(String name) {
        this.name = name;
        this.sorcery =  HogwartsService.generateQuality();
        this.transgressionDistance = HogwartsService.generateQuality();
    }

    public String getName() {
        return name;
    }

    public abstract String getTribeName();
    public int getSorcery() {
        return sorcery;
    }

    public int getTransgressionDistance() {
        return transgressionDistance;
    }

    public abstract  int getFacultySpecificTraitsIndex();
    @Override
    public String toString() {
        return "\n" +
        name + ", " + getTribeName() + ":" +
        "\n\tPower of magic = " + sorcery +
        "\n\tDistance of transgression = " + transgressionDistance;
    }


}
