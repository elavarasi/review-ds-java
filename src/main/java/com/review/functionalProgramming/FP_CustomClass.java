package com.review.functionalProgramming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Course {

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }


    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}


public class FP_CustomClass {


    public static void main(String args[]) {
        List<Course> courses = com.sun.tools.javac.util.List.of(
                new Course("datastructure", "ds", 100, 123),
                new Course("datastructure1", "ds1", 100, 123),
                new Course("datastructure2", "ds2", 101, 122),
                new Course("datastructure3", "ds3", 102, 125)
        );

        System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 104));

        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
        courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList());

    }

}
