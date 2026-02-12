/*
Name: Lawrence Oro - Carlos Lopez
Date: 12-Feb-26
Program: Course Grades Analyzer - reads CSV grade totals and analyzes (A) percentages.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Course{
    private String courseName;
    private ArrayList<Integer> courseGrades;

    public static final int INDEX_A = 0;
    public static final int INDEX_B = 1;
    public static final int INDEX_C = 2;
    public static final int INDEX_D = 3;
    public static final int INDEX_F = 4;

    // courseGrades stores totals in this exact order:
    // index 0 = A, 1 = B, 2 = C, 3 = D, 4 = F
    public Course(String courseName, ArrayList<Integer> courseGrades){
        this.courseName = courseName;
        this.courseGrades = courseGrades;
    }
    //default contsructor 
    public Course(){
        this.courseName = "Unknown Course";
        this.courseGrades = new ArrayList<Integer>();
    }
}