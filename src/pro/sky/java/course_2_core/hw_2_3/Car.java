package pro.sky.java.course_2_core.hw_2_3;

public class Car extends WheeledVehicle {

    public  Car(String modelName) {
        super(modelName, 4);
    }
    public Car(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
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
