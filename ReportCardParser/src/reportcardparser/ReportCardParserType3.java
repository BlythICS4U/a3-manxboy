/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class to handle parsing of a Type 3 report card
 * 
 * @author chris
 */
public class ReportCardParserType3 extends AbstractReportCardParser {

    //default constructor
    public ReportCardParserType3(String filePath) {
        super(filePath);
    }
    
    
    /**
     * ---Example File----------------------------------------------------------
     * Name: Carol Danvers
     * Date of Birth: 04/28/02
     * 
     * English->Business Studies      ->Computer Science      ->Calculus      ->Principles of Mathematics     ->Chemistry     ->Physics->Biology
     * 96     ->97    ->      ->      ->80    ->      ->      ->74    ->      ->79    ->      ->      ->      ->85    ->      ->72     ->78
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
        
        //get the course names from the 4th line, splitting by tabs
        String[] courseNames = lines[3].split("([\\t]+)");
        
        //get the marks in string format from the 5th line, splitting by tabs
        String[] courseMarksString = lines[4].split("([\\t]+)");
        
        //init the marks array using the length of the courseMarkString
        CourseMark[] marks = new CourseMark[courseNames.length];
        
        int marksSum = 0;
        
        //ittorate over the courseMoarksString array, converting each mark into an int
        for (int i = 0; i < marks.length; i++) {
            
            int mark = Integer.parseInt(courseMarksString[i]);
            
            marks[i] = new CourseMark(courseNames[i], mark);
            
            //
            marksSum += mark;
        }
        
        //return new reportcard with the name, dateofbirth, marks, and the average of the marks
        return new ReportCard(name, dateOfBirth, marks, (double)marksSum/marks.length);
    }

}
