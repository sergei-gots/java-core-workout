package pro.sky.course_2_core.hw_2_2_hogwarts.hogwarts;

public class GriffindorStudent extends HogwartsStudent {

    private final int bravery;
    private final int daring;
    private final int chivalry;

    public GriffindorStudent(String name) {
        this(name,
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex());
    }

    public GriffindorStudent(String name, int sorcery, int transgressionDistance, int bravery, int daring, int chivalry) {
        super(name, sorcery, transgressionDistance);
        this.bravery = bravery;
        this.daring = daring;
        this.chivalry = chivalry;
    }

    public String getFacultyName() {
        return "Griffindor";
    }

    @Override
    public int getFacultySpecificTraitsIndex() {
        return bravery + daring + chivalry;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tGriffindor traits: " + "\n\t\t bravery = " + bravery +
                "\n\t\t daring = " + daring + "\n\t\t chivalry = " + chivalry;
    }
}
