package pro.sky.java.course_2_core.hw_2_3;

import pro.sky.java.util.BasicService;

public class ServiceStation extends BasicService {
    public void check(ServicedVehicle vehicle) {
        printSeparator();
        System.out.println("Обслуживаем " + vehicle.getModelName() + ":");
        vehicle.check();
        printSeparator();

    }
}
