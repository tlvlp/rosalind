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
    private String coords;      //eg. coordinates of 
    private String ID;          //eg. the UniProt database ID that is a substring of of the header
    private String origPos;     //original position in a list if the output order matters
    private ArrayList<String> collector = new ArrayList<>();    
    
    public Fasta(){
        header = "";
        sequence = "";
        coords = "";
        ID = "";
        origPos = "";
        //readsCollected is already initialized
    }
    
    public Fasta(String h, String s, String c, String i, String o, ArrayList<String> r){
        header = h;
        sequence = s;
        coords = c;
        ID = i;
        origPos = o;
        collector = r;
    }
    
    public Fasta(String h, String s, String c, String i, String o){
        header = h;
        sequence = s;
        coords = c;
        ID = i;
        origPos = o;
    }
    
    public Fasta(String h, String s){
        header = h;
        sequence = s;
    }
    
    public String getHeader() {
        return header;
    }
    public String getSequence() {
        return sequence;
    }
    public String getCoords() {
        return coords;
    }
    public String getID() {
        return ID;
    }
    public String getOrigPos() {
        return origPos;
    }
    public ArrayList<String> getCollector() {
        return collector;
    }
    
    public void setHeader(String h) {
        header = h;
    }
    public void setSequence(String s) {
        sequence = s;
    }
    public void setCoords(String c) {
        coords = c;
    }
    public void setID(String i) {
        ID = i;
    }
    public void setOrigPos(String o) {
        origPos = o;
    }
    public void setCollector(ArrayList<String> r) {
        collector = r;
    }
    public void clear(){
        header = "";
        sequence = "";
        coords = "";
        ID = "";
        origPos = "";
        collector.clear();
    }
}
