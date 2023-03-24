package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class GriffindorStudent extends Student {

    private int bravery;
    private int daring;
    private int chivalry;
    public  GriffindorStudent(String name) {
        super(name);
        this.bravery = HogwartsService.generateTraitIndex();
        this.daring = HogwartsService.generateTraitIndex();
        this.chivalry = HogwartsService.generateTraitIndex();
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
        return super.toString() +
            "\n\tGriffindor traits: " +
            "\n\t\t bravery = " + bravery +
            "\n\t\t daring = " + daring +
            "\n\t\t chivalry = " + chivalry;
    }
}
