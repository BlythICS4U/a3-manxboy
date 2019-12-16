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
public class ReportCardParserType1 extends AbstractReportCardParser {

    //default Constructor
    public ReportCardParserType1(String filePath) {
        super(filePath);
    }
    
    
    /**
     * ---Example File----------------------------------------------------------
     * Name: Tony Stark
     * DOB: 01/19/02
     * 
     * English				85
     * Business Studies                 76
     * Computer Science                 95
     * Calculus                         82
     * Principles of Mathematics	78
     * Chemistry			56
     * Physics				90
     * Biology				63
     * ---[EOF]-----------------------------------------------------------------
     */
    

    /**
     * Parse the configured report card file
     * 
     * @return ReportCard object containing the data from the configured report card file
     */
    @Override
    public ReportCard parse(String[] lines) {
                
        //get the name by splitting the first line by ':' and trimming the second element
        String name = lines[0].split(":")[1].trim();
        
        //get the date of birth by splitting the second line by ':' and trimming the second element
        String dateOfBirth = lines[1].split(":")[1].trim();
        
        //init the marks array
        CourseMark[] marks = new CourseMark[lines.length - 3];
        
        //sum of all the marks
        int markSum = 0;
        
        //loop through all the expected marks
        for (int i = 0; i < marks.length; i ++) {
            
            //get the next line and split it by `([\t]+)`, which matches one or more tab symbols
            String[] delimeteredLine = lines[i + 3].split("([\\t]+)");
            
            //grab the course name from the first element of the tab seperated line
            String courseName = delimeteredLine[0];
            
            //parse the second element of the tab seperated line as an integer 
            int courseMark = Integer.parseInt(delimeteredLine[1]);
            
            //add the mark into the mark array
            marks[i] = new CourseMark(courseName, courseMark);
            
            //add the mark to the courseTotals
            markSum += courseMark;
        }
        
        //return the report card, with the name, date of birth, marks, and the average of marks
        return new ReportCard(name, dateOfBirth, marks, (double)markSum / marks.length);
    }
    
}
