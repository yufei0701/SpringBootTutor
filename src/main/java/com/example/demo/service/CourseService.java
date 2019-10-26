package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Integer> findAllNums(){

        return courseRepository.findAllNums();
    }

    public List<Integer> addNum(int num){

        return courseRepository.addNum(num);
    }

    public List<Integer> removeNum(int num){

        return courseRepository.removeNum(num);
    }

    public int[] searchTarget(int num){

        return courseRepository.searchTarget(num);
    }

    public List<Course> searchByCourseName(String input){

        return courseRepository.findCourseByName(input);
    }

}
