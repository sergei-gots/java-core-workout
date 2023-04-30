package pro.sky.course_2_core.hw_2_3;

import pro.sky.util.Homework;

public class Hw_2_3_OOP_2 implements Homework {
    public static void main(String[] args)  {
        Homework hw = new Hw_2_3_OOP_2();
        hw.homework();
    }

    @Override
    public void homework() {
        System.out.println("Homework 2.3 \"OOP. PartII\"");

        WheeledVehicle [] park = {
                new Car("car1"),
                new Car("car2"),
                new Truck("truck1", 6),
                new Truck("truck2", 8),
                new Bicycle("bicycle1"),
                new Bicycle("bicycle2") };

        ServiceStation station = new ServiceStation();
        for (ServicedVehicle vehicle: park) {
            station.check(vehicle);
        }

        System.out.println();
    }

}
