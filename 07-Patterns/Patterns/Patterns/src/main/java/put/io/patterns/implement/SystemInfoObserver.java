package put.io.patterns.implement;

public class SystemInfoObserver implements SystemStateObserver {
    @Override
    public void update(SystemState state) {
        System.out.println("============================================");
        System.out.printf("CPU Load: %2.2f%%%n", state.getCpu());
        System.out.printf("CPU temperature: %.2f C%n", state.getCpuTemp());
        System.out.printf("Available memory: %.2f MB%n", state.getAvailableMemory());
        System.out.printf("USB devices: %d%n", state.getUsbDevices());
    }
}
