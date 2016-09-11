/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.lang.reflect.*;
import java.util.ArrayList;

/**
 *
 * @author tlvlp
 */
public class ModuleExecute {
    
    public static ArrayList<String> launch(String module, ArrayList<String> inList) throws Exception {
        /*
        this method launches a class.mehtod from a string input using reflection
        */
        
        ArrayList<String> outList = new ArrayList<>();
        
        String aClass = "problems." + module;   //the package name is hardcoded 
        String aMethod = "solve";               //this is the method for all the problems classes
        
        Class[] parameterTypes = new Class[] {java.util.ArrayList.class};
        Object[] arguments = new Object[] {inList};
        
        Class thisClass = Class.forName(aClass);
        // get an instance
        Object iClass = thisClass.newInstance();
        // get the method
        Method thisMethod = thisClass.getDeclaredMethod(aMethod, parameterTypes);
        // call the method
        return (ArrayList<String>) thisMethod.invoke(iClass, arguments);
        
        //return outList;
        
    }
}  
