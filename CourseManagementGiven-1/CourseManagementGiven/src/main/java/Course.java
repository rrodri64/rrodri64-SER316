package main.java;

/**
 * class for managing course statistics
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;



public class Course {

    // maps student names (asurite) to their points
    public HashMap<String, Integer> points = new HashMap<>(); 
    private String courseName; // course name


    public Course(String name) {
        this.setName(name);
    }

    public String getName() {
        return courseName;
    }

    public void setName(String name) {
        this.courseName = name;
    }


    public void printCourseStats() {
        //SER316 TASK 4 SPOTBUGS FIX

        System.out.print("Average Grades without max and without min: ");
        System.out.println(this.calculateAverageWithoutMinWithoutMax());
    }


    // REACH at least 95% Code coverage (assign 3)
    // method to draw node graph for
    // should throw null pointer for empty points member
    // negative points should be ignored
    // max value and min value should be removed - (if doubles then only the first occurrence)
    // if just one or two values no values will be omitted
    public double calculateAverageWithoutMinWithoutMax() throws NullPointerException {
        ArrayList<Integer> collection = new ArrayList<Integer>(points.values());

        int counter = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (collection.size() == 1) {
            return collection.get(0);


        } else if (collection.size() == 2) {
            return (double)(collection.get(0) + collection.get(1)) / 2;
        

        //SER316-start
        //This function was not averaging the grades correctly, so I fixed it to where
        //the function will find the minimum, maximum, and determine the average without
        //negative points.
        } else {
            int allPoints = 0;
            for(int i = 0; i < collection.size(); i++) {
                if (collection.get(i) >= 0) {
                    if (collection.get(i) < min) {
                        min = collection.get(i);
                    }
                    if (collection.get(i) > max) {
                        max = collection.get(i);
                        //SER316 TASK 4 SPOTBUGS FIX
                    }
                    counter++;
                    allPoints = allPoints + collection.get(i);
                }
            }

            int totalPoints = allPoints - max - min;
            //SER316 TASK 4 SPOTBUGS FIX
            return totalPoints / (double)(counter - 2); 
            //SER316-end
            //SER316 TASK 4 SPOTBUGS FIX

        }
    }

    // REACH at least 95% Code coverage  (assign 3)
    // if student with the name (asurite member) is not yet included,
    //student needs to be added to student list 
    // sets points for a student 
    public void set_points(String name, int points) {
        //SER316-start
        //For this method, I added an "if-statement" to check if the student is included
        if (!this.points.containsKey(name)) {
            System.out.println(points);
            this.points.put(name, points);
        }
        //SER316-end
        //SER316 TASK 4 SPOTBUGS FIX
    }


    // REACH at least 95% Code coverage  (assign 3)
    // Students should only be added when they are not yet in the course,
    //(names (asurite member) needs to be unique)
    ArrayList<Student> students  = new ArrayList<Student>();
    
    public boolean addStudent(Student s) {
        //SER316-start
        //In this method, I added a check to determine if the student already exists
        if (students.contains(s)) {
            System.out.println("Student already exists!");
            return false;
        

        } else {
            students.add(s);
            points.put(s.getAsurite(), -1);
            return true;
        }
        //SER316-end
    }


    public HashMap<String, Integer> getPoints() {
        return points;
    }


    public int getStudent_Points(String student) {
        return points.get(student);
    }

    public int getStudent_Points(Student student) {
        return points.get(student.getAsurite());
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public HashMap<String, Integer> gradeFrequency() throws NullPointerException {
        return null;

        //SER316 TASK 4 SPOTBUGS FIX
    }



}