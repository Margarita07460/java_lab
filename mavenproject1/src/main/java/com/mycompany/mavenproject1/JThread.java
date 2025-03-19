/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author user
 */
public class JThread extends Thread{
    private double dLowerLimitValue;
    private double dUpperLimitValue;
    private double dStepValue;
    private double dSumFromThread;
    
    JThread(String name, double dLowerLimitValue, double dUpperLimitValue, double dStepValue){
        super(name);
        this.dLowerLimitValue = dLowerLimitValue;
        this.dUpperLimitValue = dUpperLimitValue;
        this.dStepValue = dStepValue;     
    }
    

    public void run(){
       
        System.out.printf("%s started... \n", Thread.currentThread().getName());
               
        double dLastStep = 0.0, dSum = 0.0;
        double dIterationCountWhole = (dUpperLimitValue - dLowerLimitValue)/dStepValue;
        double dIterationCountWithRest = (dUpperLimitValue - dLowerLimitValue)%dStepValue;
        dIterationCountWhole = dIterationCountWhole - dIterationCountWithRest;
        dLastStep = dIterationCountWithRest;
        double dTempA = dLowerLimitValue;
        
        long startTime2 = System.nanoTime();
        for (int i = 0; i < dIterationCountWhole; i++){
            dSum = dSum + dStepValue/2*((1/dTempA) + (1/(dTempA+dStepValue)));
            dTempA = dTempA + dStepValue;
        }
        
        if (dLastStep > 0){
            dSum = dSum + ((1/dTempA) + (1/(dTempA + dLastStep)))*dLastStep/2;
        }
        
        long endTime2 = System.nanoTime();
        System.out.printf("time of %s: %.2f\n", Thread.currentThread().getName(), (endTime2 - startTime2) / 1_000_000.0);
              
        System.out.printf("%s finished... %f\n", Thread.currentThread().getName(), dSum);
        
        
        synchronized (NewJFrame.class) { // Синхронизация
            NewJFrame.addToGlobalResult(dSum); // Суммируем результаты
        }
        
    }
}
