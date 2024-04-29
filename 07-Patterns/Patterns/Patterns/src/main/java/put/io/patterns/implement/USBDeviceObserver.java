package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver {

    private int lastNumberOfUsbDevices = -1;

    @Override
    public void update(SystemState state) {
        int currentNumberOfUsbDevices = state.getUsbDevices();

        if (lastNumberOfUsbDevices != -1 && currentNumberOfUsbDevices != lastNumberOfUsbDevices) {
            System.out.println("The number of USB devices has changed from " + lastNumberOfUsbDevices + " to " + currentNumberOfUsbDevices);
        }

        lastNumberOfUsbDevices = currentNumberOfUsbDevices;
    }
}
