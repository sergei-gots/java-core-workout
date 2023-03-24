package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class RavenclawStudent extends Student {

    private int iq;
    private int wisdom;
    private int wit;
    private int creativity;
    public RavenclawStudent(String name) {
        super(name);
        this.iq = HogwartsService.generateTraitIndex();
        this.wisdom = HogwartsService.generateTraitIndex();
        this.wit = HogwartsService.generateTraitIndex();
        this.creativity = HogwartsService.generateTraitIndex();
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
        return super.toString() +
            "\n\tRavenclaw traits: " +
            "\n\t\t iq = " + iq +
            "\n\t\t wisdom = " + wisdom +
            "\n\t\t wit = " + wit +
            "\n\t\t creativity = " + creativity;
    }
}
