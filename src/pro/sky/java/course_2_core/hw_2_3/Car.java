package pro.sky.java.course_2_core.hw_2_3;

public class Car extends WheeledVehicle {

    protected Car() {}
    public Car(String modelName) {
        this.modelName = modelName;
        wheelsCount = 4;
    }
    public void checkEngine() {
        System.out.println("Проверяем двигатель");
    }

    @Override
    public void check() {
        super.check();
        checkEngine();
    }
}
