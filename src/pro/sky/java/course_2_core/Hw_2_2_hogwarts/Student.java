package pro.sky.java.course_2_core.Hw_2_2_hogwarts;

public abstract class Student {
    private final String name;
    private int sorcery;
    private int transgressionDistance;

    protected static  int generateTraitIndex() {
        return HogwartsService.RANDOM.nextInt(101);
    }

    public Student(String name, int sorcery, int transgressionDistance) {
        this.name = name;
        this.sorcery =  sorcery;
        this.transgressionDistance =transgressionDistance;
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
