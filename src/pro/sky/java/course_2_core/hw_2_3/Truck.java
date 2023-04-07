package pro.sky.java.course_2_core.hw_2_3;

public class Truck extends Car {

    public Truck(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }
    public void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }

    @Override
    public void checkEngine() {
        System.out.println("Проверяем двигатель у грузового автомобиля");
    }
    @Override
    public void check() {
        super.check();
        checkTrailer();
    }

    @Override
    public void updateTyre(int index) {
        System.out.println("Меняем покрышку у грузового автомобиля #" + index );
    }
}
