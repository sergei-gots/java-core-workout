package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class RavenclawStudent extends Student {

    private final int iq;
    private final int wisdom;
    private final int wit;
    private final int creativity;

    public RavenclawStudent(String name) {
        this(name,
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex(), generateTraitIndex());
    }

    public RavenclawStudent(String name, int sorcery, int transgressionDistance, int iq, int wisdom, int wit, int creativity) {
        super(name, sorcery, transgressionDistance);
        this.iq = iq;
        this.wisdom = wisdom;
        this.wit = wit;
        this.creativity = creativity;
    }

    public String getFacultyName() {
        return "Ravenclaw";
    }

    @Override
    public int getFacultySpecificTraitsIndex() {
        return iq + wisdom + wit + creativity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tRavenclaw traits: " + "\n\t\t iq = " + iq +
                "\n\t\t wisdom = " + wisdom + "\n\t\t wit = " + wit + "\n\t\t creativity = " + creativity;
    }
}
