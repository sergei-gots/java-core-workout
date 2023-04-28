package pro.sky.course_2_core.hw_2_3;

public class Car extends WheeledVehicle implements HavingEngine {

    public  Car(String modelName) {
        super(modelName, 4);
    }
    public Car(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void check() {
        super.check();
        checkEngine();
    }

    @Override
    public void updateTyre(int index) {
        System.out.println("Меняем покрышку автомобиля #" + index );
    }
}
