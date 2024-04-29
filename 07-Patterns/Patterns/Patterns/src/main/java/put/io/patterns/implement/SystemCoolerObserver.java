package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver {
    @Override
    public void update(SystemState state) {
        if (state.getCpuTemp() > 60.00) {
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}
