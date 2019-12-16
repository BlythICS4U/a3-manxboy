/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author chris
 */
public class ReportCardStatsTest {

    /**
     * Test of GetBestStudent method, of class ReportCardStats.
     */
    @Test
    public void testGetBestStudent() {
        ReportCard one = new ReportCard("StudentOne", "1/1/2001", null, 89.3);
        ReportCard two = new ReportCard("StudentTwo", "2/2/2002", null, 76.3);
        ReportCard three = new ReportCard("StudentThree", "3/3/2003", null, 93.2);
        
        assertEquals(ReportCardStats.GetBestStudent(new ReportCard[] {one, two, three}), "StudentThree");
    }

    /**
     * Test of GetBestSubject method, of class ReportCardStats.
     */
    @Test
    public void testGetBestSubject() {
        CourseMark best = new CourseMark("best", 96);
        
        CourseMark[] marks = new CourseMark[] {
            best,
            new CourseMark("two", 78),
            new CourseMark("three", 69),
            new CourseMark("four", 94),
            new CourseMark("five", 88),
            new CourseMark("six", 91),
            new CourseMark("seven", 65),
            new CourseMark("eight", 74),
        };
        
        ReportCard card = new ReportCard("Test Student", "1/1/2001", marks, 93);
        
        assertEquals(ReportCardStats.GetBestSubject(card), "best");
        
    }

    /**
     * Test of SubjectAverage method, of class ReportCardStats.
     */
    @Test
    public void testSubjectAverage() {
        ReportCard one = new ReportCard("StudentOne", "1/1/2001", new CourseMark[] {new CourseMark("test", 50)}, 89.3);
        ReportCard two = new ReportCard("StudentTwo", "2/2/2002", new CourseMark[] {new CourseMark("test", 98)}, 76.3);
        ReportCard three = new ReportCard("StudentThree", "3/3/2003", new CourseMark[] {new CourseMark("test", 69)}, 93.2);
        
        assertEquals(ReportCardStats.SubjectAverage(new ReportCard[] {one, two, three}, "test"), 72.33333333, 0.01);
    }
    
    
}
