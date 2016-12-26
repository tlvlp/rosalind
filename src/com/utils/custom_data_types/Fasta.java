package com.utils.custom_data_types;

/**
 * Custom data type for individual Fasta sequences of a Fasta file
 * @author tlvlp
 */
public class Fasta {
    
    private String header;      //fasta header
    private String sequence;    //fasta sequence
    private String coords;      //eg. coordinates of a given sub sequence
    
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
    
    /** Adds new elements to the Fasta sequence */
    public void sequenceAdd(String newFragment){
        sequence = sequence.concat(newFragment);
    }
    
    public String getHeader() {return header;}
    public String getSequence() {return sequence;}
    public String getCoords() {return coords;}
    public String getUniProtID() {return header.substring(4,10);} //returns the UniProt ID from the header of a UniProt fasta file
    
    public void setHeader(String h) {header = h;}
    public void setSequence(String s) {sequence = s;}
    public void setCoords(String c) {coords = c;}
}
