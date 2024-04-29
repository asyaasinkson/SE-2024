package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import java.util.List;
import java.util.ArrayList;

public class SystemMonitor {

    private final HardwareAbstractionLayer hal;
    private SystemState lastSystemState = null;
    private final List<SystemStateObserver> observers = new ArrayList<>();

    public SystemMonitor(){
        SystemInfo si = new SystemInfo();
        hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
    }

    public void addObserver(SystemStateObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SystemStateObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (SystemStateObserver observer : observers) {
            observer.update(lastSystemState);
        }
    }

    public void probe() {
        // Get current state of the system resources
        double cpuLoad = hal.getProcessor().getSystemCpuLoad() * 100;
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = (double) hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).length;

        // Update lastSystemState
        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);

        // Notify all observers about the state change
        notifyObservers();
    }

    public SystemState getLastSystemState() {
        return lastSystemState;
    }
}
