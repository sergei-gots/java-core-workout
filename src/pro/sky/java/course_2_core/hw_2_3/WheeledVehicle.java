package pro.sky.java.course_2_core.hw_2_3;

public abstract class WheeledVehicle implements ServicedVehicle {
    private String modelName;
    private int wheelsCount;

    protected WheeledVehicle(String modelName, int wheelsCount) {
        this.modelName = modelName;
        this.wheelsCount = wheelsCount;
    }

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
