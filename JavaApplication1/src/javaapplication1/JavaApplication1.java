/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author user
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        // Передаем null в getByName()
        InetAddress addr = InetAddress.getByName(null);
        
        
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, 8080);
        try {
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            
            // Чтение значений от сервера
            double dLowerLimitValue = Double.parseDouble(in.readLine());
            double dUpperLimitValue = Double.parseDouble(in.readLine());
            double dStepValue = Double.parseDouble(in.readLine());
            
            double integralPart = (dUpperLimitValue - dLowerLimitValue)/2;
            dUpperLimitValue = dLowerLimitValue + integralPart;

            System.out.println("getted value: " + dLowerLimitValue + ", " + dUpperLimitValue + ", " + dStepValue);
            
            
            //цикл для вычисления
            double dLastStep = 0.0, dSum = 0.0;
            double dIterationCountWhole = (dUpperLimitValue - dLowerLimitValue)/dStepValue;
            double dIterationCountWithRest = (dUpperLimitValue - dLowerLimitValue)%dStepValue;
            dIterationCountWhole = dIterationCountWhole - dIterationCountWithRest;
            dLastStep = dIterationCountWithRest;
            double dTempA = dLowerLimitValue;

            
            for (int i = 0; i < dIterationCountWhole; i++){
                dSum = dSum + dStepValue/2*((1/dTempA) + (1/(dTempA+dStepValue)));
                dTempA = dTempA + dStepValue;
            }

            if (dLastStep > 0){
                dSum = dSum + ((1/dTempA) + (1/(dTempA + dLastStep)))*dLastStep/2;
            }
            
            
            
            System.out.println("rezult: " + dSum);
            out.println(dSum); // Отправить результат обратно на сервер, если нужно
            //out.println("END1");
        }
        finally {
            System.out.println("closing...");
            socket.close();
        }  
    }    
}
