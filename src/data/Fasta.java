package data;

/**
 * Class intended to create objects from Fasta sequences
 * @author tlvlp
 */
public class Fasta {
  
    private String header;      //fasta header
    private String sequence;    //fasta sequence
    private String coords;      //eg. coordinates of a given sub sequence
    private String altID;       //alternative ID. eg. when the one in the header is no longer valid but we need to keep it.
    
    /* constructors */
    public Fasta(){
        header = "";
        sequence = "";
        coords = "";
        altID = "";
    }
    public Fasta(String h){
        header = h;
        sequence = "";
        coords = "";
        altID = "";
    }
    
    /* misc methods */    
    public void sequenceAdd(String newFragment){
        sequence = sequence.concat(newFragment);
    }
    
    /* the heretic geters */
    public String getHeader() {return header;}
    public String getSequence() {return sequence;}
    public String getCoords() {return coords;}
    public String getAltID() {return altID;}
    public String getUniProtID() {return header.substring(4,10);} //returns the UniProt ID from the header of a UniProt fasta file
    
    /* the heretic seters */
    public void setHeader(String h) {header = h;}
    public void setSequence(String s) {sequence = s;}
    public void setCoords(String c) {coords = c;}
    public void setAltID(String a) {altID = a;}
}