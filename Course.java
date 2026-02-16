/*
Name: Lawrence Oro - Carlos Lopez
Date: 12-Feb-26
Program: Course Grades Analyzer - reads CSV grade totals and analyzes (A) percentages.
*/

import java.util.ArrayList;

public class Course{
   private String courseName;
   private ArrayList<Integer> courseGrades;

//parameterized constructor
   public Course(String courseName, ArrayList<Integer> courseGrades){
      this.courseName = courseName;
      this.courseGrades = new ArrayList<>(courseGrades);
   }
   //default contsructor 
   public Course(){
      this.courseName = "Unknown Course";
      this.courseGrades = new ArrayList<Integer>();
   }
   //getters and setters for course name and grades
   public String getCourseName(){
      return courseName;
   }

   public void setCourseName(String courseName){
      this.courseName = courseName;
   }
   public ArrayList<Integer> getCourseGrades(){
      return courseGrades;
   }

   public void setCourseGrades(ArrayList<Integer> courseGrades){
      this.courseGrades = new ArrayList<>(courseGrades);
   }
//returning total number of grades 
   public int getTotalGrades(){
      int total = 0;
      for(int grade : courseGrades){
         total += grade;
      }
      return total;
   }
   //getting the percentage of A grades (90 and above)
   public double getAPercentage(){
      int total = getTotalGrades();
      if(total == 0){
         return 0.0;
      }
      //Index 0 will always be 'A' grades
      return(double) courseGrades.get(0) / total * 100;
   }
   //toString to display percentag of A grades for the course
   @Override
   public String toString(){
      //insuring we wont crash if courseGrades is not populated correctly by checking size before accessing
      while(courseGrades.size() < 5){
         courseGrades.add(0); // adding 0 for missing grade categories
      }
      return String.format("%-10s %5d %5d %5d %5d %5d %7d %7.2f%%", 
         courseName, 
         courseGrades.get(0), 
         courseGrades.get(1),
         courseGrades.get(2), 
         courseGrades.get(3), 
         courseGrades.get(4), 
         getTotalGrades(), 
         getAPercentage());
      
   }
}