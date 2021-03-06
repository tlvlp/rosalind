package utils.execution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * @author tlvlp
 */
public class ProblemExecution {
    private static final Logger log = LogManager.getLogger(ProblemExecution.class);
    
    /**
     * Executes a problem module using reflection
     * @throws Exception
     * @requires problemID to be set directly in this class:
     *           problemID = class name in the problems package
     *           = ID in Rosalind url
     *           = ID in input txt file name
     * @requires An ArrayList (inList) with the parsed contents of the input File
     * @return   The ArrayList with the results generated by the problem module
     * @param problemID
     * @param inList
     */
    public static ArrayList<String> run(String problemID, ArrayList<String> inList) throws Exception {
        try {
            String aClass = "problems." + problemID;
            String aMethod = "solve";                        //the method name for all the problems classes are the same
            Class[] parameterTypes = new Class[] {ArrayList.class};
            Object[] arguments = new Object[] {inList};
            Class thisClass = Class.forName(aClass);
            Object iClass = thisClass.newInstance();                                    //get the instance
            Method thisMethod = thisClass.getDeclaredMethod(aMethod, parameterTypes);   //get the method
            return (ArrayList<String>) thisMethod.invoke(iClass, arguments);            //call the method
        } catch (Exception e) {                                                      //terminating run for any exception
            log.error("Failed to execute the problem module. Terminating run!", e);
            System.exit(0);
        }
        return inList;                 //this return statement is never used - still looking for a more elegant solution
    }
}  
