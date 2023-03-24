package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class SlytherinStudent extends Student {

    private int ambition;
    private int resoursefullness;
    private int determination;
    private int cleverness;
    private int lustForPower;

    public SlytherinStudent(String name) {
        super(name);
        this.ambition = HogwartsService.generateTraitIndex();
        this.resoursefullness = HogwartsService.generateTraitIndex();
        this.determination = HogwartsService.generateTraitIndex();
        this.cleverness = HogwartsService.generateTraitIndex();
        this.lustForPower = HogwartsService.generateTraitIndex();
    }

    public String getFacultyName() {
        return "Slytherin";
    }

    @Override
    public int getFacultySpecificTraitsIndex() {
        return ambition +
                resoursefullness +
                determination +
                cleverness +
                lustForPower;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tSlytherin traits: " +
                "\n\t\t ambition = " + ambition +
                "\n\t\t resoursefullness = " + resoursefullness +
                "\n\t\t determination = " + determination +
                "\n\t\t cleverness = " + cleverness +
                "\n\t\t lust for power = " + lustForPower;
    }
}
