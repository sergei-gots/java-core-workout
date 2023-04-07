package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class HufflepuffStudent extends HogwartsStudent {

    private int justice;
    private int honesty;
    private int propensityForHardWork;

    public HufflepuffStudent(String name) {
        this(name,
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex(), generateTraitIndex(),
                generateTraitIndex());
    }

    public HufflepuffStudent(String name, int sorcery, int transgressionDistance,
                             int justice, int honesty, int propensityForHardWork) {
        super(name, sorcery, transgressionDistance);
        this.justice = justice;
        this.honesty = honesty;
        this.propensityForHardWork = propensityForHardWork;
    }

    public String getFacultyName() {
        return "Hufflepuff";
    }

    @Override
    public int getFacultySpecificTraitsIndex() {
        return justice + honesty + propensityForHardWork;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tHufflepuff traits: " +
                "\n\t\t justice = " + justice +
                "\n\t\t honesty = " + honesty +
                "\n\t\t propensity for hard work = " + propensityForHardWork;
    }
}
