package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public abstract class Student {
    private final String name;
    private int sorcery;
    private int transgressionDistance;

    public Student(String name) {
        this.name = name;
        this.sorcery =  HogwartsService.generateTraitIndex();
        this.transgressionDistance = HogwartsService.generateTraitIndex();
    }

    public String getName() {
        return name;
    }

    public abstract String getFacultyName();

    public String getTribeName() {
        return getFacultyName() + "er";
    }
    public int getSorcery() {
        return sorcery;
    }

    public int getTransgressionDistance() {
        return transgressionDistance;
    }

    public abstract  int getFacultySpecificTraitsIndex();
    @Override
    public String toString() {
        return name + ", " + getTribeName() + ":" +
        "\n\tmagic power = " + sorcery +
        "\n\ttransgression distance = " + transgressionDistance;
    }


}
