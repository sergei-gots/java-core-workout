package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class GriffindorStudent extends Student {

    private int bravery;
    private int daring;
    private int chivalry;
    public  GriffindorStudent(String name) {
        super(name);
        this.bravery = HogwartsService.generateQuality();
        this.daring = HogwartsService.generateQuality();
        this.chivalry = HogwartsService.generateQuality();
    }

    public String getTribeName() {
        return "Griffindorer";
    }

    @Override
    public int getFacultySpecificTraitsIndex() {
        return bravery + daring + chivalry;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nGriffindor traits: " +
            "\n\t bravery = " + bravery +
            "\n\t daring = " + daring +
            "\n\t chivalry = " + chivalry;
    }
}
