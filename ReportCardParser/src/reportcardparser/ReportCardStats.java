/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class for analyzing collections of report cards
 * 
 * @author chris
 */
public class ReportCardStats {
    
    /**
     * Find the student with the highest average
     * 
     * @param reportCards The array of report cards to search
     * @return The name of the student with the highest average
     */
    public static String GetBestStudent(ReportCard[] reportCards) {
        
        //store the current best reportCard
        ReportCard bestAverage = reportCards[0];
        
        //ittorate through all of the reportCards
        for (ReportCard card : reportCards) {
            //is the current card bigger than current best
            if (card.getAverage() > bestAverage.getAverage()) {
                bestAverage = card;
            }
        }
        
        //return the name of the student from the best report card
        return bestAverage.getName();
    }
    
    /**
     * Find the best subject for the given report card
     * 
     * @param reportCard The report card to evaluate
     * @return The name of the subject with the highest mark
     */
    public static String GetBestSubject(ReportCard reportCard) {
        
        //store the current best mark (subject)
        CourseMark bestMark = reportCard.getMarks()[0];
        
        //ittorate through all of the CourseMarks
        for (CourseMark mark : reportCard.getMarks()) {
            //is the current mark better than the last?
            if (mark.getMark() > bestMark.getMark()) {
                bestMark = mark;
            }
        }
        
        //return the name of the best subject
        return bestMark.getName();
    }
    
    /**
     * Calculate the average mark for a given subject
     * 
     * @param reportCards The array of report cards to search
     * @param subject The subject for average calculation
     * @return The average mark of the passed-in subject
     */
    public static double SubjectAverage(ReportCard[] reportCards, String subject) {
        
        //sum of all the marks of the subject
        double marksSum = 0;
        
        //ittorate through all of the reportCards
        for (ReportCard card : reportCards) {
            
            //add the subject's mark to the marksum
            marksSum += getSubjectMark(card, subject).getMark();
        }
        
        //return the average
        return marksSum / reportCards.length;
    }
    
    /**
     * Get a CourseMark by name from a report card
     * @param card the card which has the marks
     * @param subject the name of the subject to get
     * @return the CourseMark of the subject
     */
    public static CourseMark getSubjectMark(ReportCard card, String subject) {
        for (CourseMark mark : card.getMarks()) {
            if (mark.getName().equals(subject)) return mark;
        }
        
        //returns null if no mark can be found
        return null;
    }
}
