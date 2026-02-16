/*
Name : Lawrence Oro - Carlos Lopez
Date: 12-Feb-26
Program: Course Grades Analyzer - reads CSV grade totals and analyzes (A) percentages.
*/ 
import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) {
      ArrayList<Course> courses = new ArrayList<>();
      String fileName = "courseAndGradesData.csv";
   
        // Read the CSV file and populate the courses list
      try (Scanner scanner = new Scanner(new File(fileName))) {
            //would skip header if exists in file 
         if(scanner.hasNextLine()){
            scanner.nextLine();
         }
            
         while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split(",");
         
            String courseName = parts[0].trim();
            ArrayList<Integer> grades = new ArrayList<>();
            for(int i = 1; i < parts.length; i++){
               grades.add(Integer.parseInt(parts[i].trim()));
            }
                //check for duplicate course names before adding to the list
            boolean found = false; 
            for(Course existingCourse : courses) {
               if(existingCourse.getCourseName().equalsIgnoreCase(courseName)){
                            // merging the counts by index 
                  for(int i = 0; i < grades.size(); i++){
                     int updatedGrade = existingCourse.getCourseGrades().get(i) + grades.get(i);
                     existingCourse.getCourseGrades().set(i, updatedGrade);
                  }
                  found = true;
                  break;
               }
            }
            if(!found){
               courses.add(new Course(courseName, grades));
            }
         }
      }catch (FileNotFoundException e) {
         System.out.println("File not found: " + fileName);
      }
            // Display the results
      System.out.printf("%-10s %5s %5s %5s %5s %5s %7s %7s%n", "Course", "A", "B", "C", "D", "F", "Total", "% A");
      for(Course course : courses){
         System.out.println(course);
      }
    // find Highest A percentage
      if(!courses.isEmpty()){
         Course highestAPercentageCourse = courses.get(0);
         for(Course course : courses){
            if(course.getAPercentage() > highestAPercentageCourse.getAPercentage()){
               highestAPercentageCourse = course;
            }
         }
         System.out.printf("\nCourse with the highest A percentage: %s (%.2f%%)%n", highestAPercentageCourse.getCourseName(), highestAPercentageCourse.getAPercentage());
      } 
    //linear search for a specific course by name
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter a course name to search for: ");
      String searchCourseName = input.nextLine().trim();
   
      boolean courseFound = false;
      for(Course course : courses){
         if(course.getCourseName().equalsIgnoreCase(searchCourseName)){
            System.out.println("Result: " + course);
            courseFound = true;
            break;
         }
      }
      if(!courseFound){
         System.out.println("Course not found: " + searchCourseName);
      }
      input.close();
    
   }
}
