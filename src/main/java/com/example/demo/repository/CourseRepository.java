package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();

    // constructor
    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();
        Course two= Course.builder()
                .className("Java II")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
        nums.add(10);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(50);
        nums.add(77);
        nums.add(80);
    }


    public List<Integer> findAllNums(){
        return  nums;
    }

    public List<Integer> addNum(int num){
        nums.add(num);
        return  nums;
    }

    public List<Integer> removeNum(int num){
        nums.remove(num);
        return  nums;
    }

    public int[] searchTarget(int target){
        int[] res = new int[2];

        List<Integer> sortedNum = new ArrayList<>(nums);
        Collections.sort(sortedNum);
        int l = 0;
        int r = sortedNum.size() - 1;

        while (l < r) {
            if (sortedNum.get(l) + sortedNum.get(r) == target) {
                res[0] = sortedNum.get(l);
                res[1] = sortedNum.get(r);
                return res;
            }
            if (sortedNum.get(l) + sortedNum.get(r) > target) {
                r--;
            } else{
                l++;
            }
        }
        return new int[0];
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        if(courseName.equals("Java_I")) {
            return courses;
        }

        return new ArrayList<Course>();
    }
}
