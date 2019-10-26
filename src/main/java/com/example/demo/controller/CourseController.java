package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// single function interface
@RestController
@RequestMapping
public class CourseController {

    @Autowired // IOC 控制反转
    CourseService calcTwoSum; // Singleton
    //依赖注入 Dependency Injection

    @GetMapping(path = "/", produces = "application/json") //如果你用get方法 call我这个地址
    public HttpEntity findAllCourses(){
        List<Integer> allNums = calcTwoSum.findAllNums(); //我就帮你用这个方法来处理这个请求

        return new ResponseEntity<>(allNums,HttpStatus.OK); // 我返回结果给你
    }

    @GetMapping(path = "/add/{addNum}", produces = "application/json") //如果你用get方法 call我这个地址
    public HttpEntity<Course> addNum(@PathVariable("addNum") int addNum) {

        List<Integer> allNums = calcTwoSum.addNum(addNum);

        return new ResponseEntity(allNums, HttpStatus.OK);
    }

    @GetMapping(path = "/remove/{idx}", produces = "application/json") //如果你用get方法 call我这个地址
    public HttpEntity<Course> removeNum(@PathVariable("idx") int removeIdx) {

        List<Integer> allNums = calcTwoSum.removeNum(removeIdx);

        return new ResponseEntity(allNums, HttpStatus.OK);
    }

    @GetMapping(path = "/look-up/{target}", produces = "application/json")
    public HttpEntity<Course> searchTarget(@PathVariable("target") int target) {

        int[] foundNums= calcTwoSum.searchTarget(target);

        return new ResponseEntity(foundNums, HttpStatus.OK);
    }
}

// 增加一个课程/删除一个课程/更新一个课程信息
