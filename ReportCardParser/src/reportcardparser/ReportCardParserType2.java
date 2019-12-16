/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class to handle parsing of a Type 2 report card
 * 
 * @author chris
 */
public class ReportCardParserType2 extends AbstractReportCardParser {

    //default constructor
    public ReportCardParserType2(String filePath) {
        super(filePath);
    }
    
    /**
     * ---Example File----------------------------------------------------------
     * Natasha Romanoff
     * 02/25/02
     * 
     * English,96,Business Studies,97,Computer Science,80,Calculus,74,Principles of Mathematics,79,Chemistry,85,Physics,72,Biology,78
     * ---[EOF]-----------------------------------------------------------------
     */
    
    
    /**
     * Parse the configured report card file
     * 
     * @return ReportCard object containing the data from the configured report card file
     */
    @Override
    public ReportCard parse(String[] lines) {
        
        //get the name form the first line
        String name = lines[0];
        
        //get the dob from the second line
        String dateOfBirth = lines[1];
        
        //split the third line at commas
        String[] splitAtCommas = lines[3].split(",");
        
        //create a marks array based of the csv list length divided by two (as the list contains two elements per mark)
        CourseMark[] marks = new CourseMark[splitAtCommas.length/2];
        
        //sum of all the marks
        int markSum = 0;
        
        //loop through the expected number of marks

        for (int i = 0; i < marks.length; i++) {
            
            //get the mark from the index (times two) + 1, which gets the next element from our current position
            int mark = Integer.parseInt(splitAtCommas[2 * i + 1]);
            
            //create a new mark with the name, (which is at the index (times two)) and the mark
            marks[i] = new CourseMark(splitAtCommas[2 * i], mark);
            
            //add the mark to the markSum
            markSum += mark;
        }
        
        //return a new report card, with the name, dateOfBirth, marks, and the average
        return new ReportCard(name, dateOfBirth, marks, (double) markSum / marks.length);
    }

}
