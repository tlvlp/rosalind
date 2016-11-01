package data;

import java.util.ArrayList;

/**
 *
 * @author tlvlp
 */
public class Fasta {
/* intended for creating objects from Fasta input  */
    
    private String header;      //fasta header
    private String sequence;    //fasta sequence
    private String coords;      //eg. coordinates of a given sub sequence
    private String ID;          //eg. the UniProt database ID that is a substring of the header
    private String origPos;     //the fasta entry's original position in a list if the output order needs to match the input's
    private ArrayList<String> collector = new ArrayList<>();    //for collecting shiny things   
    
    /* constructors */
    public Fasta(){
        header = "";
        sequence = "";
        coords = "";
        ID = "";
        origPos = "";
        //collector is already initialized
    }
    
    /* misc methods */    
    public void sequenceAdd(String newFragment){
        sequence = sequence.concat(newFragment);
    }
    
    /* geters */
    public String getHeader() {return header;}
    public String getSequence() {return sequence;}
    public String getCoords() {return coords;}
    public String getID() {return ID;}
    public String getOrigPos() {return origPos;}
    public ArrayList<String> getCollector() {return collector;}
    
    /* seters */
    public void setHeader(String h) {header = h;}
    public void setSequence(String s) {sequence = s;}
    public void setCoords(String c) {coords = c;}
    public void setID(String i) {ID = i;}
    public void setOrigPos(String o) {origPos = o;}
    public void setCollector(ArrayList<String> r) {collector = r;}
}
