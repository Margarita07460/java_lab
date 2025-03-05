/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.io.Serializable;

/**
 *
 * @author user
 */

public class classRecIntegral implements Serializable {
    private double classLowerLimitValue;
    private double classUpperLimitValue;
    private double classStepValue;
    private double classRezult;

    public classRecIntegral(double lowerLimit, double upperLimit, double step) 
        throws classRecIntegralException {
        if (lowerLimit < 0.000001 || lowerLimit > 1000000 ||
            upperLimit < 0.000001 || upperLimit > 1000000 ||
            step < 0.000001 || step > 1000000)
        throw new classRecIntegralException ("Значения, не являются числами в диапазоне от 0,000001 до 1000000");
        
        if (lowerLimit > upperLimit) 
        throw new classRecIntegralException ("Верхний предел меньше нижнего. Работа алгоритма может осуществляться некорректно.");
        
        
    
        this.classLowerLimitValue = lowerLimit;
        this.classUpperLimitValue = upperLimit;
        this.classStepValue = step;
    }   

    //public void AddRezult(double rezult) {
    //     this.classRezult = rezult;
    //} 

    public double getRezult(){
        return classRezult;
    }

    public void setRezult(double rezult){
        this.classRezult = rezult;
    }

    public double getLowerLimitValue(){
        return classLowerLimitValue;
    }

    public double getUpperLimitValue(){
        return classUpperLimitValue;
    }

    public double getStepValue(){
        return classStepValue;
    }
}

    
    

