package podraza.misiura.visca;

import jssc.SerialPort;
import jssc.SerialPortException;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by Tomek on 04.12.2016.
 */
public class Main {



    public static void main(String[] args){

        String portName = "COM1";
        final SerialPort serialPort = new SerialPort(portName);
        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }

        byte[] binaryCommand = DatatypeConverter.parseHexBinary(Commands.getCommand("UP"));
        try {
            for(byte item : binaryCommand)
             System.out.print(item+" ");
            serialPort.writeBytes(binaryCommand);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
