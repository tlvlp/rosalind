package data;

/**
 * @author tlvlp
 */
public class Fasta {
/* intended for creating objects from Fasta input  */
    
    private String header;      //fasta header
    private String sequence;    //fasta sequence
    private String coords;      //eg. coordinates of a given sub sequence
    
    /* constructors */
    public Fasta(){
        header = "";
        sequence = "";
        coords = "";
    }
    public Fasta(String h){
        header = h;
        sequence = "";
        coords = "";
    }
    
    /* misc methods */    
    public void sequenceAdd(String newFragment){
        sequence = sequence.concat(newFragment);
    }
    
    /* the heretic geters */
    public String getHeader() {return header;}
    public String getSequence() {return sequence;}
    public String getCoords() {return coords;}
    public String getUniProtID() {return header.substring(4,10);} //returns the UniProt ID from the header of a UniProt fasta file
    
    /* the heretic seters */
    public void setHeader(String h) {header = h;}
    public void setSequence(String s) {sequence = s;}
    public void setCoords(String c) {coords = c;}
}
