/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manxboy
 */
public abstract class AbstractReportCardParser implements IReportCardParser {
    
    
    private String filePath; // Path to the report card file

    /**
     * Constructor
     * 
     * @param filePath Path to the report card file
     */
    public AbstractReportCardParser(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * Parse the configured report card file, using the implementers parse method
     * 
     * @return ReportCard object containing the data from the configured report card file
     */
    public ReportCard parse() {
        String contents;
        
        try {
            //read file into a string
            contents = Files.readString(new File(filePath).toPath());
        } catch (IOException ex) {
                //log exception and return null
                Logger.getLogger(ReportCardParserType1.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }
        
        //split contents into an array of lines, split using the system's newline character
        String[] lines = contents.split(System.lineSeparator());
        
        //return the implementers parse method with the separated lines
        return this.parse(lines);
    }
    
    public abstract ReportCard parse(String[] lines);
}
