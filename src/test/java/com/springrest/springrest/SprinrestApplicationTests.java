package com.springrest.springrest;

import com.springrest.springrest.controller.MyController;
import com.springrest.springrest.entities.Course;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class SprinrestApplicationTests {
    @Autowired
    private MyController myController;


    @Test
    void getCources() {
        List<Course> courses=myController.getCourese();
        Course c1=courses.get(0);
        Assert.assertEquals(c1.getId(),116);
    }

    @Test
    void postCourse(){
        Course c1=new Course();
        c1.setId(124);
        c1.setTitle("Core Java");
        c1.setDescription("Very Good Course");
        Course course= myController.addCourse(c1) ;
            Assert.assertEquals(course.getTitle(),"Core Java");

    }
    @Test
   void putCourse(){
        Course course= myController.getCourseByCourseId(124l);
       course.setDescription("Good");
      Course course2= myController.updateCourse(course);
      Assert.assertEquals(course2.getDescription(),"Good");
    }
    @Test
    void deleteCourse(){
     ResponseEntity<String>c2= myController.deleteCourse("116");
    String s1= c2.getBody();Assert.assertEquals(s1,"DeleteSucessful");

    }

}
