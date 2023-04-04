package pro.sky.java.course_2_core.hw_2_3;

public abstract class WheeledVehicle implements ServicedVehicle {
    protected String modelName;
    protected int wheelsCount;

    public void updateTyre(int index) {
        System.out.println("Меняем покрышку #" + index );
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    @Override
    public void check() {
        for (int i = 1; i <= wheelsCount; i++) {
            updateTyre(i);
        }
    }
}
