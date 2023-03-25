package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class SlytherinStudent extends Student {

    private final int ambition;
    private final int resoursefullness;
    private final int determination;
    private final int cleverness;
    private final int lustForPower;

    public SlytherinStudent(String name) {
        this(name,
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex());
    }

    public SlytherinStudent(String name, int sorcery, int transgressionDistance, int ambition, int resoursefullness, int determination, int cleverness, int lustForPower) {
        super(name, sorcery, transgressionDistance);
        this.ambition = ambition;
        this.resoursefullness = resoursefullness;
        this.determination = determination;
        this.cleverness = cleverness;
        this.lustForPower = lustForPower;
    }

    public String getFacultyName() {
        return "Slytherin";
    }

    @Override
    public int getFacultySpecificTraitsIndex() {
        return ambition + resoursefullness + determination + cleverness + lustForPower;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tSlytherin traits: " + "\n\t\t ambition = " + ambition +
                "\n\t\t resoursefullness = " + resoursefullness +
                "\n\t\t determination = " + determination +
                "\n\t\t cleverness = " + cleverness +
                "\n\t\t lust for power = " + lustForPower;
    }
}
