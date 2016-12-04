package podraza.misiura.visca;

import jssc.SerialPort;
import jssc.SerialPortException;

import javax.xml.bind.DatatypeConverter;
import java.util.Scanner;

/**
 * Created by Tomek on 04.12.2016.
 */
public class Main {

    public static void main(String[] args){

        String portName = args[1];
        ViscaPort port = null;
        try {
            port = new ViscaPort(portName);
        } catch (SerialPortException e) {
            System.out.println("Camera not connected to "+portName);
            return;
        }
        String cmd = null;
        while(true){
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter a command: ");
            cmd= reader.nextLine();
            if(!cmd.toLowerCase().equals("exit"))
                break;
            try {
                port.sendCommand(cmd.toUpperCase());
            } catch (SerialPortException e) {
                System.out.println("Could not execute command");
                continue;
            }
        }



    }
}
