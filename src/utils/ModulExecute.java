/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import problems.*;

/**
 *
 * @author tlvlp
 */
public class ModulExecute {
    public static ArrayList<String> launch(String module, ArrayList<String> inList) {
        ArrayList<String> outList = new ArrayList<>();
        switch (module) {
            case "dna":
                outList = dna.solve(inList);
                break;
            case "fib":
                outList = fib.solve(inList);
                break;
            case "fibd":
                outList = fibd.solve(inList);
                break;
            case "gc":
                outList = gc.solve(inList);
                break;
            case "hamm":
                outList = hamm.solve(inList);
                break;
            case "mrna":
                outList = mrna.solve(inList);
                break;
            case "prot":
                outList = prot.solve(inList);
                break;
            case "prtm":
                outList = prtm.solve(inList);
                break;               
            case "revc":
                outList = revc.solve(inList);
                break;
            case "rna":
                outList = rna.solve(inList);
                break;
            case "subs":
                outList = subs.solve(inList);
                break;
            default:
                System.out.println("Error: Module name is incorrect or undefined");
                break;
        }
           
        return outList;
    }
}
