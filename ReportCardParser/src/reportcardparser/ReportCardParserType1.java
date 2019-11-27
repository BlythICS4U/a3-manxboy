/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class to handle parsing of a Type 1 report card
 * 
 * @author chris
 */
public class ReportCardParserType1 implements IReportCardParser {
    
    private String filePath; // Path to the report card file
    
    /**
     * Constructor
     * 
     * @param filePath Path to the report card file
     */
    public ReportCardParserType1(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * Parse the configured report card file
     * 
     * @return ReportCard object containing the data from the configured report card file
     */
    @Override
    public ReportCard parse() {
        // REPLACE ME WITH A REAL IMPLEMENTATION!
        return null;
    }
    
}
