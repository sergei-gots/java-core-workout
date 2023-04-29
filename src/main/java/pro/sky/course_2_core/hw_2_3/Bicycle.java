package pro.sky.course_2_core.hw_2_3;

public class Bicycle extends WheeledVehicle {
    public Bicycle(String modelName) {
        super(modelName, 2);
    }

    @Override
    public void updateTyre(int index) {
        System.out.println("Меняем покрышку велосипеда #" + index );
    }
}
