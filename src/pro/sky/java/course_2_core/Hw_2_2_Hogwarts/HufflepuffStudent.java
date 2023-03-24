package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class HufflepuffStudent extends Student {

    private int justice;
    private int honesty;
    private int propensityForHardWork;
    public HufflepuffStudent(String name) {
        super(name);
        this.justice = HogwartsService.generateTraitIndex();
        this.honesty = HogwartsService.generateTraitIndex();
        this.propensityForHardWork = HogwartsService.generateTraitIndex();
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
