package test.java;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import main.java.Course;

import main.java.Student;

import main.java.MAJOR;


public class CourseTest {
    Course oneStudent;
    Course twoStudents;
    Course moreStudents;
    Course c;
    
    Student studentList;

    @Before
    public void setUp() throws Exception {
    }

    //Test #1: calculateAverageWithoutMinWithoutMax()
    @Test
    public void testAverageWithoutMinWithoutMax() {
        // One Student [#49-55]
        oneStudent = new Course("SER316");
        oneStudent.set_points("Jessica", 40);
        double ans = oneStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 40.0);
    }
    
    @Test
    public void testTwoStudents() {
    	//Two Students [#49-58]
    	moreStudents = new Course("SER322");
    	moreStudents.set_points("Candice", 23);
    	moreStudents.set_points("Jeff", 21);
    	double ans = moreStudents.calculateAverageWithoutMinWithoutMax();
    	assertTrue(ans == 22.0);
    }
    
    @Test
    public void testMultipleStudents() {
    	//Multiple and duplicate Students [#49-76] and [#49-67, 80, 81]
    	moreStudents = new Course("SER334");
    	moreStudents.set_points("Amanda", 40);
    	moreStudents.set_points("Chelsea", 35);
    	moreStudents.set_points("Chelsea", 35);
    	moreStudents.set_points("Bob", 30);
    	moreStudents.set_points("Carl", 35);
    	double ans = moreStudents.calculateAverageWithoutMinWithoutMax();
    	assertTrue(ans == 35.0);
    	
    }
    
    
    @Test
    public void testMultipleStudentsNegative() {
    	//Multiple Students but negative scores [#49-76] and [#49-67, 80, 81]
    	moreStudents = new Course("SER334");
    	moreStudents.set_points("Amanda", -40);
    	moreStudents.set_points("Bob", -30);
    	moreStudents.set_points("Carl", -35);
    	double ans = moreStudents.calculateAverageWithoutMinWithoutMax();
    	assertFalse(ans == 35.0);
    	
    }
    
    //Test #2: public void set_points(String name, int points)
    @Test
    public void testMultipleStudents2() {
    	moreStudents = new Course("SER316");
    	moreStudents.set_points("Amanda", 40);
    	moreStudents.set_points("Bob", 30);
    	moreStudents.set_points("Bob", 30);
    	moreStudents.set_points("Carl", 35);
    	double ans = moreStudents.calculateAverageWithoutMinWithoutMax();
    	assertTrue(ans == 35.0);
    }
    
    //Test #3: public boolean addStudent(Student s)
    @Test
    public void testAddingStudent() {
    	studentList = new Student ("rrodri64", MAJOR.SER);
    	studentList = new Student ("bob31", MAJOR.SER);
    	studentList = new Student ("sarah25", MAJOR.SER);
    	studentList = new Student ("rrodri64", MAJOR.SER);
    	c = new Course("SER316");
    	c.addStudent(studentList);
    	boolean ans = c.addStudent(studentList);
    	assertTrue(ans == false);
    }

}
