package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController("api/v1/course")
public class MyController {
	
	@Autowired
	private CourseService courseSerivice;
	
	//got the courses
	@GetMapping("/courses")
	public  List<Course>getCourese(){
		return this.courseSerivice.getCourses();
		
		
	}
	//single courses
//	@GetMapping("/courses/{courseId}")
//	public Course getCourseByCourseId(@PathVariable String courseId ) {
//		return this.courseSerivice.getCourseByCourseId(Long.parseLong(courseId));
//
//	}

	@GetMapping("courses/{courseId}")
	public Course getCourseByCourseId(@PathVariable Long courseId) {
		return this.courseSerivice.getCourse(courseId);
	}
	//course add
	@PostMapping("/courses")
	public  Course addCourse(@RequestBody Course course) {
		return this.courseSerivice.addCourse(course);
		
	}
	//update
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseSerivice.updateCourse(course);
		
	}
	
	//DELETE
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<String>deleteCourse(@PathVariable String courseId){
		try {
			this.courseSerivice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>("DeleteSucessful",HttpStatus.OK);
			
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
 