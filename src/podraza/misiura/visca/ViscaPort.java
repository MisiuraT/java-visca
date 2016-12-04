package podraza.misiura.visca;

import jssc.SerialPort;
import jssc.SerialPortException;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by Tomek on 04.12.2016.
 */
public class ViscaPort {
    private final SerialPort serialPort;

    public ViscaPort(String portName) throws SerialPortException {
        serialPort = new SerialPort(portName);
        serialPort.openPort();
        serialPort.setParams(9600, 8, 1, 0);
    }

    public void sendCommand(String cmd) throws SerialPortException {
        String viscaCmd = Commands.getCommand(cmd);
        if(viscaCmd==null)
            return;
        byte[] binaryCommand = DatatypeConverter.parseHexBinary(viscaCmd);
        serialPort.writeBytes(binaryCommand);
    }
}
